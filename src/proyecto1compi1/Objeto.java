package proyecto1compi1;
import java.util.ArrayList;
import java.util.List;

public class Objeto {

    private List<String> lista;

    public Objeto() {
        this.lista = new ArrayList<>();
    }

    public void agregarString(String texto) {
        lista.add(texto);
    }

    public void eliminarString(int index) {
        if (index >= 0 && index < lista.size()) {
            lista.remove(index);
        }
    }

    public String obtenerString(int index) {
        if (index >= 0 && index < lista.size()) {
            return lista.get(index);
        } else {
            return null;
        }
    }
    
    public boolean contieneString(String texto) {
    return lista.contains(texto);
}


}
