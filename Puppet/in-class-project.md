# Generate addressbook.war
``` bash
apt-get update
apt-get install -y maven openjdk-8-jdk
git clone https://github.com/amitkumar2283/addressbook
cd addressbook
mvn package
```

# Install tomcat module
``` bash
cd  /etc/puppetlabs/code/environments/production/modules
puppet module install puppetlabs-tomcat
```

# Copy over the generated WAR file to tomcat module's `files` folder
``` bash
mkdir -p /etc/puppetlabs/code/environments/production/modules/tomcat/files
cp /root/addressbook/addressbook_main/target/addressbook.war /etc/puppetlabs/code/environments/production/modules/tomcat/files
```

# Write Your manifest

``` rb
# Install java
class { 'java' :
  package => 'openjdk-8-jdk',
}

# Install tomcat9 server
tomcat::install { '/opt/tomcat':
  source_url => 'https://mirrors.estointernet.in/apache/tomcat/tomcat-9/v9.0.46/bin/apache-tomcat-9.0.46.tar.gz',
}
tomcat::instance { 'default':
  catalina_home => '/opt/tomcat',
}

# Deploy WAR file
tomcat::war { 'addressbook.war':
  catalina_base => '/opt/tomcat',
  war_source    => "puppet:///modules/tomcat/addressbook.war",
}
```
