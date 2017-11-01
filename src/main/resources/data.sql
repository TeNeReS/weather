-- admin
INSERT INTO users (name, email, password)
VALUES ('User', 'user@yandex.ru', '$2a$10$QDXX0IOB0NGn5zSFeSBFRuq4Z7XZl1MuYI0gFD8lPj.wf5FA1re8G');

-- password
INSERT INTO users (name, email, password)
VALUES ('Admin', 'admin@gmail.com', '$2a$10$9WTHXgCJpl72WWabtAoPl./JVFAnmDEcqV8xNgzIgLmK69Zt30FCa');

INSERT INTO user_roles (user_id, role) VALUES
  (100000, 'USER'),
  (100001, 'ADMIN'),
  (100001, 'USER');