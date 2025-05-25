insert into customers (email, pwd)
values ('account@importare.mx', 'to_be_encoded'),
       ('cards@importare.mx', 'to_be_encoded'),
       ('loans@importare.mx', 'to_be_encoded'),
       ('balanace@importare.mx', 'to_be_encoded');

insert into roles (role_name, description, id_customer)
values
    ('VIEW_ACCOUNT', 'can view account endpoint', 1),
    ('VIEW_CARDS', 'can view cards endpoint', 2),
    ('VIEW_LOANS', 'can view loans endpoint', 3),
    ('VIEW_BALANCE', 'can view balance endpoint', 4);