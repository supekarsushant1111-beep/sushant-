pipeline {
    agent any
    stages {
        stage('Pull') {
            steps {
                git branch: 'main', url: 'https://github.com/rajatpzade/ONCDECB16.git'
            }
        }   
        stage('Destroy') {   
            steps {
                sh '''cd Terraform/
                      cd eks/ 
                      terraform init
                      terraform destroy --auto-approve'''
            }
        }
    }
}
