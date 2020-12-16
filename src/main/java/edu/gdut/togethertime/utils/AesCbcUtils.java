package edu.gdut.togethertime.utils;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.AlgorithmParameters;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.InvalidParameterSpecException;

/**
 * 微信登录用加密解密工具
 *
 * @author Leonardo
 */
public class AesCbcUtils {

    public static String decrypt(String data, String key, String iv, String encodingFormat) {
        //加密数据的解码
        byte[] dataByte = Base64.decodeBase64(data);
        //秘钥的解码
        byte[] keyByte = Base64.decodeBase64(key);
        //加密向量的解码
        byte[] ivByte = Base64.decodeBase64(iv);

        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            //设置AES加密标准
            SecretKeySpec secretKeySpec = new SecretKeySpec(keyByte, "AES");
            AlgorithmParameters parameter = AlgorithmParameters.getInstance("AES");
            parameter.init(new IvParameterSpec(ivByte));

            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, parameter);
            byte[] bytes = cipher.doFinal(dataByte);

            if (bytes != null && bytes.length>0) {
                return new String(bytes, encodingFormat);
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (InvalidParameterSpecException e) {
            e.printStackTrace();
        } catch (InvalidAlgorithmParameterException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return null;
    }
}
