package com.thepcenter.controller;
import com.thepcenter.service.DreamService;
import com.thepcenter.model.Dream;
import com.thepcenter.model.Patient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/dreams")
public class DreamController {

    @Autowired
    private DreamService dreamService;

    @PostMapping("/register")
    public Dream register(@RequestParam int duration,
                          @RequestParam String intensity,
                          @RequestParam String clarity) {
        return dreamService.registerDream(duration, intensity, clarity);
    }

    @PostMapping("/clone/{index}")
    public Dream cloneDream(@PathVariable int index) {
        return dreamService.cloneDream(index);
    }

    @GetMapping("/all")
    public Patient getPatientDreams() {
        return dreamService.getPatient();
    }
}
