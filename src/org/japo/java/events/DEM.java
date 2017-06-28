package org.japo.java.events;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import org.japo.java.forms.GUI;

public class DEM implements DocumentListener {

    // Referencia al Interfaz
    private final GUI gui;

    // Constructor
    public DEM(GUI gui) {
        this.gui = gui;
    }

    @Override
    public void insertUpdate(DocumentEvent e) {
        gui.procesarCambioTexto(e);
    }

    @Override
    public void removeUpdate(DocumentEvent e) {
        gui.procesarCambioTexto(e);
    }

    @Override
    public void changedUpdate(DocumentEvent e) {
        gui.procesarCambioTexto(e);
    }
}
