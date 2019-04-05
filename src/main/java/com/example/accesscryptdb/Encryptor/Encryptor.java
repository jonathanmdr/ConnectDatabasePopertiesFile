package com.example.accesscryptdb.Encryptor;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.PBEParameterSpec;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class Encryptor {

    private static final String CRYPTO_ALGORITHM = "PBEWithMD5AndDES";
    private static final String KEY = "QO[kz=rOWaHov<BqG][m]mn0&*.xnbH#lR?DNccYdxoVg0KQR?7Y!Hm%";//Aleatória, pode colocar qualquer coisa.(só consegue descriptografar com essa chave)

    private PBEKeySpec getKs() {
        return new PBEKeySpec(KEY.toCharArray());
    }

    private PBEParameterSpec getPs() {
        return new PBEParameterSpec(new byte[]{3, 1, 4, 1, 5, 9, 2, 6}, 20);
    }

    private SecretKey getKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
        SecretKeyFactory skf = SecretKeyFactory.getInstance(CRYPTO_ALGORITHM);
        KeySpec ks = getKs();
        SecretKey skey = skf.generateSecret(ks);
        return skey;
    }

    public final String encrypt(String text) throws Exception {
        try {
            Cipher c = Cipher.getInstance(CRYPTO_ALGORITHM);
            SecretKey skey = getKey();
            PBEParameterSpec ps = getPs();
            c.init(Cipher.ENCRYPT_MODE, skey, ps);
            return Base64.encode(c.doFinal(text.getBytes()));
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            throw new Exception(ex);
        }
    }

    public String decrypt(String text) throws Exception {
        if (text == null || text.equals("")) {
            return "";
        }
        try {
            Cipher c = Cipher.getInstance(CRYPTO_ALGORITHM);
            SecretKey skey = getKey();
            PBEParameterSpec ps = getPs();
            c.init(Cipher.DECRYPT_MODE, skey, ps);
            return new String(c.doFinal(Base64.decode(text)));
        } catch (IllegalBlockSizeException | BadPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | InvalidKeySpecException | NoSuchAlgorithmException | NoSuchPaddingException ex) {
            throw new Exception(ex);
        }
    }

}
