package com.nipsters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nipsters.model.Aso;
import com.nipsters.model.Collaborator;
import com.nipsters.model.TypeASO;

public class AsoDAO {

    public Aso get(long key){
        Aso obj = null;
        PreparedStatement sql = conn.prepareStatement("SELECT * FROM asos WHERE number=?");
        sql.setLong(1, key);
        ResultSet results = sql.executeQuery();

        Collaborator collab = CollaboratorDAO.getInstance().get(results.getLong("id_collab"));
        LocalDate dated = LocalDate.parse(results.getString("dated"));
        TypeASO type = TypeASO.valueOf(results.getInt("type"));

        obj = new Aso(key, collab, type, dated);
        return obj;
    }
}