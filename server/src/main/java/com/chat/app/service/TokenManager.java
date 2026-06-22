package com.chat.app.service;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TokenManager {

    // if we need to handle the expiration, we can use it
    private static final int TTL_MILLIS = 600_000;
    private final static Map<String, String> tokenMap = new ConcurrentHashMap<>();


    /**
     * generating just uuid+email as access token and put into memory to check in the next time
     * @return String
     * @since 2026-06-22
     * */
    public static String generate(String email) {
        var token = UUID.randomUUID().toString() + '-'+ email;
        tokenMap.put(token, email);
        return token;
    }
    public static boolean isValid(String token) {
        var userEmail = tokenMap.get(token);
        return userEmail != null;
    }
}
