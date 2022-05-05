import com.github.gradle.node.npm.task.NpmInstallTask
import com.github.gradle.node.npm.task.NpxTask

plugins {
	id("com.github.node-gradle.node") version "3.2.1"
}

tasks.register<NpxTask>("build") {
  dependsOn(tasks.withType<NpmInstallTask>())
  command.value("ng")
  args.value(listOf("build"))
  inputs.files("package.json", "package-lock.json", "angular.json", "tsconfig.json", "tsconfig.app.json")
  inputs.dir("src")
  inputs.dir(fileTree("node_modules").exclude(".cache"))
  outputs.dir("dist")
}

tasks.register<NpxTask>("serve") {
  dependsOn(tasks.withType<NpmInstallTask>())
  command.value("ng")
  args.value(listOf("serve"))
}
