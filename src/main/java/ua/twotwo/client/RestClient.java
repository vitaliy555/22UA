package ua.twotwo.client;

import com.google.common.base.Preconditions;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import ua.twotwo.client.cmd.Cmd;

/**
 * REST Client
 */
public class RestClient {
    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> execCmd(final Cmd cmd) {
        final HttpEntity<String> entity = new HttpEntity<String>(cmd.getRequestBody(), cmd.getHttpHeaders());
        final ResponseEntity response = restTemplate.exchange(cmd.getUrl(), cmd.getMethod(), entity,
                cmd.getResponseType());
        return response;
    }
}
