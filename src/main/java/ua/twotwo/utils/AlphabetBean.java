package ua.twotwo.utils;

import java.util.Collection;

import javax.annotation.PostConstruct;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;

public class AlphabetBean {
    private Collection<String> cyrillicAlphabet = Lists.newArrayList();

    @PostConstruct
    private void init() {
        // alphabet from À to Ï
        byte firstByte = -48;
        for (byte secondByte = -80; secondByte <= -65; secondByte++) {
            cyrillicAlphabet.add(new String(new byte[] { firstByte, secondByte }, Charsets.UTF_8));
        }
        // alphabet from Ï to ß
        firstByte = -47;
        for (byte secondByte = -128; secondByte <= -113; secondByte++) {
            cyrillicAlphabet.add(new String(new byte[] { firstByte, secondByte }, Charsets.UTF_8));
        }
    }

    public Collection<String> getCyrillicAlphabet() {
        return cyrillicAlphabet;
    }
}
