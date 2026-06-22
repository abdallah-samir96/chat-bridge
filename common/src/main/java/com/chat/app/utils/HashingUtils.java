package com.chat.app.utils;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.IOException;
import java.io.InputStream;

public class HashingUtils {

    public static String generateHash(String plain) {
        return DigestUtils.sha256Hex(plain);
    }
    public static String generateHash(InputStream stream) throws IOException {
        return DigestUtils.sha256Hex(stream);
    }
}
