package com.example.t.mymoviestory;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.t.mymoviestory.KobisMovieJSONParsing.DailyBoxOfficeProperty;

import java.util.List;

/**
 * Created by T on 2015-12-01.
 */
public class MovieBoxOfficeAdapter extends RecyclerView.Adapter<MovieBoxOfficeAdapter.movieBoxOfficeViewHolder> {

    public interface OnItemClickListener {
        public void onItemClicked(movieBoxOfficeViewHolder holder,
                                  View view,
                                  DailyBoxOfficeProperty dailyBoxOfficeProperty,
                                  int position);
    }

    public MovieBoxOfficeAdapter(List<DailyBoxOfficeProperty> dailyBoxOfficePropertyList) {
        this.dailyBoxOfficePropertyList = dailyBoxOfficePropertyList;
    }

    @Override
    public movieBoxOfficeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.custom_boxoffice_layout, parent, false);
        return new movieBoxOfficeViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(movieBoxOfficeViewHolder holder, int position) {
        holder.setItemData(dailyBoxOfficePropertyList.get(position));
        Log.e("POSITION==>", String.valueOf(position));
        holder.setOnItemClickListener(mListener);
    }

    @Override
    public int getItemCount() {
        return dailyBoxOfficePropertyList.size();
    }

    public static class movieBoxOfficeViewHolder extends RecyclerView.ViewHolder {

        public TextView boxOfficeNum,
                boxOfficeMovieTitle,
                oldAndNew,
                rankInten,
                openDate,
                audienceAccount,
                screenAccount,
                showCount;
        public ImageView movieThumbnailImage;
        public DailyBoxOfficeProperty mProperty;

        public movieBoxOfficeViewHolder(View v) {
            super(v);
            boxOfficeNum = (TextView) v.findViewById(R.id.boxoffice_num);
            boxOfficeMovieTitle = (TextView) v.findViewById(R.id.boxoffice_movie_title);
            oldAndNew = (TextView) v.findViewById(R.id.oldandnew);
            rankInten = (TextView) v.findViewById(R.id.rankinten);
            openDate = (TextView) v.findViewById(R.id.opendate);
            audienceAccount = (TextView) v.findViewById(R.id.audience_account);
            screenAccount = (TextView) v.findViewById(R.id.screen_account);
            showCount = (TextView) v.findViewById(R.id.show_count);
            movieThumbnailImage = (ImageView) v.findViewById(R.id.movie_thumbnail_image);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION) {
                        if (mItemClickListener != null) {
                            mItemClickListener.onItemClicked(movieBoxOfficeViewHolder.this, v, mProperty, position);
                        }
                    }
                }
            });
        }
        OnItemClickListener mItemClickListener;

        public void setOnItemClickListener(OnItemClickListener listener) {
            mItemClickListener = listener;
        }

        public void setItemData(DailyBoxOfficeProperty property) {
            mProperty = property;
            boxOfficeNum.setText(property.rnum + boxOfficeNum.getText());
            boxOfficeMovieTitle.setText(property.movieNm);
            oldAndNew.setText(property.rankOldAndNew);
            if (property.rankInten.equals("0")) {
                rankInten.setText("-");
            } else if (Integer.parseInt(property.rankInten) >= 1) {
                rankInten.setText(property.rankInten + "↑");
            } else if (Integer.parseInt(property.rankInten) < 0) {
                rankInten.setText(property.rankInten + "↓");
            }
            openDate.setText(openDate.getText() + property.openDt);
            audienceAccount.setText(audienceAccount.getText() + property.audiAcc);
            screenAccount.setText(screenAccount.getText() + property.scrnCnt);
            showCount.setText(showCount.getText() + property.showCnt);
            movieThumbnailImage.setImageResource(R.drawable.hungergame); // 임시
        }
    }

    public List<DailyBoxOfficeProperty> dailyBoxOfficePropertyList;
    OnItemClickListener mListener;

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    /*public void add(DailyBoxOfficeProperty property) {
        dailyBoxOfficePropertyList.add(property);
        notifyDataSetChanged();
    }*/

}
