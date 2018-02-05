package overwatch.repositories;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Repository;
import overwatch.OverwatchProperties;
import overwatch.models.Hero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class HeroRepositoryImpl implements HeroRepository{

    private RestTemplate restTemplate;

    @Value("${url}")
    private String url;

    @Autowired
    public HeroRepositoryImpl(RestTemplateBuilder restTemplateBuilder){
        this.restTemplate = restTemplateBuilder.build();
    }

    @Override

    public List<Hero> getHeros() {
        String json = restTemplate.getForObject(url + "/hero/", String.class);

        Map<String,String> map;
        List<Hero> heroes;

        ObjectMapper mapper = new ObjectMapper();

        try {
            map = mapper.readValue(json, new TypeReference<HashMap<String,String>>(){});
            String data = map.get("data");
            heroes = mapper.readValue(data, new TypeReference<ArrayList<Hero>>(){});
            return heroes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
