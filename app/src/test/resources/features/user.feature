   # language: pt


   Funcionalidade: Criacao e Exibicao de Usuario


@deleteUser
     Cenario: Criar usuario eficaz


       Quando criar um usuario
       Entao valido usuario criado


     Esquema do Cenario: Validação da API de criação de usuário

       Quando envio dados para a criacao do usuario
       Entao valido usuario criado

       Exemplos: Dados para o teste decriação

       |username|password|firstName|lastName|     email       |phone    |status|HttpStatus|
       |Akiles  |Aki31@32|Antonio  |Akino   |Aki@mailnator.com|194334200| 1     | 200     |


