import java.util.List;

public class CheckInService {
    public boolean jaFezCheckIn(List<Presenca> listaPresencas, Jogo jogoSelecionado) {
        for (Presenca presenca : listaPresencas) {
            if (presenca.getJogo().getAdversario().equals(jogoSelecionado.getAdversario()) && presenca.getJogo().getData().equals(jogoSelecionado.getData())) {
                return true;
            }
        }
        return false;
    }
}