pipeline {
    agent any

    stages {
        stage ('Generate Job') {
            steps {
                script {
                    def dslScript = readFileFromWorkspace('DSL_2.groovy')
                    dsl(dslScript)
                }
            }
        }
    }
}
