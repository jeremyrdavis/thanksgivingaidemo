package io.arrogantprogrammer.thanksgivingai.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class RestApiTest {

    @Test
    public void testCreateInvitation() {
        String payload = """
                 {"mains":["Turkey","Ham","Tofurkey"],"sides":["Mashed Potatoes","Green Beans","Cranberry Sauce","Mac & Cheese","Sweet Potatoes","Rolls"],"desserts":["Pumpkin Pie","Coconut Cake"]}
                 """;

        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/thanksgivingai/invitation")
                .then()
                .statusCode(200)
                .body("thanksgivingMenu.email", is("test@example.com"));
    }
}
