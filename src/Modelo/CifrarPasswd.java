package Modelo;

import java.security.MessageDigest;

public class CifrarPasswd {
    public static String getHash(String txt, String hashType) {
        try {
            MessageDigest md = MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : array) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String sha256(String txt) {
        return CifrarPasswd.getHash(txt, "SHA-256");
    }
}