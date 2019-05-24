package com.nipsters;

import javax.swing.UIManager;
import de.javasoft.plaf.synthetica.SyntheticaPlainLookAndFeel;

import com.nipsters.view.*;

public class App 
{
    public static void main( String[] args )
    {
        try{
            UIManager.setLookAndFeel(new SyntheticaPlainLookAndFeel());
        }catch(Exception e){
            e.printStackTrace();
        }
        (new TelaPrincipal()).show();
    }
}
