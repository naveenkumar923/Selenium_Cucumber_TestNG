package restassured;


import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import pojo.TestData;

import static io.restassured.RestAssured.baseURI;

public class APIUtil {

    public Response executeApiRequest(TestData td) {
        baseURI = td.getBaseUri();
        RequestSpecification rs = RestAssured.given();

        rs.headers(td.getHeaders());
        rs.pathParams(td.getPathParam());
        rs.contentType(td.getContentType());

        if (null != td.getRequestBody() && !td.getRequestBody().isEmpty()) {
            rs.body(td.getRequestBody());
        }


        Response response = null;
        if (td.getRequestMethod().equalsIgnoreCase("GET")) {
            response = rs.when().get(td.getRequestPath());
        }


        return response;

    }
}
