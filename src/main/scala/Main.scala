import java.security.Security

import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec
import org.bouncycastle.jce.provider.BouncyCastleProvider

object Main {
  val PROVIDER: String = "BC"
  val ALGORITHM: String = "HmacSHA256"
  val CHARSET: String = "UTF-8"

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
