def gitRepoURL = 'https://ghe.megaleo.com/Dhruven-Shah/Jenkins'
def gitCredentialsId = 'GitHub'

def generateJob() {
    pipeline {
        //agent any
        //options {
        //    buildDiscarder(logRotator(artifactDaysToKeepStr: '', artifactNumToKeepStr: '', daysToKeepStr: '', numToKeepStr: '5'))
        //}

        // Specify a custom name for your Jenkins job
        displayName 'Superman_Pipeline'

        stages {
            stage('Build') {
                steps {
                    script {
                        checkout([$class: 'GitSCM', branches: [[name: '${branchName}']], doGenerateSubmoduleConfigurations: false, extensions: [[$class: 'SubmoduleOption', disableSubmodules: false, parentCredentials: true, recursiveSubmodules: true, reference: '', trackingSubmodules: true]], submoduleCfg: [], userRemoteConfigs: [[credentialsId: gitCredentialsId, url: gitRepoURL]]])
                        load 'Jenkinsfile'
                    }
                }
            }
        }

        parameters {
            string(name: 'branchName', defaultValue: 'main', description: 'Branch to build')
        }

        triggers {
            cron('H/5 * * * *') // Adjust this cron expression accordingly
        }
    }
}

generateJob()
