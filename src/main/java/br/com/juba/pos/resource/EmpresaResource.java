package br.com.juba.pos.resource;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.juba.pos.model.Empresa;
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
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response get(@PathParam("id")long id) {
        Empresa empresa = service.getEmpresa(id);
        return Response.ok(empresa).build();
    }  
}
  