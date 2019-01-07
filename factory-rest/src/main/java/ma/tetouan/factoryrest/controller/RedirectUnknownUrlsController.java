package ma.tetouan.factoryrest.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RedirectUnknownUrlsController implements ErrorController {
	
    @GetMapping("/error")
    public void redirectNonExistentUrlsToHome(HttpServletResponse response) throws IOException {
        response.sendRedirect("/");
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

}