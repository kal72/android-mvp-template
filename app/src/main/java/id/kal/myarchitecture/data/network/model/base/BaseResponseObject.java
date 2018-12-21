package id.kal.myarchitecture.data.network.model.base;

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
public abstract class BaseResponseObject<T> {

    private T data;
}
