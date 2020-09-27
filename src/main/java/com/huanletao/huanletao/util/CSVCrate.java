package com.huanletao.huanletao.util;

import com.huanletao.huanletao.entity.WebGoodDesc;
import com.huanletao.huanletao.entity.WebOrder;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * 创建CSV文件
 */
public class CSVCrate {

    /**
     * 创建CSV文件
     */

    public static void main(String[] args) {
        /**
         * "第一列","第二列","第三列",
         * "111","222","333",
         * "444","555","666",
         */

        List<WebOrder> list = new ArrayList<>();

        Object[] head = { "省份","地市","cb订单号","产品名称","担保金额（分）","期数",
                "用户姓名","业务号码","渠道编码","竣工时间","生效时间", };
        List<Object> exportData = Arrays.asList(head);
        List<List<Object>> datalist = new ArrayList<List<Object>>();

        String path = "d:/exportCsv/";
        String fileName = "文件导出";
        createCSVFile(exportData, list, path, fileName);
    }

    /**
     * 写一行数据
     * @param row 数据列表
     * @param csvWriter
     * @throws IOException
     */
    private static void writeHead(List<Object> row, BufferedWriter csvWriter) throws IOException {
        for (Object data : row) {
            StringBuffer sb = new StringBuffer();
            String rowStr = sb.append("\"").append(data).append("\",").toString();
            csvWriter.write(rowStr);
        }
        csvWriter.newLine();
    }

    /**
     *  写入一行数据。
     * @param row
     * @param csvWriter
     * @throws IOException
     */
    private static void writeRow(WebOrder row, BufferedWriter csvWriter) throws IOException {
        StringBuffer sb = new StringBuffer();
        String rowStr = sb.append("\"").append(row.getBuyername()).append("\",")
                .append("\"").append(row.getGoodname()).append("\",").append("\"")
                .append(row.getPrice()).append("\",")
                .append("\"").append(row.getSellername()).append("\",")
                .append("\"").append(row.getPrice()).append("\",")
                .append("\"").append(row.getStatus()).append("\",")
                .append("\"").append(row.getCreatedate()).append("\",")
                .append("\"").append(row.getGoodid()).append("\",")
                .append("\"").append(row.getGoodid()).append("\",")
                .append("\"").append(row.getStatus()).append("\",")
                .append("\"").append(row.getGoodid()).append("\",").toString();

        csvWriter.write(rowStr);

        csvWriter.newLine();
    }



    /**
     * CSV文件生成方法
     * @param head 文件头
     * @param dataList 数据列表
     * @param outPutPath 文件输出路径
     * @param filename 文件名
     * @return
     */
    public static File createCSVFile(List<Object> head, List<WebOrder> dataList,String outPutPath, String filename) {

        File csvFile = null;
        BufferedWriter csvWtriter = null;
        try {
            csvFile = new File(outPutPath + File.separator + filename + ".csv");
            File parent = csvFile.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }
            csvFile.createNewFile();

            // GB2312使正确读取分隔符","
            csvWtriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(
                    csvFile), "GB2312"), 1024);
            // 写入文件头部
            writeHead(head, csvWtriter);

            // 写入文件内容
            for (WebOrder row : dataList) {
                writeRow(row, csvWtriter);
            }
            csvWtriter.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                csvWtriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return csvFile;
    }


}