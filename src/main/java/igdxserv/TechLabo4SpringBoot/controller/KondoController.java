package igdxserv.TechLabo4SpringBoot.controller;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

@Controller
@RequestMapping("/kondo")
// @EnableAutoConfiguration
public class KondoController {
  
  @RequestMapping("/hoge")
  public String hello(Model model) {
    model.addAttribute("message", "Hello Thymeleaf ");
    return "hello";
  }
 

}
