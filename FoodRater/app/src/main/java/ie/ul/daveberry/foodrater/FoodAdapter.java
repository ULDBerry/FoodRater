package ie.ul.daveberry.foodrater;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewHolder> {


  @NonNull
  @Override
  public FoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext())
        .inflate(R.layout.food_item_view, parent, false);
    return new FoodViewHolder(itemView);

  }

  private List<Food> mFoods = new ArrayList<>();
  private RecyclerView mRecyclerView;

  @Override
  public void onAttachedToRecyclerView(@NonNull RecyclerView recyclerView) {
    super.onAttachedToRecyclerView(recyclerView);
    mRecyclerView = recyclerView;
  }

  //Similar to Name  addName method
  public void addFood() {
    mFoods.add(0, new Food());  //new Food object
    notifyItemInserted(0);
    notifyItemRangeChanged(0, mFoods.size());
    mRecyclerView.scrollToPosition(0);
  }

  // Same as NameAdapter removeName
  private void removeFood(int position) {
    mFoods.remove(position);
    notifyItemRemoved(position);
    notifyItemRangeChanged(0, mFoods.size());
  }

  @Override
  public int getItemCount() {
    return mFoods.size();
  }

  @Override
  public void onBindViewHolder(@NonNull FoodViewHolder holder, int position) {
    final Food food = mFoods.get(position); //position in the Array
    holder.mName.setText(food.getName());
    holder.mImageView.setImageResource(food.getImageResourceId());
    holder.mRatingBar.setRating(food.getRating());
  }

  class FoodViewHolder extends RecyclerView.ViewHolder {
    private ImageView mImageView;
    private TextView mName;
    private RatingBar mRatingBar;
    public FoodViewHolder(View itemView) {
      super(itemView);
      mImageView = itemView.findViewById(R.id.food_pic); //image for object
      mName = itemView.findViewById(R.id.name); //name for object
      mRatingBar = itemView.findViewById(R.id.rating_bar); //ratings bar for object

      //Long press to remove food item  same as NameAdapter
      itemView.setOnLongClickListener(new View.OnLongClickListener() {
        @Override
        public boolean onLongClick(View v) {
          removeFood(getAdapterPosition());
          return true;
        }
      });

      //Given code
      mRatingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
        @Override
        public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
          if (fromUser) {
            Food currentFood = mFoods.get(getAdapterPosition());
            currentFood.setRating(rating);
          }
        }
      });
    }
  }
}
