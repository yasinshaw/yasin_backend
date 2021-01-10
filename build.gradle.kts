import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("io.spring.dependency-management") version "1.0.10.RELEASE"
	kotlin("plugin.spring") version "1.4.20"
	kotlin("jvm") version "1.4.10"
}

allprojects {
	group = "com.yasinshaw"
	version = "0.0.1-SNAPSHOT"
    apply(plugin = "kotlin")

	java.sourceCompatibility = JavaVersion.VERSION_11

	configurations {
		compileOnly {
			extendsFrom(configurations.annotationProcessor.get())
		}
	}
	repositories {
		maven (
			url = "http://maven.aliyun.com/nexus/content/groups/public"
		)
	}
    dependencies {
		implementation(kotlin("stdlib"))
	}
	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict")
			jvmTarget = "11"
		}
	}
}


tasks {
	fun createDir(path: String) {
        val file = File(path)
		if (!file.exists()) {
			println("create dir $path")
			file.mkdirs()
		}
	}
	task("createDir") {
		val dirs = arrayOf("src/main/kotlin", "src/main/resources", "src/test/kotlin", "src/test/resources")
		for (subproject in subprojects) {
			for (dir in dirs) {
				createDir("${subproject.projectDir}/$dir")
			}
		}
	}
}
