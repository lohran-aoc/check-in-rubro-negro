import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao;
        Jogo proximoJogo = new Jogo("Estudiantes", "15/10/2026", "21:30", "UNO");
        int checkIns = 0;
        boolean fezCheckIn = false;

        do {
            System.out.println("======Bem-vindo ao Check-in Rubro-Negro======");
            System.out.println(" ");
            System.out.println(" ");
            System.out.println("Escolha uma opção:");
            System.out.println("1. Consultar jogo");
            System.out.println("2. Fazer check-in");
            System.out.println("3. Visualizar perfil");
            System.out.println("4. Sair");
            opcao = leitura.nextInt();

            switch (opcao) {
                case 1:
                    proximoJogo.exibeInformacoes();
                    break;
                case 2:
                    System.out.println("Fazendo check-in");
                    if (fezCheckIn == false) {
                        checkIns++;
                        System.out.println("Você fez o check-in.");
                        fezCheckIn = true;
                    } else {
                        System.out.println("Você já fez o check-in para essa partida!");
                    }
                    System.out.println("Você já fez " + checkIns + " check-ins.");
                    break;
                case 3:
                    System.out.println("========== PERFIL RUBRO-NEGRO ==========");
                    System.out.println("Total de check-ins: " + checkIns);
                    System.out.println("Próximo adversário: " + proximoJogo.getAdversario());
                    System.out.println("Data da partida: " + proximoJogo.getData());
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