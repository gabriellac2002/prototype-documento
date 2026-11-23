package padroescriacionais.prototype;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Contrato implements DocumentoPrototipo {

    private String contratante;
    private final double valor;
    private final List<String> clausulas;

    public Contrato(String contratante, double valor) {
        this.contratante = contratante;
        this.valor = valor;
        this.clausulas = new ArrayList<>();
    }

    private Contrato(Contrato original) {
        this.contratante = original.contratante;
        this.valor = original.valor;
        this.clausulas = new ArrayList<>(original.clausulas);
    }

    public void setContratante(String contratante) {
        this.contratante = contratante;
    }

    public String getContratante() {
        return contratante;
    }

    public double getValor() {
        return valor;
    }

    public void adicionarClausula(String clausula) {
        clausulas.add(clausula);
    }

    public List<String> getClausulas() {
        return Collections.unmodifiableList(clausulas);
    }

    @Override
    public DocumentoPrototipo clonar() {
        return new Contrato(this);
    }

    @Override
    public String descrever() {
        return "Contrato de " + contratante + " no valor de " + valor + " clausulas=" + clausulas;
    }
}
