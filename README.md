# original

Criado um projeto para pesquisa de endereço via api externa e salvando em um banco local(h2)

Chamada da api externa
GET: localhost:8080/wmj/v2/endereco/{{cep}}

Chamada para salvar um endereço
POST: localhost:8080/wmj/v1/endereco
{
    "numero": "1000",
    "complemento": "apto 90",
    "bairro": "Jardim Angélica",
    "cep": "07260-470",
    "localidade": "Guarulhos",
    "uf": "SP",
    "logradouro": "Rua Victorino Bento Lorena da Silva"    
}

Chamada de busca pelo endereço salvo

GET: localhost:8080/wmj/v1/endereco/id
retorno:{
    "id": 1,
    "numero": "1000",
    "complemento": "apto 90",
    "bairro": "Jardim Angélica",
    "cep": "07260-470",
    "localidade": "Guarulhos",
    "uf": "SP",
    "logradouro": "Rua Victorino Bento Lorena da Silva"
}


Chamada de alteração de endereço
PUT: localhost:8080/wmj/v1/endereco/id
{
    
    "numero": "320",
    "complemento": "casa 2",
    "bairro": "Jardim Angélica",
    "cep": "07260-470",
    "localidade": "Guarulhos",
    "uf": "SP",
    "logradouro": "Rua Victorino Bento Lorena da Silva"
}

Chamada de deletar de endereço
DELETE: localhost:8080/wmj/v1/endereco/id
response: 204
