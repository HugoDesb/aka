import io.aka.annotations.AkaApp
import org.eclipse.jetty.server.Server
import org.eclipse.jetty.servlet.ServletHandler


fun main(args: Array<String>) {
    startExampleServer(args)
}

fun startExampleServer(args: Array<String>){
    println("Hello World!")

    val a = AkaApp()
    a.start()

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")


    val server = Server(8080)
    val handler = ServletHandler()

    server.handler = handler;
    handler.addServletWithMapping(ExampleServlet::class.java, "/*")

    server.start()
    server.join()
}