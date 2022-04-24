Tasks:
```groovy
tasks.register('hello') {
    doLast {
        println 'Hello world!'
    }
}

# Write as code
tasks.register('upper') {
    doLast {
        String someString = 'mY_nAmE'
        println "Original: $someString"
        println "Upper case: ${someString.toUpperCase()}"
    }
}

# tasks dependency
tasks.register('hello') {
    doLast {
        println 'Hello world!'
    }
}
tasks.register('intro') {
    dependsOn tasks.hello
    doLast {
        println "I'm Gradle"
    }
}
```

Direct acyclic graph

![image](https://user-images.githubusercontent.com/17488415/124798786-67297200-df71-11eb-9c0b-c137a7baaca5.png)


# tasks
![image](https://user-images.githubusercontent.com/17488415/124799140-db641580-df71-11eb-8619-278684ede139.png)
