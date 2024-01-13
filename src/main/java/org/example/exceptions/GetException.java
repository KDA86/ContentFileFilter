package org.example.exceptions;

public class GetException extends Exception{


        public GetException(final String message) {
            super(message);

        }

        public String getDetailMessage() {
            return getMessage();
        }
    }

