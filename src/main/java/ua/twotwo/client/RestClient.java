package ua.twotwo.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;
import ua.twotwo.client.cmd.Cmd;

import java.util.Arrays;

/**
 * REST Client
 */
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> execCmd(final Cmd cmd){
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        // TODO check to error
        return restTemplate.exchange(cmd.getUrl(), cmd.getMethod(), entity, cmd.getResponseType());
    }
}
