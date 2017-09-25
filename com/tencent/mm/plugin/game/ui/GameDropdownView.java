package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import java.util.LinkedList;

public class GameDropdownView extends TextView implements OnClickListener, OnDismissListener {
    private int mAA = 0;
    a mAB = null;
    View mAC = null;
    private OnClickListener mAD = new OnClickListener(this) {
        final /* synthetic */ GameDropdownView mAE;

        {
            this.mAE = r1;
        }

        public final void onClick(View view) {
            if (this.mAE.mAx.getContentView() == null || !(this.mAE.mAx.getContentView() instanceof ViewGroup)) {
                this.mAE.mAx.dismiss();
                return;
            }
            GameDropdownView.a(this.mAE, ((ViewGroup) this.mAE.mAx.getContentView()).indexOfChild(view));
            this.mAE.mAx.dismiss();
        }
    };
    private b mAx;
    private LinkedList<String> mAy;
    private int mAz = 0;
    private Context mContext;

    public interface a {
        void nI(int i);
    }

    private static class b extends PopupWindow {
        public b(Context context) {
            super(context);
            setWindowLayoutMode(-1, -2);
            setBackgroundDrawable(new BitmapDrawable());
            setFocusable(true);
            setOutsideTouchable(true);
            setTouchInterceptor(new OnTouchListener(this) {
                final /* synthetic */ b mAF;

                {
                    this.mAF = r1;
                }

                public final boolean onTouch(View view, MotionEvent motionEvent) {
                    if (motionEvent.getAction() != 4) {
                        return false;
                    }
                    this.mAF.dismiss();
                    return true;
                }
            });
            setAnimationStyle(R.a.aRe);
        }
    }

    static /* synthetic */ void a(GameDropdownView gameDropdownView, int i) {
        if (gameDropdownView.mAx.getContentView() != null && (gameDropdownView.mAx.getContentView() instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) gameDropdownView.mAx.getContentView();
            if (i <= gameDropdownView.mAA && gameDropdownView.mAz <= gameDropdownView.mAA && (viewGroup.getChildAt(i) instanceof TextView) && (viewGroup.getChildAt(gameDropdownView.mAz) instanceof TextView)) {
                ((TextView) viewGroup.getChildAt(gameDropdownView.mAz)).setTextColor(gameDropdownView.mContext.getResources().getColor(R.e.aUo));
                ((TextView) viewGroup.getChildAt(i)).setTextColor(gameDropdownView.mContext.getResources().getColor(R.e.aVo));
                gameDropdownView.setText((CharSequence) gameDropdownView.mAy.get(i));
                if (!(gameDropdownView.mAB == null || gameDropdownView.mAz == i)) {
                    gameDropdownView.mAB.nI(i);
                }
                gameDropdownView.mAz = i;
            }
        }
    }

    public GameDropdownView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        this.mAx = new b(context);
        setOnClickListener(this);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        setVisibility(8);
    }

    public void onClick(View view) {
        if (this.mAx.isShowing()) {
            this.mAx.dismiss();
        } else if (this.mAC == null) {
            this.mAx.showAsDropDown(this);
        } else {
            this.mAx.showAsDropDown(this.mAC);
        }
    }

    public void onDismiss() {
    }

    public final void b(LinkedList<String> linkedList, int i) {
        if (linkedList.size() != 0) {
            this.mAy = linkedList;
            this.mAA = linkedList.size() - 1;
            if (i < 0 || i > this.mAA) {
                this.mAz = 0;
            } else {
                this.mAz = i;
            }
            LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
            LinearLayout linearLayout = (LinearLayout) layoutInflater.inflate(R.i.deL, null);
            for (int i2 = 0; i2 < linkedList.size(); i2++) {
                String str = (String) linkedList.get(i2);
                TextView textView = (TextView) layoutInflater.inflate(R.i.deM, linearLayout, false);
                textView.setText(str);
                textView.setOnClickListener(this.mAD);
                if (i2 == this.mAz) {
                    textView.setTextColor(this.mContext.getResources().getColor(R.e.aVo));
                    setText(str);
                }
                linearLayout.addView(textView);
            }
            this.mAx.setContentView(linearLayout);
            setVisibility(0);
        }
    }
}
