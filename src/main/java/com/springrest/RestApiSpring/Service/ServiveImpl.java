package com.springrest.RestApiSpring.Service;

import com.springrest.RestApiSpring.Db.LoadDao;
import com.springrest.RestApiSpring.Entity.Load;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
class ServiceImpl implements LoadService {

    @Autowired
    private LoadDao loadDao;

    // Add a new load
    @Override
    public void addLoad(Load loadRequest) {
        loadDao.save(loadRequest);  // Save the load to the database
    }

    // Retrieve a list of loads by shipperId
    @Override
    public List<Load> getLoadsByShipperId(UUID shipperId) {
        return loadDao.findByShipperId(shipperId);  // Use a custom query to find loads by shipperId
    }

    // Retrieve a specific load by loadId
    @Override
    public Load getLoadById(UUID loadId) {
        Optional<Load> load = loadDao.findById(loadId);
        return load.orElse(null);  // Return the load if found, otherwise return null
    }

    // Update an existing load
    @Override
    public Load updateLoad(UUID loadId, Load loadRequest) {
        Optional<Load> existingLoad = loadDao.findById(loadId);
        if (existingLoad.isPresent()) {
            Load loadToUpdate = existingLoad.get();
            loadToUpdate.setLoadingPoint(loadRequest.getLoadingPoint());
            loadToUpdate.setUnloadingPoint(loadRequest.getUnloadingPoint());
            loadToUpdate.setProductType(loadRequest.getProductType());
            loadToUpdate.setTruckType(loadRequest.getTruckType());
            loadToUpdate.setNoOfTrucks(loadRequest.getNoOfTrucks());
            loadToUpdate.setWeight(loadRequest.getWeight());
            loadToUpdate.setComment(loadRequest.getComment());
            loadToUpdate.setDate(loadRequest.getDate());
            return loadDao.save(loadToUpdate);  // Save the updated load and return it
        }
        return null;  // If load is not found, return null
    }

    // Delete a load by loadId
    @Override
    public void deleteLoad(UUID loadId) {
        loadDao.deleteById(loadId);  // Delete the load by its ID
    }
}
