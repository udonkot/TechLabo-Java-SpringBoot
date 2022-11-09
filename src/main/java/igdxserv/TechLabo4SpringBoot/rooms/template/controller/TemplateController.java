package igdxserv.TechLabo4SpringBoot.rooms.template.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rooms/template")
public class TemplateController {

    @RequestMapping("home")
    public String home() {
        return "rooms/template/main";
    }

}
