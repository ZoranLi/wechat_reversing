package com.tencent.mm.kiss.widget.textview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Point;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.mm.kiss.widget.textview.a.a;
import com.tencent.mm.kiss.widget.textview.a.b;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.qqmusic.mediaplayer.PlayerException;

public final class g {
    protected f haN;
    public a haO;
    protected StaticLayout haP;
    protected boolean haQ = false;
    int haR;
    int haS;
    private boolean haT = false;
    boolean haU = false;
    private boolean haV = false;
    private boolean haW = false;
    View haX;
    private int haY = 0;
    private int haZ = 0;
    protected CharSequence text = null;

    public g(View view, a aVar) {
        this.haX = view;
        this.haO = aVar;
    }

    public final void init() {
        this.text = "";
        this.haX.setWillNotDraw(false);
    }

    public final void setSingleLine(boolean z) {
        int i;
        if (z) {
            i = 1;
        } else {
            i = Integer.MAX_VALUE;
        }
        if (this.haO.maxLines != i) {
            this.haO.maxLines = i;
            this.haQ = true;
            wd();
            this.haX.requestLayout();
            this.haX.invalidate();
        }
    }

    public final void setLines(int i) {
        if (this.haO.maxLines != i || this.haO.minLines != i) {
            this.haQ = true;
            wd();
            this.haO.maxLines = i;
            this.haO.minLines = i;
            this.haX.requestLayout();
            this.haX.invalidate();
            if (h.DEBUG) {
                w.i("MicroMsg.StaticTextViewHolder", "setLines isNeedRecreateLayout");
            }
        }
    }

    public final void setTextSize(int i, float f) {
        Resources system;
        Context context = ab.getContext();
        if (context == null) {
            system = Resources.getSystem();
        } else {
            system = context.getResources();
        }
        float applyDimension = TypedValue.applyDimension(i, f, system.getDisplayMetrics());
        if (applyDimension != 0.0f && this.haO != null && applyDimension != this.haO.hbf) {
            this.haO.hbf = applyDimension;
            this.haQ = true;
            if (h.DEBUG) {
                w.i("MicroMsg.StaticTextViewHolder", "setRawTextSize isNeedRecreateLayout");
            }
        }
    }

    public final void b(f fVar) {
        if (fVar == null || fVar.haL == null) {
            this.haN = null;
            return;
        }
        if (this.haO == null) {
            b bVar = new b();
            bVar.haO = new a();
            bVar.haO.maxLines = fVar.maxLines;
            bVar.haO.maxLength = fVar.maxLength;
            bVar.haO.haK = fVar.haK;
            bVar.haO.haz = fVar.haz;
            bVar.haO.haA = fVar.haA;
            bVar.haO.gravity = fVar.gravity;
            bVar.haO.hbf = fVar.haK.getTextSize();
            bVar.haO.textColor = fVar.haK.getColor();
            this.haO = bVar.haO;
        }
        wd();
        this.haX.setWillNotDraw(false);
        this.haN = fVar;
        this.haP = fVar.haL;
        this.text = fVar.text;
        this.haT = this.text instanceof Spannable;
        if (this.haT) {
            this.text = this.haN.text;
            com.tencent.mm.kiss.widget.textview.b.b.wg();
            com.tencent.mm.kiss.widget.textview.b.b.a((Spannable) this.text);
        }
        this.haX.requestLayout();
        this.haX.invalidate();
    }

    public final void setTextColor(int i) {
        if (this.haO != null && i != this.haO.textColor) {
            this.haO.textColor = i;
            this.haQ = true;
            if (h.DEBUG) {
                w.i("MicroMsg.StaticTextViewHolder", "setTextColor isNeedRecreateLayout");
            }
        }
    }

    public final void setGravity(int i) {
        if (this.haO != null && i != this.haO.gravity) {
            this.haO.gravity = i;
            this.haQ = true;
            if (h.DEBUG) {
                w.i("MicroMsg.StaticTextViewHolder", "setGravity isNeedRecreateLayout");
            }
        }
    }

    public final void setMaxLines(int i) {
        if (this.haO != null && i != this.haO.maxLines) {
            this.haO.maxLines = i;
            this.haQ = true;
            wd();
            if (h.DEBUG) {
                w.i("MicroMsg.StaticTextViewHolder", "setMaxLines isNeedRecreateLayout");
            }
            this.haX.requestLayout();
            this.haX.invalidate();
        }
    }

    public final int getLineHeight() {
        TextPaint paint = this.haN.haL.getPaint();
        if (paint == null) {
            paint = this.haO.haK;
        }
        return Math.round((((float) paint.getFontMetricsInt(null)) * this.haO.haE) + this.haO.haD);
    }

    public final void setText(CharSequence charSequence, boolean z) {
        if (charSequence != null) {
            if (this.text == null || !this.text.equals(charSequence) || z) {
                this.text = charSequence;
                this.haQ = true;
                this.haX.requestLayout();
                this.haX.invalidate();
                if (h.DEBUG) {
                    w.i("MicroMsg.StaticTextViewHolder", "setText isNeedRecreateLayout " + charSequence + " hashcode " + hashCode() + " " + new ah().toString());
                }
            }
        }
    }

    final void wd() {
        this.haZ = 0;
        this.haY = 0;
        this.haR = 0;
        this.haS = 0;
    }

    public final CharSequence getText() {
        return this.text;
    }

    public final float getTextSize() {
        if (this.haN != null) {
            return this.haN.haK.getTextSize();
        }
        if (this.haO != null) {
            return this.haO.hbf;
        }
        return 0.0f;
    }

    public final Layout wb() {
        return this.haP;
    }

    public final f wc() {
        return this.haN;
    }

    public final int getLineCount() {
        if (this.haP == null) {
            return 0;
        }
        return this.haP.getLineCount();
    }

    public final boolean q(MotionEvent motionEvent) {
        int i = -1;
        boolean z = motionEvent.getAction() == 1 || motionEvent.getAction() == 3;
        if (!this.haX.isEnabled() || !this.haT) {
            return false;
        }
        com.tencent.mm.kiss.widget.textview.b.b.wg();
        boolean a = com.tencent.mm.kiss.widget.textview.b.b.a(this.haX, this.haP, (Spannable) this.text, motionEvent);
        this.haW = a;
        if (this.haV && z) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            boolean z2 = (x < ((float) this.haR) || x > ((float) (this.haP.getWidth() + this.haR))) ? false : y >= ((float) this.haS) && y <= ((float) (this.haP.getHeight() + this.haS));
            if (z2) {
                Spannable spannable = (Spannable) this.text;
                int selectionStart = this.text == null ? -1 : Selection.getSelectionStart(this.text);
                if (this.text != null) {
                    i = Selection.getSelectionEnd(this.text);
                }
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(selectionStart, i, ClickableSpan.class);
                if (clickableSpanArr.length > 0) {
                    w.d("MicroMsg.StaticTextViewHolder", "perform clickable span click");
                    clickableSpanArr[0].onClick(this.haX);
                    return true;
                }
            }
        }
        return a;
    }

    public final boolean performClick() {
        if (this.haW || !this.haU) {
            return false;
        }
        return true;
    }

    protected final void onDraw(Canvas canvas) {
        if (this.haP == null || this.haN == null) {
            boolean eP = eP(this.haX.getMeasuredWidth());
            if (h.DEBUG) {
                w.d("MicroMsg.StaticTextViewHolder", "onDraw, textLayout==null:%b, layoutWrapper==null:%b recreate:%b", this.haP, this.haN, Boolean.valueOf(eP));
            }
            if (eP) {
                this.haX.requestLayout();
                this.haX.invalidate();
                return;
            }
            return;
        }
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        canvas.save();
        canvas.clipRect(this.haX.getPaddingLeft(), this.haX.getPaddingTop(), (this.haX.getRight() - this.haX.getLeft()) - this.haX.getPaddingRight(), (this.haX.getBottom() - this.haX.getTop()) - this.haX.getPaddingBottom());
        if (this.haR == 0 || this.haS == 0) {
            int paddingLeft = this.haX.getPaddingLeft();
            int right = ((this.haX.getRight() - this.haX.getLeft()) - this.haX.getPaddingLeft()) - this.haX.getPaddingRight();
            int width = this.haP.getWidth();
            if (width > right) {
                right = paddingLeft;
            } else {
                switch (this.haN.gravity & 8388615) {
                    case 1:
                    case 17:
                        right = (right / 2) - (width / 2);
                        break;
                    case 3:
                    case 8388611:
                        right = 0;
                        break;
                    case 5:
                    case 8388613:
                        right -= width;
                        break;
                    default:
                        right = 0;
                        break;
                }
                right += paddingLeft;
            }
            this.haR = right;
            paddingLeft = this.haX.getPaddingTop();
            width = ((this.haX.getBottom() - this.haX.getTop()) - this.haX.getPaddingTop()) - this.haX.getPaddingBottom();
            right = 0;
            int height = this.haP.getHeight();
            if (height > width) {
                right = paddingLeft;
            } else {
                switch (this.haN.gravity & MMGIFException.D_GIF_ERR_IMAGE_DEFECT) {
                    case 16:
                        right = (width / 2) - (height / 2);
                        break;
                    case 48:
                        right = 0;
                        break;
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                        right = width - height;
                        break;
                }
                right += paddingLeft;
            }
            this.haS = right;
        }
        canvas.translate((float) this.haR, (float) this.haS);
        this.haP.draw(canvas, null, null, 0);
        canvas.restore();
        if (h.DEBUG) {
            w.d("MicroMsg.StaticTextViewHolder", "onDraw used: %fms, hashCode: %d, text: %s clipLeft:%d clipTop:%d clipRight:%d clipBottom:%d", Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d), Integer.valueOf(hashCode()), this.text, Integer.valueOf(r4), Integer.valueOf(r5), Integer.valueOf(r6), Integer.valueOf(r7));
        }
    }

    private boolean eP(int i) {
        if (this.haQ || this.haN == null || this.haP == null) {
            if (this.haO == null) {
                return false;
            }
            if (i > 0) {
                wd();
                long j = 0;
                if (h.DEBUG) {
                    j = System.nanoTime();
                }
                this.haN = d.a(this.text, i, this.haO).vW();
                this.haP = this.haN.haL;
                this.haQ = false;
                if (h.DEBUG) {
                    long nanoTime = System.nanoTime();
                    w.d("MicroMsg.StaticTextViewHolder", "recreateLayoutIfNeed, width: %d, hasCode: %d, used: %fms, text: %s", Integer.valueOf(i), Integer.valueOf(hashCode()), Double.valueOf(((double) (nanoTime - j)) / 1000000.0d), this.text);
                }
                return true;
            }
        }
        return false;
    }

    public final Point aG(int i, int i2) {
        Point point;
        long j = 0;
        if (h.DEBUG) {
            j = System.nanoTime();
        }
        int mode = MeasureSpec.getMode(i);
        int mode2 = MeasureSpec.getMode(i2);
        int size = MeasureSpec.getSize(i);
        int size2 = MeasureSpec.getSize(i2);
        eP(size);
        if (this.haP != null) {
            int i3;
            int i4;
            if (mode != 1073741824) {
                i3 = 0;
                if (this.haO.haA == null) {
                    Layout layout = this.haP;
                    if (this.haY != 0) {
                        i3 = this.haY;
                    } else {
                        int lineCount = layout.getLineCount();
                        CharSequence text = layout.getText();
                        float f = 0.0f;
                        for (i4 = 0; i4 < lineCount - 1; i4++) {
                            if (text.charAt(layout.getLineEnd(i4) - 1) != '\n') {
                                i3 = -1;
                                break;
                            }
                        }
                        for (i4 = 0; i4 < lineCount; i4++) {
                            f = Math.max(f, layout.getLineWidth(i4));
                        }
                        this.haY = (int) Math.ceil((double) f);
                        this.haY += this.haX.getPaddingLeft() + this.haX.getPaddingRight();
                        i3 = this.haY;
                    }
                }
                i4 = (int) Math.ceil((double) Layout.getDesiredWidth(this.haP.getText(), this.haP.getPaint()));
                if (i4 > i3) {
                    i3 = i4;
                }
                if (h.DEBUG) {
                    w.d("MicroMsg.StaticTextViewHolder", "onMeasure  hashCode: %d, des: %d newdes: %d", Integer.valueOf(hashCode()), Integer.valueOf(i3), Integer.valueOf(i4));
                }
                if (mode == Integer.MIN_VALUE) {
                    size = Math.min(size, i3);
                } else {
                    size = i3;
                }
            }
            if (mode2 == 1073741824) {
                i3 = size2;
            } else {
                Layout layout2 = this.haP;
                if (this.haZ != 0) {
                    i3 = this.haZ;
                } else {
                    i3 = layout2.getLineCount();
                    if (this.haN.maxLines > 0 && this.haN.maxLines < i3) {
                        i3 = this.haN.maxLines;
                    }
                    mode = this.haX.getPaddingTop() + this.haX.getPaddingBottom();
                    i4 = layout2.getLineTop(i3);
                    if (this.haO.minLines <= 0 || i3 >= this.haO.minLines) {
                        i3 = i4;
                    } else {
                        i3 = ((this.haO.minLines - i3) * getLineHeight()) + i4;
                    }
                    this.haZ = i3 + mode;
                    i3 = this.haZ;
                }
                if (mode2 == Integer.MIN_VALUE) {
                    i3 = Math.min(i3, size2);
                }
            }
            point = new Point(size, i3);
        } else {
            point = null;
        }
        if (h.DEBUG) {
            String str = "MicroMsg.StaticTextViewHolder";
            String str2 = "onMeasure used: %fms, hashCode: %d, text: %s result: %s";
            Object[] objArr = new Object[4];
            objArr[0] = Double.valueOf(((double) (System.nanoTime() - j)) / 1000000.0d);
            objArr[1] = Integer.valueOf(hashCode());
            objArr[2] = this.text;
            objArr[3] = point == null ? "" : point.toString();
            w.d(str, str2, objArr);
        }
        return point;
    }
}
