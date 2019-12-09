package source.usecases.app.assist.interactor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import source.usecases.dto.output.assist.ShopOutputData;
import source.domain.entity.Shops;
import source.domain.repository.db.ShopsRepository;
import source.presenter.assist.IAssistShopSearchPresenter;
import source.usecases.app.assist.IAssistShopSearchUsecase;

import java.util.List;

@Component
public class AssistShopSearchInteractor implements IAssistShopSearchUsecase {

    @Autowired
    private ShopsRepository repository;

    @Autowired
    private IAssistShopSearchPresenter presenter;

    @Override
    public List<ShopOutputData> getAssistShopList() {
        List<Shops> shopsList = this.repository.findAll();

        return presenter.handle(shopsList);
    }

}