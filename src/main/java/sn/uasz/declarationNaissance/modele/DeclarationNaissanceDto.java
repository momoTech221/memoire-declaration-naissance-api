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

@Data @AllArgsConstructor @NoArgsConstructor @ToString
@Entity
@Table(name = "declarationNaissances")
public class DeclarationNaissanceDto implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idDeclaration;
    public String date;
    public String numero;
    public String declaration;
    public String reference;
    public String scanAt;
    public String dateModification;
    public String userAdd;
    public String userSet;
    @OneToOne
    @JoinColumn(name = "idDeclare")
    public DeclareDto declare;
//    @OneToOne
//    @JoinColumn(name = "idDemande")
//    public DemandeDto demande;
    @ManyToOne
    @JoinColumn(name = "idDeclarant")
    public DeclarantDto declarant;
    @ManyToOne
    @JoinColumn(name="idPere")
    public PereDto pere;
    //@ManyToOne(fetch = FetchType.LAZY)
    @ManyToOne
    @JoinColumn(name="idMere")
    public MereDto mere;
    @ManyToMany
    @JoinTable(name = "T_Temoin_declarationNaissance",
            joinColumns = @JoinColumn(name= "idDeclaration"),
            inverseJoinColumns = @JoinColumn(name="idTemoin"))
    public List<TemoinDto> temoin = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "idCentre")
    public CentreDto centre;
    @ManyToOne
    @JoinColumn(name = "idRegistre")
    public RegistreDto registre;
    @OneToOne
    @JoinColumn(name = "idJugement")
    public JugementDto jugement;
    @ManyToOne
    @JoinColumn(name = "idFormationSanitaire")
    public FormationSanitaireDto formationSanitaire;
    @ManyToMany
    @JoinTable(name = "T_mention_declarationNaissance",
            joinColumns = @JoinColumn(name= "idDeclaration"),
            inverseJoinColumns = @JoinColumn(name="idMention"))
    public List<MentionDto> mention = new ArrayList<>();
}
