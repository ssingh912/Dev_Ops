## Install Postfix
```
apt-get install libsasl2-modules mailutils
apt-get install postfix
```
## File: /etc/postfix/sasl_passwd
```bash
echo [smtp-relay.sendinblue.com]:587 username:password > /etc/postfix/sasl_passwd
```

## postmap
```
postmap /etc/postfix/sasl_passwd
chown root:root /etc/postfix/sasl_passwd /etc/postfix/sasl_passwd.db
chmod 0600 /etc/postfix/sasl_passwd /etc/postfix/sasl_passwd.db
```

## update relayhost /etc/postfix/main.cf
```
# specify SMTP relay host
relayhost = [smtp-relay.sendinblue.com]:587
```

## Add at the end of /etc/postfix/main.cf
``` 
# enable SASL authentication
smtp_sasl_auth_enable = yes
# disallow methods that allow anonymous authentication.
smtp_sasl_security_options = noanonymous
# where to find sasl_passwd
smtp_sasl_password_maps = hash:/etc/postfix/sasl_passwd
```

## test
```bash
echo "This is the body of the email" | mail -s "This is the subject line" devopsxprts@gmail.com
```
