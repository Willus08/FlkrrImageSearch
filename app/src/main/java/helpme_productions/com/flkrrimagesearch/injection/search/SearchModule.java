package helpme_productions.com.flkrrimagesearch.injection.search;


import dagger.Module;
import dagger.Provides;
import helpme_productions.com.flkrrimagesearch.view.activities.search.SearchPresenter;

@Module
public class SearchModule {
    @Provides
    public SearchPresenter searchPresenterProvider(){
        return new SearchPresenter();
    }
}
