CREATE TABLE IF NOT EXISTS Event
(
 id bigint(20) NOT NULL ,
 event varchar(20) NOT NULL,
 message varchar,
 fileName varchar(100) NOT NULL,
 createdTime TIMESTAMP(100) NOT NULL,
 topic varchar(100) NOT NULL,
 PRIMARY KEY (id)
);