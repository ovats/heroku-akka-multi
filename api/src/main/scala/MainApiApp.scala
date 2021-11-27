import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.StatusCodes
import akka.http.scaladsl.server.Directives._
import com.typesafe.scalalogging.LazyLogging

import scala.util.{Failure, Properties, Success}

object MainApiApp extends LazyLogging {

  def main(args: Array[String]): Unit = {
    logger.info("Starting ...")

    implicit val system = ActorSystem()
    import system.dispatcher

    val routes = get {
      logger.info("GET /")
      complete(StatusCodes.OK, "This is a rest api with akka http deployed in heroku")
    }

    val host: String = "0.0.0.0"
    val port: Int    = Properties.envOrElse("PORT", "8080").toInt

    Http()
      .newServerAt(host, port)
      .bind(routes)
      .onComplete {
        case Success(_) => logger.info(s"Started at port $port")
        case Failure(e) => logger.error("Failed to start", e)
      }
  }

}
