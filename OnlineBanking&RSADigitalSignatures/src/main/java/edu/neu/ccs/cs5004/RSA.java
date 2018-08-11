package edu.neu.ccs.cs5004;

import java.math.BigInteger;
import java.security.SecureRandom;

import edu.neu.ccs.cs5004.DS;
import edu.neu.ccs.cs5004.KeyPair.KeyPair;
import edu.neu.ccs.cs5004.KeyPair.PK;
import edu.neu.ccs.cs5004.KeyPair.SK;
import edu.neu.ccs.cs5004.Message;


public class RSA {
  private static final BigInteger ONE = BigInteger.ONE;
  private static final int numbits = 1024;


  public static KeyPair generateKeyPair() {
    SecureRandom rand = new SecureRandom();
    //Generate p and q
    BigInteger p = BigInteger.probablePrime(numbits, rand);
    BigInteger q = BigInteger.probablePrime(numbits, rand);

    BigInteger n = p.multiply(q);

    BigInteger p_minus_one = p.subtract(ONE);
    BigInteger q_minus_one = q.subtract(ONE);
    BigInteger phiN = p_minus_one.multiply(q_minus_one);

    //Calculate public exponent
    BigInteger e, d;
    do {
      e = BigInteger.probablePrime(numbits, rand);
    } while ((e.compareTo(ONE) == 1) && (e.compareTo(phiN) == -1) && (e.gcd(phiN).compareTo(ONE) != 0));
    //Calculate private exponent
    d = e.modInverse(phiN);
    //Set Keys
    KeyPair keyPair = new KeyPair(new SK(e,n),new PK(d,n));
    return keyPair;
  }

  public static BigInteger encrypt(Message msg,SK sk){
    return (BigInteger.valueOf(msg.getM())).modPow(sk.getA(), sk.getN());
  }


  public static boolean SignatureVerify(Message message, DS ds,PK publicKey){
    BigInteger m1 = BigInteger.valueOf(message.getM());
    BigInteger m2 = ds.getDs().modPow(publicKey.getB(), publicKey.getN());
    return m1.equals(m2);
  }

}
