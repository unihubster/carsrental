package net.demo.carsrental.model;

import net.demo.carsrental.dao.table.AccountRoleTable;
import net.demo.carsrental.dao.table.AccountStatusTable;

import java.time.LocalDateTime;

public class Account implements Entity {
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private Role role;
    private Status status;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdate;

    public Account() {
    }

    private Account(Builder builder) {
        username = builder.username;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        phone = builder.phone;
        role = builder.role;
        status = builder.status;
    }

    public static IUsername builder() {
        return new Account.Builder();
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", role=" + role +
                ", status=" + status +
                ", createDate=" + createDate +
                ", lastUpdate=" + lastUpdate +
                '}';
    }

    public enum Role {
        ADMIN(AccountRoleTable.ROLE_ADMIN_ID),
        MANAGER(AccountRoleTable.ROLE_MANAGER_ID),
        CUSTOMER(AccountRoleTable.ROLE_CUSTOMER_ID),
        GUEST(AccountRoleTable.ROLE_GUEST_ID);

        public final int roleId;

        Role(int roleId) {
            this.roleId = roleId;
        }

        public static Role getRoleById(int roleId) {
            for (Role role : Role.values()) {
                if (role.roleId == roleId) {
                    return role;
                }
            }
            return null;
        }
    }

    public enum Status {
        NEW(AccountStatusTable.STATUS_NEW_ID),
        ACTIVE(AccountStatusTable.STATUS_ACTIVE_ID),
        DELETED(AccountStatusTable.STATUS_DELETED_ID),
        BANNED(AccountStatusTable.STATUS_BANNED_ID);

        public final int statusId;

        Status(int statusId) {
            this.statusId = statusId;
        }
    }

    public interface IBuild {
        Account build();
    }

    public interface IUsername {
        IPassword setUsername(String val);
    }

    public interface IPassword {
        IFirstName setPassword(String val);
    }

    public interface IFirstName {
        ILastName setFirstName(String val);
    }

    public interface ILastName {
        IEmail setLastName(String val);
    }

    public interface IEmail {
        IPhone setEmail(String val);
    }

    public interface IPhone {
        IRole setPhone(String val);
    }

    public interface IRole {
        IStatus setRole(Role val);
    }

    public interface IStatus {
        IBuild setStatus(Status val);
    }

    private static final class Builder implements IUsername, IPassword, IFirstName, ILastName, IEmail, IPhone, IRole, IStatus, IBuild {
        private String username;
        private String password;
        private String firstName;
        private String lastName;
        private String email;
        private String phone;
        private Role role;
        private Status status;

        private Builder() {
        }

        @Override
        public IPassword setUsername(String val) {
            username = val;
            return this;
        }

        @Override
        public IFirstName setPassword(String val) {
            password = val;
            return this;
        }

        @Override
        public ILastName setFirstName(String val) {
            firstName = val;
            return this;
        }

        @Override
        public IEmail setLastName(String val) {
            lastName = val;
            return this;
        }

        @Override
        public IPhone setEmail(String val) {
            email = val;
            return this;
        }

        @Override
        public IRole setPhone(String val) {
            phone = val;
            return this;
        }

        @Override
        public IStatus setRole(Role val) {
            role = val;
            return this;
        }

        @Override
        public IBuild setStatus(Status val) {
            status = val;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
    }
}
