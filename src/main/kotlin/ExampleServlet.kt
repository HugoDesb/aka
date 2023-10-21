import jakarta.servlet.http.HttpServlet
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse

class ExampleServlet:HttpServlet(){

    private val serialVersionId: Long = 1

    override fun doGet(req: HttpServletRequest?, resp: HttpServletResponse?) {
        resp!!.contentType = "application/json"
        resp.status = HttpServletResponse.SC_OK
        resp.writer.println("{ \"status\": \"ok\"}")
    }
}