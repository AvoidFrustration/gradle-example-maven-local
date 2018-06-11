# Example of a multi-module java gradle project with a local maven repo
This continuation of the simple multi-module java example.  This repo adds examples for publishing jars to the local
maven repo.  This matches normal maven build functionality.

The project layout continues to be

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
The primary goal of this example is to show how to configure the publishing of maven artifacts to the local repo on each
build in gradle.  The configuration will use the maven-publish plugin.  The publishing configuration only contains the 
local maven repository.  And finally publishToMavenLocal will be run after any build task.

```groovy
<<<<<<< HEAD
    apply plugin: 'maven-publish'

    publishing {
        publications {
            mavenJava(MavenPublication) {
                from components.java
            }
        }
        repositories {
            mavenLocal()
        }
=======
apply plugin: 'java-library'

sourceCompatibility = JavaVersion.VERSION_1_8
targetCompatibility = JavaVersion.VERSION_1_8
    
dependencies {
    dependencies {
        testImplementation(
                'org.junit.jupiter:junit-jupiter-api:5.1.0'
        )
        testRuntimeOnly(
                'org.junit.jupiter:junit-jupiter-engine:5.1.0'
        )
>>>>>>> upstream/master
    }

    build.dependsOn publishToMavenLocal

```

### Using discrete .gradle files, subprojects, or apply from
This example continues to have the configuration examples from the simple project.  The publishing configuration
is just added to the existing build.gradle files.

### Using task publishToMavenLocal vs publish
running publish will also deploy the artifacts to the maven repo but adds a timestamp and build number to the jar name.  The publishToMavenLocal
task follows the typical maven local repository filename of just using the version number.  Examples of the two are

```text
node-a-0.1-20180610.233613-1.jar
node-a-0.1-SNAPSHOT.jar
```

<<<<<<< HEAD
The publish task format is more typical of a name on a remote snapshot repository.
=======
The api-b module uses a build.gradle file in the parent to contain most of the configurations.  Only the api-b client and
server contain build.gradle files for their dependency on the common module.

```groovy
subprojects{
    apply plugin: 'java'

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
    
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
>>>>>>> upstream/master

### Takeaways from this Example
There are a few interesting things in this example that will drive future examples.
 * Use publishToMavenLocal instead of publish
 * Use dependsOn to link tasks
