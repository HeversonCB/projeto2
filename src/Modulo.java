import java.time.DayOfWeek;
import java.time.OffsetDateTime;
import java.util.Objects;

public class Modulo {

    private Trilha trilha;
    private String nome;
    private String habilidades;
    private String tarefaValidacao;
    private OffsetDateTime prazoLimite;
    private Status status;
    private OffsetDateTime dataIincio;
    private OffsetDateTime dataEncerramento;
    private boolean avaliacaoDisp = false;
    private int diasPrazo = 10;

    public Modulo(Trilha trilha, String nome, String habilidades, String tarefaValidacao) {
        this.trilha = trilha;
        this.nome = nome;
        this.habilidades = habilidades;
        this.tarefaValidacao = tarefaValidacao;
        this.status = Status.CURSO_NAO_INICIADO;
    }

    // NÃO POSSUI O STATUS "FINALIZADO" PORQUE O MESMO DEVERÁ SER APLICADO AUTOMATICAMENTE QUANDO O PRAZO TERMINAR.
    public void alterarStatus(Status status, Perfil perfil) {
        if (Objects.equals(perfil.getNome(), "Administrativo")) {
            this.status = status;
            if (status == Status.CURSO_EM_ANDAMENTO) {
                this.dataIincio = OffsetDateTime.now();
            } else if (status == Status.EM_FASE_DE_AVALIACAO) {
                int dias = diasPrazo;
                while(dias > 0){            // LOOP PARA ADICIONAR SOMENTE DIAS ÚTEIS
                    --dias;
                    prazoLimite = prazoLimite.plusDays(1);
                    if (prazoLimite.getDayOfWeek() != DayOfWeek.SATURDAY && prazoLimite.getDayOfWeek() != DayOfWeek.SUNDAY) {
                        ++dias;
                    }
                }
                this.dataEncerramento = OffsetDateTime.now();
                this.avaliacaoDisp = true;
            }
        } else {
            System.out.println("Permissão negada!");
        }
    }

    //EXECUTADO SEMPRE QUE A AVALIAÇÃO FOR ABERTA ("TRUE" = ESTÁ NO PRAZO. |        | "FALSE" = ACABOU O PRAZO.)
    public boolean verificarPrazo() {
        return OffsetDateTime.now().isBefore(prazoLimite);
    }

}
