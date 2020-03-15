--
-- V2: Create Items TABLE
--
--
CREATE TABLE album (
  id INT NOT NULL AUTO_INCREMENT,
  title VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
#DROP TABLE album;

CREATE TABLE song (
  id INT NOT NULL AUTO_INCREMENT,
  album_id INT NOT NULL,
  title VARCHAR(255) NOT NULL,
  length INT NOT NULL,
  track INT NOT NULL,
  PRIMARY KEY (id),
  FOREIGN KEY (album_id) REFERENCES album (id)
) DEFAULT CHARSET=utf8mb4;
#DROP TABLE song;

CREATE TABLE locale (
  id INT NOT NULL AUTO_INCREMENT,
  language_code VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
#DROP TABLE locale;

CREATE TABLE album_locale (
  album_id INT NOT NULL,
  locale_id INT NOT NULL,
  FOREIGN KEY (album_id) REFERENCES album (id),
  FOREIGN KEY (locale_id) REFERENCES locale (id)
) DEFAULT CHARSET=utf8mb4;
#DROP TABLE album_locale;

CREATE TABLE playlist (
  id INT NOT NULL AUTO_INCREMENT,
  playlist_name VARCHAR(255) NOT NULL,
  user_id VARCHAR(255) NOT NULL,
  PRIMARY KEY (id)
) DEFAULT CHARSET=utf8mb4;
#DROP TABLE playlist;

CREATE TABLE playlist_song (
  song_id INT NOT NULL,
  playlist_id INT NOT NULL,
  FOREIGN KEY (song_id) REFERENCES song (id),
  FOREIGN KEY (playlist_id) REFERENCES playlist (id)
) DEFAULT CHARSET=utf8mb4;
#DROP TABLE playlist_song;