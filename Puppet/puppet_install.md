# Install Puppet cluster on Ubuntu
_Note: Run all the commands as **root** user_

## Setup Puppetserver and Nodes
### On Puppetserver

1. Install puppet
   ````bash
   wget https://apt.puppet.com/puppet7-release-focal.deb
   dpkg -i puppet7-release-focal.deb
   apt-get update
   apt install -y openjdk-8-jre-headless puppetserver  puppet-agent
   ````

2. configure puppet binaries in path

   ````bash
   source /etc/profile.d/puppet-agent.sh
   export PATH=/opt/puppetlabs/bin:$PATH
   ````
3. Identify the FQDN of the puppetserver  
   on puppetserver, execute
   ````
   hostname --fqdn
   ````
   **Save the fqdn for later usage**

4. configure puppetserver location in puppet.conf
   ````
   puppet config set server <puppetserver-fqdn> --section main
   ````

5. set correct java heapsize values for puppet in file `/etc/default/puppetserver`

   change `-Xmx2g -Xms2g` to `-Xmx512m -Xms512m`

6. Start puppetserver 
   ````bash
   systemctl start puppetserver
   ````

### On Puppet Agent Node

1. Install puppet agent
   ````bash
   wget https://apt.puppet.com/puppet7-release-focal.deb
   dpkg -i puppet7-release-focal.deb
   apt-get update
   apt-get install -y puppet-agent
   ````
2. add puppetagent to path
   ````bash
   source /etc/profile.d/puppet-agent.sh
   export PATH=/opt/puppetlabs/bin:$PATH
   ````
3. configure puppetserver location in puppet.conf
   ```
   puppet config set server <puppetserver-fqdn> --section main
   ```

## Add the Agent machine as Node to Puppetserver
1. Generate SSL-Cert-Request on Puppet Node

   `puppet ssl bootstrap`

2. Accept (sign) the cert req on Puppetserver

   `puppetserver ca sign --all`

   OR

   `puppetserver ca sign --certname <certificatename>`

