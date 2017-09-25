package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.reflect.Field;

public class ShowCommentImageView extends ImageView {
    private static Bitmap qxn;
    private static Bitmap qxo;
    private static Field qxp;
    private static Field qxq;
    private static boolean qxr = false;
    private boolean qxm = false;

    public ShowCommentImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public ShowCommentImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private static void init() {
        if (qxp == null || qxq == null) {
            try {
                qxp = View.class.getDeclaredField("mDrawingCache");
                qxq = View.class.getDeclaredField("mUnscaledDrawingCache");
                qxp.setAccessible(true);
                qxq.setAccessible(true);
                qxr = true;
            } catch (Exception e) {
                w.e("MicroMsg.ShowCommentImageView", "init error: %s", new Object[]{e.getMessage()});
                qxr = false;
            }
        }
    }

    public void buildDrawingCache(boolean z) {
        if (qxr) {
            if (this.qxm) {
                t(z, true);
            } else if (hH(z)) {
                super.buildDrawingCache(z);
                return;
            } else {
                Bitmap bitmap = z ? qxo : qxn;
                if (bitmap == null || bitmap.isRecycled()) {
                    Field field;
                    super.buildDrawingCache(z);
                    if (z) {
                        try {
                            field = qxp;
                        } catch (Exception e) {
                            w.e("MicroMsg.ShowCommentImageView", "getStaticDrawingCache error: %s", new Object[]{e.getMessage()});
                            return;
                        }
                    }
                    field = qxq;
                    bitmap = (Bitmap) field.get(this);
                    String str = "MicroMsg.ShowCommentImageView";
                    String str2 = "getStaticDrawingCache, autoScale: %s, cache==null: %s";
                    Object[] objArr = new Object[2];
                    objArr[0] = Boolean.valueOf(z);
                    objArr[1] = Boolean.valueOf(bitmap == null);
                    w.d(str, str2, objArr);
                    if (bitmap == null) {
                        return;
                    }
                    if (z) {
                        qxo = bitmap;
                        return;
                    } else {
                        qxn = bitmap;
                        return;
                    }
                }
                t(z, false);
                return;
            }
        }
        super.buildDrawingCache(z);
    }

    private boolean hH(boolean z) {
        if (!qxr) {
            return false;
        }
        Field field;
        if (z) {
            try {
                field = qxp;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.ShowCommentImageView", e, "", new Object[0]);
                w.e("MicroMsg.ShowCommentImageView", "checkIfCanReuseDrawingCache error: %s", new Object[]{e.getMessage()});
                return false;
            }
        }
        field = qxq;
        return ((Bitmap) field.get(this)) != null;
    }

    private void t(boolean z, boolean z2) {
        if (z) {
            try {
                Field field = qxp;
            } catch (Exception e) {
                w.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
                return;
            }
        }
        field = qxq;
        if (z2) {
            field.set(this, null);
            return;
        }
        boolean z3;
        if (z) {
            Object obj = qxo;
        } else {
            Bitmap bitmap = qxn;
        }
        String str = "MicroMsg.ShowCommentImageView";
        String str2 = "setDrawingCache, autoScale: %s, cache==null: %s";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(z);
        if (obj == null) {
            z3 = true;
        } else {
            z3 = false;
        }
        objArr[1] = Boolean.valueOf(z3);
        w.d(str, str2, objArr);
        if (obj != null) {
            field.set(this, obj);
        }
    }

    protected void onDetachedFromWindow() {
        try {
            qxp.set(this, null);
            qxq.set(this, null);
        } catch (Exception e) {
            w.e("MicroMsg.ShowCommentImageView", "setDrawingCache error: %s", new Object[]{e.getMessage()});
        }
        super.onDetachedFromWindow();
    }

    public void destroyDrawingCache() {
        super.destroyDrawingCache();
    }

    public void setOnClickListener(final OnClickListener onClickListener) {
        super.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ ShowCommentImageView qxt;

            public final void onClick(View view) {
                this.qxt.qxm = true;
                onClickListener.onClick(view);
            }
        });
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            postDelayed(new Runnable(this) {
                final /* synthetic */ ShowCommentImageView qxt;

                {
                    this.qxt = r1;
                }

                public final void run() {
                    this.qxt.qxm = false;
                }
            }, 100);
        } else {
            this.qxm = true;
        }
        return super.onTouchEvent(motionEvent);
    }
}
