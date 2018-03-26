import Entity.GitHubUser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.util.ArrayList;
import java.util.List;

public class YouAreEll {

    YouAreEll() {
    }

    public static void main(String[] args) {
//      jackson mapper
        ObjectMapper mapper = new ObjectMapper();
        YouAreEll urlhandler = new YouAreEll();

//       Unirest.setObjectMapper(mapper);
//      list to store github users
        String json = urlhandler.MakeURLCall("/ids", "GET", "");
        System.out.println(json);
        List<GitHubUser> list = new ArrayList<GitHubUser>();
        try {
//      type reference is a list of github users
           list = mapper.readValue(json, new TypeReference<List<GitHubUser>>(){});
            System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(list));

        } catch (Exception e){
            e.printStackTrace();
        }

        for(GitHubUser gitHubUser : list){
            System.out.println(gitHubUser.toString());
        }

        GitHubUser april = new GitHubUser("aprilcr8777", "APRILAGAIN", "32585650");
        try {
        String jsonPayLoad =  mapper.writeValueAsString(april);
        System.out.println(jsonPayLoad);

            urlhandler.MakeURLCall("/ids", "POST", mapper.writeValueAsString(april));
            } catch (Exception e){
            e.printStackTrace();
        }
    }

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
    }

    public List<GitHubUser> get_idsAsList() throws Exception{
        ObjectMapper objectMapper = new ObjectMapper();

     return objectMapper.readValue(MakeURLCall("/ids", "GET", ""), new TypeReference<List<GitHubUser>>(){});

    }

    public String get_messages() {
        return MakeURLCall("/messages", "GET", "");
    }

    public String MakeURLCall(String mainurl, String method, String jpayload) {
        String url = "http://zipcode.rocks:8085" + mainurl;

        if(method.equals("GET")) {
            HttpResponse<JsonNode> getRequest = null;
            try {
                getRequest = Unirest.get(url).asJson();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
            return getRequest.getBody().toString();
        }
        else if(method.equals("POST")){
            try {
                HttpResponse<JsonNode> post = Unirest.post(url)
                        .body(jpayload)
                        .asJson();
            } catch (UnirestException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("PUT")){
            HttpRequestWithBody put = Unirest.put(url);
            try{
                put.body(jpayload).asJson();
            }catch (UnirestException e){
                e.printStackTrace();
            }
        }

        return "nada";
    }
}
