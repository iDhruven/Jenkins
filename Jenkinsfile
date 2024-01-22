pipeline {
    agent any

    stages {
        stage ('Generate Job') {
            steps {
                script {
                    sh "python3 DSL.py"
                    //def dslScript = load 'DSL_2.groovy'
                    //dslScript()
                }
            }
        }
    }
}
