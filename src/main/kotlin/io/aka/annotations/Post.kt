package io.aka.annotations

@Target(AnnotationTarget.FUNCTION)
annotation class Post(val route: String)