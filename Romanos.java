package romanos;

public class Romanos {

	static char[] letras =  {'I','V','X','L','C','D','M'};
	static int[] valores =  { 1,  5, 10, 50, 100,500,1000};
	
	public static void main(String[] args) {
		String roman = "XC";
		int solution = solution(roman);
		System.out.println("Decimal "+solution);

	}
	public static int solution(String roman) {
		int cantidadRestar = 0;
		int cantidadSumar = 0;
		for(int i = 0; i < roman.length(); i++) {
			char c = roman.charAt(i); //Caracter actual
			int valor = getValor(c);
			
			//Recorre el resto de caracteres
			//Para comparar si hay un caracter mayor, para restar el caracter actual en lugar de sumar
			boolean restar = false; //Si es el mas pequeño de los que quedan 
			for(int j = i+1; j < roman.length(); j++ ) {
				char c2 = roman.charAt(j); //Resto de la cadena
				int vc2 = getValor(c2);
				if(valor < vc2)
					restar = true;
			}
			if(restar)
				cantidadRestar += valor * 2; 
			cantidadSumar += valor;
			
		}
		System.out.println("Cantidad a Sumar"+ cantidadSumar);
		System.out.println("Cantidad a Sumar"+ cantidadRestar);
		int solution = cantidadSumar - cantidadRestar;
		return solution;
	}
	public static int getValor(char c) {
		for(int i = 0 ; i < letras.length; i++) {
			if(c == letras[i])
				return valores[i];
		}
		return -1;
	}

}
