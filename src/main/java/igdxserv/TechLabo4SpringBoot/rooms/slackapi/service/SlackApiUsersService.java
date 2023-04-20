package igdxserv.TechLabo4SpringBoot.rooms.slackapi.service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.response.users.UsersListResponse;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.Member;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.MemberProfile;
import org.json.JSONObject;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SlackApiUsersService implements ISlackApiUsersService{

    // トークンID取得
    private static final String SLACK_TOKEN = System.getenv("SLACK_TOKEN");

    @Override
    public List<Member> getUserList() {

        // slackインスタンス作成
        Slack slack = Slack.getInstance();

        // レスポンスのJSONデータ格納用
        List<Member> usersList = new ArrayList<>();

        try {
            // slackクライアント取得
            MethodsClient client = slack.methods();
            UsersListResponse res = client.usersList(r -> r.token(SLACK_TOKEN));

            res.getMembers().stream().filter(m -> !m.isDeleted()).forEach(member -> {
                // レスポンスデータセット
                Member wrkMember = new Member();
                wrkMember.setId(member.getId());
                wrkMember.setName(member.getName());
                wrkMember.setReal_name(member.getRealName());

                MemberProfile wrkProfile = new MemberProfile();
                wrkProfile.setDisplay_name(member.getProfile().getDisplayName());
                wrkProfile.setStatus_text(member.getProfile().getStatusText());

                wrkMember.setProfile(wrkProfile);
                usersList.add(wrkMember);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

//         //dummy data for debug
//        List<Member> userList = createDummyList();
//        userList.add(createDummyData("1","hoge","real hoge", "display hoge", "statusOK"));
//        userList.add(createDummyData("2","moge","real moge", "display moge", "statusNG"));
//        userList.add(createDummyData("3","piyo","real piyo", "display piyo", "status??"));

        return usersList;
    }

    private List<Member> createDummyList() {
        List<Member> userList = new ArrayList<>();

        return userList;
    }

    private Member createDummyData(String id,String name,String realName,String displayName, String statusText) {

        MemberProfile memberProfile = new MemberProfile();
        memberProfile.setDisplay_name(displayName);
        memberProfile.setStatus_text(statusText);

        Member dto = new Member();
        dto.setId(id);
        dto.setName(name);
        dto.setReal_name(realName);
        dto.setProfile(memberProfile);
        return dto;
    }

}

