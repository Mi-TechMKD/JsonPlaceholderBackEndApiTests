package jsonplaceholdertests;

import client.JsonPlaceClient;
import datafactory.JsonPlaceDataFactoryPOSTPUT;
import io.restassured.response.Response;
import models.request.JsonPlaceModelRequestPOSTPUT;
import models.response.JsonPlaceModelResponseGET;
import models.response.JsonPlaceModelResponsePOSTPUT;
import org.junit.Test;

import java.util.List;

import static objectbuilder.JsonPlaceObjectBuilderPOSTPUT.createBodyForJsonPlacePUT;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class JsonPlaceHolderTests {


    @Test
    public void getAllPostsTest() {
        Response getResponse = new JsonPlaceClient()
                .getAllPost();

        List<JsonPlaceModelResponseGET> getResponseList = getResponse
                .body()
                .jsonPath()
                .getList("", JsonPlaceModelResponseGET.class);

        assertEquals(200, getResponse.statusCode());
        assertFalse(getResponseList.isEmpty());

    }

    @Test
    public void getSinglePostTest(){
        String title = "sunt aut facere repellat provident occaecati excepturi optio reprehenderit";
        String body = "quia et suscipit\nsuscipit recusandae consequuntur expedita et cum\nreprehenderit molestiae ut ut quas totam\nnostrum rerum est autem sunt rem eveniet architecto";


                Response getResponse = new JsonPlaceClient()
                .getSinglePost("1");

        JsonPlaceModelResponseGET getResponseBody = getResponse.body().as(JsonPlaceModelResponseGET.class);

        assertEquals(200, getResponse.statusCode());
        assertEquals(title, getResponseBody.getTitle());
        assertEquals(body, getResponseBody.getBody());

    }

    @Test
    public void postPostDefaultValuesHealtCheck() {
        //creating request body with default values
        JsonPlaceModelRequestPOSTPUT requestPUT = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .createRequest();

        //sending request and receiving response
        Response postResponse = new JsonPlaceClient()
                .postPost(requestPUT);

        //validation status code
        assertEquals(201, postResponse.statusCode());
    }

    @Test
    public void postPostCustomValues() {
        // creating request body with default values
        JsonPlaceModelRequestPOSTPUT requestPUT = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .setTitle("Makedonija pobedi na svetsko prvenstvo vo fudbal!")
                .setBody("Fudbalskata reprezentacija na Makedonija izdvojuva pobeda protiv reprezentacijata na Germanija.Krajniot rezultat bese 2:1")
                .createRequest();

        // sending request and receiving response
        Response postResponse = new JsonPlaceClient()
                .postPost(requestPUT);


        //serialization of an object
        JsonPlaceModelResponsePOSTPUT response = postResponse.body().as(JsonPlaceModelResponsePOSTPUT.class);

        // validation status code
        assertEquals(201, postResponse.statusCode());
        assertEquals("Makedonija pobedi na svetsko prvenstvo vo fudbal!", response.getTitle());
        assertEquals("Fudbalskata reprezentacija na Makedonija izdvojuva pobeda protiv reprezentacijata na Germanija.Krajniot rezultat bese 2:1", response.getBody());

    }

    @Test
    public void updatePostDefaultValuesHealtCheck() {
        //creating request body with default values
        JsonPlaceModelRequestPOSTPUT requestPUT = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .createRequest();

        //sending request and receiving response
        Response putResponse = new JsonPlaceClient()
                .updatePost(requestPUT, "1");

        //validation status code
        assertEquals(200, putResponse.statusCode());
    }

    @Test
    public void updatePostCustomValues() {
        // creating request body with default values
        JsonPlaceModelRequestPOSTPUT requestPUT = new JsonPlaceDataFactoryPOSTPUT(createBodyForJsonPlacePUT())
                .setTitle("custom value for title")
                .setBody("custum value for body")
                .createRequest();

        // sending request and receiving response
        Response putResponse = new JsonPlaceClient()
                .updatePost(requestPUT, "1");


        //serialization of an object
        JsonPlaceModelResponsePOSTPUT response = putResponse.body().as(JsonPlaceModelResponsePOSTPUT.class);

        // validation status code
        assertEquals(200, putResponse.statusCode());
        assertEquals("custom value for title", response.getTitle());
        assertEquals("custum value for body", response.getBody());

    }

    @Test

    public void deletePostTest(){

        Response deleteResponse = new JsonPlaceClient()
                .deletePost("1");

        assertEquals(200, deleteResponse.statusCode());
    }


}
