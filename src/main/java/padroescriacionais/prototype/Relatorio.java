package padroescriacionais.prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Relatorio implements DocumentoPrototipo {

    private String titulo;
    private final String conteudo;
    private final List<String> tags;

    public Relatorio(String titulo, String conteudo) {
        this.titulo = titulo;
        this.conteudo = conteudo;
        this.tags = new ArrayList<>();
    }

    private Relatorio(Relatorio original) {
        this.titulo = original.titulo;
        this.conteudo = original.conteudo;
        this.tags = new ArrayList<>(original.tags);
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void adicionarTag(String tag) {
        tags.add(tag);
    }

    public List<String> getTags() {
        return Collections.unmodifiableList(tags);
    }

    @Override
    public DocumentoPrototipo clonar() {
        return new Relatorio(this);
    }

    @Override
    public String descrever() {
        return "Relatorio '" + titulo + "' " + conteudo + " tags=" + tags;
    }
}
