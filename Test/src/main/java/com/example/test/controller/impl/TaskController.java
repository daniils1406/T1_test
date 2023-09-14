package com.example.test.controller.impl;

import com.example.test.controller.TaskApi;
import com.example.test.service.TaskService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
public class TaskController implements TaskApi {

    private final TaskService taskService;

    @Override
    public Map<Character, Integer> countStringChars(String input) {
        return taskService.parseData(input);
    }
}
