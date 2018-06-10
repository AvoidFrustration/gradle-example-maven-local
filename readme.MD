* Example of a simple multi-module gradle project
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
        
The api client and modules depend on their api common module.  The client-a module depends on the api client modules and
the server-a module depends on the api server modules.  Each module has a class that ensures the dependencies are present.

** What is in this example
The primary goal of this example is to show how to create a minimal gradle project that contains java modules and 
grouping folders. 

*** Using discrete .gradle files, subprojects, or apply from
There are a few ways to configure a modules.  The module may have a *.gradle file containing all or part of its 
configuration.  One of the parent modules may contain a subproject configuration that is applied to any children based
on filtering.  And finally(?) the module's .gradle file may import a configuration using `apply from:`

The root module does not contain a build.gradle file.  This is interesting itself as there isn't a requirement for a 
build.gradle file in the directory that `./gradlew build` is run.

The api-a modules use build.gradle files in the java projects only; none in the parent.  Both the api-a client and common
modules contain their full configuration.  The api-a server project uses `apply from:` for most of its configuration.

The api-b module uses a build.gradle file in the parent to contain most of the configurations.  Only the api-b client and
server contain build.gradle files for their dependency on the common module.

*** Using plugins 'java' vs 'java-library'
There doesn't seem to be a difference using the two different projects in this project.  This will need to be expanded
upon.




*** Different examples
This project show configurations with and without subprojects.  The root directory does not have a build.gradle file 
and neither does the api-a module.  So there is no subprojects 
configuration setup.  The api-b module has a build.gradle with subprojects configuration.