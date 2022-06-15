package br.com.juba.pos.service;

import java.sql.SQLException;

import org.glassfish.jersey.process.internal.RequestScoped;

import br.com.juba.pos.dao.EmpresaDAO;
import br.com.juba.pos.model.Empresa;


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
  
}
