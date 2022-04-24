## Initialise Docker Swarm

````
docker swarm init --advertise-addr <IP Address>
````
This command will generate a join command similar to below


## Add Worker to Docker Swarm

````
docker swarm join --token <generated_Token <IP Address>:2377
````

## List Nodes

````
docker node ls
````

## Create Service

````
docker service create –name Apache2 –mode global -d -p 8003:80 httpd
````

## List services

````
Docker service ls
````

## scale services
Create a replicated service
````
docker service create –name Apache2 –mode replicated -d -p 8003:80 httpd
````

Scale the service

````
docker service scale Apache2=5
````

## Check docker containers in a service

````
docker service ps mysql
````
