package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.User;
import ies.p1.rooms_scanner.Service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

public class AccountController {

    private static final Logger log = LoggerFactory.getLogger(AccountController.class);
    private final UserService userService;

    @Autowired
    public AccountController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);
        return "register";
    }

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @PostMapping("/register")
    public String save(@Valid User user, BindingResult bindingResult, RedirectAttributes rA) {

        //check if the user exists
        if(userService.userExists((User.getEmail()))) {
            bindingResult.addError(new FieldError("user", "email"));
        }

        if(bindingResult.hasErrors()) {
            return "register";
        }
        //log.info("user: {}", user.toString());
        rA.addFlashAttribute("message", "Your registration is now complete!")
        userService.register(user);
        return "redirect:/login";
    }
}
