package io.aka.annotations.http

@Target(AnnotationTarget.FUNCTION)
annotation class Connect(val route: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Delete(val route: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Get(val route: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Patch(val route: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Post(val route: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Put(val route: String = "")

@Target(AnnotationTarget.FUNCTION)
annotation class Trace(val route: String = "")