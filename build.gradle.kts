plugins {
    id("java")
    application
}

group = "app.belgarion.UNO"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains:annotations:15.0")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}

tasks.test {
    useJUnitPlatform()
}
application {
    mainClass.set("app.belgarion.Main") // replace with your full package+class name
}

tasks.named<JavaExec>("run") {
    standardInput = System.`in`
    jvmArgs("-Djansi.passthrough=true")
}
