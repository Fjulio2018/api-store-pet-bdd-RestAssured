# language: pt
Funcionalidade: Criacao e Exibicao de Usuario


  Esquema do Cenario: Criacao e Exibicao de Usuario

    Dado que envio dados para a criacao do usuario
      | id   | username   | password   | firstName   | lastName   | email   | phone   | userStatus   | HttpStatus   | MSG   |
      | <id> | <username> | <password> | <firstName> | <lastName> | <email> | <phone> | <userStatus> | <HttpStatus> | <MSG> |

    Quando preformo a criacao dos usuarios
    Entao valido os dados dos usuarios criados

    Exemplos: Criacao e Exibicao de Usuario com sucesso
      | id   | username | password | firstName | lastName  | email             | phone       | userStatus | HttpStatus | MSG  |
      | 3766 | Akiles   | Aki31@32 | Antonio   | Akino     | Aki@mailnator.com | 19994334200 | 1          | 200        | xpto |
      | 0007 | Jupiter  | @JP@32   | João      | Pitolomeu | Jup@mailnator.com | 19994334333 | 1          | 200        | xpto |


  Esquema do Cenario: Validação de retorno de erros da API de usuarios

    Dado que envio dados para a criacao do usuario
      | id   | username   | password   | firstName   | lastName   | email   | phone   | userStatus   | HttpStatus   | MSG   |
      | <id> | <username> | <password> | <firstName> | <lastName> | <email> | <phone> | <userStatus> | <HttpStatus> | <MSG> |

    Quando preformo a criacao dos usuarios
    Entao valido retornos e mensagens de erro


    Exemplos: Criacao e Exibicao de Usuario sem sucesso
      | id   | username      | password | firstName | lastName | email               | phone        | userStatus | HttpStatus | MSG                                                                      |
      | 7733 | SemUserStatus | Aki31@32 | Not       | StatuId  | NoSId@mailnator.com | 1999435463   |            | 400        | Input error: unable to convert input to io.swagger.petstore.model.User |
      |      | CaraSemID     | 822626   | Não       | ID       | NoId@mailnator.com  | 199943383763 |    1        | 400        | Input error: unable to convert input to io.swagger.petstore.model.User |
