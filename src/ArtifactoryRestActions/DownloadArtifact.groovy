package ArtifactoryRestActions

@Grab(group = 'org.codehaus.groovy.modules.http-builder', module = 'http-builder', version = '0.6')

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient


//Credentials + base URL
String baseUrl = "http://10.70.30.83:8082"
String user = "admin"
String password = "Dn2120091"

def rt = new RESTClient(baseUrl)
rt.auth.basic user, password
rt.contentType = ContentType.ANY

try {
    rt.get(uri: "http://10.70.30.83:8082/artifactory/npm-local/text3.txt", contentType: ContentType.BINARY) { resp, file ->
        //System.out << file
        new File("../OutputFiles/output.txt") << file
    }
}

catch (Exception e) {
    println("Download Failed. Reason: \n $e")
}