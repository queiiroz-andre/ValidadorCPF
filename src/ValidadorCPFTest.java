import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorCPFTest {

    @Test
    public void testCPFValido() {
        assertTrue(ValidadorCPF.validarCPF("12345678909")); // CPF válido
        assertTrue(ValidadorCPF.validarCPF("529.982.247-25")); // CPF válido com caracteres especiais
    }

    @Test
    public void testCPFFormatoInvalido() {
        assertFalse(ValidadorCPF.validarCPF("1234567890")); // CPF com formato inválido
        assertFalse(ValidadorCPF.validarCPF("1234567890987654321")); // CPF com mais de 11 dígitos
        assertFalse(ValidadorCPF.validarCPF("12345ABCDE67")); // CPF com caracteres não numéricos
    }

    @Test
    public void testCPFInvalido() {
        assertFalse(ValidadorCPF.validarCPF("11111111111")); // CPF inválido
        assertFalse(ValidadorCPF.validarCPF("00000000000")); // CPF inválido
    }
}
