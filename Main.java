import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Proyecto I");
        System.out.println("\nHola, bienvenido (a). Por favor, selecciona la opción que desees:");

        while (true) {
            System.out.println("\n1. Ordenar tres cadenas diferentes entre sí alfabéticamente.");
            System.out.println("2. Ordenar tres cadenas (pueden ser iguales) alfabéticamente.");
            System.out.println("3. Salir");

            System.out.print("---> ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            if (opcion == 1) {
                System.out.print("Las cadenas deben de ser diferentes entre sí, recuerda que deben de ser solo letras");
                String[] cadenas = ingresarCadenas(scanner, true);
                if (cadenas != null) {
                    Arrays.sort(cadenas);
                    System.out.println("Cadenas ordenadas: " + Arrays.toString(cadenas));
                }
            } else if (opcion == 2) {
                System.out.print("Las cadenas pueden ser iguales entre sí, recuerda que deben de ser solo letras");
                String[] cadenas = ingresarCadenas(scanner, false);
                if (cadenas != null) {
                    Arrays.sort(cadenas);
                    System.out.println("Cadenas ordenadas: " + Arrays.toString(cadenas));
                }
            } else if (opcion == 3) {
                System.out.println("Terminando el programa...");
                break;
            } else {
                System.out.println("Opción no válida. Por favor intenta de nuevo.");
            }
        }
    }

    public static String[] ingresarCadenas(Scanner scanner, boolean diferentes) {
        System.out.println("\nIngresa tres cadenas separadas por coma (,): ");
        System.out.print("---> ");
        String input = scanner.nextLine();
        String[] cadenas = input.split(",");

        for (int i = 0; i < cadenas.length; i++) {

            cadenas[i] = cadenas[i].trim();
        }

        if (cadenas.length != 3) {
            System.out.println("No ingresaste exactamente tres cadenas. Intenta de nuevo.");
            return null;
        }

        for (String cadena : cadenas) {
            if (!cadena.matches("[a-zA-Z ]+")) {
                System.out.println(
                        "Una o más cadenas contienen caracteres no permitidos. Solo se permiten letras y espacios. Intenta de nuevo.");
                return null;
            }
        }

        if (diferentes) {
            Set<String> set = new HashSet<>(Arrays.asList(cadenas));
            if (set.size() != 3) {
                System.out.println("Las cadenas deben ser diferentes entre sí. Intenta de nuevo.");
                return null;
            }
        }

        return cadenas;
    }
}
