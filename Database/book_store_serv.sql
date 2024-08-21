CREATE SCHEMA IF NOT EXISTS book_store_serv;

CREATE TABLE book_store_serv.book_catalog (
    book_id INT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    genre VARCHAR(100) NOT NULL,
    author VARCHAR(100) NOT NULL,
    published_year INT NOT NULL,
    stock INT NOT NULL,
    price DECIMAL(10, 2) NOT NULL
);

INSERT INTO book_store_serv.book_catalog (book_id, title, genre, author, published_year, stock, price)
VALUES
    (1, 'To Kill a Mockingbird', 'Fiction', 'Harper Lee', 1960, 50, 120.00),
    (2, '1984', 'Science Fiction', 'George Orwell', 1949, 30, 300.00),
    (3, 'Pride and Prejudice', 'Romance', 'Jane Austen', 1813, 75, 200.00),
    (4, 'The Alchemist', 'Fiction', 'Paulo Coelho', 1988, 100, 150.00),
    (5, 'The Hunger Games', 'Science Fiction', 'Suzanne Collins', 2008, 60, 250.00),
	(6, 'Half Girlfriend', 'Romance', 'Chetan Bhagat', 2011, 100, 190.00);

CREATE TABLE book_store_serv.book_reviews (
    book_review_id INT PRIMARY KEY,
    book_review_text TEXT NOT NULL
);

INSERT INTO book_store_serv.book_reviews (book_review_id, book_review_text)
VALUES 	(1, 'This book is a  masterpiece ! Highly recommended'),
		(2, 'Slow-paced'),
		(3, 'The plot was predictable and the characters lacked depth.'),
		(4, 'The writing felt amateurish, and the dialogue was often unrealistic.'),
		(5, 'Recommended for personal growth and self-discovery.');
        
CREATE TABLE book_store_serv.books_bought (
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    quantity INT NOT NULL,
    PRIMARY KEY (user_id, book_id)
);

INSERT INTO book_store_serv.books_bought (user_id, book_id, quantity)
VALUES
    (1, 1, 2),
    (1, 3, 1),
    (2, 2, 3),
    (3, 4, 1),
    (3, 5, 2);
    
CREATE TABLE book_store_serv.books_reviewed (
    book_review_id INT PRIMARY KEY,
    user_id INT NOT NULL,
    book_id INT NOT NULL,
    score INT NOT NULL CHECK (score BETWEEN 1 AND 5)
);

INSERT INTO book_store_serv.books_reviewed (book_review_id, user_id, book_id, score)
VALUES
    (1, 1, 1, 4),
    (2, 2, 2, 3),
    (3, 1, 3, 5),
    (4, 3, 4, 2),
    (5, 2, 5, 4);

CREATE TABLE book_store_serv.books_store_users (
    user_id INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

INSERT INTO book_store_serv.books_store_users (username, first_name, last_name, email, password)
VALUES
    ('user1', 'John', 'Doe', 'john.doe@example.com', 'password123'),
    ('user2', 'Jane', 'Smith', 'jane.smith@example.com', 'qwerty456'),
    ('user3', 'Michael', 'Johnson', 'michael.johnson@example.com', 'abc123def'),
    ('user4', 'Emily', 'Williams', 'emily.williams@example.com', 'securepassword'),
    ('user5', 'David', 'Brown', 'david.brown@example.com', 'p@ssw0rd');

