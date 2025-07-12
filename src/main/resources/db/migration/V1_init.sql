CREATE TABLE IF NOT EXISTS 'users' (

full_name varchar(50) NOT NULL,
email varchar(50) PRIMARY KEY,
password varchar(50) NOT NULL,
created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);