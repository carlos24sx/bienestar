package co.edu.unisimon.bienestar.business.domain.dto.external;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PaisDto implements Serializable {

    private static final long serialVersionUID = 3678017730217954793L;
    public static final String NAME = "Pais";

    private String name;
    private String capital;
    private String region;
    private String subregion;
    private List<String> borders;


}
