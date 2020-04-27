package source.interactor;

import lombok.extern.slf4j.Slf4j;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.domain.entity.db.Brands;
import source.domain.entity.db.Clothes;
import source.domain.entity.db.Genres;
import source.domain.entity.db.Shops;
import source.domain.logging.BrandLogging;
import source.domain.logging.ClothesLogging;
import source.domain.logging.ShopLogging;
import source.domain.repository.db.BrandsRepository;
import source.domain.repository.db.ClothesRepository;
import source.domain.repository.db.ImagesRepository;
import source.domain.repository.db.ShopsRepository;
import source.usecases.app.ICleanUsecase;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Component
@Transactional
@Slf4j
public class CleanInteractor implements ICleanUsecase {
    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private ImagesRepository imagesRepository;

    @Autowired
    private BrandsRepository brandsRepository;

    @Autowired
    private ClothesRepository clothesRepository;

    @Autowired
    private ShopsRepository shopsRepository;

    @Override
    public void cleanTables() {
        cleanClothesTable();
        cleanBrandTable();
        cleanShopTable();
    }

    private void cleanBrandTable() {
        final Optional<List<Brands>> deletedBrandsOpt = brandsRepository.findByIsDeletedOrderByUserId(true);
        deletedBrandsOpt.ifPresent(deletedBrands -> {
            BrandLogging.deleteLogging(deletedBrands);
            brandsRepository.delete(deletedBrands);
            imagesRepository.delete(
                    deletedBrands.stream()
                            .filter(deletedBrand -> deletedBrand.getImage() != null)
                            .map(Brands::getImage)
                            .collect(Collectors.toList())
            );
        });
    }

    private void cleanClothesTable() {
        final Optional<List<Clothes>> deletedClothesOpt = clothesRepository.findByIsDeletedOrderByUserId(true);
        deletedClothesOpt.ifPresent(deletedClothes -> {
            ClothesLogging.deleteLogging(deletedClothes);

            clothesRepository.delete(
                    deletedClothes.stream()
                            .peek(clothes -> {
                                Set<Genres> genres = clothes.getGenres();
                                genres.forEach(clothes::removeGenre);
                            })
                            .collect(Collectors.toList())
            );
            imagesRepository.delete(
                    deletedClothes.stream()
                            .filter(clothes -> clothes.getImage() != null)
                            .map(Clothes::getImage)
                            .collect(Collectors.toList())
            );
        });
    }

    private void cleanShopTable() {
        final Optional<List<Shops>> deletedShopsOpt = shopsRepository.findByIsDeletedOrderByUserId(true);
        deletedShopsOpt.ifPresent(deletedShops -> {
            ShopLogging.deleteLogging(deletedShops);
            shopsRepository.delete(deletedShops);
            imagesRepository.delete(
                    deletedShops.stream()
                            .filter(deletedShop -> deletedShop.getImage() != null)
                            .map(Shops::getImage)
                            .collect(Collectors.toList())
            );
        });
    }
}