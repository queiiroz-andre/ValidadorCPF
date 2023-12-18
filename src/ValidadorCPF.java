import java.util.Scanner;

public class ValidadorCPF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, insira o CPF (somente números): ");
        String cpf = scanner.nextLine();

        if (validarCPF(cpf)) {
            System.out.println("CPF válido!");
        } else {
            System.out.println("CPF inválido!");
        }

        scanner.close();
    }

    public static boolean validarCPF(String cpf) {
        // Remove caracteres especiais e espaços em branco
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verifica se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verifica se todos os dígitos são iguais (caso especial, mas não válido)
        boolean todosDigitosIguais = true;
        for (int i = 1; i < cpf.length(); i++) {
            if (cpf.charAt(i) != cpf.charAt(0)) {
                todosDigitosIguais = false;
                break;
            }
        }
        if (todosDigitosIguais) {
            return false;
        }

        // Calcula o primeiro dígito verificador
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (10 - i);
        }
        int primeiroDigito = 11 - (soma % 11);
        if (primeiroDigito > 9) {
            primeiroDigito = 0;
        }

        // Calcula o segundo dígito verificador
        soma = 0;
        for (int i = 0; i < 10; i++) {
            soma += Integer.parseInt(String.valueOf(cpf.charAt(i))) * (11 - i);
        }
        int segundoDigito = 11 - (soma % 11);
        if (segundoDigito > 9) {
            segundoDigito = 0;
        }

        // Verifica se os dígitos verificadores calculados são iguais aos informados no CPF
        return primeiroDigito == Integer.parseInt(String.valueOf(cpf.charAt(9)))
                && segundoDigito == Integer.parseInt(String.valueOf(cpf.charAt(10)));
    }
}
