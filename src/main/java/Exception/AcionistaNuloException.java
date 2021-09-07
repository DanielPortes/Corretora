package Exception;

public class AcionistaNuloException extends RuntimeException
{

    public AcionistaNuloException()
    {
        super();
    }

    public AcionistaNuloException(String mensagem)
    {
        super(mensagem);
    }

    public AcionistaNuloException(String mensagem, Throwable causa)
    {
        super(mensagem, causa);
    }

    public AcionistaNuloException(Throwable causa)
    {
        super(causa);
    }

}
