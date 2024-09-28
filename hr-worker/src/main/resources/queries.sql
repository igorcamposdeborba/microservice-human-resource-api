CREATE DATABASE human_resources;
USE human_resources;

CREATE TABLE tb_worker (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    daily_income DOUBLE NOT NULL
);

SELECT * FROM tb_worker;