package source.controller.shops.assist.response;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class ShopAssistResponseViewModels {
    private List<ShopAssistResponseModel> assistShops;
}
