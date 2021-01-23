package com.test.bsecond.xunlianying.week02;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class CloseableHttpClientDemo {

    public static void main(String[] args) {

        CloseableHttpClient client = HttpClientBuilder.create().build();

        String uri = "http://localhost:8080";
        HttpGet get = new HttpGet(uri);

        // Content-Type: application/x-www-form-urlencoded; charset=utf-8
        try {
            get.addHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() != 200) {
                return;
            }
            String res = EntityUtils.toString(response.getEntity());
            System.out.println(res);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
