package app.controller;

import app.model.Fair;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@RestController
@RequestMapping("/")
@AllArgsConstructor
public class BffController {

    @GetMapping("fairs")
    @JsonFormat
    public List<Fair> getFairs() {

        var template = new RestTemplate();

        ResponseEntity<Fair[]> responseEntity = template.getForEntity("http://localhost:9191/fairs", Fair[].class);

        if(responseEntity.getBody() == null){
            System.out.println("Ta nulo :(");
        }

        List<Fair> fairs = Arrays.asList(responseEntity.getBody());

        return fairs;
    }

    @JsonFormat
    @GetMapping("fairs/{weekday}")
    public List<Fair> getAllFairsByWeekday(@PathVariable(value = "weekday") String weekday){
        var template = new RestTemplate();

        ResponseEntity<Fair[]> responseEntity = template.getForEntity("http://localhost:9191/fairs/" + weekday, Fair[].class);

        if(responseEntity.getBody() == null){
            System.out.println("Ta nulo :(");
        }

        List<Fair> fairs = Arrays.asList(responseEntity.getBody());

        return fairs;
    }

}
