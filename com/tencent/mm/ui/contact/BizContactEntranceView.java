package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.bg.a;
import com.tencent.mm.modelbiz.w;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.x.n;

public class BizContactEntranceView extends RelativeLayout {
    private View kHA = null;
    private Context mContext;
    private View vWo;
    private TextView vWp;
    private boolean vWq = true;
    private boolean vWr;

    public BizContactEntranceView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mContext = context;
        init();
        bXN();
    }

    public BizContactEntranceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mContext = context;
        init();
        bXN();
    }

    public BizContactEntranceView(Context context) {
        super(context);
        this.mContext = context;
        init();
        bXN();
    }

    private void init() {
        this.vWr = false;
        View.inflate(getContext(), R.i.cVM, this);
        this.kHA = findViewById(R.h.bGr);
        this.vWo = this.kHA.findViewById(R.h.btJ);
        LayoutParams layoutParams = this.vWo.getLayoutParams();
        layoutParams.height = (int) (((float) a.U(getContext(), R.f.aWM)) * a.dL(getContext()));
        this.vWo.setLayoutParams(layoutParams);
        this.kHA.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ BizContactEntranceView vWs;

            {
                this.vWs = r1;
            }

            public final void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("intent_service_type", 251658241);
                d.b(view.getContext(), "brandservice", ".ui.BrandServiceIndexUI", intent);
            }
        });
        this.vWo.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ BizContactEntranceView vWs;

            {
                this.vWs = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.vWs.mContext instanceof MMActivity) {
                    ((MMActivity) this.vWs.mContext).aHf();
                }
                return false;
            }
        });
        MaskLayout maskLayout = (MaskLayout) this.vWo.findViewById(R.h.btI);
        ImageView imageView = (ImageView) maskLayout.view;
        n.Bl();
        imageView.setImageBitmap(com.tencent.mm.x.d.hm("service_officialaccounts"));
        this.vWp = (TextView) maskLayout.findViewById(R.h.cIL);
    }

    final void bXN() {
        long currentTimeMillis = System.currentTimeMillis();
        ap.yY();
        if (c.wR().bLv() > 0) {
            this.vWq = true;
        } else {
            this.vWq = false;
        }
        this.vWo.setVisibility(this.vWq ? 0 : 8);
        if (this.vWq) {
            ap.vL().D(new Runnable(this) {
                final /* synthetic */ BizContactEntranceView vWs;

                {
                    this.vWs = r1;
                }

                public final void run() {
                    long j = 0;
                    com.tencent.mm.modelbiz.d DH = w.DH();
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append("select updateTime from BizInfo").append(" where type = 1");
                    stringBuilder.append(" and status = 1").append(" ORDER BY updateTime DESC");
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizInfoStorage", "getLastNewBizUpdateTime, sql %s", stringBuilder.toString());
                    Cursor rawQuery = DH.rawQuery(r1, new String[0]);
                    if (rawQuery != null) {
                        if (rawQuery.moveToFirst()) {
                            j = rawQuery.getLong(0);
                            rawQuery.close();
                        } else {
                            rawQuery.close();
                        }
                    }
                    ap.yY();
                    final long bx = bg.bx(c.vr().get(233473, null));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizContactEntranceView", "last updateTime %d, enterTime %d", Long.valueOf(j), Long.valueOf(bx));
                    af.v(new Runnable(this) {
                        final /* synthetic */ AnonymousClass3 vWv;

                        public final void run() {
                            TextView c = this.vWv.vWs.vWp;
                            int i = (!this.vWv.vWs.vWr || j <= bx) ? 4 : 0;
                            c.setVisibility(i);
                        }
                    });
                }
            });
        }
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizContactEntranceView", "biz contact Count %d, isEntranceShow %s, setStatus cost %d", Integer.valueOf(r4), Boolean.valueOf(this.vWq), Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    public final void setVisible(boolean z) {
        int i = 0;
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.BizContactEntranceView", "setVisible visible = %s, isEntranceShow = %s", Boolean.valueOf(true), Boolean.valueOf(this.vWq));
        View view = this.kHA;
        if (!this.vWq) {
            i = 8;
        }
        view.setVisibility(i);
    }
}
