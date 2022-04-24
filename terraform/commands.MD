## Install AWS CLI
```
apt install awscli
```

## Save your Credentials
```
aws configure
```

## Install terraform
```
wget https://releases.hashicorp.com/terraform/1.0.1/terraform_1.0.1_linux_amd64.zip
unzip terraform_1.0.1_linux_amd64.zip 
cp terraform /usr/bin/
cp terraform /usr/local/bin/
terraform --version
terraform -install-autocomplete
```

## terraform Commands
```bash
terraform refresh # refresh the state
terraform fmt # Format the files
terraform validate # validate the config file
terraform apply # See the plan, and apply
terraform show # Display all assets
terraform state list # list down the resources
terraform state show <instance_name>
terraform destroy # Destroy resources

terraform apply  -var "instance_name=YetAnotherName" # Apply with variables
```

## Examples:
```rb
# basic
terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }
  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "default"
  region  = "us-west-2"
}

resource "aws_instance" "app_server" {
  ami           = "ami-830c94e3"
  instance_type = "t2.micro"
  tags = {
    Name = "ExampleAppServerInstance"
  }
}
```

```rb
# with variable
variable "instance_name" {
  description = "Value of the Name tag for the EC2 instance"
  type        = string
  default     = "ec2_name"

}

terraform {
  required_providers {
    aws = {
      source  = "hashicorp/aws"
      version = "~> 3.27"
    }
  }
  required_version = ">= 0.14.9"
}

provider "aws" {
  profile = "default"
  region  = "us-west-2"
}

resource "aws_instance" "app_server" {
  ami           = "ami-830c94e3"
  instance_type = "t2.micro"
  tags = {
    Name = var.instance_name
  }
}
```
