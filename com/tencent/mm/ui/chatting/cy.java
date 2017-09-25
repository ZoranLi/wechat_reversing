package com.tencent.mm.ui.chatting;

import android.graphics.drawable.ColorDrawable;
import android.os.Message;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.style.BackgroundColorSpan;
import android.text.style.ClickableSpan;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.MMTextView;
import com.tencent.mm.ui.widget.MMTextView.b;
import com.tencent.mm.ui.widget.celltextview.CellTextView;

final class cy implements b {
    public ae handler = new ae(this) {
        final /* synthetic */ cy vFV;

        {
            this.vFV = r1;
        }

        public final void handleMessage(Message message) {
            View view = (View) message.obj;
            if (this.vFV.saE != view.getScrollY()) {
                this.vFV.qVZ = true;
                this.vFV.handler.sendMessageDelayed(this.vFV.handler.obtainMessage(0, view), 5);
                this.vFV.saE = view.getScrollY();
                return;
            }
            this.vFV.qVZ = false;
        }
    };
    public o iuS = null;
    private ScrollView liX = null;
    long oIN = 0;
    public boolean qVZ = false;
    public boolean qWa = false;
    public int saE = 0;
    private OnTouchListener uXb = null;
    private com.tencent.mm.ui.chatting.En_5b8fbb1e.a vCd = null;
    private MMTextView vFQ = null;
    private TextView vFR = null;
    private final int vFS = 3;
    private int vFT = 0;
    public int vFU = 0;

    public static class a extends LinkMovementMethod {
        a vFX;

        public interface a {
            void a(MotionEvent motionEvent, Spannable spannable, ClickableSpan clickableSpan);
        }

        public final boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            if (action == 1 || action == 0) {
                int x = (((int) motionEvent.getX()) - textView.getTotalPaddingLeft()) + textView.getScrollX();
                int y = (((int) motionEvent.getY()) - textView.getTotalPaddingTop()) + textView.getScrollY();
                Layout layout = textView.getLayout();
                x = layout.getOffsetForHorizontal(layout.getLineForVertical(y), (float) x);
                ClickableSpan[] clickableSpanArr = (ClickableSpan[]) spannable.getSpans(x, x, ClickableSpan.class);
                if (clickableSpanArr.length != 0) {
                    if (this.vFX != null) {
                        this.vFX.a(motionEvent, spannable, clickableSpanArr[0]);
                    }
                    if (action == 1) {
                        clickableSpanArr[0].onClick(textView);
                    } else if (action == 0) {
                        Selection.setSelection(spannable, spannable.getSpanStart(clickableSpanArr[0]), spannable.getSpanEnd(clickableSpanArr[0]));
                    }
                    return true;
                }
                Selection.removeSelection(spannable);
            } else if (this.vFX != null) {
                this.vFX.a(motionEvent, spannable, null);
            }
            return super.onTouchEvent(textView, spannable, motionEvent);
        }
    }

    public final void reset() {
        this.saE = 0;
        this.vFU = 0;
        this.qVZ = false;
        this.qWa = false;
        this.handler.removeMessages(0);
    }

    public cy(com.tencent.mm.ui.chatting.En_5b8fbb1e.a aVar) {
        this.vCd = aVar;
    }

    public final boolean ds(View view) {
        if (view.getTag() instanceof dt) {
            dt dtVar = (dt) view.getTag();
            if (dtVar.knu == 0 && !((!(view instanceof TextView) && !(view instanceof CellTextView)) || dtVar.fTk == null || this.vCd == null)) {
                q qVar = this.vCd;
                if (this.iuS == null) {
                    View inflate = View.inflate(qVar.uSU.uTo, R.i.cYa, null);
                    this.liX = (ScrollView) inflate.findViewById(R.h.bSn);
                    this.vFQ = (MMTextView) inflate.findViewById(R.h.bSo);
                    this.vFR = (TextView) inflate.findViewById(R.h.bSp);
                    this.uXb = new OnTouchListener(this) {
                        final /* synthetic */ cy vFV;

                        {
                            this.vFV = r1;
                        }

                        public final boolean onTouch(View view, MotionEvent motionEvent) {
                            if (motionEvent.getAction() == 0) {
                                this.vFV.oIN = u.NA();
                                this.vFV.saE = view.getScrollY();
                                this.vFV.vFU = this.vFV.saE;
                                this.vFV.handler.removeMessages(0);
                                if (this.vFV.qVZ) {
                                    this.vFV.qVZ = false;
                                    this.vFV.qWa = true;
                                }
                            } else if (motionEvent.getAction() != 2 && (motionEvent.getAction() == 3 || motionEvent.getAction() == 1 || motionEvent.getAction() == 4)) {
                                if (Math.abs(this.vFV.vFU - view.getScrollY()) > 3) {
                                    this.vFV.handler.sendMessage(this.vFV.handler.obtainMessage(0, view));
                                }
                                if (u.NA() - this.vFV.oIN < 800 && Math.abs(this.vFV.vFU - view.getScrollY()) <= 3 && !this.vFV.qWa && this.vFV.iuS != null && this.vFV.iuS.isShowing()) {
                                    this.vFV.handler.removeMessages(0);
                                    this.vFV.reset();
                                    this.vFV.iuS.dismiss();
                                }
                                this.vFV.qWa = false;
                            }
                            return false;
                        }
                    };
                    this.liX.setOnTouchListener(this.uXb);
                    inflate.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ cy vFV;

                        {
                            this.vFV = r1;
                        }

                        public final void onClick(View view) {
                            if (this.vFV.iuS != null && this.vFV.iuS.isShowing()) {
                                this.vFV.reset();
                                this.vFV.iuS.dismiss();
                            }
                        }
                    });
                    this.iuS = new o(inflate, -1, -1, true);
                    this.iuS.setAnimationStyle(R.m.fox);
                    this.iuS.update();
                    this.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
                    this.iuS.setOnDismissListener(new OnDismissListener(this) {
                        final /* synthetic */ cy vFV;

                        {
                            this.vFV = r1;
                        }

                        public final void onDismiss() {
                        }
                    });
                }
                if (!(this.iuS == null || this.iuS.isShowing())) {
                    this.liX.scrollTo(0, 0);
                    CharSequence charSequence = "";
                    if (view instanceof TextView) {
                        charSequence = ((TextView) view).getText();
                    } else if (view instanceof CellTextView) {
                        charSequence = ((CellTextView) view).caS();
                    }
                    if (charSequence instanceof SpannableString) {
                        TextView textView = this.vFR;
                        if (charSequence instanceof SpannableString) {
                            textView.setText(((SpannableString) charSequence).toString());
                            h.d(textView, 1);
                            charSequence = textView.getText();
                        }
                        com.tencent.mm.modelstat.b.hUp.x(dtVar.fTk);
                    }
                    this.vCd.are();
                    this.vFQ.setText(charSequence);
                    this.vFQ.setTextIsSelectable(true);
                    this.iuS.showAtLocation(view.getRootView(), 17, 0, 0);
                    this.iuS.setFocusable(true);
                    this.iuS.setTouchable(true);
                    this.iuS.setBackgroundDrawable(new ColorDrawable(16777215));
                    this.iuS.setOutsideTouchable(true);
                    MovementMethod aVar = new a();
                    aVar.vFX = new a(this) {
                        final /* synthetic */ cy vFV;
                        private ClickableSpan vFW = null;

                        {
                            this.vFV = r2;
                        }

                        public final void a(MotionEvent motionEvent, Spannable spannable, ClickableSpan clickableSpan) {
                            int action = motionEvent.getAction();
                            if (action == 0) {
                                if (clickableSpan != null) {
                                    if (!(ab.getContext() == null || ab.getContext().getResources() == null)) {
                                        spannable.setSpan(new BackgroundColorSpan(ab.getContext().getResources().getColor(R.e.aUC)), spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan), 33);
                                    }
                                    this.vFW = clickableSpan;
                                }
                            } else if (action == 1) {
                                if (clickableSpan != null) {
                                    spannable.setSpan(new BackgroundColorSpan(-1), spannable.getSpanStart(clickableSpan), spannable.getSpanEnd(clickableSpan), 33);
                                }
                            } else if (action == 3 && this.vFW != null) {
                                spannable.setSpan(new BackgroundColorSpan(-1), spannable.getSpanStart(this.vFW), spannable.getSpanEnd(this.vFW), 33);
                            }
                        }
                    };
                    this.vFQ.setMovementMethod(aVar);
                    this.vFQ.setFocusable(false);
                    this.vFQ.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ cy vFV;

                        {
                            this.vFV = r1;
                        }

                        public final void onClick(View view) {
                            if (this.vFV.iuS != null && this.vFV.iuS.isShowing()) {
                                this.vFV.iuS.dismiss();
                            }
                        }
                    });
                    this.iuS.update();
                    if (dtVar.fTk.bLZ()) {
                        g.oUh.i(14220, Integer.valueOf(0), Integer.valueOf(1), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    }
                }
                return true;
            }
        }
        return false;
    }
}
