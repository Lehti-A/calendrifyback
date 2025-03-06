INSERT INTO calendrify.role (id, name) VALUES (default, 'admin');
INSERT INTO calendrify.role (id, name) VALUES (default, 'customer');

INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 2, 'rain', '123', 'A');
INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 2, 'mitteaktiivne', '123', 'D');

INSERT INTO calendrify.profile (id, user_id, terms_agreed, address, phone) VALUES (default, 1,  true,  'BCS kontor',  112111 );
INSERT INTO calendrify.profile (id, user_id, terms_agreed, address, phone) VALUES (default, 2,  true,  'Laager',  55578585 );
INSERT INTO calendrify.profile (id, user_id, terms_agreed, address, phone) VALUES (default, 3,  true,  'Vanalinn',  555525 );

INSERT INTO calendrify.general_goal_template (id, topic) VALUES (default, 'Meditation session');
INSERT INTO calendrify.general_goal_template (id, topic) VALUES (default, 'Listen to 1 podcast episode');
INSERT INTO calendrify.general_goal_template (id, topic) VALUES (default, 'Read at least 15 min');
INSERT INTO calendrify.general_goal_template (id, topic) VALUES (default, 'Workout');

INSERT INTO calendrify.day (id, user_id, date, type, focus, thoughts) VALUES (default, 1, '2025-03-25', 'P', 'Pay taxes', 'I want to do many things 1');
INSERT INTO calendrify.day (id, user_id, date, type, focus, thoughts) VALUES (default, 2, '2025-03-25', 'P', 'Vali IT', 'I want to do many things 2');
INSERT INTO calendrify.day (id, user_id, date, type, focus, thoughts) VALUES (default, 3, '2025-03-25', 'P', 'VALI IT', 'I want to do many things 3');

INSERT INTO calendrify.focus (id, user_id, topic, is_selected, month_number, year, type) VALUES (default, 2, 'go to shop', false, 3, 2025, 'P');
INSERT INTO calendrify.focus (id, user_id, topic, is_selected, month_number, year, type) VALUES (default, 2, 'go to cinema', false, 3, 2025, 'P');
INSERT INTO calendrify.focus (id, user_id, topic, is_selected, month_number, year, type) VALUES (default, 2, 'go to libary', false, 3, 2025, 'W');

INSERT INTO calendrify.activity (id, day_id, topic, is_done) VALUES (default, 2, 'Doctor', false);
INSERT INTO calendrify.activity (id, day_id, topic, is_done) VALUES (default, 2, 'Shop', false);
INSERT INTO calendrify.activity (id, day_id, topic, is_done) VALUES (default, 2, 'Cinema', true);
INSERT INTO calendrify.activity (id, day_id, topic, is_done) VALUES (default, 3, 'Read a book', false);
