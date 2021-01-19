package ies.p1.rooms_scanner;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
public class IndexController {
    @RequestMapping("/")
    public String index( HttpServletResponse httpResponse) throws Exception {
        httpResponse.sendRedirect("/home");
        return "success";
    }
}