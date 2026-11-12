import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao;
        int opcaoJogo;
        Jogo proximoJogo = new Jogo("Estudiantes", "15/10/2026", "21:30", "UNO");
        Jogo segundoJogo = new Jogo("Vasco", "11/11/2026", "21:30", "Maracanã");
        Usuario usuarioAtual = new Usuario(1, "Nicolas", LocalDate.of(2019, 10, 19), false);
        Presenca presencaAtual = null;
        CheckInService checkInService = new CheckInService();
        List<Presenca> listaPresencas = new ArrayList<>();
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
                    Jogo jogoSelecionado = null;
                    System.out.println("Em qual jogo você quer fazer check-in?");
                    System.out.println("1: " + proximoJogo.getAdversario());
                    System.out.println("2: " + segundoJogo.getAdversario());
                    opcaoJogo = leitura.nextInt();

                    switch (opcaoJogo) {
                        case 1:
                            jogoSelecionado = proximoJogo;
                            break;
                        case 2:
                            jogoSelecionado = segundoJogo;
                            break;
                        default:
                            System.out.println("Opção de jogo inválida!");
                            break;
                    }
                    if (jogoSelecionado == null) {
                        break;
                    }
                    boolean jaFezCheckIn = checkInService.jaFezCheckIn(listaPresencas, jogoSelecionado);

                    if (!jaFezCheckIn) {
                        checkIns++;
                        presencaAtual = new Presenca(usuarioAtual, jogoSelecionado);
                        listaPresencas.add(presencaAtual);
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
                    if (!listaPresencas.isEmpty()) {
                        System.out.println("----------------------------");
                        for (Presenca presenca : listaPresencas) {
                            System.out.println("Adversário: " + presenca.getJogo().getAdversario());
                            System.out.println("Data: " + presenca.getJogo().getData());
                            System.out.println("Hora: " + presenca.getJogo().getHora());
                            System.out.println("----------------------------");
                        }
                    } else {
                        System.out.println("Você ainda não fez nenhum check-in");
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