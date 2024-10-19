INSERT INTO users values (1, 'Ivan Ivanov', 'ivanov@gmail.com', now()),
                         ( 2, 'Petr Petrov', 'petrov@gmail.com', now()),
                         ( 3, 'Denis Denisov', 'denisov@gmail.com', now());

SELECT setval('users_id_seq', (SELECT MAX(id) FROM users));