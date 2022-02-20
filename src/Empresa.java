import java.util.ArrayList;

public class Empresa implements Metodos{

    private String nome;
    private String cnpj;
    private String tipo; // (MATRIZ OU FILIAL)
    private String nomeFilial;
    private Segmento segmento;
    private String estado;
    private String cidade;
    private String regional;
    private ArrayList<Trilha> trilhas = new ArrayList<Trilha>();

    //CONSTRUTOR MATRIZ
    public Empresa(String nome, String cnpj, String tipo, Segmento segmento, String estado, String cidade, String regional, ArrayList<Trilha> trilhas) {
        this.nome = nome;
        this.cnpj = inserirPontuacaoCnpj(cnpj);  // METODO PARA VALIDAÇÃO ESTÁ NA INTERFACE "METODOS".
        this.tipo = tipo;
        this.segmento = segmento;
        this.estado = estado;
        this.cidade = cidade;
        this.regional = regional;
        this.trilhas.addAll(trilhas);
    }

    //CONSTRUTOR FILIAL
    public Empresa(String nome, String cnpj, String tipo, String nomeFilial, Segmento segmento, String estado, String cidade, String regional, ArrayList<Trilha> trilhas) {
        this.nome = nome;
        this.cnpj = inserirPontuacaoCnpj(cnpj);  // METODO PARA VALIDAÇÃO ESTÁ NA INTERFACE "METODOS".
        this.tipo = tipo;
        this.nomeFilial = nomeFilial;
        this.segmento = segmento;
        this.estado = estado;
        this.cidade = cidade;
        this.regional = regional;
        this.trilhas.addAll(trilhas);
    }

    public String getNome() {
        return this.nome;
    }

    public void adicionarTrilha(Trilha trilha) {
        trilhas.add(trilha);
    }
}
