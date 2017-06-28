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

import java.awt.event.ActionEvent;
import java.awt.event.WindowEvent;
import javax.swing.JOptionPane;
import javax.swing.event.DocumentEvent;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class EventsController {

    // Referencia al MainController
    private final MainController controller;

    // Constructor Parametrizado
    public EventsController(MainController controller) {
        this.controller = controller;
    }

    // Evento de Ventana - Cerrando
    public void procesarCierreVentana(WindowEvent e) {
        // Memorizar Estado Actual
        controller.memorizarEstadoApp();

        // Otros Procesos de Cierre    
    }

    // Evento de Acción - Cargar Datos
    public void procesarImportacion(ActionEvent evt) {
        try {
            // Fichero de Datos
            String fichero = controller.getPrpApp().getProperty("fichero_datos");

            // Persistencia > Modelo
            controller.getDataAccessController().importarModelo(fichero);

            // Modelo > Interfaz
            controller.sincronizarModeloInterfaz();

            // Validar Datos Cargados > Interfaz
            controller.comprobarValidez();

            // Mensaje - Importación OK
            String msg = "Datos cargados correctamente";
            JOptionPane.showMessageDialog(controller.getGui(), msg);
        } catch (Exception e) {
            // Mensaje - Importación NO
            String msg = "Error al cargar los datos";
            JOptionPane.showMessageDialog(controller.getGui(), msg);
        }
    }

    // Interfaz > Modelo > Persistencia
    public void procesarExportacion(ActionEvent evt) {
        // Validar Datos Interfaz
        if (controller.comprobarValidez()) {
            try {
                // Interfaz > Modelo
                controller.sincronizarInterfazModelo();

                // Fichero de Datos
                String fichero = controller.getPrpApp().getProperty("fichero_datos");

                // Modelo > Persistencia
                controller.getDataAccessController().exportarModelo(fichero);

                // Mensaje - Exportación OK
                String msg = "Datos guardados correctamente";
                JOptionPane.showMessageDialog(controller.getGui(), msg);
            } catch (Exception e) {
                // Mensaje - Exportación NO
                String msg = "Error al guardar los datos";
                JOptionPane.showMessageDialog(controller.getGui(), msg);
            }
        } else {
            // Mensaje - Validación Pendiente
            JOptionPane.showMessageDialog(controller.getGui(), "Hay datos erróneos.");
        }
    }

    private void procesarFamilia() {
        // Interfaz > modelo
//        modelo.setFamilia((String) controller.getGui().cbbFamilia.getSelectedItem());

        // Modelo > Interfaz
        controller.sincronizarModeloInterfaz();
    }

    // Cambios en un Campo de Texto
    public void procesarEventosDocumento(DocumentEvent e) {
        // Campo de Texto > Modelo
        controller.getModel().setTexto(controller.getGui().txfTexto.getText());

        // Campo de Texto > Etiqueta
        controller.getGui().lblRotulo.setText(controller.getGui().txfTexto.getText());
    }
}
