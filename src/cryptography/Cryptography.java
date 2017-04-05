/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cryptography;

import Ciphers.CBC;
import Ciphers.CFB;
import Ciphers.Ciphers;
import Ciphers.ECB;
import Ciphers.OFB;
import static com.oracle.jrockit.jfr.ContentType.Bytes;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.util.Arrays;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.imageio.ImageIO;

/**
 *
 * @author Mauricio
 */
public class Cryptography {

   public static void main( String[] args ) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, InvalidAlgorithmParameterException, NoSuchProviderException{
       BufferedImage image = null;
        try {
            Ciphers c = new CBC();
              //you can either use URL or File for reading image using ImageIO
            File imagefile = new File("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Cryptography\\src\\cryptography\\linux.bmp");
            image = ImageIO.read(imagefile);
            c.setKey("12345678");
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( image, "bmp", baos );
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            System.out.println("size: "+imageInByte.length+" sizeFile: "); 
            Object o[] = SplitArray(imageInByte,54);
            System.out.println("o1 :" + ((byte[])o[0]).length +" o2: "+((byte[])o[1]).length );
            
            
            imageInByte=concat(((byte[])o[0]),c.cipher(((byte[])o[1])));
            
            InputStream in = new ByteArrayInputStream(imageInByte);
            image = ImageIO.read(in);
            //ImageIO Image write Example in Java
            //ImageIO.write(image, "jpg",new File("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Cryptography\\src\\cryptography\\l.jpg"));
            ImageIO.write(image, "bmp",new File("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Cryptography\\src\\cryptography\\out.bmp"));
            //ImageIO.write(image, "gif",new File("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Cryptography\\src\\cryptography\\linux2.gif"));
            //ImageIO.write(image, "png",new File("C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Cryptography\\src\\cryptography\\linux2.png"));

        } catch (IOException e) {
              e.printStackTrace();
        }
        System.out.println("Success");
    }
   
   public static Object []readImage(String path) throws IOException{
        BufferedImage image; 
       File imagefile = new File(path);
            image = ImageIO.read(imagefile);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( image, "bmp", baos );
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();
            System.out.println("size: "+imageInByte.length+" sizeFile: "); 
            return SplitArray(imageInByte,54);
   }
   
   public static void writeImage(byte[] imageInByte ,String path) throws IOException{
       InputStream in = new ByteArrayInputStream(imageInByte);
       ImageIO.write(ImageIO.read(in), "bmp",new File(path));
            
   }

  public static Object[] SplitArray(byte a[],int v){
      int l= a.length;
      byte a1[]=new byte[v];
      byte a2[]=new byte[l-v];
      for(int i=0;i<v;i++ )
          a1[i]=a[i];
      for(int i=v;i<l;i++)
          a2[i-v]=a[i];
      
      return new Object[]{a1,a2};
  }
 
   public static byte[] concat(byte[] f,byte[]  s) {
            byte[] combined = new byte[f.length + s.length];

            System.arraycopy(f,0,combined,0         ,f.length);
            System.arraycopy(s,0,combined,f.length,s.length);
            return combined;
    }
   


}
