package ies.p1.rooms_scanner.Controller;

import ies.p1.rooms_scanner.Entities.ConfirmationToken;
import ies.p1.rooms_scanner.Entities.User;
import ies.p1.rooms_scanner.Service.ConfirmationTokenService;
import ies.p1.rooms_scanner.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
@AllArgsConstructor
public class UserController {

    private final UserService userService;

    private final ConfirmationTokenService confirmationTokenService;

    @GetMapping("/sign-in")
    String signIn() {
        return "sign-in";
    }

    @GetMapping("/sign-up")
    String signUp() {
        return "sign-up";
    }

    @PostMapping("/sign-up")
    String signUp(User user) {
        userService.signUpUser(user);
        return "redirect:/sign-in";
    }

    @GetMapping("/confirm")
    String confirmMail(@RequestParam("token") String token) {
        Optional<ConfirmationToken> optionalConfirmationToken = confirmationTokenService.findConfirmationTokenByToken(token);
        optionalConfirmationToken.ifPresent(userService::confirmUser);
        return "/sign-in";
    }

}
