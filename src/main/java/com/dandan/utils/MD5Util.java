package com.dandan.utils;

import org.apache.commons.codec.binary.Hex;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.math.BigInteger;
import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class MD5Util {

    public static final String AES_KEY = "b4a901a1f0bb3f1a9151b88b9a2836c4";
    /**
     * 使用md5的算法进行加�?
     */
    public static String md5(String plainText) {

        if (plainText != null) {
            plainText = "ccxi_@!#$%^*&_123456987654" + plainText;
            //存放哈希值结果的 byte 数组�?
            byte[] secretBytes = null;
            try {
                //getInstance("md5"):返回实现指定摘要算法�? MessageDigest 对象
                //digest(byte[] ..)使用指定�? byte 数组对摘要进行最后更新，然后完成摘要计算
                secretBytes = MessageDigest.getInstance("md5").digest(
                        plainText.getBytes());
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("没有md5这个算法�?");
            }
            String md5code = new BigInteger(1, secretBytes).toString(16);
            for (int i = 0; i < 32 - md5code.length(); i++) {
                md5code = "0" + md5code;
            }
            return md5code;
        } else {
            return null;
        }

    }
    /**
    * @MethodName: stringToMD5
    * @Description: MD5
    * @Param plainText
    * @Return: java.lang.String
    * @Author: chshxu
    * @Date: 2020/6/22 11:09
    **/
    public static String stringToMD5(String plainText) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(
                    plainText.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1, secretBytes).toString(16);
        int length = md5code.length();//补位
        for (int i = 0; i < 32 - length; i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }
    /**
     * 生成key
     * @return
     */
    public static String generateKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
            keyGenerator.init(new SecureRandom());
            SecretKey secretKey = keyGenerator.generateKey();
            byte[] byteKey = secretKey.getEncoded();
            return Hex.encodeHexString(byteKey);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * AES加密
     * @param thisKey
     * @param data
     * @return
     */
    public static String aesEncode(String thisKey, String data) {
        try {
            // 转换KEY
            Key key = new SecretKeySpec(Hex.decodeHex(thisKey),"AES");
            //System.out.println(thisKey);

            // 加密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] result = cipher.doFinal(data.getBytes());
            return Hex.encodeHexString(result);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * AES解密
     * @param thisKey
     * @param data
     * @return
     */
    public static String aesDecode(String thisKey, String data) {
        try {
            // 转换KEY
            Key key = new SecretKeySpec(Hex.decodeHex(thisKey),"AES");
            // 解密
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] result = cipher.doFinal(Hex.decodeHex(data));
            return new String(result);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String Md5Token(String plainText) {

        if (plainText != null) {
            plainText = "ccxi_@!#$%^*&_123456987654" + plainText;
            //存放哈希值结果的 byte 数组�?
            byte[] secretBytes = null;
            try {
                //getInstance("md5"):返回实现指定摘要算法�? MessageDigest 对象
                //digest(byte[] ..)使用指定�? byte 数组对摘要进行最后更新，然后完成摘要计算
                secretBytes = MessageDigest.getInstance("md5").digest(
                        plainText.getBytes());
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException("没有md5这个算法�?");
            }
            String md5code = new BigInteger(1, secretBytes).toString(16);
            int length = md5code.length();//补位
            for (int i = 0; i < 32 - length; i++) {
                md5code = "0" + md5code;
            }
            return md5code;
        } else {
            return null;
        }

    }
    public static void main(String[] args) {
        //String ps = Md5Token("f048b8fc-75b9-45f0-a7f8-8256bc025251"+"123456789");
        //System.out.println("加密: " + ps);
       /* String res = aesDecode(AES_KEY, ps);
        System.out.println("解密: " + res);*/
        /*double fzhj =368207764192.72;
        double zchj =562224002082.86;
        double sxzc =226000000.00;
        double a =  sxzc/(zchj-fzhj);
        System.out.println(a*100);*/


        LocalDate expiryDate = LocalDate.parse("2021-04-15");
        // Parses the second date
        LocalDate nowDate = LocalDate.now();

        // Checks
        System.out.println(expiryDate.isAfter(nowDate));


    }
}
