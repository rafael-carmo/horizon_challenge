# horizon_challenge
A Horizon Air Lines é um sistema de controle de voos, passageiros e passagens áreas, feito como desafio técnico da Horizon.

## Funcionalidades:
- Autenticação de gestores **(não atendida)**
- Listar aeroportos **(atendida)**
- Cadastrar, listar, alterar e cancelar voos **(atendida)**
- Cadastrar e alterar preços das passagens **(atendida)**
- Listar passageiros de um voo **(atendida)**
- Comprar passagens **(atendida)**
- Obter as passagens compradas pelo CPF do comprador **(atendida)**
- Cancelar compra **(atendida)**
- Emitir o voucher da passagem **(não atendida)**
- Emitir etiqueta de bagagem **(não atendida)**

## Templates Postman/Insomnia

- Salvar Areporto:
{
    "cidade_id": 2,
    "nome": "Aeroporto Internacional de Guarulhos",
    "codigoIata": "GRU"
}

- Salvar voos:
{
    "aeroporto_origem_id": 2,
    "aeroporto_destino_id": 1,
    "number": 1000,
    "cancelado": false,
    "classes": [
        {
            "tipo": "G",
            "qtdAssentos": 300,
            "valor": 1500.00
        },
        {
            "tipo": "H",
            "qtdAssentos": 500,
            "valor": 1000.00
        }
    ]
}

- Update voo:
{
    "aeroporto_origem_id": 2,
    "aeroporto_destino_id": 3,
    "number": 1003,
    "dataPartida": null    
}

- Salvar classe:
{
    "voo_id": 1,
    "tipo": "J",
    "qtdAssentos": 5,
    "valor": 15350.90
}

- Update Classe:
{
    "tipo": "J",
    "qtdAssentos": 5,
    "valor": 10000.00
}

- Comprar Passagem:
{
    "passageiro_id": 1,
    "classe_id": 2,
    "comprador_id": 2,
    "numero": 12390,
    "preco": 1650.00,
    "cancelada": false,
    "despachoBagagem": false

}

## Ficou faltando:
- Autenticação/Autorização
- Impressão voucher/etiquetas bagagens
- Validação de campos de entrada
- Frontend
- Hospedagem back/front

## Arquivo docker-compose.yml
- Coloquei o arquivo docker-compose em outra pasta, e subo os containers por lá, caso gere algum erro de permissão de acesso/escrita à pasta do pgadmin, executar comando **sudo chown -R 5050:5050 .data/pgadmin/** na pasta **.data**. 
