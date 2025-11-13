package datafactory;

import models.request.JsonPlaceModelRequestPOSTPUT;

public class JsonPlaceDataFactoryPOSTPUT {

    private JsonPlaceModelRequestPOSTPUT request;

    public JsonPlaceDataFactoryPOSTPUT(JsonPlaceModelRequestPOSTPUT requestBody){
    request = requestBody;
    }

    public JsonPlaceDataFactoryPOSTPUT setTitle(String title) {
        request.setTitle(title);
        return this;
    }

    public JsonPlaceDataFactoryPOSTPUT setBody(String body) {
        request.setBody(body);
        return this;
    }

    public JsonPlaceModelRequestPOSTPUT createRequest() {
        return request;
    }
}
