package listadodeobjetos;
import java.util.Scanner;
import java.util.ArrayList;
import java.lang.NumberFormatException;
public class ListadoDeObjetos {

	static String conMat(Scanner e) {
		String matricula = "";
		String letras ="QWRTPLKJHGFDSZXCVBNM";
		
		boolean a = false;
		do {
			System.out.print("Matricula? ");
			matricula = e.nextLine();
			matricula = matricula.toUpperCase();
			if (matricula.length() == 7){
			a = true;
			try{
				Integer.parseInt(matricula.substring(0, 4));
			}catch(NumberFormatException nfe) {
				a = false;
			}
			for (int i = 0; i < 3; i++) {
			    boolean letraValida = false;
			    for (int d = 0; d < letras.length(); d++) {
			        if (matricula.charAt(4 + i) == letras.charAt(d)) {
			            letraValida = true;
			            break;
			        }
			    }
			    if (!letraValida) 
			        a = false; 
			}
			}
		}while(!a ||  matricula.length()!= 7);	
		return matricula;
	}
	static String conMar(Scanner e) {
		String marca ="";
		do {
			System.out.print("Introduce marca?");
			marca = e.nextLine();
		}while(marca.isEmpty()|| marca.length()>15);
		return marca;
	}
	
	static String conMod(Scanner e) {
		String modelo ="";
		do {
			System.out.print("Introduce modelo?");
			modelo = e.nextLine();
		}while(modelo.isEmpty()|| modelo.length()>10);
		return modelo;
	}
	
	static String conGam(Scanner e) {
		String gama="";
		boolean a;
		do {
			System.out.print("Introduce gama?");
			gama = e.nextLine().toUpperCase();
			
			a = true;
			
			if (gama.charAt(0)!= 'A' && gama.charAt(0) != 'M' && gama.charAt(0) != 'B')
				a = false;
			
		}while(!a);
		switch (gama.charAt(0)) {
		case 'A':
			gama="Alta";
			break;
		case 'M':
			gama="Media";
			break;
		case 'B':
			gama="Baja";
			break;
		};
		return gama;
	}
	static double conPre(Scanner e) {
		String precio ="";
		boolean a;
		do {
			System.out.print("Introduce precio?");
			precio = e.nextLine();
			a = true;
			try{
				Double.parseDouble(precio);
			}catch(NumberFormatException nfe) {
				a = false;
			}
		}while(!a);
		return Double.parseDouble(precio);
	}
	
	public static void altas(Scanner e, ArrayList<Coches> coches) {
		int seguir = 0;
		do {
		coches.add(new Coches(conMat(e),conMar(e),conMod(e),conGam(e),conPre(e)));
		System.out.println("Otro? 1 Si, 0 No");
		seguir = Integer.parseInt(e.nextLine());
		}while (seguir == 1);
		
	}
	
	
	public static int menu1(Scanner e) {
		String op = "";
		do {
			System.out.println("1.-Altas.");
			System.out.println("2.-Modificaciones.");
			System.out.println("3.-Consultas.");
			System.out.println("4.-Listado.");
			System.out.println("5.-Fin.");
			op= e.nextLine();
			
		}while(op.charAt(0) < '1' ||  op.charAt(0) > '5' );
		
		return Integer.parseInt(op);
	}
	
	static void visualizar(ArrayList<Coches> coches) {
		for (Coches coche: coches) 
		    System.out.println(coche);
	}
	static void modificar(Scanner e, ArrayList<Coches> coches) {
		boolean a;
		do {
		System.out.print("Qué vehículo desea modificar, por favor introduzca una ");
		String matricula= conMat(e);
		a = true;
		int i=0;
		for (Coches coche: coches) 
		    if (coche.getMatricula().equals(matricula)) {
		    	i = coches.indexOf(coche);
		    	coches.set(i, new Coches(matricula,conMar(e),conMod(e),conGam(e),conPre(e)));
		    }else
		    	a = false;
		if (!a)
			System.out.println("Esa matrícula no está en el sistema, por favor, introduzca otra.");
		}while(!a);

	}
	static void consultar(Scanner e, ArrayList<Coches> coches) {
		System.out.print("Matricula a consultar?");
		String matricula= conMat(e);
		int i=0;
		for (Coches coche: coches) 
		    if (coche.getMatricula().equals(matricula)) 
		    	i = coches.indexOf(coche); 
		
		System.out.print(coches.get(i));
	}
	public static void main(String args[]) {
		Scanner e = new Scanner(System.in);
		ArrayList<Coches> coches = new ArrayList<>();
		int op = 0;
		do {
		op = menu1(e);	
		switch (op) {
		case 1:
			altas(e,coches);
			break;
		case 2:
			modificar(e, coches);
			break;
		case 3:
			consultar(e,coches);
			break;
		case 4:
			visualizar(coches);
			break;
		case 5:
			System.out.println("Fin de programa!");
			break;
		}
		}while(op != 5);
		e.close();
	}
}
