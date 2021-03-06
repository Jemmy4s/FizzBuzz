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


 # Start project :

**You need to have docker in your machine.**

```bash
docker build -t fizzbuzz . 
docker-compose -up
```
**Troubleshoot :**
Sometime the spring boot application is too rapid and the db too slow. 
You need to restart spring boot application if you have this problem. 

## End point : 

### Calculate fizzbuzz

```css
/fizzbuzz?{int1}{int2}{str1}{str2}{limit}
```

*return  array of fizzbuzz*


#### example :

with parameter :` /fizzbuzz?int1=2&int=3&str1=a&str2=b&limit=6 `
```JSON
[ "1","a","b","a","5","b"]
```
### Default Fizzbuzz
```
/ or /Fizzbuzz
```
### Most popular
```
/mostPopular 
```
Most popular fizzbuzz

### Statistic
```
/statistic 
```
Return the most popular fizzbuzz parameter with the number of requete
exemple :
```JSON
[
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
]
```
###  Test

You can import PostMan json in your postman to use integration test. 

### Explication [FR]: 

Ps : je ne suis pas d??veloppeur spring, je suis d??veloppeur java intershop. J???ai cr???? un projet spring pour l???occasion du test technique car spring et le framework le plus utilis?? pour du JAVA. 

Pour d??marrer le projet j'ai cr??e une image docker de build temporaire. Il est juste n??cessaire d'avoir docker sur ??a machine. 

Les choix que j'ai fait en d??veloppant : 

Si les param??tres son pr??ciser partiellement. Je modifie le fizzbuzz par d??faut avec les param??tre entr??e.
Les test d'ingr??tation on ??t?? fait sur postman. Il y a un d??j?? des requ??te de pr??parer. 

J'ai fais le choix de renvoyer un array json pour les statistique car on pourrai tr??s bien un jour vouloir augmenter le nombre de statistic par requ??te. 