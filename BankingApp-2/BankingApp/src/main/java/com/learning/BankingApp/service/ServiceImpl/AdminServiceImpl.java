package com.learning.BankingApp.service.ServiceImpl;

import com.learning.BankingApp.Common.constants.AppHttpCodeEnum;
import com.learning.BankingApp.Entity.DTO.ResponseResult;
import com.learning.BankingApp.Entity.DTO.StaffDTOValidate;
import com.learning.BankingApp.service.AdminService;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Override
    public ResponseResult createStaff(StaffDTOValidate staffDTO) {
        if (true) {
            return ResponseResult.okResult(staffDTO);
        } else {
            return ResponseResult.errorResult(AppHttpCodeEnum.DATA_EXIST, "staff already exit");
        }
    }

    //Method completion Required
	public UserDetails loadUserByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
	}
}
