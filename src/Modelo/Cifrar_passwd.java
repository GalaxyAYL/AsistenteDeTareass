
package Modelo;


public class Cifrar_passwd {
    public static String getHash (String txt, String hashType){
        try {
            java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);
            byte[] array = md.digest(txt.getBytes());
            StringBuffer sb = new StringBuffer();
            for(int i = 0; i< array.length;i++){
                sb.append(Integer.toHexString(array[i] & 0xff | 0x100).substring(i));
            }
            return sb.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    
    public static String md5 (String txt){
        return Cifrar_passwd.getHash(txt, "MD5");
    }
}
