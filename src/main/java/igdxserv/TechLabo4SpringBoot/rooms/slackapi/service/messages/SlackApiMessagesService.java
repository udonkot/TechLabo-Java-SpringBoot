package igdxserv.TechLabo4SpringBoot.rooms.slackapi.service.messages;

import com.slack.api.Slack;
import com.slack.api.methods.MethodsClient;
import com.slack.api.methods.SlackApiException;
import com.slack.api.methods.response.users.UsersListResponse;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.Member;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.MemberProfile;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.service.common.MethodClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class SlackApiMessagesService implements ISlackApiMessagesService {

    @Autowired
    MethodClientService methodClientService;

    /**
     * メッセージ送信
     * @param channelId チャンネルID
     * @param message 送信するメッセージ
     * @throws SlackApiException
     * @throws IOException
     */
    @Override
    public void sendMessage( String channelId, String message) throws SlackApiException, IOException {
        // パラメータ未指定時は送信しない
        if(StringUtils.isEmpty(channelId) || StringUtils.isEmpty(message)) {
            return;
        }

        MethodsClient client = methodClientService.getMethodsClient();
        client.chatPostMessage(r ->
            r.token(methodClientService.getSlackToken()).channel(channelId).text(message)
        );

    }
}

