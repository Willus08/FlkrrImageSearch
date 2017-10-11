package helpme_productions.com.flkrrimagesearch;


public interface BasePresenter <V extends  BaseView>{
    void addView(V view);
    void removeView();
}
