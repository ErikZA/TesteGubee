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
import java.util.Arrays;

@Controller
public class ProductController {


    @GetMapping("/service")
    public String inicial(Model data) throws JsonSyntaxException, UnirestException {
        Gson gson = new Gson();
        ProductModel arrayProductModel[] = gson.fromJson(
                        Unirest.get("https://back-end-gubee.herokuapp.com/service")
                                .basicAuth("admin","admin")
                                .asJson()
                                .getBody()
                                .toString(), ProductModel[].class
        );

        Arrays.stream(arrayProductModel).forEach(productModel -> System.out.println(productModel.getName()));
        Arrays.stream(arrayProductModel).forEach(productModel -> System.out.println(productModel.getDescription()));
        data.addAttribute("products", arrayProductModel);


        return "products-view";
    }
}
