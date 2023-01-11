import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ReqresApiTest {

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {
                            put("name", "admin");
                            put("job", "admin");
                        }},
                },
                {
                        new JSONObject() {{
                            put("name", "ronaldo");
                            put("job", "player");
                        }},
                }
        };
    }

    @Test(dataProvider = "userData")
    public void testCreateUser(JSONObject userData) {
        RequestSpecification request = RestAssured.given();
        request.header("Content-Type", "application/json");
        request.body(userData.toJSONString());
        Response response = request.post("https://reqres.in/api/users");
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Incorrect status code");
        String contentType = response.getHeader("Content-Type");
        Assert.assertTrue(contentType.contains("application/json"), "Incorrect Content-Type");
        Object obj = response.getBody().as(Object.class);
        Assert.assertNotNull(obj);
    }
}




