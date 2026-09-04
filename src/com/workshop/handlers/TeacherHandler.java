package com.workshop.handlers;

import com.workshop.chain.Handler;
import com.workshop.chain.Request;

public class TeacherHandler extends Handler {

    public void handleRequest(Request request) {
        System.out.println("Teacher received the request: " + request.getDescription());

        if (request.getType().equals("grade_inquiry")) {
            System.out.println("Teacher solved the request.");
        } else {
            System.out.println("Teacher cannot solve this. Passing to the next handler.");
            if (next != null) {
                next.handleRequest(request);
            } else {
                System.out.println("No more handlers available. Request not solved.");
            }
        }
    }
}