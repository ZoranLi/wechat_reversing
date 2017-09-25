package com.tencent.mm.plugin.sns.ui;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.sns.c.a;
import com.tencent.mm.plugin.sns.i;
import com.tencent.mm.plugin.sns.i.f;
import com.tencent.mm.plugin.sns.i.j;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.r;
import java.util.LinkedList;
import java.util.List;

public class AtContactWidget extends LinearLayout {
    private View ipu;
    private Activity oqR;
    private ImageView qpP;
    private TextView qpQ;
    private PreviewContactView qpR;
    SnsUploadConfigView qpS;
    private List<String> qpT = new LinkedList();
    private boolean qpU = false;

    static /* synthetic */ void a(AtContactWidget atContactWidget) {
        if (atContactWidget.qpT == null) {
            atContactWidget.qpT = new LinkedList();
        }
        if (atContactWidget.qpS == null || atContactWidget.qpS.blg() <= 0) {
            Intent intent = new Intent();
            intent.putExtra("Contact_Compose", true);
            intent.putExtra("List_Type", 1);
            intent.putExtra("Add_address_titile", atContactWidget.oqR.getString(j.pNc));
            intent.putExtra("Contact_GroupFilter_Type", "@micromsg.qq.com");
            intent.putExtra("Block_list", m.xL());
            intent.putExtra("Select_Contact", bg.c(atContactWidget.qpT, ","));
            intent.putExtra("sns_address_count", 0);
            a.imv.a(intent, atContactWidget.oqR, 6);
            return;
        }
        g.h(atContactWidget.oqR, j.pMz, j.dIO);
    }

    @TargetApi(11)
    public AtContactWidget(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public AtContactWidget(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public final List<String> bif() {
        if (this.qpT == null) {
            this.qpT = new LinkedList();
        }
        return this.qpT;
    }

    public final void big() {
        if (this.qpT == null) {
            this.qpT = new LinkedList();
        }
        this.qpT.clear();
        if (this.qpR != null) {
            this.qpR.bA(this.qpT);
        }
        bih();
        if (this.qpQ != null) {
            this.qpQ.setVisibility(8);
        }
    }

    private void init(Context context) {
        this.oqR = (Activity) context;
        this.ipu = r.eC(context).inflate(getLayoutResource(), this);
        this.qpR = (PreviewContactView) this.ipu.findViewById(f.pBM);
        this.qpP = (ImageView) this.ipu.findViewById(f.pBN);
        this.qpQ = (TextView) this.ipu.findViewById(f.pBO);
        this.ipu.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ AtContactWidget qpV;

            {
                this.qpV = r1;
            }

            public final void onClick(View view) {
                AtContactWidget.a(this.qpV);
            }
        });
    }

    public final boolean P(Intent intent) {
        String stringExtra = intent.getStringExtra("Select_Contact");
        LinkedList linkedList = new LinkedList();
        List linkedList2;
        if (stringExtra == null || stringExtra.equals("")) {
            linkedList2 = new LinkedList();
        } else {
            linkedList2 = bg.f(stringExtra.split(","));
        }
        if (this.qpT == null) {
            this.qpT = new LinkedList();
        }
        this.qpT.clear();
        for (String stringExtra2 : r0) {
            if (!this.qpT.contains(stringExtra2)) {
                this.qpT.add(stringExtra2);
            }
        }
        if (this.qpR != null) {
            this.qpR.bA(this.qpT);
        }
        if (this.qpU) {
            w.d("MicroMsg.AtContactWiget", "withList count " + this.qpT.size());
            if (!this.qpU || this.qpQ == null || this.qpT.size() <= 0) {
                this.qpQ.setVisibility(8);
            } else {
                this.qpQ.setVisibility(0);
                if (this.qpT.size() < 100) {
                    this.qpQ.setText(this.qpT.size());
                } else {
                    this.qpQ.setText(j.eYP);
                }
            }
        }
        bih();
        return true;
    }

    private void bih() {
        if (this.qpT.size() > 0) {
            this.qpP.setImageResource(bii());
        } else {
            this.qpP.setImageResource(bij());
        }
    }

    protected int getLayoutResource() {
        return i.g.pBP;
    }

    protected int bii() {
        return i.i.pJo;
    }

    protected int bij() {
        return i.i.pJn;
    }
}
