package ua.twotwo.error;

import org.springframework.http.ResponseEntity;

import ua.twotwo.utils.AppConst;

public class ResponseException extends RuntimeException {
    public ResponseException(ResponseEntity response) {
        super(AppConst.EXCEPTION.BAD_RESPONSE.concat(response.toString()));
    }
}
