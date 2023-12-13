insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), 'a5b4e2e7-a16c-46f9-b6c5-70d0665768eb', 'Rick_Headle@rambler.ru', 'Alexey', 'Efimov', 'Alexandrovich', '+79920285401', 'L1');

insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), gen_random_uuid(), 'NotSoTestEmail@yandex.ru', 'Sergey', 'Ivanov', 'Pavlovich', '+78001234567', 'L2');

insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), gen_random_uuid(), 'TestEmail@yandex.ru', 'Testik', 'Testikoff', 'Testikovich', '+78005553535', 'L2');

insert into tech_support_experts(created_at, updated_at, id, email, first_name, last_name, middle_name, phone, support_level)
VALUES (now(), now(), gen_random_uuid(), 'ValidEmailAddress@gmail.com', 'James', 'Bond', '--', '678-354-0070', 'L3');

insert into product_users(created_at, updated_at, id, email, first_name, last_name, middle_name, phone)
VALUES (now(), now(), '9f632f4b-e907-466e-bf70-e67518f0f741', 'HIGQ@mail.ru', 'Hidaka', 'Masamune', '--', '--');

insert into product_users(created_at, updated_at, id, email, first_name, last_name, middle_name, phone)
VALUES (now(), now(), gen_random_uuid(), 'Stanley_Borfer@protonmail.com', 'Stanley', 'Borfer', '--', '(717) 550-1675');

insert into incidents(status, created_at, updated_at, id, product_user_id, tech_support_expert_id, description, incident_emergency, incident_influence, priority, title)
VALUES (0, now(), now(), '7b4d03ef-4a2f-4ab7-9e32-6a0a366bcfe6', '9f632f4b-e907-466e-bf70-e67518f0f741', 'a5b4e2e7-a16c-46f9-b6c5-70d0665768eb', 'Description is missing', 'HIGH', 'LOW', 'MEDIUM', 'Incident Test #0');