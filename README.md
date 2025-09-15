# Modelagem de API

Nesta atividade, você irá modelar dados para uma API de posts do **IFgram** (o Instagram do IF), baseando-se nos seguintes conceitos de domínio:

### Postagem

* Representa conteúdos compartilhados pelos usuários, como fotos, textos ou links.
* **Atributos:** `id`, `titulo`, `conteudo`, `dataCriacao`.

---



## Exercício 1 : 


Baseado na especificação do início deste documento para o IFgram, modele endpoints, preenchendo a tabela com a modelagem da sua API, bem como a especificação do esquema (Schema) em JSON. Para validar o seu JSON, use algum site de validação.


### Especificação do esquema em JSON

O esquema a seguir representa um único recurso **Postagem**, conforme os atributos definidos no documento (`id`, `titulo`, `conteudo`, `dataCriacao`).

```
{
  "id": 1,
  "titulo": "Primeira Postagem!",
  "conteudo": "Minha 1ª postagem!",
  "dataCriacao": "2025-09-01T10:30:00Z"
}

```

![Validação JSON](assets/images/validadorJSON.png "Captura de tela do validador JSON")

#Definição dos endpoints para o recurso

A tabela a seguir representa os endpoints para o recurso **Postagem**.

| **Verbo HTTP** | **Endpoints (path)** | **Descrição** | **Input** | **Outputs** | **Cód. Sucesso** | **Cód. Falha** |
| :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| **GET** | `/postagens` | Listagem de todas as postagens. | *(Nenhum)* | `[{ "id": 1, "titulo": "...", "conteudo": "...", "dataCriacao": "..." }, { "id": 2, "titulo": "...", "conteudo": "...", "dataCriacao": "..." }]` | 200 OK | 500 Internal Server Error |
| **POST** | `/postagens` | Adição de uma nova postagem. | `{ "titulo": "Nova Postagem", "conteudo": "Conteúdo aqui." }` | `{ "id": 3, "titulo": "Nova Postagem", "conteudo": "Conteúdo aqui.", "dataCriacao": "..." }` | 201 Created | 400 Bad Request |
| **GET** | `/postagens/{id}` | Detalhes de uma postagem específica. | *(Nenhum)* | `{ "id": 1, "titulo": "...", "conteudo": "...", "dataCriacao": "..." }` | 200 OK | 404 Not Found |
| **PUT** | `/postagens/{id}` | Atualização de uma postagem existente. | `{ "titulo": "Título Atualizado", "conteudo": "Conteúdo atualizado." }` | `{ "id": 1, "titulo": "Título Atualizado", "conteudo": "Conteúdo atualizado.", "dataCriacao": "..." }` | 200 OK | 400 Bad Request / 404 Not Found |
| **DELETE** | `/postagens/{id}` | Remoção de uma postagem. | *(Nenhum)* | *(Corpo da resposta vazio)* | 204 No Content | 404 Not Found |

---

## Exercício 2: 

Implemente a API que você modelou em um projeto **Java** com **Spring Web MVC**, seguindo as práticas e exemplos apresentados em sala de aula.





