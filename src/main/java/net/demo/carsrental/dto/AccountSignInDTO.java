package net.demo.carsrental.dto;

public class AccountSignInDTO {
    private final String username;
    private final String password;

    private AccountSignInDTO(Builder builder) {
        username = builder.username;
        password = builder.password;
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

    public interface IBuild {
        AccountSignInDTO build();
    }

    public interface IPassword {
        IBuild setPassword(String val);
    }

    public interface IUsername {
        IPassword setUsername(String val);
    }

    private static final class Builder implements IPassword, IUsername, IBuild {
        private String password;
        private String username;

        private Builder() {
        }

        @Override
        public IPassword setUsername(String val) {
            username = val;
            return this;
        }

        @Override
        public IBuild setPassword(String val) {
            password = val;
            return this;
        }

        public AccountSignInDTO build() {
            return new AccountSignInDTO(this);
        }
    }

    @Override
    public String toString() {
        return "AccountSignInDTO{" +
                "username='" + username + '\'' +
                '}';
    }
}
