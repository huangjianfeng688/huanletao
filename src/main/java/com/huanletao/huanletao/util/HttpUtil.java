package com.huanletao.huanletao.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.net.ssl.*;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.NameValuePair;
import org.apache.http.StatusLine;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.TrustSelfSignedStrategy;
import org.apache.http.conn.ssl.X509HostnameVerifier;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpUtil {

	public static final Logger logger = LoggerFactory.getLogger(HttpUtil.class);
	
	private static final String prefix = "classpath:";
	private static final String httpPrefix = "http:";
	
	private static final String EMPTY_STR = "";
	private static final String UTF_8 = "UTF-8";
	
	// HTTP(S) 读数据超时时间，单位毫秒
	private static final int readTimeoutMs = 8 * 1000;
	// HTTP(S) 连接超时时间，单位毫秒
	private static final int connectTimeoutMs = 6 * 1000;

	/**
	 * get请求
	 *
	 * @return
	 */
	public static String doGet(String url) {
		try {
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 发送get请求
			HttpGet request = new HttpGet(url);
			
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(readTimeoutMs)
					.setConnectTimeout(connectTimeoutMs).build();
			request.setConfig(requestConfig);
			
			HttpResponse response = httpclient.execute(request);
			if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
				String strResult = EntityUtils.toString(response.getEntity());
				return strResult;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return EMPTY_STR;
	}

	/**
	 * post请求(用于key-value格式的参数)
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, Map<String, String> params) {
		BufferedReader in = null;
		try {
			// 定义HttpClient
			CloseableHttpClient httpclient = HttpClients.createDefault();
			// 实例化HTTP方法
			HttpPost request = new HttpPost();
			request.setURI(new URI(url));
			
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(readTimeoutMs)
					.setConnectTimeout(connectTimeoutMs).build();
			request.setConfig(requestConfig);
			
			// 设置参数
			List<NameValuePair> nvps = new ArrayList<NameValuePair>();
			for (Iterator<String> iter = params.keySet().iterator(); iter.hasNext();) {
				String name = (String) iter.next();
				String value = String.valueOf(params.get(name));
				nvps.add(new BasicNameValuePair(name, value));
			}
			request.setEntity(new UrlEncodedFormEntity(nvps, UTF_8));
			HttpResponse response = httpclient.execute(request);
			int code = response.getStatusLine().getStatusCode();
			if (code == 200) { // 请求成功
				in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(), UTF_8));
				StringBuffer sb = new StringBuffer();
				String line = "";
				String NL = System.getProperty("line.separator");
				while ((line = in.readLine()) != null) {
					sb.append(line + NL);
				}
				in.close();
				return sb.toString();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return EMPTY_STR;
	}

	/**
	 * post请求（用于请求json格式的参数）
	 *
	 * @param url
	 * @param params
	 * @return
	 */
	public static String doPost(String url, String params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpPost httpPost = new HttpPost(url);
		
		RequestConfig requestConfig = RequestConfig.custom()
				.setSocketTimeout(readTimeoutMs)
				.setConnectTimeout(connectTimeoutMs).build();
		HttpClient.trustAllHosts();

		httpPost.setConfig(requestConfig);
		httpPost.setHeader("Accept", "application/json");
		httpPost.setHeader("Content-Type", "application/json");
		httpPost.setEntity(new StringEntity(params, UTF_8));
		
		CloseableHttpResponse response = null;
		try {
			response = httpclient.execute(httpPost);
			StatusLine status = response.getStatusLine();
			int state = status.getStatusCode();
			if (state == HttpStatus.SC_OK) {
				HttpEntity responseEntity = response.getEntity();
				String jsonString = EntityUtils.toString(responseEntity);
				return jsonString;
			} else {
				logger.error("请求返回: " + state + "(" + url + ")");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (response != null) {
				try {
					response.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			try {
				httpclient.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EMPTY_STR;
	}

	public static String doSSL(String url, String json, String path, String pwd) {
		HttpEntity entity = null;
		CloseableHttpClient httpclient = null;
		try {
			SSLContext sslcontext = SSLContexts.custom()
					.loadTrustMaterial(new File(path), pwd.toCharArray(), new TrustSelfSignedStrategy()).build();
			// Allow TLSv1 protocol only
			SSLConnectionSocketFactory sslsf = new SSLConnectionSocketFactory(sslcontext, new String[] { "TLSv1" },
					null, SSLConnectionSocketFactory.getDefaultHostnameVerifier());
			httpclient = HttpClients.custom().setSSLSocketFactory(sslsf).build();
			HttpPost request = new HttpPost(url);
			
			RequestConfig requestConfig = RequestConfig.custom()
					.setSocketTimeout(readTimeoutMs)
					.setConnectTimeout(connectTimeoutMs).build();
			
			request.setConfig(requestConfig);
			request.addHeader("Content-Type", "application/json");
			request.setEntity(new StringEntity(json, UTF_8));
			HttpResponse response = httpclient.execute(request);
			entity = response.getEntity();
			return EntityUtils.toString(entity, UTF_8);
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				EntityUtils.consume(entity);
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return EMPTY_STR;
	}

}