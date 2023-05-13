package api_Reqres_in;

public class CreateNewUserRequestBody {

    private String name;
    private String job;

    public CreateNewUserRequestBody(String name, String job) {
        this.name = name;
        this.job = job;
    }
   // public CreateNewUserRequestBody(){
    //}

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }
}
