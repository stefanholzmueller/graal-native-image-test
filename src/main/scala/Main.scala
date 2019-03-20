import java.security.Security

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.bouncycastle.jce.provider.BouncyCastleProvider

object Main {
  val PROVIDER: String = "BC"
  val ALGORITHM: String = "HmacSHA256"
  val CHARSET: String = "UTF-8"

  Security.addProvider(new BouncyCastleProvider())
  try {
    // force JCE initialization - performs security check that is restricted to image creation but cached
    val mac = Mac.getInstance(ALGORITHM, PROVIDER)
    mac.init(new SecretKeySpec("secret".getBytes(CHARSET), ALGORITHM))
  } catch {
    case t: Throwable =>
      throw new ExceptionInInitializerError(t)
  }

  @throws[Exception]
  def main(args: Array[String]): Unit = {
    if (Security.getProvider(PROVIDER) == null)
      Security.addProvider(new BouncyCastleProvider)

    val mac = Mac.getInstance(ALGORITHM, PROVIDER)
    mac.init(new SecretKeySpec("secret".getBytes(CHARSET), ALGORITHM))
    val result = mac.doFinal("test".getBytes(CHARSET))

    System.out.println(new String(result, CHARSET))
  }

}
