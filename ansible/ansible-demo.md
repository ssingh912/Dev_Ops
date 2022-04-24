# Ansible Demo
## Install Ansible
   ```bash
   apt install ansible
   ```

## Inventory `/etc/ansible/hosts`
```
<ip address 1>
<ip address 2> ansible_connection=local # for  adding ansible server
```

## Enable passwordless SSH connection from ansible server to hosts
1. On Ansible server, generate SSH key-pair. DO NOT OVERWRITE any existing Key-Pair
   ```bash
   ssh-keygen # press enter till are back at the terminal
   ```
2. Disable Host key checking for ansible

   This is  done by setting the following value in `/etc/ansible/ansible.cfg`:

   ```cfg
   [defaults]
   host_key_checking = False
   ```

3. Copy the public key text from ansible server `~/.ssh/id_rsa.pub` to the `/root/.ssh/authorized_keys` files on ALL the hosts

4. Test the setup

   ```
   ansible all -m ping
   ```

## Ad-hoc commands

```ansible
ansible all -m ping

ansible all -m user -a "name=demouser state=present"

```

