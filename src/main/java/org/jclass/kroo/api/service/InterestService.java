package org.jclass.kroo.api.service;

import java.util.ArrayList;
import org.jclass.kroo.repo.InterestRepo;
import java.util.List;
import org.jclass.kroo.api.dto.InterestDto;
import org.jclass.kroo.model.Interest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manik
 */

@Service
public class InterestService {

    @Autowired
    private InterestRepo interestRepo;

    //list of active Interest plus active zip codes 
    public List<InterestDto> list() {

        List<Interest> interests = interestRepo.findAllCustom();

        List<InterestDto> interestDtos = new ArrayList();

        for (Interest Interest : interests) {
            InterestDto interestDto = new InterestDto();
            interestDto.setValue(Interest.getId());
            interestDto.setLabel(Interest.getName());
            interestDto.setImageUrl(Interest.getImagePath());
            interestDtos.add(interestDto);
        }

        return interestDtos;
    }
}
