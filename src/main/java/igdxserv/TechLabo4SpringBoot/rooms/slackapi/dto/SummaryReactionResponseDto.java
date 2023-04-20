package igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto;

/**
 * リアクション集計レスポンスDTO
 */
public class SummaryReactionResponseDto {
    private int rank;
    private String reactionName;
    private Object reactionGif;
    private int reactionCnt;

    public int getRank() {
        return rank;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public String getReactionName() {
        return reactionName;
    }

    public void setReactionName(String reactionName) {
        this.reactionName = reactionName;
    }

    public Object getReactionGif() {
        return reactionGif;
    }

    public void setReactionGif(Object reactionGif) {
        this.reactionGif = reactionGif;
    }

    public int getReactionCnt() {
        return reactionCnt;
    }

    public void setReactionCnt(int reactionCnt) {
        this.reactionCnt = reactionCnt;
    }
}
