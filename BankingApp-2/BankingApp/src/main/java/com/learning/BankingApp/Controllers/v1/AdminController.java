package com.learning.BankingApp.Controllers.v1;

import com.learning.BankingApp.Common.constants.AppHttpCodeEnum;
import com.learning.BankingApp.Entity.DTO.ResponseResult;
import com.learning.BankingApp.Entity.DTO.StaffDTOValidate;
import com.learning.BankingApp.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @PostMapping("/create")
    public ResponseResult createStaff(@RequestBody StaffDTOValidate dto) {
        //if success
        return adminService.createStaff(dto);
    }
}

