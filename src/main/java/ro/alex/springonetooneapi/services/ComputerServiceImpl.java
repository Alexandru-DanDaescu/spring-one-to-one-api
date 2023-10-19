package ro.alex.springonetooneapi.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ro.alex.springonetooneapi.models.dtos.ComputerDTO;
import ro.alex.springonetooneapi.models.entities.Computer;
import ro.alex.springonetooneapi.repositories.ComputerRepository;


import java.util.ArrayList;
import java.util.List;


@Slf4j
@Service
public class ComputerServiceImpl implements ComputerService{


    private final ComputerRepository computerRepository;

    private ObjectMapper objectMapper;

    public ComputerServiceImpl(ComputerRepository computerRepository, ObjectMapper objectMapper){
        this.computerRepository = computerRepository;
        this.objectMapper = objectMapper;
    }


    @Override
    public ComputerDTO createComputer(ComputerDTO computerDTO) {
        Computer computerEntity = objectMapper.convertValue(computerDTO, Computer.class);
        Computer computerSaveEntity = computerRepository.save(computerEntity);
        return objectMapper.convertValue(computerSaveEntity, ComputerDTO.class);

    }

    @Override
    public List<ComputerDTO> getComputers() {
        List<Computer> computersInDB = computerRepository.findAll();
        List<ComputerDTO> response = new ArrayList<>();

        for(Computer computer : computersInDB){
            response.add(objectMapper.convertValue(computer, ComputerDTO.class));
        }

        return response;
    }

    @Override
    public ComputerDTO updateComputer(long id, ComputerDTO computerDTO) {
        Computer currentComputer = computerRepository.findById(id).get();
        currentComputer.setId(id);
        currentComputer.setTimeLimit(computerDTO.getTimeLimit());
        currentComputer.setPassword(computerDTO.getPassword());
        Computer responseEntity = computerRepository.save(objectMapper.convertValue(currentComputer, Computer.class));
        return objectMapper.convertValue(responseEntity, ComputerDTO.class);
    }

    @Override
    public void deleteComputer(long computerId) {
        computerRepository.deleteById(computerId);
    }
}
