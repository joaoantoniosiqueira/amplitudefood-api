CREATE TABLE restaurant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(150) NOT NULL,
    shipping_fee DECIMAL(10,2),
    cuisine_id BIGINT NOT NULL,
    FOREIGN KEY (cuisine_id) REFERENCES cuisine(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;