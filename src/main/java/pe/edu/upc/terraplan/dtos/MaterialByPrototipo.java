package pe.edu.upc.terraplan.dtos;

public class MaterialByPrototipo {
    private String nombre;
    private float valor;
    private int prototipo;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public int getPrototipo() {
        return prototipo;
    }

    public void setPrototipo(int prototipo) {
        this.prototipo = prototipo;
    }
}
