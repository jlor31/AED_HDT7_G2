import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/* Idea para la implementaciondel arbol obtenida del canal YT: 
 * Derek Banas en el video siguiente URL: https://www.youtube.com/watch?v=M6lYob8STMI
 * 
 * 	Se adapto el codigo para que sea generico y que funcione con la implementacion de
 *  ComparableAssociation, encontrada en el libro de texto del curso: "Java Structures" 
 *  del autor Duane A. Bailey y que tambien se encontraba en los recursos del curso en Canvas
 *  en el modulo "Arboles Binarios"
*/

/* HDT7 Grupo 2
 * Juan Lorthiois 18771
 * Carlos Martinez 19340
 */

public class Main {

	static BinnaryTree<String, ArrayList<String>> arbolIngles  = new BinnaryTree<>();
	static BinnaryTree<String, ArrayList<String>> arbolEspanol  = new BinnaryTree<>();
	static BinnaryTree<String, ArrayList<String>> arbolFrances  = new BinnaryTree<>();
	
	
	public static void AgregarPalabras(BinnaryTree<String, ArrayList<String>> arbol, int idiomaClave,  String ingles, String espanol, String frances) {
		
		ArrayList<String> nuevaData = new ArrayList<>();
		
		nuevaData.add(ingles.toLowerCase().replaceAll("\s+", ""));
		nuevaData.add(espanol.toLowerCase().replaceAll("\s+", "")); 
		nuevaData.add(frances.toLowerCase().replaceAll("\s+", ""));
		
		arbol.addNode(nuevaData.get(idiomaClave), nuevaData);
		
		
	}
	
	public static void leerDiccionario() {
		
		Scanner in2 = new Scanner(System.in);
		System.out.println(" ");
		System.out.println("	-------------------------- INICIALIZACION DEL DICCIONARIO ---------------------------");
		System.out.println(" ");
		System.out.println("	INGRESE LA DIRECCION URL DEL ARCHIVO DE TEXTO (Ej: C:\\Users\\fulanito\\diccionario.txt)");
		System.out.println(" ");
		System.out.print("	DIRECCION -> ");
		
		
		String dic;
		
			try {
				
				dic = in2.nextLine();
				
				BufferedReader reader = new BufferedReader(new FileReader(dic));
				
				String linea;
				
				while((linea = reader.readLine()) != null) {
					
					String[] datos = linea.split(",");
					
					AgregarPalabras(arbolIngles, 0, datos[0], datos[1], datos[2]);
					AgregarPalabras(arbolEspanol, 1, datos[0], datos[1], datos[2]);
					AgregarPalabras(arbolFrances, 2, datos[0], datos[1], datos[2]);
					
				}
				
				reader.close();
				
			} catch(IOException e) {
				
				System.out.println("HAY UN ERROR CON LA DIRECCCION DEL ARCHIVO O NO FUE POSIBLE LEERLO");
				leerDiccionario();
		}
			prompt();
		
	}
	
	
	public static void traducir_txt(BinnaryTree<String, ArrayList<String>> origen, int destino, ArrayList<String> texto){
		
		ArrayList<String> traduccion = texto;
		
		
		for (int i = 0; i < traduccion.size(); i ++) {
			
			
			
			if (origen.getNode(traduccion.get(i)) != null) {
				
				traduccion.set(i, origen.getNode(traduccion.get(i)).data.get(destino));
				
			} else {
				
				traduccion.set(i, "*" + traduccion.get(i) + "*");
			}
			
		}
		
		System.out.println(" ");
		System.out.println("	---------------------------------- TEXTO TRADUCIDO ----------------------------------");
		System.out.println(" ");
		
		
		
		for (int i = 0; i < traduccion.size(); i ++) {
			
			if(i  % 11 == 0) {
				
				System.out.println();
				System.out.print("		" + traduccion.get(i) + " ");
				
				
			} else {
				
				System.out.print(traduccion.get(i) +" ");
			}
			
			
		}
		
		System.out.println();
		prompt();
	}
	
	
	public static void traduccion() {
		Scanner in3 = new Scanner(System.in);
		Scanner in4 = new Scanner(System.in);
		Scanner in5 = new Scanner(System.in);
		
		ArrayList<String> texto = new ArrayList<>();
		
		int Id_origen = 0;
		int Id_llegada = 0;
		
		System.out.println(" ");
		System.out.println("	------------------------------------- TRADUCCION ------------------------------------");
		System.out.println(" ");
		System.out.println("	INGRESE LA DIRECCION URL DEL ARCHIVO DE TEXTO A TRADUCIR (Ej: C:\\Users\\fulanito\\texto.txt)");
		System.out.println(" ");
		System.out.print("	DIRECCION -> ");
		
		
		String txt;
		
			try {
				
				txt = in3.nextLine();
				
				BufferedReader reader = new BufferedReader(new FileReader(txt));
				
				String linea;
				
				while((linea = reader.readLine()) != null) {
					
					String[] datos = linea.split(" ");
					
					for(String i : datos) {
						
						String palabra = i.replaceAll("[,.]", "");
						
						texto.add(palabra.toLowerCase());
						
					}
					
					
				}
				
				reader.close();
				
			} catch(IOException e) {
				
				System.out.println("HAY UN ERROR CON LA DIRECCCION DEL ARCHIVO O NO FUE POSIBLE LEERLO");
				leerDiccionario();
		}
			
		System.out.println(" ");		
		System.out.println("	-------------------------------------- IDIOMA ORIGEN --------------------------------");
		System.out.println(" ");		
		System.out.println("		1. INGLES");
		System.out.println("		2. ESPANOL");
		System.out.println("		3. FRANCES");
		System.out.println(" ");		
		System.out.println("	-------------------------------------------------------------------------------------");
		System.out.println(" ");		
		System.out.print("		SELECCION -> ");
			
		int org; 	
		
		try {
			
			org = in4.nextInt();
			
			if (org < 1 || org > 3 ) { 
				
				System.out.println("LA SELECCION INGRESADA ES INVALIDA ");
				prompt();
				
			} else if (org == 1) {
				
				System.out.println(" ");
				Id_origen = 0;
				
			}
			
			if (org == 2) {
				
				Id_origen = 1;
				
			
			}
			
			if (org == 3) {
				
				Id_origen = 2;
				
			}
			
			
			
		} catch (java.util.InputMismatchException e) {
			
			System.out.println(" ");
			System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU");
			
			prompt();
		}
		
		System.out.println(" ");		
		System.out.println("	----------------------------------- IDIOMA DESTINO ----------------------------------");
		System.out.println(" ");		
		System.out.println("		1. PARA INGLES");
		System.out.println("		2. PARA ESPANOL");
		System.out.println("		3. PARA FRANCES");
		System.out.println(" ");		
		System.out.println("	-------------------------------------------------------------------------------------");
		System.out.println(" ");		
		System.out.print("		SELECCION -> ");
			
		int lleg; 	
		
		try {
			
			lleg = in5.nextInt();
			
			if (lleg < 1 || lleg > 3 ) { 
				
				System.out.println("LA SELECCION INGRESADA ES INVALIDA ");
				prompt();
				
			} else if (lleg == 1) {
				
				System.out.println(" ");
				Id_llegada = 0;
				
			}
			
			if (lleg == 2) {
				
				Id_llegada = 1;
				
			
			}
			
			if (lleg == 3) {
				
				Id_llegada = 2;
				
			}
			
			
			
		} catch (java.util.InputMismatchException e) {
			
			System.out.println(" ");
			System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU");
			
			prompt();
		}
		
		
		if (Id_origen == 0) {
		
			traducir_txt(arbolIngles, Id_llegada, texto );
		
		} else if (Id_origen == 1) {
			
			traducir_txt(arbolEspanol, Id_llegada, texto );
			
		} else if (Id_origen == 2) {
			
			traducir_txt(arbolFrances, Id_llegada, texto );
			
		}
			
			prompt();
	}
	
	
	public static void prompt() {
		
		Scanner in = new Scanner(System.in);
		
		
		System.out.println(" ");		
		System.out.println("	-------------------------------  DICCIONARIO TRADUCTOR ------------------------------");
		System.out.println(" ");		
		System.out.println("		1. PARA RECORRER EL DICCIONARIO (BST) EN ORDEN *INORDER*");
		System.out.println("		2. PARA TRADUCIR UN ARCHIVO");
		System.out.println("		3. PARA SALIR");
		System.out.println(" ");		
		System.out.println("	-------------------------------------------------------------------------------------");
		System.out.println(" ");		
		System.out.print("		SELECCION -> ");
		
		int seleccion; 
		
		try {
			
			seleccion = in.nextInt();
			
			if (seleccion < 1 || seleccion > 3 ) { 
				
				System.out.println("LA SELECCION INGRESADA ES INVALIDA ");
				prompt();
				
			} else if (seleccion == 1) {
				
				System.out.println(" ");
				arbolIngles.inOrderTraverseTree(arbolIngles.root);
				prompt();
			}
			
			if (seleccion == 2) {
				
				traduccion();
				prompt();
			
			}
			
			if (seleccion == 3) {
				
				System.out.println(" 		  ¡HASTA PRONTO!");
				System.exit(0);
			}
			
			
			
		} catch (java.util.InputMismatchException e) {
			
			System.out.println(" ");
			System.out.println("LA SELECCION INGRESADA ES INVALIDA - VOLVIENDO AL MENU");
			
			prompt();
		}
		
		
	}
	
	
	public static void main(String[] args) {
		
		leerDiccionario(); 
		
		
		
		
		
		
	}

}
