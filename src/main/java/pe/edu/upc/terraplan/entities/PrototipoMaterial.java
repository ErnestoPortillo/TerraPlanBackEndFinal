package pe.edu.upc.terraplan.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PrototipoMaterial")
public class PrototipoMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idPrototipoMaterial; // Cambio aquí para cumplir con los estándares

    @ManyToOne
    @JoinColumn(name = "idPrototipo")
    private Prototipo prototipo;

    @ManyToOne
    @JoinColumn(name = "idMaterial")
    private Material material;

    public PrototipoMaterial() {
    }

    public PrototipoMaterial(int idPrototipoMaterial, Material material, Prototipo prototipo) {
        this.idPrototipoMaterial = idPrototipoMaterial;
        this.material = material;
        this.prototipo = prototipo;
    }

    public int getIdPrototipoMaterial() {
        return idPrototipoMaterial;
    }

    public void setIdPrototipoMaterial(int idPrototipoMaterial) {
        this.idPrototipoMaterial = idPrototipoMaterial;
    }

    public Prototipo getPrototipo() {
        return prototipo;
    }

    public void setPrototipo(Prototipo prototipo) {
        this.prototipo = prototipo;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }
}
