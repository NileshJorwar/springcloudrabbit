package com.nilesh.springboottestapp;

import com.nilesh.springboottestapp.LoadRequest.LoadRequest;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class StatusService {

    private Controller controller;
    private StatusServiceFields statusServiceFields;
    private LoadRequest loadRequest;
    StatusService(Controller controller, StatusServiceFields statusServiceFields) {
        this.controller = controller;
        this.statusServiceFields = statusServiceFields;
    }

    @Scheduled(fixedDelay = 1000)
    public void refreshLoad() {
        System.out.println("In refreshLoad method");
        if (statusServiceFields.getAge()==10) {
            int age = statusServiceFields.getAge();
            int id = statusServiceFields.getId();
            String name = loadRequest.getName();
            String newName = "";
            if (name != null)
            {
                newName = " Hi" + name;
                age=10+age;
                id=id+10;
            }
            else
                newName = "Nilesh";
            controller.findAll(age,id,name);
        }
    }
}
