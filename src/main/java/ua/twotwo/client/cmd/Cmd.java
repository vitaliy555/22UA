package ua.twotwo.client.cmd;


import org.springframework.http.HttpMethod;

/**
 * interface cmd
 */
public interface Cmd<T> {
    HttpMethod getMethod();
    String getUrl();
    Class<T> getResponseType();
}
