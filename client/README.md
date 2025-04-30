# CLIENT Colab dev/All

## Technologies

- React 
- TypeScript
- Vite
- Axios
- Github Pages

## Subir somente o cliente

1. **Certifique-se de ter o Docker e Docker Compose instalados na sua máquina.**
   - Para instalar o Docker: [https://docs.docker.com/get-docker/](https://docs.docker.com/get-docker/)
   - Para instalar o Docker Compose: [https://docs.docker.com/compose/install/](https://docs.docker.com/compose/install/)
  
2. **Na raiz do projeto rode o docker-compose**
  ```bash
   docker compose up
  ```

4. **Acessando a aplicação:**
   - O cliente (frontend) estará disponível em `http://localhost:5173`:
     - Click no botão `start` para visualizar os Posts do Crowler.
     - Para usar a API official `https://api.devall.com.br/api/v2` descomente o codigo que tem incluido a url da api e comente a linha que usa a url local.
     - Caso não queira usar a API official, suba a [API Localmente](../api/) antes de subir o CLIENT.

## Dificuldades

1) Integrar o docker dessa aplicação front-end junto com a api.
2) Fazer um deploy visual com github pages