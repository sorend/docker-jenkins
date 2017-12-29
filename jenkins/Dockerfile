
FROM jenkinsci/jenkins:2.60.3-alpine

RUN /usr/local/bin/install-plugins.sh git matrix-auth workflow-aggregator docker-workflow blueocean credentials-binding \
	swarm active-directory \
	artifactory \
	slack \
	monitoring

ENV JENKINS_USER admin
ENV JENKINS_PASS admin
ENV JENKINS_EXECUTORS 0

# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false -XX:+UnlockExperimentalVMOptions -XX:+UseCGroupMemoryLimitForHeap

COPY scripts/executors.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY scripts/bd-proxy.groovy /usr/share/jenkins/ref/init.groovy.d/
COPY scripts/bd-artifactory.groovy /usr/share/jenkins/ref/init.groovy.d/

VOLUME /var/jenkins_home

