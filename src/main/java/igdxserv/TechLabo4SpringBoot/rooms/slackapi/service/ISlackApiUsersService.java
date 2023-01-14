package igdxserv.TechLabo4SpringBoot.rooms.slackapi.service;

import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.Member;

import java.util.List;

public interface ISlackApiUsersService {
    public List<Member> getUserList();
}
