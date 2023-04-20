package igdxserv.TechLabo4SpringBoot.rooms.slackapi.service.messages;

import com.slack.api.methods.SlackApiException;
import igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto.Member;

import java.io.IOException;
import java.util.List;

public interface ISlackApiMessagesService {
    /** メッセージ送信 */
    public void sendMessage( String channelId, String message) throws SlackApiException, IOException;
}
