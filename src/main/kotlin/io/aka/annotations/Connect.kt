package io.aka.annotations

@Target(AnnotationTarget.FUNCTION)
annotation class Connect(val route: String)