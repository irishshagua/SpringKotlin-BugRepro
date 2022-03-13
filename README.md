# Possible Compiler Bug
There appears to be an issue with overriding grandparent interface methods in concrete impls which use Kotlin
delegation `by` keyword. This issue is highlighted [here](src/main/kotlin/ie/zalando/kotlincompilerbug/BugDemo.kt).
This repro project is a minimal reproduction generated via the spring initializr. I couldn't reproduce with a non spring
dependency so that's why I've included the spring deps.


 

