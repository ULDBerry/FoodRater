package ie.ul.daveberry.foodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


  @NonNull
  @Override
  public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.food_item_view, parent, false);
    return new FoodViewHolder(itemView);

  }

 // private List<Food> mFoods = new ArrayList<>();
  private RecyclerView mRecyclerView;

  @Override
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
    mRecyclerView = recyclerView;
  }

  public void addFood() {

    notifyItemInserted(0);

    mRecyclerView.getLayoutManager().scrollToPosition(0);
  }


  @Override
  public int getItemCount() {
    return 0;
  }

  @Override
  public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {

  }

  class FoodViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;
    private TextView mName;
    private RatingBar mRatingBar;
    public FoodViewHolder(View itemView) {
      super(itemView);
      mImageView = itemView.findViewById(R.id.food_pic);
      mName = itemView.findViewById(R.id.name);
      mRatingBar = itemView.findViewById(R.id.rating_bar);

    }
  }
}
