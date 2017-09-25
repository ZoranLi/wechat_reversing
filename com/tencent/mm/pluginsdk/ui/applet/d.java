package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.ColorDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.R;
import com.tencent.mm.a.e;
import com.tencent.mm.bi.g;
import com.tencent.mm.plugin.gif.MMGIFImageView;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.j;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.base.NoMeasuredTextView;
import com.tencent.mm.ui.base.PasterEditText;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.h.a.b;
import com.tencent.mm.ui.base.h.a.c;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.l;
import com.tencent.mm.ui.r;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import junit.framework.Assert;

public final class d implements k {

    static class AnonymousClass10 implements OnClickListener {
        final /* synthetic */ com.tencent.mm.pluginsdk.ui.applet.k.a sMl;
        final /* synthetic */ o sMm;
        final /* synthetic */ View zG;

        AnonymousClass10(com.tencent.mm.pluginsdk.ui.applet.k.a aVar, View view, o oVar) {
            this.sMl = aVar;
            this.zG = view;
            this.sMm = oVar;
        }

        public final void onClick(View view) {
            if (this.sMl != null) {
                this.sMl.a(true, d.cP(this.zG), d.cQ(this.zG));
            }
            this.sMm.dismiss();
            this.sMm.setFocusable(false);
            this.sMm.setTouchable(false);
        }
    }

    static class AnonymousClass6 implements OnDismissListener {
        final /* synthetic */ Bitmap ohP;

        AnonymousClass6(Bitmap bitmap) {
            this.ohP = bitmap;
        }

        public final void onDismiss() {
            if (this.ohP != null && !this.ohP.isRecycled()) {
            }
        }
    }

    static class AnonymousClass8 implements DialogInterface.OnDismissListener {
        final /* synthetic */ Bitmap ohP;

        AnonymousClass8(Bitmap bitmap) {
            this.ohP = bitmap;
        }

        public final void onDismiss(DialogInterface dialogInterface) {
            if (this.ohP != null && !this.ohP.isRecycled()) {
                this.ohP.recycle();
            }
        }
    }

    public static class a {
        public DialogInterface.OnDismissListener jrW;
        public Context mContext;
        public h oHT;
        public final com.tencent.mm.ui.base.h.a sMq;
        public String sMr = null;

        public a(Context context) {
            this.mContext = context;
            this.sMq = new com.tencent.mm.ui.base.h.a(this.mContext);
            this.sMq.kK(false);
            this.sMq.kL(false);
            this.sMq.vix.vfS = new c(this) {
                final /* synthetic */ a sMs;

                {
                    this.sMs = r1;
                }

                public final CharSequence a(CharSequence charSequence, float f) {
                    return g.bKH().d(this.sMs.mContext, charSequence, f);
                }
            };
        }

        public final a bs(Object obj) {
            d.a(this.mContext, this.sMq, obj);
            this.sMq.kJ(true);
            return this;
        }

        public final a bEU() {
            this.sMq.vix.vgi = 2;
            return this;
        }

        public final a MP(String str) {
            int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(this.mContext, (int) (14.0f * com.tencent.mm.bg.a.dI(this.mContext)));
            if (!bg.mA(str)) {
                this.sMq.N(g.bKH().b(this.mContext, str.toString(), fromDPToPix));
            }
            return this;
        }

        public final a MQ(String str) {
            this.sMq.vix.fKz = str;
            return this;
        }

        public final a bEV() {
            this.sMq.vix.vgl = 8;
            return this;
        }

        public final a a(Bitmap bitmap, int i) {
            this.sMq.a(bitmap, true, i);
            this.sMq.kJ(false);
            this.sMq.a(new AnonymousClass8(bitmap));
            return this;
        }

        public final a MR(String str) {
            Context context = this.mContext;
            com.tencent.mm.ui.base.h.a aVar = this.sMq;
            View inflate = r.eC(context).inflate(R.i.diu, null);
            MMGIFImageView mMGIFImageView = (MMGIFImageView) inflate.findViewById(R.h.bJr);
            if (mMGIFImageView == null) {
                w.e("MicroMsg.MMConfirmDialog", "Error , emoji imageView is null !!");
            } else {
                com.tencent.mm.storage.a.c ub = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ub(str);
                if (str.indexOf(File.separatorChar) == -1) {
                    com.tencent.mm.pluginsdk.c.d emojiMgr = ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr();
                    ap.yY();
                    com.tencent.mm.u.c.xi();
                    str = emojiMgr.bP("", str);
                }
                if (ub == null || (ub.field_reserved4 & com.tencent.mm.storage.a.c.uLn) != com.tencent.mm.storage.a.c.uLn) {
                    mMGIFImageView.yj(str);
                } else {
                    mMGIFImageView.h(((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().g(ub), "");
                }
                aVar.dd(inflate);
                aVar.zY(1);
            }
            this.sMq.kJ(false);
            return this;
        }

        public final a a(com.tencent.mm.ui.base.h.a.a aVar) {
            this.sMq.vix.vfR = aVar;
            return this;
        }

        public final a cR(View view) {
            this.sMq.dd(view);
            return this;
        }

        public final a c(Boolean bool) {
            this.sMq.vix.vfK = bool.booleanValue();
            if (bool.booleanValue()) {
                this.sMq.SY(this.mContext.getString(R.l.dXj));
            }
            return this;
        }

        public final a MS(String str) {
            this.sMq.SY(str);
            return this;
        }

        public final a bEW() {
            this.sMq.kJ(false);
            return this;
        }

        public final a xp(int i) {
            this.sMr = this.mContext.getResources().getString(i);
            return this;
        }

        public final a a(com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
            this.oHT = this.sMq.WJ();
            if (this.jrW != null) {
                this.oHT.setOnDismissListener(this.jrW);
            }
            d.a(this.mContext, this.oHT, this.sMr, null, aVar, aVar);
            return this;
        }
    }

    public static void a(Context context, com.tencent.mm.ui.base.h.a aVar, Object obj) {
        if (obj != null) {
            if (obj instanceof String) {
                obj = bg.f(((String) obj).split(","));
            } else if (obj instanceof List) {
                List list = (List) obj;
            } else {
                obj = null;
            }
            if (!bg.bV(obj)) {
                if (obj.size() == 1) {
                    final String str = (String) obj.get(0);
                    aVar.M(g.bKH().b(context, context.getString(R.l.eLJ).toString(), com.tencent.mm.bg.a.fromDPToPix(context, (int) (20.0f * com.tencent.mm.bg.a.dI(context)))));
                    String eK = n.eK(str);
                    int fromDPToPix = com.tencent.mm.bg.a.fromDPToPix(context, (int) (14.0f * com.tencent.mm.bg.a.dI(context)));
                    if (com.tencent.mm.u.o.dH(str)) {
                        CharSequence b = g.bKH().b(context, (eK + context.getString(R.l.eQo, new Object[]{Integer.valueOf(j.eC(str))})).toString(), fromDPToPix);
                        final View inflate = r.eC(context).inflate(R.i.dah, null);
                        GridView gridView = (GridView) inflate.findViewById(R.h.bzd);
                        final List arrayList = new ArrayList();
                        final List eA = j.eA(str);
                        aVar.a(str, b, Boolean.valueOf(true), new b() {
                            public final void bET() {
                                bg.cX(inflate);
                                if (arrayList.size() == 0 && !bg.mA(str)) {
                                    ArrayList arrayList = arrayList;
                                    List<String> list = eA;
                                    if (!bg.bV(list)) {
                                        for (String eK : list) {
                                            arrayList.add(n.eK(eK));
                                        }
                                    }
                                }
                            }
                        });
                        gridView.setAdapter(new h(context, eA, arrayList));
                        gridView.setSelector(new ColorDrawable(context.getResources().getColor(R.e.transparent)));
                        if (eA != null) {
                            if (eA.size() > 16) {
                                gridView.setLayoutParams(new LayoutParams(-1, com.tencent.mm.bg.a.T(context, R.f.aWW)));
                                gridView.setPadding(com.tencent.mm.bg.a.T(context, R.f.aWV), 0, com.tencent.mm.bg.a.T(context, R.f.aWV), 0);
                            } else {
                                gridView.setPadding(0, 0, 0, com.tencent.mm.bg.a.T(context, R.f.aWU));
                            }
                        }
                        aVar.vix.vgg = inflate;
                        return;
                    }
                    aVar.a(str, g.bKH().b(context, eK.toString(), fromDPToPix), Boolean.valueOf(false), null);
                    return;
                }
                aVar.vix.vfM = obj;
                aVar.SW(context.getString(R.l.eBB));
            }
        }
    }

    public static void a(Context context, final h hVar, String str, String str2, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar2) {
        if (bg.mA(str) || str.length() == 0) {
            str = context.getResources().getString(R.l.dXm);
        }
        if (bg.mA(str2) || str2.length() == 0) {
            str2 = context.getResources().getString(R.l.dGs);
        }
        hVar.a(str, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar != null) {
                    aVar.a(true, hVar.bRK(), hVar.bRL());
                }
            }
        });
        hVar.b(str2, true, new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    public static h a(l lVar, String str, String str2, String str3, String str4, boolean z, String str5, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(lVar.uTo, R.i.cZm, null);
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        aVar2.kK(false);
        aVar2.kL(false);
        a(aVar2, lVar.uTo, str);
        l(inflate, z);
        a(lVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.bEC);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, str3, textView.getTextSize()));
        inflate.findViewById(R.h.bEz).setVisibility(8);
        int a = BackwardSupportUtil.b.a(lVar.uTo, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.bEE);
        if (cdnImageView != null) {
            cdnImageView.L(str2, a, a);
        }
        aVar2.dd(inflate);
        h WJ = aVar2.WJ();
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, String str, String str2, boolean z, String str3, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        return a(lVar, str, str2, z, str3, aVar, lVar.uTo.getResources().getString(R.l.dIU));
    }

    public static h a(l lVar, String str, String str2, boolean z, String str3, com.tencent.mm.pluginsdk.ui.applet.k.a aVar, String str4) {
        if ((str == null || str.length() == 0) && (str2 == null || str2.length() == 0)) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        String string = lVar.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(lVar.uTo, aVar2, bg.f(string.split(",")));
        }
        aVar2.kJ(true);
        aVar2.N(str).kK(false).kL(false);
        if (z) {
            aVar2.SY(lVar.uTo.getString(R.l.dXj));
        }
        h WJ = aVar2.WJ();
        a(lVar.uTo, WJ, str3, null, aVar, aVar);
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, String str, String str2, String str3, String str4, String str5, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        if ((str == null || str.length() == 0) && (str3 == null || str3.length() == 0)) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        View inflate = View.inflate(lVar.uTo, R.i.cZm, null);
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        aVar2.kK(false);
        aVar2.kL(false);
        a(aVar2, lVar.uTo, str);
        if (inflate != null) {
            EditText editText = (EditText) inflate.findViewById(R.h.bED);
            if (editText != null) {
                editText.setVisibility(0);
            }
            editText.setText(str4);
        }
        a(lVar, aVar2, aVar, inflate, str5);
        TextView textView = (TextView) inflate.findViewById(R.h.bEC);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, str3, textView.getTextSize()));
        inflate.findViewById(R.h.bEz).setVisibility(8);
        int a = BackwardSupportUtil.b.a(lVar.uTo, 120.0f);
        CdnImageView cdnImageView = (CdnImageView) inflate.findViewById(R.h.bEE);
        if (cdnImageView != null) {
            cdnImageView.L(str2, a, a);
        }
        aVar2.dd(inflate);
        h WJ = aVar2.WJ();
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        return a(lVar, str, z, "", aVar);
    }

    public static h a(l lVar, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem2 fail, message is empty");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        String string = lVar.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(lVar.uTo, aVar2, bg.f(string.split(",")));
        }
        aVar2.kJ(true);
        aVar2.N(str).kK(false).kL(false);
        if (z) {
            aVar2.SY(lVar.uTo.getString(R.l.dXj));
        }
        h WJ = aVar2.WJ();
        a(lVar.uTo, WJ, str2, null, aVar, aVar);
        WJ.show();
        return WJ;
    }

    public static h b(l lVar, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        return b(lVar, str, z, "", aVar);
    }

    public static h b(l lVar, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        if (str == null || !e.aO(str)) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, img does not exist");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        String string = lVar.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(lVar.uTo, aVar2, bg.f(string.split(",")));
        }
        aVar2.kJ(true);
        aVar2.kK(false).kL(false);
        if (z) {
            aVar2.SY(lVar.uTo.getString(R.l.dXj));
        }
        if (!bg.mA(str)) {
            Bitmap Pg = com.tencent.mm.sdk.platformtools.d.Pg(str);
            if (Pg != null) {
                aVar2.a(Pg, true, 3);
                a(aVar2, Pg);
                aVar2.kJ(false);
            }
        }
        h WJ = aVar2.WJ();
        a(lVar.uTo, WJ, str2, null, aVar, aVar);
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, byte[] bArr, boolean z, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        return a(lVar, bArr, z, "", aVar);
    }

    public static h a(l lVar, byte[] bArr, boolean z, String str, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        if (bArr == null || bArr.length == 0) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem3 fail, imgData is null");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        String string = lVar.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(lVar.uTo, aVar2, bg.f(string.split(",")));
        }
        aVar2.kJ(true);
        aVar2.kK(false).kL(false);
        if (z) {
            aVar2.SY(lVar.uTo.getString(R.l.dXj));
        }
        if (bArr != null && bArr.length > 0) {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
            if (decodeByteArray != null) {
                aVar2.a(decodeByteArray, true, 3);
                a(aVar2, decodeByteArray);
                aVar2.kJ(false);
            }
        }
        h WJ = aVar2.WJ();
        a(lVar.uTo, WJ, str, null, aVar, aVar);
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, String str, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem4 fail, title message both are empty");
            return null;
        }
        View O = O(lVar.uTo, R.i.cZn);
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        aVar2.kK(false);
        aVar2.kL(false);
        if (O != null) {
            EditText editText = (EditText) O.findViewById(R.h.bED);
            if (editText != null) {
                editText.setVisibility(0);
                editText.setHint(bg.mz(str2));
            }
        }
        a(lVar, aVar2, aVar, O, str3);
        if (!bg.mA(null)) {
            a(aVar2, lVar.uTo, null);
        }
        ((TextView) O.findViewById(R.h.bEF)).setVisibility(8);
        TextView textView = (TextView) O.findViewById(R.h.bEC);
        textView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, str, textView.getTextSize()));
        ((TextView) O.findViewById(R.h.bEz)).setVisibility(8);
        int a = BackwardSupportUtil.b.a(lVar.uTo, 120.0f);
        ImageView imageView = (CdnImageView) O.findViewById(R.h.bEE);
        if (imageView != null) {
            if (!bg.mA(null)) {
                com.tencent.mm.pluginsdk.ui.a.b.a(imageView, null);
            } else if (bg.mA(null)) {
                imageView.setVisibility(8);
            } else {
                imageView.L(null, a, a);
            }
        }
        aVar2.dd(O);
        h WJ = aVar2.WJ();
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, int i, String str, boolean z, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        return a(lVar, i, str, z, "", aVar);
    }

    public static h a(l lVar, int i, String str, boolean z, String str2, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        String string = lVar.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            a(lVar.uTo, aVar2, bg.f(string.split(",")));
        }
        aVar2.kJ(true);
        if (i == R.k.dte) {
            string = lVar.uTo.getResources().getString(R.l.dHn);
        } else if (i == R.k.dtg) {
            string = lVar.uTo.getResources().getString(R.l.dHI);
        } else if (i == R.k.dtr) {
            string = lVar.uTo.getResources().getString(R.l.dIX);
        } else {
            string = lVar.uTo.getResources().getString(R.l.dDm);
        }
        aVar2.N(str).kK(false).kL(false);
        if (z) {
            aVar2.SY(lVar.uTo.getString(R.l.dXj));
        }
        h WJ = aVar2.WJ();
        a(lVar.uTo, WJ, str2, null, aVar, aVar);
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, String str, boolean z, int i, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        return a(lVar, str, z, i, "", aVar);
    }

    public static h a(l lVar, String str, boolean z, int i, String str2, com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        Object f;
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        String string = lVar.uTo.getIntent().getExtras().getString("Select_Conv_User", null);
        if (string != null) {
            f = bg.f(string.split(","));
        } else {
            f = null;
        }
        a(lVar.uTo, aVar2, f);
        aVar2.kJ(true);
        switch (i) {
            case 1:
                string = lVar.uTo.getResources().getString(R.l.dIX);
                break;
            case 2:
                string = lVar.uTo.getResources().getString(R.l.dHI);
                break;
            default:
                string = lVar.uTo.getResources().getString(R.l.dDm);
                break;
        }
        aVar2.N(new StringBuffer(string).append(str).toString()).kK(false).kL(false);
        if (z) {
            aVar2.SY(lVar.uTo.getString(R.l.dXj));
        }
        h WJ = aVar2.WJ();
        a(lVar.uTo, WJ, str2, null, aVar, aVar);
        WJ.show();
        return WJ;
    }

    public static h a(l lVar, String str, String str2, String str3, com.tencent.mm.pluginsdk.ui.applet.k.a aVar, com.tencent.mm.pluginsdk.ui.applet.k.a aVar2) {
        com.tencent.mm.ui.base.h.a aVar3 = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        aVar3.a(com.tencent.mm.compatible.f.a.decodeResource(lVar.uTo.getResources(), R.k.dwz), false, 3);
        aVar3.kK(false);
        aVar3.kL(false);
        aVar3.bRM();
        aVar3.vix.vfH = str;
        aVar3.zY(17);
        h WJ = aVar3.WJ();
        a(lVar.uTo, WJ, str3, str2, aVar2, aVar);
        WJ.zV(lVar.uTo.getResources().getColor(R.e.aUd));
        WJ.show();
        return WJ;
    }

    public static o b(l lVar, String str, String str2, String str3, String str4, String str5, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        final View O = O(lVar.uTo, R.i.cZq);
        final o cO = cO(O);
        a(O, aVar, cO);
        if (bg.mA(str2)) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        a(O, R.h.bEF, str2, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) O.findViewById(R.h.bEC);
        noMeasuredTextView.voV = true;
        noMeasuredTextView.H(lVar.uTo.getResources().getDimension(R.f.aWE) * com.tencent.mm.bg.a.dI(lVar.uTo));
        noMeasuredTextView.setTextColor(com.tencent.mm.bg.a.S(lVar.uTo, R.e.aVo));
        if (bg.mA(str)) {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, str3, noMeasuredTextView.gm.getTextSize()));
        } else {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, n.eK(str), noMeasuredTextView.gm.getTextSize()));
        }
        a(O, R.h.bEA, str4, true, 8);
        Button button = (Button) O.findViewById(R.h.bEv);
        if (!bg.mA(str5)) {
            button.setText(str5);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, d.cP(O), d.cQ(O));
                }
                cO.dismiss();
                cO.setFocusable(false);
                cO.setTouchable(false);
            }
        });
        if (!bg.mA(str)) {
            com.tencent.mm.pluginsdk.ui.a.b.a((ImageView) O.findViewById(R.h.bEE), str);
        }
        a(lVar, cO);
        return cO;
    }

    public static o a(l lVar, long j, String str, String str2, String str3, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar) {
        final View O = O(lVar.uTo, R.i.cZq);
        final o cO = cO(O);
        a(O, aVar, cO);
        if (bg.mA(str)) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem8 fail,title or  message is empty");
            return null;
        }
        String str4;
        String str5;
        a(O, R.h.bEF, str, false, 0);
        NoMeasuredTextView noMeasuredTextView = (NoMeasuredTextView) O.findViewById(R.h.bEC);
        noMeasuredTextView.voV = true;
        noMeasuredTextView.H(lVar.uTo.getResources().getDimension(R.f.aWE) * com.tencent.mm.bg.a.dI(lVar.uTo));
        noMeasuredTextView.setTextColor(com.tencent.mm.bg.a.S(lVar.uTo, R.e.aVo));
        com.tencent.mm.modelbiz.a.c aa = com.tencent.mm.modelbiz.w.DJ().aa(j);
        String str6;
        if (aa.DV()) {
            str4 = aa.field_chatName;
            str5 = aa.field_headImageUrl;
            str6 = aa.field_brandUserName;
            CharSequence charSequence = str4;
            str4 = str5;
            str5 = str6;
        } else {
            com.tencent.mm.modelbiz.a.j iD = com.tencent.mm.modelbiz.w.DL().iD(aa.field_bizChatServId);
            if (iD != null) {
                str4 = iD.field_userName;
                str5 = iD.field_headImageUrl;
                str6 = iD.field_brandUserName;
                Object obj = str4;
                str4 = str5;
                str5 = str6;
            } else {
                w.w("MicroMsg.MMConfirmDialog", "showDialogItem8 userInfo is null");
                return null;
            }
        }
        if (charSequence == null) {
            charSequence = str2;
        }
        if (bg.mA(charSequence)) {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, str2, noMeasuredTextView.gm.getTextSize()));
        } else {
            noMeasuredTextView.setText(com.tencent.mm.pluginsdk.ui.d.h.b(lVar.uTo, charSequence, noMeasuredTextView.gm.getTextSize()));
        }
        a(O, R.h.bEA, null, true, 8);
        Button button = (Button) O.findViewById(R.h.bEv);
        if (!bg.mA(str3)) {
            button.setText(str3);
        }
        button.setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, d.cP(O), d.cQ(O));
                }
                cO.dismiss();
                cO.setFocusable(false);
                cO.setTouchable(false);
            }
        });
        com.tencent.mm.ah.a.a.c.a aVar2 = new com.tencent.mm.ah.a.a.c.a();
        aVar2.hIO = com.tencent.mm.modelbiz.a.e.iz(str5);
        aVar2.hIL = true;
        aVar2.hJh = true;
        aVar2.hJa = R.k.bes;
        com.tencent.mm.ah.a.a.c Hg = aVar2.Hg();
        if (!bg.mA(str4)) {
            com.tencent.mm.ah.n.GW().a(str4, (ImageView) O.findViewById(R.h.bEE), Hg);
        }
        a(lVar, cO);
        return cO;
    }

    public static h a(l lVar, String str, View view, String str2, final k.b bVar) {
        if (str == null || str.length() == 0) {
            w.e("MicroMsg.MMConfirmDialog", "showDialogItem1 fail, title message both are empty");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(lVar.uTo);
        aVar.kK(false);
        aVar.kL(false);
        a(aVar, lVar.uTo, str);
        if (bg.mA(str2) || str2.length() == 0) {
            str2 = lVar.uTo.getResources().getString(R.l.dXm);
        }
        aVar.SZ(str2).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.fg(true);
                }
            }
        });
        aVar.Aa(R.l.dGs).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (bVar != null) {
                    bVar.fg(false);
                }
            }
        });
        aVar.dd(view);
        h WJ = aVar.WJ();
        WJ.zU(lVar.uTo.getResources().getColor(R.e.aWu));
        WJ.show();
        return WJ;
    }

    public static View O(Context context, int i) {
        return ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(i, null);
    }

    static o cO(View view) {
        return new o(view, -1, -1);
    }

    public static void a(l lVar, com.tencent.mm.ui.base.h.a aVar, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar2, final View view, String str) {
        if (bg.mA(str) || str.length() == 0) {
            str = lVar.uTo.getResources().getString(R.l.dXm);
        }
        aVar.SZ(str).a(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(true, d.cP(view), d.cQ(view));
                }
            }
        });
        aVar.Aa(R.l.dGs).b(new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                if (aVar2 != null) {
                    aVar2.a(false, null, 0);
                }
            }
        });
    }

    private static void a(com.tencent.mm.ui.base.h.a aVar, Context context, String str) {
        aVar.SW(str);
        aVar.vix.sHe = context.getResources().getColor(R.e.aVo);
        aVar.vix.vgh = 2;
    }

    static void a(final View view, final com.tencent.mm.pluginsdk.ui.applet.k.a aVar, final o oVar) {
        ((Button) view.findViewById(R.h.bEv)).setOnClickListener(new OnClickListener() {
            public final void onClick(View view) {
                if (aVar != null) {
                    aVar.a(true, d.cP(view), d.cQ(view));
                }
                oVar.dismiss();
                oVar.setFocusable(false);
                oVar.setTouchable(false);
            }
        });
        Button button = (Button) view.findViewById(R.h.bEw);
        if (button != null) {
            button.setOnClickListener(new OnClickListener() {
                public final void onClick(View view) {
                    if (aVar != null) {
                        aVar.a(false, null, 0);
                    }
                    oVar.dismiss();
                    oVar.setFocusable(false);
                    oVar.setTouchable(false);
                }
            });
        }
    }

    public static void l(View view, boolean z) {
        if (view != null) {
            EditText editText = (EditText) view.findViewById(R.h.bED);
            if (editText != null) {
                editText.setVisibility(z ? 0 : 8);
            }
        }
    }

    private static void a(View view, int i, String str, boolean z, int i2) {
        TextView textView = (TextView) view.findViewById(i);
        Assert.assertTrue(textView != null);
        if (z && bg.mA(str)) {
            textView.setVisibility(i2);
        } else {
            textView.setText(str);
        }
    }

    public static String cP(View view) {
        EditText editText = (EditText) view.findViewById(R.h.bED);
        return editText == null ? null : editText.getText().toString();
    }

    public static int cQ(View view) {
        EditText editText = (EditText) view.findViewById(R.h.bED);
        if (editText instanceof PasterEditText) {
            return ((PasterEditText) editText).bkj();
        }
        return 0;
    }

    static void a(l lVar, o oVar) {
        try {
            if (!lVar.uTo.isFinishing()) {
                oVar.setInputMethodMode(1);
                oVar.setSoftInputMode(16);
                oVar.setFocusable(true);
                oVar.setTouchable(true);
                oVar.showAtLocation(lVar.uTo.getWindow().getDecorView(), 17, 0, 0);
            }
        } catch (Throwable e) {
            w.e("MicroMsg.MMConfirmDialog", "show dialog fail: %s", e.getMessage());
            w.printErrStackTrace("MicroMsg.MMConfirmDialog", e, "", new Object[0]);
        }
    }

    public static void a(com.tencent.mm.ui.base.h.a aVar, final Bitmap bitmap) {
        aVar.a(new DialogInterface.OnDismissListener() {
            public final void onDismiss(DialogInterface dialogInterface) {
                if (bitmap != null && !bitmap.isRecycled()) {
                }
            }
        });
    }
}
