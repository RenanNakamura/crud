# Cadastro de desenvolvedor

Para o teste foi desenvolvido um cadastro de desenvolvedores, onde contém um cadastro simples de níveis e desenvolvedores.

## Registros de Decisões de Arquitetura (ADRs)

- [ADR.001 - CQS]
- [ADR.002 - Arquitetura Hexagonal]
- [ADR.003 - UseCase]

## Compilação

Pré-requisitos:

- Java 11;
- Apache Maven 3.8.1

## Executando aplicação via docker-compose

Para que fique mais simples, a imagem do projeto foi publicado no dockerHub. Execute o seguinte comando para executar:

```bash
docker-compose up -d
```

## Acessando a documentação do swagger

Para acessar a documentação da api, acessar pelo browser o caminho. No swagger contém comente as api de comando, ficou faltando
as api de querys. Caso prefira testar pelo postman, segue os arquivos para cadastro de desenvolvedores e níveis,
respectivamente:

- [POSTMAN - desenvolvedor]
- [POSTMAN - nível]

```bash
http://127.0.0.1:8080/swagger-ui.html#/
```

[ADR.001 - CQS]: ./docs/ADR.001.md

[ADR.002 - Arquitetura Hexagonal]: ./docs/ADR.002.md

[ADR.003 - UseCase]: ./docs/ADR.003.md

[POSTMAN - desenvolvedor]: desenvolvedor.postman_collection.json

[POSTMAN - nível]: nivel.postman_collection.json
