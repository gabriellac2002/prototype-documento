package padroescriacionais.prototype;

public class Main {

    public static void main(String[] args) {
        Relatorio modelo = new Relatorio("Relatorio mensal", "Resumo de vendas");
        modelo.adicionarTag("financeiro");

        Contrato contratoPadrao = new Contrato("Cliente", 1000.0);
        contratoPadrao.adicionarClausula("Pagamento em 30 dias");

        RegistroDocumentos registro = new RegistroDocumentos();
        registro.registrar("relatorio", modelo);
        registro.registrar("contrato", contratoPadrao);

        Relatorio janeiro = (Relatorio) registro.criar("relatorio");
        janeiro.setTitulo("Relatorio de janeiro");
        janeiro.adicionarTag("janeiro");

        Contrato acme = (Contrato) registro.criar("contrato");
        acme.setContratante("ACME");

        System.out.println(modelo.descrever());
        System.out.println(janeiro.descrever());
        System.out.println(contratoPadrao.descrever());
        System.out.println(acme.descrever());
    }
}
