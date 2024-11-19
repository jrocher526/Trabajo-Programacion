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
            // Menú de opciones
            mostrarMenu();

            // Leer opción
            int option = scanner.nextInt();

            if (option == 0) {
                System.out.println("Has salido del menu.");
                break; // Salir del bucle si la opción es 0
            }

            // Leer números solo cuando sea necesario
            if (option != 5) pedirNumeros(scanner);

            // Ejecutar operación basada en la opción seleccionada
            switch(option) {
                case 1: realizarSuma(); break;
                case 2: realizarResta(); break;
                case 3: realizarMultiplicar(); break;
                case 4: realizarDivision(); break;
                case 5: realizarRaizCuadrada(); break;
                case 6: mcd(); break;
                case 7: mcm(); break;
                case 8: calcularLogaritmoNatural(); break; // Este es opcional, puedes añadirlo
                case 9: calcularAreaTriangulo(); break;
                case 10: calcularAreaCirculo(); break;
                case 11: calcularAreaRectangulo(); break;
                default: System.out.println("Opción no válida.");
            }

            // Mostrar resultado de la operación
            if (option != 6 && option != 7) {  // No mostrar resultado si es MCD o MCM, que no usan resultado
                System.out.println("El resultado es: " + resultado);
            }
        }
    }

    // Mostrar el menú
    private static void mostrarMenu() {
        System.out.println("Calculadora Avanzada");
        System.out.println();
        System.out.println("Menú de selección: ");
        System.out.println("*__________________________________________*");
        System.out.println("|        Operaciones Básicas              |");
        System.out.println("*------------------------------------------*");
        System.out.println("| 1.Suma  2.Resta  3.Multiplicar 4.Dividir |");
        System.out.println("*------------------------------------------*");
        System.out.println("|        Operaciones Intermedias         |");
        System.out.println("*------------------------------------------*");
        System.out.println("| 5. Raiz Cuadrada  6. MCD  7. MCM        |");
        System.out.println("*------------------------------------------*");
        System.out.println("|        Operaciones Avanzadas           |");
        System.out.println("*------------------------------------------*");
        System.out.println("| 8. Log. Natural    9.Calc. Área Triángulo |");
        System.out.println("| 10. Calc. Área Círculo  11.Calc. Área Rectángulo |");
        System.out.println("*------------------------------------------*");
    }

    // Función para pedir dos números
    private static void pedirNumeros(Scanner scanner) {
        System.out.print("Introduzca el primer número: ");
        num1 = scanner.nextInt();
        System.out.print("Introduzca el segundo número: ");
        num2 = scanner.nextInt();
    }

    // Función para pedir un solo número (para raíz cuadrada, logaritmo, etc.)
    private static void pedirUnNumero(Scanner scanner) {
        System.out.print("Introduzca un número: ");
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

    // Realizar la multiplicación
    private static void realizarMultiplicar() {
        resultado = num1 * num2;
    }

    // Realizar la división
    private static void realizarDivision() {
        if (num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            resultado = 0;
        } else {
            resultado = (double) num1 / num2;
            System.out.println("El resto de la operación es: " + (num1 % num2));
        }
    }

    // Calcular la raíz cuadrada
    private static void realizarRaizCuadrada() {
        pedirUnNumero(new Scanner(System.in));  // Pedir solo un número
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
        resultado = a;  // El MCD es el último valor de a
        System.out.println("El MCD es: " + resultado);
    }

    // Calcular MCM
    private static void mcm() {
        resultado = (num1 * num2) / calcularMCDValue(num1, num2);
        System.out.println("El MCM es: " + resultado);
    }

    // Función auxiliar para calcular el MCD
    private static int calcularMCDValue(int num1, int num2) {
        while (num2 != 0) {
            int temp = num2;
            num2 = num1 % num2;
            num1 = temp;
        }
        return num1;
    }

    // Calcular logaritmo natural (opcional, puedes añadirlo según necesidad)
    private static void calcularLogaritmoNatural() {
        pedirUnNumero(new Scanner(System.in));  // Pedir solo un número
        if (num1 <= 0) {
            System.out.println("El número debe ser mayor que cero para calcular el logaritmo natural.");
            resultado = 0;
        } else {
            resultado = Math.log(num1);
        }
    }

    // Calcular el área de un triángulo
    private static void calcularAreaTriangulo() {
        resultado = (num1 * num2) / 2.0;
    }

    // Calcular el área de un círculo
    private static void calcularAreaCirculo() {
        resultado = Math.PI * num1 * num1;
    }

    // Calcular el área de un rectángulo
    private static void calcularAreaRectangulo() {
        resultado = num1 * num2;
    }
}
