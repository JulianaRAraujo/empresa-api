package br.com.juba.pos.resource;

import java.util.List;

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
     *retorna dados  da empresa pelo id
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Path("/id/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response get(@PathParam("id")long id) {
        Empresa empresa = service.getEmpresa(id);
        return Response.ok(empresa).build();
    }

    //retorna dados  da empresa pelo nome
    @GET
    @Path("/nome/{nome}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response get(@PathParam("nome")String nome) {
        Empresa empresa = service.getEmpresaNome(nome);
        return Response.ok(empresa).build();
    }
    // retorna dados  da empresa pelo endereço
    @GET
	@Path("/endereco/{endereco}")
	public List<Empresa> getByNome(@PathParam("endereco") String endereco) {
		List<Empresa> empresas = service.findByEndereco(endereco);
		return empresas;
	}
 
    /**
     * Metodo que retorna lista das empresas.
     * @return String that will be returned as a text/plain response.
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    public Response get() {
       List<Empresa> empresas = service.getEmpresas();
        return Response.ok(empresas).build();
    }
}
  