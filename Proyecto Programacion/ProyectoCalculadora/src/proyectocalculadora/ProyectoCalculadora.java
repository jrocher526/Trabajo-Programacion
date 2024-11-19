package proyectocalculadora;

import java.util.Scanner;

public class ProyectoCalculadora {

    // Variables globales
    static int num1, num2;
    static double resultado = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        //Bucle 
        while (true) {
            // Menu de opciones
            mostrarMenu();

            // Leer opcion
            int option = scanner.nextInt();
            
            // Salir del bucle si la opcion es 0
            if (option == 0) {
                System.out.println("Has salido del menu.");
                break; 
            }

            // Leer numeros solo cuando sea necesario
            if (option != 5 && option != 8 && option != 12) { //Si la opcion no es 5, 8 o 12, pedimos dos numero
                pedirNumeros(scanner);
            } else {
                pedirUnNumero(scanner); //Si la opcion es 5, 8 o 12, solo pedimos un numero
            }
            // Ejecutar operacion basada en la opcion seleccionada
            switch (option) {
                case 1 -> realizarSuma();
                case 2 -> realizarResta();
                case 3 -> realizarMultiplicar();
                case 4 -> realizarDivision();
                case 5 -> realizarRaizCuadrada();
                case 6 -> mcd();
                case 7 -> mcm();
                case 8 -> calcularLogaritmoNatural();
                case 9 -> calcularAreaTriangulo();
                case 10 -> calcularAreaCirculo();
                case 11 -> calcularAreaRectangulo();
                case 12 -> calcularPrimo();
                default -> System.out.println("Opcion no valida.");
            }

            if (option != 6 && option != 7 && option != 12) { //No mostrara el reusultado de MCD, MCM y NumPrimo.
                System.out.println("El resultado es: " + resultado); // Mostrar resultado de la operacion
                
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
        System.out.println("11. Calculo area Rectangulo");
        System.out.println("12. Calcular si es primo");
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

    // Funcion para comprobar si un numero es primo
    private static boolean calcularPrimo() {
        boolean calcularPrimo = true;
        if (num1 < 2) {
            calcularPrimo = false;
        } else {
            for (int m = 2; m <= Math.sqrt(num1); m++) {
                if (num1 % m == 0) {
                    calcularPrimo = false;
                    break;
                }
            }
        }

        if (calcularPrimo) {
            System.out.println("El numero " + num1 + " es un numero primo.");
        } else {
            System.out.println("El numero " + num1 + " no es un numero primo.");
        }

        return calcularPrimo;
    }
}
