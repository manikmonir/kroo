package org.jclass.kroo.api.service;

import java.util.ArrayList;
import org.jclass.kroo.repo.CityRepo;
import java.util.List;
import org.jclass.kroo.api.dto.CityDto;
import org.jclass.kroo.api.dto.ZipDto;
import org.jclass.kroo.model.City;
import org.jclass.kroo.model.Zip;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Manik
 */

@Service
public class CityService {

    @Autowired
    private CityRepo cityRepo;

    //list of active city plus active zip codes 
    public List<CityDto> list() {

        List<City> cities = cityRepo.findAllCustom();

        List<CityDto> cityDtos = new ArrayList();

        for (City city : cities) {
            CityDto cityDto = new CityDto();
            cityDto.setName(city.getNameable().getName());

            ZipDto[] zipDtos = new ZipDto[city.getZips().size()];
            for (int i = 0; i < zipDtos.length; i++) {

                Zip zip = city.getZips().get(i);
                if (zip.getNameable().isActive()) {
                    ZipDto zipDto = new ZipDto();
                    zipDto.setCode(zip.getCode());
                    zipDto.setName(zip.getNameable().getName());
                    zipDtos[i] = zipDto;
                }
            }
            cityDto.setZips(zipDtos);
            cityDtos.add(cityDto);
        }

        return cityDtos;
    }
}
