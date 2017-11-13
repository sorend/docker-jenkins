
PREFIX = bdusad
VER = $(shell git describe --tags --abbrev=0)

default: build

build:
	docker build -t $(PREFIX)/jenkins:$(VER) jenkins/
	docker build -t $(PREFIX)/jenkins-swarm-slave:$(VER) jenkins-swarm-slave/

