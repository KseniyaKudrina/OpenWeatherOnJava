package api_store;

public class SendRequest_CreateNewUserResponse {
    private String first_name;
    private String last_name;
    private Integer company_id;
    private Integer user_id;

    public SendRequest_CreateNewUserResponse(String first_name, String last_name, Integer company_id, Integer user_id) {
        this.first_name = first_name;
        this.last_name = last_name;
        this.company_id = company_id;
        this.user_id = user_id;
    }
    public SendRequest_CreateNewUserResponse(){

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

    public Integer getUser_id() {
        return user_id;
    }
}
