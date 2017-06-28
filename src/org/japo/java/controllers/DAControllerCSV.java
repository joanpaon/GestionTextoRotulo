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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import org.japo.java.interfaces.IDataAccess;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DAControllerCSV implements IDataAccess {

    // Referencia al MainController
    private final MainController controller;

    // Constructor Parametrizado
    public DAControllerCSV(MainController controller) {
        this.controller = controller;
    }

    // Modelo > Fichero [CSV]
    @Override
    public void exportarModelo(String fichero) throws Exception {
        // Lectura de un fichero de texto
        try (PrintWriter salida = new PrintWriter(new FileWriter(fichero))) {
            // Modelo > Items
            String[] items = controller.getModelController().asignarModeloItems();

            // Escribe el primer item por separado
            salida.print(items[0]);

            // Separador Items
            String separador = "\\s*,\\s*";

            // Escribe el resto de los items
            for (int i = 1; i < items.length; i++) {
                salida.print(separador + items[i]);
            }
        }
    }

    // Fichero [CSV] > Modelo
    @Override
    public void importarModelo(String fichero) throws Exception {
        // Lectura de un fichero de texto
        try (BufferedReader entrada = new BufferedReader(new FileReader(fichero))) {
            // Linea de texto a leer
            String linea = entrada.readLine();

            // Separador Items
            String separador = "\\s*,\\s*";

            // Fichero > Items
            String[] items = linea.split(separador);

            // Items > Modelo
            controller.getModelController().asignarItemsModelo(items);
        }
    }
}
