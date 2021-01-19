package ies.p1.rooms_scanner.Controller;
import ies.p1.rooms_scanner.Entities.User;
import ies.p1.rooms_scanner.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<Object> createUser(@RequestBody User user) {
        if (userService.createUser(user)){
            return new ResponseEntity<>("User created successfully", HttpStatus.OK);}
        else
            return  new ResponseEntity<>("A user with the given nmec already exists.", HttpStatus.NOT_ACCEPTABLE);
    }


    @GetMapping("/user")
    public ResponseEntity<Object> Login(@RequestParam String username, @RequestParam String pw) {
        if (userService.exist(username, pw) != null) {
            User u = userService.getUserByUsername(username);
            return new ResponseEntity<>(u, HttpStatus.OK);
        }
        return new ResponseEntity<>("User does not exist", HttpStatus.NOT_ACCEPTABLE);
    }

}
