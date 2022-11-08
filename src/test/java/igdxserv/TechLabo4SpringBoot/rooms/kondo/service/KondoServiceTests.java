package igdxserv.TechLabo4SpringBoot.rooms.kondo.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class KondoServiceTests {

    @Autowired
    IKondoService kondoService;

    @Test
    public void Test01() {
        String ret = kondoService.getName(" Test!");
        assertThat(ret).isEqualTo("Kondo Test!");
    }
}
