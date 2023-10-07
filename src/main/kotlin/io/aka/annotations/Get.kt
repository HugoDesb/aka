package io.aka.annotations

@Target(AnnotationTarget.FUNCTION)
annotation class Get(val route: String)