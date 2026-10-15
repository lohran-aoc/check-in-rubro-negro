import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao;
        String adversario = "Estudiantes";
        String data = "15/10/2026";
        String hora = "21:30";
        String estadio = "Estádio UNO";
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
                    System.out.println("O próximo jogo do Mengão é " + data + " às " + hora + " contra o " + adversario + " no " + estadio);
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
                    System.out.println("Visualizando perfil");
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