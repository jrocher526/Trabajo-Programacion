package proyectocalculadora;

import java.util.Scanner;

/**
 * Clase principal del proyecto de la calculadora.
 * Esta clase proporciona un conjunto de operaciones matematicas basicas, intermedias y avanzadas.
 */
public class ProyectoCalculadora {

    // Variables globales
    /**
     * Primer numero ingresado por el usuario.
     */
    public static int num1;
    
    /**
     * Segundo numero ingresado por el usuario.
     */
    public static int num2;

    /**
     * Variable que almacena el resultado de las operaciones.
     */
    public static double resultado = 0;

    /**
     * Metodo principal que ejecuta la calculadora.
     * Muestra un menu, lee la opcion del usuario y ejecuta la operacion correspondiente.
     *
     * @param args Argumentos de la linea de comandos (no se usan en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Bucle principal de operaciones
        while (true) {
            // Mostrar el menu
            mostrarMenu();

            // Leer opcion del usuario
            int option = scanner.nextInt();
            
            // Salir del bucle si la opcion es 0
            if (option == 0) {
                System.out.println("Has salido del menu.");
                break; 
            }

            // Leer numeros solo cuando sea necesario
            if (option != 5 && option != 7 && option != 11) { // Si la opcion no es 5, 7 o 11, pedimos dos numeros
                pedirNumeros(scanner);
            } else {
                pedirUnNumero(scanner); // Si la opcion es 5, 7 o 11, solo pedimos un numero
            }

            // Ejecutar operacion segun la opcion seleccionada
            switch (option) {
                case 1 -> realizarSuma();
                case 2 -> realizarResta();
                case 3 -> realizarMultiplicar();
                case 4 -> realizarDivision();
                case 5 -> realizarRaizCuadrada();
                case 6 -> mcd();
                case 7 -> mcm();
                case 8 -> calcularAreaTriangulo();
                case 9 -> calcularAreaCirculo();
                case 10 -> calcularAreaRectangulo();
                case 11 -> calcularPrimo();
                default -> System.out.println("Opcion no valida.");
            }

            // Mostrar resultado de la operacion, excepto en el caso de MCD, MCM y primo
            if (option != 5 && option != 6 && option != 11) { 
                System.out.println("El resultado es: " + resultado); // Mostrar resultado
            }
        }
    }

    /**
     * Muestra el menu de opciones de la calculadora.
     * Informa al usuario sobre las operaciones disponibles.
     */
    public static void mostrarMenu() {
        System.out.println("================================================");
        System.out.println("               CALCULADORA AVANZADA             ");
        System.out.println("================================================");

        System.out.println("\n[OPERACIONES BASICAS]");
        System.out.println("1. Sumar");
        System.out.println("2. Restar");
        System.out.println("3. Multiplicar");
        System.out.println("4. Dividir");

        System.out.println("\n[OPERACIONES INTERMEDIAS]");
        System.out.println("5. Raiz Cuadrada");
        System.out.println("6. Minimo Comun Divisor");
        System.out.println("7. Minimo Comun Multiplo");

        System.out.println("\n[OPERACIONES AVANZADAS]");
        System.out.println("8. Calculo area Triangulo");
        System.out.println("9. Calculo area Circulo");
        System.out.println("10. Calculo area Rectangulo");
        System.out.println("11. Calcular si es primo");
        System.out.println("================================================");
        System.out.println("Introduzca numero de operacion a realizar "
                + "o introduzca 0 para salir:");
    }

    /**
     * Pide dos numeros al usuario.
     * Este metodo se utiliza cuando la operacion requiere dos numeros de entrada.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void pedirNumeros(Scanner scanner) {
        System.out.print("Introduzca el primer numero: ");
        num1 = scanner.nextInt();
        System.out.print("Introduzca el segundo numero: ");
        num2 = scanner.nextInt();
    }

    /**
     * Pide un solo numero al usuario.
     * Este metodo se utiliza cuando la operacion requiere solo un numero de entrada, 
     * como la raiz cuadrada o el calculo de numeros primos.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    public static void pedirUnNumero(Scanner scanner) {
        System.out.print("Introduzca un numero: ");
        num1 = scanner.nextInt();
    }

    /**
     * Realiza la suma de dos numeros.
     */
    public static void realizarSuma() {
        resultado = num1 + num2;
    }

    /**
     * Realiza la operacion de resta de dos numeros.
     */
    public static void realizarResta() {
        resultado = num1 - num2;
    }

    /**
     * Realiza la operacion de multiplicacion de dos numeros.
     */
    public static void realizarMultiplicar() {
        resultado = num1 * num2;
    }

    /**
     * Realiza la operacion de division de dos numeros.
     * Si el divisor es cero, muestra un mensaje de error.
     */
    public static void realizarDivision() {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            resultado = 0;
        } else {
            resultado = (double) num1 / num2;
            System.out.println("El resto de la operacion es: " + (num1 % num2));
        }
    }

    /**
     * Calcula la raiz cuadrada de un numero.
     */
    public static void realizarRaizCuadrada() {
        pedirUnNumero(new Scanner(System.in));  // Pedir solo un numero
        resultado = Math.sqrt(num1);
    }

    /**
     * Calcula el Maximo Comun Divisor (MCD) de dos numeros.
     * Utiliza el algoritmo de Euclides para calcular el MCD.
     */
    public static void mcd() {
        int a = num1, b = num2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        resultado = a;  // El MCD es el ultimo valor de a
        System.out.println("El MCD es: " + resultado);
    }

    /**
     * Calcula el Minimo Comun Multiplo (MCM) de dos numeros.
     */
    public static void mcm() {
        resultado = (num1 * num2) / calcularMCDValue(num1, num2);
        System.out.println("El MCM es: " + resultado);
    }

    /**
     * Utiliza el algoritmo de Euclides para calcular el MCD de dos numeros.
     *
     * @param num1 El primer numero.
     * @param num2 El segundo numero.
     * @return El MCD de los dos numeros.
     */
    public static int calcularMCDValue(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    /**
     * Calcula el area de un triangulo dado su base y altura.
     */
    public static void calcularAreaTriangulo() {
        resultado = (num1 * num2) / 2.0;
    }

    /**
     * Calcula el area de un circulo dado su radio.
     */
    public static void calcularAreaCirculo() {
        resultado = Math.PI * num1 * num1;
    }

    /**
     * Calcula el area de un rectangulo dado su base y altura.
     */
    public static void calcularAreaRectangulo() {
        resultado = num1 * num2;
    }

    /**
     * Comprueba si un numero es primo.
     * Un numero es primo si solo es divisible por 1 y por si mismo.
     *
     * @return `true` si el numero es primo, `false` en caso contrario.
     */
    public static boolean calcularPrimo() {
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
