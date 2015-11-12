package ua.twotwo;

import org.apache.log4j.Logger;

public class Main {
    final static Logger logger = Logger.getLogger(Main.class);

    public static void main(String[] args) {
        String s = "Червлена-Вузлова (Російська Федерація)~25106";
        System.out.println(s.replaceAll("\\(\\S*[ ][\\S*]\\)", ""));
        System.out.println(s.replaceAll("\\(.+\\)~","#"));
    }
}
//\S+[\d]\S+