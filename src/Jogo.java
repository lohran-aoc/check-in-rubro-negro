public class Jogo {
    private String adversario;
    private String data;
    private String hora;
    private String estadio;

    public String getAdversario() {
        return adversario;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public String getEstadio() {
        return estadio;
    }

    public Jogo(String adversario, String data, String hora, String estadio) {
        this.adversario = adversario;
        this.data = data;
        this.hora = hora;
        this.estadio = estadio;
    }

    public void exibirInformacoes() {
        System.out.println("O próximo jogo do Mengão é " + data + " às " + hora + " contra o " + adversario + " no " + estadio);
    }
}
