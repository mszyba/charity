INSERT INTO user_role(role, description) VALUES ('ROLE_USER', 'default role for user');
INSERT INTO user_role(role, description) VALUES ('ROLE_ADMIN', 'default role for admin');

INSERT INTO users (id, email, first_name, last_name, password, is_active) VALUES (1, 't@t.pl', 'testName', 'test', '{bcrypt}$2a$10$MRph5r69JD.PassKa75P7.a6GyVmZjl03DaNc5g2Dd6yaj8dCT3tG', 1);
INSERT INTO users (id, email, first_name, last_name, password, is_active) VALUES (2, 'a@a.pl', 'aName', 'atest', '{bcrypt}$2a$10$MRph5r69JD.PassKa75P7.a6GyVmZjl03DaNc5g2Dd6yaj8dCT3tG', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (3, 'Martina', 'Bees', 'mbees2@geocities.jp', '{bcrypt}$2a$10$MRph5r69JD.PassKa75P7.a6GyVmZjl03DaNc5g2Dd6yaj8dCT3tG', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (4, 'Nicolis', 'Andrzejak', 'nandrzejak3@google.com.hk', '{bcrypt}$2a$10$MRph5r69JD.PassKa75P7.a6GyVmZjl03DaNc5g2Dd6yaj8dCT3tG', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (5, 'Thibaut', 'Fleetwood', 'tfleetwood4@house.gov', 'gbOqUtbf', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (6, 'Maury', 'Safell', 'msafell5@yale.edu', 'W9onRK6', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (7, 'Tanhya', 'Tanman', 'ttanman6@nbcnews.com', 'oE429xXEIG', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (8, 'Jessy', 'Dulson', 'jdulson7@ocn.ne.jp', 'k0dQcYGgpU', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (9, 'Mickie', 'Ivons', 'mivons8@newsvine.com', 'KsNufIzc', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (10, 'Niall', 'Jewsbury', 'njewsbury9@behance.net', 'Pp9tBZ', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (11, 'Roarke', 'Higbin', 'rhigbina@cbslocal.com', 'x8Swwc', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (12, 'Adi', 'O''Kelly', 'aokellyb@huffingtonpost.com', 'oG5tHKxUjwX', 0);
insert into users (id, first_name, last_name, email, password, is_active) values (13, 'Livvyy', 'Coping', 'lcopingc@washingtonpost.com', 'GnH0fqotOV', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (14, 'Allie', 'Patullo', 'apatullod@usnews.com', '1Ca5LiNSHCwg', 0);
insert into users (id, first_name, last_name, email, password, is_active) values (15, 'Charin', 'Catcheside', 'ccatchesidee@upenn.edu', '461OPopU', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (16, 'Sherrie', 'Hindrich', 'shindrichf@vk.com', 'YkFlNzMS3lgw', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (17, 'Nissy', 'Hulstrom', 'nhulstromg@bloglovin.com', 'boYq7ZdVdv', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (18, 'Sharia', 'Gosland', 'sgoslandh@wisc.edu', 'ip8k9XUMvq', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (19, 'Stacie', 'Scarsbrook', 'sscarsbrooki@tripadvisor.com', 'eyB0YyH', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (20, 'Xylia', 'Giddy', 'xgiddyj@businessinsider.com', 'Btgse4X', 1);
insert into users (id, first_name, last_name, email, password, is_active) values (21, 'Carmine', 'Gronw', 'cgronwk@amazonaws.com', 'Z8byiLtnSl', 1);

INSERT INTO users_roles(user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES (2, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (3, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (4, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (5, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (6, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (7, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (8, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (9, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (10, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (11, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (12, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (13, 2);
INSERT INTO users_roles(user_id, roles_id) VALUES (14, 2);

INSERT INTO institutions (description, name) VALUES ('desc1', 'Fundacja 1');
INSERT INTO institutions (description, name) VALUES ('desc2', 'Fundacja 2');
INSERT INTO institutions (description, name) VALUES ('desc3', 'Fundacja 3');
INSERT INTO institutions (description, name) VALUES ('desc4', 'Fundacja 4');
INSERT INTO institutions (description, name) VALUES ('desc5', 'Fundacja 5');
INSERT INTO institutions (description, name) VALUES ('desc6', 'Fundacja 6');

INSERT INTO donations (city, pick_up_comment, quantity, street, zip_code, institution_id) VALUES ('Kielce', 'comm1', '9', 'ulica0', '55-000', '1');
INSERT INTO donations (city, pick_up_comment, quantity, street, zip_code, institution_id) VALUES ('Kielce1', 'comm1', '1', 'ulica1', '55-000', '2');
INSERT INTO donations (city, pick_up_comment, quantity, street, zip_code, institution_id) VALUES ('Kielce2', 'comm1', '120', 'ulica2', '55-03300', '2');

INSERT INTO categories (name) VALUES ('ubrania, które nadają się do ponownego użycia');
INSERT INTO categories (name) VALUES ('ubrania, do wyrzucenia');
INSERT INTO categories (name) VALUES ('zabawki');
INSERT INTO categories (name) VALUES ('książki');
INSERT INTO categories (name) VALUES ('inne');
INSERT INTO categories (name) VALUES ('inne2');