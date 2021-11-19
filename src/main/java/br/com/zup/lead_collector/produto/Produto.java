package br.com.zup.lead_collector.produto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "produtos")
@NoArgsConstructor
@Getter
@Setter
public class Produto {

    @Id
    private String nomeProduto;

}
