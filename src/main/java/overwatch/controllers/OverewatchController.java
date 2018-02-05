package overwatch.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import overwatch.models.Hero;
import overwatch.repositories.HeroRepository;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class OverewatchController {
    @Autowired
    private HeroRepository heroRepository;

    @GetMapping(value = "/heros")
    public List<Hero> getHeroes(){
        return heroRepository.getHeros();
    }
}
