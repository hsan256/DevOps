pipeline {
    agent any

    stages {

        stage('Checkout GIT') {
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

        /* stage('Ansible'){
               steps{
                        sh  'ansible-playbook -i hosts.yml ansible-playbook.yml'
               }

         }*/

        /*stage('Build docker image'){
            steps{
                script{
                    sh 'docker build -t hassan1999/docker-spring-boot .'
                }
            }
        }

        stage('Push docker image'){
         steps{
             script{
                 withCredentials([string(credentialsId: 'dockerhub-pwd', variable: 'dockerhubpwd')]) {
                 sh 'docker login -u hassan1999 -p ${dockerhubpwd}'
                }
                sh 'docker push hassan1999/docker-spring-boot'
             }
         }
        }*/

          stage('DOCKER COMPOSE') {
                steps {
                        sh 'docker-compose up -d --build'
                }
          }

        //   stage("nexus deploy"){
        //        steps{
        //                sh 'mvn deploy'
        //        }
        //   }

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

    }

    post{
            success {
                mail to: "hassan.trabelsi1999@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n, More info at: ${env.BUILD_URL}",
                from: "hassan.trabelsi1999@gmail.com",
                subject: "Jenkins Build ${currentBuild.currentResult}: Job ${env.JOB_NAME}"
            }

            failure{
                mail to: "hassan.trabelsi1999@gmail.com",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                from: "hassan.trabelsi1999@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
            }

            changed{
                mail to: "hassan.trabelsi1999@gmail.com",
                subject: "jenkins build:${currentBuild.currentResult}: ${env.JOB_NAME}",
                from: "hassan.trabelsi1999@gmail.com",
                body: "${currentBuild.currentResult}: Job ${env.JOB_NAME}\nMore Info can be found here: ${env.BUILD_URL}"
            }
        }
}



