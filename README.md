# 🏢 Gestion des Salaires OCP  
### JavaFX • Hibernate • MySQL • Maven

---

## 📌 Description du projet

Ce projet consiste à développer une application Java orientée objet destinée à la **gestion des employés et de leurs salaires** pour l’entreprise **OCP**.  
L’application repose sur l’utilisation de **JavaFX** pour la conception de l’interface graphique et de **Hibernate (ORM)** pour assurer la persistance des données dans une base de données **MySQL**.

Le projet met en œuvre les concepts avancés de la **Programmation Orientée Objet (POO)** tels que l’héritage, le polymorphisme et l’encapsulation afin de gérer différents types d’employés, chacun disposant de son propre mode de calcul de salaire.

Ce travail a été réalisé dans le cadre du module **Programmation Orientée Objet Avancée (Java)**.

---

## 🎯 Objectifs pédagogiques

- Appliquer les principes de la programmation orientée objet en Java  
- Utiliser Hibernate pour le mapping objet–relationnel (ORM)  
- Assurer la persistance des données avec MySQL  
- Implémenter les opérations CRUD (Create, Read, Update, Delete)  
- Concevoir une interface graphique avec JavaFX  
- Utiliser GitHub pour le versionnement et la sauvegarde du code  

---

## 🧩 Fonctionnalités

- Gestion de plusieurs types d’employés :
  - Vendeur  
  - Représentant  
  - Producteur  
  - Manutentionnaire  
- Calcul automatique des salaires selon le type d’employé  
- Ajout, modification, suppression et affichage des employés  
- Persistance des données via Hibernate  
- Interface graphique simple et intuitive (JavaFX)

---

## 🛠️ Technologies utilisées

- **Java 21**
- **JavaFX**
- **Hibernate ORM**
- **MySQL**
- **Maven**
- **Git & GitHub**

---

## 📂 Structure du projet

```

gestion-salaires
│
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── app
│   │   │   │   └── Main.java
│   │   │   ├── controller
│   │   │   │   └── EmployeController.java
│   │   │   ├── dao
│   │   │   │   └── EmployeDAO.java
│   │   │   ├── model
│   │   │   │   ├── Employe.java
│   │   │   │   ├── Vendeur.java
│   │   │   │   ├── Representant.java
│   │   │   │   ├── Producteur.java
│   │   │   │   └── Manutentionnaire.java
│   │   │   └── util
│   │   │       └── HibernateUtil.java
│   │   └── resources
│   │       ├── interface.fxml
│   │       └── hibernate.cfg.xml
│   └── test
│       └── java
│           └── test
│               ├── TestHibernate.java
│               └── TestCRUD.java
│
└── pom.xml

````

---

## ▶️ Lancement de l’application

1. Créer une base de données MySQL nommée :
   ```
   CREATE DATABASE tp_hibernete;
   ````

3. Vérifier la configuration dans `hibernate.cfg.xml`

4. Mettre à jour les dépendances Maven :

   * Clic droit sur le projet → Maven → Update Project

5. Lancer la classe :

   ```
   app.Main
   ```

⚠️ Ajouter les VM arguments JavaFX si nécessaire :

```
--module-path "C:\javafx\lib" --add-modules javafx.controls,javafx.fxml
```

---

## 📝 Remarque importante

Les identifiants des employés sont générés automatiquement par MySQL via le mécanisme **AUTO_INCREMENT**.
Même après suppression des enregistrements, le compteur d’identifiants continue d’augmenter afin de garantir l’unicité des clés primaires.

---

## 👨‍💻 Auteur

Projet réalisé dans le cadre du module
**Programmation Orientée Objet Avancée (Java)**
Année universitaire **2025 – 2026**

---

## 📎 Licence

Ce projet est destiné à un usage **pédagogique et académique**.


