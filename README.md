# Documentação das Utilidades de Banco de Dados

## `DatabaseUtil`

### Descrição

A classe `DatabaseUtil` fornece métodos utilitários para gerenciar conexões com o banco de dados. Ela oferece uma maneira centralizada de obter e fechar conexões, facilitando o gerenciamento de recursos do banco de dados.

### Métodos

- **getConnection**
    - **Descrição**: Retorna uma conexão com o banco de dados. Se a conexão ainda não tiver sido estabelecida, ela será criada. O método garante que sempre haverá uma única instância de conexão (padrão singleton).
    - **Retorno**: `Connection` - A conexão com o banco de dados.
- **closeConnection**
    - **Descrição**: Fecha a conexão com o banco de dados, se ela estiver aberta. É útil para garantir que os recursos sejam liberados corretamente após o uso.
    - **Parâmetros**:
        - `connection` (`Connection`): A conexão a ser fechada.

---

## `DBUtil`

### Descrição

A classe `DBUtil` fornece métodos utilitários para executar consultas e atualizações no banco de dados. Ela abstrai operações comuns, como executar consultas SQL e atualizar registros, para evitar duplicação de código e facilitar a manutenção.

### Métodos

- **executeUpdate**
    - **Descrição**: Executa uma atualização no banco de dados, como operações de inserção, atualização ou exclusão (INSERT, UPDATE, DELETE).
    - **Parâmetros**:
        - `sql` (`String`): A consulta SQL a ser executada.
        - `consumer` (`SQLConsumer<PreparedStatement>`): Uma expressão lambda ou classe que consome um `PreparedStatement` para configurar os parâmetros da consulta.
    - **Exceções**: Pode lançar `SQLException`.
- **executeQuery**
    - **Descrição**: Executa uma consulta SELECT no banco de dados e retorna o resultado.
    - **Parâmetros**:
        - `sql` (`String`): A consulta SQL a ser executada.
        - `consumer` (`SQLConsumer<PreparedStatement>`): Uma expressão lambda ou classe que consome um `PreparedStatement` para configurar os parâmetros da consulta.
    - **Retorno**: `ResultSet` - O resultado da consulta.
    - **Exceções**: Pode lançar `SQLException`.

### Interface SQLConsumer

- **SQLConsumer**
    - **Descrição**: Uma interface funcional que representa uma operação que aceita um único argumento de entrada e pode lançar uma `SQLException`.
    - **Método**:
        - `accept(T t)`: Executa a operação.
        - **Parâmetros**:
            - `t` (`T`): O argumento de entrada.
        - **Exceções**: Pode lançar `SQLException`.

---

## `SQLExceptionUtil`

### Descrição

A classe `SQLExceptionUtil` fornece um método utilitário para tratar exceções SQL e padronizar as mensagens de erro. Isso facilita a depuração e o tratamento consistente de erros relacionados ao banco de dados.

### Métodos

- **handleSQLException**
    - **Descrição**: Trata uma exceção SQL, imprimindo uma mensagem de erro padronizada no console.
    - **Parâmetros**:
        - `e` (`SQLException`): A exceção SQL a ser tratada.