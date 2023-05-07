create table users
(
    id       BIGSERIAL primary key,
    login    text NOT NULL,
    password text NOT NULL
);

CREATE INDEX user_login_ind ON users (login);
CREATE INDEX user_password_ind ON users (password);