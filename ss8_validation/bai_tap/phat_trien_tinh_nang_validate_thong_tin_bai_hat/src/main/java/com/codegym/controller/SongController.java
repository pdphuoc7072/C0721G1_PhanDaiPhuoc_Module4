package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("/the-song")
public class SongController {
    @Autowired
    private ISongService songService;

    @GetMapping("")
    public ModelAndView listSong () {
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("songs", songService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("song", new Song());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveSong (@Valid @ModelAttribute Song song, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/create";
        } else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "The song was successful created.");
            return "redirect:/the-song";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm (@PathVariable Long id) {
        Optional<Song> song = songService.findById(id);
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("song", song.get());
        return modelAndView;
    }

    @PostMapping("/update")
    public String updateSong (@Valid @ModelAttribute Song song, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        new Song().validate(song, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "/edit";
        } else {
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "The song was successful updated.");
            return "redirect:/the-song";
        }
    }

    @PostMapping("/delete")
    public String deleteBlog(@RequestParam Long idSong, RedirectAttributes redirectAttributes) {
        songService.remove(idSong);
        redirectAttributes.addFlashAttribute("message", "The song was successful deleted");
        return "redirect:/the-song";
    }

    @PostMapping("/deleteMultiple")
    public String deleteMultipleBlog(@RequestParam String idSongMultiple, RedirectAttributes redirectAttributes) {
        String[] idSongMultipleArray = idSongMultiple.split(",");
        for (int i = 0; i < idSongMultipleArray.length; i++) {
            songService.remove(Long.valueOf(idSongMultipleArray[i]));
        }
        redirectAttributes.addFlashAttribute("message", "The multiple song was successful deleted");
        return "redirect:/the-song";
    }

}
