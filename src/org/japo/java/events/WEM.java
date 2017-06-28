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
package org.japo.java.events;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import org.japo.java.controllers.EventsController;

/**
 *
 * @author José A. Pacheco Ondoño - joanpaon@gmail.com
 */
public class WEM extends WindowAdapter {

    // Referencia al EventsController
    private final EventsController eventsController;

    // Constructor
    public WEM(EventsController eventsController) {
        this.eventsController = eventsController;
    }

    // Cierre Iniciado
    @Override
    public void windowClosing(WindowEvent e) {

    }
}
