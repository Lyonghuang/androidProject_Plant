package com.example.activity;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by main on 2018/6/1.
 */

public class ServerConnect {


    public static String getResult(String url_str){
        String result = null;
        try{
            URL url = new URL(url_str);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setReadTimeout(5000);
            conn.setConnectTimeout(5000);
            conn.setUseCaches(false);
            OutputStream out = conn.getOutputStream();
            out.write(url_str.getBytes());
            out.flush();
            out.close();
            conn.connect();
            return conn.getResponseMessage();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }
}
