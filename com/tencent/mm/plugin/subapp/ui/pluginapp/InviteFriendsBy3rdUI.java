package com.tencent.mm.plugin.subapp.ui.pluginapp;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bb.d;
import com.tencent.mm.modelmulti.i;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.h;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.preference.MMPreference;
import com.tencent.mm.ui.base.preference.Preference;
import com.tencent.mm.ui.base.preference.f;
import com.tencent.mm.ui.j.a.a;
import com.tencent.mm.ui.j.a.b;
import com.tencent.mm.ui.j.a.c;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.io.RandomAccessFile;

public class InviteFriendsBy3rdUI extends MMPreference implements a, b, e {
    private static int qVj = 1;
    private static int qVk = 2;
    private static int qVl = 3;
    private static int qVm = 4;
    private static int qVn = 5;
    private static int qVo = 0;
    private static int qVp = 1;
    private int fromScene;
    private ProgressDialog isv = null;
    private ProgressBar lKt = null;
    private ProgressDialog mWt = null;
    private com.tencent.mm.ui.j.a qKe = new com.tencent.mm.ui.j.a();
    private int qVq = 0;
    private Bitmap qVr = null;
    private View qVs;
    private ImageView qVt = null;
    private EditText qVu = null;
    private boolean qVv = false;
    private boolean qVw = false;

    static /* synthetic */ class AnonymousClass3 {
        static final /* synthetic */ int[] mWR = new int[c.values().length];

        static {
            try {
                mWR[c.wrC.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                mWR[c.wrE.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                mWR[c.wrD.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    static /* synthetic */ void a(InviteFriendsBy3rdUI inviteFriendsBy3rdUI, int i, String str) {
        final k iVar = new i(i, str);
        inviteFriendsBy3rdUI.getString(R.l.dIO);
        inviteFriendsBy3rdUI.isv = g.a(inviteFriendsBy3rdUI, inviteFriendsBy3rdUI.getString(R.l.dIB), true, new OnCancelListener(inviteFriendsBy3rdUI) {
            final /* synthetic */ InviteFriendsBy3rdUI qVx;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(iVar);
            }
        });
        ap.vd().a(iVar, 0);
    }

    public final int ON() {
        return R.o.ftM;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        zi(R.l.ekc);
        this.fromScene = getIntent().getIntExtra("Invite_friends", 4);
        int i = bg.getInt(com.tencent.mm.i.g.sV().getValue("InviteFriendsInviteFlags"), 0);
        f fVar = this.vrv;
        if ((i & 2) <= 0) {
            fVar.Te("invite_friends_by_message");
        }
        if ((i & 1) <= 0) {
            fVar.Te("invite_friends_by_mail");
        }
        if ((i & 4) <= 0 || !ah(this.uSU.uTo, "com.whatsapp")) {
            fVar.Te("invite_friends_by_whatsapp");
        }
        if ((i & 8) <= 0 || !m.yk()) {
            fVar.Te("invite_friends_by_facebook");
        }
        if ((i & 16) <= 0) {
            fVar.Te("invite_friends_by_twitter");
        }
        fVar.notifyDataSetChanged();
        ap.vd().a(1803, this);
        ap.vd().a(1804, this);
        ap.vd().a(bw.CTRL_INDEX, this);
        b(new OnMenuItemClickListener(this) {
            final /* synthetic */ InviteFriendsBy3rdUI qVx;

            {
                this.qVx = r1;
            }

            public final boolean onMenuItemClick(MenuItem menuItem) {
                this.qVx.finish();
                return true;
            }
        });
    }

    protected void onDestroy() {
        ap.vd().b(1803, this);
        ap.vd().b(1804, this);
        ap.vd().b(bw.CTRL_INDEX, this);
        if (this.qVq == 0) {
            com.tencent.mm.plugin.report.service.g.oUh.i(14035, new Object[]{Integer.valueOf(this.qVq), Integer.valueOf(qVo), Integer.valueOf(this.fromScene)});
        }
        super.onDestroy();
    }

    public final boolean a(f fVar, Preference preference) {
        if ("invite_friends_by_message".equals(preference.igL)) {
            this.qVq = qVk;
            uy(2);
            return true;
        } else if ("invite_friends_by_mail".equals(preference.igL)) {
            this.qVq = qVj;
            uy(1);
            return true;
        } else if ("invite_friends_by_whatsapp".equals(preference.igL)) {
            this.qVq = qVl;
            uy(4);
            return true;
        } else if ("invite_friends_by_facebook".equals(preference.igL)) {
            this.qVq = qVm;
            if (m.ym()) {
                this.qVw = true;
                uy(8);
                return true;
            }
            g.a(this.uSU.uTo, R.l.eSx, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ InviteFriendsBy3rdUI qVx;

                {
                    this.qVx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    d.a(this.qVx.uSU.uTo, ".ui.account.FacebookAuthUI", new Intent());
                }
            }, new OnClickListener(this) {
                final /* synthetic */ InviteFriendsBy3rdUI qVx;

                {
                    this.qVx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        } else if (!"invite_friends_by_twitter".equals(preference.igL)) {
            return false;
        } else {
            this.qVq = qVn;
            if (this.qKe.cam()) {
                this.qVv = true;
                uy(16);
                return true;
            }
            g.a(this.uSU.uTo, R.l.eUC, R.l.dIO, new OnClickListener(this) {
                final /* synthetic */ InviteFriendsBy3rdUI qVx;

                {
                    this.qVx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                    InviteFriendsBy3rdUI inviteFriendsBy3rdUI = this.qVx;
                    Context context = this.qVx.uSU.uTo;
                    this.qVx.uSU.uTo.getString(R.l.dIO);
                    inviteFriendsBy3rdUI.mWt = g.a(context, this.qVx.uSU.uTo.getString(R.l.eYA), true, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass6 qVy;

                        {
                            this.qVy = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                        }
                    });
                    this.qVx.qKe.a(this.qVx, this.qVx.uSU.uTo);
                }
            }, new OnClickListener(this) {
                final /* synthetic */ InviteFriendsBy3rdUI qVx;

                {
                    this.qVx = r1;
                }

                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
            return true;
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        w.i("MicroMsg.InviteFriendsBy3rdUI", "onSceneEnd: errType = " + i + " errCode = " + i2 + " errMsg = " + str);
        if (this.isv != null) {
            this.isv.dismiss();
            this.isv = null;
        }
        if (!(i == 0 && i2 == 0)) {
            com.tencent.mm.plugin.report.service.g.oUh.i(14035, new Object[]{Integer.valueOf(this.qVq), Integer.valueOf(qVo), Integer.valueOf(this.fromScene)});
        }
        if (kVar.getType() == 1803) {
            if (i == 0 && i2 == 0) {
                Intent intent;
                com.tencent.mm.modelmulti.f fVar = (com.tencent.mm.modelmulti.f) kVar;
                String str2 = bg.mA(fVar.title) ? null : fVar.title;
                fVar = (com.tencent.mm.modelmulti.f) kVar;
                String str3 = bg.mA(fVar.content) ? null : fVar.content;
                String xM = m.xM();
                ap.yY();
                String str4 = (String) com.tencent.mm.u.c.vr().get(6, null);
                if (bg.mA(xM)) {
                    xM = str4;
                }
                int i3 = ((com.tencent.mm.modelmulti.f) kVar).hKq;
                if ((i3 & 1) > 0) {
                    if (bg.mA(str2)) {
                        str2 = String.format(getString(R.l.esU), new Object[]{m.xN()});
                    }
                    if (bg.mA(str3)) {
                        str3 = String.format(getString(R.l.esT), new Object[]{xM});
                    }
                    Intent intent2 = new Intent("android.intent.action.SEND");
                    intent2.putExtra("android.intent.extra.SUBJECT", str2);
                    intent2.putExtra("android.intent.extra.TEXT", str3);
                    intent2.setType("plain/text");
                    startActivity(Intent.createChooser(intent2, getString(R.l.esP)));
                    com.tencent.mm.plugin.report.service.g.oUh.i(14035, new Object[]{Integer.valueOf(this.qVq), Integer.valueOf(qVp), Integer.valueOf(this.fromScene)});
                }
                str4 = str3;
                if ((i3 & 2) > 0) {
                    if (bg.mA(str4)) {
                        str4 = String.format(getString(R.l.esV), new Object[]{xM});
                    }
                    intent = new Intent("android.intent.action.VIEW");
                    intent.putExtra("sms_body", str4);
                    intent.setType("vnd.android-dir/mms-sms");
                    if (bg.j(this, intent)) {
                        startActivity(intent);
                    } else {
                        Toast.makeText(this, R.l.eQE, 1).show();
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.i(14035, new Object[]{Integer.valueOf(this.qVq), Integer.valueOf(qVp), Integer.valueOf(this.fromScene)});
                }
                if ((i3 & 4) > 0) {
                    if (bg.mA(str4)) {
                        str4 = String.format(getString(R.l.esV), new Object[]{xM});
                    }
                    intent = new Intent();
                    intent.setAction("android.intent.action.SEND");
                    intent.putExtra("android.intent.extra.TEXT", str4);
                    intent.setType("text/plain");
                    intent.setPackage("com.whatsapp");
                    startActivity(intent);
                    com.tencent.mm.plugin.report.service.g.oUh.i(14035, new Object[]{Integer.valueOf(this.qVq), Integer.valueOf(qVp), Integer.valueOf(this.fromScene)});
                }
                if ((i3 & 8) > 0) {
                    if (bg.mA(str4)) {
                        if (bg.mA(m.xM())) {
                            str4 = getString(R.l.esS);
                        } else {
                            str4 = String.format(getString(R.l.esR), new Object[]{m.xM()});
                        }
                    }
                    str2 = getString(R.l.esO);
                    if (this.qVw) {
                        k(i3, str4, str2);
                        this.qVw = false;
                    }
                }
                if ((i3 & 16) > 0) {
                    this.qKe.a(this);
                    if (bg.mA(str4)) {
                        if (bg.mA(m.xM())) {
                            str4 = getString(R.l.esS);
                        } else {
                            str4 = String.format(getString(R.l.esR), new Object[]{m.xM()});
                        }
                    }
                    str2 = getString(R.l.esQ);
                    if (this.qVv) {
                        k(i3, str4, str2);
                        this.qVv = false;
                    }
                }
            } else {
                g.h(this.uSU.uTo, R.l.ewn, R.l.dIO);
                return;
            }
        }
        if (kVar.getType() == 1804) {
            if (i == 0 && i2 == 0) {
                g.bl(this, getResources().getString(R.l.dXl));
                com.tencent.mm.plugin.report.service.g.oUh.i(14035, new Object[]{Integer.valueOf(this.qVq), Integer.valueOf(qVp), Integer.valueOf(this.fromScene)});
            } else {
                g.h(this.uSU.uTo, R.l.eRk, R.l.dIO);
                return;
            }
        }
        if (kVar.getType() == bw.CTRL_INDEX && i == 0 && i2 == 0 && this.qVt != null) {
            if (this.lKt != null) {
                this.lKt.setVisibility(8);
            }
            this.qVt.setImageBitmap(aFl());
        }
    }

    private void uy(int i) {
        final k fVar = new com.tencent.mm.modelmulti.f(i);
        getString(R.l.dIO);
        this.isv = g.a(this, getString(R.l.cbS), true, new OnCancelListener(this) {
            final /* synthetic */ InviteFriendsBy3rdUI qVx;

            public final void onCancel(DialogInterface dialogInterface) {
                ap.vd().c(fVar);
            }
        });
        ap.vd().a(fVar, 0);
    }

    private static boolean ah(Context context, String str) {
        if (bg.mA(str)) {
            return false;
        }
        try {
            context.getPackageManager().getApplicationInfo(str, 8192);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }

    private void ow(int i) {
        g.a(this.uSU.uTo, i, R.l.dIO, new OnClickListener(this) {
            final /* synthetic */ InviteFriendsBy3rdUI qVx;

            {
                this.qVx = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        }, new OnClickListener(this) {
            final /* synthetic */ InviteFriendsBy3rdUI qVx;

            {
                this.qVx = r1;
            }

            public final void onClick(DialogInterface dialogInterface, int i) {
            }
        });
    }

    public final void a(c cVar) {
        if (this.mWt != null) {
            this.mWt.cancel();
        }
        switch (AnonymousClass3.mWR[cVar.ordinal()]) {
            case 1:
                ow(R.l.eYC);
                return;
            case 3:
                ow(R.l.eYB);
                return;
            default:
                return;
        }
    }

    public final void b(c cVar) {
    }

    private void k(final int i, final String str, String str2) {
        this.qVs = View.inflate(this.uSU.uTo, R.i.cZl, null);
        this.qVu = (EditText) this.qVs.findViewById(R.h.bED);
        this.qVt = (ImageView) this.qVs.findViewById(R.h.bEB);
        this.lKt = (ProgressBar) this.qVs.findViewById(R.h.cbP);
        ((View) this.qVt.getParent()).setVisibility(8);
        this.qVu.setText(str);
        this.qVr = aFl();
        if (this.qVr == null) {
            String xL = m.xL();
            ap.yY();
            ap.vd().a(new com.tencent.mm.aq.a(xL, bg.f((Integer) com.tencent.mm.u.c.vr().get(66561, null))), 0);
            ((ProgressBar) this.qVs.findViewById(R.h.cbP)).setVisibility(0);
        } else if (this.qVt != null) {
            this.qVt.setImageBitmap(this.qVr);
        }
        com.tencent.mm.pluginsdk.ui.applet.d.a(this.uSU, str2, this.qVs, getResources().getString(R.l.dIA), new com.tencent.mm.pluginsdk.ui.applet.k.b(this) {
            final /* synthetic */ InviteFriendsBy3rdUI qVx;

            public final void fg(boolean z) {
                if (z) {
                    InviteFriendsBy3rdUI.a(this.qVx, i, this.qVx.qVu == null ? str : this.qVx.qVu.getText().toString());
                }
            }
        });
    }

    private static Bitmap aFl() {
        byte[] yL = yL(m.xL());
        if (yL == null) {
            return null;
        }
        return com.tencent.mm.sdk.platformtools.d.bd(yL);
    }

    private static byte[] yL(String str) {
        Throwable e;
        ap.yY();
        String xb = com.tencent.mm.u.c.xb();
        ap.yY();
        RandomAccessFile randomAccessFile;
        try {
            randomAccessFile = new RandomAccessFile(h.f(xb, com.tencent.mm.u.c.xc(), "qr_", com.tencent.mm.a.g.n(str.getBytes()), ".png"), "r");
            try {
                byte[] bArr = new byte[((int) randomAccessFile.length())];
                randomAccessFile.read(bArr);
                try {
                    randomAccessFile.close();
                    return bArr;
                } catch (Exception e2) {
                    return bArr;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    w.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e4) {
                        }
                    }
                    return null;
                } catch (Throwable th) {
                    e = th;
                    if (randomAccessFile != null) {
                        try {
                            randomAccessFile.close();
                        } catch (Exception e5) {
                        }
                    }
                    throw e;
                }
            }
        } catch (Exception e6) {
            e = e6;
            randomAccessFile = null;
            w.printErrStackTrace("MicroMsg.InviteFriendsBy3rdUI", e, "", new Object[0]);
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            return null;
        } catch (Throwable th2) {
            e = th2;
            randomAccessFile = null;
            if (randomAccessFile != null) {
                randomAccessFile.close();
            }
            throw e;
        }
    }
}
