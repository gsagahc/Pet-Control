* [Gerenciamento de cache redis]
* Configuração da imagem
docker pull redis
docker run --name localredis -p 6379:6379  -d redis
*** Configuração application.yml****

  cache: 
   type: redis
   redis:
    host: localhost
    port: 6379