package com.example.sellions.controller;

import com.example.sellions.Exceptions.SupportingRuntimeError;
import com.example.sellions.dao.entity.Parameter;
import com.example.sellions.service.ParameterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import static com.example.sellions.Exceptions.ExceptionMessagesLibrary.YOU_SHOULD_POINT_NAME;

@RestController
@RequestMapping("/sellionsParameter")

public class ParameterController {


    private ParameterService parameterService;

    @Autowired
    public ParameterController(ParameterService parameterService){
        this.parameterService = parameterService;
    }

    @PostMapping("/postParameter/{index}")
    public void addParameter(@PathVariable long index,@RequestBody Parameter parameter){
        try {
            parameterService.save(index,parameter);
        }catch(RuntimeException ex){
            throw new SupportingRuntimeError(YOU_SHOULD_POINT_NAME);
        }
    }


}
