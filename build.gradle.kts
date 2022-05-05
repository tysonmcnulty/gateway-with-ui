tasks.register("build") {
    dependsOn(gradle.includedBuild("gateway").task(":build"))
    dependsOn(gradle.includedBuild("ui").task(":build"))
}

tasks.register("run") {
    dependsOn(gradle.includedBuild("gateway").task(":bootRun"))
    dependsOn(gradle.includedBuild("ui").task(":serve"))
}
