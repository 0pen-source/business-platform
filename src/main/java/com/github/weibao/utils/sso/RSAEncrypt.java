 package com.github.weibao.utils.sso;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

/**
 * Created by wyf on 2015/11/13.
 * RSA 加密
 */
public class RSAEncrypt {
    public static final String KEY_PUBLIC = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCKBJfKhljBmgECbtsr3wWDXti+NahdBQCXbP57O4yiFDKj665D/UHAMMPYMvTHXqo/4Cj5wbvFuBnHP7IcjSCH1nW+W1urpiqm5Dc4d8XWGkheCEZgWe696ReUFDhYI4FTwqVR/g36Mwe9Xw1hRvTP9by3uNktLu2IZA6nXRkqVQIDAQAB";
    public static final String KEY_PRIVATE = "MIICdQIBADANBgkqhkiG9w0BAQEFAASCAl8wggJbAgEAAoGBAIoEl8qGWMGaAQJu2yvfBYNe2L41qF0FAJds/ns7jKIUMqPrrkP9QcAww9gy9Mdeqj/gKPnBu8W4Gcc/shyNIIfWdb5bW6umKqbkNzh3xdYaSF4IRmBZ7r3pF5QUOFgjgVPCpVH+DfozB71fDWFG9M/1vLe42S0u7YhkDqddGSpVAgMBAAECgYATEtlrWq+vaboT/P/7CyI26oenmcC/wi43vw9YNn2T9JifALYfnUNV7SdTnI8pclKy6yaehYCOrYeaepoByhshlWE2SxUtPI7nugInjl6G+f4W+sYh2NY+QRGpNMh+lLAAOtAdjR8QNlOS37z2yaU3bVXodjM0jC4yFw88HK1+7QJBAOt9E09PG8P7TfuSLCy2dRog0CLFFa0Ce7rEIzYB5rJ8I6XNvBgcwjEH1R3kfavMx8SMWN0HGOKHuQ84oq6WRW8CQQCWCh3+hmCEppAV2DFHIPp+1ppWTyjXttWTi/4DVWlosZwBz4UEXePShQ9ddT9WpA8ES0G2xiiNyGuajsGcPBJ7AkAD0OUNNfT3Og1LdFTu7I39PGbjCVqOkSm8Hw2LBIDeh5B0UV8o7N5guQXFFDzNGeZq0vNlsYW/tf9TtdE9DwZVAkBn0kZhClEdWThYtUmcA3jybcNMN+h2JCDzwSoa2m5fMI9YPWW42NM9qC8yp2AVrt5pRT4KoGINggLbZy8X0gWjAkA6fbMiI5UNAz+UARaqc0BYek1bSluvqJNoAHFyyWhVixcN08uAOTL7tO+RyNbSPvzfgzjQln0itcI9QR2GgrbF";

    public static final String ALGORITHM = "RSA";
    public static final String CHARSET_NAME = "utf-8";
    private static PublicKey publicKey;
    private static PrivateKey privateKey;
    private static Cipher cipher;
    static {
        try {
            X509EncodedKeySpec pks = new X509EncodedKeySpec(Base64.decodeBase64(KEY_PUBLIC));
            PKCS8EncodedKeySpec prks = new PKCS8EncodedKeySpec(Base64.decodeBase64(KEY_PRIVATE));
            KeyFactory keyFactory = KeyFactory.getInstance(ALGORITHM);
            publicKey = keyFactory.generatePublic(pks);
            privateKey = keyFactory.generatePrivate(prks);
            cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        }
    }

    /**
     * 加密
     * @param content
     * @return
     */
    public static String encrypt(String content) throws InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return Base64.encodeBase64String(cipher.doFinal(content.getBytes(CHARSET_NAME)));
    }

    /**
     * 解密
     * @param content
     * @return
     */
    public static String unencrypt(String content) throws InvalidKeyException, UnsupportedEncodingException, BadPaddingException, IllegalBlockSizeException {
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return new String(cipher.doFinal(Base64.decodeBase64(content)), CHARSET_NAME);
    }

    public static void main(String[] args) throws Exception {
        String content = "iKu/BGZqqIowiI18lm4xcJ3doRdHmY8trMA/YfNqZz95K/lGcQPRgSpI7bJYeKwifyT8VglIqRhRXCDwF99jrmIYzMxZYRVOb/+Nk7zhs/agx6qX5u64pHSiuxaETHCOliV1QPIntKFFJ+iiMC4PrOxJmavoKPl2fjuC3NwRXHo=";
        String unencrypt = RSAEncrypt.unencrypt(content);
        System.out.println(unencrypt);
    }

}
