```Kotlin
plugins {
    application
    kotlin("jvm") version "1.7.20"
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation(platform("org.bot4j:bot4j-bom:2.5.3"))
    implementation("com.github.bot4j:bot4j-core:2.5.3")
    implementation("com.github.bot4j:bot4j-telegram:2.5.3")
    implementation("com.github.kittinunf.result:result-kotlin:2.0.1")
    implementation("org.json:json:20220924")
    implementation("org.slf4j:slf4j-api:1.7.36")
    testImplementation("junit:junit:4.13.2")

    implementation("com.google.code.gson:gson:2.10")
}

application {
    mainClass.set("com.ewzf_create_a_automated_chatbot.CreateAutomatedChatbot")
}

sourceSets {
    main.kotlin.srcDirs("src/main/kotlin")
    test.kotlin.srcDirs("src/test/kotlin")
}

sourceCompatibility = "11"
targetCompatibility = "11"

tasks {
    withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
        kotlinOptions {
            jvmTarget = "11"
        }
    }
}

val botToken by project(string("BOT_TOKEN"))
val telegramBotId by project(string("TELEGRAM_BOT_ID"))
val log4jProperties by project(properties("LOG4J_PROPERTIES"))
val telegramChatId by project(long("TELEGRAM_CHAT_ID"))

buildscript {
    repositories {
        mavenCentral()
        maven("https://jitpack.io")
    }
}