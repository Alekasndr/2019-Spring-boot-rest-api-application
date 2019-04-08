-- Table: users
CREATE TABLE users (
  id       INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  username VARCHAR(255) NOT NULL,
  password VARCHAR(255) NOT NULL
)
  ENGINE = InnoDB;

-- Table: roles
CREATE TABLE roles (
  id   INT          NOT NULL AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100) NOT NULL
)
  ENGINE = InnoDB;

-- Table for mapping user and roles: user_roles
CREATE TABLE user_roles (
  user_id INT NOT NULL,
  role_id INT NOT NULL,

  FOREIGN KEY (user_id) REFERENCES users (id),
  FOREIGN KEY (role_id) REFERENCES roles (id),

  UNIQUE (user_id, role_id)
)
  ENGINE = InnoDB;

-- Insert data

INSERT INTO users VALUES (1, 'proselyte', '$2a$11$uSXS6rLJ91WjgOHhEGDx..VGs7MkKZV68Lv5r1uwFu7HgtRn3dcXG');

INSERT INTO roles VALUES (1, 'ROLE_USER');
INSERT INTO roles VALUES (2, 'ROLE_ADMIN');

INSERT INTO user_roles VALUES (1, 2);


-- Table: subscription
CREATE TABLE subscription(
    id           INT AUTO_INCREMENT PRIMARY KEY,
    price        INT NOT NULL,
    subscription_name VARCHAR(255),

    UNIQUE (subscription_name)
)

    ENGINE = InnoDB;



-- Table: billing_account
CREATE TABLE billing_account(
     id           INT AUTO_INCREMENT PRIMARY KEY,
     billing_name     VARCHAR(255) NOT NULL,

     UNIQUE (billing_name)
)

    ENGINE = InnoDB;


-- Table: user_subscription
CREATE TABLE user_subscription(
    username_id          INT NOT NULL,
    user_subscription_id INT NOT NULL,

    FOREIGN KEY (username_id) REFERENCES users (id),
    FOREIGN KEY (user_subscription_id) REFERENCES subscription (id)
)
    ENGINE = InnoDB;


-- Table: user_billing_account
CREATE TABLE user_billing_account(
    username_id          INT NOT NULL,
    billing_name_id      INT NOT NULL,
    money                INT,

    FOREIGN KEY (username_id) REFERENCES users (id),
    FOREIGN KEY (billing_name_id) REFERENCES billing_account (id)
)
    ENGINE = InnoDB;
