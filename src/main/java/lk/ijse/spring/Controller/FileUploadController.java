package lk.ijse.spring.Controller;


import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;

@RestController
//@MultipartConfig
@RequestMapping("/api/vt/upload")
public class FileUploadController {
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFile(@RequestParam("myFile") MultipartFile myFile) {
        /*
         * There are three ways we can obtain this value, but in all cases we need to use
         * @RequestPart annotation.
         * 1. Byte Array ( byte [] )
         * 2. MultipartFile ( Spring way )
         * 3. Part ( Java EE way )
         */
        //  01.First we need to configure MultipartResolver
        //  02.We need to override  method inorder to set MultipartConfigElement
        //  Check WebAppConfig and WebAppInitializer
        //  In spring boot we dont need to add those two configurations
        System.out.println("hello");
        System.out.println(myFile.getOriginalFilename());;

        try {
            // Let's get the project location
            String projectPath = new File(this.getClass().getProtectionDomain().getCodeSource().getLocation().toURI()).getParentFile().getParentFile().getAbsolutePath();
            // Let's create a folder there for uploading purposes, if not exists
            File uploadsDir = new File(projectPath + "/uploads");
            uploadsDir.mkdir();
            // It is time to transfer the file into the newly created dir
            myFile.transferTo(new File(uploadsDir.getAbsolutePath() + "/" + myFile.getOriginalFilename()));
            return true;
        } catch (URISyntaxException e) {
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }

    }
}
