package cinemachallenge.api;

import cinemachallenge.api.model.Screening;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/screening")
public class ScreeningApi {

    public void addScreening(Screening screening) {
        //addscreening
    }
}
