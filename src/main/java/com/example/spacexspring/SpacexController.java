package com.example.spacexspring;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping(path="capsules")
public class SpacexController {
    private static final String POSTS_API_URL = "https://api.spacexdata.com/v4/capsules";
    private final SpacexService spacexService;


    @Autowired
    public SpacexController(SpacexService spacexService){
        this.spacexService = spacexService;
    }

    //http://localhost:8080/capsules
    @GetMapping
    public List<Dates> getDates() throws IOException, InterruptedException {
        //receiving data using the Http client
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder().GET().uri(URI.create(POSTS_API_URL)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());


        //Parse JSON into objects
        ObjectMapper mapper = new ObjectMapper();
        List<Capsules> posts = mapper.readValue(response.body(), new TypeReference<List<Capsules>>() {
        });


        return spacexService.getDates(posts);
    }

}
