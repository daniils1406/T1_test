package com.example.test.service.impl;

import com.example.test.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

    @Override
    public Map<Character, Integer> parseData(String input) {
        input = input.toLowerCase().replaceAll("\\s", "");
        List<Character> chars = input.chars().mapToObj(elem -> (char) elem).toList();
        Map<Character, Integer> map = chars.stream().collect(LinkedHashMap::new, (m, k) -> {
            if (m.containsKey(k)) {
                m.put(k, m.get(k) + 1);
            } else {
                m.put(k, 1);
            }
        }, LinkedHashMap::putAll);

        return map.entrySet().stream().sorted((e1, e2) ->
                e2.getValue().compareTo(e1.getValue())
        ).collect(Collectors.toMap(
                Map.Entry::getKey,
                Map.Entry::getValue,
                (v1, v2) -> v1,
                LinkedHashMap::new
        ));
    }
}
