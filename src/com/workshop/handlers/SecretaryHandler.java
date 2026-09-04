package com.workshop.handlers;

import com.workshop.chain.Handler;
import com.workshop.chain.Request;

public class SecretaryHandler extends Handler {

    public void handleRequest(Request request) {
        System.out.println("Secretary received the request: " + request.getDescription());

        if (request.getType().equals("certificate_request")) {
            System.out.println("Secretary solved the request.");
        } else {
            System.out.println("Secretary cannot solve this. Passing to the next handler.");
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("No more handlers available. Request not solved.");
            }
        }
    }
}