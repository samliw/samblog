package com.sam.blog.common.util;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 *  密码加密  解密
 *      意义：
 *          加密：不希望别人知道我的消息，只有我才能解密，因此公钥负责加密，私钥负责解密
 *          签名：不希望别人 冒充我的消息，所以只能我才能发布这个签名，因此私钥负责签名，公钥负责验证
 */
public class AccountRSAUtils {
    public static final Logger LOGGER = LoggerFactory.getLogger(AccountRSAUtils.class);
    private static String KEY_RSA_TYPE = "RSA";
    private static String KEY_RSA_TYPE_ALL = "RSA/ECB/PKCS1Padding";
    private static int KEY_SIZE = 1024;//JDK方式RSA加密最大只有1024位
    private static int ENCODE_PART_SIZE = KEY_SIZE/8;
    public static final String PUBLIC_KEY_NAME = "public";
    public static final String PRIVATE_KEY_NAME = "private";

    // 公钥
    public static final String RSA_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCwOoiQH6A6dXVa8gRLX5aQ/BhVuvp8suRbO0J6OAVAswTvdfosV0t4mBMtakHPZUQE2d/ynCOSqRZXAccULa+pc10A2RbiFGYURFqTfgsaD46jJknDBn8kNdXLq/VIpob3BkIYN+tS62vXX2XmDB1qgoH4zdeRT/W0q6YnredtiQIDAQAB";
    // 秘钥
    public static final String RSA_PRIVATE = "MIICdwIBADANBgkqhkiG9w0BAQEFAASCAmEwggJdAgEAAoGBALA6iJAfoDp1dVryBEtflpD8GFW6+nyy5Fs7Qno4BUCzBO91+ixXS3iYEy1qQc9lRATZ3/KcI5KpFlcBxxQtr6lzXQDZFuIUZhREWpN+CxoPjqMmScMGfyQ11cur9UimhvcGQhg361Lra9dfZeYMHWqCgfjN15FP9bSrpiet522JAgMBAAECgYAVZtZk4mJcFx2scM3StYYcj3EJIE8BS9xts/Gr1BfXNqZ3ylUag3N37sgNcOUTIdIz4J3Q4eN0ETLUWDPsIGw/rVbXWpaBVuXYODjZjBzKZBdcNJKeIXm3HKEgO/apvaWzRaVB5Kuh6ydYsJodGER6owqVU9EEvWssfa1T0VVeXQJBANm2w0Kqgnt4Nlt9P45NaJt/4L1s8+92rv+PiWKz5OHi/yzqUgUkpdzdwwaKeD+VJOpcHQ0+mCIYiDBtqi6gtNMCQQDPOCZyf+6W3VzMPFFtyL3fbpGmXg6MV9qd3qkMyfBiAkcwRHU942FZAhIpWyISFh80dkI3d7qrNpARiGdpLEqzAkAwHahBz5VO3F6HEcM+G/WGiFiPBMlUnxJGAN8IJWHsWlKzBoZiBJtzmL9FbszsoHWsJfd1ueO9hVZz/YijDXlpAkEAr3/dyCGjn3BRlMQNLw7SCLarcpy8c45AoG4g/KzXAxrs0etY5JZ8Lxc67H27qFfGC/eQc0va9ADdGYxOENwrUwJBAMUxA3QN+mMBUlJb5YzDLbUmsI5IpzJFpHR/hNo8wxJ8oktxzhNsqc1a/MvFGA/6Xk2nl4vtHjgAqTEnPi/W3RE=";

    /**
     * 创建公钥秘钥
     * @return
     */
    public static Map<String,String> createRSAKeys(){
        Map<String,String> keyPairMap = new HashMap<>();//里面存放公私秘钥的Base64位加密
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_RSA_TYPE);
            keyPairGenerator.initialize(KEY_SIZE,new SecureRandom());
            KeyPair keyPair = keyPairGenerator.generateKeyPair();

            //获取公钥秘钥
            String publicKeyValue = Base64.encodeBase64String(keyPair.getPublic().getEncoded());
            String privateKeyValue = Base64.encodeBase64String(keyPair.getPrivate().getEncoded());

            //存入公钥秘钥，以便以后获取
            keyPairMap.put(PUBLIC_KEY_NAME,publicKeyValue);
            keyPairMap.put(PRIVATE_KEY_NAME,privateKeyValue);
        } catch (NoSuchAlgorithmException e) {
            LOGGER.error("获取公钥私钥失败！原因： " + e.getMessage());
            e.printStackTrace();
        }
        return keyPairMap;
    }

    /**
     * 公钥加密
     * 描述：
     *     1字节 = 8位；
     *     最大加密长度如 1024位私钥时，最大加密长度为 128-11 = 117字节，不管多长数据，加密出来都是 128 字节长度。
     * @param sourceStr
     * @param publicKeyBase64Str
     * @return
     */
    public static String encode(String sourceStr,String publicKeyBase64Str){
        byte [] publicBytes = Base64.decodeBase64(publicKeyBase64Str);
        //公钥加密
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(publicBytes);
        List<byte[]> alreadyEncodeListData = new LinkedList<>();

        int maxEncodeSize = ENCODE_PART_SIZE - 11;
        String encodeBase64Result = null;
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_TYPE);
            PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(KEY_RSA_TYPE_ALL);
            cipher.init(Cipher.ENCRYPT_MODE,publicKey);
            byte[] sourceBytes = sourceStr.getBytes(StandardCharsets.UTF_8);
            int sourceLen = sourceBytes.length;
            for(int i=0;i<sourceLen;i+=maxEncodeSize){
                int curPosition = sourceLen - i;
                int tempLen = curPosition;
                if(curPosition > maxEncodeSize){
                    tempLen = maxEncodeSize;
                }
                byte[] tempBytes = new byte[tempLen];//待加密分段数据
                System.arraycopy(sourceBytes,i,tempBytes,0,tempLen);
                byte[] tempAlreadyEncodeData = cipher.doFinal(tempBytes);
                alreadyEncodeListData.add(tempAlreadyEncodeData);
            }
            int partLen = alreadyEncodeListData.size();//加密次数

            int allEncodeLen = partLen * ENCODE_PART_SIZE;
            byte[] encodeData = new byte[allEncodeLen];//存放所有RSA分段加密数据
            for (int i = 0; i < partLen; i++) {
                byte[] tempByteList = alreadyEncodeListData.get(i);
                System.arraycopy(tempByteList,0,encodeData,i*ENCODE_PART_SIZE,ENCODE_PART_SIZE);
            }
            encodeBase64Result = Base64.encodeBase64String(encodeData);
        } catch (Exception e) {
            LOGGER.error("公钥加密失败！原因： " + e.getMessage());
            e.printStackTrace();
        }
        return encodeBase64Result;
    }

    /**
     * 私钥解密
     * @param sourceBase64RSA
     * @param privateKeyBase64Str
     */
    public static String decode(String sourceBase64RSA,String privateKeyBase64Str){
        byte[] privateBytes = Base64.decodeBase64(privateKeyBase64Str);
        byte[] encodeSource = Base64.decodeBase64(sourceBase64RSA);
        int encodePartLen = encodeSource.length/ENCODE_PART_SIZE;
        List<byte[]> decodeListData = new LinkedList<>();//所有解密数据
        String decodeStrResult = null;
        //私钥解密
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(privateBytes);
        try {
            KeyFactory keyFactory = KeyFactory.getInstance(KEY_RSA_TYPE);
            PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
            Cipher cipher = Cipher.getInstance(KEY_RSA_TYPE_ALL);
            cipher.init(Cipher.DECRYPT_MODE,privateKey);
            int allDecodeByteLen = 0;//初始化所有被解密数据长度
            for (int i = 0; i < encodePartLen; i++) {
                byte[] tempEncodedData = new byte[ENCODE_PART_SIZE];
                System.arraycopy(encodeSource,i*ENCODE_PART_SIZE,tempEncodedData,0,ENCODE_PART_SIZE);
                byte[] decodePartData = cipher.doFinal(tempEncodedData);
                decodeListData.add(decodePartData);
                allDecodeByteLen += decodePartData.length;
            }
            byte [] decodeResultBytes = new byte[allDecodeByteLen];
            for (int i = 0,curPosition = 0; i < encodePartLen; i++) {
                byte[] tempSorceBytes = decodeListData.get(i);
                int tempSourceBytesLen = tempSorceBytes.length;
                System.arraycopy(tempSorceBytes,0,decodeResultBytes,curPosition,tempSourceBytesLen);
                curPosition += tempSourceBytesLen;
            }
            decodeStrResult = new String(decodeResultBytes, StandardCharsets.UTF_8);
        }catch (Exception e){
            LOGGER.error("私钥解密失败！原因： " + e.getMessage());
            e.printStackTrace();
        }
        return decodeStrResult;
    }
}
