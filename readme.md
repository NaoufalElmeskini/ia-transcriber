![Spring](https://img.shields.io/badge/-Aws-13aa52?style=for-the-badge&logo=aws&logoColor=white)
![Spring](https://img.shields.io/badge/-Boot-13aa52?style=for-the-badge&logo=springboot&logoColor=white)

# À propos
IATranscriber est une API backend qui permet la transcription d'un fichier audio, à l'aide d'un modèle de langage de type [speech-to-text](https://en.wikipedia.org/wiki/Speech_recognition).

Plusieurs APIs fournissent un service speech-to-text ([notemment Whisper](https://platform.openai.com/docs/guides/speech-to-text)), mais ces services requierent plusieurs conditions concernant les fichiers en entrée (format, taille, encodage...) et de [prompt](https://en.wikipedia.org/wiki/Prompt_engineering) accompagnant le fichier.

Cette application a pour but de résoudre ces problèmes en proposant une interface minimaliste.
Elle offre aussi une intégration simple dans un environnement AWS.

---


# Fonctionnalités
- Transcrire un fichier audio vers un fichier texte
- Découper d'un fichier volumineux en morceaux acceptés par une API STT (speech-to-text)
- Proposer des prompts précis  pour interagire avec les agents d'IA

---
# Tester :
- vérifier le statut de l'application
```
$ curl --request GET \
     --url http://{baseUrl}/transcriber-api/status \
```


- transcrire fichier audio (.wav) :
```
$ curl --request POST \
  --url 'http://{baseUrl}/transcriber-api/transcribe/attached?=&fileName=result' \
  --header 'Content-Type: multipart/form-data' \
  --header 'User-Agent: insomnia/10.2.0' \
  --form 'file=@C:\Users\local_path_to_audio_file\audioFile.wav'
```

--- 
## Builder (AWS) :
(à venir)

---
## Deployer (AWS) :
(à venir)

---
## Template CloudFormation

Ce projet contient un [template CloudFormation](https://en.wikipedia.org/wiki/AWS_CloudFormation) qui decrit et automatise la creation des ressources AWS.

C'est un [fichier IaC](https://fr.wikipedia.org/wiki/Infrastructure_as_code) qui simplifie cette automatisation. 

Ce [template](scripts/cloudformation) crée une instance ec2, lui donne les configuration de securité et prépare un environnement java dessus.
Il contient aussi la section de build (codeBuild), et de deploiement automatisé (codeDeploy).

## annexe :
