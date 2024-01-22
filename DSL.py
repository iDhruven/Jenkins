from gocept.jenkinsdsl import JenkinsJob

gitRepoURL = "https://github.com/iDhruven/Jenkins"
gitCredentialsId = "ac98bbd7-38fc-4a1f-8339-ddc65c6716a2"

def generateJob(job_dsl):
    job_dsl.job("Superman_Pipeline")(
        definition=dict(
            cpsScm=dict(
                scm=dict(
                    git=dict(
                        remote=dict(
                            url=gitRepoURL,
                            credentials=gitCredentialsId
                        ),
                        branch='${branchName}',
                        browser=dict(
                            githubWeb=dict(
                                repoUrl=gitRepoURL
                            )
                        )
                    ),
                    scriptPath='Jenkinsfile',
                    lightweight=True
                ),
                triggers=dict(
                    genericTrigger=dict(
                        genericVariables=dict(
                            genericVariable=dict(
                                key='branchName',
                                expressionType='JSONPath',
                                value='',
                                defaultValue='main'
                            )
                        ),
                        token='abc123',
                        printPostContent=True,
                        printContributedVariables=True,
                        causeString='Generic Cause'
                    )
                )
            )
        )
    )

# Create an instance of JenkinsJob and call the generateJob function
job_dsl = JenkinsJob()
generateJob(job_dsl)

# Print the generated DSL script
print(job_dsl.generate_script())
