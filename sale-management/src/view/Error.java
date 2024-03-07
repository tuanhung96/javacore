package view;

import javax.swing.*;

public class Error {
    private JPanel ErrorPanel;
    private JLabel errorMessage;

    public JPanel getErrorPanel() {
        return ErrorPanel;
    }

    public void setErrorPanel(JPanel errorPanel) {
        ErrorPanel = errorPanel;
    }

    public JLabel getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(JLabel errorMessage) {
        this.errorMessage = errorMessage;
    }
}
