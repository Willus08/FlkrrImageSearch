package helpme_productions.com.flkrrimagesearch.model;


import java.util.List;

public class Photos {
    private int page;
    private int pages;
    private int per_page;
    private int total;
    private List<PhotoInformation> photoInformations;

    public Photos(int page, int pages, int per_page, int total, List<PhotoInformation> photoInformations) {
        this.page = page;
        this.pages = pages;
        this.per_page = per_page;
        this.total = total;
        this.photoInformations = photoInformations;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPer_page() {
        return per_page;
    }

    public void setPer_page(int per_page) {
        this.per_page = per_page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<PhotoInformation> getPhotoInformations() {
        return photoInformations;
    }

    public void setPhotoInformations(List<PhotoInformation> photoInformations) {
        this.photoInformations = photoInformations;
    }
}
