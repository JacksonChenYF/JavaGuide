package com.jacky.io;

/**
 * @Auther: ChenYF
 * @Date: 2019/12/8 10:14
 * @Description:文件的编码
 */
public class EncodeDemo {

    public static void main(String[] args) throws Exception {
        String string = "小蜜蜂XMF";
        //gbk
        byte[] bytes = string.getBytes("gbk");//转换成字节序列,并规定编码格式
        for (byte b : bytes) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
            //输出：d0 a1 c3 db b7 e4 58 4d 【gbk编码：中文两个字节、英文一个字节】
        }
        //utf-8
        System.out.println();
        byte[] bytes1 = string.getBytes("utf-8");//转换成字节序列,并规定编码格式
        for (byte b : bytes1) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
            //输出：e5 b0 8f e8 9c 9c e8 9c 82 58 4d 46  【utf-8编码：中文三个字节、英文一个字节】
        }

        //Java是双字节编码utf-16be
        System.out.println();
        byte[] bytes2 = string.getBytes("utf-16be");//转换成字节序列,并规定编码格式
        for (byte b : bytes2) {
            System.out.print(Integer.toHexString(b & 0xff) + " ");
            //输出：5c f 87 1c 87 2 0 58 0 4d 0 46  【utf-16be编码：中文两个字节、英文两个字节】
        }

        //当你的字节序列(右下角)是某种编码时，这个时候想把字节序列变成字符串，也需要用同种编码方式，否则出现乱码
        //正常：1、指定编码格式；2、用与项目一致的编码格式
        System.out.println();
        String str2 = new String(bytes2);//utf-16be
        String str22 = new String(bytes2, "utf-16be");//utf-16be
        System.out.println(str2);
        System.out.println(str22);
        System.out.println();
        String str1 = new String(bytes1);//utf-16be
        System.out.println(str1);

        /**
         * 文本文件就是字节序列，可以是任意编码，如果我们在中文机器上直接创建，该文件只认识ansi编码
         */

    }
}
