package helpme_productions.com.flkrrimagesearch.injection.search;

import dagger.Component;
import helpme_productions.com.flkrrimagesearch.view.activities.search.Search;

@Component(modules = SearchModule.class )
public interface SearchComponent {
    void inject(Search search);

}
