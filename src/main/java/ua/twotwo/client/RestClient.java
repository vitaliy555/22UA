package ua.twotwo.client;

import java.util.Arrays;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import ua.twotwo.client.cmd.Cmd;

import com.google.common.base.Preconditions;

/**
 * REST Client
 */
public class RestClient {
    public static final String ERR_MESS_URL = "Url not can be null or empty";
    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> execCmd(final Cmd cmd) {
        final HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        final HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
        // TODO check to error
        return restTemplate.exchange(constructUrl(cmd), cmd.getMethod(), entity, cmd.getResponseType());
    }

    // TODO now only path param allow (add url param)
    private String constructUrl(final Cmd cmd) {
        final String url = cmd.getUrl();
        Preconditions.checkArgument(StringUtils.isNotEmpty(url), ERR_MESS_URL);
        return StringUtils.isNotEmpty(cmd.getPathParam()) ? url.concat("/").concat(cmd.getPathParam()) : url;
    }
}
