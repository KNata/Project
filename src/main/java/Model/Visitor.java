package Model;

import java.util.Objects;

public class Visitor {

    private int visitorID;
    private String visitorName;
    private String visitorLogin;
    private String visitorPassword;
    private String visitorRole;
    private boolean isAdmin;
    private ROLE role;
    private Driver theDriver;

    public static Builder newBuilder() {
        return new Visitor().new Builder();
    }

    public int getVisitorID() {
        return visitorID;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public String getVisitorLogin() {
        return visitorLogin;
    }

    public String getVisitorPassword() {
        return visitorPassword;
    }

    public String getVisitorRole() {
        return visitorRole;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public Driver getTheDriver() {
        return theDriver;
    }

    public ROLE getRole() {
        return role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Visitor visitor = (Visitor) o;
        return visitorID == visitor.visitorID &&
                isAdmin == visitor.isAdmin &&
                Objects.equals(visitorName, visitor.visitorName) &&
                Objects.equals(visitorLogin, visitor.visitorLogin) &&
                Objects.equals(visitorPassword, visitor.visitorPassword) &&
                Objects.equals(visitorRole, visitor.visitorRole) &&
                Objects.equals(theDriver, visitor.theDriver);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((visitorName == null) ? 0 : visitorName.hashCode());
        result = prime * result + ((visitorLogin == null) ? 0 :  visitorLogin.hashCode());
        result = prime * result + ((visitorPassword == null) ? 0 : visitorPassword.hashCode());
        result = prime * result + visitorID;
        result = prime * result + ((visitorRole == null) ? 0 : visitorRole.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Visitor (" +
                "visitorID = " + visitorID +
                ", visitorName = '" + visitorName + '\'' +
                ", visitorLogin = '" + visitorLogin + '\'' +
                ", visitorPassword = '" + visitorPassword + '\'' +
                ", visitorRole = '" + visitorRole + '\'' +
                ", isAdmin = " + isAdmin +
                ", routeList = " + theDriver.toString() +
                ')';
    }

    public class Builder {

        private Builder() {
        }

        public Builder setVisitorID(int aVisitorID) {
            visitorID = aVisitorID;
            return this;
        }

        public Builder setVisitorName(String aVisitorName) {
            visitorName = aVisitorName;
            return this;
        }

        public Builder setVisitorLogin(String aVisitorLogin) {
            visitorLogin = aVisitorLogin;
            return this;
        }

        public Builder setVisitorPassword(String aVisitorPassword) {
            visitorPassword = aVisitorPassword;
            return this;
        }

        public Builder setVisitorRole(String aVisitorRole) {
            visitorRole = aVisitorRole;
            return this;
        }

        public Builder setAdminStatus(boolean anAdminStatus) {
            isAdmin = anAdminStatus;
            return this;
        }

        public Builder setDriver(Driver aDriver) {
            theDriver = aDriver;
            return this;
        }

        public Builder setRole(ROLE aRole) {
            role = aRole;
            return this;
        }

        public Visitor build() {
            return Visitor.this;
        }
    }

    public enum ROLE {
      ADMIN, DRIVER;
    }
}
