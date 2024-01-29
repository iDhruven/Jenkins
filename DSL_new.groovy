def gitRepoURL = 'https://ghe.megaleo.com/Dhruven-Shah/Jenkins'
def gitCredentialsId = 'GitHub'

def generateJob() {
    pipelineJob('Superman_Pipeline') {
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
            }
        }

        parameters {
            stringParam('branchName', '', 'main')
        }

        triggers {
            cron('H/5 * * * *') // Adjust this cron expression accordingly
        }

        configure { project ->
            project / 'triggers' << 'hudson.triggers.SCMTrigger' {
                spec('H/5 * * * *') // Adjust this spec accordingly
                ignorePostCommitHooks(false)
            }

            project / 'triggers' << 'org.jenkinsci.plugins.remotebuild.RemoteBuildTrigger' {
                buildToken('abc123') // Replace with your generated token
            }
        }
    }
}
generateJob()

