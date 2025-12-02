package com.noobCoder.blog.service;

import com.noobCoder.blog.entity.Blog;
import com.noobCoder.blog.entity.User;
import com.noobCoder.blog.repository.BlogRepository;
import com.noobCoder.blog.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    private BlogRepository blogRepository;

    @Autowired
    private UserRepository userRepository;

    // create blog
    public ResponseEntity<?> createBlog(Blog blog, String userName){
        if(blog != null && userName != null && !userName.isEmpty()){
            User user = userRepository.findByUserName(userName);
            blog.setUser(user);
            blogRepository.save(blog);
            return new ResponseEntity<>(blog,HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Please check the payload",HttpStatus.BAD_REQUEST);
    }

    //Fetch all blog
    public ResponseEntity<?> fetchAllBlog(){
        List<Blog> listOfAllBlog = blogRepository.findAll();
        if(!listOfAllBlog.isEmpty()){
            return new ResponseEntity<>(listOfAllBlog, HttpStatus.OK);
        }
        return new ResponseEntity<>("There is no blog present", HttpStatus.NOT_FOUND);
    }

    //updateBlog
    public ResponseEntity<?> updateBlog(Blog newblog, Long blog_id){
        Optional<Blog> oldBlog = blogRepository.findById(blog_id);
        if(oldBlog.isPresent()){
            Blog updatedBlog = oldBlog.get();
            if(newblog.getTitle() != null && !newblog.getTitle().isBlank()){
                updatedBlog.setTitle(newblog.getTitle());
            }
            if(newblog.getContent()!=null && !newblog.getContent().isBlank()){
                updatedBlog.setContent(newblog.getContent());
            }
            blogRepository.save(updatedBlog);
            return new ResponseEntity<>(updatedBlog, HttpStatus.OK);
        }
        return new ResponseEntity<>("""
                {
                    error: "Invalid Id"
                }
                """, HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<Blog>> fetchBlogByUserName(String userName) {
        List<Blog> listOfBlogByUserName= userRepository.findByUserName(userName).getBlogList();
        return new ResponseEntity<>(listOfBlogByUserName, HttpStatus.OK);
    }
}
