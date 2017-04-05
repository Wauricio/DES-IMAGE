/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Ciphers;



import java.io.File;
import java.io.IOException;

/**
 *
 * @author ian
 */
public class Test {
  
  public static void main(String[] args) throws IOException {
    
    // input and output file names
    
    String strInFile = "C:\\Users\\Mauricio\\Documents\\NetBeansProjects\\Cryptography\\src\\cryptography\\linux.bmp";
    String strOutFile = "output.bmp";
                
    /*****  decode ICO and save images as BMP and PNG ****/
         java.io.File inFile = new java.io.File(strInFile);
    System.out.println("Decoding ICO file '"+strInFile+"'.");
    /***** reload BMP images *****/
    
    System.out.println("  reloading BMP files:");
    java.awt.image.BufferedImage image = net.sf.image4j.codec.bmp.BMPDecoder.read(inFile);
    System.out.println("BMP decoding...OK");
    /*****  encode images and save as ICO  *****/
    
    System.out.println("Encoding ICO file '"+strOutFile+"'.");
    java.io.File outFile = new java.io.File(strOutFile);
    net.sf.image4j.codec.bmp.BMPEncoder.write(image, new File("out2.bmp"));
    System.out.println("ICO encoding...OK");
    
  }
  
  private static void usage() {
    
  }
  
}
