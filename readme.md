![Spring](https://img.shields.io/badge/-Spring-13aa52?style=for-the-badge&logo=spring&logoColor=white)
![Spring](https://img.shields.io/badge/-Boot-13aa52?style=for-the-badge&logo=springboot&logoColor=white)


# À propos

IATranscriber est un backend API qui permet la transcription d'un fichier audio, à l'aide un d'un modèle de langage de type speech-to-text. 

Plusieurs APIs fournissent un service speech-to-text ([notemment Whisper](https://platform.openai.com/docs/guides/speech-to-text)), mais ces services requierent plusieurs conditions concernant les fichiers en entrée (format, taille, encodage...) et de [prompt](https://en.wikipedia.org/wiki/Prompt_engineering) accompagnant le fichier.

Cette application a pour but de résoudre ces problèmes en proposant une interface minimaliste.

---


# Fonctionnalités
- Transcrire un fichier audio vers un fichier texte
- découpage d'un fichier volumineux en morceaux acceptés par une API STT (speech-to-text)
- proposer des prompts précis  pour interagire avec les agents d'IA


---
# Technique
## demarrer avec IDE :

---
l'application est accessible sur {baseUrl}

## démarrer avec docker compose (recommandé)
```
$ docker compose up -d
```

--- 
## demarrer avec Docker (sans compose) :
- generer le jar dans target
  $ mvn clean package
- creer une image docker 
  ```
  docker build -t spring-transcriber-api .
  ```
- creer un network "api-network" pour simplifier la communication entre les 2 api contenarisés
  $ docker network create api-network
- demarrer le container
    ```
      docker run -p 127.0.0.1:8080:8080 --network=api-network --name spring-transcriber-api spring-transcriber-api
    ```
  "--network=api-network --name spring-transcriber-api" : section necessaire pour que les 2 containers communiquent

## tester
- scenario 0 : vérifier le statut de l'application
```
curl --request GET \
  --url http://{baseUrl}/transcriber-api/status \
```

- scenario  1 : recuperer produit 
    prerequis : demarrer price-api
```
  curl --request POST \
  --url 'http://{baseUrl}/transcriber-api/transcribe/attached?=&fileName=toto' \
  --header 'Content-Type: multipart/form-data' \
  --header 'User-Agent: insomnia/10.2.0' \
  --form 'file=@C:\Users\local_path_to_audio_file\dynamicFile.wav'
```

## annexe :
- {baseUrl} : http://localhost:8080
- Fonctionnalité à venir : [voir backlog](https://github.com/NaoufalElmeskini/spring-ia-speech-to-text/issues/2)
- Credit : le module de traitement de fichier était éhontément volé du [travail de @KenKousen](https://github.com/kousen/openaidemo/)
