package com.chat.app.utils;

import java.util.Map;

public enum ConfigurationProperties {

    ;

    public final static String applicationName = "CHATTING-BRIDGE";
    public final static Map<String, Object> envVariables = Map.of("appName", applicationName);
    public final static String SERVICE_NAME = "messageService";
    public final static short SERVER_PORT = 8080;

}
