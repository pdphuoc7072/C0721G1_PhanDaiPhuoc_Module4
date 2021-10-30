package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.Category;
import com.codegym.service.IBlogService;
import com.codegym.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("/blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveBlog (@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "New blog was successful created");
        return "redirect:/blog";
    }

    @GetMapping("")
    public ModelAndView listBlog (@RequestParam ("search") Optional<String> search,
                                  @PageableDefault (size = 5) Pageable pageable) {
        Page<Blog> blogs;
        if (search.isPresent()) {
            blogs = blogService.findAllByTitleContaining(search.get(), pageable);
        } else {
            blogs = blogService.findAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("/blog/list");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("categories", categoryService.findAll());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
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

    @PostMapping("/update")
    public String updateBlog(@ModelAttribute("blog") Blog blog, RedirectAttributes redirectAttributes) {
        blogService.save(blog);
        redirectAttributes.addFlashAttribute("message", "The blog was successful updated");
        return "redirect:/blog";
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Long idBlog, RedirectAttributes redirectAttributes) {
        blogService.remove(idBlog);
        redirectAttributes.addFlashAttribute("message", "The blog was successful deleted");
        return "redirect:/blog";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultipleBlog(@RequestParam String idBlogMultiple, RedirectAttributes redirectAttributes) {
        String[] idBlogMultipleArray = idBlogMultiple.split(",");
        for (int i = 0; i < idBlogMultipleArray.length; i++) {
            categoryService.remove(Long.valueOf(idBlogMultipleArray[i]));
        }
        redirectAttributes.addFlashAttribute("message", "The multiple blog was successful deleted");
        return "redirect:/blog";
    }

    @GetMapping("/view-category")
    public ModelAndView viewCategory (@RequestParam Long idCategory) {
        Optional<Category> categoryOptional = categoryService.findById(idCategory);
        if(!categoryOptional.isPresent()){
            return new ModelAndView("/error.404");
        }

        Iterable<Blog> blogs = blogService.findAllByCategory(categoryOptional.get());

        ModelAndView modelAndView = new ModelAndView("/blog/view-category");
        modelAndView.addObject("blogs", blogs);
        modelAndView.addObject("category", categoryOptional.get());
        return modelAndView;
    }

    @PostMapping("/sort")
    public ModelAndView sortBlogByCreateDay (@RequestParam ("sortByCreateDay") String sortByCreateDay, Pageable pageable) {
        ModelAndView modelAndView = null;
        Page<Blog> blogs;
        if (!sortByCreateDay.isEmpty())
        switch (sortByCreateDay) {
            case "Asc":
                blogs = blogService.findAllByOrderByCreateDayAsc(pageable);
                modelAndView = new ModelAndView("/blog/sort");
                modelAndView.addObject("blogs", blogs);
                break;
            case "Desc":
                blogs = blogService.findAllByOrderByCreateDayDesc(pageable);
                modelAndView = new ModelAndView("/blog/sort");
                modelAndView.addObject("blogs", blogs);
            break;
        }
        return modelAndView;
    }

    @GetMapping("/view-detail/{id}")
    public ModelAndView viewDetailCategory (@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("/blog/view-detail");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }
}
