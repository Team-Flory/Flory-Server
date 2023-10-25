package zerobibim.flory.domain.test.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import zerobibim.flory.global.common.ApiPayload.code.status.ErrorStatus;
import zerobibim.flory.global.exception.handler.TestHandler;

@Service
@RequiredArgsConstructor
public class TestService {

    public void CheckFlag(Integer flag) {
        if(flag == 1)
            throw new TestHandler(ErrorStatus.TEST_EXCEPTION);
    }
}
