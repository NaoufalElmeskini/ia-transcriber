# usage:
# .\deployJar.ps1 C:\path_to_key\key.ppk ec2-xx-xx.amazonaws.com
####################################
# key format: encryption keys in this project are in different format : some script use .ppk and others .pem
# a simple conversion is necessary to create one from an other (probably .pem to .ppk)
####################################
param(
    [string]$ppkCertificate,
    [string]$server
)

if (!$ppkCertificate) {
    Write-Host "/!\ you didn't insert .ppk certificate"
    exit
}
if (!$server) {
    Write-Host "/!\ you didn't insert server"
    exit
}

mvn clean package -DskipTests --file ..\pom.xml
.\pscp.exe -scp -i $ppkCertificate ../target/*.jar ec2-user@$($server):~