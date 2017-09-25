package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import java.util.ArrayList;

public class GameDetailAutoScrollView extends LinearLayout {
    int kZt = 0;
    aj mxh = new aj(new a(this) {
        final /* synthetic */ GameDetailAutoScrollView myR;

        {
            this.myR = r1;
        }

        public final boolean oQ() {
            GameDetailAutoScrollView.a(this.myR);
            return true;
        }
    }, true);
    ArrayList<String> myI = new ArrayList();
    ViewGroup myJ;
    TextView myK;
    TextView myL;
    ViewGroup myM;
    private TextView myN;
    private TextView myO;
    private Animation myP;
    private Animation myQ;

    static /* synthetic */ void a(GameDetailAutoScrollView gameDetailAutoScrollView) {
        if (gameDetailAutoScrollView.kZt < (gameDetailAutoScrollView.myI.size() / 2) - 1) {
            gameDetailAutoScrollView.kZt++;
        } else {
            gameDetailAutoScrollView.kZt = 0;
        }
        String str = (String) gameDetailAutoScrollView.myI.get((gameDetailAutoScrollView.kZt * 2) + 1);
        gameDetailAutoScrollView.myN.setText(h.b(gameDetailAutoScrollView.getContext(), (String) gameDetailAutoScrollView.myI.get(gameDetailAutoScrollView.kZt * 2), gameDetailAutoScrollView.myN.getTextSize()));
        gameDetailAutoScrollView.myO.setText(str);
        gameDetailAutoScrollView.myJ.startAnimation(gameDetailAutoScrollView.myQ);
        gameDetailAutoScrollView.myJ.setVisibility(8);
        gameDetailAutoScrollView.myM.startAnimation(gameDetailAutoScrollView.myP);
        gameDetailAutoScrollView.myM.setVisibility(0);
        ViewGroup viewGroup = gameDetailAutoScrollView.myJ;
        gameDetailAutoScrollView.myJ = gameDetailAutoScrollView.myM;
        gameDetailAutoScrollView.myM = viewGroup;
        TextView textView = gameDetailAutoScrollView.myK;
        gameDetailAutoScrollView.myK = gameDetailAutoScrollView.myN;
        gameDetailAutoScrollView.myN = textView;
        textView = gameDetailAutoScrollView.myL;
        gameDetailAutoScrollView.myL = gameDetailAutoScrollView.myO;
        gameDetailAutoScrollView.myO = textView;
    }

    public GameDetailAutoScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.myJ = (ViewGroup) LayoutInflater.from(context).inflate(R.i.deq, this, false);
        this.myK = (TextView) this.myJ.findViewById(R.h.bSS);
        this.myL = (TextView) this.myJ.findViewById(R.h.bST);
        addView(this.myJ);
        this.myJ.setVisibility(8);
        this.myM = (ViewGroup) LayoutInflater.from(context).inflate(R.i.deq, this, false);
        this.myN = (TextView) this.myM.findViewById(R.h.bSS);
        this.myO = (TextView) this.myM.findViewById(R.h.bST);
        addView(this.myM);
        this.myM.setVisibility(8);
        this.myP = AnimationUtils.loadAnimation(context, R.a.aRK);
        this.myQ = AnimationUtils.loadAnimation(context, R.a.aRQ);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mxh.KH();
    }
}
