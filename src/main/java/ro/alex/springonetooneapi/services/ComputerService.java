package ro.alex.springonetooneapi.services;

import ro.alex.springonetooneapi.models.dtos.ComputerDTO;

import java.util.List;

public interface ComputerService {

    ComputerDTO createComputer(ComputerDTO computerDTO);

    List<ComputerDTO> getComputers();

    ComputerDTO updateComputer(long id, ComputerDTO computerDTO);

    void deleteComputer(long computerId);


}
