   # language: pt


   Funcionalidade: Criar e visualizar pedidos


     Cenario: Listar pedidos com sucesso

       Dado que tenha pedidos feitos
       Quando Procurar por pedidos com status pending
       Entao os pedidos com status pending serao listados
