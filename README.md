# Test technique


## Exercise: Write a simple fizz-buzz REST server.

The original fizz-buzz consists in writing all numbers from `1` to `100`, and just replacing all multiples of `3` by `fizz`, all multiples of `5` by `buzz`, and all multiples of `15` by `fizzbuzz`.

The output would look like this: 
```
1,2,fizz,4,buzz,fizz,7,8,fizz,buzz,11,fizz,13,14,fizzbuzz,16,...
```


Your goal is to implement a web server that will expose a REST API endpoint that:

### Accepts five parameters : 
 - three integers `int1`, `int2` and `limit`, 
 - two strings `str1` and `str2`.

Returns a list of strings with numbers from 1 to limit, where: all multiples of int1 are replaced by str1, all multiples of int2 are replaced by str2, all multiples of int1 and int2 are replaced by str1str2.



### The server needs to be:

Ready for production

Easy to maintain by other developers

- Add a statistics endpoint allowing users to know what the most frequent request has been.

This endpoint should:

- Accept no parameter

- Return the parameters corresponding to the most used request, as well as the number of hits for this request


 ### Start project :

You need to have docker in your machine. 

```
docker-compose -up
```

### Explication [FR]: 
Ps : je ne suis pas developpeur spring, je suis developpeur java intershop. J'ai créer un projet spring pour l'occasion car spring et le framework le plus utilisé pour du JAVA. 
Certaine implémentation peuvent être bancal. 

Pour démarrer le projet j'ai créer une image docker de build temporaire. Il est juste nécessaire d'avoir docker sur ça machine. 

Les choix que j'ai fais en developpant : 

Si les paramètres son préciser qu'à moitié. Je renvoie le fizzbuzz par défaut modifier par les paramètre entrée.
Quand les paramètres sont préciser à moitier.