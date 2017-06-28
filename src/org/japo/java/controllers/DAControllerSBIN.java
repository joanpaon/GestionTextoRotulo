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

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import org.japo.java.entities.Model;
import org.japo.java.interfaces.IDataAccess;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DAControllerSBIN implements IDataAccess {

    // Referencia al MainController
    private final MainController controller;

    // Constructor Parametrizado
    public DAControllerSBIN(MainController controller) {
        this.controller = controller;
    }

    // Modelo > Fichero [SBIN]
    @Override
    public void exportarModelo(String fichero) throws Exception {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero))) {
            // Escribe el modelo
            salida.writeObject(controller.getModel());
        }
    }

    // Fichero [SBIN] > Modelo
    @Override
    public void importarModelo(String fichero) throws Exception {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
            // Persistencia Binaria > Modelo Importado
            Model modeloImp = (Model) entrada.readObject();

            // Modelo Importado > Modelo
            controller.getModelController().copiarModelo(modeloImp);
        }
    }
}
