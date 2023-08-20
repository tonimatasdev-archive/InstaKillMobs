plugins {
    java
}

val pluginVersion: String by extra

group = "net.tonimatasdev"
version = pluginVersion

base {
    archivesName.set("InstaKillMobs")
}

repositories {
    mavenCentral()
    maven(url = "https://hub.spigotmc.org/nexus/content/repositories/snapshots/")
}

dependencies {
    compileOnly("org.spigotmc:spigot-api:1.20.1-R0.1-SNAPSHOT")
}

tasks.withType<ProcessResources> {
    inputs.property("version", version)

    filesMatching("plugin.yml") {
        expand("version" to version)
    }
}

tasks.withType<JavaCompile> {
    options.encoding = "UTF-8"
}
