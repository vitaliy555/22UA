package ua.twotwo.client.cmd;

import org.springframework.http.HttpMethod;

/**
 * Abstract cmd
 */
public class AbstractCmd<T> implements Cmd<T> {

    private HttpMethod method = HttpMethod.GET;
    private String url;
    private Class<T> responseType;

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
    public Class<T> getResponseType() {
        return responseType;
    }

    public void setResponseType(Class<T> responseType) {
        this.responseType = responseType;
    }
}
