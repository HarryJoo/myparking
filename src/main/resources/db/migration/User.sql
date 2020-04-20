DROP TABLE IF EXISTS user;

CREATE TABLE user (
	 id	bigint	NOT NULL  AUTO_INCREMENT PRIMARY KEY ,
	 name 	varchar(255)	NOT NULL,
	 email	varchar(255)	NOT NULL,
	 picture 	text	NOT NULL,
	 role 	varchar(255)	NOT NULL
);
