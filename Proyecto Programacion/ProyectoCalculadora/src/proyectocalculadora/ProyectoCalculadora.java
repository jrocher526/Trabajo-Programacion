package ProyectoCalculadora;
import java.util.Scanner;

public class ProyectoCalculadora {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1, num2, option;
        double resultado = 0;
        
        do {
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

            option = scanner.nextInt();

            switch(option) {
                case 1:
                    resultado = realizarSuma(scanner);
                    break;
                case 2:
                    resultado = realizarResta(scanner);
                    break;
                case 3:
                    resultado = realizarMultiplicar(scanner);
                    break;
                case 4:
                    resultado = realizarDivision(scanner);
                    break;
                case 5:
                    resultado = realizarRaizCuadrada(scanner);
                    break;
                case 6:
                    mcd(scanner);
                    break;
                case 7:
                    mcm(scanner);
                    break;
                case 8:
                    resultado = calcularAreaCirculo(scanner);
                    break;
                case 9:
                    resultado = calcularAreaTriangulo(scanner);
                    break;
                case 10:
                    resultado = calcularAreaRctgl(scanner);
                    break;
                case 11:
                    calcularPrimo (scanner);
                    break;
                default:
                    System.out.println("Opción no válida.");
                    resultado = 0;
            }
            if(option != 11){
                System.out.println("El resultado es: " + resultado);
            }
        } while(option != 0);

        System.out.println("Has salido del menu.");
        scanner.close();
    }

    public static double realizarSuma(Scanner scanner) {
        int num;
        double suma = 0;
        do {
            System.out.println("Introduzca un número, introduzca 0 para ver el resultado: ");
            num = scanner.nextInt();
            suma += num;
        } while(num != 0);
        return suma;
    }

    public static double realizarResta(Scanner scanner) {
        int num;
        double resta = 0;
        do {
            System.out.println("Introduzca un número, introduzca 0 para ver el resultado: ");
            num = scanner.nextInt();
            resta -= num;
        } while(num != 0);
        return resta;
    }

    public static double realizarMultiplicar(Scanner scanner) {
        int num;
        double resultadoMultiplicar = 1;
        do {
            System.out.println("Introduzca un número, introduzca 0 para ver el resultado: ");
            num = scanner.nextInt();
            if(num != 0) {
                resultadoMultiplicar *= num;
            }
        } while(num != 0);
        return resultadoMultiplicar;
    }

    public static double realizarDivision(Scanner scanner) {
        int num1, num2;
        System.out.println("Introduzca el primer número: ");
        num1 = scanner.nextInt();
        System.out.println("Introduzca el segundo número: ");
        num2 = scanner.nextInt();
        if(num2 == 0) {
            System.out.println("Error: No se puede dividir por cero.");
            return 0;
        }
        double resultadoDividir = (double) num1 / num2;
        System.out.println("El resto de la operación es: " + (num1 % num2));
        return resultadoDividir;
    }

    public static double realizarRaizCuadrada(Scanner scanner) {
        System.out.println("Introduzca un número: ");
        int num = scanner.nextInt();
        return Math.sqrt(num);
    }

    public static void mcd(Scanner scanner) {
        int num1, num2;
        System.out.println("Introduzca el primer número: ");
        num1 = scanner.nextInt();
        System.out.println("Introduzca el segundo número: ");
        num2 = scanner.nextInt();

        while(num2 != 0) {
            if(num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        System.out.println("El MCD es: " + num1);
    }

    public static void mcm(Scanner scanner) {
        int num1, num2;
        System.out.println("Introduzca el primer número: ");
        num1 = scanner.nextInt();
        System.out.println("Introduzca el segundo número: ");
        num2 = scanner.nextInt();
        int mcm = (num1 * num2) / calcularMCDValue(num1, num2);
        System.out.println("El MCM es: " + mcm);
    }

    public static int calcularMCDValue(int num1, int num2) {
        while(num2 != 0) {
            if(num1 > num2) {
                num1 -= num2;
            } else {
                num2 -= num1;
            }
        }
        return num1;
    }

    public static double calcularAreaCirculo(Scanner scanner) {
        System.out.println("Introduzca el radio del círculo: ");
        double radio = scanner.nextDouble();
        return Math.PI * radio * radio;
    }

    public static double calcularAreaTriangulo(Scanner scanner) {
        System.out.println("Introduzca la base del triángulo: ");
        double base = scanner.nextDouble();
        System.out.println("Introduzca la altura del triángulo: ");
        double altura = scanner.nextDouble();
        return (base * altura) / 2;
    }

    public static double calcularAreaRctgl(Scanner scanner) {
        System.out.println("Introduzca la base del rectángulo: ");
        double base = scanner.nextDouble();
        System.out.println("Introduzca la altura del rectángulo: ");
        double altura = scanner.nextDouble();
        return base * altura;
    }
    public static boolean calcularPrimo(Scanner scanner) {
        boolean esPrimo = true;

        System.out.println("Dime un número: ");
        int num = scanner.nextInt();
        
        if (num < 2) {
            esPrimo = false; 
        } else {
            for (int m = 2; m <= Math.sqrt(num); m++) {
                if (num % m == 0) {
                    esPrimo = false; 
                    break;
                }
            }
        }

        if (esPrimo) {
            System.out.println("El número " + num + " es un número primo.");
        } else {
            System.out.println("El número " + num + " no es un número primo.");
        }

        return esPrimo;
    }
}