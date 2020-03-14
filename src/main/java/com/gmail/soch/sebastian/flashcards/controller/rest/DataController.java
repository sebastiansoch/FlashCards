/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gmail.soch.sebastian.flashcards.controller.rest;

import com.gmail.soch.sebastian.flashcards.restdata.RestData;
import java.util.Random;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ssoch
 */
@RestController
public class DataController {

    @RequestMapping(value = "/restdata", method = RequestMethod.GET)
    public RestData getRestData() {
        Random random = new Random();
        return new RestData(random.nextInt(1000), "Seba");
    }
}
