CREATE TABLE book (
  id INT NOT NULL PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  price DECIMAL(10,2) NOT NULL,
  publication_date DATE NOT NULL
);


