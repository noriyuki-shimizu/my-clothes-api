package source.usecases.app.shops;

import source.usecases.dto.input.shops.ShopSearchInputData;
import source.domain.entity.Shops;

import java.util.List;

public interface IShopSearchUsecase {
    public List<Shops> search(Long userId, ShopSearchInputData inputData);
}