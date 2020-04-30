# Docker

1. What's docker container?

2. What is docker compose ? How is it different than Dockerfile?

3. Is it a good practice to run stateful applications on Docker? or What type of applications - Stateless or Stateful are more suitable for Docker Container?

4. What is a Docker Registry?

5. What is the difference between the COPY and ADD commands in a Dockerfile?

6. What's health checks in docker compose?

&nbsp;&nbsp;&nbsp;&nbsp;[Info](https://howchoo.com/g/zwjhogrkywe/how-to-add-a-health-check-to-your-docker-container)

7. Build a docker image?

```bash
$ docker build -t $Docker_Image .
```

8. Run a docker image?

```bash
$ docker run -it --rm $Docker_Image
```

9. How to override entrypoint using docker run?

```bash
$ docker run --entrypoint=python $Docker_Image $script
 ```
 
10. Difference between CMD and ENTRYPOINT?


# Kubernetes

1. Difference between container vs pods?
