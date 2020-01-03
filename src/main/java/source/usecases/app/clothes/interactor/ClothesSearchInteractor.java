package source.usecases.app.clothes.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specifications;
import org.springframework.stereotype.Component;
import source.usecases.dto.request.clothes.ClothesSearchRequestData;
import source.domain.entity.Clothes;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.specification.ClothesSpecification;
import source.usecases.app.clothes.IClothesSearchUsecase;

import java.util.List;

@Component
public class ClothesSearchInteractor implements IClothesSearchUsecase {

    @Autowired
    private ClothesRepository repository;

    public List<Clothes> search(Long userId, ClothesSearchRequestData inputData) {
        return this.repository.findAll(
                Specifications
                        .where(ClothesSpecification.userIdEqual(userId))
                        .and(ClothesSpecification.brandIdContains(inputData.getBrandId()))
                        .and(ClothesSpecification.shopIdEqual(inputData.getShopId()))
                        .and(ClothesSpecification.genreIdEqual(inputData.getGenreId()))
                        .and(ClothesSpecification.priceLessEqual(inputData.getLessPrice()))
                        .and(ClothesSpecification.priceGreaterEqual(inputData.getMorePrice()))
                        .and(ClothesSpecification.buyDateEqual(inputData.getBuyDate()))
                        .and(ClothesSpecification.deleteFlagEqual(inputData.getIsDeleted()))
        );
    }
}
