# terraform apply  -var "instance_name=YetAnotherName" # Apply with variables

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

