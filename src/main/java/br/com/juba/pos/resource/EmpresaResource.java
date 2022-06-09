package br.com.juba.pos.resource;

import java.util.List;
import java.util.UUID;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import br.com.juba.pos.model.Empresa;
import br.com.juba.pos.model.Endereco;
import br.com.juba.pos.model.Telefone;
import br.com.juba.pos.service.EmpresaService;

/**
 * Root resource (exposed at "empresa" path)
 */
@Path("empresa")
public class EmpresaResource {
    
    private EmpresaService empresaService = new EmpresaService();

    /**
     * Metodo que retorna os dados da empresa
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")

    public Response get() {
    
        Empresa empresa = empresaService.criarEmpresa();
       
        return Response.ok(empresa).build();
    }    

    /**
     * Method handling HTTP GET requests. The returned object will be sent
     * to the client as "text/plain" media type.
     *
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("mock")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")

    public Response getMock() {
    
        Empresa empresa = new Empresa();
        empresa.setId(UUID.randomUUID());
        empresa.setNome("Minha Empresa");
        Endereco endereco = new Endereco();
        endereco.setBairro("Limoeiro");
        endereco.setCidade("Bauru");
        endereco.setEstado("São Paulo");
        endereco.setLogradouro("Rua do Jaú");
        endereco.setNumero(10);
        Telefone telefone = new Telefone();
        telefone.setDdd(61);
        telefone.setNumero(998368149);
        empresa.setEndereco(endereco);
        empresa.setTelefone(telefone);
        return Response.ok(empresa).build();
    }    

    @GET
	@Path("mock/endereco")
	public Response get(@PathParam("endereco") String bairro) {
		Endereco end = new Endereco();
        end.setBairro("Aguas");
		return Response.ok(end).build();

   }

   
}