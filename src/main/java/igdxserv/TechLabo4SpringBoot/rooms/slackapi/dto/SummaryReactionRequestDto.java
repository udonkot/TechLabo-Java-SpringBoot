package igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto;

/**
 * リアクション集計リクエストDTO
 */
public class SummaryReactionRequestDto {
    private String channelId = "";
    private String month = "0";

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }
}
