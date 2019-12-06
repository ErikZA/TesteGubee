package erikzambeli.com.br.testeGubee.testegubee.presentation.base;

import erikzambeli.com.br.testeGubee.testegubee.exception.URLJsonNotFound;
import erikzambeli.com.br.testeGubee.testegubee.servie.base.BuildBaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Service
@RestController
public class BuildBasePresentation {

    @Autowired
    private BuildBaseService buildbase;

    @GetMapping("/service")
    public ResponseEntity<String> readAllJson() throws URLJsonNotFound {
        try {
            buildbase.buildBaseJson();
            return ResponseEntity.status(201).body(buildbase.toString());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(201).body(e.getMessage());
        }
    }
}