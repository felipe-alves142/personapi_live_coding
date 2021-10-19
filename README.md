# Personapi

Personapi é um projeto feito no bootcamp Capgemini Fullstack Java and Angular. É uma api para controle de pessoas, suas funcionalidades são:

  - Cadastrar dados de pessoas. Por exemplo: nome,idade e número de telefone
  - Listar todas as pessoas cadastradas pelo id
  - Deletar pessoas pelo id
  - Mudar dados já existentes

## Como executar o projeto

  - Clone o projeto
  - Execute o projeto
  - Baixe algum API client, nesse projeto foi usado o Postman
  
  ### Cadastre a pessoa ( No campo type pode ser COMMERCIAL, MOBILE e HOME 
  ```sh 
    {
    "firstName":"Nome",
    "secondName":"Sobrenome",
    "cpf":"cpf",
    "birthDate":"Data de nascimento",
    "phones":[
        {
            "type":"COMMERCIAL", 
            "number":"(11)99999994"
        }
    ]
}
  ```
  
  ### Encontrar uma pessoa pelo id 
  ```sh
  http://localhost:8080/api/v1/people/(Coloque o id que quer encontrar)
  ```
  O resultado será este 
  
  ```sh
  {
    "id": 1,
    "firstName": "Felipe",
    "secondName": "Alves",
    "birthDate": "2002-10-28",
    "cpf": "",
    "phones": [
        {
            "id": null,
            "type": null,
            "number": null
        }
    ]
}
  ```
  - Deletar uma pessoas pelo id
  
  No API client que está usando troque o verbo http por DELETE
  ```sh
  http://localhost:8080/api/v1/people/(Coloque o id que quer deletar)
  ```
   No API client que está usando troque o verbo http por PUT
  ```sh
  http://localhost:8080/api/v1/people/(Coloque o id da pessoas que que quer modificar)
  ```
  Mude os dados que quer
  ```sh 
  {
    "id": 1,
    "firstName": "Felipe",
    "secondName": "Alves",
    "birthDate": "2002-10-28",
    "cpf": "",
    "phones": [
        {
            "id": null,
            "type": null,
            "number": null
        }
    ]
}
```
</ul>
