package com.javastart.deposit.controller;

import com.javastart.deposit.dto.DepositRequestDTO;
import com.javastart.deposit.dto.DepositResponseDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepositController {

    @PostMapping("/deposits")
    public DepositResponseDTO deposit(@RequestBody DepositRequestDTO requestDTO) {

    }
}
