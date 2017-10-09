package iurii.job.interview.crypto;

import java.security.PublicKey;
import java.security.Signature;

public class Crypto {

    /**
     * @return true is {@code signature} is a valid digital signature of {@code message} under the
     *         key {@code pubKey}. Internally, this uses RSA signature, but the student does not
     *         have to deal with any of the implementation details of the specific signature
     *         algorithm
     */
    public static boolean verifySignature(PublicKey pubKey, byte[] message, byte[] signature) {
        Signature sig;
        try {
            sig = Signature.getInstance("SHA256withRSA");
            sig.initVerify(pubKey);
            sig.update(message);
            return sig.verify(signature);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;

    }
}
