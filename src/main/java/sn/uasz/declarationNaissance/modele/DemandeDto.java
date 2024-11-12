package sn.uasz.declarationNaissance.modele;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "demandes")
public class DemandeDto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDemande;
    public  String dateDemande;
    public  String etat;
    public  String code;
    public  String modePaiement;
    public  String reference;
    public  String userAdd;
    public  Long declaration;
    public Long nbCopie;
    public String nomParticulier;
    public String prenomParticulier;
    public String telephoneParticulier;
//    @OneToOne(mappedBy = "demande")
//    public DeclarationNaissanceDto declarationNaissance;
}
