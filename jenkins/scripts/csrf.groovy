import hudson.security.csrf.DefaultCrumbIssuer
import jenkins.model.Jenkins

def jenkins = Jenkins.instance

if(!jenkins.isQuietingDown()) {
    if(jenkins.getCrumbIssuer() == null) {
        jenkins.setCrumbIssuer(new DefaultCrumbIssuer(true))
        jenkins.save()
        println '--> CSRF Protection configuration has changed.  Enabled CSRF Protection.'
    }
    else {
        println '--> Nothing changed.  CSRF Protection already configured.'
    }
}
else {
    println "--> Shutdown mode enabled.  Configure CSRF protection SKIPPED."
}

