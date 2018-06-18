ARG JENKINS_VERSION=2.108

FROM jenkins/jenkins:${JENKINS_VERSION}-alpine

ARG user=jenkins
ARG docker_gid=999

RUN /usr/local/bin/install-plugins.sh git matrix-auth workflow-aggregator docker-workflow blueocean credentials-binding \
	swarm active-directory \
	monitoring \
	pipeline-aggregator-view \
	docker

USER root
RUN set -x && \
	mkdir /var/backing && chown -R ${user} /var/backing && \
	( getent group ${docker_gid} || addgroup -S -G ${docker_gid} jdocker ) && \
	addgroup ${user} $(getent group ${docker_gid} | cut -f 1 -d ":")
USER ${user}

RUN id

ENV JENKINS_EXECUTORS 0

# Skip initial setup
ENV JAVA_OPTS -Xmx512m -Djenkins.install.runSetupWizard=false

COPY scripts/* /usr/share/jenkins/ref/init.groovy.d/
COPY jenkins-wrapper.sh /usr/local/bin/

VOLUME /var/jenkins_home

ENTRYPOINT ["/sbin/tini", "--", "/usr/local/bin/jenkins-wrapper.sh"]
