/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Mauricio
 */
public class DES {
    private Cipher c;
    private SecretKey key;
    public DES(String key){
        this.key=new SecretKeySpec(key.getBytes(),"DES");
    }
    
    public void initCipher(String mode) throws NoSuchAlgorithmException, NoSuchProviderException, NoSuchPaddingException, InvalidKeyException{
        switch(mode){
            case "ECB":
                c= Cipher.getInstance("DES/ECB/PKCS7Padding", "BC");
             break;
             
            case "CBC":
                
                break;
   
        }
           
        
        
    }
    
    
    
    
    public static void main(String args[]) throws IOException{
       
        
    }
    
    
    
   
    
    
    
    
}
