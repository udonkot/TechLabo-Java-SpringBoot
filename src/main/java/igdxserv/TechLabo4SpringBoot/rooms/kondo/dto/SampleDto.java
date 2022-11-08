package igdxserv.TechLabo4SpringBoot.rooms.kondo.dto;

import java.util.Date;
import java.util.Objects;

public class SampleDto {

    private String text = null;
    private int num  = 0;
    private Long cnt  = 0L;
    private Date regDate = null;
    private boolean isFlg  = false;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Long getCnt() {
        return cnt;
    }

    public void setCnt(Long cnt) {
        this.cnt = cnt;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public boolean isFlg() {
        return isFlg;
    }

    public void setFlg(boolean flg) {
        isFlg = flg;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SampleDto that = (SampleDto) o;
        return num == that.num &&
                isFlg == that.isFlg &&
                Objects.equals(text, that.text) &&
                Objects.equals(cnt, that.cnt) &&
                Objects.equals(regDate, that.regDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(text, num, cnt, regDate, isFlg);
    }
}
