package br.com.juba.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.juba.pos.model.Empresa;

public class EmpresaDAO extends LoadDriver {
    
    //consultar BD pelo ID
    public Empresa getEmpresaById(Long id) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt= conn.prepareStatement("select * from empresa where id=?");
            stmt.setLong(1,id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Empresa e = createEmpresa(rs);
                rs.close();
                return e;
            }
        } finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
       //consultar BD pelo nome
    public Empresa getEmpresaByNome(String nome) throws SQLException{
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt= conn.prepareStatement("select * from empresa where lower(nome) like ?");
            stmt.setString(1,"%" + nome.toLowerCase() +"%");
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                Empresa e = createEmpresa(rs);
                rs.close();
                return e;
            }
        } finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return null;
	}
       //consultar BD e criação de lista de empresas
    public List<Empresa> getEmpresas() throws SQLException{
        List<Empresa> empresas = new ArrayList<>();
        Connection conn = null;
        PreparedStatement stmt = null;
        try {
            conn = getConnection();
            stmt = conn.prepareStatement("select * from empresa");
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                Empresa e = createEmpresa(rs);
                empresas.add(e);
            }
            rs.close();
            return empresas;
        } finally {
            if (stmt != null) {
                stmt.close();
			}
			if (conn != null) {
                conn.close();
			}
		}


    }
       //consultar BD pelo endereço
    public List<Empresa> findByEndereco(String endereco) throws SQLException {
		List<Empresa> empresas = new ArrayList<>();
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = getConnection();
			stmt = conn.prepareStatement("select * from empresa where lower(endereco) like ?");
			stmt.setString(1, "%" + endereco.toLowerCase() +"%");
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				Empresa e = createEmpresa(rs);
				empresas.add(e);
			}
			rs.close();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
		return empresas;
	}
    //metodo para criação do objeto empresa.
    private Empresa createEmpresa(ResultSet rs) throws SQLException {
        Empresa e = new Empresa();
        e.setId(rs.getLong("id"));
        e.setNome(rs.getString("nome"));
        e.setEndereco(rs.getString("endereco"));
        
        return e;
    }
}
