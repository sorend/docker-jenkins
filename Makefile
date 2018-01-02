
PREFIX = bdusad
VER = latest
# $(shell git describe --tags --abbrev=0)

default: build

build:
	docker build --rm -t $(PREFIX)/jenkins:$(VER) jenkins/
	docker build --rm -t $(PREFIX)/jenkins-swarm-slave:$(VER) jenkins-swarm-slave/

release:
	docker tag $(PREFIX)/jenkins:$(VER) registry.s.dnam.dk/$(PREFIX)/jenkins:$(VER)
	docker push registry.s.dnam.dk/$(PREFIX)/jenkins:$(VER)

deploy:
	docker stack deploy jenkins -c docker-compose.yml
	docker stack ps jenkins

clean:
	docker stack rm jenkins

