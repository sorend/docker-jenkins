FROM openjdk:8-jdk-alpine

MAINTAINER Soren A D <sorend@gmail.com>

ENV JENKINS_SWARM_VERSION 3.12
ENV JENKINS_SWARM_DOWNLOAD_SITE https://repo.jenkins-ci.org/releases/org/jenkins-ci/plugins/swarm-client
ENV JENKINS_HOME /home/jenkins

RUN apk add --no-cache docker curl bash
RUN curl --create-dirs -sSLo /usr/share/jenkins/swarm-client-${JENKINS_SWARM_VERSION}.jar \
  ${JENKINS_SWARM_DOWNLOAD_SITE}/${JENKINS_SWARM_VERSION}/swarm-client-${JENKINS_SWARM_VERSION}.jar \
  && chmod 755 /usr/share/jenkins

COPY jenkins-slave.sh /usr/local/bin/jenkins-slave.sh

RUN mkdir /docker-entrypoint-init.d
ONBUILD ADD ./*.sh /docker-entrypoint-init.d/

ENV JAVA_OPTS -Xmx64m

ENTRYPOINT ["/usr/local/bin/jenkins-slave.sh"]

