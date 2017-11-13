
import jenkins.model.*

def numExecutors = System.env.'JENKINS_EXECUTORS' as Integer ?: 0

Jenkins.instance.setNumExecutors(numExecutors)

