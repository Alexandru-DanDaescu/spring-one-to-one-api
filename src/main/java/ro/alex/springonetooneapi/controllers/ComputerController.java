package ro.alex.springonetooneapi.controllers;


import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ro.alex.springonetooneapi.models.dtos.ComputerDTO;
import ro.alex.springonetooneapi.services.ComputerService;

import java.util.List;


@Validated
@RestController
@RequestMapping("api/computers")
public class ComputerController {

    private ComputerService computerService;

    public ComputerController(ComputerService computerService){
        this.computerService = computerService;
    }

    @PostMapping
    public ResponseEntity<ComputerDTO> createComputer(@RequestBody @Valid ComputerDTO computerDTO){
        return ResponseEntity.ok(computerService.createComputer(computerDTO));
    }

    @GetMapping
    public ResponseEntity<List<ComputerDTO>> getAllComputers(){
        return ResponseEntity.ok(computerService.getComputers());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ComputerDTO> updateComputer(@PathVariable("id") Long computerId, @RequestBody @Valid ComputerDTO computerDTO){
        return ResponseEntity.ok(computerService.updateComputer(computerId , computerDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteComputer(@PathVariable("id") Long computerId){
        computerService.deleteComputer(computerId);
        return new ResponseEntity<>("Computer deleted successfully", HttpStatus.OK);
    }



}
