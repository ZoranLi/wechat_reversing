package com.tencent.mm.plugin.ipcall.ui;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.plugin.ipcall.a.e.e;
import com.tencent.mm.plugin.ipcall.a.i;
import com.tencent.mm.plugin.ipcall.b.a;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;

public class IPCallUserProfileUI extends MMActivity {
    private String fWT;
    private String fWV;
    private ImageView ioV;
    private boolean mSU = false;
    private TextView mXH;
    private TextView mXI;
    private LinearLayout mXJ;
    private LinearLayout mXK;
    private TextView mXL;
    private TextView mXM;
    private TextView mXN;
    private TextView mXO;
    private TextView mXP;
    private Button mXQ;
    private String mXR;
    private String mXS;
    private Bitmap mXT;
    private boolean mXU;
    private Cursor mXV = null;
    private boolean mXW = false;
    private e mXX = new e();

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, final TextView textView) {
        l lVar = new l(iPCallUserProfileUI);
        lVar.qJf = new c(iPCallUserProfileUI) {
            final /* synthetic */ IPCallUserProfileUI mXY;

            {
                this.mXY = r1;
            }

            public final void a(com.tencent.mm.ui.base.l lVar) {
                lVar.add(R.l.dGx);
            }
        };
        lVar.qJg = new d(iPCallUserProfileUI) {
            final /* synthetic */ IPCallUserProfileUI mXY;

            public final void c(MenuItem menuItem, int i) {
                if (i == 0) {
                    g.oUh.i(12766, new Object[]{Integer.valueOf(4)});
                    com.tencent.mm.plugin.ipcall.b.c.c(this.mXY, textView.getText().toString());
                    Toast.makeText(this.mXY, R.l.etW, 0).show();
                }
            }
        };
        lVar.blb();
    }

    static /* synthetic */ void a(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (com.tencent.mm.plugin.ipcall.b.c.cu(iPCallUserProfileUI)) {
            Intent intent = new Intent(iPCallUserProfileUI, IPCallDialUI.class);
            if (iPCallUserProfileUI.mXW) {
                intent.putExtra("IPCallTalkUI_dialScene", 4);
                g.oUh.i(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(4)});
            } else {
                intent.putExtra("IPCallTalkUI_dialScene", 2);
                g.oUh.i(12059, new Object[]{Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(2)});
            }
            intent.putExtra("IPCallTalkUI_contactId", iPCallUserProfileUI.fWT);
            intent.putExtra("IPCallTalkUI_nickname", iPCallUserProfileUI.mXR);
            intent.putExtra("IPCallTalkUI_phoneNumber", com.tencent.mm.plugin.ipcall.b.c.zc(str));
            intent.putExtra("IPCallTalkUI_toWechatUsername", iPCallUserProfileUI.mXS);
            iPCallUserProfileUI.startActivityForResult(intent, MMBitmapFactory.ERROR_ALLOCATE_STRUCT_FAILED);
            iPCallUserProfileUI.mXU = true;
        }
    }

    static /* synthetic */ void b(IPCallUserProfileUI iPCallUserProfileUI, String str) {
        if (!bg.mA(iPCallUserProfileUI.fWT) && !bg.mA(str) && !str.endsWith("@stranger")) {
            com.tencent.mm.sdk.e.c yt = i.aEn().yt(iPCallUserProfileUI.fWT);
            if (yt.uxb > 0) {
                yt.field_wechatUsername = str;
                i.aEn().a(yt.uxb, yt);
            }
        }
    }

    protected final int Ol() {
        return 1;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r10) {
        /*
        r9 = this;
        r2 = 0;
        r8 = 8;
        r6 = 1;
        r7 = 0;
        super.onCreate(r10);
        r0 = com.tencent.mm.plugin.report.service.g.oUh;
        r1 = 12061; // 0x2f1d float:1.6901E-41 double:5.959E-320;
        r3 = 6;
        r3 = new java.lang.Object[r3];
        r4 = java.lang.Integer.valueOf(r7);
        r3[r7] = r4;
        r4 = java.lang.Integer.valueOf(r6);
        r3[r6] = r4;
        r4 = 2;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r4 = 3;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r4 = 4;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r4 = 5;
        r5 = java.lang.Integer.valueOf(r7);
        r3[r4] = r5;
        r0.i(r1, r3);
        r0 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$1;
        r0.<init>(r9);
        r9.b(r0);
        r0 = com.tencent.mm.R.l.etZ;
        r9.zi(r0);
        r0 = com.tencent.mm.R.h.bqM;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.ImageView) r0;
        r9.ioV = r0;
        r0 = com.tencent.mm.R.h.cHd;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXH = r0;
        r0 = com.tencent.mm.R.h.cSO;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXI = r0;
        r0 = com.tencent.mm.R.h.ctd;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.LinearLayout) r0;
        r9.mXJ = r0;
        r0 = com.tencent.mm.R.h.ctc;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXL = r0;
        r0 = com.tencent.mm.R.h.ctb;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXN = r0;
        r0 = com.tencent.mm.R.h.cta;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXM = r0;
        r0 = com.tencent.mm.R.h.ctf;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.LinearLayout) r0;
        r9.mXK = r0;
        r0 = com.tencent.mm.R.h.cxj;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXO = r0;
        r0 = com.tencent.mm.R.h.bYh;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.TextView) r0;
        r9.mXP = r0;
        r0 = com.tencent.mm.R.h.csY;
        r0 = r9.findViewById(r0);
        r0 = (android.widget.Button) r0;
        r9.mXQ = r0;
        r0 = r9.getIntent();
        r1 = "IPCallProfileUI_contactid";
        r0 = r0.getStringExtra(r1);
        r9.fWT = r0;
        r0 = r9.getIntent();
        r1 = "IPCallProfileUI_systemUsername";
        r0 = r0.getStringExtra(r1);
        r9.mXR = r0;
        r0 = r9.getIntent();
        r1 = "IPCallProfileUI_wechatUsername";
        r0 = r0.getStringExtra(r1);
        r9.mXS = r0;
        r0 = r9.getIntent();
        r1 = "IPCallProfileUI_phonenumber";
        r0 = r0.getStringExtra(r1);
        r9.fWV = r0;
        r0 = r9.getIntent();
        r1 = "IPCallProfileUI_isNeedShowRecord";
        r0 = r0.getBooleanExtra(r1, r7);
        r9.mXW = r0;
        r0 = r9.fWT;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0111;
    L_0x00fe:
        r0 = r9.fWT;
        r0 = com.tencent.mm.plugin.ipcall.b.a.al(r9, r0);
        r9.mXT = r0;
        r0 = r9.mXT;
        if (r0 == 0) goto L_0x0111;
    L_0x010a:
        r0 = r9.ioV;
        r1 = r9.mXT;
        r0.setImageBitmap(r1);
    L_0x0111:
        r0 = r9.mXT;
        if (r0 != 0) goto L_0x0131;
    L_0x0115:
        r0 = r9.mXS;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0131;
    L_0x011d:
        r0 = r9.mXS;
        r1 = -1;
        r0 = com.tencent.mm.x.b.a(r0, r7, r1);
        r9.mXT = r0;
        r0 = r9.mXT;
        if (r0 == 0) goto L_0x0131;
    L_0x012a:
        r0 = r9.ioV;
        r1 = r9.mXT;
        r0.setImageBitmap(r1);
    L_0x0131:
        r0 = r9.mXR;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0187;
    L_0x0139:
        r0 = r9.mXH;
        r1 = r9.mXR;
        r0.setText(r1);
    L_0x0140:
        r0 = r9.mXS;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x019b;
    L_0x0148:
        r0 = r9.mXS;
        r1 = "@stranger";
        r0 = r0.endsWith(r1);
        if (r0 != 0) goto L_0x019b;
    L_0x0153:
        r0 = com.tencent.mm.R.l.eua;
        r1 = new java.lang.Object[r6];
        r3 = r9.mXS;
        r3 = com.tencent.mm.u.n.eK(r3);
        r1[r7] = r3;
        r0 = r9.getString(r0, r1);
        r1 = r9.mXI;
        r0 = com.tencent.mm.pluginsdk.ui.d.h.a(r9, r0);
        r1.setText(r0);
    L_0x016c:
        r0 = r9.fWT;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x01c2;
    L_0x0174:
        r0 = "android.permission.READ_CONTACTS";
        r0 = com.tencent.mm.pluginsdk.i.a.aT(r9, r0);
        if (r0 != 0) goto L_0x01a1;
    L_0x017d:
        r0 = "MicroMsg.IPCallUserProfileUI";
        r1 = "no contact permission";
        com.tencent.mm.sdk.platformtools.w.e(r0, r1);
    L_0x0186:
        return;
    L_0x0187:
        r0 = r9.fWV;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0140;
    L_0x018f:
        r0 = r9.mXH;
        r1 = r9.fWV;
        r1 = com.tencent.mm.plugin.ipcall.b.a.yY(r1);
        r0.setText(r1);
        goto L_0x0140;
    L_0x019b:
        r0 = r9.mXI;
        r0.setVisibility(r8);
        goto L_0x016c;
    L_0x01a1:
        r0 = r9.getContentResolver();
        r1 = android.provider.ContactsContract.CommonDataKinds.Phone.CONTENT_URI;
        r3 = "contact_id=?";
        r4 = new java.lang.String[r6];
        r5 = r9.fWT;
        r4[r7] = r5;
        r5 = r2;
        r0 = r0.query(r1, r2, r3, r4, r5);
        r9.mXV = r0;
        r0 = r9.mXV;
        r0 = r0.getCount();
        if (r0 > r6) goto L_0x0292;
    L_0x01bf:
        r0 = r6;
    L_0x01c0:
        r9.mSU = r0;
    L_0x01c2:
        r9.aFn();
        r0 = r9.mXN;
        r0.setVisibility(r8);
        r0 = r9.mXM;
        r0.setVisibility(r8);
        r0 = r9.mXL;
        r0.setVisibility(r8);
        r0 = r9.mXQ;
        r0.setVisibility(r8);
        r0 = r9.mXP;
        r0.setVisibility(r8);
        r0 = r9.mXS;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0295;
    L_0x01e6:
        r0 = r9.mXR;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0295;
    L_0x01ee:
        com.tencent.mm.u.ap.yY();
        r0 = com.tencent.mm.u.c.wR();
        r1 = r9.mXS;
        r0 = r0.Rc(r1);
        if (r0 == 0) goto L_0x021b;
    L_0x01fd:
        r0 = r0.field_type;
        r0 = com.tencent.mm.j.a.ez(r0);
        if (r0 != 0) goto L_0x021b;
    L_0x0205:
        r0 = r9.mXQ;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$8;
        r1.<init>(r9);
        r0.setOnClickListener(r1);
        r0 = r9.mXQ;
        r1 = com.tencent.mm.R.l.etX;
        r0.setText(r1);
        r0 = r9.mXQ;
        r0.setVisibility(r7);
    L_0x021b:
        r0 = new java.util.ArrayList;
        r0.<init>();
        r1 = r9.mXV;
        if (r1 == 0) goto L_0x0306;
    L_0x0224:
        r1 = r9.mXV;
        r1 = r1.getCount();
        if (r1 <= 0) goto L_0x0306;
    L_0x022c:
        r1 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r1 = r1.moveToFirst();	 Catch:{ Exception -> 0x0277 }
        if (r1 == 0) goto L_0x02ff;
    L_0x0234:
        r1 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r1 = r1.isAfterLast();	 Catch:{ Exception -> 0x0277 }
        if (r1 != 0) goto L_0x02ff;
    L_0x023c:
        r7 = r7 + 1;
        r1 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r2 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r3 = "data1";
        r2 = r2.getColumnIndex(r3);	 Catch:{ Exception -> 0x0277 }
        r1 = r1.getString(r2);	 Catch:{ Exception -> 0x0277 }
        r2 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r3 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r4 = "data2";
        r3 = r3.getColumnIndex(r4);	 Catch:{ Exception -> 0x0277 }
        r2 = r2.getInt(r3);	 Catch:{ Exception -> 0x0277 }
        r3 = r0.contains(r1);	 Catch:{ Exception -> 0x0277 }
        if (r3 != 0) goto L_0x0271;
    L_0x0262:
        r0.add(r1);	 Catch:{ Exception -> 0x0277 }
        r3 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r3 = r3.getCount();	 Catch:{ Exception -> 0x0277 }
        if (r7 != r3) goto L_0x02f2;
    L_0x026d:
        r3 = 0;
        r9.l(r1, r2, r3);	 Catch:{ Exception -> 0x0277 }
    L_0x0271:
        r1 = r9.mXV;	 Catch:{ Exception -> 0x0277 }
        r1.moveToNext();	 Catch:{ Exception -> 0x0277 }
        goto L_0x0234;
    L_0x0277:
        r0 = move-exception;
        r1 = "MicroMsg.IPCallUserProfileUI";
        r2 = "initPhoneNumberList error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x02f8 }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x02f8 }
        r3[r4] = r0;	 Catch:{ all -> 0x02f8 }
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);	 Catch:{ all -> 0x02f8 }
        r0 = r9.mXV;
        r0.close();
        goto L_0x0186;
    L_0x0292:
        r0 = r7;
        goto L_0x01c0;
    L_0x0295:
        r0 = r9.fWT;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x02b1;
    L_0x029d:
        r0 = r9.mXR;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x02b1;
    L_0x02a5:
        r9.aFm();
        r0 = r9.mXQ;
        r1 = com.tencent.mm.R.l.etY;
        r0.setText(r1);
        goto L_0x021b;
    L_0x02b1:
        r0 = r9.fWV;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x021b;
    L_0x02b9:
        r0 = r9.mXM;
        r0.setVisibility(r7);
        r0 = r9.mXN;
        r0.setVisibility(r7);
        r0 = r9.mXL;
        r0.setVisibility(r7);
        r0 = r9.mXL;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$10;
        r1.<init>(r9);
        r0.setOnClickListener(r1);
        r0 = r9.mXM;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$11;
        r1.<init>(r9);
        r0.setOnClickListener(r1);
        r0 = r9.mXN;
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$2;
        r1.<init>(r9);
        r0.setOnClickListener(r1);
        r9.aFm();
        r0 = r9.mXQ;
        r1 = com.tencent.mm.R.l.etY;
        r0.setText(r1);
        goto L_0x021b;
    L_0x02f2:
        r3 = 1;
        r9.l(r1, r2, r3);	 Catch:{ Exception -> 0x0277 }
        goto L_0x0271;
    L_0x02f8:
        r0 = move-exception;
        r1 = r9.mXV;
        r1.close();
        throw r0;
    L_0x02ff:
        r0 = r9.mXV;
        r0.close();
        goto L_0x0186;
    L_0x0306:
        r0 = r9.mXJ;
        r0.setVisibility(r8);
        goto L_0x0186;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.onCreate(android.os.Bundle):void");
    }

    protected final int getLayoutId() {
        return R.i.dgh;
    }

    private void l(final String str, int i, boolean z) {
        View inflate = LayoutInflater.from(this).inflate(R.i.dls, this.mXJ, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.h.cbr);
        if (z) {
            linearLayout.setBackgroundDrawable(getResources().getDrawable(R.g.bgh));
        } else {
            linearLayout.setBackgroundDrawable(null);
        }
        TextView textView = (TextView) inflate.findViewById(R.h.crC);
        final TextView textView2 = (TextView) inflate.findViewById(R.h.crB);
        textView2.setText(a.yY(com.tencent.mm.plugin.ipcall.b.c.zc(str)));
        textView.setText(a.oy(i));
        inflate.setClickable(true);
        inflate.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallUserProfileUI mXY;

            public final void onClick(View view) {
                IPCallUserProfileUI.a(this.mXY, str);
            }
        });
        inflate.setOnLongClickListener(new OnLongClickListener(this) {
            final /* synthetic */ IPCallUserProfileUI mXY;

            public final boolean onLongClick(View view) {
                IPCallUserProfileUI.a(this.mXY, textView2);
                return true;
            }
        });
        this.mXJ.addView(inflate);
    }

    private static String yM(String str) {
        String str2;
        Exception e;
        String str3 = "";
        Cursor query;
        if (com.tencent.mm.pluginsdk.i.a.aT(ab.getContext(), "android.permission.READ_CONTACTS")) {
            query = ab.getContext().getContentResolver().query(Phone.CONTENT_URI, null, "contact_id=?", new String[]{str}, null);
            if (query == null) {
                return null;
            }
            try {
                if (query.moveToFirst()) {
                    str2 = str3;
                    while (!query.isAfterLast()) {
                        try {
                            str3 = str2 + query.getString(query.getColumnIndex("data1")) + ",";
                            query.moveToNext();
                            str2 = str3;
                        } catch (Exception e2) {
                            e = e2;
                        }
                    }
                } else {
                    str2 = str3;
                }
                query.close();
            } catch (Exception e3) {
                e = e3;
                str2 = str3;
            }
            if (str2.lastIndexOf(",") >= 0) {
                str2 = str2.substring(0, str2.lastIndexOf(","));
            }
            return str2;
        }
        w.e("MicroMsg.IPCallUserProfileUI", "no contact permission");
        return null;
        try {
            w.e("MicroMsg.IPCallUserProfileUI", "extractAddressItemFromCursor, error: %s, class: %s", new Object[]{e.getMessage(), e.getClass().getSimpleName()});
            if (str2.lastIndexOf(",") >= 0) {
                str2 = str2.substring(0, str2.lastIndexOf(","));
            }
            return str2;
        } finally {
            query.close();
        }
    }

    private void aFm() {
        this.mXQ.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ IPCallUserProfileUI mXY;

            {
                this.mXY = r1;
            }

            public final void onClick(View view) {
                this.mXY.mXX.start();
                this.mXY.mXX.mQn = 1;
                this.mXY.mXX.mQo = 5;
                this.mXY.mXX.finish();
                g.oUh.i(12766, new Object[]{Integer.valueOf(3)});
                Intent intent;
                if (!bg.mA(this.mXY.fWT)) {
                    intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + IPCallUserProfileUI.yM(this.mXY.fWT)));
                    intent.putExtra("sms_body", this.mXY.getString(R.l.etO, new Object[]{m.yr().tK()}));
                    this.mXY.startActivity(intent);
                } else if (!bg.mA(this.mXY.fWV)) {
                    intent = new Intent("android.intent.action.SENDTO", Uri.parse("smsto:" + this.mXY.fWV));
                    intent.putExtra("sms_body", this.mXY.getString(R.l.etO, new Object[]{m.yr().tK()}));
                    this.mXY.startActivity(intent);
                }
            }
        });
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void aFn() {
        /*
        r14 = this;
        r0 = r14.mXW;
        if (r0 != 0) goto L_0x0012;
    L_0x0004:
        r0 = r14.mXK;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r14.mXO;
        r1 = 8;
        r0.setVisibility(r1);
    L_0x0012:
        r0 = r14.fWT;
        r0 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r0 != 0) goto L_0x0118;
    L_0x001a:
        r0 = r14.fWT;
        r1 = com.tencent.mm.sdk.platformtools.bg.mA(r0);
        if (r1 != 0) goto L_0x0115;
    L_0x0022:
        r1 = com.tencent.mm.plugin.ipcall.a.i.aEn();
        r0 = r1.yt(r0);
        if (r0 == 0) goto L_0x0115;
    L_0x002c:
        r2 = r0.uxb;
        r4 = -1;
        r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1));
        if (r1 == 0) goto L_0x0115;
    L_0x0034:
        r6 = r0.uxb;
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();
        r0 = r0.gUz;
        r1 = "IPCallRecord";
        r2 = com.tencent.mm.plugin.ipcall.a.g.l.mRf;
        r3 = "addressId=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r5 = 0;
        r6 = java.lang.String.valueOf(r6);
        r4[r5] = r6;
        r5 = 0;
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r8 = "calltime desc limit 4";
        r7.<init>(r8);
        r7 = r7.toString();
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
    L_0x0060:
        r5 = r0;
    L_0x0061:
        if (r5 == 0) goto L_0x019b;
    L_0x0063:
        r0 = r5.getCount();
        if (r0 <= 0) goto L_0x019b;
    L_0x0069:
        r0 = r5.moveToFirst();	 Catch:{ Exception -> 0x014e }
        if (r0 == 0) goto L_0x0170;
    L_0x006f:
        r0 = 0;
    L_0x0070:
        r1 = r5.isAfterLast();	 Catch:{ Exception -> 0x014e }
        if (r1 != 0) goto L_0x0167;
    L_0x0076:
        r6 = new com.tencent.mm.plugin.ipcall.a.g.k;	 Catch:{ Exception -> 0x014e }
        r6.<init>();	 Catch:{ Exception -> 0x014e }
        r6.b(r5);	 Catch:{ Exception -> 0x014e }
        r3 = r0 + 1;
        r0 = 0;
        r1 = 3;
        if (r3 < r1) goto L_0x01aa;
    L_0x0084:
        r0 = 1;
        r4 = r0;
    L_0x0086:
        r7 = r5.getCount();	 Catch:{ Exception -> 0x014e }
        r0 = android.view.LayoutInflater.from(r14);	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.R.i.dlt;	 Catch:{ Exception -> 0x014e }
        r2 = r14.mXK;	 Catch:{ Exception -> 0x014e }
        r8 = 0;
        r8 = r0.inflate(r1, r2, r8);	 Catch:{ Exception -> 0x014e }
        r0 = com.tencent.mm.R.h.cte;	 Catch:{ Exception -> 0x014e }
        r0 = r8.findViewById(r0);	 Catch:{ Exception -> 0x014e }
        r0 = (android.widget.TextView) r0;	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.R.h.ctg;	 Catch:{ Exception -> 0x014e }
        r1 = r8.findViewById(r1);	 Catch:{ Exception -> 0x014e }
        r1 = (android.widget.TextView) r1;	 Catch:{ Exception -> 0x014e }
        r2 = com.tencent.mm.R.h.cth;	 Catch:{ Exception -> 0x014e }
        r2 = r8.findViewById(r2);	 Catch:{ Exception -> 0x014e }
        r2 = (android.widget.TextView) r2;	 Catch:{ Exception -> 0x014e }
        r9 = r6.field_phonenumber;	 Catch:{ Exception -> 0x014e }
        r9 = com.tencent.mm.plugin.ipcall.b.a.yY(r9);	 Catch:{ Exception -> 0x014e }
        r1.setText(r9);	 Catch:{ Exception -> 0x014e }
        r10 = r6.field_duration;	 Catch:{ Exception -> 0x014e }
        r12 = 0;
        r1 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1));
        if (r1 <= 0) goto L_0x0143;
    L_0x00c0:
        r10 = r6.field_duration;	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.plugin.ipcall.b.c.cx(r10);	 Catch:{ Exception -> 0x014e }
        r2.setText(r1);	 Catch:{ Exception -> 0x014e }
    L_0x00c9:
        r10 = r6.field_calltime;	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.plugin.ipcall.b.c.cv(r10);	 Catch:{ Exception -> 0x014e }
        r0.setText(r1);	 Catch:{ Exception -> 0x014e }
        if (r4 == 0) goto L_0x00f0;
    L_0x00d4:
        r0 = r14.getResources();	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.R.g.biB;	 Catch:{ Exception -> 0x014e }
        r0 = r0.getDrawable(r1);	 Catch:{ Exception -> 0x014e }
        r8.setBackgroundDrawable(r0);	 Catch:{ Exception -> 0x014e }
        r0 = r14.getResources();	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.R.f.baQ;	 Catch:{ Exception -> 0x014e }
        r0 = r0.getDimensionPixelSize(r1);	 Catch:{ Exception -> 0x014e }
        r1 = 0;
        r2 = 0;
        r8.setPadding(r0, r1, r0, r2);	 Catch:{ Exception -> 0x014e }
    L_0x00f0:
        r0 = 1;
        if (r0 != r7) goto L_0x0108;
    L_0x00f3:
        r0 = r8.getLayoutParams();	 Catch:{ Exception -> 0x014e }
        r0 = (android.widget.LinearLayout.LayoutParams) r0;	 Catch:{ Exception -> 0x014e }
        r1 = r14.uSU;	 Catch:{ Exception -> 0x014e }
        r1 = r1.uTo;	 Catch:{ Exception -> 0x014e }
        r2 = com.tencent.mm.R.f.baL;	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.bg.a.T(r1, r2);	 Catch:{ Exception -> 0x014e }
        r0.height = r1;	 Catch:{ Exception -> 0x014e }
        r8.setLayoutParams(r0);	 Catch:{ Exception -> 0x014e }
    L_0x0108:
        r0 = r14.mXK;	 Catch:{ Exception -> 0x014e }
        r0.addView(r8);	 Catch:{ Exception -> 0x014e }
        if (r4 != 0) goto L_0x0166;
    L_0x010f:
        r5.moveToNext();	 Catch:{ Exception -> 0x014e }
        r0 = r3;
        goto L_0x0070;
    L_0x0115:
        r0 = 0;
        goto L_0x0060;
    L_0x0118:
        r0 = com.tencent.mm.plugin.ipcall.a.i.aEo();
        r5 = r14.fWV;
        r0 = r0.gUz;
        r1 = "IPCallRecord";
        r2 = com.tencent.mm.plugin.ipcall.a.g.l.mRf;
        r3 = "phonenumber=?";
        r4 = 1;
        r4 = new java.lang.String[r4];
        r6 = 0;
        r4[r6] = r5;
        r5 = 0;
        r6 = 0;
        r7 = new java.lang.StringBuilder;
        r8 = "calltime desc limit 4";
        r7.<init>(r8);
        r7 = r7.toString();
        r0 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r5 = r0;
        goto L_0x0061;
    L_0x0143:
        r1 = r6.field_status;	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.plugin.ipcall.b.c.oz(r1);	 Catch:{ Exception -> 0x014e }
        r2.setText(r1);	 Catch:{ Exception -> 0x014e }
        goto L_0x00c9;
    L_0x014e:
        r0 = move-exception;
        r1 = "MicroMsg.IPCallUserProfileUI";
        r2 = "initRecordList, error: %s";
        r3 = 1;
        r3 = new java.lang.Object[r3];	 Catch:{ all -> 0x0196 }
        r4 = 0;
        r0 = r0.getMessage();	 Catch:{ all -> 0x0196 }
        r3[r4] = r0;	 Catch:{ all -> 0x0196 }
        com.tencent.mm.sdk.platformtools.w.e(r1, r2, r3);	 Catch:{ all -> 0x0196 }
        r5.close();
    L_0x0165:
        return;
    L_0x0166:
        r0 = r3;
    L_0x0167:
        if (r0 > 0) goto L_0x0174;
    L_0x0169:
        r0 = r14.mXK;	 Catch:{ Exception -> 0x014e }
        r1 = 8;
        r0.setVisibility(r1);	 Catch:{ Exception -> 0x014e }
    L_0x0170:
        r5.close();
        goto L_0x0165;
    L_0x0174:
        r0 = r5.getCount();	 Catch:{ Exception -> 0x014e }
        r1 = 4;
        if (r0 < r1) goto L_0x0170;
    L_0x017b:
        r0 = android.view.LayoutInflater.from(r14);	 Catch:{ Exception -> 0x014e }
        r1 = com.tencent.mm.R.i.dlu;	 Catch:{ Exception -> 0x014e }
        r2 = r14.mXK;	 Catch:{ Exception -> 0x014e }
        r3 = 0;
        r0 = r0.inflate(r1, r2, r3);	 Catch:{ Exception -> 0x014e }
        r1 = r14.mXK;	 Catch:{ Exception -> 0x014e }
        r1.addView(r0);	 Catch:{ Exception -> 0x014e }
        r1 = new com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI$3;	 Catch:{ Exception -> 0x014e }
        r1.<init>(r14);	 Catch:{ Exception -> 0x014e }
        r0.setOnClickListener(r1);	 Catch:{ Exception -> 0x014e }
        goto L_0x0170;
    L_0x0196:
        r0 = move-exception;
        r5.close();
        throw r0;
    L_0x019b:
        r0 = r14.mXK;
        r1 = 8;
        r0.setVisibility(r1);
        r0 = r14.mXO;
        r1 = 8;
        r0.setVisibility(r1);
        goto L_0x0165;
    L_0x01aa:
        r4 = r0;
        goto L_0x0086;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.ipcall.ui.IPCallUserProfileUI.aFn():void");
    }

    protected void onResume() {
        super.onResume();
        if (this.mXU) {
            this.mXU = false;
            this.mXK.removeAllViews();
            aFn();
        }
    }

    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
    }
}
