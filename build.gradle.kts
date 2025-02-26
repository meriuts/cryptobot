plugins {
	java
	id("org.springframework.boot") version "3.4.3"
	id("io.spring.dependency-management") version "1.1.7"
}

val telegrambotsVersion by extra("6.9.7.1")
val postgresqlDriverVersion by extra("42.7.3")
val logbackVersion by extra("1.5.16")
val slf4jVersion by extra("2.0.16")

group = "com.myapp"
version = "1.0-SNAPSHOT"

java {
	toolchain {
		languageVersion = JavaLanguageVersion.of(21)
	}
}

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-data-redis")


	implementation("org.telegram:telegrambots:$telegrambotsVersion")

	implementation("org.postgresql:postgresql:$postgresqlDriverVersion")

	implementation("org.slf4j:slf4j-api:$slf4jVersion")
	implementation("ch.qos.logback:logback-classic:$logbackVersion")

	compileOnly("org.projectlombok:lombok")
	annotationProcessor("org.projectlombok:lombok")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

tasks.withType<Test> {
	useJUnitPlatform()
}
