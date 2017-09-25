package com.tencent.mm.ui.chatting;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.a.qp;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.chatting.En_5b8fbb1e.a;
import com.tencent.mm.ui.widget.MMTextView;

final class dg implements OnClickListener {
    public a vCd;

    public dg(a aVar) {
        this.vCd = aVar;
    }

    public final void onClick(View view) {
        w.d("MicroMsg.ChattingTranslateClickListener", "tranlsate view clicked");
        if (view instanceof ChattingTranslateView) {
            int i;
            ChattingTranslateView chattingTranslateView = (ChattingTranslateView) view;
            if (chattingTranslateView.vHL == ChattingTranslateView.a.Translating) {
                i = 1;
            } else {
                boolean z = false;
            }
            if (i == 0) {
                MMTextView mMTextView = (MMTextView) view.getTag();
                if (mMTextView != null) {
                    int i2;
                    boolean z2;
                    dt dtVar = (dt) mMTextView.getTag();
                    boolean bMs = dtVar.fTk.bMs();
                    if (chattingTranslateView.vHL == ChattingTranslateView.a.Translated) {
                        i2 = 1;
                    } else {
                        z2 = false;
                    }
                    if (i2 != 0) {
                        chattingTranslateView.bUO();
                        this.vCd.a(dtVar.fTk.field_msgId, ChattingTranslateView.a.NoTranslate);
                        mMTextView.setText(dtVar.fTk.field_content);
                        h.d(mMTextView, 1);
                        return;
                    }
                    if (chattingTranslateView.vHL == ChattingTranslateView.a.NoTranslate) {
                        i2 = 1;
                    } else {
                        z2 = false;
                    }
                    if (i2 == 0) {
                        return;
                    }
                    if (bMs) {
                        chattingTranslateView.Tx(dtVar.fTk.field_transBrandWording);
                        this.vCd.a(dtVar.fTk.field_msgId, ChattingTranslateView.a.Translated);
                        mMTextView.setText(dtVar.fTk.field_transContent);
                        h.d(mMTextView, 1);
                        return;
                    }
                    chattingTranslateView.bUP();
                    b qpVar = new qp();
                    qpVar.fXH.fXJ = false;
                    qpVar.fXH.id = dtVar.fTk.field_msgId;
                    qpVar.fXH.fXI = dtVar.fTk.field_content;
                    qpVar.fXH.type = 0;
                    com.tencent.mm.sdk.b.a.urY.m(qpVar);
                    this.vCd.a(dtVar.fTk.field_msgId, ChattingTranslateView.a.Translating);
                }
            }
        }
    }
}
