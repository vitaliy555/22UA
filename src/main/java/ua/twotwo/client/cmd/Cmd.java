package ua.twotwo.client.cmd;


import org.springframework.http.HttpMethod;

/**
 * interface cmd
 */
public interface Cmd {
    HttpMethod getMethod();
}
