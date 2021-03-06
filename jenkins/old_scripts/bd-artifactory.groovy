import jenkins.model.*
import org.jfrog.*
import org.jfrog.hudson.*
import org.jfrog.hudson.util.Credentials

def jenkins = Jenkins.getInstance()

def desc = jenkins.getDescriptor("org.jfrog.hudson.ArtifactoryBuilder")

def deployerCredentials = new CredentialsConfig("admin", "password", "")
def resolverCredentials = new CredentialsConfig("", "", "")

def sinst = [new ArtifactoryServer(
  "artifactory",
  "http://artifactorytest.bdpnet.dk:9081/artifactory",
  deployerCredentials,
  resolverCredentials,
  300,
  false, 3)
]

desc.setArtifactoryServers(sinst)

desc.save()
