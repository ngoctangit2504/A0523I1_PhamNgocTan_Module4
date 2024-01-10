package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.LinkedHashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private static final Map<String, String> list = new LinkedHashMap<>();
    static {
        list.put("hello", "Xin Chào");
        list.put("father", "Bố");
        list.put("mother", "Mẹ");
        list.put("thank", "Cảm Ơn");
        list.put("sorry", "Xin lỗi");
        list.put("good", "Tốt");
    }


    @GetMapping("/")
    public String showHome(){
        return "home";
    }

    @PostMapping("/translate")
    public String showResult(@RequestParam String english, Model model) {
        String vietnamese = null;
        for (Map.Entry<String, String> entry: list.entrySet()) {
            if (entry.getKey().equals(english.toLowerCase())) {
                vietnamese = entry.getValue();
                break;
            }
        }
        if (vietnamese == null) {
            vietnamese = "keyword not found !";
        }
        model.addAttribute("vietnamese", vietnamese);
        return "home";
    }
}
