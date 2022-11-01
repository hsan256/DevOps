pipeline {
  agent any
  tools {
    maven 'M2_HOME'
  }

  stages {

    stage('preparation : start sonar, nexus, local mysql') {
      steps {
        sh "docker start bfa"
        sh "docker start 188"
        sh "docker start 8a8"
      }
    }

    stage('Getting project from Git') {
      steps {
                echo 'Pulling From Github...'
                git branch: 'main', 
                credentialsId: 'jenkins', 
                url: 'https://github.com/hsan256/DevOps.git'
            }
    }

    stage('Cleaning the project') {
      steps {
        sh "mvn -B -DskipTests clean  "
      }
    }

    stage('Artifact Construction') {
      steps {
        sh "mvn -B -DskipTests package "
      }
    }

    stage('Unit Tests') {
      steps {
        sh "mvn test "
      }
    }

}