# language: pt

Funcionalidade: Criacao e Exibicao de Usuario

  @deleteUser
  Cenario: Criar usuario eficaz

    Quando criar um usuario
    Entao valido usuario criado


  Esquema do Cenario: Validação da API de criação de usuário


    Dado envio dados para a criacao do usuario
      | username | password | firstName | lastName | email              | phone     | status | HttpStatus |
      | Akiles   | Aki31@32 | Antonio   | Akino    | Aki@mailnator.com  | 194334200 | 1      | 200        |
      | Jaranha  | Senha123 | Joao      | Aranha   | joa@mailnator.com  | 987654321 | 1      | 200        |
    Entao valido os dados do usuario criado




