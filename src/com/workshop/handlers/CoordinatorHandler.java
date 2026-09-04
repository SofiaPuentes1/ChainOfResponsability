package com.workshop.handlers;

import com.workshop.chain.Handler;
import com.workshop.chain.Request;

public class CoordinatorHandler extends Handler {

    public void handleRequest(Request request) {
        System.out.println("Coordinator received the request: " + request.getDescription());

        if (request.getType().equals("schedule_change")) {
            System.out.println("Coordinator solved the request.");
        } else {
            System.out.println("Coordinator cannot solve this. Passing to the next handler.");
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("No more handlers available. Request not solved.");
            }
        }
    }
}