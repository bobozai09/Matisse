/*
 * Copyright 2017 Zhihu Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.zhihu.matisse.internal.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.zhihu.matisse.internal.entity.Item;
import com.zhihu.matisse.internal.ui.PreviewItemFragment;

import java.util.ArrayList;
import java.util.List;

public class PreviewPagerAdapter extends FragmentPagerAdapter {

    private ArrayList<Item> mItems = new ArrayList<>();
    private OnPrimaryItemSetListener mListener;
//private onItemClickListener onItemClickListener;
    public PreviewPagerAdapter(FragmentManager manager, OnPrimaryItemSetListener listener) {
        super(manager);
        mListener = listener;
    }
//    public PreviewPagerAdapter(FragmentManager manager,onItemClickListener onItemClickListener){
//        super(manager);
//        onItemClickListener=onItemClickListener;
//    }

    @Override
    public Fragment getItem(int position) {
        return PreviewItemFragment.newInstance(mItems.get(position));
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        super.setPrimaryItem(container, position, object);
        if (mListener != null) {
            mListener.onPrimaryItemSet(position);
        }
    }

    public Item getMediaItem(int position) {
        return mItems.get(position);
    }

    public void addAll(List<Item> items) {
        mItems.addAll(items);
    }



    public   interface OnPrimaryItemSetListener {
        void onPrimaryItemSet(int position);
    }
//    public void  onitemClickListener(OnPrimaryItemSetListener onPrimaryItemSetListener){
//        this.mListener=onPrimaryItemSetListener;
//
//    }
//public void setOnItemClickListener(onItemClickListener onItemClickListener){
//        this.onItemClickListener=onItemClickListener;
//}
//protected  interface onItemClickListener{
//void  onItemClickListener();
//}
}
