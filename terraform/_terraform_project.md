1. Network Setup
  *  Create a VPC
  *  Create an internet gateway
  *  Create a custom Route Table
  *  Create a Subnet
  *  Associate the Subnet with the Route Table
2. Security Group Setup
  * Create a new security group
  * Enable ports 22, 80, 443
3. Network Interface Setup
  *  Create a new network interface with IP in the previously created subnet
  *  Create an elastic IP associated with the network interface
4. Ec2 instance setup
  *  Create a new ubuntu ec2 instance and attach the network interface to it
  *  Install httpd server on it

[Project] (Project)
