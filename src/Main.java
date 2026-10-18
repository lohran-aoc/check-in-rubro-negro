import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao;
        Jogo proximoJogo = new Jogo("Estudiantes", "15/10/2026", "21:30", "UNO");
        Usuario usuarioAtual = new Usuario(1, "Nicolas", LocalDate.of(2019, 10, 19), false);
        Presenca presencaAtual = null;
        int checkIns = 0;
        boolean fezCheckIn = false;

        do {
            System.out.println("======Bem-vindo ao Check-in Rubro-Negro======");
            System.out.println(" ");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar jogo");
            System.out.println("2. Fazer check-in");
            System.out.println("3. Visualizar perfil");
            System.out.println("4. Sair");
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    proximoJogo.exibirInformacoes();
                    break;
                case 2:
                    System.out.println("Fazendo check-in");
                    if (presencaAtual == null) {
                        checkIns++;
                        presencaAtual = new Presenca(usuarioAtual, proximoJogo);
                        System.out.println("Você fez o check-in.");
                    } else {
                        System.out.println("Você já fez o check-in para essa partida!");
                    }
                    System.out.println("Você já fez " + checkIns + " check-in(s).");
                    break;
                case 3:
                    System.out.println("========== PERFIL RUBRO-NEGRO ==========");
                    System.out.println("Bem-vindo " + usuarioAtual.getNome());
                    if(usuarioAtual.isSocioTorcedor()) {
                        System.out.println("Você é sócio torcedor!");
                    } else {
                        System.out.println("Que tal aderir a um plano de sócio-torcedor?");
                    }
                    System.out.println("Total de check-ins: " + checkIns);
                    System.out.println(" ");
                    if (presencaAtual != null) {
                        System.out.println("=========== ÚLTIMA PRESENÇA ===========");
                        System.out.println("Torcedor: " + presencaAtual.getUsuario().getNome());
                        System.out.println("Adversário: " + presencaAtual.getJogo().getAdversario());
                        System.out.println("Data: " + presencaAtual.getJogo().getData());
                        System.out.println("Hora: " + presencaAtual.getJogo().getHora());
                    } else {
                        System.out.println("Faça seu check-in para o próximo jogo contra o " + proximoJogo.getAdversario() + " no dia: " + proximoJogo.getData());
                    }
                    break;
                case 4:
                    System.out.println("Até a próxima!");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        } while (opcao != 4);
        leitura.close();
    }
}