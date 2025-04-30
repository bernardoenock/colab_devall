# Colab dev/All

Contributions to /dev/All 2025 — a platform for sharing and curating technical articles on software development and architecture, created by itexto Consultoria. 🚀 devall.com.br

## API

[Ver código](api)

## CLIENT

[Ver Front](https://bernardoenock.github.io/colab_devall/)
[Ver código](client)

## INICIAR LOCALMENTE

Para rodar o projeto localmente, siga os passos abaixo:

1. **Certifique-se de ter o Docker, Docker Compose e Node.js instalados na sua máquina.**
   - Para instalar o Docker: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)
   - Para instalar o Docker Compose: [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)
   - Para instalar o Node.js (npm é instalado junto automaticamente): [https://nodejs.org/](https://nodejs.org/)


2. **Clone o repositório:**

   ```bash
   git clone git@github.com:bernardoenock/colab_devall.git
   cd colab_devall
   ```

3. **Rodar o projeto:**

   Agora, você pode iniciar os containers da API e do frontend com o seguinte comando:

   ```bash
   npm run avaliar
   ```

   O comando irá orquestrar o Docker Compose para iniciar tanto a API quanto o frontend.
   Aguarde uns 2 minutinhos e a aplicação estara disponivel para avaliação.

4. **Acessando a aplicação:**

   - **API:** A API estará disponível em `http://localhost:8080/api/v2/docs`
     - Acesse a documentação e teste as rotas da [API](api)
   - **Frontend:** O cliente (frontend) estará disponível em `http://localhost:5173`
     - Click no botão `start` para visualizar os Posts do Crowler.

Isso deve levantar os containers de ambos os serviços e você poderá acessar a aplicação localmente.
