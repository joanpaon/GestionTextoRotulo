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

import java.awt.Color;
import java.awt.Font;
import java.util.Properties;
import org.japo.java.entities.Model;
import org.japo.java.forms.View;
import org.japo.java.lib.UtilesApp;
import org.japo.java.lib.UtilesSwing;
import org.japo.java.interfaces.IDataAccess;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class MainController {

    // Referencia al GUI
    private final View gui;

    // Propiedades APP
    private final Properties prpApp;

    // Referencia al Modelo
    private final Model model;

    // Controlador de Modelo
    private final ModelController modelController;

    // Controlador de Persistencia
    private final IDataAccess dataAccessController;

    // Controlador de Eventos
    private final EventsController eventsController;

    // Constructor Parametrizado
    public MainController(Model modelo, View gui) {
        this.model = modelo;
        this.gui = gui;

        // Propiedades App
        this.prpApp = UtilesApp.cargarPropiedades();

        // Controlador de Modelo
        this.modelController = new ModelController(this);

        // Controlador de Persistencia
        this.dataAccessController = new DAControllerJSON(this);

        // Controlador de Eventos
        this.eventsController = new EventsController(this);
    }

    public View getGui() {
        return gui;
    }

    public Properties getPrpApp() {
        return prpApp;
    }

    public Model getModel() {
        return model;
    }

    public ModelController getModelController() {
        return modelController;
    }

    public IDataAccess getDataAccessController() {
        return dataAccessController;
    }

    public EventsController getEventsController() {
        return eventsController;
    }

    // Estado Actual > Persistencia
    public void memorizarEstadoApp() {
        // Memoriza Estado Actual

        // Guardar Estado Actual
        // UtilesApp.guardarPropiedades(prpApp);
    }

    // Interfaz > Modelo
    public void sincronizarInterfazModelo() {

//        // Item 1
//        if (UtilesValidacion.validarDato(
//            txfItem1.getText(), Modelo.ER_ITEM1)) {
//            modelo.setItem1(txfItem1.getText());
//        } else {
//            modelo.setItem1(Modelo.DEF_ITEM1);
//        }
//
//        // Item 2
//        if (UtilesValidacion.validarDato(
//            txfItem2.getText(), Modelo.ER_ITEM2)) {
//            modelo.setItem2(txfItem2.getText());
//        } else {
//            modelo.setItem2(Modelo.DEF_ITEM2);
//        }
//
//        // Item 3
//        if (UtilesValidacion.validarDato(
//            (String) cbbItem3.getSelectedItem(), Modelo.ER_ITEM3)) {
//            modelo.setItem3((String) cbbItem3.getSelectedItem());
//        } else {
//            modelo.setItem3(Modelo.DEF_ITEM3);
//        }
//
//        // Item 4
//        if (UtilesFecha.validarFecha(txfItem4.getText())) {
//            modelo.setItem4(txfItem4.getText());
//        } else {
//            modelo.setItem4(Modelo.DEF_ITEM4);
//        }
//
//        // Item 5
//        if (UtilesValidacion.validarDato(
//            txfItem5.getText(), Modelo.ER_ITEM5)) {
//            modelo.setItem5(txfItem5.getText());
//        } else {
//            modelo.setItem5(Modelo.DEF_ITEM5);
//        }
    }

    // Interfaz > Modelo
    public void sincronizarModeloInterfaz() {
        // Texto
        getGui().lblRotulo.setText(getModel().getTexto());

        // Campo de texto
        getGui().txfTexto.setText(getModel().getTexto());

        // Fuente
        String familia = getModel().getFamilia();
        int negrita = getModel().isNegrita() ? Font.BOLD : Font.PLAIN;
        int cursiva = getModel().isCursiva() ? Font.ITALIC : Font.PLAIN;
        int talla = getModel().getTalla();
        getGui().lblRotulo.setFont(new Font(familia, negrita + cursiva, talla));

        // Frente
        Color frente = new Color(getModel().getFrenteR(),
              getModel().getFrenteV(), getModel().getFrenteA());
        getGui().lblRotulo.setForeground(frente);

        // Fondo
        Color fondo = new Color(getModel().getFondoR(),
              getModel().getFondoV(), getModel().getFondoA());
        getGui().lblRotulo.setBackground(fondo);
    }

    // Validar Controles Subjetivos
    public boolean comprobarValidez() {
        // Validación Individual
//        boolean item1OK = UtilesValidacion.validarCampoTexto(txfItem1, Modelo.ER_ITEM1, "*");
//        boolean item2OK = UtilesValidacion.validarCampoTexto(txfItem2, Modelo.ER_ITEM2, "*");
//        boolean item4OK = UtilesValidacion.validarCampoFecha(txfItem4, "*");
//        boolean item5OK = UtilesValidacion.validarCampoTexto(txfItem5, Modelo.ER_ITEM5, "*");

        // Validación Conjunta
//        return item1OK && item2OK && item4OK && item5OK;
        return true;
    }

    // Persistencia > Estado Actual
    public void restaurarEstadoApp() {
        // Establece Lnf
        UtilesSwing.establecerLnF(getPrpApp().getProperty("lnf", UtilesSwing.WINDOWS));

        // Activa Singleton
        if (!UtilesApp.activarInstancia(prpApp.getProperty("puerto_bloqueo", UtilesApp.PUERTO_BLOQUEO))) {
            UtilesSwing.terminarPrograma(getGui());
        }

        // Otras propiedades
    }

}
