Voici le README.md dans le format demandé :

```markdown
# Kafka Spring Stream Demo

Une application complète de traitement de données en temps réel avec Spring Boot et Kafka Streams.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Kafka](https://img.shields.io/badge/Apache%20Kafka-3.7-red)
![License](https://img.shields.io/badge/License-MIT-blue)

## Fonctionnalités

- Traitement de flux de données en temps réel avec Kafka Streams
- Comptage de mots (Word Count) en continu
- API REST pour l'envoi et la réception de données
- Interface web de monitoring temps réel
- Architecture modulaire et extensible
- Configuration Spring Boot optimisée

## 🛠️ Technologies

- Spring Boot 3.2.0
- Kafka Streams API
- Apache Kafka 3.7
- Java 17
- Maven
- Spring Web
- Thymeleaf (Interface web)

```
## 📁 Structure du Projet

```
src/main/java/com/example/demo/
├── config/
│   └── KafkaConfig.java               # Configuration Kafka
├── controller/
│   └── StreamController.java          # Endpoints REST
├── service/
│   └── WordCountService.java          # Service Kafka Streams
├── model/
│   └── Message.java                   # Modèle de données
├── dto/
│   └── WordCountDto.java              # DTO de transfert
└── DemoApplication.java               # Classe principale
```

## 🏃‍♂️ Installation et Exécution

### Prérequis
- Java 17+
- Maven 3.6+
- Apache Kafka

### 1. Cloner le projet
```bash
git clone https://github.com/Wijdaneh/kafka-spring-stream-demo.git
cd kafka-spring-stream-demo
```

### 2. Démarrer Kafka
```bash
# Démarrer Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Démarrer Kafka
bin/kafka-server-start.sh config/server.properties
```

### 3. Créer les topics Kafka
```bash
bin/kafka-topics.sh --create --topic input-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
bin/kafka-topics.sh --create --topic output-topic --bootstrap-server localhost:9092 --partitions 1 --replication-factor 1
```

### 4. Lancer l'application
```bash
mvn clean spring-boot:run
```

Application disponible sur :
[http://localhost:8080](http://localhost:8080)

---

## 🔑 Utilisation

### 1. Envoyer des données au stream
```bash
curl -X POST http://localhost:8080/api/publish \
  -H "Content-Type: application/json" \
  -d '{"message": "hello world kafka streams"}'
```

### 2. Récupérer les résultats du traitement
```bash
curl -X GET http://localhost:8080/api/results
```

Réponse :
```json
{
  "hello": 1,
  "world": 1,
  "kafka": 1,
  "streams": 1
}
```

---

## 📊 Interface Web

Accédez à l'interface web sur `http://localhost:8080` pour :

- Visualiser les données en temps réel
- Envoyer des messages directement
- Surveiller le traitement Kafka Streams
- Voir les statistiques de traitement

---

## 🔒 Architecture Kafka

| Composant | Topic | Description |
| --------- | ----- | ----------- |
| Producer | input-topic | Réception des données brutes |
| Stream Processor | - | Traitement Kafka Streams |
| Consumer | output-topic | Résultats du traitement |

---

## 🔄 Flux de Traitement

```
1. Client → POST /api/publish (données)
2. Application → Production vers input-topic
3. Kafka Streams → Traitement et agrégation
4. Application → Consommation depuis output-topic
5. Client → GET /api/results (résultats)
```

---

## 🧪 Testing (PowerShell)

```powershell
# Tester l'envoi de données
$response = Invoke-RestMethod -Uri "http://localhost:8080/api/publish" -Method POST -Headers @{"Content-Type"="application/json"} -Body '{"message": "test kafka streams processing"}'

# Vérifier les résultats
$results = Invoke-RestMethod -Uri "http://localhost:8080/api/results" -Method GET
```

---

## 🤝 Contribution

1. Fork le projet
2. Créer une branche feature
3. Commit
4. Push
5. Pull Request

---

## 📝 Licence

Ce projet est sous licence MIT.

---

## 👨‍💻 Auteur

Wijdane  
GitHub: @Wijdaneh

---

## 🔮 Améliorations futures

- Agrégations temporelles (tumbling windows)
- Traitement de données JSON complexes
- Intégration avec bases de données
- Monitoring avancé avec Micrometer
- Tests d'intégration Kafka
- Déploiement Docker
- Scaling horizontal des instances

---

⭐ N'oubliez pas de donner une étoile si ce projet vous a été utile !
```