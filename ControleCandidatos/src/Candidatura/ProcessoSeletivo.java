package Candidatura;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ProcessoSeletivo {
    public static void main(String[] args) throws Exception {
        String[] candidatos = { "PÂMELA", "PATRICK", "ÉRIKA", "RAFAELA", "AUGUSTO", "CAIO", "IGOR", "ANA FLÁVIA",
                "MARIANA", "JOÃO PEDRO" };

        selecaoCandidatos();
        imprimirSelecionados();

        for (String candidato : candidatos) {
            entrandoEmContato(candidato);
        }

    }

    // Método ligar
    static void entrandoEmContato(String candidato) {
        int tentativasRealizadas = 1;
        boolean continuarTentando = true;
        boolean atendeu = false;
        do {
            atendeu = atender();
            continuarTentando = !atendeu;
            if (continuarTentando) {
                tentativasRealizadas++;
            } else {
                System.out.println("CONTATO REALIZADO COM SUCESSO");
            }

        } while (continuarTentando && tentativasRealizadas < 3);

        if (atendeu) {
            System.out.println("CONSEGUIMOS CONTATTO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA");
        } else {
            System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NÚMERO MÁXIMO DE TENTATIVAS "
                    + tentativasRealizadas + " REALIZADA");
        }

    }

    // Método auxiliar
    static boolean atender() {
        return new Random().nextInt(3) == 1;
    }

    // Método escrito para que fosse mostrada a lista dos selecionados
    static void imprimirSelecionados() {
        String[] candidatos = { "CAIO", "ANA FLÁVIA", "IGOR", "ÉRIKA", "RAFAELA" };

        /*
         * Forma de mostrar o indice no console
         * 
         * System.out.
         * println("Imprimindo a lista de candidatos informando o índice do elemento.");
         * 
         * for (int indice = 0; indice < candidatos.length; indice++) {
         * System.out.println("O candidato de n° " + (indice + 1) + " é o " +
         * candidatos[indice]);
         * }
         * 
         */

        // Forma abreviada sem mostrar o indice no console
        System.out.println(" ");
        System.out.println("Forma abreviada de interação for each");

        for (String candidato : candidatos) {
            System.out.println("O candidato selecionado foi: " + candidato);
        }
        System.out.println(" ");
    }

    // Método feito para a seleção dos candidatos
    static void selecaoCandidatos() {
        String[] candidatos = { "PÂMELA", "PATRICK", "ÉRIKA", "RAFAELA", "AUGUSTO", "CAIO", "IGOR", "ANA FLÁVIA",
                "MARIANA", "JOÃO PEDRO" };

        int candidatosSelecionados = 0;
        int candidatosAtual = 0;
        double salarioBase = 2000.0;

        while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
            String candidato = candidatos[candidatosAtual];
            double salarioPretendido = valorPretendido();

            System.out.println("O candidato " + candidato + " solicitou este valor de salário: " + salarioPretendido);
            if (salarioBase >= salarioPretendido) {
                System.out.println("O candidato " + candidato + " foi selecionado para a vaga.");
                candidatosSelecionados++;
            }
            candidatosAtual++;
        }
    }

    // Método feito para gerar randomicamente um valor de salário
    static double valorPretendido() {
        return ThreadLocalRandom.current().nextDouble(1800, 2200);
    }

    // Método criado para analizar se o candidato deve ser convocado
    static void analizarCandidato(double salarioPretendido) {
        double salarioBase = 2000.0;

        if (salarioBase > salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO");
        } else if (salarioBase == salarioPretendido) {
            System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
        } else {
            System.out.println("AGUARDANDO O RESULTADO DOS DEMAIS CANDIDATOS");
        }

    }
}
