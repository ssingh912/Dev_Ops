# Install docker in one of the jenkins nodes (master or slave or any other node)

# Enable jenkins to run sudo commands without password
_This should be done on the node where you want to run a docker build_

_if this is on master, then grant sudo access to Jenkins user_

_if this is on node, grand sudo access for the user which is used to connect to the node in node configuration_


## Execute below command
   ```bash
   sudo echo "jenkins   ALL=(ALL:ALL) NOPASSWD:ALL" >> /etc/sudoers
   ```


# Jenkins Freestyle job to create docker iamge
* Add the below commands to `Execute shell` build step :
  ```bash
   mvn package # this will generate the war file
   cp addressbook_main/target/addressbook.war . # this will copy the war file to build context (current dir)
   sudo docker build -t addressbook:$BUILD_NUMBER . # build the iamge
   ```
