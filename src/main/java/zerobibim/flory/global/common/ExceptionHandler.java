package zerobibim.flory.global.common;

import zerobibim.flory.global.common.ApiPayload.code.BaseErrorCode;
import zerobibim.flory.global.exception.GeneralException;

public class ExceptionHandler extends GeneralException {

    public ExceptionHandler(BaseErrorCode code) {
        super(code);
    }
}
