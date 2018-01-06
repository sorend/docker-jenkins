import hudson.model.*
import jenkins.model.*
import hudson.security.*

def env = System.getenv()
def jenkins = Jenkins.instance

def localrealm = new HudsonPrivateSecurityRealm(false)
localrealm.createAccount("admin", "devopsjava123")  // for support
localrealm.createAccount("swarm-slave", "devopsjava123") // for swarm clients
jenkins.setSecurityRealm(localrealm)
jenkins.save()

def auth = new GlobalMatrixAuthorizationStrategy()
auth.add(Jenkins.ADMINISTER, "admin")
auth.add(Jenkins.ADMINISTER, "swarm-slave")
jenkins.setAuthorizationStrategy(auth)
jenkins.save()
