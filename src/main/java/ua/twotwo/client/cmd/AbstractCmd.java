package ua.twotwo.client.cmd;

import java.util.Map;

import org.springframework.http.HttpMethod;

import com.google.common.collect.Maps;

/**
 * Abstract cmd
 */
public class AbstractCmd implements Cmd {

    private HttpMethod method = HttpMethod.GET;
    private String url;
    private Class responseType;
    private Map<String, String> params = Maps.newHashMap();
    private String pathParam;

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    @Override
    public void setMethod(HttpMethod method) {
        this.method = method;
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
}
