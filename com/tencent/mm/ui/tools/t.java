package com.tencent.mm.ui.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.FontMetricsInt;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.widget.EditText;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class t {
    String jqT;
    List<b> woU;
    WeakReference<EditText> woV;
    ArrayList<String> woW;
    boolean woX;

    public static class a extends Drawable {
        private static int wkz;
        private RectF fw;
        private String jqT;
        private Paint omd = new Paint(1);
        private float wkA;
        private float wkB;
        private Paint wky;
        private float woY;
        private float woZ;

        public a(Context context, String str, Paint paint) {
            this.omd.setColor(-7829368);
            this.wky = paint;
            wkz = com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b.a(context, 2.0f);
            this.woY = (float) wkz;
            this.woZ = (float) wkz;
            this.jqT = str;
            this.wkA = this.wky.measureText(this.jqT);
            FontMetrics fontMetrics = this.wky.getFontMetrics();
            this.wkB = (float) Math.ceil((double) (fontMetrics.bottom - fontMetrics.top));
            setBounds(0, 0, (int) ((this.wkA + ((float) (wkz * 2))) + ((float) (wkz * 2))), (int) this.wkB);
            w.i("MicroMsg.TextDrawable", "setText(%s).", str);
        }

        public final void draw(Canvas canvas) {
            canvas.drawRoundRect(this.fw, this.woY, this.woZ, this.omd);
            Rect bounds = getBounds();
            int i = (int) (((((float) (bounds.right - bounds.left)) - (this.fw.right - this.fw.left)) + ((float) (wkz * 2))) / 2.0f);
            FontMetricsInt fontMetricsInt = this.wky.getFontMetricsInt();
            canvas.drawText(this.jqT, (float) i, (float) ((((((bounds.bottom - bounds.top) - fontMetricsInt.bottom) + fontMetricsInt.top) / 2) + bounds.top) - fontMetricsInt.top), this.wky);
        }

        public final void setAlpha(int i) {
            if (i != this.omd.getAlpha()) {
                this.omd.setAlpha(i);
                invalidateSelf();
            }
        }

        public final void setColorFilter(ColorFilter colorFilter) {
            this.omd.setColorFilter(colorFilter);
            invalidateSelf();
        }

        public final int getOpacity() {
            return this.omd.getAlpha() < 255 ? -3 : -1;
        }

        public final void setBounds(int i, int i2, int i3, int i4) {
            super.setBounds(i, i2, i3, i4);
            FontMetrics fontMetrics = this.wky.getFontMetrics();
            this.fw = new RectF((float) (wkz + i), (fontMetrics.ascent - fontMetrics.top) + ((float) i2), (float) (i3 - wkz), (float) i4);
            invalidateSelf();
        }
    }

    private static class b {
        int length;
        int start;
        boolean wpa;

        b(int i, int i2, boolean z) {
            this.start = i;
            this.length = i2;
            this.wpa = z;
        }
    }

    public t(EditText editText) {
        this.woV = new WeakReference(editText);
    }

    final b Cf(int i) {
        if (this.woU != null) {
            for (b bVar : this.woU) {
                if (i <= bVar.start + bVar.length && i > bVar.start) {
                    return bVar;
                }
            }
        }
        return null;
    }

    static boolean a(EditText editText, ArrayList<String> arrayList) {
        String obj = editText.getText().toString();
        CharSequence spannableStringBuilder = new SpannableStringBuilder();
        List<b> i = i(obj, arrayList);
        if (i == null || i.size() <= 0) {
            return false;
        }
        int selectionStart = editText.getSelectionStart();
        int selectionEnd = editText.getSelectionEnd();
        Context context = editText.getContext();
        Paint paint = editText.getPaint();
        for (b bVar : i) {
            int i2 = bVar.start;
            int i3 = bVar.length;
            if (i2 < 0 || i3 <= 0 || i2 + i3 > obj.length()) {
                w.i("MicroMsg.WordsChecker", "start : %d, length : %d.", Integer.valueOf(i2), Integer.valueOf(i3));
            } else if (bVar.wpa) {
                String substring = obj.substring(i2, i2 + i3);
                CharSequence spannableString = new SpannableString(substring);
                spannableString.setSpan(new ImageSpan(new a(context, substring, paint), 0), 0, substring.length(), 33);
                spannableStringBuilder.append(spannableString);
            } else {
                spannableStringBuilder.append(obj.substring(i2, i2 + i3));
            }
        }
        if (spannableStringBuilder.length() > 0) {
            editText.setText(spannableStringBuilder);
            editText.setTextKeepState(spannableStringBuilder);
            if (selectionStart == selectionEnd && selectionStart >= 0) {
                editText.setSelection(selectionStart);
            }
        }
        return true;
    }

    static List<b> i(String str, ArrayList<String> arrayList) {
        if (bg.mA(str) || arrayList == null || arrayList.size() == 0) {
            return null;
        }
        List<b> arrayList2 = new ArrayList();
        int length = str.length();
        int i = 0;
        while (i <= length) {
            Iterator it = arrayList.iterator();
            int i2 = 0;
            int i3 = length;
            while (it.hasNext()) {
                String str2 = (String) it.next();
                if (!bg.mA(str2)) {
                    int i4;
                    int indexOf = str.indexOf(str2, i);
                    if (indexOf < 0 || (indexOf >= i3 && (indexOf != i3 || str2.length() <= i2))) {
                        i4 = i2;
                        i2 = i3;
                    } else {
                        i4 = str2.length();
                        i2 = indexOf;
                    }
                    i3 = i2;
                    i2 = i4;
                }
            }
            if (i3 < length) {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                arrayList2.add(new b(i3, i2, true));
                i = i3 + i2;
            } else {
                if (i3 > i) {
                    arrayList2.add(new b(i, i3 - i, false));
                }
                return arrayList2;
            }
        }
        return arrayList2;
    }
}
