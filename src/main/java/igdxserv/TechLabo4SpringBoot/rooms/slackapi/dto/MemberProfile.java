package igdxserv.TechLabo4SpringBoot.rooms.slackapi.dto;

public class MemberProfile {
    private String display_name = "";
    private String status_text = "";

    public String getDisplay_name() {
        return display_name;
    }

    public void setDisplay_name(String display_name) {
        this.display_name = display_name;
    }

    public String getStatus_text() {
        return status_text;
    }

    public void setStatus_text(String status_text) {
        this.status_text = status_text;
    }
}
