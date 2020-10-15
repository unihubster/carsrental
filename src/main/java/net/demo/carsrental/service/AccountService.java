package net.demo.carsrental.service;

import com.lambdaworks.crypto.SCryptUtil;
import net.demo.carsrental.dao.AccountDAO;
import net.demo.carsrental.dao.exception.NotUniqueException;
import net.demo.carsrental.dto.AccountRegistrationDTO;
import net.demo.carsrental.dto.AccountSignInDTO;
import net.demo.carsrental.model.Account;

public class AccountService implements Service {

    // CPU cost parameter for SCryptUtil
    private static final int N = 16384;

    private final AccountDAO accountDAO;

    public AccountService(AccountDAO accountDAO) {
        this.accountDAO = accountDAO;
    }

    // https://github.com/wg/scrypt
    public void registerNewAccount(AccountRegistrationDTO accountRegistrationDTO) throws NotUniqueException {
        Account account = mapAccountDTOtoAccount(accountRegistrationDTO);
        String cryptPassword = SCryptUtil.scrypt(account.getPassword(), N, 8, 1);
        account.setPassword(cryptPassword);
        accountDAO.create(account);
    }

    // https://github.com/wg/scrypt
    public boolean isLoginAndPasswordKnown(AccountSignInDTO accountSignInDTO) {
        String cryptPassword = accountDAO.getPassword(accountSignInDTO.getUsername());
        return SCryptUtil.check(accountSignInDTO.getPassword(), cryptPassword);
    }

    private Account mapAccountDTOtoAccount(AccountRegistrationDTO accountRegistrationDTO) {
        return Account.builder()
                      .setUsername(accountRegistrationDTO.getUsername())
                      .setPassword(accountRegistrationDTO.getPassword())
                      .setFirstName(accountRegistrationDTO.getFirstName())
                      .setLastName(accountRegistrationDTO.getLastName())
                      .setEmail(accountRegistrationDTO.getEmail())
                      .setPhone(accountRegistrationDTO.getPhone())
                      .setRole(Account.Role.CUSTOMER)
//                      .setStatus(Account.Status.NEW) // TODO set this instead of Account.Status.ACTIVE after email or phone confirmation implementation
                      .setStatus(Account.Status.ACTIVE)
                      .build();
    }
}
