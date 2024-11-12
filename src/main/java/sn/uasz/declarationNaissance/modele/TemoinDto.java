package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "temoins")

public class TemoinDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idTemoin;
    public String nom;
    public String prenom;
    public String typePiece;
    public String numeroPiece;
    public String domicile;
    public String profession;
//    @Temporal(TemporalType.DATE)
    public String dateNaissance;
    public String lieuNaissance;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "T_Temoin_declarationNaissance",
            joinColumns = @JoinColumn(name= "idTemoin"),
            inverseJoinColumns = @JoinColumn(name="idDeclaration"))
    public List<DeclarationNaissanceDto> declarationNaissance = new ArrayList<>();

}
