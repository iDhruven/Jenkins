pipeline {
    agent any

    stages {
        stage ('Generate Job') {
            steps {
                script {
                    sh "pip3 install job_dsl"
                    sh "python3 DSL.py"
                    //def dslScript = load 'DSL_2.groovy'
                    //dslScript()
                }
            }
        }
    }
}
