insert into customers (email, pwd)
values ('account@importare.mx', 'to_be_encoded'),
       ('cards@importare.mx', 'to_be_encoded'),
       ('loans@importare.mx', 'to_be_encoded'),
       ('balanace@importare.mx', 'to_be_encoded');

insert into roles (role_name, description, id_customer)
values
    ('ROLE_ADMIN', 'can view account endpoint', 1),
    ('ROLE_ADMIN', 'can view cards endpoint', 2),
    ('ROLE_USER', 'can view loans endpoint', 3),
    ('ROLE_USER', 'can view balance endpoint', 4);