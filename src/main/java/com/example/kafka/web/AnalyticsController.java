package com.example.kafka.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AnalyticsController {

    @GetMapping("/")
    public String dashboard(Model model) {
        // Ajouter des données au modèle
        model.addAttribute("appName", "Kafka Streams Demo");
        model.addAttribute("status", "Running");
        model.addAttribute("topics", new String[]{"input-topic", "output-topic", "word-count-output"});
        return "dashboard";
    }
}