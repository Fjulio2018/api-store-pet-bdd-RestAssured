# language: pt

Funcionalidade: Criacao e Exibicao de Usuario

  @deleteUser
  Cenario: Criar usuario eficaz

    Quando criar um usuario
    Entao valido usuario criado

  Esquema do Cenario: Validação da API de criação de usuário


    Dado envio dados para a criacao do usuario
      | Apelido          | <username>   |
      | Senha            | <password>   |
      | Primeiro nome    | <firstName>  |
      | Ultimo nome      | <lastName>   |
      | Email            | <email>      |
      | Celular          | <phone>      |
      | Status           | <status>     |
      | Http Status code | <HttpStatus> |


    Entao valido os dados do usuario criado

    Exemplos: para o teste de criacao
      | username | password | firstName | lastName | email              | phone     | status | HttpStatus |
      | Akiles   | Aki31@32 | Antonio   | Akino    | Aki@mailnator.com  | 194334200 | 1      | 200        |
      | Outro    | Senha123 | Joao      | Silva    | joao@mailnator.com | 987654321 | 1      | 200        |
      | ...      | ...      | ...       | ...      | ...                | ...       | ...    | ...        |
