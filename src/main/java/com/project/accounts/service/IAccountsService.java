package com.project.accounts.service;

import com.project.accounts.dto.CustomerDto;

public interface IAccountsService {
    /**
     *
     * @param customerDto -CustomerDto Object
     */
    void createAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input mobileNumber
     * @return Accounts details based on a given mobile number
     */
    CustomerDto fetchAccountDetails(String mobileNumber);

    /**
     *
     * @param customerDto - Input CustomerDto
     * @return boolean showing that account updated Successfully or not
     */
    boolean updateAccount(CustomerDto customerDto);

    /**
     *
     * @param mobileNumber - Input Mobile Number
     * @return boolean show if the account got deleted successfully
     */
    boolean deleteAccount(String mobileNumber);

}
