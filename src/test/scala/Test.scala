import pdi.jwt.{Jwt, JwtAlgorithm}

object Test {
  def main(args: Array[String]): Unit = {
    val jwt = Jwt.encode("{}", "secret", JwtAlgorithm.HS256)
    println(jwt)
  }
}
