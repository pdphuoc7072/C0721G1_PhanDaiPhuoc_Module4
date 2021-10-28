package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @GetMapping("")
    public ModelAndView blog () {
        ModelAndView modelAndView = new ModelAndView("index");
        List<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogList", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveBlog (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveOrUpdate(blog);
        redirectAttributes.addFlashAttribute("message", "New blog was successful saved");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/edit")
    public ModelAndView showEditForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateBlog (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.saveOrUpdate(blog);
        redirectAttributes.addFlashAttribute("message", "New blog was successful updated");
        return "redirect:/blog";
    }

    @GetMapping("/{id}/view")
    public ModelAndView showViewForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("view");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @GetMapping("/{id}/delete")
    public ModelAndView showDeleteForm (@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("delete");
        modelAndView.addObject("blog", blogService.findById(id));
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteBlog (@ModelAttribute Blog blog, RedirectAttributes redirectAttributes) {
        blogService.delete(blog.getId());
        redirectAttributes.addFlashAttribute("message", "New blog was successful deleted");
        return "redirect:/blog";
    }
}
