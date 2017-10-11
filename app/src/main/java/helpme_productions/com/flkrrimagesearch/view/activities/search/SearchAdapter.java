package helpme_productions.com.flkrrimagesearch.view.activities.search;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import helpme_productions.com.flkrrimagesearch.R;
import helpme_productions.com.flkrrimagesearch.model.PhotoInformation;

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHolder>{
    private List<PhotoInformation> photoInformationList = new ArrayList<>();

    public SearchAdapter(List<PhotoInformation> photoInformationList) {
        this.photoInformationList = photoInformationList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.photo_list_item,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        PhotoInformation photo  = photoInformationList.get(position);
        String location = "http://farm"+photo.getFarm()+".static.flickr.com/"+photo.getServer()+"/"+photo.getId()+"_"+photo.getSecret()+".jpg";
        Glide.with(holder.itemView.getContext()).load(location).into(holder.picture);
    }

    @Override
    public int getItemCount() {
        return photoInformationList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView picture;
        public ViewHolder(View itemView) {
            super(itemView);
            picture = itemView.findViewById(R.id.ivSearchedImage);
        }
    }
}
