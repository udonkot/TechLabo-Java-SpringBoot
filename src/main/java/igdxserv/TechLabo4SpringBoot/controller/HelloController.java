package igdxserv.TechLabo4SpringBoot.controller;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

@Controller
// @EnableAutoConfiguration
public class HelloController {

  @RequestMapping("/")
  public String home() {
    return "body";
  }

  @RequestMapping("/kondo")
  public String kondo() {
    return "kondo";
  }



  @RequestMapping("/hello")
  public String hello(Model model) {
    model.addAttribute("message", "Hello Thymeleaf ");
    return "hello";
  }
 
  
}
