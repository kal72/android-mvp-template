package id.kal.myarchitecture.data.network.model.base;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * Contributor Kristiawan Adi L on 21/12/18.
 */
@NoArgsConstructor
@Setter
@Getter
@ToString
public class BaseResponseList<T> {

    private List<T> data;
}
