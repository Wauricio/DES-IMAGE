/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciphers;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;


/**
 *
 * @author Mauricio
 */
public class ECB extends Ciphers {

    public ECB() throws NoSuchAlgorithmException, NoSuchPaddingException{
        
        c=Cipher.getInstance("DES/ECB/PKCS5Padding");
        

    }
    
    @Override
    public byte[] cipher(byte[] data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        c.init(Cipher.ENCRYPT_MODE, myKey);
        return c.doFinal(data);
        
    }

    @Override
    public byte[] decipher(byte[] data) throws InvalidKeyException, IllegalBlockSizeException, BadPaddingException  {
        
            c.init(Cipher.DECRYPT_MODE, myKey);
            return c.doFinal(data);

        }

    
}
