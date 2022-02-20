import java.time.OffsetDateTime;
import java.util.ArrayList;

public class Trabalhador implements Metodos {

    private String nome;
    private String cpf;
    private Empresa empresa;
    private String setor;
    private String funcao;
    private OffsetDateTime dataUltimaFuncao;
    private ArrayList<Trilha> trilhas = new ArrayList<Trilha>();
    private ArrayList<ModuloTrabalhador> modulos = new ArrayList<ModuloTrabalhador>(); /* LISTA FEITA PARA GUARDAR AS ANOTAÇÕES EM CADA
                                                                                          MODULO DE FORMA MAIS ORGANIZADA EM UMA UNICA CLASSE */

    public Trabalhador(String nome, String cpf, Empresa empresa, String setor, String funcao) {
        this.nome = nome;
        this.cpf = inserirPontuacaoCpf(cpf);  // METODO PARA VALIDAÇÃO ESTÁ NA INTERFACE "METODOS".
        this.empresa = empresa;
        this.setor = setor;
        this.funcao = funcao;
    }

    public void adicionarModulo(ModuloTrabalhador moduloTrabalhador) {
        modulos.add(moduloTrabalhador);
    }

    public void adicionarTrilha(Trilha trilha) {
        trilhas.add(trilha);
    }


}
