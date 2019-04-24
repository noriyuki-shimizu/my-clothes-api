package source.domain.repository.specification;

import org.springframework.data.jpa.domain.Specification;
import source.domain.entity.MClothes;

import java.util.Date;

public class MClothesSpecification {

    public static Specification<MClothes> brandIdContains(final Integer brandId) {
        return brandId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("brandId"), brandId);
        };
    }

    public static Specification<MClothes> genreIdEqual(final Integer genreId) {
        return genreId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("genreId"), genreId);
        };
    }

    public static Specification<MClothes> shopIdEqual(final Integer shopId) {
        return shopId == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("shopId"), shopId);
        };
    }

    public static Specification<MClothes> priceLessEqual(final Integer price) {
        return price == null ? null : (root, query, cb) -> {
            return cb.lessThanOrEqualTo(root.get("price"), price);
        };
    }

    public static Specification<MClothes> priceGreaterEqual(final Integer price) {
        return price == null ? null : (root, query, cb) -> {
            return cb.greaterThanOrEqualTo(root.get("price"), price);
        };
    }

    public static Specification<MClothes> buyDateEqual(final Date buyDate) {
        return buyDate == null ? null : (root, query, cb) -> {
            return cb.equal(root.get("buyDate"), buyDate);
        };
    }

    public static Specification<MClothes> deleteFlagEqual(final boolean deleteFlag) {
        return (root, query, cb) -> {
            return cb.equal(root.get("deleteFlag"), deleteFlag);
        };
    }
}
