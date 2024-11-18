package io.arrogantprogrammer.thanksgivingai.api;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;

@QuarkusTest
public class RestApiTest {

    @Test
    public void testCreateMenu() {
        String payload =
        """
                {
                    "email": "jeremy.davis@redhat.com",
                    "postCodes" : ["None"]
                }
        """;

        given()
                .header("Content-Type", "application/json")
                .body(payload)
                .when()
                .post("/api/ai/menu")
                .then()
                .statusCode(200)
                .body("email", is("jeremy.davis@redhat.com"));
    }

    @Test
    public void testCreateInvitation() {

        String invitationPayload = """
                {
                  "thanksgivingMenuRecord": {
                    "email": "jeremy.davis@redhat.com",
                    "mains": [
                      {
                        "item": "Turkey",
                        "description": "Brined, Oven Roasted"
                      },
                      {
                        "item": "Tofurkey",
                        "description": "Vegan"
                      }
                    ],
                    "sides": [
                      {
                        "item": "Mac & Cheese",
                        "description": "Gooey, Cheesy"
                      },
                      {
                        "item": "Green Bean Casserole",
                        "description": "Like Grandma used to make"
                      },
                      {
                        "item": "Green Bean Casserole",
                        "description": "Like Grandma used to make"
                      },
                      {
                        "item": "Squash",
                        "description": "Roasted"
                      }
                    ],
                    "desserts": [
                      {
                        "item": "Pumpkin Pie",
                        "description": "Traditional"
                      }
                    ]
                  }
                }
                """;
        given()
                .header("Content-Type", "application/json")
                .body(invitationPayload)
                .when()
                .post("/api/ai/invitation")
                .then()
                .statusCode(200)
                .body("thanksgivingMenuRecord.email", is("jeremy.davis@redhat.com"));
    }

}
