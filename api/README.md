# API Colab dev/All

## Technologies

- Framework: Spring Boot 3.4.5
  - Dependencies:
    - Spring Boot Dev Tools
    - Lombok
    - Spring Web
- Project: Gradle - Groovy
- Languege: Java 17

## Subir a API LOCALMENTE

1. **Certifique-se de ter o Docker e Docker Compose instalados na sua máquina.**
   - Para instalar o Docker: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)
   - Para instalar o Docker Compose: [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)
  
2. **Na raiz do projeto rode o docker-compose**
  ```bash
   docker compose up
  ```

4. **Acessando a aplicação:**
   - A api (backend) estará disponível em `http://localhost:8080`:
     - Documentação: `http://localhost:8080/api/v2/docs`
     - Listar Posts: `http://localhost:8080/api/v2/posts?search=`
     - Clickar no Post: `http://localhost:8080/api/v2/posts/${id}/click`
     - Quantos cliques tem o Post: `http://localhost:8080/api/v2/posts/cliques/${id}/count`

## Dificuldades

1) Criar uma estrutura docker para a api que reflita as alterações no projeto instantaneamente, para trazer um ambiente de desenvolvimento produtivo.
2) Colocar o arquivo `openapi.yml` para ser visualizado como rota em `/docs`.
3) Popular o banco com os dados já existentes em `https://devall.com.br/`.
