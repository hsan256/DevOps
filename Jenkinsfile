pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
            steps {
                echo 'Pulling From Github...'
                git branch: 'main', 
                credentialsId: 'jenkins', 
                url: 'https://github.com/hsan256/DevOps.git'
            }
            
        }           
      
        stage('Clean'){
            steps {
                sh 'mvn clean '
            }
            
        }
        
        stage('Compile'){
            steps {
                sh 'mvn compile  -DskipTests'
            }
            
        }
        
        
        /* stage('UNIT test'){
            steps{
                sh 'mvn test'
            }
        }*/

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