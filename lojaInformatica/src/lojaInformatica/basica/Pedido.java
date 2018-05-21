package lojaInformatica.basica;

import java.util.ArrayList;

/**
 *
 * @author renatoandrade
 */
public class Pedido {

    private Integer codigo;
    private String data;
    private Double valor;
    private String pagamento;
    private Cliente cliente;
    private Funcionario funcionario;
    private ArrayList<PedidoMaterial> pedidomaterial;

    /**
     * Método construtor para inicializar um Pedido
     */
    public Pedido() {
        cliente = new Cliente();
        funcionario = new Funcionario();
    }

    /**
     * Método construtor para inicializar um Pedido e iniciar os parâmetros
     *
     * @param codigo
     * @param data
     * @param valor
     * @param pagamento
     * @param cliente
     * @param funcionario
     */
    public Pedido(Integer codigo, String data, Double valor, String pagamento, Cliente cliente, Funcionario funcionario) {
        this.codigo = codigo;
        this.data = data;
        this.valor = valor;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
    }

    /**
     * Método construtor para inicializar um Pedido e iniciar os parâmetros
     *
     * @param codigo
     * @param data
     * @param valor
     * @param pagamento
     * @param cliente
     * @param funcionario
     * @param pedidomaterial
     */
    public Pedido(Integer codigo, String data, Double valor, String pagamento, Cliente cliente, Funcionario funcionario, ArrayList<PedidoMaterial> pedidomaterial) {
        this.codigo = codigo;
        this.data = data;
        this.valor = valor;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.funcionario = funcionario;
        this.pedidomaterial = pedidomaterial;
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
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
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

    /**
     * @return the pagamento
     */
    public String getPagamento() {
        return pagamento;
    }

    /**
     * @param pagamento the pagamento to set
     */
    public void setPagamento(String pagamento) {
        this.pagamento = pagamento;
    }

    /**
     * @return the cliente
     */
    public Cliente getCliente() {
        return cliente;
    }

    /**
     * @param cliente the cliente to set
     */
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    /**
     * @return the funcionario
     */
    public Funcionario getFuncionario() {
        return funcionario;
    }

    /**
     * @param funcionario the funcionario to set
     */
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    /**
     * @return the pedidomaterial
     */
    public ArrayList<PedidoMaterial> getPedidoMaterial() {
        return pedidomaterial;
    }

    /**
     * @param pedidomaterial the pedidomaterial to set
     */
    public void setPedidoMaterial(ArrayList<PedidoMaterial> pedidomaterial) {
        this.pedidomaterial = pedidomaterial;
    }

    /**
     * Instância um objeto de PedidoMaterial
     *
     * @return ArrayList de PedidoMaterial
     */
    public ArrayList<PedidoMaterial> getPedidomaterial() {
        return pedidomaterial;
    }

    /**
     * Instância um objeto de PedidoMaterial e passa os dados dele
     *
     * @param pedidomaterial
     */
    public void setPedidomaterial(ArrayList<PedidoMaterial> pedidomaterial) {
        this.pedidomaterial = pedidomaterial;
    }

    @Override
    public String toString() {
        return "Código: " + this.codigo + " Data do pedido: " + this.data + " Valor total do pedido: R$" + this.valor + " Forma de pagamento: " + this.pagamento + "CPF Cliente: " + this.cliente + "Funcionário responsável: " + this.funcionario;
    }
}
