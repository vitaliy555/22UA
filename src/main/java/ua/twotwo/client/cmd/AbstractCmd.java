package ua.twotwo.client.cmd;

import org.springframework.http.HttpMethod;

public class AbstractCmd implements Cmd {

    private HttpMethod method = HttpMethod.GET;

    @Override
    public HttpMethod getMethod() {
        return method;
    }

    public void setMethod(HttpMethod method) {
        this.method = method;
    }
}
