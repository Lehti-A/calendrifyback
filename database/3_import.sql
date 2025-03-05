INSERT INTO calendrify.role (id, name) VALUES (default, 'admin');
INSERT INTO calendrify.role (id, name) VALUES (default, 'customer');


INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 2, 'rain', '123', 'A');
INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 2, 'mitteaktiivne', '123', 'D');

INSERT INTO calendrify.profile (id, user_id, terms_agreed, address, phone) VALUES (default, 1,  true,  'BCS kontor',  112111 );
INSERT INTO calendrify.profile (id, user_id, terms_agreed, address, phone) VALUES (default, 2,  true,  'Laager',  55578585 );
INSERT INTO calendrify.profile (id, user_id, terms_agreed, address, phone) VALUES (default, 3,  true,  'Vanalinn',  555525 );

INSERT INTO calendrify.focus (id, user_id, topic, is_selected, month_number, year, type) VALUES (default, 2, 'mine poodi', false, 3, 2025, 'P');
INSERT INTO calendrify.focus (id, user_id, topic, is_selected, month_number, year, type) VALUES (default, 2, 'mine kinno', false, 3, 2025, 'P');
INSERT INTO calendrify.focus (id, user_id, topic, is_selected, month_number, year, type) VALUES (default, 2, 'mine tööle', false, 3, 2025, 'W');
