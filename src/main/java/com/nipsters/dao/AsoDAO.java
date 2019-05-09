package com.nipsters.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nipsters.model.Aso;
import com.nipsters.model.Collaborator;
import com.nipsters.model.TypeASO;

public class AsoDAO {
    
    /* public void write(Aso aso){
        PreparedStatement sql = conn.prepareStatement("INSERT INTO asos (number, id_collab, type, dated) VALUES (?,?,?,?)");
        sql.setLong(1, aso.getNumber());
        sql.setLong(2, aso.getCollaborator().getId());
        sql.setInt(3, aso.getType().getValue());
        sql.setDate(4, Date.valueOf(aso.getDated()));
        sql.executeUpdate();
    } */

    /* public Aso get(long key){
        Aso obj = null;
        PreparedStatement sql = conn.prepareStatement("SELECT * FROM asos WHERE number=?");
        sql.setLong(1, key);
        ResultSet results = sql.executeQuery();

        Collaborator collab = CollaboratorDAO.getInstance().get(results.getLong("id_collab"));
        LocalDate dated = results.getDate("dated").toLocalDate();
        TypeASO type = TypeASO.valueOf(results.getInt("type"));

        obj = new Aso(key, collab, type, dated);
        return obj;
    } */
}