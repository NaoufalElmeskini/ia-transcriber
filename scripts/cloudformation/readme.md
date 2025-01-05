

## troubleshooting
cloudformation logs in EC2 :
- /var/log/cloud-init-output.log
- /var/log/cloud-output.log

## useful CFN commands:

### create stack :
````powershell
aws cloudformation create-stack --stack-name someUsStack2
#    --template-body file://C:\Users\neal_\Desktop\local-projects\software\aws-ec2-spring-api-ex\scripts\cloudformation\ec2Instance.yml
#    --parameters ParameterKey=SecurityGroupDescription,ParameterValue=uneDescription
#    --capabilities CAPABILITY_IAM
````

### display stack
````powershell
aws cloudformation describe-stacks --stack-name someStack
````

### update stack:
````powershell
aws cloudformation update-stack --stack-name someStack 
#   --template-url https://s3Url/template.yml
#   --parameters ParameterKey=Maxvalue,ParameterValue=7
````
