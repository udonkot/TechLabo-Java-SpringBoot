package igdxserv.TechLabo4SpringBoot.rooms.kondo.controller;

//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import igdxserv.TechLabo4SpringBoot.rooms.kondo.dto.SampleDto;
import igdxserv.TechLabo4SpringBoot.rooms.kondo.service.IKondoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
// import org.springframework.web.bind.annotation.RestController;

@Controller
// @EnableAutoConfiguration
public class KondoController {

    @Autowired
    IKondoService kondoService;

    @RequestMapping("/kondo")
    public String kondo(Model model) {
        String name = kondoService.getName(" Page!");
        String message = "Hello ".concat(name);
        model.addAttribute("message", message);
        return "rooms/kondo/main";
    }

    @RequestMapping("/kondo/list")
    public String list(Model model) {
        List<SampleDto> sampleDtoList = new ArrayList<>();

        sampleDtoList.add(createData("data1", 10, 1000, true));
        sampleDtoList.add(createData("data2", 50, 500, true));
        sampleDtoList.add(createData("data3", 30, 700, false));

        model.addAttribute("sampleList", sampleDtoList);
        return "rooms/kondo/list";
    }

    private SampleDto createData(String text, int num, long cnt, boolean flg) {
        SampleDto sampleData = new SampleDto();
        sampleData.setText(text);
        sampleData.setCnt(cnt);
        sampleData.setNum(num);
        sampleData.setFlg(flg);
        sampleData.setRegDate(new Date());

        return sampleData;
    }
}
