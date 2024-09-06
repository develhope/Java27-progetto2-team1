package Users;

import Enums.Roles;
import Management.Carrello;

public class Utente {
    private String nome;
    private String cognome;
    private int age;
    private String email;
    private int idUtente;
    private String password;
    protected Roles role;
    protected Carrello carrelloCliente;

    public Utente(String nome, String cognome, int age, String email, String password) {
        this.nome = nome;
        this.cognome = cognome;
        this.age = age;
        this.email = email;
        this.password = password;
        carrelloCliente = new Carrello();
    }

    public Utente(){}


    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getIdUtente() {
        return idUtente;
    }

    public String getPassword() {
        return password;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdUtente(int idUtente) {
        this.idUtente = idUtente;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean login(String email, String password) {
        return email.equals(getEmail()) && password.equals(getPassword());
    }

    public Roles getRole() {
        return role;
    }

    public Carrello getCarrelloCliente() {

        if(carrelloCliente == null) carrelloCliente = new Carrello();
        return carrelloCliente;
    }

    public void setCarrelloCliente(Carrello carrelloCliente) {
        this.carrelloCliente = carrelloCliente;
    }
}
