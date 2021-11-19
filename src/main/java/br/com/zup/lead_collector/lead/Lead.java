package br.com.zup.lead_collector.lead;

import br.com.zup.lead_collector.produto.Produto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "leads")
@NoArgsConstructor
@Getter
@Setter
public class Lead {

    @Id
    private String email;
    @Column(columnDefinition = "VARCHAR(100) DEFAULT 'Não informado'")
    private String nome;
    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Produto> produtos;

}
