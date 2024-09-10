package com.springrest.RestApiSpring.Service;

import com.springrest.RestApiSpring.Entity.Load;

import java.util.List;
import java.util.UUID;

public interface LoadService {
    // Add a new load
    public void addLoad(Load loadRequest);

    // Retrieve a list of loads by shipperId
    public List<Load> getLoadsByShipperId(UUID shipperId);

    // Retrieve a specific load by its ID
    public Load getLoadById(UUID loadId);

    // Update an existing load
    public Load updateLoad(UUID loadId, Load loadRequest);

    // Delete a load by its ID
    public void deleteLoad(UUID loadId);
}
