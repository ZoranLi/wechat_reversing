package com.tencent.mm.ui.contact;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.av.b;
import com.tencent.mm.av.c;
import com.tencent.mm.av.f;
import com.tencent.mm.bb.d;
import com.tencent.mm.e.a.fh;
import com.tencent.mm.modelsimple.ag;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.pluginsdk.ui.d.h;
import com.tencent.mm.sdk.e.j;
import com.tencent.mm.sdk.e.l;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aj.a;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.MaskLayout;
import com.tencent.mm.ui.tools.s;
import com.tencent.mm.x.n;
import java.util.ArrayList;
import java.util.List;

public final class k extends RelativeLayout {
    public static Boolean vXG = Boolean.valueOf(true);
    private Context context = null;
    private boolean isVisible = true;
    private View lmQ = null;
    private View vXH = null;
    private final aj vXI = new aj(new a(this) {
        final /* synthetic */ k vXL;

        {
            this.vXL = r1;
        }

        public final boolean oQ() {
            w.d("MicroMsg.FMessageContactView", "refresh timer expired, update");
            k.bXW();
            this.vXL.init();
            return false;
        }
    }, true);
    j.a vXJ = new j.a(this) {
        final /* synthetic */ k vXL;

        {
            this.vXL = r1;
        }

        public final void a(String str, l lVar) {
            w.d("MicroMsg.FMessageContactView", "onNotifyChange, fmsg change");
            if (!this.vXL.vXI.bJq()) {
                this.vXL.vXI.KH();
            }
            aj b = this.vXL.vXI;
            long j = this.vXL.vXK ? 500 : 1000;
            b.v(j, j);
        }
    };
    boolean vXK = false;

    public k(Context context) {
        super(context);
        this.context = context;
        com.tencent.mm.av.l.Ky().c(this.vXJ);
        bXW();
        init();
    }

    private void init() {
        c Ky = com.tencent.mm.av.l.Ky();
        w.v("MicroMsg.FMessageConversationStorage", "getNewLimit, limit = %d", Integer.valueOf(4));
        List arrayList = new ArrayList();
        Cursor a = Ky.gUz.a(new StringBuilder("select * from fmessage_conversation  where isNew = 1 ORDER BY lastModifiedTime DESC limit 4").toString(), null, 2);
        while (a.moveToNext()) {
            b bVar = new b();
            bVar.b(a);
            if (!bg.mA(bVar.field_talker)) {
                arrayList.add(bVar);
            }
        }
        a.close();
        int size = arrayList.size();
        w.d("MicroMsg.FMessageContactView", "init new fconv size = %d (max is 4)", Integer.valueOf(size));
        removeAllViews();
        if (size <= 0) {
            if (this.context == null) {
                w.w("MicroMsg.FMessageContactView", "initNoNew failed. context is null.");
            } else {
                this.lmQ = View.inflate(this.context, R.i.ddh, this);
                this.vXH = this.lmQ.findViewById(R.h.bQy);
                LayoutParams layoutParams = this.vXH.getLayoutParams();
                layoutParams.height = (int) (((float) com.tencent.mm.bg.a.U(this.context, R.f.aWM)) * com.tencent.mm.bg.a.dL(this.context));
                this.vXH.setLayoutParams(layoutParams);
                this.lmQ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k vXL;

                    {
                        this.vXL = r1;
                    }

                    public final void onClick(View view) {
                        w.d("MicroMsg.FMessageContactView", "initNoNew, goto FMessageConversationUI");
                        d.b(this.vXL.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                MaskLayout maskLayout = (MaskLayout) this.lmQ.findViewById(R.h.bQk);
                n.Bl();
                ((ImageView) maskLayout.view).setImageBitmap(com.tencent.mm.x.d.hm("fmessage"));
            }
        } else if (size == 1) {
            b bVar2 = (b) arrayList.get(0);
            if (this.context == null) {
                w.w("MicroMsg.FMessageContactView", "initSingleNew failed. context is null.");
            } else {
                CharSequence string;
                if (com.tencent.mm.bg.a.dM(this.context)) {
                    this.lmQ = View.inflate(this.context, R.i.ddk, this);
                } else {
                    this.lmQ = View.inflate(this.context, R.i.ddj, this);
                }
                ((TextView) this.lmQ.findViewById(R.h.bQD)).setText(h.a(this.context, bVar2.field_displayName));
                TextView textView = (TextView) this.lmQ.findViewById(R.h.bQC);
                f la = com.tencent.mm.av.l.Kx().la(bVar2.field_talker);
                Context context = this.context;
                int i = la.field_type;
                int i2 = bVar2.field_addScene;
                String str = la.field_msgContent;
                w.d("MicroMsg.FMessageProvider", "setDigest, fmsgType = %d, fmsgScene = %d, fmsgContent = %s, isSend = %b", Integer.valueOf(i), Integer.valueOf(i2), str, Boolean.valueOf(!la.Kp()));
                if (i == 0) {
                    if (str != null) {
                        au.a RF = au.a.RF(str);
                        switch (RF.scene) {
                            case 4:
                                string = context.getString(R.l.dTu);
                                break;
                            case 10:
                            case 11:
                                com.tencent.mm.sdk.b.b fhVar = new fh();
                                fhVar.fJR.fJO = RF.uJX;
                                fhVar.fJR.fJP = RF.uJY;
                                com.tencent.mm.sdk.b.a.urY.m(fhVar);
                                string = context.getString(R.l.dTx, new Object[]{bg.ap(fhVar.fJS.fJT, "")});
                                break;
                            case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                                string = context.getString(R.l.dTG);
                                break;
                            case 32:
                                string = context.getString(R.l.dTA);
                                break;
                            case m.CTRL_INDEX /*58*/:
                            case bc.CTRL_INDEX /*59*/:
                            case 60:
                                string = context.getString(R.l.dTv);
                                break;
                            default:
                                string = context.getString(R.l.dTz);
                                break;
                        }
                    }
                    w.e("MicroMsg.FMessageProvider", "setDigest fail, fmsgContent is null");
                    string = null;
                } else if (r2) {
                    Object obj = str;
                } else {
                    au.d RI = au.d.RI(str);
                    string = (RI.content == null || RI.content.trim().equals("")) ? context.getString(R.l.ekZ) : RI.content;
                }
                if (u.mA(string)) {
                    textView.setVisibility(8);
                } else {
                    textView.setText(string);
                }
                this.vXH = this.lmQ.findViewById(R.h.bQp);
                this.lmQ.setOnClickListener(new OnClickListener(this) {
                    final /* synthetic */ k vXL;

                    {
                        this.vXL = r1;
                    }

                    public final void onClick(View view) {
                        w.d("MicroMsg.FMessageContactView", "initSingleNew, not goto ContactInfoUI, goto FMessageConversationUI");
                        ap.yY();
                        com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
                        d.b(this.vXL.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                    }
                });
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) ((MaskLayout) this.lmQ.findViewById(R.h.bQk)).view, bVar2.field_talker);
            }
        } else if (this.context == null) {
            w.w("MicroMsg.FMessageContactView", "initMultiNew failed. context is null.");
        } else {
            this.lmQ = View.inflate(this.context, R.i.ddi, this);
            int size2 = arrayList.size();
            w.d("MicroMsg.FMessageContactView", "initMultiNew, newList size = %d", Integer.valueOf(size2));
            MaskLayout maskLayout2 = (MaskLayout) this.lmQ.findViewById(R.h.bQk);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(0)).field_talker);
            maskLayout2.setVisibility(0);
            maskLayout2 = (MaskLayout) this.lmQ.findViewById(R.h.bQl);
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(1)).field_talker);
            maskLayout2.setVisibility(0);
            if (size2 > 2) {
                maskLayout2 = (MaskLayout) this.lmQ.findViewById(R.h.bQm);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(2)).field_talker);
                maskLayout2.setVisibility(0);
            }
            if (size2 > 3) {
                maskLayout2 = (MaskLayout) this.lmQ.findViewById(R.h.bQn);
                com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) maskLayout2.view, ((b) arrayList.get(3)).field_talker);
                maskLayout2.setVisibility(0);
            }
            this.vXH = this.lmQ.findViewById(R.h.bQp);
            this.vXH.setOnClickListener(new OnClickListener(this) {
                final /* synthetic */ k vXL;

                {
                    this.vXL = r1;
                }

                public final void onClick(View view) {
                    w.d("MicroMsg.FMessageContactView", "initMultiNew, goto FMessageConversationUI");
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
                    d.b(this.vXL.context, "subapp", ".ui.friend.FMessageConversationUI", new Intent());
                }
            });
        }
        View findViewById = this.lmQ.findViewById(R.h.bQp);
        if (findViewById != null) {
            findViewById.setVisibility(this.isVisible ? 0 : 8);
        }
        this.vXH.setOnTouchListener(new OnTouchListener(this) {
            final /* synthetic */ k vXL;

            {
                this.vXL = r1;
            }

            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (this.vXL.context instanceof MMActivity) {
                    ((MMActivity) this.vXL.context).aHf();
                }
                return false;
            }
        });
        int Km = com.tencent.mm.av.l.Ky().Km();
        w.d("MicroMsg.FMessageContactView", "init totalNewSize = %d", Integer.valueOf(Km));
        TextView textView2 = (TextView) this.lmQ.findViewById(R.h.bQw);
        textView2.setBackgroundResource(s.fg(this.context));
        if (Km <= 0) {
            textView2.setVisibility(8);
            vXG = Boolean.valueOf(false);
            return;
        }
        textView2.setVisibility(0);
        vXG = Boolean.valueOf(true);
        if (Km > 99) {
            textView2.setText(getContext().getString(R.l.eYP));
        } else {
            textView2.setText(String.valueOf(Km));
        }
    }

    private static void bXW() {
        int Km = com.tencent.mm.av.l.Ky().Km();
        w.v("MicroMsg.FMessageContactView", "updateAddressTabUnread, newCount update to = %d", Integer.valueOf(Km));
        if (Km > 0) {
            ap.yY();
            com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(Km));
        }
    }

    public static void bXX() {
        ap.yY();
        if (com.tencent.mm.u.c.wM()) {
            ap.yY();
            if (com.tencent.mm.u.c.vr().getInt(143618, 0) > 0) {
                ag.C("fmessage", 2);
            }
        }
        ap.yY();
        com.tencent.mm.u.c.vr().set(143618, Integer.valueOf(0));
    }
}
