package proyecto1compi1;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Objeto {

    private List<String> lista;
    private Map<String, String> mapa;

    public Objeto() {
        this.lista = new ArrayList<>();
        this.mapa = new HashMap<>();
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

    // Métodos para el HashMap
    public void agregarAlMapa(String clave, String valor) {
        mapa.put(clave, valor);
    }

    public String obtenerDelMapa(String clave) {
        return mapa.get(clave);
    }

    public void eliminarDelMapa(String clave) {
        mapa.remove(clave);
    }

    public boolean contieneClave(String clave) {
        return mapa.containsKey(clave);
    }
}
