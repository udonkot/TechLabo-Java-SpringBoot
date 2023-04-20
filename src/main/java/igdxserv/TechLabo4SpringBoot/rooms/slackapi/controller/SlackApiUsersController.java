package igdxserv.TechLabo4SpringBoot.rooms.slackapi.controller;

import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.*;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.service.ISlackApiUsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rooms/slackapi/users")
public class SlackApiUsersController {

    @Autowired
    private ISlackApiUsersService slackApiUsersService;

    @RequestMapping(value = "list", method = RequestMethod.GET)
    public String list(Model model) {

        List<Member> userList = slackApiUsersService.getUserList();
        model.addAttribute("members", userList);

        return "rooms/slackapi/users/userlist";
    }

}
