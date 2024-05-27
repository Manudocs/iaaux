package projetosjava;

public class Consult {
    public static String ConsultaCEP(String cep) {
        if (cep.matches("\\d{5}-\\d{3}")) {
            return "Endereço fictício para o CEP " + cep;
        } else {
            return null;
        }
    }
}
