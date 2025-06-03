### Change Data Capture d'une application Spring Boot vers une base de données Postgre, en passant par Kafka

Aprés avoir créer le projet Spring boot, veuillez ajouter le schema avro order.avsc exactement dans : 

<code> /src/resources/avro/order.avsc </code>

Exécuter un <code> mvn clean install </code> pour générer le package dto dans le package com.dione.dto que vous avez spécifié dans le schéma.

## Que se passe t-il si toute la configuration s'est bien passée

Aprés avoir démarré l'application, vous pouvez utiliser postman pour envoyer une requête post :
<img src="Request Order.png"/>

D'aprés la sortie de postman, le message a été envoyé avec succés !

Pour vérifier cela, vous devez naviguer vers le control center de confluente pour visualiser non seulement le message dans le topic OrderRequest mais également la présence du schéma Avro.

## NB : Kafka manipule uniquement des chaînes de caractères (strings). Or, dans le cadre de cette étude, les messages reçus doivent être insérés directement dans une base de données PostgreSQL. Pour permettre cette insertion, il est nécessaire de sérialiser les messages à l’aide d’un convertisseur tel qu’Avro, Protobuf ou JsonConverter.
## Dans notre cas, c’est le format Avro qui a été retenu pour structurer et sérialiser les messages.

Voici ce qu'on trouve à présent dans confluent

## Message dans le topic OrderRequest 
<img src="Topic OrderRquest.png"/>

## Schéma prédéfinit au niveau de order.avsc
<img src="Schema OrderRequest.png"/>


