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

### End point : 

```
/fizzbuzz?{int1}{int2}{str1}{str2}{limit}
```
return : with paramater 
calculate fizzbuzz
example :
with parameter :` /fizzbuzz?int1=2&int=3&str1=a&str2=b&limit=6 `
```
{
 "1","a","b","a","5","b"
}
```
```
/ or /fizzbuzz without parameter : 
```
Most popular fizzbuzz
```
/statistic 
```
Return the most popular fizzbuzz parameter with the number of requete
exemple :
```
{
 "id" : "1" , #ID of Fizzbuszz Statistic if you want to reuse it
 "nbOccurence" : 5
 "Fizzbuzz" : { 
   "id": 1, #ID of db object  fizzbuzz if you want to reuse it
   "int1":3,
   "int2":5,
   "str1":"fizz",
   "str2":"buzz"
   }
}
```


### Explication [FR]: 

Ps : je ne suis pas développeur spring, je suis développeur java intershop. J’ai créé un projet spring pour l’occasion car spring et le framework le plus utilisé pour du JAVA. 

Pour démarrer le projet j'ai crée une image docker de build temporaire. Il est juste nécessaire d'avoir docker sur ça machine. 

Les choix que j'ai fait en développant : 

Si les paramètres son préciser partiellement. Je modifie le fizzbuzz par défaut avec les paramètre entrée.
