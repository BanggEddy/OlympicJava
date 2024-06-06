Projet Java Spring Boot
Description

Ce projet est une application web basée sur le framework Spring Boot en Java, conçue pour gérer un système d'authentification, de gestion des billets, des épreuves sportives, des événements et des utilisateurs. Bien que le projet ne soit pas complètement terminé, plusieurs fonctionnalités principales ont été implémentées.
Fonctionnalités

    Authentification et Autorisation
        Inscription des utilisateurs (/auth/signup)
        Connexion des utilisateurs (/auth/login)
        Génération de JWT pour l'authentification

    Gestion des Billets
        Création, mise à jour et suppression des billets (/billet)
        Recherche de billets par UUID
        Consultation de tous les billets disponibles

    Gestion des Épreuves Sportives
        Création, mise à jour et suppression des épreuves (/epreuve)
        Recherche d'épreuves par UUID
        Consultation de toutes les épreuves disponibles

    Gestion des Événements
        Création, mise à jour et suppression des événements (/evenement)
        Recherche d'événements par UUID
        Consultation de tous les événements disponibles

    Gestion des Utilisateurs
        Modèle de gestion des utilisateurs avec rôles et autorisations
        Association des utilisateurs avec des billets et des événements

Structure du Projet
Contrôleurs

    AuthController : Gestion de l'inscription et de la connexion des utilisateurs.
    BilletController : Gestion des billets (création, mise à jour, suppression, recherche).
    EpreuveController : Gestion des épreuves sportives (création, mise à jour, suppression, recherche).
    EvenementController : Gestion des événements (création, mise à jour, suppression, recherche).

Modèles

    User : Représente un utilisateur du système avec les détails d'authentification et les rôles.
    Billet : Représente un billet associé à une épreuve sportive et un utilisateur.
    Epreuve : Représente une épreuve sportive associée à un événement.
    Evenement : Représente un événement sportif avec des épreuves associées.
    Stade : Représente un stade où se déroulent les épreuves.
    Commande : Représente une commande de billets par un utilisateur.
    Candidat : Représente un candidat participant à une épreuve.

DTOs (Data Transfer Objects)

    RegisterDto : Données pour l'inscription d'un utilisateur.
    LoginDto : Données pour la connexion d'un utilisateur.
    LoginResponse : Réponse contenant le token JWT et son expiration.
    CreateBillet : Données pour la création d'un billet.
    UpdateBillet : Données pour la mise à jour d'un billet.
    CreateEpreuve : Données pour la création d'une épreuve.
    UpdateEpreuve : Données pour la mise à jour d'une épreuve.
    CreateEvenement : Données pour la création d'un événement.
    UpdateEvenement : Données pour la mise à jour d'un événement.

Configuration
Prérequis

    Java 17 ou supérieur
    Maven 3.6 ou supérieur
    Spring Boot 2.5 ou supérieur

Endpoints Principaux

    POST /auth/signup : Inscription des utilisateurs

    POST /auth/login : Connexion des utilisateurs

    GET /billet : Récupérer tous les billets

    GET /billet/{uuid} : Récupérer un billet par UUID

    POST /billet : Créer un nouveau billet

    DELETE /billet/{uuid} : Supprimer un billet par UUID

    PUT /billet/{uuid} : Mettre à jour un billet par UUID

    PATCH /billet/{uuid} : Mettre à jour partiellement un billet par UUID

    GET /epreuve : Récupérer toutes les épreuves

    GET /epreuve/{uuid} : Récupérer une épreuve par UUID

    POST /epreuve : Créer une nouvelle épreuve

    DELETE /epreuve/{uuid} : Supprimer une épreuve par UUID

    PUT /epreuve/{uuid} : Mettre à jour une épreuve par UUID

    PATCH /epreuve/{uuid} : Mettre à jour partiellement une épreuve par UUID

    GET /evenement : Récupérer tous les événements

    GET /evenement/{uuid} : Récupérer un événement par UUID

    POST /evenement : Créer un nouvel événement

    DELETE /evenement/{uuid} : Supprimer un événement par UUID

    PUT /evenement/{uuid} : Mettre à jour un événement par UUID

    PATCH /evenement/{uuid} : Mettre à jour partiellement un événement par UUID
