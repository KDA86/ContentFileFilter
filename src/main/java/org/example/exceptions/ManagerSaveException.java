package org.example.exceptions;

import java.io.IOException;

public class ManagerSaveException extends IOException {
    public ManagerSaveException(final String message) {
        super(message);
    }

    public String getMessage(){
        return getMessage();
    }
}
