/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciphers;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Mauricio
 */
public abstract class Ciphers {
    public Cipher c;
    public SecretKey myKey;
    public  String key;
    public IvParameterSpec ivectorSpecv;
    public Ciphers(){
    }

   public void setKey(String k){
       this.key=k;
        myKey=new SecretKeySpec(key.getBytes(),"DES");
        ivectorSpecv=new IvParameterSpec(this.key.getBytes());
   }
    
   
    public byte[] cipher(byte[] data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,InvalidAlgorithmParameterException {
         c.init(Cipher.ENCRYPT_MODE, this.myKey, ivectorSpecv);
        return c.doFinal(data);
    }

    
    public byte[] decipher(byte[] data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException,InvalidAlgorithmParameterException {
        c.init(Cipher.DECRYPT_MODE, this.myKey, ivectorSpecv);
        return c.doFinal(data);
    }
}
