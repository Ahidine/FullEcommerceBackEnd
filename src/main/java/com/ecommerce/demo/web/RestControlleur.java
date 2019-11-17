package com.ecommerce.demo.web;

import com.ecommerce.demo.dao.ProductRespository;
import com.ecommerce.demo.entites.Product;
import javafx.scene.media.Media;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Files;
import java.nio.file.Paths;
@CrossOrigin("*")
@RestController
public class RestControlleur  {
    @Autowired
    ProductRespository prod;
@GetMapping(path = "/productPhoto/{id}", produces = MediaType.IMAGE_PNG_VALUE)
    public byte[]  getPhoto(@PathVariable("id") Long id) throws Exception
    {
        Product p = prod.findById(id).get();
       // System.out.println(System.getProperty("user.home"));
        return Files.readAllBytes(Paths.get(System.getProperty("user.home")+"/Documents/images/"+p.getPhotoName()));
    }
    @PostMapping(path = "/uploadPhoto/{id}")
    public void uploadPhoto( MultipartFile file , @PathVariable Long id) throws Exception{
            Product p = prod.findById(id).get();
            p.setPhotoName(id+".png");
            System.out.println(file);
            Files.write(Paths.get(System.getProperty("user.home")+"/Documents/images/"+p.getPhotoName()),file.getBytes());
            prod.save(p);
    }
}
