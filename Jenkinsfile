pipeline{
    agent any

    stages{


        stage('Cloning from GitHub') {
            steps {
                echo 'Pulling From Github...'
                git branch: 'main', 
                credentialsId: git credentialsId: 'db8f361d-31ac-4ec3-9527-ff2b75b4ef09', url: 'https://github.com/hsan256/DevOps.git'
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