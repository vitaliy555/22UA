package ua.twotwo.controllers;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.twotwo.dto.Station;
import ua.twotwo.service.SaverStationService;
import ua.twotwo.service.StationService;
import ua.twotwo.utils.AppConst.INFO;

@Controller
@RequestMapping(value = "/update")
public class UpdateStationController {

    private static final Logger LOGGER = Logger.getLogger(UpdateStationController.class);
    @Autowired
    private StationService stationService;
    @Autowired
    private SaverStationService saverStationService;

    @RequestMapping(value = "/stations", method = RequestMethod.GET)
    public String updateStations(Model model) throws Exception {
        final Collection<Station> bookingStations = stationService.getBookingStations();
        LOGGER.debug(String.format(INFO.SIZE_STATIONS_AND_FROM, bookingStations.size(), INFO.BOOKING));
        final Collection<Station> uzStations = stationService.getUzStations();
        LOGGER.debug(String.format(INFO.SIZE_STATIONS_AND_FROM, uzStations.size(), INFO.UZ));
        saverStationService.saveAndCutCrossStations(uzStations, bookingStations);
        fillModel(model, bookingStations, uzStations);
        return "update_stations";
    }

    private void fillModel(final Model model, final Collection<Station> bookingStations,
            final Collection<Station> uzStations) {
        model.addAttribute(INFO.BOOKING, bookingStations);
        model.addAttribute(INFO.UZ, uzStations);
    }

    @ExceptionHandler(Exception.class)
    public ModelAndView handleAllException(Exception ex) {
        final ModelAndView model = new ModelAndView("error/global_error");
        model.addObject("ex", ex);
        LOGGER.error(ex);
        return model;

    }
}
