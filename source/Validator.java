/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package passwordtest;

import javax.swing.*;
import javax.swing.text.JTextComponent;

/**
 *
 * @author Huy
 */
public class Validator {

    public Validator() {

    }

    public boolean isPresent(JTextComponent component, String fieldName) {
        if (component.getText().length() == 0) {
            showMessage(component, fieldName + " is a required field.");
            component.requestFocusInWindow();
            return false;
        }
        return true;
    }

    public boolean isInteger(JTextComponent component, String fieldName) {
        try {
            int i = Integer.parseInt(component.getText());
            return true;
        } catch (NumberFormatException e) {
            showMessage(component, fieldName + " must be an integer.");
            component.requestFocusInWindow();
            return false;
        }
    }
    
    public boolean isSelected(ButtonGroup buttonGroup) {
        return (buttonGroup.getSelection() != null);
    }

    private void showMessage(JTextComponent component, String message) {
        JOptionPane.showMessageDialog(component, message, "Invalid Entry",
                JOptionPane.ERROR_MESSAGE);
    }
}
