import jenkins.model.*
import hudson.security.*

def env = System.getenv()

import jenkins.model.*
import hudson.security.*
import hudson.plugins.active_directory.*

// add AD login
def jenkins = Jenkins.getInstance()
def adrealm = new ActiveDirectorySecurityRealm("d101p.bdpnet.dk" null, null, null, null)
jenkins.setSecurityRealm(adrealm)
jenkins.save()

def localrealm = new HudsonPrivateSecurityRealm(false)
localrealm.createAccount("admin", "devopsjava123")  // for support
localrealm.createAccount("swarm-slave", env.JENKINS_SWARM_PASS) // for swarm clients
jenkins.setSecurityRealm(localrealm)
jenkins.save()

def auth = new GlobalMatrixAuthorizationStrategy()
auth.add(Jenkins.ADMINISTER, 

jenkins.setAuthorizationStrategy(new GlobalMatrixAuthorizationStrategy())

def user = jenkins.getSecurityRealm().createAccount(env.JENKINS_USER, env.JENKINS_PASS)
user.save()

jenkins.getAuthorizationStrategy().add(Jenkins.ADMINISTER, env.JENKINS_USER)
jenkins.save()
