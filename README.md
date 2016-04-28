# Explore Enterprise #

O projeto trata-se de um sistema exploração de novos planetas. O sistema foi desenvolvido para NASA com objetivo de coordenar as sondas no processo de exploração dos planetas.

## Arquitetura ##

Para implementação do sistemas de exploração criamos uma arquitetura simples e eficiente utilizando spring-boot o que facilita a implementação de microseviço.

## Pré-Requisitos ##

- Java 8
- Maven

## Instalação ##

Para instalação e necessário realizar o download do código-fonte git clone  ](Link URL).
Após realizar o download do código-fonte acesse a pasta do sistema e execute os comandos abaixo:

- mvn clean install
- mvn spring-boot:run

## Explorando API REST ##

- explorar


```http

POST /missao/explorar-planalto HTTP/1.1
Host: localhost:8080
Accept: text/plain
Content-Type: text/plain
Cache-Control: no-cache

 5 5
 1 2 N
 LMLMLMLM
 3 3 E
 MMRMMRMRRM
```

- exploracao-detalhada

```http
POST /missao/exploracao-detalhada HTTP/1.1
Host: localhost:8080
Accept: application/json
Content-Type: application/json
Cache-Control: no-cache

{  
  "dimensao": {
    "comprimento": 5,
    "largura": 5
  },

  "exploradores": [
    {
      "sonda": {
        "nome": "Phoenix",
        "coordenada": {
          "latitude": 1,
          "longitude": 2
        },
        "direcao": "NORTE"
      },
      "comandos": [
        "ESQUERDA",
        "MOVER",
        "ESQUERDA",
        "MOVER",
        "ESQUERDA",
        "MOVER",
        "ESQUERDA",
        "MOVER",
        "MOVER"
      ]
    },
    {
      "sonda": {
        "nome": "Obiter",
        "coordenada": {
          "latitude": 3,
          "longitude": 3
        },
        "direcao": "LESTE"
      },
      "comandos": [
        "MOVER",
        "MOVER",
        "DIREITA",
        "MOVER",
        "MOVER",
        "DIREITA",
        "MOVER",
        "DIREITA",
        "DIREITA",
        "MOVER"
      ]
    }
  ]
}

```

## POSTMAN ##

- Dados das API REST para import:

```json
{"id":"8a21bc70-125e-2143-2bf7-dec376a65ed9","name":"explorer-enterprise","timestamp":1461692115680,"requests":[{"collectionId":"8a21bc70-125e-2143-2bf7-dec376a65ed9","id":"a28730a0-56dd-b481-2b9e-31f3a071e5e7","name":"exploracao-detalhada","description":"","url":"http://localhost:8080/missao/exploracao-detalhada","method":"POST","headers":"Accept: application/json\nContent-Type: application/json\n","data":"{  \n  \"dimensao\": {\n    \"comprimento\": 5,\n    \"largura\": 5\n  },\n\n  \"exploradores\": [\n    {\n      \"sonda\": {\n        \"nome\": \"Phoenix\",\n        \"coordenada\": {\n          \"latitude\": 1,\n          \"longitude\": 2\n        },\n        \"direcao\": \"NORTE\"\n      },\n      \"comandos\": [\n        \"ESQUERDA\",\n        \"MOVER\",\n        \"ESQUERDA\",\n        \"MOVER\",\n        \"ESQUERDA\",\n        \"MOVER\",\n        \"ESQUERDA\",\n        \"MOVER\",\n        \"MOVER\"\n      ]\n    },\n    {\n      \"sonda\": {\n        \"nome\": \"Obiter\",\n        \"coordenada\": {\n          \"latitude\": 3,\n          \"longitude\": 3\n        },\n        \"direcao\": \"LESTE\"\n      },\n      \"comandos\": [\n        \"MOVER\",\n        \"MOVER\",\n        \"DIREITA\",\n        \"MOVER\",\n        \"MOVER\",\n        \"DIREITA\",\n        \"MOVER\",\n        \"DIREITA\",\n        \"DIREITA\",\n        \"MOVER\"\n      ]\n    }\n  ]\n}","dataMode":"raw","timestamp":0,"version":2,"time":1461822532750},{"collectionId":"8a21bc70-125e-2143-2bf7-dec376a65ed9","id":"ddf8cf59-6cab-bca6-c01f-4852b5b7c9a0","name":"explorar-planalto","description":"","url":"http://localhost:8080/missao/explorar-planalto","method":"POST","headers":"Accept: text/plain\nContent-Type: text/plain\n","data":" 5 5\n 1 2 N\n LMLMLMLM\n 3 3 E\n MMRMMRMRRM\n","dataMode":"raw","timestamp":0,"version":2,"time":1461817792904}]}
```
