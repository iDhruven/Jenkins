pipeline {
    agent any

    stages {
        stage ('Generate Job') {
            steps {
                script {
                    //sh "pip3 install gocept.jenkinsdsl"
                    //sh "python3 DSL.py"
                    def dslScript = load 'DSL_new.groovy'
                    dslScript()
                }
            }
        }
    }
}
