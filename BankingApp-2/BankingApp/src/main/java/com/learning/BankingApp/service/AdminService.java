package com.learning.BankingApp.service;

import com.learning.BankingApp.Entity.DTO.ResponseResult;
import com.learning.BankingApp.Entity.DTO.StaffDTOValidate;

public interface AdminService {
    public ResponseResult createStaff(StaffDTOValidate staffDTO);
}
