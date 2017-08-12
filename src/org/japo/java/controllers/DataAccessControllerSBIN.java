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
import org.japo.java.models.Model;
import org.japo.java.interfaces.IDataAccessController;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class DataAccessControllerSBIN implements IDataAccessController {

    // Fichero SBIN > Modelo
    @Override
    public void importarModelo(Model model, String fichero) throws Exception {
        try (ObjectInputStream entrada = new ObjectInputStream(new FileInputStream(fichero))) {
            // Fichero SBIN > Modelo (Importado)
            Model modelClon = (Model) entrada.readObject();

            // Modelo (Importado) > Modelo
            convertirModeloModelo(modelClon, model);
        }
    }

    // Modelo > Fichero SBIN
    @Override
    public void exportarModelo(Model model, String fichero) throws Exception {
        try (ObjectOutputStream salida = new ObjectOutputStream(new FileOutputStream(fichero))) {
            // Modelo > Fichero SBIN
            salida.writeObject(model);
        }
    }

    // Modelo > Modelo
    private void convertirModeloModelo(Model modeloIni, Model modeloFin) {
        // Texto
        modeloFin.setTexto(modeloIni.getTexto());

        // Familia
        modeloFin.setFamilia(modeloIni.getFamilia());

        // Estilo
        modeloFin.setNegrita(modeloIni.isNegrita());
        modeloFin.setCursiva(modeloIni.isCursiva());

        // Tamaño
        modeloFin.setTalla(modeloIni.getTalla());

        // Color Frente
        modeloFin.setFrenteR(modeloIni.getFrenteR());
        modeloFin.setFrenteV(modeloIni.getFrenteV());
        modeloFin.setFrenteA(modeloIni.getFrenteA());

        // Color Fondo
        modeloFin.setFondoR(modeloIni.getFondoR());
        modeloFin.setFondoV(modeloIni.getFondoV());
        modeloFin.setFondoA(modeloIni.getFondoA());
    }
}
