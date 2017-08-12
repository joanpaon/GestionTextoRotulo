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
package org.japo.java.controllers;

import java.util.Properties;
import org.japo.java.models.Model;
import org.japo.java.interfaces.IDataAccessController;
import org.japo.java.libraries.UtilesApp;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DataAccessControllerPRP implements IDataAccessController {

    // Fichero Propiedades > Modelo
    @Override
    public void importarModelo(Model model, String fichero) throws Exception {
        // Fichero Propiedades > Propiedades
        Properties prp = UtilesApp.cargarPropiedades(fichero);

        // Propiedades > Modelo
        convertirPropiedadesModelo(prp, model);
    }

    // Modelo > Fichero Propiedades
    @Override
    public void exportarModelo(Model model, String fichero) throws Exception {
        // Propiedades
        Properties prp = new Properties();

        // Modelo > Propiedades
        convertirModeloPropiedades(model, prp);

        // Propiedades > Fichero Propiedades
        UtilesApp.guardarPropiedades(prp, fichero);
    }

    // Propiedades > Modelo
    private void convertirPropiedadesModelo(Properties prp, Model model) {
        // Texto
        model.setTexto(prp.getProperty("rotulo.texto", Model.DEF_TEXTO));

        // Familia
        model.setFamilia(prp.getProperty("rotulo.familia", Model.DEF_FAMILIA));

        // Estilo
        model.setNegrita(prp.getProperty("rotulo.negrita", Model.DEF_NEGRITA + "").equals("true"));
        model.setCursiva(prp.getProperty("rotulo.cursiva", Model.DEF_CURSIVA + "").equals("true"));

        // Talla
        try {
            model.setTalla(Integer.parseInt(prp.getProperty("rotulo.talla")));
        } catch (NumberFormatException e) {
            model.setTalla(Model.DEF_TALLA);
        }

        // Color de Frente
        try {
            model.setFrenteR(Integer.parseInt(prp.getProperty("rotulo.frente_r")));
            model.setFrenteV(Integer.parseInt(prp.getProperty("rotulo.frente_v")));
            model.setFrenteA(Integer.parseInt(prp.getProperty("rotulo.frente_a")));
        } catch (NumberFormatException e) {
            model.setFrenteR(Model.DEF_FRENTE_R);
            model.setFrenteV(Model.DEF_FRENTE_V);
            model.setFrenteA(Model.DEF_FRENTE_A);
        }

        // Color de Fondo
        try {
            model.setFondoR(Integer.parseInt(prp.getProperty("rotulo.fondo_r")));
            model.setFondoV(Integer.parseInt(prp.getProperty("rotulo.fondo_v")));
            model.setFondoA(Integer.parseInt(prp.getProperty("rotulo.fondo_a")));
        } catch (NumberFormatException e) {
            model.setFondoR(Model.DEF_FONDO_R);
            model.setFondoV(Model.DEF_FONDO_V);
            model.setFondoA(Model.DEF_FONDO_A);
        }
    }

    // Modelo > Propiedades
    private void convertirModeloPropiedades(Model model, Properties prp) {
        prp.setProperty("rotulo.texto", model.getTexto());
        prp.setProperty("rotulo.familia", model.getFamilia());
        prp.setProperty("rotulo.negrita", model.isNegrita() + "");
        prp.setProperty("rotulo.cursiva", model.isCursiva() + "");
        prp.setProperty("rotulo.talla", model.getTalla() + "");
        prp.setProperty("rotulo.frente_r", model.getFrenteR() + "");
        prp.setProperty("rotulo.frente_v", model.getFrenteV() + "");
        prp.setProperty("rotulo.frente_a", model.getFrenteA() + "");
        prp.setProperty("rotulo.fondo_r", model.getFondoR() + "");
        prp.setProperty("rotulo.fondo_v", model.getFondoV() + "");
        prp.setProperty("rotulo.fondo_a", model.getFondoA() + "");
    }
}
