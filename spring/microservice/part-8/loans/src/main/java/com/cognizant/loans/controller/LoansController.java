package com.cognizant.loans.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.loans.dto.LoansDto;
import com.cognizant.loans.dto.ResponseDto;
import com.cognizant.loans.service.LoansServiceImp;

@RestController
@RequestMapping("/api")
public class LoansController {
	
	@Autowired
	private LoansServiceImp loansServiceImp;
	
	@PostMapping("/create")
	public ResponseEntity<String> createLoans(@RequestParam String mobileNumber){
		
		loansServiceImp.createLoan(mobileNumber);
		return ResponseEntity
				   .status(HttpStatus.CREATED)
				   .body("201");
				   
	}
	@GetMapping("/fetch")
	public ResponseEntity<LoansDto> fetchLoansDetails(@RequestParam String mobileNumber){
		LoansDto loansDto=loansServiceImp.fetchLoan(mobileNumber);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body(loansDto);
	}
	@PutMapping("/update")
	public ResponseEntity<?> updateLoansDetails(@RequestBody LoansDto loansDto){
		boolean isUpdated=loansServiceImp.updateLoan(loansDto);
		if(isUpdated) {
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "Request processed successfully"));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto("417", "Update operation failed. Please try again or contact Dev team"));
        }
		
	}
	@DeleteMapping("/delete")
	public ResponseEntity<?> deleteLoansDetails(@RequestParam String mobileNumber){
		boolean isDeleted = loansServiceImp.deleteLoan(mobileNumber);
		if(isDeleted) {
			return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto("200", "Update operation failed. Please try again or contact Dev team"));
        }else{
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto("417", "Delete operation failed. Please try again or contact Dev team"));
        }
		
	}

}
