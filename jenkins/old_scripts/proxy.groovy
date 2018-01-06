import jenkins.model.*

def instance = Jenkins.getInstance()

final String name = "proxy.bdpnet.dk"
final int port = 8080
final String userName = null
final String password = null
final String noProxyHost = ".bdpnet.dk\n.bdbnet.dk\n.bdunet.dk\nlocalhost"

final def pc = new hudson.ProxyConfiguration(name, port, userName, password, noProxyHost)
instance.proxy = pc
instance.save()
println "--> Proxy settings updated for ${name}:${port}"
