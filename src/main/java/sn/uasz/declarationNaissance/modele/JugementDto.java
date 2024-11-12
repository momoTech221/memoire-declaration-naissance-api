package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "jugements")
public class JugementDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idJugement;
    public String numero;
    public String date;
    public String lieu;
    @OneToOne(mappedBy = "jugement")
    public DeclarationNaissanceDto declarationNaissance;

}
