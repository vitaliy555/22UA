package ua.twotwo.client.cmd;

import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;

/**
 * interface cmd
 */
public interface Cmd {
    void setMethod(HttpMethod method);

    void addHeader(String headerName, String headerValue);

    HttpHeaders getHttpHeaders();

    HttpMethod getMethod();

    void setUrl(String url);

    String getUrl();

    void setResponseType(Class responseType);

    Class getResponseType();

    void setUrlParams(Map<String, String> params);

    Map<String, String> getUrlParams();

    void setPathParam(String pathParam);

    String getPathParam();
}
