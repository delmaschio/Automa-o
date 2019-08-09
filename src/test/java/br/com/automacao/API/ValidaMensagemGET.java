package br.com.automacao.API;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class ValidaMensagemGET {

	@Test
	public void testCriaUsuario() {
		baseURI = "https://jsonplaceholder.typicode.com/todos";
		
         given()
           .contentType("application/json")
     	 .when()
    	   .get(baseURI + "/1")
    	 .then()
    	   .statusCode(200)
    	   .body("title", containsString("delectus aut autem"))	
           .body("completed", is(false));
	}
	
}
