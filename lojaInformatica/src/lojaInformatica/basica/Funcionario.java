package lojaInformatica.basica;

/**
 *
 * @author renatoandrade
 */
public class Funcionario {

    private String cpf;
    private String nome;
    private String tel;
    private String end;
    private String cargo;

    /**
     * Método construtor para inicializar um Funcionario
     */
    public Funcionario() {
    }

    /**
     * Método construtor para inicializar o cpf do Funcionario
     * @param cpf 
     */
    public Funcionario(String cpf) {
        this.cpf = cpf;
    }

    /**
     * Método construtor para inicializar os parâmetros do Funcionário
     * @param cpf
     * @param nome
     * @param tel
     * @param end
     * @param cargo 
     */
    public Funcionario(String cpf, String nome, String tel, String end, String cargo) {
        this.cpf = cpf;
        this.nome = nome;
        this.tel = tel;
        this.end = end;
        this.cargo = cargo;
    }

    /**
     * Método construtor para inicializar os parâmetros do Funcionario (sem CPF)
     * @param nome
     * @param tel
     * @param end
     * @param cargo 
     */
    public Funcionario(String nome, String tel, String end, String cargo) {
        this.nome = nome;
        this.end = tel;
        this.tel = end;
        this.cargo = cargo;
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
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    @Override
    public String toString() {
        return "CPF: " + this.cpf + " Nome: " + this.nome + " Telefone: " + this.tel + " Endereço: " + this.end + " Cargo: " + this.cargo;
    }

}
