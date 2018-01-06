import jenkins.model.Jenkins

println "--> removing CLI and old JNLP protocols"

def jenkins = Jenkins.instance

// disable remoting
jenkins.getDescriptor("jenkins.CLI").get().setEnabled(false)

// disable all but jnlp/4
HashSet<String> newProtocols = new HashSet<String>(jenkins.getAgentProtocols())
newProtocols.removeAll(Arrays.asList("JNLP3-connect", "JNLP2-connect", "JNLP-connect", "CLI-connect"))
jenkins.setAgentProtocols(newProtocols)
jenkins.save()

println "--> removed CLI and old JNLP protocols"
