package com.google.acarsan.server;

import com.google.acarsan.Constants;
import com.google.acarsan.HelloClass;
import com.google.acarsan.domain.Product;
import com.google.acarsan.form.ProductForm;
import com.google.api.server.spi.config.Api;
import com.google.api.server.spi.config.ApiMethod;
import com.google.api.server.spi.config.ApiMethod.HttpMethod;
import com.google.api.server.spi.config.Named;
import com.google.api.server.spi.response.UnauthorizedException;
import com.google.appengine.api.users.User;

import javax.mail.AuthenticationFailedException;

/**
 * Defines endpoint functions APIs.
 */
@Api(name = "acarsanendpoints", version = "v1",
scopes = {Constants.EMAIL_SCOPE },
        clientIds = {Constants.WEB_CLIENT_ID, Constants.API_EXPLORER_CLIENT_ID },
        description = "API for hello world endpoints.")

public class AcarsanServer {

   // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "sayHello", path = "sayHello",
            httpMethod = HttpMethod.GET)

    public HelloClass sayHello() {
        return new HelloClass();
    }

    // Declare this method as a method available externally through Endpoints
    @ApiMethod(name = "sayHelloByName", path = "sayHelloByName",            httpMethod = HttpMethod.GET)
    public HelloClass sayHelloByName (@Named("name") String name) {
        return new HelloClass(name);
    }

    @ApiMethod(name = "sayYourAge", path = "sayYourAge", httpMethod = HttpMethod.GET)
    public HelloClass sayYourAge (@Named("age") int age){
    	return new HelloClass(age);
    }

    @ApiMethod(name = "sayNameSurname", path = "sayNameSurname", httpMethod = HttpMethod.GET)
    public HelloClass sayNameSurname(@Named("name") String name, @Named("surname") String surname){
        return new HelloClass(name, surname);
    }

    @ApiMethod(name = "createProduct", path = "createProduct", httpMethod = HttpMethod.GET)
    public Product createProduct(final User user, ProductForm productForm) throws Exception {
        if (user == null) {
            throw new UnauthorizedException("Authorization required");
        }

        if(productForm == null){
            throw new Exception("Product required");
        }

        Product product = new Product(null, productForm.getCategory(), productForm.getName());
        saveProduct(product);

        return product;
    }

    private void saveProduct(Product product) {

    }
}
