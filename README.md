# Possible Compiler Bug
There appears to be an issue with overriding grandparent interface methods in concrete impls which use Kotlin
delegation `by` keyword. This issue is highlighted [here](src/main/kotlin/ie/zalando/kotlincompilerbug/BugDemo.kt).
This repro project is a minimal reproduction generated via the spring initializr. I couldn't reproduce with a non spring
dependency so that's why I've included the spring deps.

## Steps to repro 
Compile this project with gradle
```shell
./gradlew clean check
```

View the error output
```shell

> Task :compileKotlin FAILED
e: ~/Work/dev/kotlin-compiler-bug/src/main/kotlin/ie/zalando/kotlincompilerbug/BugDemo.kt: (19, 5): Conflicting overloads: public open fun findById(id: Long): Optional<String> defined in ie.zalando.kotlincompilerbug.ConcreteImplWithOverrides, public open fun findById(id: Long): Optional<String!> defined in ie.zalando.kotlincompilerbug.ConcreteImplWithOverrides

FAILURE: Build failed with an exception.

* What went wrong:
Execution failed for task ':compileKotlin'.
> Compilation error. See log for more details

* Try:
> Run with --stacktrace option to get the stack trace.
> Run with --info or --debug option to get more log output.
> Run with --scan to get full insights.

* Get more help at https://help.gradle.org

BUILD FAILED in 1s
2 actionable tasks: 2 executed
```
