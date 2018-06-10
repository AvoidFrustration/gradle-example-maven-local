# Example of a simple multi-module java gradle project
This is an example of a multi-module gradle project.  This tries to be the simplest configuration.

The project layout is

    root
        api-a - grouping folder
            api-a-client - java module
            api-a-common - java module
            api-a-server - java module
        api-b - grouping folder
            api-b-client - java module
            api-b-common - java module
            api-b-server - java module
        client-a - java module
        node-a - java module
        util - java module
        
The api client and modules depend on their api common module.  The client-a module depends on the api client modules and
the server-a module depends on the api server modules.  Each module has a class that ensures the dependencies are present.

## What is in this example
The primary goal of this example is to show how to create a minimal gradle project that contains java modules and 
grouping folders. The grouping folders can be empty or have subproject configurations.  Each project will need junit
and the one of the java plugins.  An example configuration is

```groovy
apply plugin: 'java-library'

dependencies {
    dependencies {
        testImplementation(
                'org.junit.jupiter:junit-jupiter-api:5.1.0'
        )
        testRuntimeOnly(
                'org.junit.jupiter:junit-jupiter-engine:5.1.0'
        )
    }
}

repositories {
    mavenCentral()
}
```

There are two types of dependencies between the projects.
### Using discrete .gradle files, subprojects, or apply from
There are a few ways to configure a modules.  The module may have a build.gradle file containing all or part of its 
configuration.  One of the parent modules may contain a subproject configuration that is applied to any children based
on filtering.  And finally(?) the module's build.gradle file may import a configuration using `apply from:`

The root module does not contain a build.gradle file.  This is interesting itself as there isn't a requirement for a 
build.gradle file in the directory that `./gradlew build` is run.

The api-a modules use build.gradle files in the java projects only; none in the parent.  Both the api-a client and common
modules contain their full configuration. 

The api-a server project uses `apply from:` for most of its configuration.  This allows for a configuration to be imported.

```groovy
apply from: "$rootDir/gradle/java.gradle"

dependencies {
    dependencies {
        api project(':api-a:api-a-common')
        implementation project(':util')
    }
}
```

The api-b module uses a build.gradle file in the parent to contain most of the configurations.  Only the api-b client and
server contain build.gradle files for their dependency on the common module.

```groovy
subprojects{
    apply plugin: 'java'

    dependencies {
        testImplementation (
                'org.junit.jupiter:junit-jupiter-api:5.1.0'
        )
        testRuntimeOnly (
                'org.junit.jupiter:junit-jupiter-engine:5.1.0'
        )

    }

    repositories {
        mavenCentral()
    }
}
```

### Using plugins 'java' vs 'java-library'
Using the java-libary plugin allows for the use of api dependencies.  This dependency will avoid pulling in transitive
dependencies during compile time.  This works in IntelliJ.

api-a usings the java-library plugin like the above example and the client and server subprojects add an api dependency for 
common and util.  util is an implementation dependency so modules dependent on client or server will not see util through
those modules.  Conversely, common is an api dependency an is available like a maven transitive dependency.

```groovy
dependencies {
    dependencies {
        api project(':api-a:api-a-common')
        implementation project(':util')
    }
}
```

api-b uses the java plugin and uses the deprecated compile dependency instead of the api available in the java-library.

```groovy
dependencies {
    compile project(':api-b:api-b-common')
    implementation project(':util')
}
```

### Takeaways from this Example
There are a few interesting things in this example that will drive future examples.
 * Using `apply from:` allows for importing configuration
 * Not every directory needs a build.gradle
 * Using `subprojects` removes a lot of copy/paste code. But not all modules are java projects
 * Using the java-library with api dependencies has value in reducing exposed transitive dependencies
 * Use $rootDir instead of relative path (../../) to find imported build files, and use double quotes ""