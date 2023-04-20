package igdxserv.TechLabo4SpringBoot.rooms.kondo.controller.kobayashi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rooms/kobayashi")
public class KobayashiController {

    @RequestMapping("home")
    public String home() {
        return "rooms/kobayashi/main";
    }

}
