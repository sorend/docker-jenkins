
import jenkins.model.*

def numExecutors = System.getenv('JENKINS_EXECUTORS') as Integer ?: 0

Jenkins.instance.setNumExecutors(numExecutors)

