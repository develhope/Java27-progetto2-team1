package Exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionHandler {
    public static <T> T handlexception(ExceptionHandlerFunction<T> function) {
        try {
            return function.apply();
        } catch (NullPointerException e) {
            System.err.println("Errore null: " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.err.println("Errore inserimento: " + e.getMessage());
            return null;
        } catch (FileNotFoundException e) {
            System.err.println("Errore file: " + e.getMessage());
            return null;
        } catch (IOException e) {
            System.err.println("Errore lettura: " + e.getMessage());
            return null;
        } catch (ProdottoNonTrovatoException e) {
            System.err.println("Errore ricerca: " + e.getMessage());
            return null;
        } catch (LoginFailedException e) {
            System.err.println("Login fallito" + e.getMessage());
            return null;
        } catch (CarrelloVuotoException e) {
            System.err.println("Errore carrello: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Errore generico: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }

}

