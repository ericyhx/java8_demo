package com.demo.jdk8.test;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @Description:
 * @author: yuhongxi
 * @date:2018/12/25
 */
public class Request {
    public static void main(String[] args) throws Exception {
        URL url=new URL("http://www.12333sh.gov.cn/sbsjb/wzb/dologin.jsp");
        HttpClient httpClient =new DefaultHttpClient();
//        HttpPost post=new HttpPost("http://www.12333sh.gov.cn/sbsjb/wzb/dologin.jsp");
        HttpPost post=new HttpPost("http://www.12333sh.gov.cn/sbsjb/wzb/dologin.jsp");

        // 构造消息头
//        post.setHeader("Accept","text/html,application/xhtml+xml,applicatio/n/xml;q=0.9,image/webp,image/apng,*/*;q=0.8");
//        post.setHeader("Accept-Encoding","gzip, deflate");
//        post.setHeader("Accept-Language","zh-CN,zh;q=0.9");
//        post.setHeader("Cache-Control","no-cache");
//        post.setHeader("Connection","keep-alive");
//        post.setHeader("Cookie","JSESSIONID=0000MnNGaI603MruIqrYNbi1OSv:1970revpd");
        post.setHeader("Cookie","0000MnNGaI603MruIqrYNbi1OSv:1970revpd");

        post.setHeader("Content-Type","application/x-www-form-urlencoded");
        JSONObject param= new JSONObject();
        param.put("userid", "422801198703180615");
//        param.put("userid", "622723198403122018");
//
        param.put("userpw","1111111");
        param.put("userjym","htf72");
        param.put("dfghj","3362");
        param.put("dianjicd1","");
        StringEntity stringEntity = new StringEntity(param.toString());
        stringEntity.setContentType("application/x-www-form-urlencoded");
        post.setEntity(stringEntity);
        HttpResponse response = httpClient.execute(post);
        System.out.println(response.getStatusLine().getStatusCode());
        BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"GBK"));
        String line ;
        while ((line=in.readLine())!=null){
            System.out.println(line);
        }
    }

}
