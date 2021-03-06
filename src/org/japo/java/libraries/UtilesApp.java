/* 
 * Copyright 2017 José A. Pacheco Ondoño - joanpaon@gmail.com.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.japo.java.libraries;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.Properties;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class UtilesApp {

    // Fichero de propiedades
    public static final String FICHERO_PRP_APP = "app.properties";

    // Puerto de Bloqueo por Defecto
    public static final String PUERTO_BLOQUEO = "54321";

    // Fichero (Por defecto) > Propiedades    
    public static Properties cargarPropiedades() {
        return cargarPropiedades(FICHERO_PRP_APP);
    }

    // Fichero Propiedades > Objeto Propiedades
    public static Properties cargarPropiedades(String fichero) {
        // Objeto de Propiedades Vacio
        Properties prp = new Properties();

        // Cargar Fichero de Propiedades 
        try (FileReader fr = new FileReader(fichero)) {
            prp.load(fr);
        } catch (Exception e) {
            System.out.println(e);
        }

        // Devolver Propiedades
        return prp;
    }

    // Objeto Propiedades > Fichero Propiedades (Por defecto)
    public static boolean guardarPropiedades(Properties prp) {
        return guardarPropiedades(prp, FICHERO_PRP_APP);
    }

    // Objeto Propiedades > Fichero Propiedades
    public static boolean guardarPropiedades(Properties prp, String fichero) {
        // Semáforo Estado
        boolean procesoOK = false;

        // Guardar Fichero de Propiedades 
        try (FileWriter fw = new FileWriter(fichero)) {
            // Guardar Propiedades
            prp.store(fw, null);

            // Proceso OK
            procesoOK = true;
        } catch (Exception e) {
            System.out.println(e);
        }

        // Devuelve Estado
        return procesoOK;
    }

    // Activa Instancia Única
    public static boolean activarInstancia(Properties prp) {
        // Semaforo Estado
        boolean instanciaOK = false;

        try {
            // Obtener dato
            String dato = prp.getProperty("puerto_bloqueo", PUERTO_BLOQUEO);

            // Puerto de bloqueo
            int puerto = Integer.parseInt(dato);

            // Abre un ServerSocket al puerto de bloqueo
            ServerSocket ss = new ServerSocket(puerto);

            // Marca Semáforo
            instanciaOK = true;
        } catch (IOException | NumberFormatException e) {
            // Mensaje Informativo
            System.out.println(e);
        }

        // Devuelve Estado
        return instanciaOK;
    }

    // Activa Instancia Única
    public static boolean activarInstancia(String txtPuerto) {
        // Semaforo Estado
        boolean instanciaOK = false;

        try {
            // Conversión numérica
            int puerto = Integer.parseInt(txtPuerto);

            // Abre un ServerSocket al puerto de bloqueo
            ServerSocket ss = new ServerSocket(puerto);

            // Marca Semáforo
            instanciaOK = true;
        } catch (IOException | NumberFormatException e) {
            // Mensaje Informativo
            System.out.println(e);
        }

        // Devuelve Estado
        return instanciaOK;
    }
}
