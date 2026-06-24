CREATE TABLE if not exists message (
   id BIGINT NOT NULL AUTO_INCREMENT PRIMARY KEY,
   text TEXT,
   sender BIGINT NOT NULL,
   receiver BIGINT NOT NULL,
   message_hash VARCHAR(1000) NOT NULL,
   is_seen BOOLEAN NOT NULL DEFAULT FALSE,
   sent_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

    INDEX idx_sender(sender),
    INDEX idx_receiver(receiver)
);