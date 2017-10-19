package exception;

/**
 * Classe LocationImpossibleException extends exception. elle est levée quand une location est impossible à effectuée
 */
public class LocationImpossibleException extends Exception {

    public LocationImpossibleException(String e) {
        super(e);
    }
}

