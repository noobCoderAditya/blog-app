package com.noobCoder.blog.controller;

import com.noobCoder.blog.entity.Blog;
import com.noobCoder.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @PostMapping("/create-blog/{userName}")
    public ResponseEntity<?> createBlog(@RequestBody Blog blog, @PathVariable String userName){
       return blogService.createBlog(blog,userName);
    }

    @GetMapping
    public ResponseEntity<?> getAllBlog(){
        return blogService.fetchAllBlog();
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<Blog>> getBlogByUserName(@PathVariable String userName){
        return blogService.fetchBlogByUserName(userName);
    }

    @PutMapping("/update-blog/{blog_id}")
    public ResponseEntity<?> updateBlog(@RequestBody Blog blog, @PathVariable Long blog_id){
        return blogService.updateBlog(blog, blog_id);
    }
}
