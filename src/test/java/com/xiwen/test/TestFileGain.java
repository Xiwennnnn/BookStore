package com.xiwen.test;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


public class TestFileGain {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/BookStore/static/img/logo.jpg");
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.connect();
            FileOutputStream fos = new FileOutputStream("D:\\Code\\JavaWeb\\BookStore\\src\\test\\logo.txt");
            BufferedInputStream bis = new BufferedInputStream(conn.getInputStream());
            int len = 0;
            byte[] buffer = new byte[1024];
            while((len = bis.read(buffer)) != -1) {
                fos.write(buffer, 0, len);
            }
            bis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static StringBuilder getStringBuilder(HttpURLConnection conn) throws IOException {
        int code = conn.getResponseCode();
        String currentLine;
        StringBuilder totalLine = new StringBuilder();
        if (code == 200) {
            InputStream inputStream = conn.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            while((currentLine = bufferedReader.readLine()) != null) {
                if(currentLine.length() > 0){
                    totalLine.append(currentLine);
                }
            }
        }else{
            totalLine.append(code);
        }
        return totalLine;
    }
}
