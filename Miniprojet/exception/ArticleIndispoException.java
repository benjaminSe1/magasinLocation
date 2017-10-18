package exception;

/**
 * Classe ArticleIndispoException extends exception. elle est levée quand un article est demande en location dans en quantité indisponible
 */
public class ArticleIndispoException extends Exception {

    public ArticleIndispoException(String e) {
        super(e);
    }
}
