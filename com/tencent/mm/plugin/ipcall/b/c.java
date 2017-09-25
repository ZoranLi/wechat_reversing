package com.tencent.mm.plugin.ipcall.b;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.text.format.DateFormat;
import com.tencent.mm.R;
import com.tencent.mm.al.a;
import com.tencent.mm.plugin.voip.b.d;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.protocal.c.adf;
import com.tencent.mm.protocal.c.ark;
import com.tencent.mm.protocal.c.bjx;
import com.tencent.mm.protocal.c.bjy;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.io.IOException;
import java.net.InetAddress;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

public final class c {
    public static bjy X(LinkedList<ark> linkedList) {
        if (linkedList == null || linkedList.size() <= 0) {
            return null;
        }
        bjy com_tencent_mm_protocal_c_bjy = new bjy();
        com_tencent_mm_protocal_c_bjy.ujy = linkedList.size();
        com_tencent_mm_protocal_c_bjy.ujz = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            ark com_tencent_mm_protocal_c_ark = (ark) it.next();
            bjx com_tencent_mm_protocal_c_bjx = new bjx();
            com_tencent_mm_protocal_c_bjx.ufq = zb(com_tencent_mm_protocal_c_ark.tNy);
            com_tencent_mm_protocal_c_bjx.tVV = com_tencent_mm_protocal_c_ark.tVV;
            com_tencent_mm_protocal_c_bjy.ujz.add(com_tencent_mm_protocal_c_bjx);
        }
        return com_tencent_mm_protocal_c_bjy;
    }

    private static int zb(String str) {
        try {
            byte[] address = InetAddress.getByName(str).getAddress();
            if (address != null) {
                int i = 0;
                int i2 = 0;
                while (i < address.length) {
                    int i3 = (address[i] & 255) | (i2 << 8);
                    i++;
                    i2 = i3;
                }
                w.d("MicroMsg.IPCallUtil", "ipAddressStrToInt, ip: %s, result: %d", new Object[]{str, Integer.valueOf(i2)});
                return i2;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.IPCallUtil", e, "", new Object[0]);
        }
        return 0;
    }

    public static int aFx() {
        Context context = ab.getContext();
        if (am.is2G(context)) {
            return 1;
        }
        if (am.is3G(context)) {
            return 3;
        }
        if (am.is4G(context)) {
            return 5;
        }
        if (am.isWifi(context)) {
            return 4;
        }
        return 0;
    }

    public static String zc(String str) {
        return str.replace("-", "").replace(" ", "").replace("(", "").replace(")", "").trim();
    }

    public static String oz(int i) {
        Context context = ab.getContext();
        switch (i) {
            case 1:
                return context.getString(R.l.euw);
            case 2:
                return context.getString(R.l.euw);
            case 6:
                return context.getString(R.l.eus);
            case 7:
                return context.getString(R.l.eut);
            default:
                return context.getString(R.l.euw);
        }
    }

    public static CharSequence g(Context context, long j) {
        return DateFormat.format(context.getString(R.l.elE), j);
    }

    public static String an(Context context, String str) {
        int i = 0;
        String[] stringArray = context.getResources().getStringArray(R.c.aSq);
        List arrayList = new ArrayList();
        arrayList.add("");
        for (int i2 = i; i2 < stringArray.length; i2++) {
            arrayList.add(stringArray[i2]);
        }
        try {
            i = bg.getInt(str, 0);
        } catch (Exception e) {
        }
        if (i >= arrayList.size()) {
            return "";
        }
        return (String) arrayList.get(i);
    }

    public static String cv(long j) {
        Object obj = 1;
        Context context = ab.getContext();
        if ((cw(j) == 0 ? 1 : null) != null) {
            return new SimpleDateFormat("HH:mm", Locale.US).format(new Date(j));
        }
        if (cw(j) != -1) {
            obj = null;
        }
        if (obj != null) {
            return context.getString(R.l.etD);
        }
        return new SimpleDateFormat("MM/dd", Locale.US).format(new Date(j));
    }

    private static long cw(long j) {
        Calendar instance = Calendar.getInstance();
        long timeInMillis = instance.getTimeInMillis();
        instance.add(6, 1);
        long timeInMillis2 = instance.getTimeInMillis() - timeInMillis;
        return (j / timeInMillis2) - (Calendar.getInstance().getTimeInMillis() / timeInMillis2);
    }

    public static String cx(long j) {
        Context context = ab.getContext();
        if (((double) j) <= 60.0d) {
            return context.getString(R.l.etI, new Object[]{String.valueOf(j)});
        }
        int i = (int) (((double) j) / 60.0d);
        if ((((double) j) / 60.0d) - ((double) i) > 0.0d) {
            i++;
        }
        return context.getString(R.l.etH, new Object[]{String.valueOf(i)});
    }

    public static boolean cu(Context context) {
        int i;
        if (d.brk()) {
            i = R.l.esC;
        } else if (d.brl()) {
            i = R.l.esB;
        } else if (a.HD()) {
            i = R.l.esA;
        } else if (com.tencent.mm.n.a.tQ()) {
            i = R.l.esx;
        } else {
            boolean z;
            if (l.a.sBr == null || !l.a.sBr.bnI()) {
                z = false;
            } else {
                z = true;
            }
            if (z) {
                i = R.l.esA;
            } else {
                i = 0;
            }
        }
        if (i == 0) {
            return true;
        }
        g.h(context, i, R.l.dIO);
        return false;
    }

    public static void c(MMActivity mMActivity, String str) {
        ((ClipboardManager) mMActivity.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(null, str));
    }

    public static String aFy() {
        String string = ab.getContext().getSharedPreferences("IPCall_LastInputPref", 0).getString("IPCall_LastInputCountryCode", "");
        if (bg.mA(string)) {
            return a.aFv();
        }
        return string.replace("+", "");
    }

    public static adf aFz() {
        ap.yY();
        Object obj = com.tencent.mm.u.c.vr().get(com.tencent.mm.storage.w.a.uCO, null);
        if (obj != null) {
            adf com_tencent_mm_protocal_c_adf = new adf();
            try {
                com_tencent_mm_protocal_c_adf.aD(bg.PT(obj.toString()));
                w.i("MicroMsg.IPCallUtil", "[royle]parse success,Coupons:%s,Wording:%s,Title:%s,Desc:%s,ImgPath:%s,UrlPath:%s,Balance:%s,PVWording:%s,PackageMsg:%s", new Object[]{com_tencent_mm_protocal_c_adf.tIH, com_tencent_mm_protocal_c_adf.mQZ, com_tencent_mm_protocal_c_adf.fDC, com_tencent_mm_protocal_c_adf.msk, com_tencent_mm_protocal_c_adf.tII, com_tencent_mm_protocal_c_adf.tIJ, com_tencent_mm_protocal_c_adf.tIK, com_tencent_mm_protocal_c_adf.tIL, com_tencent_mm_protocal_c_adf.tIS});
                return com_tencent_mm_protocal_c_adf;
            } catch (IOException e) {
                w.i("MicroMsg.IPCallUtil", "[royle]parse exception:%s", new Object[]{e.getMessage()});
            }
        }
        return null;
    }
}
