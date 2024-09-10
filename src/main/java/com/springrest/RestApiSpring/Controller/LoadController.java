package com.springrest.RestApiSpring.Controller;

import com.springrest.RestApiSpring.Entity.Load;
import com.springrest.RestApiSpring.Service.LoadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/load")
public class LoadController {
    @Autowired
    private LoadService loadService;

    // POST - Add a new load
    @PostMapping
    public String addLoad(@RequestBody Load loadRequest) {
        loadService.addLoad(loadRequest);
        return "Load details added successfully";
    }

    // GET - Retrieve list of loads by shipperId
    @GetMapping
    public List<Load> getLoadsByShipperId(@RequestParam String shipperId) {
        return loadService.getLoadsByShipperId(UUID.fromString(shipperId));
    }

    // GET - Retrieve a specific load by loadId
    @GetMapping("/{loadId}")
    public Load getLoadById(@PathVariable String loadId) {
        return loadService.getLoadById(UUID.fromString(loadId));
    }

    // PUT - Update a load by loadId
    @PutMapping("/{loadId}")
    public Load updateLoad(@PathVariable String loadId, @RequestBody Load loadRequest) {
        return loadService.updateLoad(UUID.fromString(loadId), loadRequest);
    }

    // DELETE - Delete a load by loadId
    @DeleteMapping("/{loadId}")
    public void deleteLoad(@PathVariable String loadId) {
        loadService.deleteLoad(UUID.fromString(loadId));
    }
}
