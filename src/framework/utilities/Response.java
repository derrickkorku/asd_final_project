package framework.utilities;

public class Response {
    private boolean success = false;

    public String getMessage() {
        return message;
    }

    private String message = "";

    public Response(Boolean success, String message){
        this.message = message;
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}
