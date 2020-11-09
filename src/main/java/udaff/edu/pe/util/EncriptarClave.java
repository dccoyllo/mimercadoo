package udaff.edu.pe.util;

import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class EncriptarClave {
	String clavePrivada = "david";

	public String encode(String cadena) {
		String encriptacion = "";
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] llavePass = md5.digest(clavePrivada.getBytes("utf-8"));
			byte[] BytesKey = Arrays.copyOf(llavePass, 24);
			SecretKey llave = new SecretKeySpec(BytesKey, "DESede");
			Cipher cifrado = Cipher.getInstance("DESede");
			cifrado.init(Cipher.ENCRYPT_MODE, llave);

			byte[] plain = cadena.getBytes("utf-8");
			byte[] buffer = cifrado.doFinal(plain);
			byte[] base64 = Base64.getEncoder().encode(buffer);
			encriptacion = new String(base64);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return encriptacion;
	}

	public String decode(String cadena) {
		String descriptacion = "";
		try {
			byte[] message = Base64.getDecoder().decode(cadena.getBytes("utf-8"));
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] digest = md5.digest(clavePrivada.getBytes("utf-8"));
			byte[] keyBytes = Arrays.copyOf(digest, 24);
			SecretKey key = new SecretKeySpec(keyBytes, "DESede");
			Cipher deci = Cipher.getInstance("DESede");
			deci.init(Cipher.DECRYPT_MODE, key);
			byte[] plain = deci.doFinal(message);
			descriptacion = new String(plain, "utf-8");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		return descriptacion;
	}
}
