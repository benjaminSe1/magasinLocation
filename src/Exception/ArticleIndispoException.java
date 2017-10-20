package Exception;

/**
 * Classe ArticleIndispoException extends Exception. elle est levée quand un Article est demande en location dans en quantité indisponible
 */
public class ArticleIndispoException extends Exception {

    public ArticleIndispoException(String e) {
        super(e);
    }
}
