package ua.twotwo.client;

import static org.springframework.http.HttpStatus.*;

import java.util.Arrays;
import java.util.Collection;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import ua.twotwo.client.cmd.Cmd;
import ua.twotwo.error.ResponseException;

import com.google.common.base.Preconditions;

/**
 * REST Client
 */
public class RestClient {
    public static final String ERR_MESS_URL = "Url not can be null or empty";
    @Autowired
    private RestTemplate restTemplate;

    public <T> ResponseEntity<T> execCmd(final Cmd cmd) {

//        final HttpEntity<String> entity = new HttpEntity<String>(null, cmd.getHttpHeaders());
        final HttpEntity<String> entity = new HttpEntity<String>("station_id_from=2208001&station_id_till=2218000&date_dep=11.20.2015&time_dep=00:00&time_dep_till=24:00", cmd.getHttpHeaders());
        final ResponseEntity response = restTemplate.exchange(constructUrl(cmd), cmd.getMethod(), entity,
                cmd.getResponseType());
        return response;
    }

    // TODO @Override uriVariables
//    public <T> ResponseEntity<T> exchange(String url, HttpMethod method,
//                                          HttpEntity<?> requestEntity, Class<T> responseType, Object... uriVariables) throws RestClientException {

        private String constructUrl(final Cmd cmd) {
        final String url = cmd.getUrl();
        Preconditions.checkArgument(StringUtils.isNotEmpty(url), ERR_MESS_URL);
        return StringUtils.isNotEmpty(cmd.getPathParam()) ? url.concat("/").concat(cmd.getPathParam()) : url;
    }
}
