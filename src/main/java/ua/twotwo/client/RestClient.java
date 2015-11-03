package ua.twotwo.client.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.client.RestTemplate;

/**
 * Client REST
 */
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    public void doCMD(){
        restTemplate.exchange(null, HttpMethod.GET)
    }
}
