import lombok.Data;
    /*
    MATHEUS PEDRO ZANCANELLA BARBOZA 202035005
    DANIEL FAGUNDES PORTES FERNANDES 201965574C
    */
import java.util.ArrayList;
import java.util.List;

@Data
public class Empresa implements Investimento
{
    public String nome;
    public double valorAcao;
    public double lucroDividendo;
    public List<Acionista> acionistas;

    public Empresa(String nome, double valorAcao, double lucroDividendo)
    {
        this.nome = nome;
        this.valorAcao = valorAcao;
        this.lucroDividendo = lucroDividendo;
        acionistas = new ArrayList<Acionista>();
    }

    public void cadastrarAcionista(Acionista acionista)
    {
        if (acionista == null)
        {
            throw new IllegalArgumentException("Acionista deve ser informado");
        }
        if (!verificarExistenciaAcionista(acionista))
        {
            this.acionistas.add(acionista);
        }
    }

    public boolean verificarExistenciaAcionista(Acionista acionista)
    {
        return getAcionistas().contains(acionista);
    }




}