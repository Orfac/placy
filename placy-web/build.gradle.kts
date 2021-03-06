import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.3.72"
}

group = "placy"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_1_8

repositories {
	maven("https://repo.spring.io/snapshot")
  mavenCentral()
}

dependencies {
	implementation(kotlin("stdlib-jdk8"))
	implementation("io.projectreactor.netty:reactor-netty:1.0.0-SNAPSHOT")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.3.1")
	testImplementation("io.mockk:mockk:1.9.3")
	testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.3.1")
}

tasks.withType<Test> {
	useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "1.8"
	}
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
	jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
	jvmTarget = "1.8"
}