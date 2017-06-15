
public class Uso {

	public static void main(String[] args) {

		String texto = "esto es una prueba para ver si funciona";
		
		Transformar t = new Transformar();
		
		System.out.println(t.desencriptar(t.encriptar(texto, "222"), "222"));				

	}

}
