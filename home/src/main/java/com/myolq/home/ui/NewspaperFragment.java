package com.myolq.home.ui;

import com.myolq.frame.base.BaseFragment;
import com.myolq.home.R;


public class NewspaperFragment extends BaseFragment {

    private static NewspaperFragment fragment;

    public NewspaperFragment() {
    }

    public static NewspaperFragment newInstance() {
        if (fragment==null){
            fragment = new NewspaperFragment();
        }
        return fragment;
    }

//    @Nullable
//    @Override
//    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        return inflater.inflate(R.layout.fragment_newspaper,container);
//    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_newspaper;
    }

    @Override
    public void onCreateView() {

    }

    @Override
    public void onLayoutLoadData() {

    }
}
