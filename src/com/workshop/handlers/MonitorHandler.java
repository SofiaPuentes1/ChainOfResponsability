package com.workshop.handlers;

import com.workshop.chain.Handler;
import com.workshop.chain.Request;

public class MonitorHandler extends Handler {

    public void handleRequest(Request request) {
        System.out.println("Monitor received the request: " + request.getDescription());

        if (request.getType().equals("technical_question")) {
            System.out.println("Monitor solved the request.");
        } else {
            System.out.println("Monitor cannot solve this. Passing to the next handler.");
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("No more handlers available. Request not solved.");
            }
        }
    }
} 