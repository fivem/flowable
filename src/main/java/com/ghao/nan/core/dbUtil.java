package com.ghao.nan.core;

import org.springframework.beans.factory.annotation.Value;

public class dbUtil {
    @Value("${jdbc.driverClass}")
    private String DriverClass ;
}
