
FROM jenkinsci/jenkins:2.60.3-alpine

RUN /usr/local/bin/install-plugins.sh git matrix-auth workflow-aggregator docker-workflow blueocean credentials-binding \
	swarm active-directory \
	artifactory

ENV JENKINS_USER admin
ENV JENKINS_PASS admin

# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY scripts/* /usr/share/jenkins/ref/init.groovy.d/

VOLUME /var/jenkins_home

