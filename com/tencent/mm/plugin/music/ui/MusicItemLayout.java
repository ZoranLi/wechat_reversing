package com.tencent.mm.plugin.music.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.widget.LinearLayout;

public class MusicItemLayout extends LinearLayout {
    private GestureDetector nlD;

    private class a extends SimpleOnGestureListener {
        final /* synthetic */ MusicItemLayout nUN;

        private a(MusicItemLayout musicItemLayout) {
            this.nUN = musicItemLayout;
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
            if (Math.abs(f2) > Math.abs(f)) {
                com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) this.nUN.getTag();
                if (f2 > 0.0f) {
                    aVar.aOt();
                } else {
                    aVar.aOs();
                }
            }
            return false;
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) this.nUN.getTag();
            if (aVar.aOr()) {
                if (motionEvent.getY() <= ((float) aVar.nUZ.getMeasuredHeight()) && motionEvent.getY() > 100.0f) {
                    aVar.aOu();
                }
            } else if (motionEvent.getY() >= aVar.nVc.getY() - 100.0f && motionEvent.getY() < ((float) aVar.nVc.getMeasuredHeight()) + aVar.nVc.getY()) {
                aVar.aOu();
            }
            return false;
        }
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        KC();
    }

    public MusicItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        KC();
    }

    private void KC() {
        this.nlD = new GestureDetector(getContext(), new a());
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        com.tencent.mm.plugin.music.ui.b.a aVar = (com.tencent.mm.plugin.music.ui.b.a) getTag();
        if (!aVar.aOr()) {
            Object obj;
            if (aVar.nVa.getX() <= motionEvent.getX() && motionEvent.getX() <= aVar.nVa.getX() + ((float) aVar.nVa.getMeasuredWidth()) && aVar.nVa.getY() <= motionEvent.getY()) {
                if (motionEvent.getY() <= ((float) aVar.nVa.getMeasuredHeight()) + aVar.nVa.getY()) {
                    obj = 1;
                    if (obj == null) {
                        return true;
                    }
                }
            }
            obj = null;
            if (obj == null) {
                return true;
            }
        }
        return false;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        this.nlD.onTouchEvent(motionEvent);
        return true;
    }
}
