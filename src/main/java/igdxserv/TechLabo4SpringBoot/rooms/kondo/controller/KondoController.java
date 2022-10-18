package igdxserv.TechLabo4SpringBoot.rooms.kondo.controller;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

@Controller
// @EnableAutoConfiguration
public class KondoController {
  
  @RequestMapping("/kondo")
  public String hello(Model model) {
    model.addAttribute("message", "Hello Kondo's Page!");
    return "rooms/kondo/main";
  }
 

}
