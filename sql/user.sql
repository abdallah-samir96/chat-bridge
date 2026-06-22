CREATE TABLE if not exists user (
   id BIGINT NOT NULL AUTO_INCREMENT,
   name VARCHAR(100) NOT NULL,
   email VARCHAR(150) NOT NULL,
   password VARCHAR(255) NOT NULL,
   gender ENUM('MALE','FEMALE','OTHER'),
   mobile VARCHAR(20),
   avatar VARCHAR(255),
   created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,

   PRIMARY KEY (id),
   UNIQUE KEY uk_email (email)
);