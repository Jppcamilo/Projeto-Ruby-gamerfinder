# GameFinder API 🎮

Esta é a API RESTful do projeto **GameFinder**, desenvolvida para o gerenciamento e consulta de um catálogo de jogos. O projeto foi construído focando em maturidade e boas práticas de desenvolvimento Java, atingindo o **Nível 3 de Maturidade de Richardson** através da implementação de **HATEOAS**.

## 🚀 Tecnologias e Ferramentas

* **Java 21** (LTS)
* **Spring Boot 3.2.5**
* **Spring Data JPA** (Persistência e ORM)
* **Spring HATEOAS** (Links hipermídia)
* **H2 Database** (Banco de dados em memória)
* **Project Lombok** (Redução de boilerplate)
* **Maven** (Gerenciamento de dependências)

## 🏗️ Arquitetura do Projeto

O sistema segue uma arquitetura em camadas bem definida, garantindo a separação de responsabilidades:

1.  **Model/Entity:** Definição das tabelas e relacionamentos (`Game`, `Genre`, `Platform`).
2.  **Repository:** Interfaces que estendem `JpaRepository` para comunicação com o banco.
3.  **Service:** Camada de lógica de negócio e validações.
4.  **Controller:** Exposição dos endpoints REST e montagem dos links HATEOAS.

## 📌 Endpoints Principais

| Recurso | Método | Rota | Descrição |
| :--- | :--- | :--- | :--- |
| **Jogos** | GET | `/games` | Lista todos os jogos com paginação. |
| **Detalhes** | GET | `/games/{id}` | Retorna um jogo com seus respectivos links de navegação. |
| **Gêneros** | GET | `/games/genres/{genreId}` | Filtra jogos por categoria específica. |
| **Plataformas** | GET | `/games/platforms/{platformId}` | Filtra jogos por plataforma. |
| **Wishlist** | GET | `/games/wishlist/{id}` | Simulação de remoção da lista de desejos via HATEOAS. |

## 🔗 HATEOAS (Nível 3)

Diferente de uma API simples, esta implementação fornece links dinâmicos no corpo da resposta (`_links`). Ao consultar um jogo, a API sugere automaticamente rotas para:
* Visualizar outros jogos do mesmo gênero.
* Visualizar outros jogos da mesma plataforma.
* Ações contextuais (ex: remover da lista de desejos se o jogo já estiver nela).

## 🛠️ Como Executar

1.  Certifique-se de ter o **JDK 21** instalado.
2.  Clone o repositório e abra na sua IDE (recomendado IntelliJ IDEA).
3.  Execute o comando Maven para baixar as dependências:
    ```bash
    mvn clean install
    ```
4.  Execute a classe `GamefinderApplication.java`.
5.  Acesse o Console do Banco de Dados H2:
    * **URL:** `http://localhost:8080/h2-console`
    * **JDBC URL:** `jdbc:h2:mem:gamefinderdb`
    * **User:** `sa` | **Password:** (vazio)

---

### Autor
**João Pedro Pereira Camilo** *RM 562005* *Estudante de Análise e Desenvolvimento de Sistemas - FIAP*
**Pamella Christiny Chaves Brito** *RM 565206* *Estudante de Análise e Desenvolvimento de Sistemas - FIAP*
