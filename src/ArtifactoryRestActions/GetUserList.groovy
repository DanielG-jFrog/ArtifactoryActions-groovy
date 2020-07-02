package ArtifactoryRestActions

@Grab(group='org.codehaus.groovy.modules.http-builder', module='http-builder', version='0.6')

import groovyx.net.http.ContentType
import groovyx.net.http.RESTClient


//Artifactory credentials and base URL
String baseUrl = "http://10.70.30.83:8082"
String user = "admin"
String password = "Dn2120091"

// Users
String getUsersPath = '/artifactory/api/security/users'


def rt = new RESTClient(baseUrl)
rt.auth.basic user, password
rt.contentType = ContentType.JSON

try {
    rt.get(path: getUsersPath) { response, json ->
        println(response.status)
        println(json.name[8])
    }
}
catch (Exception e){
    println(e)
}