package io.aka.annotations

@Target(AnnotationTarget.FUNCTION)
annotation class Patch(val route: String)