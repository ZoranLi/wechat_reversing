package com.tencent.mm.pluginsdk.ui.applet;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.modelsimple.aa;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.ui.applet.d.AnonymousClass10;
import com.tencent.mm.pluginsdk.ui.applet.d.AnonymousClass6;
import com.tencent.mm.protocal.c.awr;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.d;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.RegionCodeDecoder;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.x.n;
import com.tencent.mm.y.e;
import com.tencent.mm.y.k;
import java.util.LinkedList;

public final class b implements com.tencent.mm.pluginsdk.ui.applet.a.a, com.tencent.mm.x.d.a {
    private String gVl;
    private int hPi;
    public String jia;
    public ProgressDialog kIa;
    public x kWy;
    public Context mContext;
    private a sLZ;
    public h sMa;
    public e sMb;
    private boolean sMc;

    public interface a {
        void pb(int i);
    }

    public b(Context context, String str, a aVar) {
        this(context, str, 0, aVar, true, "");
    }

    public b(Context context, String str, int i, a aVar, String str2) {
        this(context, str, i, aVar, true, str2);
    }

    public b(Context context, String str, int i, a aVar, boolean z, String str2) {
        this.sMb = null;
        this.sMc = true;
        this.mContext = context;
        this.jia = str;
        this.hPi = i;
        this.sLZ = aVar;
        this.sMc = z;
        this.gVl = str2;
    }

    public final void show() {
        ap.yY();
        this.kWy = c.wR().Rc(this.jia);
        if (this.kWy != null && ((int) this.kWy.gTQ) <= 0) {
            w.i("MicroMsg.AddContactDialog", "dealAddContact get by username fail, try alias, %s", this.jia);
            ap.yY();
            this.kWy = c.wR().QZ(this.jia);
        }
        if (this.kWy == null || ((int) this.kWy.gTQ) <= 0) {
            Context context = this.mContext;
            this.mContext.getString(R.l.dIO);
            this.kIa = g.a(context, this.mContext.getString(R.l.fnD), true, new OnCancelListener(this) {
                final /* synthetic */ b sMd;

                {
                    this.sMd = r1;
                }

                public final void onCancel(DialogInterface dialogInterface) {
                    if (this.sMd.kIa != null) {
                        this.sMd.kIa.dismiss();
                        this.sMd.kIa = null;
                    }
                }
            });
            ML(this.jia);
            return;
        }
        w.i("MicroMsg.AddContactDialog", "The contact already exists, so go to dealAddContact.");
        if (this.kWy == null) {
            w.e("MicroMsg.AddContactDialog", "dealAddContact fail, contact is null");
            ey(-1);
            return;
        }
        String str = this.kWy.field_username;
        if (this.kWy.bLe()) {
            if (com.tencent.mm.j.a.ez(this.kWy.field_type)) {
                g.bl(this.mContext, this.mContext.getResources().getString(R.l.fnG));
                ey(-2);
                return;
            }
            M(this.kWy);
        } else if (com.tencent.mm.modelbiz.w.DH().hO(str).CB()) {
            Context context2 = this.mContext;
            this.mContext.getString(R.l.dIO);
            this.kIa = g.a(context2, this.mContext.getString(R.l.fnD), true, null);
            ML(str);
        } else {
            Bitmap decodeResource = BitmapFactory.decodeResource(this.mContext.getResources(), R.g.beq);
            if (this.mContext instanceof MMActivity) {
                OnCancelListener onCancelListener;
                l lVar = ((MMActivity) this.mContext).uSU;
                CharSequence string = this.mContext.getResources().getString(R.l.fnI);
                com.tencent.mm.pluginsdk.ui.applet.k.a anonymousClass5 = new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                    final /* synthetic */ b sMd;

                    {
                        this.sMd = r1;
                    }

                    public final void a(boolean z, String str, int i) {
                        w.e("MicroMsg.AddContactDialog", "doAddContact fail, contact not biz");
                        this.sMd.ey(-1);
                    }
                };
                View O = d.O(lVar.uTo, R.i.cZp);
                o cO = d.cO(O);
                d.a(O, anonymousClass5, cO);
                if (bg.mA(string)) {
                    w.e("MicroMsg.MMConfirmDialog", "showDialogItem7 fail, message is empty");
                    onCancelListener = null;
                } else {
                    TextView textView = (TextView) O.findViewById(R.h.bEC);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, string, textView.getTextSize()));
                    Button button = (Button) O.findViewById(R.h.bEv);
                    ImageView imageView = (ImageView) O.findViewById(R.h.bEE);
                    if (imageView != null) {
                        if (decodeResource == null || decodeResource.isRecycled()) {
                            imageView.setVisibility(8);
                        } else {
                            imageView.setImageBitmap(decodeResource);
                            cO.setOnDismissListener(new AnonymousClass6(decodeResource));
                        }
                    }
                    button.setOnClickListener(new AnonymousClass10(anonymousClass5, O, cO));
                    d.a(lVar, cO);
                    Object obj = cO;
                }
                if (onCancelListener == null) {
                    w.e("MicroMsg.AddContactDialog", "dealAddContact fail, connot show dialog");
                    ey(-1);
                }
            }
        }
    }

    public final void M(final x xVar) {
        if (xVar == null) {
            w.e("MicroMsg.AddContactDialog", "showContact fail, contact is null");
            ey(-1);
            return;
        }
        Bitmap bitmap;
        CharSequence string = this.mContext.getString(R.l.fnB);
        Bitmap a = com.tencent.mm.x.b.a(xVar.field_username, false, -1);
        if (a == null) {
            n.Bl().a(this);
        }
        if (a == null || !xVar.bLe()) {
            bitmap = a;
        } else {
            bitmap = d.a(a, false, (float) (a.getWidth() / 2));
        }
        CharSequence charSequence = xVar.field_nickname;
        this.sMa = null;
        if (this.mContext instanceof MMActivity) {
            if (this.sMc) {
                h hVar;
                l lVar = ((MMActivity) this.mContext).uSU;
                CharSequence charSequence2 = "";
                int i = R.l.dXC;
                xVar.bLe();
                com.tencent.mm.pluginsdk.ui.applet.k.a anonymousClass2 = new com.tencent.mm.pluginsdk.ui.applet.k.a(this) {
                    final /* synthetic */ b sMd;

                    public final void a(boolean z, String str, int i) {
                        if (z) {
                            this.sMd.N(xVar);
                        } else {
                            this.sMd.ey(0);
                        }
                        this.sMd.sMa.dismiss();
                    }
                };
                if ((string == null || string.length() == 0) && (charSequence == null || charSequence.length() == 0)) {
                    w.e("MicroMsg.MMConfirmDialog", "showDialogItem6 fail, title message both are empty");
                    hVar = null;
                } else {
                    View O = d.O(lVar.uTo, R.i.cZo);
                    com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(lVar.uTo);
                    aVar.kK(false);
                    aVar.kL(false);
                    d.l(O, false);
                    d.a(lVar, aVar, anonymousClass2, O, lVar.uTo.getResources().getString(i));
                    TextView textView = (TextView) O.findViewById(R.h.bEF);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, string, textView.getTextSize()));
                    textView = (TextView) O.findViewById(R.h.bEC);
                    textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, charSequence, textView.getTextSize()));
                    if (charSequence2.length() == 0) {
                        O.findViewById(R.h.bEz).setVisibility(8);
                    } else {
                        ((TextView) O.findViewById(R.h.bEz)).setText(charSequence2);
                    }
                    ImageView imageView = (ImageView) O.findViewById(R.h.bEE);
                    if (imageView != null) {
                        if (bitmap == null || bitmap.isRecycled()) {
                            imageView.setVisibility(4);
                        } else {
                            imageView.setImageBitmap(bitmap);
                            d.a(aVar, bitmap);
                        }
                    }
                    aVar.dd(O);
                    hVar = aVar.WJ();
                    hVar.show();
                }
                this.sMa = hVar;
            } else {
                N(xVar);
                return;
            }
        }
        if (this.sMa == null) {
            w.e("MicroMsg.AddContactDialog", "showContact fail, cannot show dialog");
            ey(-1);
        }
    }

    public final void N(x xVar) {
        if (this.kIa != null) {
            this.kIa.dismiss();
        }
        Context context = this.mContext;
        this.mContext.getString(R.l.dIO);
        this.kIa = g.a(context, this.mContext.getString(R.l.fnD), true, null);
        a aVar = new a(this.mContext, this);
        LinkedList linkedList = new LinkedList();
        linkedList.add(Integer.valueOf(this.hPi));
        aVar.a(xVar.field_username, linkedList, this.gVl);
    }

    public final void ho(String str) {
        Object obj = 1;
        if (this.kWy != null) {
            Object obj2 = (this.kWy.field_username == null || !this.kWy.field_username.equals(str)) ? null : 1;
            if (this.kWy.pA() == null || !this.kWy.pA().equals(str)) {
                obj = null;
            }
            if (obj2 == null && r1 == null) {
                return;
            }
        } else if (this.jia == null || !this.jia.equals(str)) {
            return;
        }
        if (this.sMa != null && this.sMa.isShowing()) {
            af.v(new Runnable(this) {
                final /* synthetic */ b sMd;

                {
                    this.sMd = r1;
                }

                public final void run() {
                    ImageView imageView = (ImageView) this.sMd.sMa.getContentView().findViewById(R.h.bEE);
                    if (imageView != null) {
                        Bitmap a = com.tencent.mm.x.b.a(this.sMd.kWy.field_username, false, -1);
                        if (a != null && this.sMd.kWy.bLe()) {
                            a = d.a(a, false, (float) (a.getWidth() / 2));
                        }
                        if (a != null && !a.isRecycled()) {
                            imageView.setImageBitmap(a);
                            imageView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    private void ML(String str) {
        w.i("MicroMsg.AddContactDialog", "searchContact %s", str);
        if (this.sMb == null) {
            this.sMb = new e(this) {
                final /* synthetic */ b sMd;

                {
                    this.sMd = r1;
                }

                public final void a(int i, int i2, String str, k kVar) {
                    if (this.sMd.kIa != null) {
                        this.sMd.kIa.dismiss();
                    }
                    if (this.sMd.sMb != null) {
                        ap.vd().b((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this.sMd.sMb);
                    }
                    if (this.sMd.kIa == null) {
                        w.e("MicroMsg.AddContactDialog", "has cancel the loading dialog");
                        this.sMd.ey(0);
                    } else if (i != 0 || i2 != 0) {
                        w.e("MicroMsg.AddContactDialog", "searchContact onSceneEnd, errType = %d, errCode = %d", Integer.valueOf(i), Integer.valueOf(i2));
                        this.sMd.ey(-1);
                    } else if (this.sMd.mContext == null) {
                        w.e("MicroMsg.AddContactDialog", "searchContact, context is null, msghandler has already been detached!");
                        this.sMd.ey(-1);
                    } else if ((this.sMd.mContext instanceof Activity) && ((Activity) this.sMd.mContext).isFinishing()) {
                        w.e("MicroMsg.AddContactDialog", "searchContact, context isFinishing");
                        this.sMd.ey(-1);
                    } else {
                        awr Jx = ((aa) kVar).Jx();
                        String a = com.tencent.mm.platformtools.n.a(Jx.ttp);
                        if (bg.mA(a)) {
                            w.e("MicroMsg.AddContactDialog", "searchContact, user is null");
                            g.bl(this.sMd.mContext, this.sMd.mContext.getResources().getString(R.l.fnC));
                            this.sMd.ey(-1);
                            return;
                        }
                        if (this.sMd.jia == null || !this.sMd.jia.equals(a)) {
                            w.w("MicroMsg.AddContactDialog", "user not the same, %s, %s", this.sMd.jia, a);
                        }
                        b bVar = this.sMd;
                        ap.yY();
                        bVar.kWy = c.wR().Rc(a);
                        if (this.sMd.kWy == null || ((int) this.sMd.kWy.gTQ) == 0) {
                            w.i("MicroMsg.AddContactDialog", "searchContact, no contact with username = " + a + ", try get by alias");
                            bVar = this.sMd;
                            ap.yY();
                            bVar.kWy = c.wR().QZ(a);
                            if (this.sMd.kWy == null || ((int) this.sMd.kWy.gTQ) == 0) {
                                w.i("MicroMsg.AddContactDialog", "searchContact, no contact with alias, new Contact");
                                this.sMd.kWy = new x(a);
                                this.sMd.kWy.bO(Jx.hAI);
                                this.sMd.kWy.bR(com.tencent.mm.platformtools.n.a(Jx.tLj));
                                this.sMd.kWy.bS(com.tencent.mm.platformtools.n.a(Jx.ttf));
                                this.sMd.kWy.bT(com.tencent.mm.platformtools.n.a(Jx.ttg));
                                this.sMd.kWy.di(Jx.hAD);
                                this.sMd.kWy.ck(RegionCodeDecoder.ab(Jx.hAM, Jx.hAE, Jx.hAF));
                                this.sMd.kWy.ce(Jx.hAG);
                                this.sMd.kWy.de(Jx.tMP);
                                this.sMd.kWy.cj(Jx.tMQ);
                                this.sMd.kWy.dd(Jx.tMT);
                                this.sMd.kWy.bU(Jx.tMS);
                                this.sMd.kWy.ci(Jx.tMR);
                            }
                        } else {
                            w.i("MicroMsg.AddContactDialog", "searchContact, contact in db, %s", a);
                        }
                        this.sMd.M(this.sMd.kWy);
                    }
                }
            };
        }
        ap.vd().a((int) MMGIFException.D_GIF_ERR_NO_COLOR_MAP, this.sMb);
        ap.vd().a(new aa(str), 0);
    }

    public final void a(boolean z, boolean z2, String str, String str2) {
        if (this.kIa != null) {
            this.kIa.dismiss();
        }
        if (z) {
            this.kWy.tc();
            ap.yY();
            c.wR().a(this.kWy.field_username, this.kWy);
            g.bl(this.mContext, this.mContext.getResources().getString(R.l.fnG));
            ey(1);
            return;
        }
        ey(-1);
    }

    public final void ey(int i) {
        if (this.sLZ != null) {
            this.sLZ.pb(i);
        }
    }
}
