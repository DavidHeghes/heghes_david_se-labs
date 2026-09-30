subprojects {
    apply(plugin = "application")

    extensions.configure<JavaPluginExtension> {
        toolchain.languageVersion.set(JavaLanguageVersion.of(21))
    }

    // lab_01 -> lab01.Main
    extensions.configure<JavaApplication> {
        mainClass.set("${project.name.replace("_", "")}.Main")
    }
}
