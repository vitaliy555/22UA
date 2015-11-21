package ua.twotwo.client;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.client.RestTemplate;
import ua.twotwo.client.cmd.TestCMD;
import ua.twotwo.dto.booking.BookingTrainAnswer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"/beans.xml","/db.xml"})
public class RestClientTest {
    @Autowired
    RestTemplate restTemplate;

    @Test
    public void testExecCmd() throws Exception {
        TestCMD testCMD = new TestCMD();
        final HttpEntity<String> entity = new HttpEntity<String>("station_id_from=2208001&station_id_till=2218000&date_dep=11.20.2015&time_dep=00:00&time_dep_till=24:00", testCMD.getHttpHeaders());
        final ResponseEntity response = restTemplate.exchange(testCMD.getUrl(), testCMD.getMethod(), entity,
                testCMD.getResponseType());


        System.out.println("OK");
    }
}