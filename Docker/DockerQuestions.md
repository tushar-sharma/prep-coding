# Docker

## Lifecycle
`docker run` creates and starts a container in one command

`docker rm` deletes a container

`docker rm $(docker ps -aq)` removes all docker containers

## Starting & Stopping
`docker start` starts a container

`docker stop` stops a running container

`docker stop $(docker ps -aq)` stops all running containers

## Info
`docker ps` shows running containers

`docker ps -a` shows running and stopped containers

`docker stats` shows container's resource usage stats

`docker diff` shows changed files in the container's file system

## Executing Commands
`docker exec` to execute a command in a container


# Images
## Lifecycle
`docker images` shows all images

`docker build (--tag={tag})` creates image from Dockerfile

# Issues

## Build docker image with specific dockerfile

```bash
$ dockerbuild -t <tag> -f <filename> .
```

`docker rmi` removes an image

`docker rmi $(docker images -q)` remove all images

## Info
`docker history` shows history of an image

`docker tag` tags an image to a name


## Questions

1. What is docker compose ? How is it different than Dockerfile?

2. What is the difference between the COPY and ADD commands in a Dockerfile?

3. What's health checks in docker compose?

&nbsp;&nbsp;&nbsp;&nbsp;[Info](https://howchoo.com/g/zwjhogrkywe/how-to-add-a-health-check-to-your-docker-container)

4.  How to override entrypoint using docker run?

```bash
$ docker run --entrypoint=python $Docker_Image $script
```

## Kubernetes

1. Difference between container vs pods?
