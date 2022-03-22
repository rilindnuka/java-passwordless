package com.rilind.javapasswordless.utils;

import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class Utils {

    public String genereateFourDigitCode() {
        Random random = new Random();
        return String.format("%04d", random.nextInt(10000));
    }

    public String generateUUID() {
        return UUID.randomUUID().toString();
    }
}
