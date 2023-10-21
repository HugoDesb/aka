package io.aka.configuration

import java.util.Properties

private const val AKA_CONFIG = "aka.properties"
object PropertiesReader {

    private val properties = Properties()

    init {
        val file = this::class.java.classLoader.getResourceAsStream(AKA_CONFIG)
        properties.load(file)
    }

    fun getProperty(key: String) = properties.getProperty(key)
}