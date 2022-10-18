package igdxserv.TechLabo4SpringBoot.rooms.hello.controller;

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

  // @RequestMapping("/hello")
  // public String hello(Model model) {
  //   model.addAttribute("message", "Hello Thymeleaf ");
  //   return "rooms/template/main";
  // }
 
  
}
