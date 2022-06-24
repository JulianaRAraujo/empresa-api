package br.com.juba.pos.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.juba.pos.dao.EmpresaDAO;
import br.com.juba.pos.model.Empresa;

// comunicação entre DAO e View 
@RequestScoped
public class EmpresaService {
  
    private EmpresaDAO db = new EmpresaDAO();
    
    public Empresa getEmpresa(Long id) {
        try {
            return db.getEmpresaById(id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Empresa getEmpresaNome(String nome) {
        try {
            return db.getEmpresaByNome(nome);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
 
    public List<Empresa> findByEndereco(String endereco) {
		try {
			return db.findByEndereco(endereco);
		} catch (SQLException e) {
			return null;
		}
	}


    public List<Empresa> getEmpresas(){
        try {
            List<Empresa> empresas = db.getEmpresas();
            return empresas;
        } catch (Exception e) {
            e.printStackTrace();
            return new ArrayList<Empresa>();
        }
    }
  
}
