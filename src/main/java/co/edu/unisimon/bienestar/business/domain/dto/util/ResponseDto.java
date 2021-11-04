package co.edu.unisimon.bienestar.business.domain.dto.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor(staticName = "create")
public class ResponseDto<T> {

    @NonNull
    private T data;

}
