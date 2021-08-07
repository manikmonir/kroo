package org.jclass.kroo.api.endpoint;

import java.util.List;
import org.jclass.kroo.api.dto.InterestDto;
import org.jclass.kroo.api.service.InterestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
