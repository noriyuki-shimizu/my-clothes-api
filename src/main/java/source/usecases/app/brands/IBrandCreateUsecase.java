package source.usecases.app.brands;

import source.usecases.dto.request.brands.BrandCreateRequestData;
import source.usecases.dto.response.brands.BrandResponseModel;

public interface IBrandCreateUsecase {
    public BrandResponseModel create(Long userId, BrandCreateRequestData inputData);
}
