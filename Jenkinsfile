pipeline {
    agent any

    stages {

        stage('GIT') {
            steps {
                echo 'Pulling From Github...'
                git branch: 'main', 
                credentialsId: 'jenkins', 
                url: 'https://github.com/hsan256/DevOps.git'
            }
        }

        stage('MVN CLEAN'){
            steps{
                sh  'mvn clean'
            }
        }

        stage('MVN COMPILE'){
            steps{
                sh  'mvn compile'
            }
        }

        stage('MVN PACKAGE'){
              steps{
                  sh 'mvn package -DskipTests=true'
              }
        }

        // stage('Building Docker Image'){
        //     steps{
        //         script{
        //             sh 'docker build -t hassan1999/docker-spring-boot .'
        //         }
        //     }
        // }

        // stage('Push docker image'){
        //  steps{
        //      script{
        //          withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
        //          sh 'docker login -u hassan1999 -p ${dockerhubpwd}'
        //         }
        //         sh 'docker push hassan1999/docker-spring-boot'
        //      }
        //  }
        // }

          stage('DOCKER COMPOSE') {
                steps {
                        sh 'docker-compose up -d --build'
                }
          }

        //   stage('MVN SONARQUBE'){

        //         steps{
        //                 sh  'mvn sonar:sonar -Dsonar.login=admin -Dsonar.password=jenkins'
        //         }
        //   }

          stage("Test JUnit / Mockito"){
                steps {
                        sh 'mvn test'
                }
          }

        //   stage("NEXUS"){
        //        steps{
        //                sh 'mvn deploy'
        //        }
        //   }

    }

    post{
            success {
                mail to: "hassen.trabelsi@esprit.tn",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n, More info at: ${env.BUILD_URL}",
                from: "hsan.trabelsi1999@gmail.com",
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            }

            failure{
                mail to: "hassen.trabelsi@esprit.tn",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                from: "hsan.trabelsi1999@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
            }

            changed{
                mail to: "hassen.trabelsi@esprit.tn",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                from: "hsan.trabelsi1999@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
            }
        }
}



