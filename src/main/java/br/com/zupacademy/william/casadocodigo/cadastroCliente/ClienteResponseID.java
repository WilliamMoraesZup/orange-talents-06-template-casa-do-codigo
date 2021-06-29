package br.com.zupacademy.william.casadocodigo.cadastroCliente;

public class ClienteResponseID {

    private Long id;

    public ClienteResponseID(Cliente cliente) {
        this.id = cliente.getId();
    }


}
