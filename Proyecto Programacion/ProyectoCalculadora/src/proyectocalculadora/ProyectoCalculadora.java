package ProyectoCalculadora;
import java.util.Scanner;

import java.util.Scanner;

import java.util.Scanner;

public class ProyectoCalculadora {
    // Variables globales
    static int num1, num2;
    static double resultado = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        while (true) {
            // Menu de opciones
            mostrarMenu();

            // Leer opcion
            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("Has salido del menu.");
                break; // Salir del bucle si la opcion es 0
            }

            // Leer numeros solo cuando sea necesario
            if (option != 5) pedirNumeros(scanner);

            // Ejecutar operacion basada en la opcion seleccionada
            switch(option) {
                case 1: realizarSuma(); break;
                case 2: realizarResta(); break;
                case 3: realizarMultiplicar(); break;
                case 4: realizarDivision(); break;
                case 5: realizarRaizCuadrada(); break;
                case 6: mcd(); break;
                case 7: mcm(); break;
                case 8: calcularLogaritmoNatural(); break; 
                case 9: calcularAreaTriangulo(); break;
                case 10: calcularAreaCirculo(); break;
                case 11: calcularAreaRectangulo(); break;
                default: System.out.println("opcion no valida.");
            }

            // Mostrar resultado de la operacion
            if (option != 6 && option != 7) {  // No mostrar resultado si es MCD o MCM, que no usan resultado
                System.out.println("El resultado es: " + resultado);
            }
        }
    }

    // Mostrar el menu
    private static void mostrarMenu() {
        System.out.println("================================================");
        System.out.println("               CALCULADORA AVANZADA             ");
        System.out.println("================================================");
        
        System.out.println("\n[OPERACIONES BASICAS]");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");
        
        System.out.println("\n[OPERACIONES INTERMEDIAS]");
        System.out.println("5. Raiz Cuadrada");
        System.out.println("6. MCD");
        System.out.println("7. MCM");
        
        System.out.println("\n[OPERACIONES AVANZADAS]");
        System.out.println("8. Logaritmo Natural");
        System.out.println("9. Calculo area Triangulo");
        System.out.println("10. Calculo area Circulo");
        System.out.println("================================================");
        System.out.println("Introduzca numero de operacion a realizar "
                + "o introduzca 0 para salir:");

    }

    // Funcion para pedir dos numeros
    private static void pedirNumeros(Scanner scanner) {
        System.out.print("Introduzca el primer numero: ");
        num1 = scanner.nextInt();
        System.out.print("Introduzca el segundo numero: ");
        num2 = scanner.nextInt();
    }

    // Funcion para pedir un solo numero (para raiz cuadrada, logaritmo, etc.)
    private static void pedirUnNumero(Scanner scanner) {
        System.out.print("Introduzca un numero: ");
        num1 = scanner.nextInt();
    }

    // Realizar la suma
    private static void realizarSuma() {
        resultado = num1 + num2;
    }

    // Realizar la resta
    private static void realizarResta() {
        resultado = num1 - num2;
    }

    // Realizar la multiplicacion
    private static void realizarMultiplicar() {
        resultado = num1 * num2;
    }

    // Realizar la division
    private static void realizarDivision() {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            resultado = 0;
        } else {
            resultado = (double) num1 / num2;
            System.out.println("El resto de la operacion es: " + (num1 % num2));
        }
    }

    // Calcular la raiz cuadrada
    private static void realizarRaizCuadrada() {
        pedirUnNumero(new Scanner(System.in));  // Pedir solo un numero
        resultado = Math.sqrt(num1);
    }

    // Calcular MCD
    private static void mcd() {
        int a = num1, b = num2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        resultado = a;  // El MCD es el ultimo valor de a
        System.out.println("El MCD es: " + resultado);
    }

    // Calcular MCM
    private static void mcm() {
        resultado = (num1 * num2) / calcularMCDValue(num1, num2);
        System.out.println("El MCM es: " + resultado);
    }

    // Funcion auxiliar para calcular el MCD
    private static int calcularMCDValue(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    // Calcular logaritmo natural (opcional, puedes añadirlo segun necesidad)
    private static void calcularLogaritmoNatural() {
        pedirUnNumero(new Scanner(System.in));  // Pedir solo un numero
        if (num1 <= 0) {
            System.out.println("El numero debe ser mayor que cero para "
                    + "calcular el logaritmo natural.");
            resultado = 0;
        } else {
            resultado = Math.log(num1);
        }
    }

    // Calcular el area de un triangulo
    private static void calcularAreaTriangulo() {
        resultado = (num1 * num2) / 2.0;
    }

    // Calcular el area de un circulo
    private static void calcularAreaCirculo() {
        resultado = Math.PI * num1 * num1;
    }

    // Calcular el area de un rectangulo
    private static void calcularAreaRectangulo() {
        resultado = num1 * num2;
    }

    
    
    
    
    
    }
