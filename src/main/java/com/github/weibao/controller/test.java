package com.github.weibao.controller;
import java.awt.image.BufferedImage;
import java.io.*;

import javax.imageio.ImageIO;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;
/**
 * Created by wb on 2016-01-25.
 */
public class test {


    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static void main(String[] args) {
        System.out.println(111);
//        System.out.println(getImageBinary());
//        System.out.println(2222);
//        base64StringToImage(getImageBinary());
        System.out.println(33333);
    }

    static String getImageBinary(InputStream f) {
        //File f = new File("E:\\busiplatform\\code\\trunk\\enterprise-easy\\src\\main\\webapp\\WEB-INF\\images\\weibaopro_02.jpg");
        BufferedImage bi;
        try {
            bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void base64StringToImage(String base64String) {
        try {
//            System.out.println(base64String);
//            System.out.println(44444);
            byte[] bytes1 = decoder.decodeBuffer(base64String);

            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File w2 = new File("E://weibaopro_01.jpg");//可以是jpg,png,gif格式
            ImageIO.write(bi1, "jpg", w2);//不管输出什么格式图片，此处不需改动
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}