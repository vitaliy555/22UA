package ua.twotwo.client.cmd;

import org.springframework.http.HttpMethod;

/**
 * Abstract cmd
 */
public class AbstractCmd implements Cmd{

    private HttpMethod method = HttpMethod.GET;
    private String url;
    private Class responseType;

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }

    @Override
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @Override
    public Class getResponseType() {
        return responseType;
    }

    public void setResponseType(Class responseType) {
        this.responseType = responseType;
    }
}
