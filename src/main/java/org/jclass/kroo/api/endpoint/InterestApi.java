package org.jclass.kroo.api.endpoint;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.jclass.kroo.api.dto.InterestDto;
import org.jclass.kroo.api.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manik
 */
@RestController
@RequestMapping("/api/interest")
public class InterestApi {

    @Autowired
    private InterestService interestService;

    @GetMapping("/list")
    public List<InterestDto> list() {
        return interestService.list();
    }

    @GetMapping("/image/{id}")
    // public List<InterestDto> list() {
    //   return interestService.list();
    // }

    // @RequestMapping(value = "/image/{id}", method = RequestMethod.GET)
    public ResponseEntity<byte[]> getImage(@PathVariable("id") String id) {
        try {
            byte[] image = Files.readAllBytes(Path.of("./interest", id + ".jpeg"));
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(image);

        } catch (Exception e) {
            return null;
        }
    }
}
