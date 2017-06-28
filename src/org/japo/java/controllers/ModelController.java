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
import org.japo.java.entities.Model;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class ModelController {

    // Referencia al MainController
    private final MainController controller;

    // Constructor Parametrizado
    public ModelController(MainController controller) {
        this.controller = controller;
    }

    // Items > Modelo
    public void asignarItemsModelo(String[] items) throws Exception {
        // Texto
        controller.getModel().setTexto(items[Model.POS_TEXTO]);

        // Familia
        controller.getModel().setFamilia(items[Model.POS_FAMILIA]);

        // Estilo
        controller.getModel().setNegrita(items[Model.POS_NEGRITA].toLowerCase().equals("true"));
        controller.getModel().setCursiva(items[Model.POS_CURSIVA].toLowerCase().equals("true"));

        // Talla
        try {
            controller.getModel().setTalla(Integer.parseInt(items[Model.POS_TALLA]));
        } catch (NumberFormatException e) {
            controller.getModel().setTalla(Model.DEF_TALLA);
        }

        // Frente
        try {
            controller.getModel().setFrenteR(Integer.parseInt(items[Model.POS_FRENTE_R]));
            controller.getModel().setFrenteV(Integer.parseInt(items[Model.POS_FRENTE_V]));
            controller.getModel().setFrenteA(Integer.parseInt(items[Model.POS_FRENTE_A]));
        } catch (NumberFormatException e) {
            controller.getModel().setFrenteR(Model.DEF_FRENTE_R);
            controller.getModel().setFrenteV(Model.DEF_FRENTE_V);
            controller.getModel().setFrenteA(Model.DEF_FRENTE_A);
        }

        // Fondo
        try {
            controller.getModel().setFondoR(Integer.parseInt(items[Model.POS_FONDO_R]));
            controller.getModel().setFondoV(Integer.parseInt(items[Model.POS_FONDO_V]));
            controller.getModel().setFondoA(Integer.parseInt(items[Model.POS_FONDO_A]));
        } catch (NumberFormatException e) {
            controller.getModel().setFondoR(Model.DEF_FONDO_R);
            controller.getModel().setFondoV(Model.DEF_FONDO_V);
            controller.getModel().setFondoA(Model.DEF_FONDO_A);
        }
    }

    // Modelo > Items
    public String[] asignarModeloItems() {
        // Lista vacía
        String[] items = new String[Model.NUM_ITEMS];

        // Items > Lista
        items[Model.POS_TEXTO] = controller.getModel().getTexto();
        items[Model.POS_FAMILIA] = controller.getModel().getFamilia();
        items[Model.POS_NEGRITA] = controller.getModel().isNegrita() + "";
        items[Model.POS_CURSIVA] = controller.getModel().isCursiva() + "";
        items[Model.POS_TALLA] = controller.getModel().getTalla() + "";
        items[Model.POS_FRENTE_R] = controller.getModel().getFrenteR() + "";
        items[Model.POS_FRENTE_V] = controller.getModel().getFrenteV() + "";
        items[Model.POS_FRENTE_A] = controller.getModel().getFrenteA() + "";
        items[Model.POS_FONDO_R] = controller.getModel().getFondoR() + "";
        items[Model.POS_FONDO_V] = controller.getModel().getFondoV() + "";
        items[Model.POS_FONDO_A] = controller.getModel().getFondoA() + "";

        // Devuelve Lista
        return items;
    }

    // Copiar Estado Modelo
    public void copiarModelo(Model modeloRef) {
        // Texto
        controller.getModel().setTexto(modeloRef.getTexto());

        // Familia
        controller.getModel().setFamilia(modeloRef.getFamilia());

        // Estilo
        controller.getModel().setNegrita(modeloRef.isNegrita());
        controller.getModel().setCursiva(modeloRef.isCursiva());

        // Tamaño
        controller.getModel().setTalla(modeloRef.getTalla());

        // Color Frente
        controller.getModel().setFrenteR(modeloRef.getFrenteR());
        controller.getModel().setFrenteV(modeloRef.getFrenteV());
        controller.getModel().setFrenteA(modeloRef.getFrenteA());

        // Color Fondo
        controller.getModel().setFondoR(modeloRef.getFondoR());
        controller.getModel().setFondoV(modeloRef.getFondoV());
        controller.getModel().setFondoA(modeloRef.getFondoA());
    }

    public void asignarItemsModelo(Properties prp) {
        // Texto
        controller.getModel().setTexto(prp.getProperty("rotulo.texto", Model.DEF_TEXTO));

        // Familia
        controller.getModel().setFamilia(prp.getProperty("rotulo.familia", Model.DEF_FAMILIA));

        // Estilo
        controller.getModel().setNegrita(prp.getProperty("rotulo.negrita", Model.DEF_NEGRITA + "").equals("true"));
        controller.getModel().setCursiva(prp.getProperty("rotulo.cursiva", Model.DEF_CURSIVA + "").equals("true"));

        // Talla
        try {
            controller.getModel().setTalla(Integer.parseInt(prp.getProperty("rotulo.talla")));
        } catch (NumberFormatException e) {
            controller.getModel().setTalla(Model.DEF_TALLA);
        }

        // Color de Frente
        try {
            controller.getModel().setFrenteR(Integer.parseInt(prp.getProperty("rotulo.frente_r")));
            controller.getModel().setFrenteV(Integer.parseInt(prp.getProperty("rotulo.frente_v")));
            controller.getModel().setFrenteA(Integer.parseInt(prp.getProperty("rotulo.frente_a")));
        } catch (NumberFormatException e) {
            controller.getModel().setFrenteR(Model.DEF_FRENTE_R);
            controller.getModel().setFrenteV(Model.DEF_FRENTE_V);
            controller.getModel().setFrenteA(Model.DEF_FRENTE_A);
        }

        // Color de Fondo
        try {
            controller.getModel().setFondoR(Integer.parseInt(prp.getProperty("rotulo.fondo_r")));
            controller.getModel().setFondoV(Integer.parseInt(prp.getProperty("rotulo.fondo_v")));
            controller.getModel().setFondoA(Integer.parseInt(prp.getProperty("rotulo.fondo_a")));
        } catch (NumberFormatException e) {
            controller.getModel().setFondoR(Model.DEF_FONDO_R);
            controller.getModel().setFondoV(Model.DEF_FONDO_V);
            controller.getModel().setFondoA(Model.DEF_FONDO_A);
        }
    }

    // Modelo > Propiedades
    public Properties generarPropiedadesModelo() {
        // Instancia Propiedades
        Properties prp = new Properties();

        // Escribe Propiedades
        prp.setProperty("rotulo.texto", controller.getModel().getTexto());
        prp.setProperty("rotulo.familia", controller.getModel().getFamilia());
        prp.setProperty("rotulo.negrita", controller.getModel().isNegrita() + "");
        prp.setProperty("rotulo.cursiva", controller.getModel().isCursiva() + "");
        prp.setProperty("rotulo.talla", controller.getModel().getTalla() + "");
        prp.setProperty("rotulo.frente_r", controller.getModel().getFrenteR() + "");
        prp.setProperty("rotulo.frente_v", controller.getModel().getFrenteV() + "");
        prp.setProperty("rotulo.frente_a", controller.getModel().getFrenteA() + "");
        prp.setProperty("rotulo.fondo_r", controller.getModel().getFondoR() + "");
        prp.setProperty("rotulo.fondo_v", controller.getModel().getFondoV() + "");
        prp.setProperty("rotulo.fondo_a", controller.getModel().getFondoA() + "");

        // Devuelve Propiedades
        return prp;
    }

}
