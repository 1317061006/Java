package com.utils;

import com.Exception.ImageUploadException;
import org.apache.commons.io.FileUtils;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.security.RolesAllowed;
import java.io.File;
import java.io.IOException;

/**
 * Created by han on 2016/9/9.
 */
@Component
public class imageUtiles {


    public void validateImage(MultipartFile image) throws ImageUploadException {

        if (!image.getContentType().equals("image/jpeg")) {
            throw new ImageUploadException("Only jpg image accpted");
        }
    }

   @PreAuthorize("(hasRole('ROLE_USER') and #filename.length() <=10)"+"or hasRole('ROLE_ADMIN')")

     public void saveImage(String filename, MultipartFile image) throws ImageUploadException {
        try {
            File file = new File("D://" + filename+".jpg");
            FileUtils.writeByteArrayToFile(file, image.getBytes());

        } catch (IOException e) {
            throw new ImageUploadException("Unable to save image ", e);
        }

    }

          @PostAuthorize("returnObject =='ceshi'")
         public  String ceshi() {
           return "ceshi";
        }


}
