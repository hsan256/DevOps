pipeline{
    agent any
    tools {
        jdk 'JAVA_HOME'
        maven 'M2_HOME'
    }

    stages{


        stage('Cloning from GitHub') {
            steps {
                echo 'Pulling From Github...'
                git branch: 'main', 
                credentialsId: 'jenkins', 
                url: 'https://github.com/hsan256/DevOps.git'
            }
            
        }   

        stage ('Check Tools Initializing') {
            steps {
                sh 'java --version'
                sh 'mvn --version'
                sh '''
                    echo "PATH = ${PATH}"
                    echo "M2_HOME = ${M2_HOME}"
                '''
            }
        }        
      
        stage('Clean'){
            steps {
                sh 'echo "Clean the Project is processing ...."'
                sh 'mvn clean '
            }
            
        }
        
        stage('Artifact Construction'){
            steps {
                sh 'mvn -B -DskipTests package'
            }
            
        }
        
        
        stage('UNIT test'){
            steps{
                sh 'mvn test'
            }
        }

        /*stage('SonarQube Analysis'){
            steps {
                sh """mvn sonar:sonar -DskipTests \
                        -Dsonar.language=java \
                        
                        
                """
            }
            
        }*/
        
        
        /*stage('Nexus'){
            steps{
                sh 'mvn deploy -DskipTests'
            }
        }*/
    }
}