-- Inserir dados na tabela customer
INSERT INTO customer (name, cpf, email)
VALUES
    ('João Silva', '12345678901', 'joao.silva@example.com'),
    ('Maria Oliveira', '98765432100', 'maria.oliveira@example.com'),
    ('Pedro Santos', '11122233344', 'pedro.santos@example.com');

-- Inserir dados na tabela payment
INSERT INTO payment (amount, status)
VALUES
    (100.50, 'PAID'),
    (200.75, 'PENDING'),
    (150.00, 'CANCELLED');

-- Inserir dados na tabela orders
INSERT INTO orders (customer_id, date_time_order, payment_id, total_amount, order_status)
VALUES
    (1, '2024-11-30 10:00:00', 1, 100.50, 'RECEIVED'),
    (2, '2024-11-30 11:00:00', 2, 200.75, 'IN_PREPARATION'),
    (3, '2024-11-30 12:00:00', 3, 150.00, 'CANCELED');

-- Inserir dados na tabela product com UUIDs
INSERT INTO product (product_id, name, price, information, category, order_id)
VALUES
    (UUID(), 'Hambúrguer', 15.99, 'Delicioso hambúrguer artesanal.', 'lanches', 1),
    (UUID(), 'Sanduíche de Frango', 12.49, 'Sanduíche de frango grelhado.', 'lanches', 1),
    (UUID(), 'Pizza', 25.00, 'Pizza de calabresa com queijo.', 'lanches', 2),
    (UUID(), 'Coca-Cola', 4.99, 'Refrigerante Coca-Cola 350ml.', 'bebidas', 2),
    (UUID(), 'Suco de Laranja', 5.49, 'Suco de laranja natural.', 'bebidas', 3);
