package com.jacky.coremail;

import java.io.IOException;
import java.net.*;

/**
 * @Auther: ChenYF
 * @Date: 2019/12/21 15:53
 * @Description: 客户域名检测
 */
public class testdomain {

    public static void isOpen(String[] domainurl) throws MalformedURLException {

        String[] urlHead = new String[]{"http://mail.", "https://mail.", "http://smtp.", "https://smtp.", "http://mx.", "https://mx."};
        System.setProperty("sun.net.client.defaultConnectTimeout", "600"); //设置最长连接时间

        //for (String s1 : domainurl)
        for (int i = 0; i < domainurl.length; i++) {
            //for (String s2 : urlHead)
            for (int j = 0; j < urlHead.length; j++) {
                String realurl = urlHead[j] + domainurl[i];
                //System.out.print(realurl+"  ");  //http://mail.baidu.com  https://mail.baidu.com  http://smtp.baidu.com  https://smtp.baidu.com  http://mx.baidu.com  https://mx.baidu.com  http://mail.fanyi.baidu.com  https://mail.fanyi.baidu.com  http://smtp.fanyi.baidu.com  https://smtp.fanyi.baidu.com  http://mx.fanyi.baidu.com  https://mx.fanyi.baidu.com
                URL url = new URL(realurl);
                try {
                    url.openConnection().connect();
                    System.out.print(realurl + "可以访问！！！");

                    //是否为coremail系统
                    String coremailurl = "http://mail." + domainurl[i] + "/coremail/s?func=verify";
                    URL url1 = new URL(coremailurl);
                    URLConnection urlConnection = url1.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    if (httpURLConnection.getResponseCode() == 200) {
                        System.out.println("是coremail系统 ！！！");
                        break;              //如果url头判定是coremail系统跳出循环
                    } else {
                        System.out.println("不是coremail系统！！！");
                    }
                    //break;

                } catch (IOException e) {
                    //e.printStackTrace(); //连接失败直接跳过
                }
            }
        }

        /*for (String s1 : domainurl) {
            for (String s2 : urlHead) {
                String realurl = s2 + s1;
                //System.out.print(realurl+"  ");  //http://mail.baidu.com  https://mail.baidu.com  http://smtp.baidu.com  https://smtp.baidu.com  http://mx.baidu.com  https://mx.baidu.com  http://mail.fanyi.baidu.com  https://mail.fanyi.baidu.com  http://smtp.fanyi.baidu.com  https://smtp.fanyi.baidu.com  http://mx.fanyi.baidu.com  https://mx.fanyi.baidu.com
                URL url = new URL(realurl);
                try {
                    url.openConnection().connect();
                    System.out.print(realurl + "可以访问！！！");

                    //是否为coremail系统
                    String coremailurl = "http://mail." + s1 + "/coremail/s?func=verify";
                    URL url1 = new URL(coremailurl);
                    URLConnection urlConnection = url1.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    if (httpURLConnection.getResponseCode() == 200) {
                        System.out.println("是coremail系统 ！！！");
                    } else {
                        System.out.println("不是coremail系统！！！");
                    }

                } catch (IOException e) {
                    //e.printStackTrace();
                }
            }
        }*/
    }


    public static void main(String[] args) throws MalformedURLException {
        String[] domainurl = new String[]{"luxin.cn", "gissinggroup.com", "pbcsf.tsinghua.edu.cn", "jit.edu.cn", "ekimmigration.com",};
        isOpen(domainurl);

        /*URL URL = new URL("http://mail.ahpumec.edu.cn/coremail/s?func=verify");
        System.setProperty("sun.net.client.defaultConnectTimeout", "300");
        try {
            URL.openConnection().connect();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
