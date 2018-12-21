package id.kal.myarchitecture.exception;

/**
 * Contributor Kristiawan Adi L on 18/12/18.
 * this class for exception if view not attached on presenter
 */
public class MvpViewNotAttachedException extends NullPointerException {

    public MvpViewNotAttachedException() {
        super("View on this Presenter is not attached");
    }
}
