package org.jclass.kroo.api.service;

import java.util.ArrayList;
import org.jclass.kroo.repo.CityRepo;
import java.util.List;
import org.jclass.kroo.api.dto.BaseDto;
import org.jclass.kroo.api.dto.CityDto;
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

        //List<City> cities = cityRepo.findAllCustom();
        List<City> cities = cityRepo.findAllByOrderBySlNoAsc();

        List<CityDto> cityDtos = new ArrayList();

        for (City city : cities) {

            if (!city.isActive()) {
                continue;
            }

            CityDto cityDto = new CityDto();
            cityDto.setId(city.getId());
            cityDto.setName(city.getName());

            //ZipDto[] zipDtos = new ZipDto[city.getZips().size()];
            List<BaseDto> zipDtos = new ArrayList<>();
            for (Zip zip : city.getZips()) {

                if (zip.isActive()) {
                    BaseDto zipDto = new BaseDto();
                    zipDto.setId(zip.getId());
                    zipDto.setName((zip.getId() == 0 ? "" : zip.getCode() + "-") + zip.getName());
                    zipDtos.add(zipDto);
                }
            }
            cityDto.setZips(zipDtos);
            cityDtos.add(cityDto);
        }
        System.out.println("cityDtos" + cityDtos);
        return cityDtos;
    }
}
