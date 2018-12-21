package id.kal.myarchitecture.data.network.model.base;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
@NoArgsConstructor
@Setter
@Getter
public class BaseResponse {

    private int status;
    private String message;
    private int offset;
    private int limit;
    private int totalRows;
}
