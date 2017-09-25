package com.tencent.mm.modelsimple;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract.Settings;
import com.jg.EType;
import com.jg.JgMethodChecked;
import com.tencent.mm.modelfriend.m;
import com.tencent.mm.sdk.f.e;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.c;
import java.util.regex.Pattern;

public final class d {

    public interface a {
        void o(Bundle bundle);
    }

    public static int a(Context context, a aVar) {
        if (context == null) {
            w.e("MicroMsg.MMAccountManager", "context is null");
            return 0;
        }
        String IN = IN();
        if (bg.mA(IN)) {
            w.e("MicroMsg.MMAccountManager", "account username is null or nil");
            ap.yY();
            IN = (String) c.vr().get(6, (Object) "");
            if (bg.mA(IN)) {
                return 0;
            }
        }
        if (C(context, IN)) {
            return 3;
        }
        if (!com.tencent.mm.pluginsdk.i.a.aT(context, "android.permission.READ_CONTACTS")) {
            return 2;
        }
        try {
            AccountManager accountManager = AccountManager.get(context);
            Account account = new Account(IN, "com.tencent.mm.account");
            if (accountManager.addAccountExplicitly(account, "", null)) {
                ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                Bundle bundle = new Bundle();
                bundle.putString("authAccount", IN);
                bundle.putString("accountType", "com.tencent.mm.account");
                if (aVar != null) {
                    aVar.o(bundle);
                }
                return 1;
            }
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            w.e("MicroMsg.MMAccountManager", "exception in addAccountNoNeedBindMobile() " + e.getMessage());
        }
        if (aVar != null) {
            aVar.o(null);
        }
        return 2;
    }

    public static int a(Context context, String str, a aVar) {
        if (context == null) {
            w.e("MicroMsg.MMAccountManager", "activity is null");
            return 0;
        } else if (bg.mA(str)) {
            w.e("MicroMsg.MMAccountManager", "account username is null or nil");
            return 0;
        } else {
            String IN = IN();
            if (!bg.mA(IN)) {
                str = IN;
            }
            try {
                AccountManager accountManager = AccountManager.get(context);
                Account account = new Account(str, "com.tencent.mm.account");
                if (!com.tencent.mm.pluginsdk.i.a.aT(context, "android.permission.READ_CONTACTS")) {
                    return 2;
                }
                if (C(context, str)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    return 3;
                }
                A(context, null);
                if (accountManager.addAccountExplicitly(account, "", null)) {
                    ContentResolver.setSyncAutomatically(account, "com.android.contacts", true);
                    Bundle bundle = new Bundle();
                    bundle.putString("authAccount", str);
                    bundle.putString("accountType", "com.tencent.mm.account");
                    if (aVar != null) {
                        aVar.o(bundle);
                    }
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("account_name", str);
                    contentValues.put("account_type", "com.tencent.mm.account");
                    contentValues.put("should_sync", Integer.valueOf(1));
                    contentValues.put("ungrouped_visible", Integer.valueOf(1));
                    context.getContentResolver().insert(Settings.CONTENT_URI, contentValues);
                    return 1;
                }
                if (aVar != null) {
                    aVar.o(null);
                }
                return 2;
            } catch (Throwable e) {
                w.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
                w.e("MicroMsg.MMAccountManager", "exception in addAccount() " + e.getMessage());
            }
        }
    }

    public static void bc(Context context) {
        com.tencent.mm.bb.d.bGP();
        if (f.fvb == 0) {
            w.d("MicroMsg.MMAccountManager", "do not auto add account");
        } else if (f.fvb == 1) {
            if (m.Fl() == com.tencent.mm.modelfriend.m.a.SUCC) {
                w.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, m.Fn(), null));
                return;
            }
            w.i("MicroMsg.MMAccountManager", "the user not bind mobile or not aggreed to upload addressbook");
        } else if (f.fvb == 2) {
            w.d("MicroMsg.MMAccountManager", "auto add account result: " + a(context, null));
        }
    }

    public static boolean A(Context context, String str) {
        boolean mA = bg.mA(str);
        w.v("MicroMsg.MMAccountManager", "remove account : " + str);
        if (context == null) {
            w.e("MicroMsg.MMAccountManager", "null context");
            return false;
        }
        try {
            Account[] bi = bi(context);
            if (bi == null || bi.length == 0) {
                w.d("MicroMsg.MMAccountManager", "get account info is null or nil");
                return true;
            }
            AccountManager accountManager = AccountManager.get(context);
            for (Account account : bi) {
                if (mA) {
                    accountManager.removeAccount(account, null, null);
                } else if (account.name.equals(str)) {
                    accountManager.removeAccount(account, null, null);
                    w.i("MicroMsg.MMAccountManager", "remove account success: " + str);
                }
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            w.e("MicroMsg.MMAccountManager", "exception in removeAccount() " + e.getMessage());
            return false;
        }
    }

    @JgMethodChecked(author = 20, fComment = "checked", lastDate = "20140429", reviewer = 20, vComment = {EType.INTENTCHECK})
    public static boolean bd(Context context) {
        boolean z = false;
        if (context != null) {
            Intent intent = new Intent("com.tencent.mm.login.ACTION_LOGOUT");
            intent.putExtra("accountName", IN());
            intent.putExtra("accountType", "com.tencent.mm.account");
            z = A(context, IN());
            if (z) {
                context.sendBroadcast(intent);
            }
        }
        return z;
    }

    private static String IN() {
        if (ap.zb()) {
            String str = "";
            ap.yY();
            String str2 = (String) c.vr().get(4, null);
            if (bg.mA(str2)) {
                str2 = com.tencent.mm.u.m.xM();
                if (bg.mA(str2)) {
                    str2 = com.tencent.mm.u.m.xL();
                    if (bg.mA(str2) || x.QQ(str2)) {
                        str2 = str;
                    }
                }
            }
            return kz(str2);
        }
        w.e("MicroMsg.MMAccountManager", "getCurrentAccountName MMCore.acc Not Ready");
        return "";
    }

    public static void be(Context context) {
        if (bf(context)) {
            e.b(new b(context, bh(context)), "MMAccountManager_updateAllContact").start();
            return;
        }
        A(context, null);
        w.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static void B(Context context, String str) {
        if (bf(context)) {
            e.b(new b(context, bh(context), str), "MMAccountManager_deleteSpecifiedContact").start();
            return;
        }
        A(context, null);
        w.d("MicroMsg.MMAccountManager", "no account added or not current account");
    }

    public static boolean bf(Context context) {
        Account bh = bh(context);
        if (bh != null && bh.name.equals(IN())) {
            return true;
        }
        return false;
    }

    public static boolean bg(Context context) {
        if (!bf(context)) {
            w.e("MicroMsg.MMAccountManager", "no account added or not current account");
            return false;
        } else if (!com.tencent.mm.pluginsdk.i.a.aT(context, "android.permission.READ_CONTACTS")) {
            return false;
        } else {
            Account bh = bh(context);
            if (bh != null) {
                Bundle bundle = new Bundle();
                bundle.putBoolean("expedited", true);
                bundle.putBoolean("do_not_retry", true);
                ContentResolver.requestSync(bh, "com.android.contacts", bundle);
                return true;
            }
            w.e("MicroMsg.MMAccountManager", "no account added");
            return false;
        }
    }

    public static Account bh(Context context) {
        String IN = IN();
        if (bg.mA(IN)) {
            ap.yY();
            IN = (String) c.vr().get(6, (Object) "");
        }
        if (!bg.mA(IN)) {
            Account[] bi = bi(context);
            if (bi == null) {
                return null;
            }
            for (Account account : bi) {
                if (account.name.equals(IN)) {
                    return account;
                }
            }
        }
        return null;
    }

    private static Account[] bi(Context context) {
        try {
            return AccountManager.get(context).getAccountsByType("com.tencent.mm.account");
        } catch (Throwable e) {
            w.e("MicroMsg.MMAccountManager", "get all accounts failed");
            w.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
            return null;
        }
    }

    private static boolean C(Context context, String str) {
        Account[] bi = bi(context);
        if (bi == null || bi.length == 0) {
            return false;
        }
        for (Account account : bi) {
            if (account.name.equals(str)) {
                return true;
            }
        }
        return false;
    }

    private static Account[] D(Context context, String str) {
        Account[] accountArr = null;
        try {
            accountArr = AccountManager.get(context).getAccountsByType(str);
        } catch (Throwable e) {
            w.e("MicroMsg.MMAccountManager", "get all accounts failed");
            w.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
        }
        return accountArr;
    }

    public static String bj(Context context) {
        Account[] D = D(context, "com.google");
        String str = null;
        if (D != null && D.length > 0) {
            for (Account account : D) {
                str = account.name;
                if (!bg.mA(str) && bg.PK(str)) {
                    break;
                }
            }
        }
        return str;
    }

    private static String kz(String str) {
        try {
            str = Pattern.compile("[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#¥￥%……&*（）——+|{}【】‘；：”“’。，、？]").matcher(str).replaceAll("_").trim();
        } catch (Throwable e) {
            w.e("MicroMsg.MMAccountManager", "stringFilter failed, %s, %s", str, e.getMessage());
            w.printErrStackTrace("MicroMsg.MMAccountManager", e, "", new Object[0]);
        }
        return str;
    }
}
