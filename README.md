# Akka Http and Heroku

This is a sample for deploying a Rest API implemented using Akka Http and deployed in Heroku.
This is a sbt multi-proyect.

The multi-proyect is based in this [example](https://pbassiner.github.io/blog/defining_multi-project_builds_with_sbt.html).
    
The Akka Http and the necessary steps required to deploy it in Heroku are based in this [example](https://dzone.com/articles/akka-http-from-zero-to-heroku-in-10-minutes).

## Endpoints

There is only one endpoint:

```
GET /
```

You can test it using curl:

```
curl http://localhost:8080
```

It will return the following message:

```
This is a rest api with akka http deployed in heroku
```

## To run in your local env using sbt

```
sbt api/run
```
