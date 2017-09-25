package com.tencent.mm.plugin.scanner.ui;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.base.preference.Preference;

public final class e extends Preference {
    private Context context;
    private TextView ioX;
    String mTitle;
    private View mView;
    private OnTouchListener nIz;
    private final int oYC = 5;
    public TextView oYD;
    public boolean oYE = false;
    public boolean oYF = false;
    public Boolean oYG;
    private OnGlobalLayoutListener oYH;
    public a oYI;
    public TextView ouW;

    public interface a {
        Boolean DH(String str);

        void a(String str, Boolean bool);

        void aYE();
    }

    public e(Activity activity) {
        super(activity);
        setLayoutResource(R.i.dja);
        this.context = activity;
    }

    public final View getView(View view, ViewGroup viewGroup) {
        if (this.mView == null) {
            this.mView = onCreateView(viewGroup);
        }
        onBindView(this.mView);
        return this.mView;
    }

    protected final void onBindView(View view) {
        super.onBindView(view);
        if (this.ioX == null) {
            this.ioX = (TextView) view.findViewById(16908310);
        }
        if (this.ouW == null) {
            this.ouW = (TextView) view.findViewById(16908304);
        }
        if (this.oYD == null) {
            this.oYD = (TextView) view.findViewById(R.h.cld);
        }
        if (this.nIz == null) {
            this.nIz = new OnTouchListener(this) {
                final /* synthetic */ e oYJ;

                {
                    this.oYJ = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() == 0) {
                        w.d("MicroMsg.scanner.PlainTextPreference", "moreTv onTouch");
                        this.oYJ.oYD.setVisibility(4);
                        this.oYJ.ouW.setMaxLines(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
                        this.oYJ.oYE = true;
                        if (this.oYJ.oYI != null) {
                            this.oYJ.oYI.a(this.oYJ.igL, Boolean.valueOf(true));
                            this.oYJ.oYI.aYE();
                        }
                    }
                    return false;
                }
            };
            this.oYD.setOnTouchListener(this.nIz);
        }
        if (this.oYI != null) {
            this.oYG = this.oYI.DH(this.igL);
            if (this.oYG == null) {
                this.oYD.setVisibility(8);
                this.ouW.setMaxLines(6);
            } else if (this.oYG.booleanValue()) {
                this.oYD.setVisibility(8);
                this.ouW.setMaxLines(MMBitmapFactory.ERROR_IMG_BUG_DETECTED_BEGIN);
            } else {
                this.oYD.setVisibility(0);
                this.ouW.setMaxLines(5);
            }
        } else {
            this.oYD.setVisibility(8);
            this.ouW.setMaxLines(6);
        }
        if (this.oYH == null) {
            this.oYH = new OnGlobalLayoutListener(this) {
                final /* synthetic */ e oYJ;

                {
                    this.oYJ = r1;
                }

                public final void onGlobalLayout() {
                    w.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() = " + this.oYJ.ouW.getHeight() + ", summaryTv.getLineHeight() = " + this.oYJ.ouW.getLineHeight());
                    if (this.oYJ.ouW.getText() != null && this.oYJ.ouW.getHeight() > 0 && this.oYJ.ouW.getLineHeight() > 0 && this.oYJ.oYG == null) {
                        if (!(this.oYJ.ouW.getHeight() / this.oYJ.ouW.getLineHeight() <= 5 || this.oYJ.oYF || this.oYJ.oYE)) {
                            this.oYJ.oYD.setVisibility(0);
                            this.oYJ.ouW.setMaxLines(5);
                            this.oYJ.oYF = true;
                            if (this.oYJ.oYI != null && this.oYJ.oYI.DH(this.oYJ.igL) == null) {
                                this.oYJ.oYI.a(this.oYJ.igL, Boolean.valueOf(false));
                                this.oYJ.oYI.aYE();
                            }
                        }
                        w.d("MicroMsg.scanner.PlainTextPreference", "summaryTv.getHeight() / summaryTv.getLineHeight() = " + (this.oYJ.ouW.getHeight() / this.oYJ.ouW.getLineHeight()));
                    }
                    this.oYJ.ouW.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                }
            };
            this.ouW.getViewTreeObserver().addOnGlobalLayoutListener(this.oYH);
        }
        if (bg.mA(this.mTitle)) {
            this.ioX.setVisibility(8);
            return;
        }
        this.ioX.setText(this.mTitle);
        this.ioX.setVisibility(0);
    }
}
