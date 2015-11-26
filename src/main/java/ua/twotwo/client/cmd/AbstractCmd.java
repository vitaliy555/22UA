package ua.twotwo.client.cmd;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;

import com.google.common.collect.Maps;

/**
 * Abstract cmd
 */
public class AbstractCmd implements Cmd {

    private HttpMethod method = HttpMethod.GET;
    // JSON by default
    private HttpHeaders headers = new HttpHeaders();
    private String url;
    private Class responseType;
    private Map<String, String> params = Maps.newHashMap();
    private String pathParam;
    private String requestBody;
    {
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
    }

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    @Override
    public void addHeader(String headerName, String headerValue) {
        headers.add(headerName, headerValue);
    }

    @Override
    public HttpHeaders getHttpHeaders() {
        return headers;
    }

    public void setAccept(List<MediaType> mediaTypes) {
        headers.setAccept(mediaTypes);
    }

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Class getResponseType() {
        return responseType;
    }

    @Override
    public void setResponseType(Class responseType) {
        this.responseType = responseType;
    }

    @Override
    public void setUrlParams(Map<String, String> params) {
        this.params.putAll(params);
    }

    @Override
    public Map<String, String> getUrlParams() {
        return params;
    }

    @Override
    public void setPathParam(String pathParam) {
        this.pathParam = pathParam;
    }

    @Override
    public String getPathParam() {
        return pathParam;
    }

    public String getRequestBody() {
        return requestBody;
    }

    public void setRequestBody(String requestBody) {
        this.requestBody = requestBody;
    }
}
