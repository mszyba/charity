INSERT INTO user_role(role, description) VALUES ('ROLE_USER', 'default role for user');
INSERT INTO user_role(role, description) VALUES ('ROLE_ADMIN', 'default role for admin');

INSERT INTO users_roles(user_id, roles_id) VALUES (1, 1);
INSERT INTO users_roles(user_id, roles_id) VALUES (2, 2);

INSERT INTO users (id, email, first_name, last_name, password) VALUES (1, 't@t.pl', 'testName', 'test', '{bcrypt}$2a$10$MRph5r69JD.PassKa75P7.a6GyVmZjl03DaNc5g2Dd6yaj8dCT3tG');
INSERT INTO users (id, email, first_name, last_name, password) VALUES (2, 'a@a.pl', 'aName', 'atest', '{bcrypt}$2a$10$MRph5r69JD.PassKa75P7.a6GyVmZjl03DaNc5g2Dd6yaj8dCT3tG');

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