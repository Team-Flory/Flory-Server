package zerobibim.flory.domain.test.exception;

import zerobibim.flory.global.common.ApiPayload.code.BaseErrorCode;
import zerobibim.flory.global.exception.GeneralException;

public class TestHandler extends GeneralException {
    public TestHandler(BaseErrorCode code) {
        super(code);
    }
}