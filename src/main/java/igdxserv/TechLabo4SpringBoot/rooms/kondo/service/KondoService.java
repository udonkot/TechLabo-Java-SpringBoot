package igdxserv.TechLabo4SpringBoot.rooms.kondo.service;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.response.conversations.ConversationsListResponse;
import igdxserv.TechLabo4SpringBoot.rooms.kondo.record.SlackChannelRerocd;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KondoService implements IKondoService {

    // トークンID取得
    private static final String SLACK_TOKEN = System.getenv("SLACK_TOKEN");

    public String getName(String name) {
        return "Kondo".concat(name);
    }

    /**
     * チャンネル一覧取得
     *
     * @return
     */
    public List<SlackChannelRerocd> getChannlelList() {
        // slackインスタンス作成
        Slack slack = Slack.getInstance();

        // レスポンスのRecord格納用
        List<SlackChannelRerocd> responseList = new ArrayList<>();
        JSONObject json = new JSONObject();

        try {
            // slackクライアント取得
            MethodsClient client = slack.methods();
            ConversationsListResponse res = client.conversationsList(r -> r.token(SLACK_TOKEN));

            res.getChannels().stream().forEach(conv -> {
                // レスポンスデータセット
                SlackChannelRerocd wrkObj = new SlackChannelRerocd(conv.getId(), conv.getName());
                responseList.add(wrkObj);
            });
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Recordを文字列に変換して返却
        return responseList;

    }

}
