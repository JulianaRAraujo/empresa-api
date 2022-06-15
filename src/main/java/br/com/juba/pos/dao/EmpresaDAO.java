package br.com.juba.pos.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


import br.com.juba.pos.model.Empresa;

public class EmpresaDAO extends LoadDriver {
    
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

    public Empresa createEmpresa(ResultSet rs) throws SQLException {
		Empresa e = new Empresa();
		e.setId(rs.getLong("id"));
        e.setNome(rs.getString("nome"));
        e.setEndereco(rs.getString("endereco"));
		
		return e;
	}
}
