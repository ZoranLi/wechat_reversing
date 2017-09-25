package com.tencent.mm.pluginsdk.ui.d;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract.Contacts;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnCreateContextMenuListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.comm.PlatformComm.C2Java;
import com.tencent.mm.R;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.amr;
import com.tencent.mm.protocal.c.aqk;
import com.tencent.mm.protocal.c.aql;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.m;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.s;
import com.tencent.smtt.sdk.WebView;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import junit.framework.Assert;

public final class j {
    static String sTA;

    static class AnonymousClass3 implements OnCreateContextMenuListener {
        final /* synthetic */ List sTD;

        public AnonymousClass3(List list) {
            this.sTD = list;
        }

        public final void onCreateContextMenu(ContextMenu contextMenu, View view, ContextMenuInfo contextMenuInfo) {
            for (String add : this.sTD) {
                contextMenu.add(0, 0, 0, add);
            }
        }
    }

    private static class a extends BaseAdapter {
        private Context mContext = null;
        private List<String> mzj = null;
        private Bundle rx = null;
        private OnDismissListener sTH = null;
        a sTI = null;

        public interface a {
            void ff(boolean z);
        }

        private class b {
            TextView iUO;
            Button lKN;
            final /* synthetic */ a sTJ;
            TextView sTK;

            public b(a aVar) {
                this.sTJ = aVar;
            }
        }

        private class c {
            TextView iUO;
            final /* synthetic */ a sTJ;

            public c(a aVar) {
                this.sTJ = aVar;
            }
        }

        public a(List<String> list, Context context, OnDismissListener onDismissListener, Bundle bundle) {
            Assert.assertTrue(context != null);
            this.mzj = list;
            this.mContext = context;
            this.sTH = onDismissListener;
            this.rx = bundle;
        }

        public final int getCount() {
            return this.mzj == null ? 0 : this.mzj.size();
        }

        public final Object getItem(int i) {
            return this.mzj.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final int getViewTypeCount() {
            return 2;
        }

        public final int getItemViewType(int i) {
            if (this.mContext.getString(R.l.dUX).equals((String) this.mzj.get(i))) {
                return 1;
            }
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            Object obj;
            String str = (String) getItem(i);
            int itemViewType = getItemViewType(i);
            if (view == null) {
                Object bVar;
                View view2;
                LayoutInflater layoutInflater = (LayoutInflater) this.mContext.getSystemService("layout_inflater");
                View inflate;
                if (itemViewType == 1) {
                    inflate = layoutInflater.inflate(R.i.cYf, viewGroup, false);
                    bVar = new b(this);
                    ((b) bVar).iUO = (TextView) inflate.findViewById(R.h.title);
                    ((b) bVar).lKN = (Button) inflate.findViewById(R.h.bJY);
                    ((b) bVar).sTK = (TextView) inflate.findViewById(R.h.cIG);
                    view2 = inflate;
                } else {
                    inflate = layoutInflater.inflate(R.i.cYg, viewGroup, false);
                    bVar = new c(this);
                    ((c) bVar).iUO = (TextView) inflate.findViewById(R.h.title);
                    view2 = inflate;
                }
                view2.setTag(bVar);
                view = view2;
                obj = bVar;
            } else {
                obj = view.getTag();
            }
            switch (itemViewType) {
                case 0:
                    c cVar = (c) obj;
                    cVar.iUO.setText(h.b(this.mContext, bg.mz(str), cVar.iUO.getTextSize()));
                    break;
                case 1:
                    b bVar2 = (b) obj;
                    bVar2.iUO.setText(h.b(this.mContext, bg.mz(str), bVar2.iUO.getTextSize()));
                    bVar2.sTK.setText(this.mContext.getString(R.l.dVd));
                    bVar2.lKN.setOnClickListener(new OnClickListener(this) {
                        final /* synthetic */ a sTJ;

                        {
                            this.sTJ = r1;
                        }

                        public final void onClick(View view) {
                            if (C2Java.isNetworkConnected()) {
                                o.d(this.sTJ.mContext, this.sTJ.rx);
                                if (this.sTJ.sTI != null) {
                                    this.sTJ.sTI.ff(true);
                                    return;
                                }
                                return;
                            }
                            w.w("MicroMsg.MailPhoneMenuHelper", "hy: no network. abort download");
                            s.makeText(this.sTJ.mContext, this.sTJ.mContext.getString(R.l.elv), 0).show();
                            if (this.sTJ.sTI != null) {
                                this.sTJ.sTI.ff(false);
                            }
                        }
                    });
                    break;
                default:
                    w.e("MicroMsg.MailPhoneMenuHelper", "hy: error tag");
                    break;
            }
            return view;
        }
    }

    static class AnonymousClass4 implements d {
        final /* synthetic */ Context val$context;

        public AnonymousClass4(Context context) {
            this.val$context = context;
        }

        public final void c(MenuItem menuItem, int i) {
            Intent intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(menuItem.getTitle().toString().replace(" ", "").replace("(", "").replace(")", "").replace("-", "")).toString()));
            intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
            if (bg.j(this.val$context, intent)) {
                this.val$context.startActivity(intent);
            }
        }
    }

    public static void b(final Context context, final String str, final OnDismissListener onDismissListener) {
        if (((m.xW() & 1) == 0 ? 1 : 0) != 0) {
            g.a(context, str, context.getResources().getStringArray(R.c.aRZ), "", new c() {
                public final void hq(int i) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", "").replace("#", "@");
                    switch (i) {
                        case 0:
                            Context context = context;
                            Intent intent = new Intent();
                            intent.putExtra("composeType", 4);
                            String substring = replace.substring(0, replace.indexOf(64));
                            intent.putExtra("toList", new String[]{substring + " " + replace});
                            com.tencent.mm.bb.d.b(context, "qqmail", ".ui.ComposeUI", intent);
                            return;
                        case 1:
                            j.aW(context, replace);
                            return;
                        default:
                            return;
                    }
                }
            });
        } else {
            g.a(context, str, new String[]{context.getResources().getString(R.l.dTp)}, "", new c() {
                public final void hq(int i) {
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                    String replace = str.replace(" ", "").replace("#", "@");
                    switch (i) {
                        case 0:
                            j.aW(context, replace);
                            return;
                        default:
                            return;
                    }
                }
            });
        }
    }

    public static void a(Context context, String str, final OnDismissListener onDismissListener, Bundle bundle) {
        boolean booleanValue;
        boolean z;
        List f;
        if (!(context instanceof Activity)) {
            w.w("MicroMsg.MailPhoneMenuHelper", "context should be Activity, %s", bg.bJZ());
        }
        if (h.vG().uV()) {
            booleanValue = ((Boolean) h.vI().vr().get(com.tencent.mm.storage.w.a.USERFINO_IPCALL_HAS_ENTRY_BOOLEAN, Boolean.valueOf(false))).booleanValue();
        } else {
            booleanValue = false;
        }
        final int i = bundle != null ? bundle.getInt("fromScene") : 0;
        if (bGt() || bGu()) {
            z = true;
        } else {
            z = false;
        }
        if (z) {
            String[] strArr;
            String mz = bg.mz(bundle.getString("Contact_User"));
            if (mz == null || mz == "" || mz.endsWith("@chatroom") || m.eH(mz)) {
                strArr = booleanValue ? new String[]{context.getResources().getString(R.l.dVb), context.getResources().getString(R.l.dVc), context.getResources().getString(R.l.dUU)} : new String[]{context.getResources().getString(R.l.dVb), context.getResources().getString(R.l.dUU)};
            } else {
                x Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(mz);
                if (Rc != null) {
                    String tL = Rc.tL();
                    sTA = context.getResources().getString(R.l.dUV, new Object[]{tL});
                    strArr = booleanValue ? new String[]{context.getResources().getString(R.l.dVb), context.getResources().getString(R.l.dVc), sTA, context.getResources().getString(R.l.dUU)} : new String[]{context.getResources().getString(R.l.dVb), sTA, context.getResources().getString(R.l.dUU)};
                } else {
                    return;
                }
            }
            f = bg.f(strArr);
        } else {
            f = bg.f(new String[]{context.getResources().getString(R.l.dVb), context.getResources().getString(R.l.dUW)});
        }
        com.tencent.mm.plugin.report.service.g.oUh.i(11621, Integer.valueOf(i), Integer.valueOf(2));
        if (o.oz()) {
            f.add(context.getResources().getString(R.l.dUX));
            com.tencent.mm.plugin.report.service.g.oUh.i(11621, Integer.valueOf(i), Integer.valueOf(3));
            if (C2Java.isNetworkConnected()) {
                w.v("MicroMsg.WxPhoneBookHelper", "hy: minus pb counter, ori counter = %d", Integer.valueOf(bg.a((Integer) h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_WXPHONE_PB_COUNT_INT, null), 3)));
                h.vI().vr().a(com.tencent.mm.storage.w.a.USERINFO_WXPHONE_PB_COUNT_INT, Integer.valueOf(r0 - 1));
            }
        }
        final Dialog kVar = new k(context);
        kVar.setTitle(str);
        BaseAdapter aVar = new a(f, context, onDismissListener, bundle);
        aVar.sTI = new a() {
            public final void ff(boolean z) {
                if (z) {
                    kVar.dismiss();
                    if (onDismissListener != null) {
                        onDismissListener.onDismiss(null);
                    }
                }
            }
        };
        kVar.kjh = aVar;
        g.a(context, kVar);
        kVar.setOnCancelListener(new OnCancelListener() {
            public final void onCancel(DialogInterface dialogInterface) {
                if (onDismissListener != null) {
                    onDismissListener.onDismiss(null);
                }
            }
        });
        final String str2 = str;
        final Context context2 = context;
        final OnDismissListener onDismissListener2 = onDismissListener;
        final Bundle bundle2 = bundle;
        kVar.sVj = new OnItemClickListener() {
            public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
                final CharSequence replace = str2.replace(" ", "").replace("(", "").replace(")", "").replace("-", "");
                String str = (String) f.get(i);
                w.i("MicroMsg.MailPhoneMenuHelper", str);
                Intent intent;
                if (context2.getString(R.l.dVb).equals(str)) {
                    intent = new Intent("android.intent.action.DIAL", Uri.parse(new StringBuilder(WebView.SCHEME_TEL).append(replace).toString()));
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    if (bg.j(context2, intent)) {
                        context2.startActivity(intent);
                    }
                    com.tencent.mm.plugin.report.service.g.oUh.A(10112, "1");
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else if (context2.getString(R.l.dVc).equals(str)) {
                    com.tencent.mm.plugin.report.service.g.oUh.i(12059, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0));
                    intent = new Intent();
                    intent.putExtra("IPCallTalkUI_phoneNumber", replace);
                    com.tencent.mm.bb.d.b(context2, "ipcall", ".ui.IPCallDialUI", intent);
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else if (context2.getString(R.l.dUU).equals(str)) {
                    String[] stringArray;
                    if (j.bGt() && j.bGu()) {
                        stringArray = context2.getResources().getStringArray(R.c.aSl);
                    } else {
                        stringArray = j.bGt() ? new String[]{context2.getResources().getString(R.l.dUT)} : new String[]{context2.getResources().getString(R.l.dVa)};
                    }
                    context2.getResources().getString(R.l.dUZ);
                    g.a(context2, str2, stringArray, "", new c(this) {
                        final /* synthetic */ AnonymousClass7 sTG;

                        public final void hq(int i) {
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                            switch (i) {
                                case 0:
                                    if (j.bGt()) {
                                        Context context = context2;
                                        String str = replace;
                                        Intent intent = new Intent("android.intent.action.INSERT");
                                        intent.setType("vnd.android.cursor.dir/contact");
                                        intent.putExtra("phone", str);
                                        context.startActivity(intent);
                                        com.tencent.mm.plugin.report.service.g.oUh.A(10113, "1");
                                        return;
                                    }
                                    j.aX(context2, replace);
                                    com.tencent.mm.plugin.report.service.g.oUh.A(10114, "1");
                                    return;
                                case 1:
                                    j.aX(context2, replace);
                                    com.tencent.mm.plugin.report.service.g.oUh.A(10114, "1");
                                    return;
                                default:
                                    return;
                            }
                        }
                    }, new OnCancelListener(this) {
                        final /* synthetic */ AnonymousClass7 sTG;

                        {
                            this.sTG = r1;
                        }

                        public final void onCancel(DialogInterface dialogInterface) {
                            if (onDismissListener2 != null) {
                                onDismissListener2.onDismiss(null);
                            }
                        }
                    });
                    kVar.dismiss();
                } else if (context2.getString(R.l.dUW).equals(str)) {
                    com.tencent.mm.pluginsdk.j.d.a(context2, replace, replace);
                    com.tencent.mm.plugin.report.service.g.oUh.A(10115, "1");
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                    kVar.dismiss();
                } else if (context2.getString(R.l.dUX).equals(str)) {
                    w.d("MicroMsg.MailPhoneMenuHelper", "hy: button should consume this action");
                } else if (j.sTA.equals(str)) {
                    j.a((Activity) context2, str2, bundle2);
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                } else {
                    w.e("MicroMsg.MailPhoneMenuHelper", "hy: error phone item clicked. should not happen");
                    kVar.dismiss();
                    if (onDismissListener2 != null) {
                        onDismissListener2.onDismiss(null);
                    }
                }
            }
        };
        kVar.show();
    }

    public static void aW(Context context, String str) {
        Intent intent = new Intent("android.intent.action.SENDTO");
        intent.setData(Uri.parse(WebView.SCHEME_MAILTO));
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        if (bg.j(context, intent)) {
            context.startActivity(intent);
        } else {
            g.a(context, R.l.dUR, R.l.dIO, new DialogInterface.OnClickListener() {
                public final void onClick(DialogInterface dialogInterface, int i) {
                }
            });
        }
    }

    public static boolean bGt() {
        Context context = ab.getContext();
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.dir/contact");
        intent.putExtra("phone", "10086");
        return bg.j(context, intent);
    }

    public static boolean bGu() {
        return bg.j(ab.getContext(), new Intent("android.intent.action.PICK", Contacts.CONTENT_URI));
    }

    public static void aX(Context context, String str) {
        Intent intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
        intent.setType("vnd.android.cursor.item/person");
        intent.putExtra("phone", str);
        if (bg.j(context, intent)) {
            context.startActivity(intent);
        }
    }

    public static void a(Activity activity, String str, Bundle bundle) {
        String mz = bg.mz(bundle.getString("Contact_User"));
        if (mz == null) {
            w.e("MicroMsg.MailPhoneMenuHelper", "username is null");
            return;
        }
        x Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(mz);
        if (Rc == null) {
            w.e("MicroMsg.MailPhoneMenuHelper", "contact is null");
            return;
        }
        int i;
        ArrayList arrayList;
        String[] split;
        String string = bundle.getString("Contact_Mobile_MD5");
        String str2 = Rc.gkQ;
        if (!bg.mA(string)) {
            if (string == str) {
                i = 0;
            } else if (!Rc.tH()) {
                i = 1;
            }
            arrayList = new ArrayList();
            if (!bg.mA(str2)) {
                split = str2.split(",");
                for (Object add : split) {
                    arrayList.add(add);
                }
                if (arrayList.contains(str)) {
                    arrayList.remove(str);
                }
            }
            arrayList.add(str);
            if (arrayList.size() + i > 5) {
                a(activity, Rc, mz, arrayList);
                com.tencent.mm.plugin.report.service.g.oUh.i(12040, Rc.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
            }
            Toast.makeText(activity, activity.getString(R.l.eBu), 0).show();
            return;
        }
        i = 0;
        arrayList = new ArrayList();
        if (bg.mA(str2)) {
            split = str2.split(",");
            while (r3 < split.length) {
                arrayList.add(add);
            }
            if (arrayList.contains(str)) {
                arrayList.remove(str);
            }
        }
        arrayList.add(str);
        if (arrayList.size() + i > 5) {
            Toast.makeText(activity, activity.getString(R.l.eBu), 0).show();
            return;
        }
        a(activity, Rc, mz, arrayList);
        com.tencent.mm.plugin.report.service.g.oUh.i(12040, Rc.field_username, Integer.valueOf(4), Integer.valueOf(i), Integer.valueOf(i + arrayList.size()));
    }

    private static void a(Activity activity, x xVar, String str, ArrayList<String> arrayList) {
        com.tencent.mm.bd.a com_tencent_mm_protocal_c_amr = new amr();
        com_tencent_mm_protocal_c_amr.tRa = str;
        aql com_tencent_mm_protocal_c_aql = new aql();
        com_tencent_mm_protocal_c_aql.jNd = arrayList.size();
        com_tencent_mm_protocal_c_aql.tVf = new LinkedList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            aqk com_tencent_mm_protocal_c_aqk = new aqk();
            com_tencent_mm_protocal_c_aqk.tVe = str2;
            com_tencent_mm_protocal_c_aql.tVf.add(com_tencent_mm_protocal_c_aqk);
        }
        com_tencent_mm_protocal_c_amr.tQW = com_tencent_mm_protocal_c_aql;
        ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wQ().b(new com.tencent.mm.plugin.messenger.foundation.a.a.e.a(60, com_tencent_mm_protocal_c_amr));
        af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str);
        if (Rc != null && ((int) Rc.gTQ) > 0 && com.tencent.mm.j.a.ez(Rc.field_type)) {
            Iterator it2 = arrayList.iterator();
            String str3 = "";
            while (it2.hasNext()) {
                str3 = (str3 + ((String) it2.next())) + ",";
            }
            xVar.cr(str3);
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Q(xVar);
        }
        Toast.makeText(activity, activity.getString(R.l.eXf), 0).show();
    }
}
