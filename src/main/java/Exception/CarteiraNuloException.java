package Exception;

public class CarteiraNuloException extends RuntimeException {

    public CarteiraNuloException() {
        super();
    }

    public CarteiraNuloException(String mensagem) {
        super(mensagem);
    }


    public CarteiraNuloException(String mensagem, Throwable causa) {
        super(mensagem, causa);
    }


    public CarteiraNuloException(Throwable causa) {
        super(causa);
    }

}
