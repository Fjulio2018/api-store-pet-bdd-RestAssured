#language: pt
Funcionalidade: Criacao e Exibicao de Usuario


@deleteUser
Cenario: Criar usuario eficaz

Quando criar um usuario
Entao valido usuario criado

Esquema do Cenario: Campos obrigatórios

Dado que envio dados para a criacao do usuario
        | username         | <username>   |
        | password         | <password>   |
        | firstName        | <firstName>  |
        | lastName         | <lastName>   |
        | email            | <email>      |
        | phone            | <phone>      |
        | status           | <status>     |
        | HttpStatus       | <HttpStatus> |




Quando preformo a criação dos usuarios
Entao valido os dados do usuario criado

Exemplos:
| username | password | firstName | lastName | email              | phone     | status | HttpStatus |
| Akiles   | Aki31@32 | Antonio   | Akino    | Aki@mailnator.com  | 194334200 | 1      | 200              |
| Outro    | Senha123 | Joao      | Silva    | joao@mailnator.com | 987654321 | 1      | 200              |

