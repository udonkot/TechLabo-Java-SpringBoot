package igdxserv.TechLabo4SpringBoot.rooms.kondo.dto;

public class SampleDtoEx extends SampleDto{
    private String id = null;

    private int score= 0;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
