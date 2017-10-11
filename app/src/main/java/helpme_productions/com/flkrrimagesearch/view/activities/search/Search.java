package helpme_productions.com.flkrrimagesearch.view.activities.search;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import helpme_productions.com.flkrrimagesearch.R;
import helpme_productions.com.flkrrimagesearch.injection.search.DaggerSearchComponent;
import helpme_productions.com.flkrrimagesearch.model.PhotoInformation;

public class Search extends AppCompatActivity implements SearchContract.View{
    @Inject SearchPresenter presenter;

    @BindView(R.id.llSearchContainer)
    LinearLayout searchContainer;
    @BindView(R.id.llPicturesContainer)
    LinearLayout picturesContainer;
    @BindView(R.id.rvPhotoList)
    RecyclerView photoslist;
    @BindView(R.id.etSearchTeext)
    EditText searchText;

    SearchAdapter adapter;
    RecyclerView.LayoutManager layout;
    DefaultItemAnimator animate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        ButterKnife.bind(this);
        setupDagger();
        presenter.addView(this);
    }

    public void startSearch(View view) {
        if (searchText.getText() != null){
            searchContainer.setVisibility(View.GONE);
            picturesContainer.setVisibility(View.VISIBLE);
            presenter.getPhotoInformation(searchText.getText().toString());
        }
        else{
            showError("You must enter something!!");
        }
    }

    public void EnterNewSearch(View view) {
        searchContainer.setVisibility(View.VISIBLE);
        picturesContainer.setVisibility(View.GONE);
    }

    @Override
    public void showError(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setupDagger() {
        DaggerSearchComponent.create().inject(this);
    }

    @Override
    public void setupAdapter(List<PhotoInformation> photoInformationList) {
        adapter = new SearchAdapter(photoInformationList);
        layout = new GridLayoutManager(this,3);
        animate = new DefaultItemAnimator();

        photoslist.setAdapter(adapter);
        photoslist.setLayoutManager(layout);
        photoslist.setItemAnimator(animate);
    }
}
