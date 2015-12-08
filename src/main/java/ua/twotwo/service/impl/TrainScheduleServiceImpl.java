package ua.twotwo.service.impl;

import java.util.Collection;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import ua.twotwo.client.RestClient;
import ua.twotwo.client.cmd.impl.ScheduleStationCmd;
import ua.twotwo.dto.Train;
import ua.twotwo.service.TrainScheduleService;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class TrainScheduleServiceImpl implements TrainScheduleService {
    public static final String TRAINS_SELECTOR = "#cpn-timetable > table > tbody > tr";

    @Autowired
    private RestClient restClient;

    @Override
    public Collection<Train> getScheduleTrains(String uzIdFrom, String uzIdTo) {
        final ScheduleStationCmd scheduleStationCmd = new ScheduleStationCmd(uzIdFrom, uzIdTo);
        ResponseEntity<String> responseHtml = restClient.execCmd(scheduleStationCmd);
        return parseHtmlToTrains(responseHtml.getBody());
    }

    private Collection<Train> parseHtmlToTrains(final String html) {
        Preconditions.checkNotNull(html, "HTML can't be null");
        Elements trainElements = Jsoup.parse(html).select(TRAINS_SELECTOR);
        return convertToTrains(trainElements);
    }

    private Collection<Train> convertToTrains(final Elements trainsInHtml) {
        Collection<Train> trains = Lists.newArrayList();
        for (Element element : trainsInHtml) {
            Elements children = element.children();
            Train train = new Train();
            train.setNumber(children.get(0).text());
            train.setRoute(children.get(1).text());
            train.setSchedule(children.get(2).text());
            // TODO add dip/arrive station and time
            // train.setDispatchStation(children.get(3).text());
            // train.setArrivalStation(children.get(6).text());
            trains.add(train);
        }
        return trains;

    }
}
