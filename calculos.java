package projetosjava;
public class calculos {
    private static final double DEDUCAO_DEPENDENTE = 189.59; // Valor da dedução por dependente

    public static double calculaIRRF(double salarioBruto, double descontoINSS, double descontosIRRF, int numeroDependentes) {
        double salarioBase = salarioBruto - descontoINSS - (numeroDependentes * DEDUCAO_DEPENDENTE);
        double irrf = 0.0;

        if (salarioBase <= 1903.98) {
            irrf = 0.0;
        } else if (salarioBase <= 2826.65) {
            irrf = (salarioBase * 0.075) - 142.80;
        } else if (salarioBase <= 3751.05) {
            irrf = (salarioBase * 0.15) - 354.80;
        } else if (salarioBase <= 4664.68) {
            irrf = (salarioBase * 0.225) - 636.13;
        } else {
            irrf = (salarioBase * 0.275) - 869.36;
        }

        return Math.max(irrf, 0); // Garantir que o IRRF não seja negativo
    }

    public static double calculaSalarioLiquido(double salarioBruto, double descontoINSS, double outrosDescontos, int numeroDependentes) {
        double irrf = calculaIRRF(salarioBruto, descontoINSS, numeroDependentes, numeroDependentes);
        return salarioBruto - descontoINSS - outrosDescontos - irrf;
    }

    public static void main(String[] args) {
        // Exemplos de uso
        double salarioBruto = 5000.00;
        double descontoINSS = 500.00;
        double outrosDescontos = 100.00;
        int numeroDependentes = 2;

        double irrf = calculaIRRF(salarioBruto, descontoINSS, numeroDependentes, numeroDependentes);
        double salarioLiquido = calculaSalarioLiquido(salarioBruto, descontoINSS, outrosDescontos, numeroDependentes);

        System.out.printf("IRRF: %.2f\n", irrf);
        System.out.printf("Salário Líquido: %.2f\n", salarioLiquido);
    }
}
