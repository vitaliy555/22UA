package ua.twotwo.service.impl;

import com.google.common.collect.Maps;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import ua.twotwo.dto.Train;
import ua.twotwo.service.TrainAvailabilityService;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.MessageFormat;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TrainAvailabilityServiceImpl implements TrainAvailabilityService {
    @Override
    public Collection<Train> getAvailableTrains(Integer bookingIdFrom, Integer bookingIdTo, String data) {
        return null;
    }
}
