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
    BlogRepository blogRepository;

    @Autowired
    ImageService imageService;

    @Autowired
    UserRepository userRepository;

//    public List<Blog> showBlogs(){
//        //find all blogs
//
//    }

    public Blog createAndReturnBlog(Integer userId, String title, String content) {
        //create a blog at the current time
        User user = userRepository.findById(userId).get();
        Blog blog=new Blog();
        blog.setUser(user);
//        blog.setBlogId(userId);
        blog.setContent(content);
        blog.setPubDate(new Date());
        blog.setTitle(title);

        userRepository.save(user);
        user.getBlogList().add(blog);

        blogRepository.save(blog);
        return blog;

        //updating the blog details

        //Updating the userInformation and changing its blogs

    }

//    public Blog findBlogById(int blogId){
//        //find a blog
//    }

//    public void addImage(Integer blogId, String description, String dimensions){
//
//        //add an image to the blog after creating it
//    }

    public void deleteBlog(int blogId){
        blogRepository.deleteById(blogId);
        //delete blog and corresponding images
    }

//    public int numberOfBlog(ResponseEntity<Integer> allBlogs) {
//        return blogRepository.
//    }
}
