package com.lm.pizzariaApi.entity;


@Entity
@Table(name = "Balcao",schema = "public")
public class Balcao extends AbstractEntity {
/*

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cl_balcao.pedido",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "balcao.id",
                            "pedido.id"
                    }
            ),
            joinColumns =  @JoinColumn(
                    name = "balcao.id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "pedido.id"
            )
    )
    private List<Pedido> pedidos = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cl_balcao.funcionario",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "balcao.id",
                            "funcionario.id"
                    }
            ),
            joinColumns =  @JoinColumn(
                    name = "balcao.id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "funcionario.id"
            )
    )
    private List<Funcionario> funcionarios = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cl_balcao.cliente",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "balcao.id",
                            "cliente.id"
                    }
            ),
            joinColumns =  @JoinColumn(
                    name = "balcao.id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "cliente.id"
            )
    )
    private List<Cliente> clientes = new ArrayList<>();

    @Getter
    @Setter
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "cl_balcao.produto",
            uniqueConstraints = @UniqueConstraint(
                    columnNames = {
                            "balcao.id",
                            "produto.id"
                    }
            ),
            joinColumns =  @JoinColumn(
                    name = "balcao.id"
            ),
            inverseJoinColumns = @JoinColumn(
                    name = "produto.id"
            )
    )
    private List<Produto> produtos = new ArrayList<>();

    */


    @ManyToOne
    @JoinColumn(name = "pedidos_id", referencedColumnName = "id")
    private Pedido pedido;


    @ManyToOne
    @JoinColumn(name = "cliente_id", referencedColumnName = "id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "id")
    private Funcionario funcionario;

}
