package com.tencent.mm.pluginsdk.ui.tools;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.webkit.MimeTypeMap;
import com.tencent.mm.R;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.model.q;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.t;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import com.tencent.mm.ui.d;
import com.tencent.smtt.sdk.QbSdk;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.io.File;
import java.lang.ref.WeakReference;
import java.util.HashMap;

public final class a {
    private static Intent sUt;
    private static WeakReference<Activity> sUu;
    private static final HashMap<String, String> sUv;

    public enum a {
        NOT_INSTALL,
        INSTALL_BUT_NEED_UPDATE,
        INSTALL_BUT_NOT_SUPPORT,
        INSTALL_AND_SUPPORT
    }

    public static boolean a(Activity activity, String str, String str2, int i) {
        w.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            int i2;
            String Ni = Ni(str2);
            String Nh = Nh(Ni);
            if (!Nh.equals("")) {
                w.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", Nh);
                Intent en = en(Ni, str);
                en.setPackage(Nh);
                if (bg.j((Context) activity, en)) {
                    w.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(en);
                    return false;
                }
                w.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
                w.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            w.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", v(activity, Ni, str).name());
            if (v(activity, Ni, str) == a.INSTALL_AND_SUPPORT) {
                Intent ep = ep(str, str2);
                if (bg.j((Context) activity, ep)) {
                    ep.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    activity.startActivity(ep);
                    g.oUh.i(11168, Integer.valueOf(5), Integer.valueOf(i));
                    return false;
                }
                ep.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                Intent eo = eo(Ni, str);
                if (bg.j((Context) activity, eo)) {
                    activity.startActivity(eo);
                    g.oUh.i(11168, Integer.valueOf(5), Integer.valueOf(i));
                    w.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                } else {
                    w.e("MicroMsg.AppChooserIntentUtil", "Occur error, has bugs, status is install and support but not found support activity");
                    return true;
                }
            }
            if (!bg.mA(str2)) {
                ap.yY();
                Ni = (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
                if (!bg.mA(Ni) && Ni.contains(str2)) {
                    i2 = 1;
                    if (i2 != 0) {
                        return true;
                    }
                    b(activity, str, str2);
                    return false;
                }
            }
            i2 = 0;
            if (i2 != 0) {
                return true;
            }
            b(activity, str, str2);
            return false;
        }
        w.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
        return true;
    }

    public static void b(Activity activity, String str, String str2, int i) {
        boolean z = true;
        w.i("MicroMsg.AppChooserIntentUtil", "path:%s, isExisted:%b, size:%d", str, Boolean.valueOf(r0.exists()), Long.valueOf(new File(str).length()));
        if (new File(str).exists()) {
            boolean z2;
            boolean z3;
            Parcelable en;
            String Ni = Ni(str2);
            String Nh = Nh(Ni);
            if (!Nh.equals("")) {
                w.i("MicroMsg.AppChooserIntentUtil", "User exist always config, package is %s", Nh);
                Intent en2 = en(Ni, str);
                en2.setPackage(Nh);
                if (bg.j((Context) activity, en2)) {
                    w.i("MicroMsg.AppChooserIntentUtil", "Always package support mimeType");
                    activity.startActivity(en2);
                    return;
                }
                w.i("MicroMsg.AppChooserIntentUtil", "Always package do not support mimeType");
            }
            w.i("MicroMsg.AppChooserIntentUtil", "QQBrowser status is %s", v(activity, Ni, str).name());
            Object en3;
            switch (v(activity, Ni, str)) {
                case NOT_INSTALL:
                    z2 = false;
                    en3 = en(Ni, str);
                    z3 = true;
                    break;
                case INSTALL_BUT_NOT_SUPPORT:
                    z2 = false;
                    en3 = en(Ni, str);
                    z3 = false;
                    break;
                case INSTALL_BUT_NEED_UPDATE:
                    z2 = true;
                    en3 = en(Ni, str);
                    z3 = true;
                    break;
                case INSTALL_AND_SUPPORT:
                    Intent ep = ep(str, str2);
                    if (!bg.j((Context) activity, ep)) {
                        z2 = false;
                        en3 = en(Ni, str);
                        z3 = true;
                        break;
                    }
                    activity.startActivity(ep);
                    return;
                default:
                    z2 = false;
                    en = en(Ni, str);
                    z3 = true;
                    break;
            }
            String Ni2 = Ni(str2);
            Uri fromFile = Uri.fromFile(new File(str));
            Bundle bundle = new Bundle();
            bundle.putString("targeturl", fromFile.toString());
            bundle.putString("filepath", str);
            bundle.putString("fileext", str2);
            bundle.putParcelable("targetintent", en);
            Intent intent = new Intent();
            intent.putExtra(Columns.TYPE, 0);
            intent.putExtra("title", activity.getResources().getString(R.l.dWa));
            intent.putExtra("needupate", z2);
            Nh = "not_show_recommend_app";
            if (z3) {
                z = false;
            }
            intent.putExtra(Nh, z);
            intent.putExtra("mimetype", Ni2);
            intent.putExtra("targetintent", en);
            intent.putExtra("transferback", bundle);
            intent.putExtra("scene", i);
            b(activity, str, str2);
            sUt = intent;
            sUu = new WeakReference(activity);
            return;
        }
        w.e("MicroMsg.AppChooserIntentUtil", "Cannot open file not existed!");
    }

    private static void b(Activity activity, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("file_path", str);
        intent.putExtra("file_ext", str2);
        intent.setComponent(new ComponentName(d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE");
        activity.sendBroadcast(intent);
    }

    public static void aa(Intent intent) {
        boolean booleanExtra = intent.getBooleanExtra("MINIQB_OPEN_RET_VAL", false);
        intent.getStringExtra("file_path");
        Object stringExtra = intent.getStringExtra("file_ext");
        w.i("MicroMsg.AppChooserIntentUtil", "miniQB retVal:%b", Boolean.valueOf(booleanExtra));
        if (!ap.yQ() && ap.zb()) {
            ap.yY();
            Object obj = (String) c.vr().get(com.tencent.mm.storage.w.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, (Object) "");
            if (!booleanExtra) {
                obj = obj.replace(stringExtra, "");
            } else if (!obj.contains(stringExtra)) {
                obj = obj.concat(stringExtra);
            }
            ap.yY();
            c.vr().a(com.tencent.mm.storage.w.a.USERINFO_MINIQB_SUPPORT_FILE_TYPE_STRING_SYNC, obj);
            if (!(booleanExtra || sUt == null || sUu == null || sUu.get() == null)) {
                sUt.setClass((Context) sUu.get(), AppChooserUI.class);
                ((Activity) sUu.get()).startActivityForResult(sUt, 2);
            }
            sUt = null;
        }
    }

    public static void a(Activity activity, int i, int i2, Intent intent, boolean z, int i3, int i4, int i5) {
        if (i != 2) {
            return;
        }
        if (-1 == i2 && intent != null) {
            String stringExtra = intent.getStringExtra("selectpkg");
            Bundle bundleExtra = intent.getBundleExtra("transferback");
            Intent intent2 = (Intent) bundleExtra.getParcelable("targetintent");
            String string = bundleExtra.getString("filepath");
            String string2 = bundleExtra.getString("fileext");
            if (intent2 != null) {
                Intent ep;
                w.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI select package name %s and target intent is not null", stringExtra);
                if ("com.tencent.mtt".equals(stringExtra) && string != null) {
                    ep = ep(string, string2);
                    ep.addFlags(SQLiteGlobal.journalSizeLimit);
                    ep.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
                    ep.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
                    if (bg.j((Context) activity, ep)) {
                        w.i("MicroMsg.AppChooserIntentUtil", "user has installed new version of QQbrowser");
                        activity.startActivity(ep);
                        g.oUh.i(11168, Integer.valueOf(5), Integer.valueOf(i5));
                        return;
                    }
                }
                ep = new Intent(intent2);
                ep.setPackage(stringExtra);
                ep.addFlags(SQLiteGlobal.journalSizeLimit);
                if (bg.j((Context) activity, ep)) {
                    activity.startActivity(ep);
                    return;
                }
                w.e("MicroMsg.AppChooserIntentUtil", "Always Intent is not support mimetype");
                if (z) {
                    com.tencent.mm.ui.base.g.h(activity, i3, i4);
                    return;
                }
                return;
            }
            w.e("MicroMsg.AppChooserIntentUtil", "AppChooserUI target intent is null in handlerResultOfAppChooserUI");
            if (z) {
                com.tencent.mm.ui.base.g.h(activity, i3, i4);
            }
        } else if (4098 == i2) {
            w.e("MicroMsg.AppChooserIntentUtil", "Not Found App Support media type");
            if (z) {
                com.tencent.mm.ui.base.g.h(activity, i3, i4);
            }
        } else if (4097 == i2) {
            w.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is no choice");
            if (z) {
                com.tencent.mm.ui.base.g.h(activity, i3, i4);
            }
        } else {
            w.i("MicroMsg.AppChooserIntentUtil", "AppChooserUI result code is not ok or data is null");
        }
    }

    private static Intent en(String str, String str2) {
        Uri fromFile = Uri.fromFile(new File(str2));
        Intent intent = new Intent();
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(fromFile, str);
        return intent;
    }

    private static Intent eo(String str, String str2) {
        Intent intent = new Intent();
        intent.setPackage("com.tencent.mtt");
        intent.setAction("android.intent.action.VIEW");
        intent.setDataAndType(Uri.fromFile(new File(str2)), str);
        return intent;
    }

    private static Intent ep(String str, String str2) {
        Intent intent = new Intent("com.tencent.QQBrowser.action.sdk.document");
        File file = new File(str);
        intent.setPackage("com.tencent.mtt");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_ID, "com.tencent.mm");
        intent.putExtra(QbSdk.LOGIN_TYPE_KEY_PARTNER_CALL_POS, 4);
        intent.putExtra("key_reader_sdk_id", 1);
        intent.putExtra("key_reader_sdk_type", 0);
        intent.putExtra("key_reader_sdk_format", str2);
        intent.putExtra("key_reader_sdk_path", str);
        intent.setData(Uri.fromFile(file));
        return intent;
    }

    private static String Nh(String str) {
        int i = 274528;
        ap.yY();
        t vr = c.vr();
        if (str != null) {
            i = 274528 + str.hashCode();
        }
        return (String) vr.get(i, (Object) "");
    }

    private static a v(Context context, String str, String str2) {
        if (!q.du(context)) {
            return a.NOT_INSTALL;
        }
        if (bg.j(context, eo(str, str2))) {
            return a.INSTALL_AND_SUPPORT;
        }
        if (q.LU(str)) {
            return a.INSTALL_BUT_NEED_UPDATE;
        }
        return a.INSTALL_BUT_NOT_SUPPORT;
    }

    private static String Ni(String str) {
        String str2 = null;
        if (str != null && str.length() > 0) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
        }
        if (str2 == null || str2.length() == 0) {
            str2 = (String) sUv.get(str);
        }
        if (str2 != null && str2.length() != 0) {
            return str2;
        }
        w.w("MicroMsg.AppChooserIntentUtil", "getMimeType fail, not a built-in mimetype, use \"*/{fileext}\" instead");
        return "*/" + str;
    }

    static {
        HashMap hashMap = new HashMap();
        sUv = hashMap;
        hashMap.put("wps", "application/wps");
        sUv.put("ett", "application/ett");
        sUv.put("log", "application/log");
        sUv.put("wpt", "application/wpt");
        sUv.put("et", "application/et");
        sUv.put("ksdps", "application/ksdps");
        sUv.put("kset", "application/kset");
        sUv.put("kswps", "application/kswps");
    }
}
