package com.vivsoft.client;


import org.apache.http.client.methods.*;
import org.apache.http.impl.client.*;
import org.apache.http.util.*;
import org.apache.http.*;
import org.apache.http.entity.*;
import org.apache.http.protocol.*;

/**
 * Created with IntelliJ IDEA.
 * User: vivianvanzyl
 * Date: 7/22/14
 * Time: 2:00 PM
 */
public class testClient {

    public static void main(String[] args) {
        sendREQ();
        recvREQ();
    }


    private static void recvREQ() {
        CloseableHttpResponse response = null;

        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpGet httpGet = new HttpGet("http://www.demobank.us/DSsampleServices/v1/ofac/10000002");
            httpGet.addHeader("Content-Type", "application/json");
            System.err.println("Requesting...");

            response = httpclient.execute(httpGet);
            System.out.println("Response Code:" + response.getStatusLine());
            HttpEntity recv_entity = response.getEntity();
            System.out.println("Response:\n" + EntityUtils.toString(recv_entity));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception ex) {
            }
        }
    }

    private static void sendREQ() {
        CloseableHttpResponse response = null;
        String jsonObj = "{\n" +
                "\"person\": {\n" +
                "\t\t\t\"firstname\": \"Osama\",\n" +
                "\t\t\t\"lastname\": \"test\",\n" +
                "\t\t\t\"address\": \"10 Test Street\",\n" +
                "\t\t\t\"city\": \"Test\",\n" +
                "\t\t\t\"state\": \"GA\",\n" +
                "\t\t\t\"zip\": \"30024\"\n" +
                "\t\t  }\n" +
                "}";

        try {
            CloseableHttpClient httpclient = HttpClients.createDefault();
            HttpPost httpPost = new HttpPost("http://www.demobank.us/DSsampleServices/v1/ofac");
            httpPost.addHeader("Content-Type", "application/json");
            StringEntity send_entity = new StringEntity(jsonObj.toString(), HTTP.UTF_8);
            httpPost.setEntity(send_entity);
            System.err.println("Sending:\n:" + EntityUtils.toString(send_entity));

            response = httpclient.execute(httpPost);
            System.out.println("Response Code:" + response.getStatusLine());
            HttpEntity recv_entity = response.getEntity();
            System.out.println("Response:\n" + EntityUtils.toString(recv_entity));

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            try {
                response.close();
            } catch (Exception ex) {
            }
        }
    }

}
