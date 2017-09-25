package com.tencent.mm.pluginsdk.ui.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.av.f;
import com.tencent.mm.av.i;
import com.tencent.mm.av.j;
import com.tencent.mm.av.l;
import com.tencent.mm.pluginsdk.model.n;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.au.d;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.tools.a.c;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;

public final class a extends LinearLayout implements e {
    static a sRR;
    private Context context;
    p irJ;
    private TextView iuD;
    private Button sRS;

    public static class a {
        public String fJL;
        public String osP;
        public int scene;
        public int type;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static /* synthetic */ void a(com.tencent.mm.pluginsdk.ui.preference.a r9, java.lang.String r10) {
        /*
        r7 = 0;
        r6 = 1;
        r0 = sRR;
        if (r0 != 0) goto L_0x0010;
    L_0x0006:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "FMessage Args is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x000f:
        return;
    L_0x0010:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "try to reply verify content";
        com.tencent.mm.sdk.platformtools.w.d(r0, r1);
        r2 = new java.util.LinkedList;
        r2.<init>();
        r0 = sRR;
        r0 = r0.fJL;
        r2.add(r0);
        r3 = new java.util.LinkedList;
        r3.<init>();
        r0 = sRR;
        r0 = r0.scene;
        r0 = java.lang.Integer.valueOf(r0);
        r3.add(r0);
        r0 = sRR;
        r0 = r0.type;
        r1 = sRR;
        r1 = r1.fJL;
        r4 = "MicroMsg.FMessageItemView";
        r5 = new java.lang.StringBuilder;
        r8 = "getOpCode, type = ";
        r5.<init>(r8);
        r5 = r5.append(r0);
        r8 = ", talker = ";
        r5 = r5.append(r8);
        r5 = r5.append(r1);
        r5 = r5.toString();
        com.tencent.mm.sdk.platformtools.w.d(r4, r5);
        switch(r0) {
            case 0: goto L_0x00b0;
            case 1: goto L_0x00f2;
            case 2: goto L_0x010f;
            default: goto L_0x0061;
        };
    L_0x0061:
        r1 = 6;
    L_0x0062:
        r0 = "MicroMsg.FMessageItemView";
        r4 = new java.lang.StringBuilder;
        r5 = "reply, final opcode = ";
        r4.<init>(r5);
        r4 = r4.append(r1);
        r4 = r4.toString();
        com.tencent.mm.sdk.platformtools.w.d(r0, r4);
        r0 = com.tencent.mm.u.ap.vd();
        r4 = 30;
        r0.a(r4, r9);
        r0 = new com.tencent.mm.pluginsdk.model.n;
        r4 = sRR;
        r5 = r4.osP;
        r4 = r10;
        r0.<init>(r1, r2, r3, r4, r5);
        r1 = com.tencent.mm.u.ap.vd();
        r1.a(r0, r7);
        r1 = r9.context;
        r2 = r9.context;
        r3 = com.tencent.mm.R.l.dIO;
        r2.getString(r3);
        r2 = r9.context;
        r3 = com.tencent.mm.R.l.dIB;
        r2 = r2.getString(r3);
        r3 = new com.tencent.mm.pluginsdk.ui.preference.a$2;
        r3.<init>(r9, r0);
        r0 = com.tencent.mm.ui.base.g.a(r1, r2, r6, r3);
        r9.irJ = r0;
        goto L_0x000f;
    L_0x00b0:
        if (r1 == 0) goto L_0x00b8;
    L_0x00b2:
        r0 = r1.length();
        if (r0 != 0) goto L_0x00c6;
    L_0x00b8:
        r0 = "MicroMsg.FMessageLogic";
        r1 = "isVerifyReceiver, invalid argument";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x00c1:
        r0 = r7;
    L_0x00c2:
        if (r0 != 0) goto L_0x0061;
    L_0x00c4:
        r1 = 5;
        goto L_0x0062;
    L_0x00c6:
        r0 = com.tencent.mm.av.l.Kx();
        r0 = r0.lb(r1);
        if (r0 != 0) goto L_0x00e7;
    L_0x00d0:
        r0 = "MicroMsg.FMessageLogic";
        r4 = new java.lang.StringBuilder;
        r5 = "isVerifyReceiver, lastRecvFmsg does not exist, talker = ";
        r4.<init>(r5);
        r1 = r4.append(r1);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x00c1;
    L_0x00e7:
        r1 = r0.field_type;
        if (r1 == r6) goto L_0x00f0;
    L_0x00eb:
        r0 = r0.field_type;
        r1 = 2;
        if (r0 != r1) goto L_0x00c1;
    L_0x00f0:
        r0 = r6;
        goto L_0x00c2;
    L_0x00f2:
        r0 = com.tencent.mm.av.l.Kz();
        r0 = r0.lg(r1);
        if (r0 != 0) goto L_0x0107;
    L_0x00fc:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last lbsMsg is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0061;
    L_0x0107:
        r0 = r0.field_content;
        r1 = Nd(r0);
        goto L_0x0062;
    L_0x010f:
        r0 = com.tencent.mm.av.l.KA();
        r0 = r0.li(r1);
        if (r0 != 0) goto L_0x0124;
    L_0x0119:
        r0 = "MicroMsg.FMessageItemView";
        r1 = "getOpCode, last shakeMsg is null";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
        goto L_0x0061;
    L_0x0124:
        r0 = r0.field_content;
        r1 = Nd(r0);
        goto L_0x0062;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.preference.a.a(com.tencent.mm.pluginsdk.ui.preference.a, java.lang.String):void");
    }

    public a(Context context) {
        super(context);
        this.context = context;
        View inflate = View.inflate(this.context, R.i.ddp, this);
        this.iuD = (TextView) inflate.findViewById(R.h.bQE);
        this.sRS = (Button) inflate.findViewById(R.h.bQF);
        this.sRS.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ a sRT;

            {
                this.sRT = r1;
            }

            public final void onClick(View view) {
                View inflate = View.inflate(this.sRT.context, R.i.dnR, null);
                ((TextView) inflate.findViewById(R.h.cCA)).setVisibility(8);
                final TextView textView = (TextView) inflate.findViewById(R.h.cTh);
                textView.setVisibility(0);
                textView.setText("50");
                final EditText editText = (EditText) inflate.findViewById(R.h.cCz);
                editText.setSingleLine(false);
                c.d(editText).Ch(100).a(null);
                editText.addTextChangedListener(new TextWatcher(this) {
                    final /* synthetic */ AnonymousClass1 sRV;

                    public final void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                    }

                    public final void afterTextChanged(Editable editable) {
                        int aI = h.aI(100, editable.toString());
                        if (textView != null) {
                            textView.setText(String.valueOf(aI));
                        }
                    }
                });
                g.a(this.sRT.context, this.sRT.context.getString(R.l.dIt), inflate, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass1 sRV;

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        String trim = editText.getText().toString().trim();
                        if (trim != null && trim.length() > 0) {
                            a.a(this.sRV.sRT, trim);
                        }
                    }
                }, null);
                editText.post(new Runnable(this) {
                    final /* synthetic */ AnonymousClass1 sRV;

                    {
                        this.sRV = r1;
                    }

                    public final void run() {
                        if (this.sRV.sRT.context instanceof MMActivity) {
                            ((MMActivity) this.sRV.sRT.context).aHj();
                        }
                    }
                });
            }
        });
    }

    private static int Nd(String str) {
        if (str == null) {
            w.d("MicroMsg.FMessageItemView", "getOpCodeFromVerify fail, xml is null");
            return 6;
        }
        switch (d.RI(str).fJK) {
            case 2:
            case 5:
                return 6;
            case 6:
                return 5;
            default:
                return 6;
        }
    }

    public final void Ne(String str) {
        this.iuD.setText(com.tencent.mm.pluginsdk.ui.d.h.b(this.context, bg.mz(str), this.iuD.getTextSize()));
    }

    public final void xO(int i) {
        if (this.sRS != null) {
            this.sRS.setVisibility(i);
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() == 30) {
            w.d("MicroMsg.FMessageItemView", "onSceneEnd, errType = " + i + ", errCode = " + i2);
            if (this.irJ != null) {
                this.irJ.dismiss();
            }
            if (i == 0 && i2 == 0) {
                int i3 = ((n) kVar).fJK;
                String str2 = ((n) kVar).sCw;
                w.d("MicroMsg.FMessageItemView", "onSceneEnd, pre insert fmsg, opcode = " + i3 + ", verifyContent = " + str2);
                w.d("MicroMsg.FMessageItemView", "onSceneEnd, type = " + sRR.type);
                switch (sRR.type) {
                    case 1:
                        com.tencent.mm.av.h hVar = new com.tencent.mm.av.h();
                        hVar.field_createtime = i.lh(sRR.fJL);
                        hVar.field_isSend = 1;
                        hVar.field_content = str2;
                        hVar.field_talker = "fmessage";
                        hVar.field_sayhiuser = sRR.fJL;
                        hVar.field_svrid = System.currentTimeMillis();
                        hVar.field_status = 4;
                        l.Kz().a(hVar);
                        break;
                    case 2:
                        j jVar = new j();
                        jVar.field_createtime = com.tencent.mm.av.k.lh(sRR.fJL);
                        jVar.field_isSend = 1;
                        jVar.field_content = str2;
                        jVar.field_talker = "fmessage";
                        jVar.field_sayhiuser = sRR.fJL;
                        jVar.field_svrid = System.currentTimeMillis();
                        jVar.field_status = 4;
                        w.d("MicroMsg.FMessageItemView", "onSceneEnd, insert shake, ret = " + l.KA().a(jVar));
                        break;
                    default:
                        f fVar = new f();
                        fVar.field_createTime = com.tencent.mm.av.e.i(sRR.fJL, 0);
                        fVar.field_isSend = 1;
                        fVar.field_msgContent = str2;
                        fVar.field_talker = sRR.fJL;
                        fVar.field_type = i3 == 5 ? 2 : 3;
                        w.d("MicroMsg.FMessageItemView", "onSceneEnd, insert fmsg, ret = " + l.Kx().a(fVar));
                        break;
                }
            }
            if (i == 4 && i2 == -34) {
                str = this.context.getString(R.l.eld);
            } else if (i == 4 && i2 == -94) {
                str = this.context.getString(R.l.ele);
            } else if (!(i == 4 && i2 == -24 && !bg.mA(str))) {
                str = this.context.getString(R.l.eRk);
            }
            Toast.makeText(this.context, str, 1).show();
            ap.vd().b(30, this);
        }
    }
}
