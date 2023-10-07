package io.aka.annotations

/**
 * Annotate the main app entrypoint with it
 * The annotated class should be at the root of the project
 */
@Target(AnnotationTarget.CLASS)
annotation class Aka(
    val port: Int = 8080
)
