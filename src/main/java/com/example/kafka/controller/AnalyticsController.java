package com.example.kafka.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Controller
public class AnalyticsController {

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("appName", "Kafka Streams Demo");
        model.addAttribute("status", "Running");
        return "dashboard";
    }

    @GetMapping("/api/status")
    @ResponseBody
    public Map<String, Object> getStatus() {
        Map<String, Object> status = new HashMap<>();
        status.put("application", "Kafka Streams Demo");
        status.put("status", "Running");
        status.put("topics", new String[]{"input-topic", "output-topic", "word-count-output"});
        status.put("timestamp", System.currentTimeMillis());
        return status;
    }
}