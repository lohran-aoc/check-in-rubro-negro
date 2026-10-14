import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner leitura = new Scanner(System.in);
        int opcao;

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
                    System.out.println("Consultando o próximo jogo");
                    break;
                case 2:
                    System.out.println("Fazendo check-in");
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