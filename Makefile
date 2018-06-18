
PREFIX = registry.s.dnam.dk/bdusad
JENKINS_VERSION=2.108
VER = latest
# $(shell git describe --tags --abbrev=0)

default: build

build:
	docker build --rm --build-arg JENKINS_VERSION=$(JENKINS_VERSION) -t $(PREFIX)/jenkins:$(JENKINS_VERSION) jenkins/
	docker build --rm -t $(PREFIX)/jenkins-swarm-slave:$(VER) jenkins-swarm-slave/
	docker build --rm -t $(PREFIX)/cloudbees-swarm-slave:$(VER) cloudbees-swarm-slave/

release:
	docker push $(PREFIX)/jenkins:$(JENKINS_VERSION)

deploy:
	JENKINS_VERSION=$(JENKINS_VERSION) docker stack deploy jenkins -c docker-stack-docker.yml
	docker stack ps jenkins

clean:
	docker stack rm jenkins

