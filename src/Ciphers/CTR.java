/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciphers;

import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author alumno
 */
public class CTR extends Ciphers  {
    
    public CTR () throws NoSuchAlgorithmException, NoSuchPaddingException{
        c = Cipher.getInstance("DES/CTR/PKCS5Padding");
    }
}
