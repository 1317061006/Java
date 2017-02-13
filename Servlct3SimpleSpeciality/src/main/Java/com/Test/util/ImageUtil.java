package com.Test.util;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * Created by han on 2016/11/19.
 */
public class ImageUtil {

    private static ImageUtil imageUtil = new ImageUtil();

    private ImageUtil (){

    }

    public static  ImageUtil getInstance() {
        return imageUtil;
    }

    public  void saveImage(String filename,MultipartFile image){

        try {
            String file="D://测试//" + filename+".jpg";
            File Tfile = new File(file);
//            FileUtils.writeByteArrayToFile(file, image.getBytes());
            image.transferTo(Tfile);//，MultipartFile还提供了一个便利的transferTo()方法
            // ，它能够帮助我们将 上传的文件写入到文件系统中。
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public  void saveImage(String filename,Part image){

        try {
            String file="D://测试//" + filename+".jpg";
            File Tfile = new File(file);
//            FileUtils.writeByteArrayToFile(file, image.getBytes());
            image.write(file);//，，write()对应于transferTo()，借助该方法我们能够将上传的文件写入文件系统中：
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
