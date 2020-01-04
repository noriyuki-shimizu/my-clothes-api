package source.controller.images.fashion;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import source.controller.images.ImageController;
import source.usecases.app.images.IGetImageAddressUsecase;
import source.usecases.dto.response.images.ImageAddressResponseData;

@RestController
@Slf4j
public class StreetFashionSnapController extends ImageController {
    private static final String BASE_URL = "/street-fashion-snap";

    @Autowired
    private IGetImageAddressUsecase usecase;

    @GetMapping(BASE_URL + "/addresses")
    public ImageAddressResponseData addresses() {
        return ImageAddressResponseData.of(this.usecase.handle());
    }
}
