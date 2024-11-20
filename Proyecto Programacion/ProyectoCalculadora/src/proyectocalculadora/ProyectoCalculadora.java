package proyectocalculadora;

import java.util.Scanner;

/**
 * Clase principal del proyecto de la calculadora.
 * Esta clase proporciona un conjunto de operaciones matemáticas básicas, intermedias y avanzadas.
 */
public class ProyectoCalculadora {

    // Variables globales
    static int num1, num2;
    static double resultado = 0;

    /**
     * Método principal que ejecuta la calculadora.
     * Muestra un menú, lee la opción del usuario y ejecuta la operación correspondiente.
     *
     * @param args Argumentos de la línea de comandos (no se usan en este caso).
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Bucle principal de operaciones
        while (true) {
            // Mostrar el menú
            mostrarMenu();

            // Leer opción del usuario
            int option = scanner.nextInt();
            
            // Salir del bucle si la opción es 0
            if (option == 0) {
                System.out.println("Has salido del menu.");
                break; 
            }

            // Leer números solo cuando sea necesario
            if (option != 5 && option != 7 && option != 11) { // Si la opción no es 5, 7 o 11, pedimos dos números
                pedirNumeros(scanner);
            } else {
                pedirUnNumero(scanner); // Si la opción es 5, 7 o 11, solo pedimos un número
            }

            // Ejecutar operación según la opción seleccionada
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
                default -> System.out.println("Opción no válida.");
            }

            // Mostrar resultado de la operación, excepto en el caso de MCD, MCM y primo
            if (option != 5 && option != 6 && option != 11) { 
                System.out.println("El resultado es: " + resultado); // Mostrar resultado
            }
        }
    }

    /**
     * Muestra el menú de opciones de la calculadora.
     * Informa al usuario sobre las operaciones disponibles.
     */
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
        System.out.println("8. Calculo area Triangulo");
        System.out.println("9. Calculo area Circulo");
        System.out.println("10. Calculo area Rectangulo");
        System.out.println("11. Calcular si es primo");
        System.out.println("================================================");
        System.out.println("Introduzca numero de operacion a realizar "
                + "o introduzca 0 para salir:");
    }

    /**
     * Pide dos números al usuario.
     * Este método se utiliza cuando la operación requiere dos números de entrada.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    private static void pedirNumeros(Scanner scanner) {
        System.out.print("Introduzca el primer número: ");
        num1 = scanner.nextInt();
        System.out.print("Introduzca el segundo número: ");
        num2 = scanner.nextInt();
    }

    /**
     * Pide un solo número al usuario.
     * Este método se utiliza cuando la operación requiere solo un número de entrada, 
     * como la raíz cuadrada o el cálculo de números primos.
     *
     * @param scanner El objeto Scanner utilizado para leer la entrada del usuario.
     */
    private static void pedirUnNumero(Scanner scanner) {
        System.out.print("Introduzca un número: ");
        num1 = scanner.nextInt();
    }

    /**
     * Realiza la operación de suma de dos números.
     */
    private static void realizarSuma() {
        resultado = num1 + num2;
    }

    /**
     * Realiza la operación de resta de dos números.
     */
    private static void realizarResta() {
        resultado = num1 - num2;
    }

    /**
     * Realiza la operación de multiplicación de dos números.
     */
    private static void realizarMultiplicar() {
        resultado = num1 * num2;
    }

    /**
     * Realiza la operación de división de dos números.
     * Si el divisor es cero, muestra un mensaje de error.
     */
    private static void realizarDivision() {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            resultado = 0;
        } else {
            resultado = (double) num1 / num2;
            System.out.println("El resto de la operación es: " + (num1 % num2));
        }
    }

    /**
     * Calcula la raíz cuadrada de un número.
     */
    private static void realizarRaizCuadrada() {
        pedirUnNumero(new Scanner(System.in));  // Pedir solo un número
        resultado = Math.sqrt(num1);
    }

    /**
     * Calcula el Máximo Común Divisor (MCD) de dos números.
     * Utiliza el algoritmo de Euclides para calcular el MCD.
     */
    private static void mcd() {
        int a = num1, b = num2;
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        resultado = a;  // El MCD es el último valor de a
        System.out.println("El MCD es: " + resultado);
    }

    /**
     * Calcula el Mínimo Común Múltiplo (MCM) de dos números.
     */
    private static void mcm() {
        resultado = (num1 * num2) / calcularMCDValue(num1, num2);
        System.out.println("El MCM es: " + resultado);
    }

    /**
     * Función auxiliar para calcular el MCD de dos números.
     * Utiliza el algoritmo de Euclides.
     *
     * @param num1 El primer número.
     * @param num2 El segundo número.
     * @return El MCD de los dos números.
     */
    private static int calcularMCDValue(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    /**
     * Calcula el área de un triángulo dado su base y altura.
     */
    private static void calcularAreaTriangulo() {
        resultado = (num1 * num2) / 2.0;
    }

    /**
     * Calcula el área de un círculo dado su radio.
     */
    private static void calcularAreaCirculo() {
        resultado = Math.PI * num1 * num1;
    }

    /**
     * Calcula el área de un rectángulo dado su base y altura.
     */
    private static void calcularAreaRectangulo() {
        resultado = num1 * num2;
    }

    /**
     * Comprueba si un número es primo.
     * Un número es primo si solo es divisible por 1 y por sí mismo.
     *
     * @return `true` si el número es primo, `false` en caso contrario.
     */
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
            System.out.println("El número " + num1 + " es un número primo.");
        } else {
            System.out.println("El número " + num1 + " no es un número primo.");
        }

        return calcularPrimo;
    }
}