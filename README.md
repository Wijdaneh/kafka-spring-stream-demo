# ⚡ Kafka Spring Stream Demo

Une application complète en Spring Boot utilisant **Kafka Streams** pour le traitement de données en temps réel avec visualisation instantanée des résultats.

![Java](https://img.shields.io/badge/Java-17-orange)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.0-brightgreen)
![Kafka](https://img.shields.io/badge/Apache%20Kafka-3.7-red)
![License](https://img.shields.io/badge/License-MIT-blue)

---

## 🚀 Fonctionnalités

- Streaming temps réel avec Kafka Streams
- Word Count (exemple démo)
- API REST de publication / lecture
- Interface Web temps réel
- Monitoring pipelines Kafka
- Architecture modulaire
- Service analytique en streaming

---

## 🛠️ Technologies utilisées

- Java 17
- Spring Boot 3
- Kafka Streams API
- Apache Kafka
- Maven
- WebSocket (optionnel)
- Thymeleaf / React (selon UI)

---

## 📁 Structure du Projet

src/main/java/com/example/demo/
├── config/ # Config Kafka
│ └── KafkaConfig.java
├── controller/ # API REST
│ └── StreamController.java
├── service/ # Services Kafka Streams
│ └── WordCountService.java
├── model/ # Données échangées
│ └── Message.java
├── dto/ # Data Transfer Objects
│ └── WordCountDto.java
└── DemoApplication.java # Classe principale

yaml
Copier le code

---

## 🏃 Installation et exécution

### 🧩 Prérequis
- Java 17+
- Maven
- Apache Kafka installé

---

### 1️⃣ Cloner le projet

```bash
git clone https://github.com/Wijdaneh/kafka-spring-stream-demo.git
cd kafka-spring-stream-demo
2️⃣ Démarrer Kafka
bash
Copier le code
# Démarrer Zookeeper
bin/zookeeper-server-start.sh config/zookeeper.properties

# Démarrer Kafka
bin/kafka-server-start.sh config/server.properties
Créer les topics si nécessaire :

bash
Copier le code
bin/kafka-topics.sh --create --topic input-topic --bootstrap-server localhost:9092
bin/kafka-topics.sh --create --topic output-topic --bootstrap-server localhost:9092
3️⃣ Lancer l'application
bash
Copier le code
mvn clean spring-boot:run
Application accessible sur :
http://localhost:8080

🔧 Utilisation
1. Envoyer un message au flux
bash
Copier le code
curl -X POST "http://localhost:8080/api/publish" \
     -H "Content-Type: application/json" \
     -d '{"message": "hello world from streaming app"}'
2. Récupérer les résultats du streaming
bash
Copier le code
curl -X GET "http://localhost:8080/api/results"
Réponse JSON :

json
Copier le code
{
  "hello": 1,
  "world": 1,
  "streaming": 1,
  "app": 1
}
🔄 Flux de traitement Kafka
markdown
Copier le code
1. Client → POST /publish (message)
2. Application → push dans input-topic
3. Kafka Streams → word count
4. Résultats envoyés vers output-topic
5. Application → expose /results en REST ou WebSocket
6. UI web → affichage en temps réel
📊 Monitoring (optionnel)
Outil	URL
Kafka UI	http://localhost:8080/ui
Kafka CLI	bin/kafka-console-consumer.sh
Conduktor	externe
ksqlDB	optionnel

🔬 Testing (PowerShell)
powershell
Copier le code
# Écrire dans Kafka
bin/kafka-console-producer.sh --topic input-topic --bootstrap-server localhost:9092

# Consommer
bin/kafka-console-consumer.sh --topic output-topic --from-beginning --bootstrap-server localhost:9092
🤝 Contribution
Fork

Branche feature/*

Commit + Push

Pull Request

📝 Licence
Ce projet est sous licence MIT.

👨‍💻 Auteur
Wijdane
GitHub : https://github.com/Wijdaneh

🔮 Améliorations futures
Pipeline multi-topique

Agrégations temporelles (windowing)

Détection d’événements anormaux

Notifications en temps réel

Intégration avec Redis/Elastic

Dashboard en React live analytics

Exposition métriques Prometheus/Grafana

⭐ Si ce projet vous aide, pensez à lui mettre une étoile sur GitHub 🙂