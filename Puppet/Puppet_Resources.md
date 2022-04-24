# Manifest

# Resource
1. File
``` rb
file { 'helloworld':
  path    => '/tmp/helloworld.conf',
  ensure  => file,
  content => "Hello World",
}
```
2. package
``` rb
package { 'apache2':
  ensure => installed,
}
```
3. relationships
``` rb
package { 'apache2':
  ensure => installed,
  before => File['helloworld'],
}
service { 'apache2':
  ensure    => running,
  subscribe => Package['apache2'],
}
```

4. Notify
```rb
notify { 'Debug Message':
  message  => "hello",
}
```

# Variables
## Custom Variables
``` rb
$content = "This content is defined in a variable"
file {'/tmp/fileContainingVariableText':
  ensure  => file,
  content => ${content},
}
```
## Factor variables
``` rb
notify { 'OS Family':
 message => $facts['os']['family']
}

```