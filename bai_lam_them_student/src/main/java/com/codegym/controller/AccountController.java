package com.codegym.controller;

import com.codegym.dto.AccountDto;
import com.codegym.model.Account;
import com.codegym.service.IAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/account")
public class AccountController {
    @Autowired
    private IAccountService accountService;

    @GetMapping("")
    public ModelAndView index () {
        ModelAndView modelAndView = new ModelAndView("account/list");
        modelAndView.addObject("accounts", accountService.findByFlag(true));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("account/create");
        modelAndView.addObject("accountDto", new AccountDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("accountDto") AccountDto accountDto, BindingResult bindingResult) {
        boolean checkUsername = true;
        accountDto.setAccounts(accountService.findAll());
        accountDto.setCheckUsername(checkUsername);
        accountDto.validate(accountDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            return "account/create";
        } else {
            Account account = new Account();
            BeanUtils.copyProperties(accountDto, account);
            account.setFlag(false);
            accountService.save(account);
            return "redirect:/account";
        }
    }
}
