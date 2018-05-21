package lojaInformatica.basica;

/**
 *
 * @author renatoandrade
 */
public class Cliente {

    private String cpf;
    private String nome;
    private String end;
    private String tel;
    private String email;
    
    /**
     * Método construtor para inicializar o cliente
     */
    public Cliente() {
    }

    /**
     * Método construtor para inicializar o cpf do cliente
     * @param cpf 
     */
    public Cliente(String cpf) {
        this.cpf = cpf;
    }
    
    /**
     * Método construtor para inicializar os parâmetros do cliente
     * @param cpf
     * @param nome
     * @param end
     * @param tel
     * @param email 
     */
    public Cliente(String cpf, String nome, String end, String tel, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.end = end;
        this.tel = tel;
        this.email = email;
    }

    /**
     * Método construtor para inicializar os parâmetros do cliente sem o CPF
     * @param nome
     * @param end
     * @param tel
     * @param email 
     */
    public Cliente(String nome, String end, String tel, String email) {
        this.nome = nome;
        this.end = end;
        this.tel = tel;
        this.email = email;
    }

    /**
     * @return the cpf
     */
    public String getCpf() {
        return cpf;
    }

    /**
     * @param cpf the cpf to set
     */
    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the end
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * @return the tel
     */
    public String getTel() {
        return tel;
    }

    /**
     * @param tel the tel to set
     */
    public void setTel(String tel) {
        this.tel = tel;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "CPF: " + this.cpf + " Nome: " + this.nome + " Endereço: " + this.end + " Telefone: " + this.tel + " E-mail: " + this.email;
    }

}
