def gitRepoURL = 'https://github.com/iDhruven/Jenkins'
def gitCredentialsId = 'ac98bbd7-38fc-4a1f-8339-ddc65c6716a2'


jobDsl('Superman_Pipeline') {
    definition {
        cpsScm {
            scm {
                git {
                    remote {
                        url(gitRepoURL)
                        credentials(gitCredentialsId)
                    }
                    branch('${branchName}')
                    browser {
                        githubWeb {
                            repoUrl(gitRepoURL)
                        }
                    }
                }
                scriptPath('Jenkinsfile')
                lightweight(true)
            }

            triggers {
                genericTrigger {
                    genericVariables {
                        genericVariable {
                            key('branchName')
                            expressionType('JSONPath')
                            value('')
                            defaultValue('main')
                        }
                    }
                    token('abc123')
                    printPostContent(true)
                    printContributedVariables(true)
                    causeString('Generic Cause')
                }
            }
        }
    }
}
