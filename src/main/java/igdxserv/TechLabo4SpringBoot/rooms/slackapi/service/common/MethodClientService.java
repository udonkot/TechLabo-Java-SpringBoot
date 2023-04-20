package igdxserv.TechLabo4SpringBoot.rooms.slackapi.service.common;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import org.springframework.stereotype.Service;

/**
 *
 */
@Service
public class MethodClientService {

    // トークンID
    private final String SLACK_TOKEN = System.getenv("SLACK_TOKEN");

    // slackインスタンス
    private static final Slack slack = Slack.getInstance();

    /**
     * MethodsClientインスタンス返却
     * @return
     */
    public MethodsClient getMethodsClient() {
        return slack.methods();
    }

    /**
     * トークン返却
     * @return
     */
    public String getSlackToken() {
        return SLACK_TOKEN;
    }



}
