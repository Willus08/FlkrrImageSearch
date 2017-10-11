package helpme_productions.com.flkrrimagesearch.view.activities.search;


import java.util.List;

import helpme_productions.com.flkrrimagesearch.BasePresenter;
import helpme_productions.com.flkrrimagesearch.BaseView;
import helpme_productions.com.flkrrimagesearch.model.PhotoInformation;

public interface SearchContract {
    interface View extends BaseView{
        void setupAdapter(List<PhotoInformation> photoInformationList);

    }
    interface  Presenter extends BasePresenter<View>{
        void getPhotoInformation(String search);

    }
}
