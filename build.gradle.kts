plugins {
    kotlin("jvm") version "1.9.0"
    application
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test"))
    implementation("org.apache.logging.log4j:log4j-api:2.7")
    implementation("org.apache.logging.log4j:log4j-core:2.12.4")
    implementation("org.slf4j:slf4j-simple:2.0.9")
    implementation("org.eclipse.jetty:jetty-server:11.0.14")
    implementation("org.eclipse.jetty:jetty-servlet:11.0.3")
    implementation("com.github.ajalt.clikt:clikt:4.2.1")
    implementation("io.github.classgraph:classgraph:4.8.162")
    implementation(kotlin("reflect"))

}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(17)
}

application {
    mainClass.set("MainKt")
}

class GreetingPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.task("hello"){
            doLast {
                println("Hello form the greeting plugin")
            }
        }
    }
}

apply<GreetingPlugin>()