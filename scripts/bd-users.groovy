import jenkins.model.*
import hudson.security.*

def env = System.getenv()

import jenkins.model.*
import hudson.security.*
import hudson.plugins.active_directory.*

def jenkins = Jenkins.getInstance()
String domain = 'd101p.bdpnet.dk'
String site = null
String server = null
String bindName = null
String bindPassword = null
def adrealm = new ActiveDirectorySecurityRealm(domain, site, bindName, bindPassword, server)
jenkins.setSecurityRealm(adrealm)

def strategy = new hudson.security.FullControlOnceLoggedInAuthorizationStrategy()
strategy.setAllowAnonymousRead(false)
jenkins.setAuthorizationStrategy(strategy)

jenkins.save()

