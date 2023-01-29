package igdxserv.TechLabo4SpringBoot.rooms.hazama.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rooms/hazama")
public class HazamaController {

    @RequestMapping("home")
    public String home() {
        return "rooms/hazama/main";
    }

}
