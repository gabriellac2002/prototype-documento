package padroescriacionais.prototype;

import java.util.HashMap;
import java.util.Map;

public class RegistroDocumentos {

    private final Map<String, DocumentoPrototipo> prototipos = new HashMap<>();

    public void registrar(String nome, DocumentoPrototipo prototipo) {
        prototipos.put(nome, prototipo);
    }

    public DocumentoPrototipo criar(String nome) {
        DocumentoPrototipo prototipo = prototipos.get(nome);
        if (prototipo == null) {
            throw new IllegalArgumentException("Prototipo nao registrado: " + nome);
        }
        return prototipo.clonar();
    }
}
