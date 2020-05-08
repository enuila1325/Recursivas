package recursivas1;

import java.util.Scanner;
import java.util.Random;

public class Recursivas1 {

    static Scanner leer = new Scanner(System.in);
    static Random r = new Random();

    public static void main(String[] args) {
        char resp = 's';
        while (resp == 's' || resp == 'S') {
            System.out.println("1. Suma recursiva");
            System.out.println("2. Factorial");
            System.out.println("3. Potencia");
            System.out.println("4. Rellenar/Recorrer arreglo");
            System.out.println("5. Busqueda recursiva");
            System.out.println("6. Invertir numero");
            System.out.println("7. Invertir palabra");
            int opc = leer.nextInt();
            switch (opc) {
                case 1:
                    System.out.println("Ingrese hasta que numero se sumara");
                    int num = leer.nextInt();
                    int suma = sumaRecursiva(num);
                    System.out.println("El resultado es: " + suma);
                    break;
                case 2:
                    System.out.println("Ingrese la base al factorial");
                    int N = leer.nextInt();
                    while (N < 0) {
                        System.out.println("Ingrese un numero positivo entero mayor o igual que 0");
                        N = leer.nextInt();
                    }
                    int fact = factorialRecursivo(N);
                    System.out.println("El factoria de " + N + " es: " + fact);
                    break;
                case 3:
                    System.out.println("Ingrese la base a elevar");
                    int base = leer.nextInt();
                    System.out.println("Ingrese la potencia");
                    int pot = leer.nextInt();
                    while (pot < 0) {
                        System.out.println("Ingrese una potencia postiva");
                        pot = leer.nextInt();
                    }
                    int res = potenciaRecursiva(base, pot);
                    System.out.println(base + "^" + pot + "es: " + res);
                    break;
                case 4:
                    System.out.println("Ingrese el tamaño del arreglo");
                    int tam = leer.nextInt();
                    int[] a = new int[tam];
                    imprimirArrayRecursivo(a, 0);
                    break;
                case 5:
                    System.out.println("Ingrese el tamaño del arreglo");
                    tam = leer.nextInt();
                    int[] b = new int[tam];
                    imprimirArrayRecursivo(b, 0);
                    System.out.println("Ingrese el numero a buscar en el arreglo");
                    int buscar = leer.nextInt();
                    while (buscar < 0 || buscar > 15) {
                        System.out.println("EL ARREGLO SOLO CONTIENE NUMEROS DEL 1 AL 15. Intente de nuevo");
                        buscar = leer.nextInt();
                    }
                    System.out.println("El numero esta en la posicion: " + (busquedaRecursiva(b, 0, buscar) + 1));
                    break;
                case 6:
                    System.out.println("Ingrese un numero");
                    String n = leer.next();
                    int lon = n.length();
                    int numero = Integer.parseInt(n);
                    int invertido = invertirNum(numero, lon-1);
                    System.out.println("El numero invertido es: "+ invertido);
                    break;
                default:
                    break;

            }
        }

    }

    public static int sumaRecursiva(int n) {
        int res = 0;

        if (n == 1) {
            return 1;
        } else {
            res = n + sumaRecursiva(n - 1);
        }

        return res;
    }

    public static int factorialRecursivo(int n) {
        int fact;
        if (n == 0) {
            return 1;
        } else {
            fact = n * factorialRecursivo(n - 1);
        }
        return fact;
    }

    public static int potenciaRecursiva(int n, int m) {
        int pot;
        if (m == 1) {
            return 1;
        } else {
            pot = n * potenciaRecursiva(n, m - 1);
        }
        return pot;
    }

    public static void imprimirArrayRecursivo(int[] a, int indice) {
        if (indice < a.length) {
            a[indice] = 1 + r.nextInt(15);
            System.out.print("[" + a[indice] + "]");
            indice++;
            imprimirArrayRecursivo(a, indice);
        }
    }

    public static int busquedaRecursiva(int[] a, int indice, int elemento) {
        int pos;
        if (indice == a.length) {
            return -1;
        } else if (a[indice] == elemento) {
            return indice;
        } else {
            pos = busquedaRecursiva(a, indice + 1, elemento);
        }
        return pos;
    }

    public static int invertirNum(int num, int pos) {

        if (num < 10) {
            return num;
        } else {
            return (num % 10)*(int)Math.pow(10,pos)+(invertirNum(num/10,pos-1));
        }
    }

}
