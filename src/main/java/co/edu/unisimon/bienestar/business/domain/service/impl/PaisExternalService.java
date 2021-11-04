package co.edu.unisimon.bienestar.business.domain.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import co.edu.unisimon.bienestar.business.domain.dto.external.PaisDto;
import co.edu.unisimon.bienestar.business.domain.service.IPaisExternalService;
import co.edu.unisimon.bienestar.business.http.feign.CountryFeign;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class PaisExternalService implements IPaisExternalService {

    private final CountryFeign countryFeign;

    @Override
    public List<PaisDto> getCountriesByLangaugeSpeaking(String language) {
        return countryFeign.getCountriesByLangaugeSpeaking(language);
    }

}
