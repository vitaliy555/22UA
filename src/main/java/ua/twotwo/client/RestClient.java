package ua.twotwo.client.cmd;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * REST Client
 */
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    public <T> T execCmd(final Cmd<T> cmd){
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        ResponseEntity<T> result = restTemplate.exchange(cmd.getUrl(), cmd.getMethod(), entity, cmd.getResponseType());
        // TODO check to error
        return result.getBody();
    }
}
