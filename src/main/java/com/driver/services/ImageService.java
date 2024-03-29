package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    @Autowired
    ImageRepository imageRepository2;
    @Autowired
    BlogRepository blogRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        Blog blog=blogRepository2.findById(blogId).get();
        Image image=new Image( blog,description,dimensions);
//        image.setBlog(blog);
//        image.setDescription(description);
//        image.setDimensions(dimensions);
//        //imageRepository.save(image);

        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return image;
        //create an image based on given parameters and add it to the imageList of given blog
    }

    public void deleteImage(int id){
        imageRepository2.deleteById(id);
    }

//    public Image findById(int id) {
//
//    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        String [] scrarray = screenDimensions.split("X"); //A=Length   X    B=Breadth
//        if(!imageRepository2.findById(id).isPresent()){
//            throw new Exception();
//        }
        Image image = imageRepository2.findById(id).get();

        String imageDimensions = image.getDimensions();
        String [] imgarray = imageDimensions.split("X");

        int scrl = Integer.parseInt(scrarray[0]); //A -- > integer
        int scrb = Integer.parseInt(scrarray[1]); //B -- > integer

        int imgl = Integer.parseInt(imgarray[0]); //A -- > integer
        int imgb = Integer.parseInt(imgarray[1]); //B -- > integer

        return no_Images(scrl,scrb,imgl,imgb);
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        //In case the image is null, return 0

    }
    private int no_Images(int scrl, int scrb, int imgl, int imgb) {
        int lenC = scrl/imgl; //
        int lenB = scrb/imgb;
        return lenC*lenB;
    }
}
