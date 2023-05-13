package api_Reqres_in;

public class UnSuccessRegistration {
    public UnSuccessRegistration() {
    }
    private String error;

    public UnSuccessRegistration(String email) {
        this.error = email;
    }

    public String getError() {
        return error;
    }

}

