package org.japo.java.events;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.japo.java.controllers.EventsController;

public class DEM implements DocumentListener {

    // Referencia al EventsController
    private final EventsController eventsController;

    // Constructor
    public DEM(EventsController eventsController) {
        this.eventsController = eventsController;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        eventsController.procesarEventosDocumento(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        eventsController.procesarEventosDocumento(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        eventsController.procesarEventosDocumento(e);
    }
}
