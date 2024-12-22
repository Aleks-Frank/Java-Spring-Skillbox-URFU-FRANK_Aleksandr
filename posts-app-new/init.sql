CREATE TABLE users
(

    id SERIAL PRIMARY KEY,
    nameUser VARCHAR(100) NOT NULL,
    emailUser VARCHAR(100) NOT NULL UNIQUE

)

CREATE TABLE categories
(

    id SERIAL PRIMARY KEY,
    nameCategory VARCHAR(100) NOT NULL UNIQUE

)

CREATE TABLE posts
(

    id SERIAL PRIMARY KEY,
    headLine VARCHAR(255) NOT NULL,
    bodyLine TEXT NOT NULL,
    idAuthor INT NOT NULL,
    idCategory INT NOT NULL,
    FOREIGN KEY (idAuthor) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (idCategory) REFERENCES categories (id) ON DELETE CASCADE

)

CREATE TABLE comments
(

    id SERIAL PRIMARY KEY,
    bodyLine TEXT NOT NULL,
    idAuthor INT NOT NULL,
    idPosts INT NOT NULL,
    FOREIGN KEY (idAuthor) REFERENCES users (id) ON DELETE CASCADE,
    FOREIGN KEY (idPosts) REFERENCES posts (id) ON DELETE CASCADE

)
