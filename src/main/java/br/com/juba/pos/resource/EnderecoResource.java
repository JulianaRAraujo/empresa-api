package br.com.juba.pos.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.juba.pos.model.Endereco;
import br.com.juba.pos.service.EnderecoService;

@Path("endereco")
@RequestScoped


public class EnderecoResource {
    private EnderecoService service = new EnderecoService();

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")    
    public Response get() {
    
        Endereco endereco = service.criarEndereco();
       
        return Response.ok(endereco).build();
    }   
}
