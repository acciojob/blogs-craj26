package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.models.User;
import com.driver.repositories.BlogRepository;
import com.driver.repositories.ImageRepository;
import com.driver.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class BlogService {
    @Autowired
    BlogRepository blogRepository1;

    @Autowired
    UserRepository userRepository1;

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        User user = userRepository1.findById(userId).get();
        Blog blog = new Blog(user,title,content);
        blog.setPubDate(new Date());
        userRepository1.save(user); //Blog saved in repo by cascading
        user.getBlogList().add(blog);
        return blog;

    }

    public void deleteBlog(int blogId){
        //delete blog and corresponding images
        blogRepository1.deleteById(blogId);
    }



//    @Autowired
//    BlogRepository blogRepository1;
//
//    @Autowired
//    UserRepository userRepository1;
//
////    public List<Blog> showBlogs(){
////        //find all blogs
////
////    }
//
//    public Blog createAndReturnBlog(Integer userId, String title, String content) {
//        //create a blog at the current time
//        User user = userRepository1.findById(userId).get();
//        Blog blog=new Blog(user,title,content);
//        blog.setPubDate(new Date());
//        userRepository1.save(user);
//        user.getBlogList().add(blog);
//
//        //blogRepository.save(blog);
//        return blog;
//
//        //updating the blog details
//
//        //Updating the userInformation and changing its blogs
//
//    }
//
////    public Blog findBlogById(int blogId){
////        //find a blog
////    }
//
////    public void addImage(Integer blogId, String description, String dimensions){
////
////        //add an image to the blog after creating it
////    }
//
//    public void deleteBlog(int blogId){
//        blogRepository1.deleteById(blogId);
//        //delete blog and corresponding images
//    }
//
////    public int numberOfBlog(ResponseEntity<Integer> allBlogs) {
////        return blogRepository.
////    }
}
