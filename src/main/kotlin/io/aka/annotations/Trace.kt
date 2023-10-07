package io.aka.annotations

@Target(AnnotationTarget.FUNCTION)
annotation class Trace(val route: String)