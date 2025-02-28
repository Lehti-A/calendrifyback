-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2025-02-28 09:41:47.23

-- tables
-- Table: activity
CREATE TABLE activity (
                          id serial  NOT NULL,
                          day_id int  NOT NULL,
                          topic varchar(255)  NOT NULL,
                          is_done boolean  NOT NULL,
                          CONSTRAINT activity_pk PRIMARY KEY (id)
);

-- Table: day
CREATE TABLE day (
                     id serial  NOT NULL,
                     user_id int  NOT NULL,
                     date date  NOT NULL,
                     type varchar(1)  NOT NULL,
                     focus varchar(255)  NOT NULL,
                     thoughts varchar(1000)  NOT NULL,
                     CONSTRAINT day_pk PRIMARY KEY (id)
);

-- Table: focus
CREATE TABLE focus (
                       id serial  NOT NULL,
                       user_id int  NOT NULL,
                       topic varchar(255)  NOT NULL,
                       is_selected boolean  NOT NULL,
                       month_number int  NOT NULL,
                       year int  NOT NULL,
                       type varchar(1)  NOT NULL,
                       CONSTRAINT focus_pk PRIMARY KEY (id)
);

-- Table: general_goal_template
CREATE TABLE general_goal_template (
                                       id serial  NOT NULL,
                                       topic varchar(255)  NOT NULL,
                                       CONSTRAINT general_goal_template_pk PRIMARY KEY (id)
);

-- Table: image
CREATE TABLE image (
                       id serial  NOT NULL,
                       day_id int  NOT NULL,
                       data bytea  NOT NULL,
                       CONSTRAINT image_pk PRIMARY KEY (id)
);

-- Table: meeting
CREATE TABLE meeting (
                         id serial  NOT NULL,
                         day_id int  NOT NULL,
                         time time  NOT NULL,
                         subject varchar(255)  NOT NULL,
                         CONSTRAINT meeting_pk PRIMARY KEY (id)
);

-- Table: mood
CREATE TABLE mood (
                      id serial  NOT NULL,
                      day_id int  NOT NULL,
                      state varchar(1)  NOT NULL,
                      CONSTRAINT mood_pk PRIMARY KEY (id)
);

-- Table: personal_goal
CREATE TABLE personal_goal (
                               id serial  NOT NULL,
                               day_id int  NOT NULL,
                               topic varchar(255)  NOT NULL,
                               is_done boolean  NOT NULL,
                               CONSTRAINT personal_goal_pk PRIMARY KEY (id)
);

-- Table: personal_goal_template
CREATE TABLE personal_goal_template (
                                        id serial  NOT NULL,
                                        user_id int  NOT NULL,
                                        topic varchar(255)  NOT NULL,
                                        CONSTRAINT personal_goal_template_pk PRIMARY KEY (id)
);

-- Table: profile
CREATE TABLE profile (
                         id serial  NOT NULL,
                         user_id int  NOT NULL,
                         terms_agreed boolean  NOT NULL,
                         address varchar(255)  NOT NULL,
                         phone varchar(255)  NOT NULL,
                         CONSTRAINT profile_pk PRIMARY KEY (id)
);

-- Table: steps
CREATE TABLE steps (
                       id serial  NOT NULL,
                       user_id int  NOT NULL,
                       date date  NOT NULL,
                       count int  NOT NULL,
                       CONSTRAINT steps_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        email varchar(255)  NOT NULL,
                        password varchar(255)  NOT NULL,
                        status varchar(1)  NOT NULL,
                        CONSTRAINT user_ak_1 UNIQUE (email) NOT DEFERRABLE  INITIALLY IMMEDIATE,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: water
CREATE TABLE water (
                       id serial  NOT NULL,
                       user_id int  NOT NULL,
                       date date  NOT NULL,
                       count int  NOT NULL,
                       CONSTRAINT water_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: activity_day (table: activity)
ALTER TABLE activity ADD CONSTRAINT activity_day
    FOREIGN KEY (day_id)
        REFERENCES day (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: calendar_user (table: day)
ALTER TABLE day ADD CONSTRAINT calendar_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: focus_user (table: focus)
ALTER TABLE focus ADD CONSTRAINT focus_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: goal_day (table: personal_goal)
ALTER TABLE personal_goal ADD CONSTRAINT goal_day
    FOREIGN KEY (day_id)
        REFERENCES day (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: image_day (table: image)
ALTER TABLE image ADD CONSTRAINT image_day
    FOREIGN KEY (day_id)
        REFERENCES day (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: meeting_day (table: meeting)
ALTER TABLE meeting ADD CONSTRAINT meeting_day
    FOREIGN KEY (day_id)
        REFERENCES day (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: mood_day (table: mood)
ALTER TABLE mood ADD CONSTRAINT mood_day
    FOREIGN KEY (day_id)
        REFERENCES day (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: personal_goal_template_user (table: personal_goal_template)
ALTER TABLE personal_goal_template ADD CONSTRAINT personal_goal_template_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: profile_user (table: profile)
ALTER TABLE profile ADD CONSTRAINT profile_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: steps_user (table: steps)
ALTER TABLE steps ADD CONSTRAINT steps_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: water_user (table: water)
ALTER TABLE water ADD CONSTRAINT water_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

