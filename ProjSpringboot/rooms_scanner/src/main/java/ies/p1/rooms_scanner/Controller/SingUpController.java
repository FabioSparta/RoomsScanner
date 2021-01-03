package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class SignUpController {

    private static final Logger log = LoggerFactory.getLogger(SignUpController.class);

    @InitBinder
    public void initBinder(WebDataBinder dataBinder) {
        StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
        dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
    }

    @ResponseBody
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public ModelAndView register() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("register");
        return modelAndView;
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String save(@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "register";
        }
        log.info(">> user : {}", user.toString());
        return "redirect:/login";
    }
}