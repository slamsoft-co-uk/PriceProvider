package org.matsuri.customerservice.external.services;

import org.matsuri.customerservice.external.dao.repositories.DeleteStalePricesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DeleteStalePricesService {

    private DeleteStalePricesRepository deleteStalePricesRepository;

    @Autowired
    public void setDeleteStalePricesRepository(DeleteStalePricesRepository deleteStalePricesRepository) {
        this.deleteStalePricesRepository = deleteStalePricesRepository;
    }

    public int deleteStalePrices(LocalDateTime staleDate) {
        return deleteStalePricesRepository.deleteStaleBooks(staleDate);
    }

}
