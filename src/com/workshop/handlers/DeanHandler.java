package com.workshop.handlers;

import com.workshop.chain.Handler;
import com.workshop.chain.Request;

public class DeanHandler extends Handler {

    public void handleRequest(Request request) {
        System.out.println("Dean received the request: " + request.getDescription());

        if (request.getType().equals("scholarship_request")) {
            System.out.println("Dean solved the request.");
        } else {
            System.out.println("Dean cannot solve this and there is no one else in the chain.");
            System.out.println("Request not solved: " + request.getDescription());
        }
    }
}