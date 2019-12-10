package erikzambeli.com.br.testeGubee.testegubee.controller;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import erikzambeli.com.br.testeGubee.testegubee.model.ProductModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Controller
public class ProductController {

    @GetMapping("/service")
    public String loadProduct(Model data) throws JsonSyntaxException, UnirestException {
                Unirest.get("https://back-end-gubee.herokuapp.com/service")
                        .basicAuth("admin","admin")
                        .asJson()
                        .getBody()
                        .toString();

            return "product-view-search";
    }


    @GetMapping("/service/products_search")
    public String loadResultProducts(ProductModel productModel) throws JsonSyntaxException, UnirestException {
        Gson gson = new Gson();
        Object arrayProductModel[] = gson.fromJson(
                Unirest.get("https://back-end-gubee.herokuapp.com/service")
                        .basicAuth("admin","admin")
                        .asJson()
                        .getBody()
                        .toString(), Object[].class
        );
        return "products-view";
    }
}
