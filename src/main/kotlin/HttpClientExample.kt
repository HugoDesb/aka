import java.io.IOException
import java.net.URI
import java.net.http.*
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class HttpClientExample {

    companion object {
        fun callServer(): String {
            val client = HttpClient.newBuilder().build()
            val request = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create("http://localhost:8082"))
                .build()
            return try {
                val response = client.send(request, BodyHandlers.ofString())
                if (response.statusCode() == 200) {
                    response.body();
                } else {
                    response.statusCode().toString()
                }
            } catch (e: IOException) {
                throw RuntimeException(e.message);
            }

        }
    }
}