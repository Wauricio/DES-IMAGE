/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciphers;

import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * @author Mauricio
 */
public class OFB extends Ciphers {
     public OFB() throws NoSuchAlgorithmException, NoSuchPaddingException, NoSuchProviderException {
        
         c = Cipher.getInstance("DES/OFB/PKCS5Padding");
        
        
    }
}
