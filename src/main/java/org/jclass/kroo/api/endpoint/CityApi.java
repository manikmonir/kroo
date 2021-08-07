package org.jclass.kroo.api.endpoint;

import java.util.List;
import org.jclass.kroo.api.dto.CityDto;
import org.jclass.kroo.api.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Manik
 */

@RestController
@RequestMapping("/api/city")
public class CityApi {

    @Autowired
    private CityService cityService;

    @GetMapping("/list")
    public List<CityDto> list() {
        return cityService.list();
    }
}
