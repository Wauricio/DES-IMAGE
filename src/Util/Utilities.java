/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import javax.imageio.ImageIO;

/**
 *
 * @author Mauricio
 */
public class Utilities {
    public static Object []readImage(BufferedImage image,String path) throws IOException{
        
      File imagefile = new File(path);
           // image = ImageIO.read(imagefile);
           InputStream in = new FileInputStream(imagefile);
           
           /* 
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write( image, "bmp", baos );
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            baos.close();*/
           
           byte [] in1=new byte[54];
           byte [] in2 = new byte[(int)(imagefile.length()-54)];
           in.read(in1,0,54);
           in.read(in2);
           in.close();
            System.out.println("size: "+in1.length+" sizeFile: "+in2.length); 
            //return SplitArray(imageInByte,54);
            return new Object[]{in1,in2};
   }
    
    public static BufferedImage getImage(String path) throws IOException{

        return   ImageIO.read(new File(path));
            
    }
   
   public static BufferedImage writeImage(byte[]hdr,byte []data ,String path) throws IOException{
     //byte b[]=int_to_byteA(data.length);
       //System.out.println("Datasize in write:"+data.length);
     //hdr[2]=b[0];hdr[3]=b[1];hdr[4]=b[2];hdr[5]=b[3];
       //byte size[]={hdr[2],hdr[3],hdr[4],hdr[5]};
                   
         //9          ByteBuffer bb = ByteBuffer.wrap(size);
            //        bb.order(ByteOrder.LITTLE_ENDIAN);

              //     System.out.println("dataoutto:"+bb.getInt());
       //byte[] imageInByte=concat(hdr,data);
       //System.out.println("Final File Size: "+imageInByte.length);
       //InputStream in = new ByteArrayInputStream(imageInByte);
       File outF=new File(path);
       OutputStream out =new FileOutputStream(outF);
       out.write(hdr);
       out.write(data);
       out.close();
       
       //ImageIO.write(image, "bmp",out);
       return ImageIO.read(outF);
       
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
   
   public static  byte[] int_to_byteA(int myInteger){
    return ByteBuffer.allocate(4).order(ByteOrder.LITTLE_ENDIAN).putInt(myInteger).array();
    }
}
