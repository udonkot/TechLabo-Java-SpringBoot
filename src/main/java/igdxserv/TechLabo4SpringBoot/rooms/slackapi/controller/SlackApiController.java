package igdxserv.TechLabo4SpringBoot.rooms.slackapi.controller;

import igdxserv.TechLabo4SpringBoot.rooms.kondo.record.SlackChannelRerocd;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.SummaryReactionRequestDto;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.SummaryReactionResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("rooms/slackapi")
public class SlackApiController {

    @RequestMapping("home")
    public String home() {
        return "rooms/slackapi/main";
    }

    @RequestMapping(value = "reaction/init")
    public String init(SummaryReactionRequestDto requestDto, Model model) {
        System.out.println("start init");
        model.addAttribute("requestDto", requestDto);
        return "rooms/slackapi/reaction/summary";
    }

    @RequestMapping(value = "reaction/summary", method = RequestMethod.POST)
    public String summary(@ModelAttribute SummaryReactionRequestDto requestDto, Model model) {
        System.out.println("start summary");
        String channelId = requestDto.getChannelId();
        if(channelId == null) {
            channelId = "";
        }
        String month = requestDto.getMonth();
        if(month == null) {
            month = "0";
        }

        List<SummaryReactionResponseDto> reactionList = createDummyList();
        reactionList.add(createDummyData(1,"hoge",100));
        reactionList.add(createDummyData(2,"piyo",50));
        reactionList.add(createDummyData(3,"huga",30));
        reactionList.add(createDummyData(99,channelId, Integer.parseInt(month)));
        model.addAttribute("reactionList", reactionList);
        model.addAttribute("requestDto", requestDto);

        return "rooms/slackapi/reaction/summary";
    }

    private List<SummaryReactionResponseDto> createDummyList() {
        List<SummaryReactionResponseDto> reactionList = new ArrayList<>();

        return reactionList;
    }

    private SummaryReactionResponseDto createDummyData(int rank, String name, int cnt) {

        SummaryReactionResponseDto dto = new SummaryReactionResponseDto();
        dto.setRank(rank);
        dto.setReactionName(name);
        dto.setReactionCnt(cnt);

        return dto;
    }


}
