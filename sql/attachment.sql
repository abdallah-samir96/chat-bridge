CREATE TABLE if not exists attachment (
            id         BIGINT AUTO_INCREMENT PRIMARY KEY,
            message_id BIGINT       NOT NULL,
            file_name  VARCHAR(255) NOT NULL,
            file_extension  VARCHAR(100),
            file_path       VARCHAR(500) NOT NULL,
            file_size_KB    BIGINT,

            CONSTRAINT fk_attachment_message
             FOREIGN KEY (message_id)
                 REFERENCES messages (id)
                 ON DELETE CASCADE
);