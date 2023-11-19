package com.proyecto.cita.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatDate {

    public static String localDateTimeToString(LocalDateTime localDateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }
}
