package igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto;

import java.util.List;

/**
 * リアクション集計リクエストDTO
 */
public class UserListResponseDto {
    private List<Member> members = null;

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}