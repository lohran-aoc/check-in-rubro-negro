import java.time.LocalDate;

public class Usuario {
    private long id;
    private String nome;
    private LocalDate dataNascimento;
    private boolean socioTorcedor;


    public String getNome() {
        return nome;
    }

    public boolean isSocioTorcedor() {
        return socioTorcedor;
    }


    public Usuario(long id, String nome, LocalDate dataNascimento, boolean socioTorcedor) {
        this.id = id;
        this.nome = nome;
        this.dataNascimento = dataNascimento;
        this.socioTorcedor = socioTorcedor;
    }
}
