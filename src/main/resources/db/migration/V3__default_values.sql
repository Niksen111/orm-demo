INSERT INTO products (name, price) VALUES
    ('Laptop', 1500),
    ('Smartphone', 800),
    ('Headphones', 200);

INSERT INTO orders (user_id, order_date) VALUES
    (1, NOW()),
    (2, NOW()),
    (3, NOW());

INSERT INTO order_products (order_id, product_id, quantity) VALUES
    (1, 1, 1),
    (2, 2, 2),
    (3, 3, 1);