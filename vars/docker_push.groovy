def call(String Project, String ImageTag, String dockerhubuser, String credentialsId ){
  withCredentials([usernamePassword(credentialsId: ${credentialsId}, passwordVariable: 'dockerHubPass', usernameVariable: 'dockerHubUser')]) {
      sh "docker login -u ${dockerhubuser} -p ${dockerhubpass}"
  }
  sh "docker push ${dockerhubuser}/${Project}:${ImageTag}"
}
