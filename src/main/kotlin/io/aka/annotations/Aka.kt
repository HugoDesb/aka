package io.aka.annotations

import io.aka.annotations.http.Get
import io.aka.app.AppContext
import io.aka.app.EndPoint
import io.github.classgraph.*
import kotlin.reflect.full.declaredMemberProperties


/**
 * Annotate the main app entrypoint with it
 * The annotated class should be at the root of the project
 */
@Target(AnnotationTarget.CLASS)
annotation class Aka(
    /**
     * The port you want the web server to listen to
     */
    val port: Int = 8080
)

class AkaApp {

    private val scanResult = ClassGraph()
        .enableAllInfo() // Scan classes, methods, fields, annotations
        .scan()

    fun start(){
        // find Aka annotation
        // Set it as the root
        // set port to server
        val ctx = getAppContext()

        // find controllers
        // among them find methods
        // set their handlers
        //
    }

    private fun getAppContext(): AppContext {
        val c: AppContext
        scanResult.use {
            c = findAkaApp(it)
            findEndpoints(c, it)
        }
        return c
    }

    private fun findAkaApp(scanResult: ScanResult): AppContext {
        val classes = scanResult.getClassesWithAnnotation(Aka::class.qualifiedName)
        if(classes.size != 1){
            throw NotImplementedError("There should be one and only one class annotated with AkaApp " +
                    "at the root of the project")
        }
        val cl = classes.first();
        val info = cl.annotationInfo.first()
        return AppContext(info.parameterValues.get("port").value.toString().toInt())

    }

    private fun findEndpoints(ctx: AppContext, scanResult: ScanResult){
        val c = findControllers(ctx, scanResult)
        c.forEach {
            println(it.name) // Controller
            it.methodInfo.forEach {
                println(it.name)
                it.annotationInfo.directOnly().forEach{
                    println(it.name)
                }
            }
        }
    }

    fun findControllers(ctx: AppContext, scanResult: ScanResult): ClassInfoList {
            val classes = scanResult.getClassesWithAnnotation(Controller::class.qualifiedName)
            return classes
    }


    private fun getAnnotationInfoExample(info: AnnotationInfo){
        // Get used properties
        info.parameterValues.forEach{
            println(it.name)
            println(it.value)
        }
    }

    private fun getClassFunctionsExample(){
        // Get class functions
        Aka::class.members.forEach{
            println(it.name)
        }
    }
    private fun getClassPropertiesExample(){
        // Get class properties
        Aka::class.declaredMemberProperties.forEach {
            println(it.name)
            println(it.returnType)
        }
    }



}
