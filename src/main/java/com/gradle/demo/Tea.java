package com.gradle.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//@Controller
//@Service

public class Tea implements HotDrink {
    @Override
    public String prepareHotDrink() {
        return "Prepared Tea";
    }


}
