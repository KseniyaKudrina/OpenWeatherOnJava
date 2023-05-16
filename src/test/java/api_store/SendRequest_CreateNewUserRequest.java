package api_store;

public class SendRequest_CreateNewUserRequest {
    private String first_name;
    private String last_name;
    private Integer company_id;

    public SendRequest_CreateNewUserRequest(String first_name, String last_name, Integer company_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_id = company_id;
    }
    public SendRequest_CreateNewUserRequest(){

    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public Integer getCompany_id() {
        return company_id;
    }
}
