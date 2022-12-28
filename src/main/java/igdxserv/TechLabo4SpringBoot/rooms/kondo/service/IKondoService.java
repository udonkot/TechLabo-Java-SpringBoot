package igdxserv.TechLabo4SpringBoot.rooms.kondo.service;

import igdxserv.TechLabo4SpringBoot.rooms.kondo.record.SlackChannelRerocd;

import java.util.List;

public interface IKondoService {
    public String getName(String name);
    public List<SlackChannelRerocd> getChannlelList();
}
