package com.huanletao.huanletao.controller;

import com.alibaba.fastjson.JSONObject;
import com.huanletao.huanletao.dto.ResponseObject;
import com.huanletao.huanletao.tenum.ResponseEnum;
import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 *
 * @auther: huangjianfeng
 * @Date: 2019/12/29
 * @Time: 17:27
 * Description:
 */@Controller
@RequestMapping("File")
public class CommonController {

     //文件上传功能
     @ResponseBody
     @RequestMapping(value = "upload",produces = "text/html;charset=UTF-8")
    public ResponseObject uploadFile(MultipartFile uploadFile, HttpServletRequest request, String path){

         //获取文件路劲
         String rootPath = request.getServletContext().getRealPath("static");

         //获取上传文件的源文件名
         String filename = uploadFile.getOriginalFilename();

         //构建文件对象
         File filePath = new File(rootPath,filename);

         //判断存放的路径是否存在。不存在就创建。
         if (!filePath.getParentFile().exists()){
             filePath.mkdirs();
         }
         //这里是存放上传文件的路径。
         String savePath = rootPath+"/image/"+path+"/"+filename;

         try {
             //开始上传
             uploadFile.transferTo(new File(savePath));
         } catch (IOException e) {
             e.printStackTrace();
         }

         //构造返回回显图的路径。
         String picPath = "/static/image/"+path+"/"+filename;

         //创建Json对象
         JSONObject jsonObject = new JSONObject();
         jsonObject.put("msg",picPath);

         return ResponseObject.success(ResponseEnum.UPLOADSUCCESS).setData(jsonObject.toJSONString());
     }


     //文件下载功能
     @RequestMapping("download")
    public ResponseEntity<byte[]> download(HttpServletRequest request,String imgPath){
        //获取服务器的要下载的文件件夹物理地址，
         String path = request.getServletContext().getRealPath("static");
         //要下载的文件路径。
         File file = new File(path+imgPath);
         String filename = file.getName();
         byte[] bytes = null;
         HttpHeaders httpHeaders = null;

         try {
             bytes = FileUtils.readFileToByteArray(file);
             httpHeaders = new HttpHeaders();

             filename = new String(filename.getBytes("UTF-8"));
             httpHeaders.setContentDispositionFormData("attachment",filename);
             httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
         } catch (IOException e) {
             e.printStackTrace();
         }

         return new ResponseEntity<>(bytes,httpHeaders,HttpStatus.CREATED);
     }


}
