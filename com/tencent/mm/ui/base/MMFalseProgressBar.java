package com.tencent.mm.ui.base;

import android.content.Context;
import android.os.Looper;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.ProgressBar;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.w;

public class MMFalseProgressBar extends ProgressBar {
    private ae mHandler;
    private boolean viW;
    private float viX;
    private float viY;
    private float viZ;
    private float vja;
    private float vjb;
    public boolean vjc;

    static /* synthetic */ void a(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.setVisibility(0);
        mMFalseProgressBar.setAlpha(1.0f);
    }

    static /* synthetic */ void b(MMFalseProgressBar mMFalseProgressBar) {
        if (mMFalseProgressBar.viX < 600.0f) {
            mMFalseProgressBar.viX += mMFalseProgressBar.viY;
        } else if (mMFalseProgressBar.viX >= 600.0f && mMFalseProgressBar.viX < 800.0f) {
            mMFalseProgressBar.viX += mMFalseProgressBar.viZ;
        } else if (mMFalseProgressBar.viX >= 800.0f && mMFalseProgressBar.viX < 920.0f) {
            mMFalseProgressBar.viX += mMFalseProgressBar.vja;
        }
        if (mMFalseProgressBar.mHandler != null) {
            if (mMFalseProgressBar.viX < 920.0f) {
                mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED, 10);
            } else {
                mMFalseProgressBar.mHandler.removeMessages(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
            }
        }
        mMFalseProgressBar.setProgress((int) mMFalseProgressBar.viX);
    }

    static /* synthetic */ void c(MMFalseProgressBar mMFalseProgressBar) {
        float f = 950.0f;
        if (mMFalseProgressBar.viW) {
            Float valueOf;
            if (mMFalseProgressBar.viX < 950.0f) {
                mMFalseProgressBar.viX += mMFalseProgressBar.vjb;
                if (mMFalseProgressBar.viX <= 950.0f) {
                    f = mMFalseProgressBar.viX;
                }
                mMFalseProgressBar.viX = f;
                valueOf = Float.valueOf(1.0f);
            } else {
                mMFalseProgressBar.viX += 1.0f;
                valueOf = Float.valueOf(((1000.0f - mMFalseProgressBar.viX) * 0.01f) + 0.3f);
            }
            if (mMFalseProgressBar.mHandler != null) {
                if (mMFalseProgressBar.viX < 1000.0f) {
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED, 10);
                } else {
                    mMFalseProgressBar.viX = 1000.0f;
                    mMFalseProgressBar.mHandler.removeMessages(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
                    mMFalseProgressBar.mHandler.sendEmptyMessageDelayed(MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED, 10);
                }
            }
            mMFalseProgressBar.setAlpha(valueOf.floatValue());
            mMFalseProgressBar.setProgress((int) mMFalseProgressBar.viX);
        }
    }

    static /* synthetic */ void d(MMFalseProgressBar mMFalseProgressBar) {
        mMFalseProgressBar.viX = 0.0f;
        mMFalseProgressBar.viW = false;
        mMFalseProgressBar.postInvalidateDelayed(200);
        mMFalseProgressBar.setVisibility(8);
    }

    public MMFalseProgressBar(Context context) {
        this(context, null);
        bRQ();
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MMFalseProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.viW = false;
        this.viX = 0.0f;
        this.vjc = true;
        this.mHandler = new ae(this, Looper.getMainLooper()) {
            final /* synthetic */ MMFalseProgressBar vjd;

            public final void handleMessage(Message message) {
                switch (message.what) {
                    case 1000:
                        MMFalseProgressBar.a(this.vjd);
                        return;
                    case MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED /*1001*/:
                        MMFalseProgressBar.b(this.vjd);
                        return;
                    case MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED /*1002*/:
                        MMFalseProgressBar.c(this.vjd);
                        return;
                    case MMBitmapFactory.ERROR_GET_PIXEL_FORMAT_FAILED /*1003*/:
                        MMFalseProgressBar.d(this.vjd);
                        return;
                    default:
                        return;
                }
            }
        };
        setMax(1000);
        bRQ();
    }

    public final void start() {
        w.d("MicroMsg.MMFalseProgressBar", "[cpan] start");
        if (this.vjc && !this.viW) {
            this.viW = true;
            bRQ();
            if (this.mHandler != null) {
                this.mHandler.sendEmptyMessage(1000);
                this.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
            }
        }
    }

    public final void finish() {
        w.d("MicroMsg.MMFalseProgressBar", "[cpan] finish");
        if (this.mHandler != null) {
            this.mHandler.sendEmptyMessage(MMBitmapFactory.ERROR_LOCK_BITMAP_FAILED);
        }
    }

    private void bRQ() {
        if (am.eh(ab.getContext())) {
            this.viY = 4.0f;
            this.viZ = 1.0f;
            this.vja = 0.3f;
            this.vjb = 50.0f;
            return;
        }
        this.viY = 2.0f;
        this.viZ = 0.5f;
        this.vja = 0.15f;
        this.vjb = 50.0f;
    }
}
