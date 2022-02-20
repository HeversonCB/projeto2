import java.time.LocalDateTime;
import java.util.ArrayList;

public class Trilha {

    private static int sequencia = 0;
    private Empresa empresa;
    private String ocupacao;
    private String nome;
    private String apelido;
    private ArrayList<Modulo> modulos = new ArrayList<Modulo>();
    private int satisfacao;
    private ArrayList<String> anotacoes = new ArrayList<>();

    public Trilha(Empresa empresa, String ocupacao, ArrayList<Modulo> modulos, int satisfacao, ArrayList<String> anotacoes) {
        this.empresa = empresa;
        this.ocupacao = ocupacao;
        this.satisfacao = satisfacao;
        this.modulos.addAll(modulos);
        this.anotacoes.addAll(anotacoes);
        this.nome = ocupacao + empresa.getNome() + toString(sequencia) + toString(LocalDateTime.now().getYear());
        this.apelido = ocupacao + toString(sequencia);
        sequencia++;
    }

    private String toString(int year) {
        return Integer.toString(year);
    }

    public void adicionarModulo(Modulo modulo) {
        this.modulos.add(modulo);
    }

    public void adicionarAnotacao(String anotacao) {
        this.anotacoes.add(anotacao);
    }


    public boolean validarSatisfacao(int satisfacao) {
        return satisfacao >= 1 && satisfacao <= 5;
    }

}
