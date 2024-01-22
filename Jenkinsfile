pipeline {
    agent any

    stages {
        stage ('Generate Job') {
            steps {
                script {
                    //def dslScript = load 'DSL_2.groovy'
                    def dslScript = load 'DSL_new.groovy'
                    sh 'import DSL_new.groovy'
                }
            }
        }
    }
}
