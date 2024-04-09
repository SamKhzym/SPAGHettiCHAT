package kdc;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import java.io.IOException;
import java.io.Serializable;
import java.rmi.ServerError;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

public final class AES {


    public static SecretKey genSecretKey(int keySize) throws NoSuchAlgorithmException {
        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        keyGen.init(keySize);
        return keyGen.generateKey();
    }

    public static IvParameterSpec genIV(){
        byte[] iv = new byte[16];
        SecureRandom rand = new SecureRandom();
        rand.nextBytes(iv);
        return new IvParameterSpec(iv);
    }

    public static SealedObject encryptObj(SecretKey key, Serializable obj, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, IOException {
        Cipher cryptoAlgo = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cryptoAlgo.init(Cipher.ENCRYPT_MODE,key,iv);
        return new SealedObject(obj, cryptoAlgo);
    }

    public static Serializable decryptObj(SealedObject encryptedObj, SecretKey key, IvParameterSpec iv) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException, IllegalBlockSizeException, IOException, BadPaddingException, ClassNotFoundException {
        Cipher cryptoAlgo = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cryptoAlgo.init(Cipher.DECRYPT_MODE, key, iv);
        return (Serializable) encryptedObj.getObject(cryptoAlgo);


    }

}
