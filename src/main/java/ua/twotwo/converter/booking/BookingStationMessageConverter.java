package ua.twotwo.converter.booking;

import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import ua.twotwo.converter.booking.dto.BookingStationAnswer;

//TODO public class BookingStationMessageConverter extends AbstractHttpMessageConverter {
public class BookingStationMessageConverter extends MappingJackson2HttpMessageConverter {

    @Override
    protected boolean supports(Class clazz) {
        throw new RuntimeException(
                "BookingStationMessageConverter method ---> boolean supports(Class clazz) not supported");
        // return false;
    }

    @Override
    protected Object readInternal(Class clazz, HttpInputMessage inputMessage) throws IOException,
            HttpMessageNotReadableException {
        Object readObj = super.readInternal(clazz, inputMessage);
        if (readObj instanceof BookingStationAnswer) {
            BookingStationAnswer answer = (BookingStationAnswer) readObj;
            return answer.getValue();
        }
        return null;
    }

    @Override
    protected void writeInternal(Object o, HttpOutputMessage outputMessage) throws IOException,
            HttpMessageNotWritableException {
//        OutputStream body = outputMessage.getBody();
//        byte[] bytes = IOUtils.;
//        while(body)
//
//
//        throw new RuntimeException(
//                "BookingStationMessageConverter method ---> writeInternal(Object o, HttpOutputMessage outputMessage) not supported");
    }
}
