def gitRepoURL = 'https://github.com/iDhruven/Jenkins'
def gitCredentialsId = 'ac98bbd7-38fc-4a1f-8339-ddc65c6716a2'

def generateJob() {
    pipelineJob('Superman_Pipeline') {
        definition {
            script {
                git remoteUrl gitRepoURL
                git credentialsId gitCredentialsId
                git branch 'main' // or replace with your desired branch name
                load 'Jenkinsfile'
            }
        }

        triggers {
            genericTrigger {
                token('abc123')
                printPostContent(true)
                printContributedVariables(true)
                causeString('Generic Cause')
                genericVariables {
                    genericVariable {
                        key('branchName')
                        expressionType('JSONPath')
                        value('')
                        defaultValue('main')
                    }
                }
            }
        }
    }
}
