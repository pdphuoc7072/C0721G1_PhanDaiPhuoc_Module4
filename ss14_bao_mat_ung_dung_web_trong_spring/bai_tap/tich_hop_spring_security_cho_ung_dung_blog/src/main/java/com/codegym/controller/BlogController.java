package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories () {
        return categoryService.findAll();
    }

    @GetMapping("/user")
    public ModelAndView user(Principal principal) {
        return listBlog();
    }

    @GetMapping("/user/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/user/save")
    public String saveBlog (@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog was successful created");
        return "redirect:/blog/user";
    }

    @GetMapping("")
    public ModelAndView listBlog () {
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogService.findAll());
        return modelAndView;
    }

    @GetMapping("/user/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView;
        if (blog.isPresent()) {
            modelAndView = new ModelAndView("/blog/edit");
            modelAndView.addObject("blog", blog.get());
        } else {
            modelAndView = new ModelAndView("/error.404");
        }
        return modelAndView;
    }

    @PostMapping("/user/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "The blog was successful updated");
        return "redirect:/blog/user";
    }

    @PostMapping("/user/delete")
    public String deleteBlog(@RequestParam Long idBlog, RedirectAttributes redirectAttributes) {
        blogService.remove(idBlog);
        redirectAttributes.addFlashAttribute("message", "The blog was successful deleted");
        return "redirect:/blog/user";
    }

    @GetMapping("/view-detail/{id}")
    public ModelAndView viewDetailCategory (@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/view-detail");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }
}
