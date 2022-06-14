package br.com.juba.pos.resource;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.juba.pos.model.Empresa;
import br.com.juba.pos.model.Endereco;
import br.com.juba.pos.model.Telefone;
import br.com.juba.pos.service.EmpresaService;

/**
 * Root resource (exposed at "empresa" path)
 */
@Path("empresa")
@RequestScoped

public class EmpresaResource {
    
    private EmpresaService service = new EmpresaService();

    /**
     * Metodo que retorna os dados da empresa
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")

    public Response get() {
    
        Empresa empresa = service.criarEmpresa();
       
        return Response.ok(empresa).build();
    }    

}


// APENAS COMENTARIOS ABAIXO

    /**
     * METODO DE MOCK PARA TESTE.
     * @return String that will be returned as a text/plain response.
     */
    // @GET
    // @Path("mock")
    // @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")

    // public Response getMock() {
    
    //     Empresa empresa = new Empresa();
    //     empresa.setId(UUID.randomUUID());
    //     empresa.setNome("Minha Empresa");
    //     Endereco endereco = new Endereco();
    //     endereco.setBairro("Limoeiro");
    //     endereco.setCidade("Bauru");
    //     endereco.setEstado("São Paulo");
    //     endereco.setLogradouro("Rua do Jaú");
    //     endereco.setNumero(10);
    //     Telefone telefone = new Telefone();
    //     telefone.setDdd(61);
    //     telefone.setNumero(998368149);
    //     empresa.setEndereco(endereco);
    //     empresa.setTelefone(telefone);
    //     return Response.ok(empresa).build();
    // }    

//     @GET
// 	@Path("mock/endereco")
// 	public Response get(@PathParam("endereco") String bairro) {
// 		Endereco end = new Endereco();
//         end.setBairro("Aguas");
// 		return Response.ok(end).build();

//    }
  