pipeline {
    agent any

    stages {
        stage ('Generate Job') {
            steps {
                script {
                    def dslScript = load 'DSL_2.groovy'
                    def closure = dslScript.buildGroovy()
                    closure()
                }
            }
        }
    }
}
