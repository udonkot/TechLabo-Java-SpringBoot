package igdxserv.TechLabo4SpringBoot.rooms.dxservice.controller;

import igdxserv.TechLabo4SpringBoot.rooms.dxservice.task.scheduled.DxServiceScheduledTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("rooms/dxservice")
public class DxServiceController {

    @Autowired
    DxServiceScheduledTask dxServiceScheduledTask;

    @RequestMapping("whatsnew")
    public void whatsnew(Model model) {
        dxServiceScheduledTask.sendPortalWhatNew();
    }

}
