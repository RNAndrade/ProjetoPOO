package lojaInformatica.basica;

/**
 *
 * @author renatoandrade
 */
public class PedidoMaterial {

    private Double valor;
    private Integer quantidade;
    private Pedido pedido;
    private Material material;

    /**
     * Método construtor para inicializar um PedidoMaterial
     */
    public PedidoMaterial() {
    }

    /**
     * Método construtor para inicializar um PedidoMaterial e iniciar os
     * parâmetros
     *
     * @param valor
     * @param quantidade
     * @param pedido
     * @param material
     */
    public PedidoMaterial(Double valor, Integer quantidade, Pedido pedido, Material material) {
        this.valor = valor;
        this.quantidade = quantidade;
        this.pedido = pedido;
        this.material = material;
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
     * @return the quantidade
     */
    public Integer getQuantidade() {
        return quantidade;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @return the pedido
     */
    public Pedido getPedido() {
        return pedido;
    }

    /**
     * @param pedido the pedido to set
     */
    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    /**
     * @return the material
     */
    public Material getMaterial() {
        return material;
    }

    /**
     * @param material the material to set
     */
    public void setMaterial(Material material) {
        this.material = material;
    }

    @Override
    public String toString() {
        return "Valor: R$" + this.valor + " Quantidade: " + this.quantidade + " Código do pedido" + this.pedido + " Código do material: " + this.material;
    }

}
