import java.util.Scanner;

public class ValidadorCPF {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Por favor, insira o CPF (Apenas números): ");
        String cpf = scanner.nextLine();

        if (validarCPF(cpf)) {
            String estado = obterEstado(cpf);
            System.out.println("CPF válido!");
            System.out.println("Estado associado ao CPF: " + estado);
        } else {
            System.out.println("CPF inválido!");
        }

        scanner.close();
    }

    public static boolean validarCPF(String cpf) {
        // Implementação da validação do CPF
        // (Seu código atual permanece aqui)
        // Retorno temporário de 'true' para fins de exemplo
        return true;
    }

    public static String obterEstado(String cpf) {
        // Obtém os dois primeiros dígitos do CPF
        int doisPrimeirosDigitos = Integer.parseInt(cpf.substring(0, 2));

        String estado = "";

        // Lógica para determinar o estado com base nos primeiros dígitos do CPF
        if (doisPrimeirosDigitos == 30 || doisPrimeirosDigitos == 31 || doisPrimeirosDigitos == 32 || doisPrimeirosDigitos == 33 || doisPrimeirosDigitos == 34 || doisPrimeirosDigitos == 35) {
            estado = "Região Sudeste (ES, RJ, MG, SP)";
        } else if ((doisPrimeirosDigitos >= 20 && doisPrimeirosDigitos <= 29) || cpf.charAt(0) == '2') {
            estado = "Região Nordeste (MA, PI, CE, RN, PB, PE, AL, SE, BA)";
        } else if ((doisPrimeirosDigitos >= 40 && doisPrimeirosDigitos <= 48) || cpf.charAt(0) == '4') {
            estado = "Região Sul (PR, SC, RS)";
        } else if ((doisPrimeirosDigitos >= 50 && doisPrimeirosDigitos <= 59) || cpf.charAt(0) == '5') {
            estado = "Região Centro-Oeste (MS, MT, GO)";
        } else if ((doisPrimeirosDigitos >= 60 && doisPrimeirosDigitos <= 67) || cpf.charAt(0) == '6') {
            estado = "Região Norte (PA)";
        }  else if ((doisPrimeirosDigitos >= 10 && doisPrimeirosDigitos <= 17) || cpf.charAt(0) == '3') {
            estado = "Região Norte (AM, RR, AP, PA, TO, RO, AC)";
        }  else {
            estado = "Estado não identificado";
        }

        return estado;
    }




}
