   # language: pt


   Funcionalidade: Criar e visualizar pedido


     Cenario: Listar pedido com sucesso

       Dado que tenha pedidos feitos
       Quando procurar por id do pedidos
       Entao o pedido com status placed sera apresentado
