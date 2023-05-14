package api_store;


import org.json.JSONObject;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class Animals {
    String requestBody = null;
    Integer idAnimal = 11;
    String name = "Lola";
    {
        //тело запроса
        String path = "src/test/resources/addNewPet.json";
        //меняем запрос
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("id", idAnimal);
        jsonObject.put("name", name);
        requestBody = jsonObject.toString();
    }

    @Test
    @DisplayName("Поиск животного по статусу")
    public void testSearchPet() throws IOException {
        URL baseURL = new URL("https://petstore.swagger.io/v2/pet/findByStatus?status=available");
        HttpURLConnection connection = (HttpURLConnection) baseURL.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setRequestProperty("Accept", "application/json");
        connection.setRequestProperty("Accept-Encoding", "gzip, deflate, br");


        // ответ
        StringBuilder content = new StringBuilder();
        Map<String, List<String>> headersMap = connection.getHeaderFields();
        for(Map.Entry item: headersMap.entrySet()){
            System.out.println(item.getKey() + " " + item.getValue());
        }
        System.out.println(content);
    }




}
