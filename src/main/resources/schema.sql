DROP TABLE IF EXISTS OBSERVATION;

CREATE TABLE OBSERVATION (
    OBSERVATION_ID INT AUTO_INCREMENT  PRIMARY KEY,
    SOURCE VARCHAR(250) DEFAULT NULL,
    CODE_LIST_CODE VARCHAR(250) DEFAULT NULL,
    CODE VARCHAR(250) NOT NULL,
    DISPLAY_VALUE VARCHAR(250) DEFAULT NULL,
    LONG_DESCRIPTION VARCHAR(250) DEFAULT NULL,
    FROM_DATE DATE,
    TO_DATE DATE,
    SORTING_PRIORITY INTEGER
);