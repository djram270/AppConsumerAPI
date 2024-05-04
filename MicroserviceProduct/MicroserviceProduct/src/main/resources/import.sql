INSERT INTO category (name) VALUES ('ct1');
INSERT INTO category (name) VALUES ('ct12');


-- Insertar productos
INSERT INTO product (description, image_link, name, price) VALUES ('de1', 'link1', 'nm1', 90.0);
INSERT INTO product (description, image_link, name, price) VALUES ('de2', 'link2', 'nm2', 100.0);
INSERT INTO product (description, image_link, name, price) VALUES ('de3', 'link3', 'nm3', 110.0);

-- Insertar categorías asociadas a los productos existentes
INSERT INTO categories (product_id, category_id) VALUES (1L, 1L);
INSERT INTO categories (product_id, category_id) VALUES (1L, 2L);
INSERT INTO categories (product_id, category_id) VALUES (2L, 1L);
INSERT INTO categories (product_id, category_id) VALUES (3L, 2L);