package udaff.edu.pe.util;

public class ClavePrueba {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EncriptarClave eClave = new EncriptarClave();
		System.out.println(eClave.encode("jhon"));
		//clave encriptado = nq3K+n/9ZJE=
		System.out.println(eClave.decode("OeGGmLHfhmM="));
	}

}
