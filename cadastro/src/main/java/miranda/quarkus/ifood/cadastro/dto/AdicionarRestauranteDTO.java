package miranda.quarkus.ifood.cadastro.dto;

import miranda.quarkus.ifood.cadastro.entidades.Localizacao;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.CascadeType;
import javax.persistence.OneToOne;
import java.util.Date;

public class AdicionarRestauranteDTO {

    private String proprietario;

    private String nome ;

    private String cnpj;




    private LocalizacaoDTO localizacao;


}
