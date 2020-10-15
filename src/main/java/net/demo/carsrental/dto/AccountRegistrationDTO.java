package net.demo.carsrental.dto;

public class AccountRegistrationDTO {
    private final String username;
    private final String password;
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String phone;

    private AccountRegistrationDTO(Builder builder) {
        username = builder.username;
        password = builder.password;
        firstName = builder.firstName;
        lastName = builder.lastName;
        email = builder.email;
        phone = builder.phone;
    }

    public static IUsername builder() {
        return new Builder();
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "AccountRegistrationDTO{" +
                "username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public interface IBuild {
        AccountRegistrationDTO build();
    }

    public interface IPhone {
        IBuild setPhone(String val);
    }

    public interface IEmail {
        IPhone setEmail(String val);
    }

    public interface ILastName {
        IEmail setLastName(String val);
    }

    public interface IFirstName {
        ILastName setFirstName(String val);
    }

    public interface IPassword {
        IFirstName setPassword(String val);
    }

    public interface IUsername {
        IPassword setUsername(String val);
    }

    private static final class Builder implements IPhone, IEmail, ILastName, IFirstName, IPassword, IUsername, IBuild {
        private String phone;
        private String email;
        private String lastName;
        private String firstName;
        private String password;
        private String username;

        private Builder() {
        }

        @Override
        public IBuild setPhone(String val) {
            phone = val;
            return this;
        }

        @Override
        public IPhone setEmail(String val) {
            email = val;
            return this;
        }

        @Override
        public IEmail setLastName(String val) {
            lastName = val;
            return this;
        }

        @Override
        public ILastName setFirstName(String val) {
            firstName = val;
            return this;
        }

        @Override
        public IFirstName setPassword(String val) {
            password = val;
            return this;
        }

        @Override
        public IPassword setUsername(String val) {
            username = val;
            return this;
        }

        public AccountRegistrationDTO build() {
            return new AccountRegistrationDTO(this);
        }
    }
}
