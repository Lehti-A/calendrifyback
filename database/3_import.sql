INSERT INTO calendrify.role (id, name) VALUES (default, 'admin');
INSERT INTO calendrify.role (id, name) VALUES (default, 'customer');


INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 1, 'admin', '123', 'A');
INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 2, 'rain', '123', 'A');
INSERT INTO calendrify."user" (id, role_id, email, password, status) VALUES (default, 2, 'mitteaktiivne', '123', 'D');