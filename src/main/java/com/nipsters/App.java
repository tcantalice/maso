package com.nipsters;

import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import com.nipsters.dao.Datasource;
import com.nipsters.view.*;

public class App 
{
    public static void main( String[] args )
    {
        /*
            Database initializer
        */
        Datasource.init();

        try{
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        }catch(Exception e){
            e.printStackTrace();
        }
        (new TelaPrincipal()).setVisible(true);;
    }
}
