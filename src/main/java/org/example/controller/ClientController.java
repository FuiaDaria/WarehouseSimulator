package org.example.controller;

import org.example.view.ClientFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.example.view.*;

public class ClientController {
    public ClientController(ClientFrame frame){
        frame.setAddButtonActionListener(new AddButtonActionListener());
        frame.setDeleteButtonActionListener(new DeleteButtonActionListener());
        frame.setViewButtonActionListener(new ViewButtonActionListener());
        frame.setEditButtonActionListener(new EditButtonActionListener());
    }

    private class AddButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new AddClientController(new AddClientFrame());
        }
    }

    private class EditButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new EditClientController(new EditClientFrame());
        }
    }

    private class DeleteButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new DeleteClientController(new DeleteClientFrame());
        }
    }

    private class ViewButtonActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            new ViewClientsController(new ViewClientsFrame());
        }
    }
}
