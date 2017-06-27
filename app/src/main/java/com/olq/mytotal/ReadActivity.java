package com.olq.mytotal;

import android.widget.FrameLayout;

import com.lzy.okgo.cache.CacheManager;
import com.olq.mytotal.base.BaseActivity;
import com.olq.mytotal.bookview.OnReadStateChangeListener;
import com.olq.mytotal.bookview.PageWidget;

import butterknife.BindView;

public class ReadActivity extends BaseActivity {

    @BindView(R.id.fl_read)
    FrameLayout flRead;

    @Override
    public int getLayout() {
        return R.layout.activity_read;
    }

    @Override
    public void onCreate() {
//        PageWidget pageWidget=new PageWidget(this,"a",,new ReadListener());
//        flRead.addView(pageWidget);
    }

    private class ReadListener implements OnReadStateChangeListener {
        @Override
        public void onChapterChanged(int chapter) {
//            LogUtils.i("onChapterChanged:" + chapter);
//            currentChapter = chapter;
//            mTocListAdapter.setCurrentChapter(currentChapter);
//            // 加载前一节 与 后三节
//            for (int i = chapter - 1; i <= chapter + 3 && i <= mChapterList.size(); i++) {
//                if (i > 0 && i != chapter
//                        && CacheManager.getInstance().getChapterFile(bookId, i) == null) {
//                    mPresenter.getChapterRead(mChapterList.get(i - 1).link, i);
//                }
//            }
        }

        @Override
        public void onPageChanged(int chapter, int page) {
//            LogUtils.i("onPageChanged:" + chapter + "-" + page);
        }

        @Override
        public void onLoadChapterFailure(int chapter) {
//            LogUtils.i("onLoadChapterFailure:" + chapter);
//            startRead = false;
//            if (CacheManager.getInstance().getChapterFile(bookId, chapter) == null)
//                mPresenter.getChapterRead(mChapterList.get(chapter - 1).link, chapter);
        }

        @Override
        public void onCenterClick() {
//            LogUtils.i("onCenterClick");
//            toggleReadBar();
        }

        @Override
        public void onFlip() {
//            hideReadBar();
        }
    }

}
