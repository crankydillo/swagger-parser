package io.swagger.parser.test;

import io.swagger.parser.models.SwaggerParseResult;
//import org.junit.Test;
import io.swagger.parser.v3.OpenAPIV3Parser;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNotNull;

public class OpenApiResolverTest {
    @Test
    public void testSimple() {
        SwaggerParseResult result = new OpenAPIV3Parser().readLocation("oas3.yaml", null, null);

        assertNotNull(result);
        assertNotNull(result.getOpenAPI());
        assertEquals(result.getOpenAPI().getOpenapi(), "3.0.0-rc1");
    }

    @Test
    public void test30Url() {
        String location = "http://petstore.swagger.io/v2/swagger.json";

        SwaggerParseResult result = new OpenAPIV3Parser().readLocation(location, null, null);

        assertNotNull(result);
        assertNotNull(result.getOpenAPI());
        assertEquals(result.getOpenAPI().getOpenapi(), "3.0.0-rc1");
    }

    @Test
    public void test30() {
        String yaml =
                "{\n" +
                        "  \"openapi\": \"3.0.0-rc1\",\n" +
                        "  \"info\": {\n" +
                        "    \"title\": \"Swagger Petstore\",\n" +
                        "    \"description\": \"This is a sample server Petstore server. You can find out more about Swagger at [http://swagger.io](http://swagger.io) or on [irc.freenode.net, #swagger](http://swagger.io/irc/). For this sample, you can use the api key `special-key` to test the authorization filters.\",\n" +
                        "    \"termsOfService\": \"http://swagger.io/terms/\",\n" +
                        "    \"contact\": {\n" +
                        "      \"email\": \"apiteam@swagger.io\"\n" +
                        "    },\n" +
                        "    \"license\": {\n" +
                        "      \"name\": \"Apache 2.0\",\n" +
                        "      \"url\": \"http://www.apache.org/licenses/LICENSE-2.0.html\"\n" +
                        "    },\n" +
                        "    \"version\": \"1.0.0\"\n" +
                        "  }\n" +
                        "}";

        SwaggerParseResult result = new OpenAPIV3Parser().readContents(yaml, null, null);

        assertNotNull(result);
        assertNotNull(result.getOpenAPI());
        assertEquals(result.getOpenAPI().getOpenapi(), "3.0.0-rc1");
    }
}
