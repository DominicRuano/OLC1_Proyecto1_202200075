package proyecto1compi1;

import java.awt.Desktop;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

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

    public void limpiarMapa() {
        mapa.clear();
    }

    public void imprimirMapa() {
        for (Map.Entry<String, String> entrada : mapa.entrySet()) {
            System.out.println("Clave: " + entrada.getKey() + ", Valor: " + entrada.getValue());
        }
    }

    public void generarYAbrirHTML() throws IOException {
        String nombreArchivo = "TablaDeSimbolos.html";
        String html = "<!DOCTYPE html>\n" +
                "<html>\n" +
                "<head>\n" +
                "<title>Tabla de Símbolos</title>\n" +
                "<style>\n" +
                "table, th, td {\n" +
                "  border: 1px solid black;\n" +
                "  border-collapse: collapse;\n" +
                "}\n" +
                "th, td {\n" +
                "  padding: 5px;\n" +
                "  text-align: left;\n" +
                "}\n" +
                "</style>\n" +
                "</head>\n" +
                "<body>\n" +
                "<h2>Tabla de Símbolos</h2>\n" + // Título de la tabla
                "<table>\n" +
                "<tr>\n" +
                "<th>#</th>\n" +
                "<th>Nombre</th>\n" +
                "<th>Tipo</th>\n" +
                "<th>Valor</th>\n" +
                "<th>Línea</th>\n" +
                "<th>Columna</th>\n" +
                "</tr>\n";

        int count = 1; // Contador para los números de línea en la tabla
        for (Map.Entry<String, String> entrada : mapa.entrySet()) {
            html += String.format("<tr>\n" +
                    "<td>%d</td>\n" +
                    "<td>%s</td>\n" +
                    "<td>%s</td>\n" +
                    "<td>%s</td>\n" +
                    "<td>%s</td>\n" +
                    "<td>%s</td>\n" +
                    "</tr>\n", count++, entrada.getKey(), "tipo", entrada.getValue(), "línea", "columna");
        }

        html += "</table>\n</body>\n</html>";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreArchivo))) {
            writer.write(html);
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        if (Desktop.isDesktopSupported()) {
            Desktop.getDesktop().browse(new File(nombreArchivo).toURI());
        }
    }

}
