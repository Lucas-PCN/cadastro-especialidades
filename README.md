# Projeto Cadastro especialidades

<p>Projeto entregue durante o curso de desenvolvimento Web ministrado pela <a href="https://www.betrybe.com" targe="_blank" rel="nofollow">Trybe</a>.</p>

<p>Obtive a aprovação no projeto completando 100% dos requisitos obrigatórios e opcionais. Efetivando, assim, a conclusão do Bloco 10 (Java Web) referente a Aceleração em Java.</p>

## Descrição
Sistema web responsável por consultar, cadastrar, editar e deletar profissionais e suas especialidades no banco de dados.

### 🔴 Desenvolvimento

  - Projeto desenvolvido utilizando o framework Spring Boot na versão `2.x`;
  
  - `Maven` definido como gerenciador de dependências e ferramenta de build do projeto;
  
  - Camada de acesso a dados construída utilizando os conceitos de abstração da base de dados, disponíveis nas especificações do `JPA`;
  
  - Entidade do profissional e sua especialidade com os atributos: `id`, `name` e `speciality` implementados;
  
  - Propriedades do sistema em um arquivo `.yml` devidamente configurados, conforme a lista abaixo:
	   - Porta de execução da aplicação foi a `8080`;
	   - Datasource apontado para acessar o `H2 Database` com as seguintes credenciais: `username = speciality-app` / `password = speciality-app!`;
	
  - Propriedades do logger definidas para gerar um arquivo de logs em uma pasta especificada `./logs/speciality-app.log`, assim como o level de logging das informações.
	
  - Projeto empacotado no formato `.war` para deploy.

  
#### 📌 CRUD
  **Foram implementadas as 4 operações básicas de um CRUD (GET, POST, PUT e DELETE) utilizando as especificações do `JAX-RS`, em que cada uma dessas operações deverá corresponder a um caminho na API Rest:**
   
   🔵 `GET path = "/api/professional/all": `

   * Traz todos os registros cadastrados dos profissionais e suas especialidades. 
     
   * Caso não encontre nenhum registro, deverá retornar um `404 Not Found`, com uma mensagem de erro: "*Nenhum registro foi encontrado!*"; 

   🔵 `POST path = "/api/professional/add"`
   
   * Cadastra um novo registro no banco de dados com retorno `201 Created` e a string "*Inserido*". 
   
   * O id é autogerado e portanto não pode ser informado manualmente. 
   
   * Caso seja um `400 Bad Request`, uma mensagem "*Não é permitido inserir novos registros com ID explícito*" será exibida.
   
   🔵 `PUT path = "/api/professional/edit/{id}"`: 
   
   * Edita um registro já existente na base de dados, retorna um `200 Ok` e a string "*ID [%d] atualizado*", onde o `%d` representa o ID editado. O ID do cadastro é informado manualmente na URL.
   
   * Caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível editar, o ID informado não existe*" deve ser retornado;
   
   🔵 `DELETE path = "/api/professional/delete/{id}"`: 
 
   * Deleta um registro já existente da base de dados, retornar um `200 Ok` e a string "*ID [%d] removido*", onde o `%d` representa o ID editado. O ID do cadastro é informado manualmente na URL.
   
   * Caso ele não exista, um `404 Not Found` com a mensagem "*Não é possível deletar, o ID informado não existe*" deve ser retornado;



## Rodando o projeto localmente
  1. Clone o repositório
   
     `git@github.com:Lucas-PCN/cadastro-especialidades.git`
    
  2. Entre no diretório do repositório que você acabou de clonar:
  
     `cd cadastro-especialidades`

  3. Instale as dependências:
    
     `mvn install`

---

Projeto desenvolvido por Lucas Castanheira, para fins didáticos. 2023
