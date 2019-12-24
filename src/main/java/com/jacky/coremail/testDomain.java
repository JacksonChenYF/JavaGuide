package com.jacky.coremail;

import java.io.IOException;
import java.net.*;

/**
 * @Auther: ChenYF
 * @Date: 2019/12/21 15:53
 * @Description: 客户域名检测
 */
public class testDomain {

    public static void isOpen(String[] domainurl) throws MalformedURLException {

        String[] urlHead = new String[]{"http://mail.", "https://mail.", "http://smtp.", "https://smtp.", "http://mx.", "https://mx."};
        System.setProperty("sun.net.client.defaultConnectTimeout", "300"); //设置最长连接时间

        //for (String s1 : domainurl)
        for (int i = 0; i < domainurl.length; i++) {
            //for (String s2 : urlHead)
            for (int j = 0; j < urlHead.length; j++) {
                String realurl = urlHead[j] + domainurl[i];
                //System.out.print(realurl+"  ");  //http://mail.baidu.com  https://mail.baidu.com  http://smtp.baidu.com  https://smtp.baidu.com  http://mx.baidu.com  https://mx.baidu.com  http://mail.fanyi.baidu.com  https://mail.fanyi.baidu.com  http://smtp.fanyi.baidu.com  https://smtp.fanyi.baidu.com  http://mx.fanyi.baidu.com  https://mx.fanyi.baidu.com
                URL url = new URL(realurl);

                try {
                    url.openConnection().connect();
                    System.out.print("\n" + i + " " + realurl + "可以访问！！！" + "  ");
                    /*URLConnection urlConnection1 = url.openConnection();
                    HttpURLConnection httpURLConnection1 = (HttpURLConnection) urlConnection1;
                    if (httpURLConnection1.getResponseCode() == 200 ) {
                        System.out.print("\n" + i + " " + realurl + "可以访问！！！" + "  ");
                    } else {
                        break;
                    }*/
                } catch (IOException e) {
                    break;
                    //e.printStackTrace();
                }

                try {
                    /*url.openConnection().connect();
                    System.out.print("\n" + i + " " + realurl + "可以访问！！！");*/

                    //是否为coremail系统
                    String coremailurl = "http://mail." + domainurl[i] + "/coremail/s?func=verify";
                    URL url1 = new URL(coremailurl);
                    URLConnection urlConnection = url1.openConnection();
                    HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
                    if (httpURLConnection.getResponseCode() == 200) {
                        System.out.print("是coremail系统 ！！！");
                        break;              //如果url头判定是coremail系统跳出循环
                    } else {
                        testagain(domainurl[i]);
                        //System.out.println("不是coremail系统！！！");
                        break;              //如果url头判定不是coremail系统跳出循环
                    }
                    //break;

                } catch (IOException e) {
                    testagain(domainurl[i]);
                    //e.printStackTrace(); //连接失败直接跳过
                }
            }
        }

    }

    //
    public static void testagain(String s) throws MalformedURLException {
        String coremailurl1 = "https://mail." + s + "/coremail/s?func=verify";
        URL url11 = new URL(coremailurl1);
        URLConnection urlConnection1 = null;
        try {
            urlConnection1 = url11.openConnection();
            HttpURLConnection httpURLConnection1 = (HttpURLConnection) urlConnection1;
            if (httpURLConnection1.getResponseCode() == 200) {
                System.out.print("是coremail系统 ！！！");
            } else {
                System.out.print("不是coremail系统！！！");
            }
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }


    public static void main(String[] args) throws MalformedURLException {
        String[] domainurl = new String[]{};
        isOpen(domainurl);
//"gzfda.gov.cn", "rrcb.com", "gshi.cn", "zhongweihotels.com", "lxsec.com","fufeng-group.com", "hualu.com.cn", "sz.tsinghua.edu.cn", "ect888.com"
        /*URL URL = new URL("http://mail.cucn.edu.cn");
        System.setProperty("sun.net.client.defaultConnectTimeout", "300");
        try {
            URL.openConnection().connect();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

}
