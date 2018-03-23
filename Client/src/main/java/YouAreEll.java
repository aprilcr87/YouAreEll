import com.fasterxml.jackson.core.JsonProcessingException;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.ObjectMapper;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import com.mashape.unirest.request.HttpRequestWithBody;

import java.io.IOException;

public class YouAreEll {

    YouAreEll() {
    }

    public static void main(String[] args) {
        YouAreEll urlhandler = new YouAreEll();

        Unirest.setObjectMapper(new ObjectMapper() {
            private com.fasterxml.jackson.databind.ObjectMapper jacksonObjectMapper
                    = new com.fasterxml.jackson.databind.ObjectMapper();

            public <T> T readValue(String value, Class<T> valueType) {
                try {
                    return jacksonObjectMapper.readValue(value, valueType);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            public String writeValue(Object value) {
                try {
                    return jacksonObjectMapper.writeValueAsString(value);
                } catch (JsonProcessingException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        System.out.println(urlhandler.MakeURLCall("/ids", "GET", ""));
        System.out.println(urlhandler.MakeURLCall("/messages", "GET", ""));
    }

    public String get_ids() {
        return MakeURLCall("/ids", "GET", "");
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
