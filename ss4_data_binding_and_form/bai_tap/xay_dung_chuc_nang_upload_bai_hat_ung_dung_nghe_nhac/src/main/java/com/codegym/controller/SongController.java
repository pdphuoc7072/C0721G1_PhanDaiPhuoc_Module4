package com.codegym.controller;

import com.codegym.model.Song;
import com.codegym.model.SongForm;
import com.codegym.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping ("/song")
public class SongController {
    @Autowired
    private ISongService songService;

    @Value("${song-upload}")
    private String songUpload;

    @GetMapping ("")
    public String index (Model model) {
        List<Song> songList = songService.findAll();
        model.addAttribute("songList", songList);
        return "index";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm () {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("songForm", new SongForm());
        modelAndView.addObject("kindOfMusicArray",
                new String[] {"Nhạc trẻ", "Nhạc thiếu nhi", "Nhạc quốc tế", "Nhạc Bolero", "Nhạc không lời", "Nhạc rap"});
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveSong(@ModelAttribute SongForm songForm, RedirectAttributes redirectAttributes) {
        MultipartFile multipartFile = songForm.getSongPath();
        String songFileName = multipartFile.getOriginalFilename();
        String[] array = songFileName.split("\\.");
        if (array[1].equals("mp3") || array[1].equals("wav") || array[1].equals("ogg") || array[1].equals("m4p")) {
            try {
                FileCopyUtils.copy(songForm.getSongPath().getBytes(), new File(songUpload + songFileName));
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            Song song = new Song(songForm.getName(), songForm.getArtist(), songForm.getKindOfMusic(), songFileName);
            songService.save(song);
            redirectAttributes.addFlashAttribute("message", "Create new song successful");
        } else {
            redirectAttributes.addFlashAttribute("message", "Create new song error");
        }
        return "redirect:/song";
    }
}
