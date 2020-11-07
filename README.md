# BuscaCep

Um buscador simples de geocodes do Google Maps usando Java Spring Shell, RestTemplate e Gradle como Build Manager.

# Como rodar

Basta criar o build e rodar o jar em seguida:

    ./gradlew build && java -jar build/libs/buscaCep-0.0.1-SNAPSHOT.jar


# RoadMap

O sistema foi criado pensando principalmente em validar o conceito rapidamente, mas pode se tornar um exemplo sólido se as seguintes tarefas forem executadas:

 - Criar um aspect para extender as funcionalidades do ResultHandler do Spring Shell. Assim as mensagens de erro em comandos não reconhecidos possam ser traduzidas

- Implementar um link de resposta para abrir a localização no Maps no navegador

- Apresentar os resultados em forma de tabela, como no Cliente Console do MySQL. 
	> Nota: O Spring Shell dá suporte a criação destas tabelas, é necessário implementar ObjectMapping e testar com calma..


