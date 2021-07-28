`docker run -d --name postgres --net cms-application -p 5432:5432 -e POSTGRES_USER=postgres POSTGRES_PASSWORD=cms@sandi postgres:9.6.6-alpine`

The --format option of inspect comes to the rescue.

Modern Docker client syntax is:

`docker inspect -f '{{range.NetworkSettings.Networks}}{{.IPAddress}}{{end}}' container_name_or_id`

Old Docker client syntax is:

`docker inspect --format '{{ .NetworkSettings.IPAddress }}' container_name_or_id`

These commands will return the Docker container's IP address.

As mentioned in the comments: if you are on Windows, use double quotes " instead of single quotes ' around the curly braces.


### mongo image over docker

`docker run -d --name mongodb --net cms-application -p 27017:27017 mongo:3.4.10`

`docker run -d --link mongodb:mongo --net cms-application -p 8081:8081 mongo-express`

`docker run -d --name cms --link mongodb:mongodb --net cms-application -p 8080:8080 sandeep15mca/cms:latest`