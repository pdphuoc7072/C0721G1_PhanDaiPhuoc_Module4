package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private IBlogService blogService;

    @GetMapping
    public ModelAndView index(@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs;
        ModelAndView modelAndView = new ModelAndView("index");
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContains(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("search", search);
        modelAndView.addObject("title", "List of Blogs");
        return modelAndView;
    }

    @GetMapping(value = "search", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public Page<Blog> findAllByTitleContains(@RequestParam("search") Optional<String> search, @PageableDefault(value = 3) Pageable pageable) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContains(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        return blogs;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> showBlog(@PathVariable("id") Long id) {
        Blog blog = blogService.findById(id);
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }
}
