package igdxserv.TechLabo4SpringBoot.rooms.kondo.trial;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.jupiter.api.Assertions.*;

/**
 * お試し
 */
class TrialTest {
    @Autowired
    Trial trial;

    @Test
    void getNewText() {
    }

    /**
     * trial001のテスト
     */
    @Test
    void trial001Test() {
        Trial trial = new Trial();
        trial.trial001();
    }

    /**
     * trial099のテスト
     */
    @Test
    void trial099Test() {
        Trial trial = new Trial();
    }


}