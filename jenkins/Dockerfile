
FROM jenkins/jenkins:2.73.3-alpine

ARG user=jenkins

RUN /usr/local/bin/install-plugins.sh git matrix-auth workflow-aggregator docker-workflow blueocean credentials-binding \
	swarm active-directory \
	monitoring

USER root
RUN mkdir /var/backing && chown -R ${user} /var/backing
USER ${user}

ENV JENKINS_EXECUTORS 0

# Skip initial setup
ENV JAVA_OPTS -Djenkins.install.runSetupWizard=false

COPY scripts/* /usr/share/jenkins/ref/init.groovy.d/
COPY jenkins-wrapper.sh /usr/local/bin/

VOLUME /var/jenkins_home

ENTRYPOINT ["/bin/tini", "--", "/usr/local/bin/jenkins-wrapper.sh"]
