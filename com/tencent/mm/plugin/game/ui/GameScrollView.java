package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.ScrollView;

public class GameScrollView extends ScrollView {
    private GestureDetector iXs;

    class a extends SimpleOnGestureListener {
        final /* synthetic */ GameScrollView mEn;

        a(GameScrollView gameScrollView) {
            this.mEn = gameScrollView;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            return Math.abs(f2) > Math.abs(f);
        }
    }

    public GameScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iXs = new GestureDetector(context, new a(this));
        setFadingEdgeLength(0);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return super.onInterceptTouchEvent(motionEvent) && this.iXs.onTouchEvent(motionEvent);
    }
}
