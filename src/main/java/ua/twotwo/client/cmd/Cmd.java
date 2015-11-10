package ua.twotwo.client.cmd;


import org.springframework.http.HttpMethod;

import java.util.Map;

/**
 * interface cmd
 */
public interface Cmd {
    void setMethod(HttpMethod method);
    HttpMethod getMethod();
    void setUrl(String url);
    String getUrl();
    void setResponseType(Class responseType);
    Class getResponseType();
    void setUrlParams(Map<String,String> params);
    Map<String,String> getUrlParams();
    void setPathParam(String pathParam);
    String getPathParam();
}
