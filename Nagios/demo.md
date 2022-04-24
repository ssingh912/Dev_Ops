# Demonstration for Edureka Puppet Module

We will try to monitor addressbook application via nagios

## Install Nagios 
Follow the guide at [nagios-installation.md](nagios-installation.md) for installation

## Deploy addressbook application
On a separate host, deploy addressbook on port 5555
````bash
docker run -itdp 5555:8080 devopsxprts/addressbook:20100510
````

## Create configuration for nagios
1. Create an object configuration file [addressbook.cfg](addressbook.cfg) under `/usr/local/nagios/etc/objects/`
2. Enable this configuration file in  `/usr/local/nagios/etc/nagios.cfg`
    ````
    etc/nagios.cfg 
    cfg_file=/usr/local/nagios/etc/objects/addressbook.cfg
    ````