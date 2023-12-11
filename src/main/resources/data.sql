insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), gen_random_uuid(), 'Rick_Headle@rambler.ru', 'Alexey', 'Efimov', 'Alexandrovich', '+79920285401', 'L1');

insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), gen_random_uuid(), 'TestEmail@yandex.ru', 'Testik', 'Testikoff', 'Testikovich', '+78005553535', 'L2');

insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), gen_random_uuid(), 'ValidEmailAddress@gmail.com', 'James', 'Bond', '--', '678-354-0070', 'L3');

insert into product_users(created_at, updated_at, id, email, first_name, last_name, middle_name, phone)
VALUES (now(), now(), gen_random_uuid(), 'HIGQ@mail.ru', 'Hidaka', 'Masamune', '--', '--');

insert into product_users(created_at, updated_at, id, email, first_name, last_name, middle_name, phone)
VALUES (now(), now(), gen_random_uuid(), 'Stanley_Borfer@protonmail.com', 'Stanley', 'Borfer', '--', '(717) 550-1675');