CREATE TABLE users(
    id INT PRIMARY KEY AUTO_INCREMENT,
    fullname VARCHAR(30) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(50) DEFAULT '',
    password VARCHAR(30) NOT NULL DEFAULT '',
    created_at DATETIME,
    updated_at DATETIME,
    is_active TINYINT(1) DEFAULT 1,
    date_of_birth DATE,
    role_id INT,
    facebook_account_id INT DEFAULT 0,
    google_account_id INT DEFAULT 0,
    FOREIGN KEY (role_id) REFERENCES roles (id)
);


CREATE TABLE roles(
    id INT PRIMARY KEY,
    name VARCHAR(10) NOT NULL 
);

CREATE TABLE tokens(
    id int PRIMARY KEY AUTO_INCREMENT,
    token varchar(255) UNIQUE NOT NULL,
    token_type varchar(50) NOT NULL,
    expiration_date DATETIME,
    revoked tinyint(1) NOT NULL,
    expired tinyint(1) NOT NULL,
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id)
);


CREATE TABLE social_accounts(
    id INT PRIMARY KEY AUTO_INCREMENT,
    provider VARCHAR(20) NOT NULL COMMENT 'Tên nhà social network',
    provider_id VARCHAR(50) NOT NULL,
    email VARCHAR(150) NOT NULL COMMENT 'Email tài khoản',
    name VARCHAR(100) NOT NULL COMMENT 'Tên người dùng',
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id)
);



CREATE TABLE categories(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name varchar(30) NOT NULL DEFAULT '' 
);

CREATE TABLE products (
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(30),
    price FLOAT NOT NULL CHECK (price >= 0),
    thumbnail VARCHAR(50) DEFAULT '',
    description LONGTEXT DEFAULT '',
    created_at DATETIME,
    updated_at DATETIME,
    category_id INT,
    FOREIGN KEY (category_id) REFERENCES categories (id)
);

CREATE TABLE orders(
    id INT PRIMARY KEY AUTO_INCREMENT,
    user_id int,
    FOREIGN KEY (user_id) REFERENCES users(id),
    fullname VARCHAR(30) DEFAULT '',
    email VARCHAR(30) DEFAULT '',
    phone_number VARCHAR(10) NOT NULL,
    address VARCHAR(50) NOT NULL,
    note VARCHAR(100) DEFAULT '',
    order_date DATETIME DEFAULT CURRENT_TIMESTAMP,
    status ENUM('processing','watting for delivery','delivering','successful delivery','cancelled'),
    shipping_method VARCHAR(30),
    shipping_address VARCHAR(50),
    shipping_date DATE,
    tracking_number VARCHAR(30),
    payment_method VARCHAR(30),
    active TINYINT(1),
    total_money FLOAT CHECK(total_money >= 0)
);


CREATE TABLE order_details(
    id INT PRIMARY KEY AUTO_INCREMENT,
    order_id INT,
    FOREIGN KEY (order_id) REFERENCES orders (id),
    product_id INT,
    FOREIGN KEY (product_id) REFERENCES products (id),
    price FLOAT CHECK(price >= 0),
    number_of_products INT CHECK(number_of_products > 0),
    total_money FLOAT CHECK(total_money >= 0)
   
);
