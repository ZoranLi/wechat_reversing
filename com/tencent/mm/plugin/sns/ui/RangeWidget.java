package com.tencent.mm.plugin.sns.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.j.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.i;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.ui.base.g;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class RangeWidget extends RelativeLayout {
    private View ipu;
    private Activity oqR;
    private ImageView qpP;
    SnsUploadConfigView qpS;
    private String qsI = "";
    private String qsJ = "";
    private TextView qwX;
    private boolean qwY = true;
    int qwZ = 0;
    String qxa = "";
    boolean qxb = false;
    public int style = 0;

    public RangeWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public RangeWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    private void init(Context context) {
        this.oqR = (Activity) context;
        this.ipu = View.inflate(context, getLayoutResource(), this);
        this.qwX = (TextView) this.ipu.findViewById(f.pFS);
        this.qpP = (ImageView) this.ipu.findViewById(f.pDv);
        this.ipu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ RangeWidget qxc;

            {
                this.qxc = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent(this.qxc.oqR, SnsLabelUI.class);
                intent.putExtra("KLabel_range_index", this.qxc.qwZ);
                intent.putExtra("Klabel_name_list", this.qxc.qsI);
                intent.putExtra("Kother_user_name_list", this.qxc.qsJ);
                intent.putExtra("Ktag_rangeFilterprivate", this.qxc.qxb);
                intent.putExtra("k_sns_label_ui_style", this.qxc.style);
                this.qxc.oqR.startActivityForResult(intent, 5);
            }
        });
    }

    private static List<String> ae(List<String> list) {
        List<String> linkedList = new LinkedList();
        h.vJ();
        if (!h.vG().uV()) {
            return linkedList;
        }
        if (list == null) {
            return linkedList;
        }
        for (Object obj : list) {
            Object obj2;
            h.vJ();
            a Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(obj2);
            if (!(Rc == null || ((int) Rc.gTQ) == 0)) {
                obj2 = Rc.tL();
            }
            linkedList.add(obj2);
        }
        return linkedList;
    }

    public boolean a(int i, int i2, Intent intent, AtContactWidget atContactWidget) {
        String c;
        this.qwZ = intent.getIntExtra("Ktag_range_index", 0);
        this.qsI = intent.getStringExtra("Klabel_name_list");
        this.qsJ = intent.getStringExtra("Kother_user_name_list");
        int bjB = bjB();
        Object obj = "";
        if (!bg.mA(this.qsI)) {
            obj = obj + this.qsI;
        }
        if (!bg.mA(this.qsJ)) {
            c = bg.c(ae(Arrays.asList(this.qsJ.split(","))), ",");
            if (obj.length() > 0) {
                obj = obj + "," + c;
            } else {
                obj = obj + c;
            }
        }
        if (!(bjB == -1 || obj == null || obj.length() <= bjB)) {
            obj = obj.substring(0, bjB) + "...";
        }
        bjB = this.qwZ;
        if (this.qpP != null) {
            this.qpP.setImageResource(i.pJu);
        }
        if (this.qpS != null) {
            this.qpS.hN(false);
        }
        switch (bjB) {
            case 0:
                if (this.qpP != null) {
                    this.qpP.setImageResource(i.pJt);
                }
                this.qwX.setText(j.pLC);
                break;
            case 1:
                if (this.qpS != null) {
                    this.qpS.hN(true);
                }
                if (!(atContactWidget == null || this.qpS == null || atContactWidget.bif().size() <= 0)) {
                    g.h(this.oqR, j.pMz, j.dIO);
                    atContactWidget.big();
                    this.qpS.bld();
                }
                this.qwX.setText(j.pLA);
                break;
            case 2:
                this.qwX.setText(obj);
                break;
            case 3:
                TextView textView = this.qwX;
                c = this.oqR.getString(j.pLo);
                obj = c + "  " + obj;
                CharSequence spannableString = new SpannableString(obj);
                spannableString.setSpan(new ForegroundColorSpan(-65536), c.length() + 2, obj.length(), 33);
                textView.setText(spannableString);
                break;
        }
        return true;
    }

    protected int getLayoutResource() {
        return com.tencent.mm.plugin.sns.i.g.pGR;
    }

    protected int bjB() {
        return -1;
    }
}
