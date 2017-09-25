package com.tencent.mm.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.jg.EType;
import com.jg.JgClassChecked;
import com.tencent.mm.s.a.e;
import com.tencent.mm.s.a.f;
import com.tencent.mm.s.a.h;
import com.tencent.mm.s.a.j;
import com.tencent.mm.s.a.k;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMEditText;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@JgClassChecked(author = 20, fComment = "checked", lastDate = "201400504", reviewer = 20, vComment = {EType.JSEXECUTECHECK})
public final class g {
    private static Toast vhJ;

    public interface a {
        void rO(int i);
    }

    public interface b {
        boolean u(CharSequence charSequence);
    }

    public interface c {
        void hq(int i);
    }

    public interface d {
        void bN(int i, int i2);
    }

    public static void a(Context context, Dialog dialog) {
        if (context instanceof MMActivity) {
            ((MMActivity) context).a(dialog);
        }
    }

    public static Toast bi(Context context, String str) {
        return bl(context, str);
    }

    public static Toast bj(Context context, String str) {
        return bl(context, str);
    }

    public static void bk(Context context, String str) {
        if (vhJ == null) {
            vhJ = Toast.makeText(context, str, 0);
        } else {
            vhJ.setText(str);
        }
        vhJ.show();
    }

    public static Toast bl(Context context, String str) {
        Toast makeText = Toast.makeText(context, str, 0);
        makeText.show();
        return makeText;
    }

    public static h z(Context context, String str, String str2) {
        return b(context, str, str2, true);
    }

    public static h b(Context context, String str, String str2, boolean z) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.kK(z);
        aVar.zZ(k.dHT).a(new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h h(Context context, int i, int i2) {
        return b(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", true);
    }

    public static h a(Context context, int i, int i2, OnClickListener onClickListener) {
        return a(context, i, i2, true, onClickListener);
    }

    public static h a(Context context, int i, int i2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        if (i2 > 0) {
            aVar.zW(i2);
        }
        aVar.zX(i);
        aVar.zZ(k.dHT).a(onClickListener);
        aVar.kK(z);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, OnClickListener onClickListener) {
        return a(context, str, str2, true, onClickListener);
    }

    public static h a(Context context, String str, String str2, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.zZ(k.dHT).a(onClickListener);
        aVar.kK(z);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, String str3, OnClickListener onClickListener) {
        return a(context, str, str2, str3, true, onClickListener);
    }

    public static h a(Context context, String str, String str2, String str3, boolean z, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.SZ(str3).a(onClickListener);
        aVar.kK(z);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.zZ(k.dHT).a(onClickListener);
        aVar.Aa(k.dGs).b(onClickListener2);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.zZ(k.dHT).a(onClickListener);
        aVar.Aa(k.dGs).b(onClickListener2);
        aVar.kK(z);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, str, str2, str3, str4, z, onClickListener, onClickListener2, -1);
    }

    public static h a(Context context, String str, String str2, String str3, String str4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.SZ(str3).a(onClickListener);
        aVar.Ta(str4).b(onClickListener2);
        aVar.kK(z);
        h WJ = aVar.WJ();
        if (i > 0) {
            WJ.zU(context.getResources().getColor(i));
        }
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", onClickListener, onClickListener2);
    }

    public static h b(Context context, int i, int i2, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", false, onClickListener, onClickListener2);
    }

    public static h a(Context context, int i, int i2, int i3, int i4, boolean z, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), z, onClickListener, onClickListener2);
    }

    public static h a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, OnClickListener onClickListener2, int i5) {
        return a(context, i > 0 ? context.getString(i) : "", i2 > 0 ? context.getString(i2) : "", context.getString(i3), context.getString(i4), false, onClickListener, onClickListener2, i5);
    }

    public static h a(Context context, int i, int i2, int i3, int i4, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        if (i2 != 0) {
            aVar.zW(i2);
        }
        aVar.zX(i);
        aVar.zZ(i3).a(onClickListener);
        aVar.Aa(i4).b(onClickListener2);
        aVar.d(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
            }
        });
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.SZ(str3).a(onClickListener);
        aVar.Ta(str4).b(onClickListener2);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.SZ(str3).a(onClickListener);
        aVar.Ta(str4).b(onClickListener2);
        h WJ = aVar.WJ();
        WJ.zU(context.getResources().getColor(i));
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.SZ(str3).a(onClickListener);
        aVar.Ta(str4).b(onClickListener2);
        aVar.kK(z);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, boolean z, String str, String str2, String str3, String str4, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.SZ(str3).a(onClickListener);
        aVar.Ta(str4).b(onClickListener2);
        aVar.kK(z);
        h WJ = aVar.WJ();
        if (i > 0) {
            WJ.zU(context.getResources().getColor(i));
        }
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str);
        aVar.dd(view);
        aVar.zZ(k.dHT).a(onClickListener);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, true, str, view, str2, str3, onClickListener, onClickListener2);
    }

    public static h a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2) {
        return a(context, z, str, view, str2, str3, onClickListener, onClickListener2, -1);
    }

    public static h a(Context context, boolean z, String str, View view, String str2, String str3, OnClickListener onClickListener, OnClickListener onClickListener2, int i) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str);
        aVar.dd(view);
        aVar.SZ(str2).a(onClickListener);
        aVar.Ta(str3).b(onClickListener2);
        aVar.kK(z);
        h WJ = aVar.WJ();
        if (i > 0) {
            WJ.zU(context.getResources().getColor(i));
        }
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, View view, OnClickListener onClickListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str);
        aVar.dd(view);
        aVar.SZ(str2).a(onClickListener);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, View view, OnClickListener onClickListener, final OnClickListener onClickListener2) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str);
        aVar.SX(null);
        aVar.dd(view);
        aVar.zZ(k.dHT).a(onClickListener);
        aVar.Aa(k.dGs).b(onClickListener2);
        aVar.d(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onClickListener2 != null) {
                    onClickListener2.onClick(dialogInterface, 0);
                }
            }
        });
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(final Context context, String str, String str2, String str3, int i, final b bVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.kK(false);
        aVar.kL(true);
        aVar.Aa(k.dGs).b(null);
        aVar.SW(str);
        View inflate = View.inflate(context, h.hea, null);
        final MMEditText mMEditText = (MMEditText) inflate.findViewById(com.tencent.mm.s.a.g.bKP);
        if (!bg.mA(str2)) {
            mMEditText.Uz(str2);
        }
        TextView textView = (TextView) inflate.findViewById(com.tencent.mm.s.a.g.cIS);
        if (bg.mA(str3)) {
            textView.setVisibility(8);
        } else {
            textView.setText(str3);
        }
        aVar.zZ(k.dHT).a(false, new OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i) {
                boolean z = true;
                if (bVar != null) {
                    z = bVar.u(mMEditText.getText().toString().trim());
                }
                if (z) {
                    dialogInterface.dismiss();
                    if (context instanceof MMActivity) {
                        af.v(new Runnable(this) {
                            final /* synthetic */ AnonymousClass12 vhO;

                            {
                                this.vhO = r1;
                            }

                            public final void run() {
                                ((MMActivity) context).aHf();
                            }
                        });
                    }
                }
            }
        });
        if (i > 0) {
            com.tencent.mm.ui.tools.a.c.d(mMEditText).Ch(i).a(null);
        }
        aVar.dd(inflate);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        if (!(context instanceof MMActivity)) {
            return WJ;
        }
        inflate.post(new Runnable() {
            public final void run() {
                ((MMActivity) context).aHj();
            }
        });
        return WJ;
    }

    public static h a(Context context, String str, List<String> list, int i, final a aVar) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if (list.isEmpty()) {
            w.w("MicroMsg.MMAlert", "show switch alert fail");
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar2 = new com.tencent.mm.ui.base.h.a(context);
        aVar2.kK(false);
        aVar2.Aa(k.dGs);
        aVar2.SW(str);
        View inflate = View.inflate(context, h.div, null);
        final LinearLayout linearLayout = (LinearLayout) inflate.findViewById(com.tencent.mm.s.a.g.cGZ);
        for (int size = list.size() - 1; size >= 0; size--) {
            TextView textView = (TextView) View.inflate(context, h.dlH, null);
            textView.setText((CharSequence) list.get(size));
            if (size == i) {
                textView.setCompoundDrawablesWithIntrinsicBounds(j.dze, 0, 0, 0);
            }
            if (size == list.size() - 1) {
                context.getResources().getDimensionPixelSize(e.aXH);
                textView.setBackgroundResource(f.bkp);
            }
            textView.setTag(Integer.valueOf(size));
            linearLayout.addView(textView, 0);
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    for (int i = 0; i < linearLayout.getChildCount(); i++) {
                        TextView textView = (TextView) linearLayout.getChildAt(i);
                        if (textView.getId() != com.tencent.mm.s.a.g.cIS) {
                            textView.setCompoundDrawablesWithIntrinsicBounds(j.dzd, 0, 0, 0);
                        }
                    }
                    ((TextView) view).setCompoundDrawablesWithIntrinsicBounds(j.dze, 0, 0, 0);
                    final int intValue = ((Integer) view.getTag()).intValue();
                    view.post(new Runnable(this) {
                        final /* synthetic */ AnonymousClass14 vhR;

                        public final void run() {
                            ((Dialog) linearLayout.getTag()).dismiss();
                            if (aVar != null) {
                                aVar.rO(intValue);
                            }
                        }
                    });
                }
            });
        }
        aVar2.dd(inflate);
        Dialog WJ = aVar2.WJ();
        linearLayout.setTag(WJ);
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static h a(Context context, String str, String str2, OnClickListener onClickListener, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        com.tencent.mm.ui.base.h.a aVar = new com.tencent.mm.ui.base.h.a(context);
        aVar.SW(str2);
        aVar.SX(str);
        aVar.zZ(k.dHT).a(onClickListener);
        aVar.d(onCancelListener);
        h WJ = aVar.WJ();
        WJ.show();
        a(context, WJ);
        return WJ;
    }

    public static p a(Context context, String str, boolean z, OnCancelListener onCancelListener) {
        return a(context, 0, str, z, onCancelListener);
    }

    public static p a(Context context, String str, OnCancelListener onCancelListener) {
        return a(context, 2, str, true, onCancelListener);
    }

    private static p a(Context context, int i, String str, boolean z, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        x.a(true, null);
        final WeakReference weakReference = new WeakReference(onCancelListener);
        p b = p.b(context, str, z, i, new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                OnCancelListener onCancelListener = (OnCancelListener) weakReference.get();
                if (onCancelListener != null) {
                    onCancelListener.onCancel(dialogInterface);
                }
                x.a(false, null);
            }
        });
        a(context, b);
        return b;
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, d dVar) {
        return b(context, str, list, list2, str2, true, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, String str2, boolean z, d dVar) {
        return b(context, str, list, list2, str2, z, dVar);
    }

    public static Dialog a(Context context, String str, List<String> list, List<Integer> list2, d dVar) {
        return b(context, str, list, list2, null, true, dVar);
    }

    @Deprecated
    private static Dialog b(Context context, final String str, List<String> list, final List<Integer> list2, final String str2, boolean z, final d dVar) {
        if ((list == null || list.size() == 0) && bg.mA(str2)) {
            return null;
        }
        if (list == null) {
            list = new ArrayList();
        }
        if (z) {
            l lVar = new l(context);
            lVar.qJf = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    if (!bg.mA(str)) {
                        lVar.setHeaderTitle(str);
                    }
                    for (int i = 0; i < list.size(); i++) {
                        lVar.e(((Integer) list2.get(i)).intValue(), (CharSequence) list.get(i));
                    }
                    if (!bg.mA(str2)) {
                        lVar.e(-1, str2);
                    }
                }
            };
            lVar.qJg = new com.tencent.mm.ui.base.n.d() {
                public final void c(MenuItem menuItem, int i) {
                    if (dVar != null) {
                        dVar.bN(i, menuItem.getItemId());
                    }
                }
            };
            lVar.e(null);
            Dialog blb = lVar.blb();
            a(context, blb);
            return blb;
        }
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(context, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                if (!bg.mA(str)) {
                    lVar.setHeaderTitle(str);
                }
                for (int i = 0; i < list.size(); i++) {
                    lVar.e(((Integer) list2.get(i)).intValue(), (CharSequence) list.get(i));
                }
                if (!bg.mA(str2)) {
                    lVar.e(-1, str2);
                }
            }
        };
        eVar.qJg = new com.tencent.mm.ui.base.n.d() {
            public final void c(MenuItem menuItem, int i) {
                if (dVar != null) {
                    dVar.bN(i, menuItem.getItemId());
                }
            }
        };
        eVar.bzh();
        return null;
    }

    public static Dialog a(Context context, String str, String[] strArr, c cVar) {
        return a(context, str, strArr, null, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar) {
        return a(context, str, strArr, str2, true, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, boolean z, c cVar) {
        return a(context, str, strArr, str2, z, cVar, null);
    }

    public static Dialog a(Context context, String str, String[] strArr, String str2, c cVar, OnCancelListener onCancelListener) {
        return a(context, str, strArr, str2, true, cVar, onCancelListener);
    }

    @Deprecated
    public static Dialog a(Context context, final String str, String[] strArr, String str2, boolean z, final c cVar, OnCancelListener onCancelListener) {
        if ((context instanceof Activity) && ((Activity) context).isFinishing()) {
            return null;
        }
        if ((strArr == null || strArr.length == 0) && bg.mA(str2)) {
            return null;
        }
        final ArrayList arrayList = new ArrayList();
        if (strArr != null && strArr.length > 0) {
            Collections.addAll(arrayList, strArr);
        }
        if (!bg.mA(str2)) {
            arrayList.add(str2);
        }
        if (z) {
            l lVar = new l(context);
            lVar.qJf = new com.tencent.mm.ui.base.n.c() {
                public final void a(l lVar) {
                    lVar.setHeaderTitle(str);
                    for (int i = 0; i < arrayList.size(); i++) {
                        lVar.e(i, (CharSequence) arrayList.get(i));
                    }
                }
            };
            lVar.qJg = new com.tencent.mm.ui.base.n.d() {
                public final void c(MenuItem menuItem, int i) {
                    if (cVar != null) {
                        cVar.hq(menuItem.getItemId());
                    }
                }
            };
            lVar.e(onCancelListener);
            Dialog blb = lVar.blb();
            a(context, blb);
            return blb;
        }
        com.tencent.mm.ui.widget.e eVar = new com.tencent.mm.ui.widget.e(context, com.tencent.mm.ui.widget.e.wuP, false);
        eVar.qJf = new com.tencent.mm.ui.base.n.c() {
            public final void a(l lVar) {
                lVar.setHeaderTitle(str);
                for (int i = 0; i < arrayList.size(); i++) {
                    lVar.e(i, (CharSequence) arrayList.get(i));
                }
            }
        };
        eVar.qJg = new com.tencent.mm.ui.base.n.d() {
            public final void c(MenuItem menuItem, int i) {
                if (cVar != null) {
                    cVar.hq(menuItem.getItemId());
                }
            }
        };
        eVar.bzh();
        return null;
    }
}
