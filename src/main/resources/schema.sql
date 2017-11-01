DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP SEQUENCE IF EXISTS global_seq;

CREATE SEQUENCE global_seq START WITH 100000;

CREATE TABLE users
(
  id                        INTEGER DEFAULT NEXTVAL ('global_seq'),
  name                      VARCHAR NOT NULL,
  email                     VARCHAR NOT NULL,
  password                  VARCHAR NOT NULL,
  account_non_expired       BOOLEAN DEFAULT TRUE,
  account_non_locked        BOOLEAN DEFAULT TRUE,
  credentials_non_expired   BOOLEAN DEFAULT TRUE,
  enabled                   BOOLEAN DEFAULT TRUE,
  PRIMARY KEY (id)
);
CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
  user_id INTEGER NOT NULL,
  role    VARCHAR,
  CONSTRAINT user_roles_idx UNIQUE (user_id, role),
  FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);