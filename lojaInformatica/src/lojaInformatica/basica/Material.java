package lojaInformatica.basica;

/**
 *
 * @author renatoandrade
 */
public class Material {

    private Integer codigo;
    private String descricao;
    private Double valor;

    /**
     * Método construtor para inicializar um Material
     */
    public Material() {
    }

    /**
     * Método construtor para inicializar o código de um Material
     * @param codigo 
     */
    public Material(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * Método construtor para inicializar os parâmetros de um Material
     * @param codigo
     * @param descricao
     * @param valor 
     */
    public Material(Integer codigo, String descricao, Double valor) {
        this.codigo = codigo;
        this.descricao = descricao;
        this.valor = valor;
    }

    /**
     * Método construtor para inicializar um Material e passar os parâmetros (sem código)
     * @param descricao
     * @param valor 
     */
    public Material(String descricao, Double valor) {
        this.descricao = descricao;
        this.valor = valor;
    }

    /**
     * @return the codigo
     */
    public Integer getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the valor
     */
    public Double getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(Double valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " Descrição: " + this.descricao + " Valor: R$" + this.valor;
    }
}
