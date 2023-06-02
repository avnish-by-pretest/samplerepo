package com.example.sampletest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.sampletest.dto.FindStoreAvailabilityRequestDTO;
import com.example.sampletest.dto.FindStoreAvailabilityResponseDTO;
import com.example.sampletest.service.FindStoreAvailabilityService;

@RestController
public class FindStoreAvailabilityController {
        @Autowired
        FindStoreAvailabilityService findStoreAvailabilityService;
        
        @PostMapping("/findStoreAvailabilitty")
        public ResponseEntity getProdAvailability(@RequestBody FindStoreAvailabilityRequestDTO findStoreAvailDTO){
        	FindStoreAvailabilityResponseDTO findStoreAvailResponseDTO = findStoreAvailabilityService.getStoreAvailability(findStoreAvailDTO);

                if(findStoreAvailResponseDTO==null)
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
                if(findStoreAvailResponseDTO.getStatus().compareTo("-1")==0)
                        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);


                return ResponseEntity.status(HttpStatus.OK).body(findStoreAvailResponseDTO);

        }
}
