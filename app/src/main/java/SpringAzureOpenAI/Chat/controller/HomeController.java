package SpringAzureOpenAI.Chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/")
    public String loadHomePage(){
        return "index.html";
    }
}
