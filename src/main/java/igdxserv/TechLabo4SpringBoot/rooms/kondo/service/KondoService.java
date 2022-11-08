package igdxserv.TechLabo4SpringBoot.rooms.kondo.service;

import org.springframework.stereotype.Service;

@Service
public class KondoService implements IKondoService {

    public String getName(String name) {
        return "Kondo".concat(name);
    }
}
