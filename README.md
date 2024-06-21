# Spring Boot com Localstack
Criando uma aplicação com Spring Boot que funciona com os recursos do LocalStack e da AWS.

## Requisitos para executar a aplicação:
  * Java
  * Maven
  * Git
  * Aws CLI
  * Docker

## Serviços Aws utilizados:
  * Parameter Store
  * S3
  * SQS
  * SNS
  * Secrets Manager

## Passo a passo para executar a aplicação:
  - Adicionar na inicialização o profile do localstack:
  ```
  spring.profiles.active=localstack
  ```
  - Executar os docker compose:
    - Na raiz do projeto e dentro da pasta localstack execute o comando:
    ```
    docker compose up
    ```
  - Criar configurações para os Serviços AWS:
    - Dentro da pasta localstack execute os comando dentro do arquivo:
    ```
    loaclstack.bat
    ```
  - Executar a aplicação:
    ```
    run
    ```
## Referências:
  * https://www.zup.com.br/blog/localstack-simule-ambientes-aws-localmente
  * https://medium.com/@valdemarjuniorr/como-configurar-localstack-para-mapear-servicos-da-aws-c8c25e6363b4
  * https://medium.com/itautech/como-economizar-recursos-e-testar-suas-aplica%C3%A7%C3%B5es-aws-em-ambientes-controlados-fb97e8b9f9bc
  * https://medium.com/@thomsdacosta
  * https://docs.localstack.cloud/user-guide/aws/sns/
  * https://docs.localstack.cloud/user-guide/aws/sqs/
  * https://docs.localstack.cloud/user-guide/aws/secretsmanager/
  * https://docs.localstack.cloud/user-guide/aws/ssm/