package com.chat.app.model;

import java.time.LocalDateTime;
import java.util.*;

public class Message {

    private long id;
    private String text;
    private long sender;
    private long receiver;
    private LocalDateTime sentAt;
    private String messageHash;
    private List<Attachment> attachments;

}
