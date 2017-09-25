package com.tencent.mm.ui.chatting;

import android.graphics.drawable.Drawable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spannable.Factory;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.widget.d;

final class bx implements a {

    static class a extends LinkMovementMethod {
        private c vDY;

        a() {
        }

        public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            if (motionEvent.getAction() == 0) {
                this.vDY = a(textView, spannable, motionEvent);
                if (this.vDY != null) {
                    this.vDY.vEa = true;
                    Selection.setSelection(spannable, spannable.getSpanStart(this.vDY), spannable.getSpanEnd(this.vDY));
                }
            } else if (motionEvent.getAction() == 2) {
                c a = a(textView, spannable, motionEvent);
                if (!(this.vDY == null || a == this.vDY)) {
                    this.vDY.vEa = false;
                    this.vDY = null;
                    Selection.removeSelection(spannable);
                }
            } else {
                if (this.vDY != null) {
                    this.vDY.vEa = false;
                    super.onTouchEvent(textView, spannable, motionEvent);
                }
                this.vDY = null;
                Selection.removeSelection(spannable);
            }
            return true;
        }

        private static c a(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
            int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
            Layout layout = textView.getLayout();
            x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
            c[] cVarArr = (c[]) spannable.getSpans(x, x, c.class);
            if (cVarArr.length > 0) {
                return cVarArr[0];
            }
            return null;
        }
    }

    static class b {
        public int end;
        public int start;
        public ClickableSpan vDZ;

        b() {
        }
    }

    static abstract class c extends ClickableSpan {
        boolean vEa;
        private int vEb;
        private int vEc;

        public c(int i, int i2) {
            this.vEb = i;
            this.vEc = i2;
        }

        public void updateDrawState(TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.vEa ? this.vEc : this.vEb);
            textPaint.setUnderlineText(false);
        }
    }

    bx() {
    }

    public final void a(com.tencent.mm.ui.chatting.ah.a aVar, int i, com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar2, au auVar) {
        final b bVar = (b) aVar;
        int color = bVar.suV.getContext().getResources().getColor(R.e.aUA);
        int color2 = bVar.suV.getContext().getResources().getColor(R.e.aUB);
        final com.tencent.mm.an.a bMD = auVar.bMD();
        if (bMD == null) {
            bVar.mil.setVisibility(8);
        } else {
            int i2;
            CharSequence charSequence;
            bVar.mil.setVisibility(0);
            bVar.suV.setText(h.b(bVar.suV.getContext(), bg.mz(bMD.hMY), bVar.suV.getTextSize()));
            bVar.suV.setMovementMethod(new a());
            Object newSpannable;
            if (bMD.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApplication") || bMD.TYPE.equalsIgnoreCase("NewXmlChatRoomAccessVerifyApproval")) {
                color = bVar.suV.getContext().getResources().getColor(R.e.aUd);
                color2 = bVar.suV.getContext().getResources().getColor(R.e.aTb);
                if (auVar.bMz()) {
                    color = bVar.suV.getContext().getResources().getColor(R.e.aUd);
                    color2 = bVar.suV.getContext().getResources().getColor(R.e.aTb);
                    newSpannable = Factory.getInstance().newSpannable(bVar.suV.getText());
                    i2 = 0;
                } else {
                    Spannable newSpannable2 = Factory.getInstance().newSpannable("    " + bVar.suV.getText());
                    Drawable drawable = bVar.suV.getContext().getResources().getDrawable(R.k.dxv);
                    drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    d dVar = new d(drawable);
                    dVar.wuA = (int) (((((float) drawable.getIntrinsicHeight()) - bVar.suV.getTextSize()) + ((float) com.tencent.mm.bg.a.fromDPToPix(bVar.suV.getContext(), 2))) / 2.0f);
                    newSpannable2.setSpan(dVar, 0, 3, 33);
                    charSequence = newSpannable2;
                    i2 = 4;
                }
            } else {
                newSpannable = Factory.getInstance().newSpannable(bVar.suV.getText());
                i2 = 0;
            }
            for (int i3 = 0; i3 < bMD.hNa.size(); i3++) {
                b bVar2 = new b();
                final com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar3 = aVar2;
                final au auVar2 = auVar;
                final int i4 = i;
                bVar2.vDZ = new c(this, color, color2) {
                    final /* synthetic */ bx vDX;

                    public final void onClick(View view) {
                        w.i("MicroMsg.ChattingItemNewXmlSysImpl", "[onClick] pBaseNewXmlMsg:%s", bMD);
                        aVar3.a(bVar.mil, auVar2, bMD, i3);
                    }
                };
                bVar2.start = ((Integer) bMD.hNb.get(i3)).intValue();
                bVar2.end = ((Integer) bMD.hNc.get(i3)).intValue();
                charSequence.setSpan(bVar2.vDZ, bVar2.start + i2, bVar2.end + i2, 33);
            }
            bVar.suV.setText(charSequence);
            bVar.suV.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ bx vDX;

                {
                    this.vDX = r1;
                }

                public final void onClick(View view) {
                    w.d("MicroMsg.ChattingItemNewXmlSysImpl", "clicked");
                }
            });
        }
        bVar.suV.invalidate();
    }
}
