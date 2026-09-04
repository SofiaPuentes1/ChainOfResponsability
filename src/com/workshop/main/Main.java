package com.workshop.main;

import com.workshop.chain.Handler;
import com.workshop.chain.Request;
import com.workshop.handlers.MonitorHandler;
import com.workshop.handlers.TeacherHandler;
import com.workshop.handlers.CoordinatorHandler;
import com.workshop.handlers.SecretaryHandler;
import com.workshop.handlers.DeanHandler;

public class Main {

    public static void main(String[] args) {

        Handler monitor = new MonitorHandler();
        Handler teacher = new TeacherHandler();
        Handler coordinator = new CoordinatorHandler();
        Handler secretary = new SecretaryHandler();
        Handler dean = new DeanHandler();

        monitor.setNext(teacher);
        teacher.setNext(coordinator);
        coordinator.setNext(secretary);
        secretary.setNext(dean);

        Request[] requests = new Request[6];
        requests[0] = new Request("technical_question", "How to compile a Java program");
        requests[1] = new Request("grade_inquiry", "Question about the final exam grade");
        requests[2] = new Request("schedule_change", "Request to change class schedule");
        requests[3] = new Request("certificate_request", "Request for an enrollment certificate");
        requests[4] = new Request("scholarship_request", "Request for a scholarship review");
        requests[5] = new Request("legal_complaint", "Legal complaint against the university");

        for (int i = 0; i < requests.length; i++) {
            System.out.println("----- New request -----");
            monitor.handleRequest(requests[i]);
            System.out.println();
        }
    }
}