package igdxserv.TechLabo4SpringBoot.rooms.kondo.controller;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import igdxserv.TechLabo4SpringBoot.rooms.kondo.service.IKondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

@Controller
// @EnableAutoConfiguration
public class KondoController {

    @Autowired
    IKondoService kondoService;

    @RequestMapping("/kondo")
    public String hello(Model model) {
        String name = kondoService.getName();
        String message = "Hello ".concat(name).concat(" Page!");
        System.out.println(message);
        model.addAttribute("message", message);
        return "rooms/kondo/main";
    }

}
