/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Baseconfiguracion;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelos.BasePropiedadesModel;

public class clsPropiedades {
    // utilizando los datos del archivo de propiedades 
    //private static final String pathConfiguracion="C:\\Users\\FERCAMPOS\\Desktop\\universidad quinto semestre\\programacion 3\\parcial 2\\tareas\\checha programa listas\\ejemploListas\\build\\classes\\configuracion\\configuracion.properties";
    private static final String pathConfiguracion="C:\\Users\\FERCAMPOS\\Desktop\\universidad quinto semestre\\programacion 3\\parcial 2\\tareas\\ejemploListas\\src\\Baseconfiguracion\\configuracion.properties";
    public BasePropiedadesModel cargarPropiedad(){
        BasePropiedadesModel prop = new BasePropiedadesModel();
        Properties p = new Properties();
        try {
            p.load(new FileReader(pathConfiguracion));
        } catch (FileNotFoundException ex) {
            Logger.getLogger(clsPropiedades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(clsPropiedades.class.getName()).log(Level.SEVERE, null, ex);
        }
        prop.setBasedatos(p.getProperty("BaseDatos"));
        prop.setUsuario(p.getProperty("usuario"));
        prop.setClave(p.getProperty("clave"));
        //retornamos la base de datos el ususario y la contrasena
        return prop;
    } 
}
