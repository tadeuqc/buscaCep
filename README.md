# BuscaCep

Um buscador simples de geocodes do Google Maps usando Java Spring Shell, RestTemplate e Gradle como Build Manager. 

# Requerimentos:

- java8
- jdk 1.8

# Como rodar

1. Primeiro deve ser criada uma chave de API do google. Isto pode ser feito em https://developers.google.com/maps/documentation/embed/get-api-key

2. Preencher a chave google.ApiKey no arquivo application.properties com a chave criada no passo 1.

3. Por fim, basta criar o build e rodar o jar em seguida:

    ./gradlew build && java -jar build/libs/buscaCep-0.0.1-SNAPSHOT.jar


# RoadMap

O sistema foi criado pensando principalmente em validar o conceito rapidamente, mas pode se tornar um exemplo sólido se as seguintes tarefas forem executadas:

 - Criar um aspect para extender as funcionalidades do ResultHandler do Spring Shell. Assim as mensagens de erro em comandos não reconhecidos possam ser traduzidas

- Implementar um link de resposta para abrir a localização no Maps no navegador

- Apresentar os resultados em forma de tabela, como no Cliente Console do MySQL. 
	> Nota: O Spring Shell dá suporte a criação destas tabelas, é necessário implementar ObjectMapping e testar com calma..


