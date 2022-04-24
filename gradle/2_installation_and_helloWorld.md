https://gradle.org/install/

# initialize project
`gradle init`

# Tasks
## see tasks
`gradle tasks`

currently no tasks. only defau;t system tasks

## create task
in build.gradle

```groovy
tasks.register('hello') {
    doLast {
        println 'Hello world!'
    }
}
```

## run task
`gradle <taskname>`

# gradle settings
project name

# gradlew wrapper
