package com.trananhdung.demo.service;

import java.util.List;
import java.util.UUID;

import com.trananhdung.demo.entity.StaffAccount;

public interface StaffAccountService {
    StaffAccount addStaffAccount(StaffAccount staffAccount);

    StaffAccount getStaffAccountById(UUID staffAccountId);

    List<StaffAccount> getAllStaffAccounts();

    StaffAccount updateStaffAccount(UUID staffAccountId, StaffAccount updatedStaffAccount);

    void deleteStaffAccount(UUID staffAccountId);
}
