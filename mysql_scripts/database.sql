-- Inclua aqui seu script SQL para criar o banco de dados
-- Crie também alguns registros pra ajudar a nossa revisão? :)

-- O que costumo fazer: crio o banco de dados, depois gero um dump dele 
-- no padrão sql e coloco aqui. Assim fica mais fácil já ter um script
-- com todos os registros.

-- Qualquer coisa, só me chamar, ok? 
-- Meu e-mail é kico@itexto.com.br !

CREATE DATABASE IF NOT EXISTS devall CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci;
USE devall;

-- Sites
CREATE TABLE site (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(255) NOT NULL,
  url VARCHAR(512) NOT NULL,
  rss VARCHAR(512),
  about TEXT,
  iframe BOOLEAN NOT NULL DEFAULT FALSE
);

-- Posts
CREATE TABLE post (
  id INT AUTO_INCREMENT PRIMARY KEY,
  title VARCHAR(255) NOT NULL,
  summary TEXT,
  url VARCHAR(512) NOT NULL,
  site_id INT NOT NULL,
  index_date DATETIME NOT NULL,
  pub_date DATETIME NOT NULL,
  clicks BIGINT NOT NULL DEFAULT 0,
  FOREIGN KEY (site_id) REFERENCES site(id)
);

-- (Optional) API Keys for auth
CREATE TABLE api_key (
  id INT AUTO_INCREMENT PRIMARY KEY,
  key_value CHAR(36) NOT NULL UNIQUE,
  description VARCHAR(255),
  created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP
);

-- Initialize a default key (UUID4)
INSERT INTO api_key (key_value, description) VALUES ('00000000-0000-0000-0000-000000000000','default for testing');
