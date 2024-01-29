package com.zafir.bojiu.webviewinrecyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.zafir.bojiu.R;

/**
 * Created by wng on 2017/7/25.
 */

public class TextViewHolder extends RecyclerView.ViewHolder {
    private final TextView textView;

    public TextViewHolder(View itemView) {
        super(itemView);
        textView = (TextView) itemView.findViewById(R.id.textview);
    }

    public void setTitle(String title) {
        textView.setText(title);
    }
}
