# LACHAAL Abdallah

Mon travaille a consisté essentiellement à mettre en place l'API REST de notre application 
# L'API REST

Voici la liste des appels possibles dans notre API REST

## `GET /missions`

Consulter la liste de toute les mission enregistré dans la base de donnée

## `POST /missions`

Cet appel à créer une mission dont la représentation en JSON est passée dans le corps de la requête HTTP, ce dernier doit avoir cette forme:
```json
      {
			"name":"nomDeLaMission",
			"route":[{position1},...,{positionN}],
			"startDate":"YYYY-MM-dd hh:mm:ss",
			"endDate";"YYYY-MM-dd hh:mm:ss"
       }
```

## `GET /missions/{id}/positions`

Récupérer la liste des positions associées à une mission dont l’identifiant est égale à `id`,  la réponse de cette doit ressembler à cette forme:
```json
{
	"id":"idDeLaPosition",
	"lat":latitude,
	"lon": longitude
}
```

## `PATCH /mission/{id}/start`

Cet appel sert à  démarrer une mission, dans cet appel on set le date de début de mission `startDate` 

## `PATCH /mission/{id}/stop`

Cet appel sert à  terminer une mission, dans cet appel on set le date de fin de mission `endDate` 

