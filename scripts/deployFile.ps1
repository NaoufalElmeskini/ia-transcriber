# usage:
## .\deployFile.ps1 C:\some_path\convertedKey.ppk .\fileToSend.txt ec2-xxxx-x-xxx.eu-north-x.amazonaws.com
####################################
# key format: encryption keys in this project are in different format : some script use .ppk and others .pem
# a simple conversion is necessary to create one from an other (probably .pem to .ppk)
####################################
param(
    [string]$certificate,
    [string]$file,
    [string]$server
)

if (!$certificate) {
    Write-Host "/!\ you didn't insert certificate"
    exit
}
if (!$file) {
    Write-Host "/!\ you didn't insert file"
    exit
}
if (!$server) {
    Write-Host "/!\ you didn't insert server"
    exit
}

echo "deploying to : " ec2-user@$($server)
.\pscp.exe -scp -i $certificate $file ec2-user@$($server):~