import java.util.ArrayList;

public abstract class Usuario implements Metodos {

    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private ArrayList<Perfil> perfisDeAcesso = new ArrayList<Perfil>();


    public Usuario(String nome, String cpf, String email, String senha, Perfil perfil) {
        this.nome = nome;
        this.cpf = inserirPontuacaoCpf(cpf);  // METODO PARA VALIDAÇÃO ESTÁ NA INTERFACE "METODOS".
        this.email = email;  // METODO PARA VALIDAÇÃO ESTÁ NA INTERFACE "METODOS".
        this.senha = senha;
        this.perfisDeAcesso.add(perfil);
    }

    public void adicionarPerfilDeAcesso(Perfil perfil) {
        this.perfisDeAcesso.add(perfil);
    }

}
