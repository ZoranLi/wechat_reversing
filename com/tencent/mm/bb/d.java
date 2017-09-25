package com.tencent.mm.bb;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import com.tencent.mm.compatible.util.f;
import com.tencent.mm.pluginsdk.d.c;
import com.tencent.mm.pluginsdk.h;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.pluginsdk.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.am;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.b;
import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteGlobal;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class d {
    private static final Map<String, String> sYt;
    private static HashMap<String, c> sYu = new HashMap();
    private static final HashSet<String> sYv = new HashSet<String>() {
        {
            add(".ui.transmit.SelectConversationUI");
        }
    };

    static {
        Map hashMap = new HashMap();
        sYt = hashMap;
        hashMap.put("location", "talkroom");
        sYt.put("talkroom", "voip");
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent) {
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent == null ? new Intent() : intent;
                intent.setClassName(ab.getPackageName(), str2.startsWith(".") ? (ab.bIW() + ".plugin." + str) + str2 : str2);
                MMWizardActivity.z(context, intent);
            }
        }, new b() {
            public final void b(Exception exception) {
                w.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                w.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
            }
        });
    }

    public static void a(Context context, final String str, String str2, Intent intent, Intent intent2) {
        final Intent intent3 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final Intent intent4 = intent2;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent3 == null ? new Intent() : intent3;
                intent.setClassName(ab.getPackageName(), str4.startsWith(".") ? (ab.bIW() + ".plugin." + str3) + str4 : str4);
                MMWizardActivity.b(context2, intent, intent4);
            }
        }, new b() {
            public final void b(Exception exception) {
                w.e("MicroMsg.PluginHelper", "start wizard activity failed, plugin(%s) not loaded", str);
                w.e("MicroMsg.PluginHelper", "start wizard activity with exception:%s", exception);
            }
        });
    }

    public static void w(Context context, String str, String str2) {
        a(context, str, str2, null, true);
    }

    public static void b(Context context, String str, String str2, Intent intent) {
        if (!f.ep(21)) {
            try {
                if (context.getSharedPreferences(ab.bIX(), 0).getBoolean("settings_multi_webview", false) && ".ui.tools.WebViewUI".endsWith(str2)) {
                    w.i("MicroMsg.PluginHelper", "start multi webview!!!!!!!!!");
                    intent.addFlags(134217728);
                    intent.addFlags(SQLiteGlobal.journalSizeLimit);
                }
            } catch (Exception e) {
                w.e("MicroMsg.PluginHelper", "%s", e.getMessage());
            }
        }
        a(context, str, str2, intent, true);
    }

    public static void a(final Context context, final String str, final String str2, final Intent intent, boolean z) {
        w.d("MicroMsg.PluginHelper", "start activity, need try load plugin[%B]", Boolean.valueOf(z));
        a anonymousClass7 = new a() {
            public final void onDone() {
                w.d("MicroMsg.PluginHelper", "[DEBUG] onDone Load %s", str);
                try {
                    Intent intent = intent == null ? new Intent() : intent;
                    String str = str2.startsWith(".") ? (ab.bIW() + ".plugin." + str) + str2 : str2;
                    intent.setClassName(ab.getPackageName(), str);
                    Class.forName(str, false, context.getClassLoader());
                    if (context instanceof Activity) {
                        context.startActivity(intent);
                        return;
                    }
                    intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
                    context.startActivity(intent);
                } catch (ClassNotFoundException e) {
                    w.e("MicroMsg.PluginHelper", "Class Not Found when startActivity %s", e);
                }
            }
        };
        b anonymousClass8 = new b() {
            public final void b(Exception exception) {
                w.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                w.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
            }
        };
        if (z) {
            a(str, anonymousClass7, anonymousClass8);
        } else {
            anonymousClass7.onDone();
        }
    }

    public static void a(Context context, String str, Intent intent) {
        if (intent == null) {
            intent = new Intent();
        }
        String bIW = ab.bIW();
        if (str.startsWith(".")) {
            str = bIW + str;
        }
        intent.setClassName(ab.getPackageName(), str);
        if (context instanceof Activity) {
            context.startActivity(intent);
            return;
        }
        intent.addFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        context.startActivity(intent);
    }

    public static void b(Context context, String str, String str2, int i) {
        a(context, str, str2, null, i, true);
    }

    public static void b(Context context, String str, String str2, Intent intent, int i) {
        a(context, str, str2, intent, i, true);
    }

    public static void a(Context context, final String str, String str2, Intent intent, int i, boolean z) {
        w.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(z));
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Context context2 = context;
        final int i2 = i;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(ab.getPackageName(), str4.startsWith(".") ? (ab.bIW() + ".plugin." + str3) + str4 : str4);
                if (context2 instanceof Activity) {
                    ((Activity) context2).startActivityForResult(intent, i2);
                    d.b(context2, str4, intent);
                    return;
                }
                w.f("MicroMsg.PluginHelper", "context not activity, skipped");
            }
        }, new b() {
            public final void b(Exception exception) {
                w.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                w.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
            }
        });
    }

    public static void a(Fragment fragment, final String str, String str2, Intent intent, int i) {
        w.d("MicroMsg.PluginHelper", "start activity for result, need try load plugin[%B]", Boolean.valueOf(true));
        final Intent intent2 = intent;
        final String str3 = str;
        final String str4 = str2;
        final Fragment fragment2 = fragment;
        final int i2 = i;
        a(str, new a() {
            public final void onDone() {
                Intent intent = intent2 == null ? new Intent() : intent2;
                intent.setClassName(ab.getPackageName(), str4.startsWith(".") ? (ab.bIW() + ".plugin." + str3) + str4 : str4);
                fragment2.startActivityForResult(intent, i2);
                d.b(fragment2.aG(), str4, intent2);
            }
        }, new b() {
            public final void b(Exception exception) {
                w.f("MicroMsg.PluginHelper", "start activity failed, plugin(%s) not loaded", str);
                w.e("MicroMsg.PluginHelper", "start activity failed,%s", exception);
            }
        });
    }

    public static void b(Context context, String str, Intent intent) {
        if (intent != null && sYv.contains(str)) {
            intent.putExtra("animation_pop_in", true);
            b.A(context, intent);
        }
    }

    public static void a(Context context, String str, Intent intent, int i) {
        intent.setClassName(ab.getPackageName(), str.startsWith(".") ? ab.bIW() + str : str);
        if (context instanceof Activity) {
            ((Activity) context).startActivityForResult(intent, i);
            b(context, str, intent);
            return;
        }
        w.f("MicroMsg.PluginHelper", "context not activity, skipped");
    }

    public static void a(MMActivity mMActivity, String str, Intent intent, int i, a aVar) {
        String bIW = ab.bIW();
        if (str.startsWith(".")) {
            bIW = bIW + str;
        } else {
            bIW = str;
        }
        intent.setClassName(ab.getPackageName(), bIW);
        mMActivity.a(aVar, intent, i);
        b(mMActivity, str, intent);
    }

    public static void a(Fragment fragment, String str, Intent intent, int i) {
        intent.setClassName(ab.getPackageName(), str.startsWith(".") ? ab.bIW() + str : str);
        if (fragment instanceof Fragment) {
            fragment.startActivityForResult(intent, i);
            b(fragment.aG(), str, intent);
            return;
        }
        w.f("MicroMsg.PluginHelper", "fragment not Fragment, skipped");
    }

    public static void o(String str, Map<String, am> map) {
        w.d("MicroMsg.PluginHelper", "-->createSubCore: %s", str);
        c NA = NA(str);
        if (NA == null) {
            w.f("MicroMsg.PluginHelper", "register subcore failed, plugin=%s", str);
            return;
        }
        am createSubCore = NA.createSubCore();
        if (createSubCore == null) {
            w.w("MicroMsg.PluginHelper", "create sub core failed, plugin=%s", str);
            return;
        }
        if (map != null) {
            map.put("plugin." + str, createSubCore);
        }
        w.d("MicroMsg.PluginHelper", "<--createSubCore successfully: %s", str);
    }

    public static void a(String str, i iVar, h hVar) {
        w.d("MicroMsg.PluginHelper", "--> registerApplication: %s", str);
        c NA = NA(str);
        if (NA == null) {
            w.f("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            return;
        }
        k createApplication = NA.createApplication();
        if (createApplication == null) {
            w.w("MicroMsg.PluginHelper", "register application failed, plugin=%s", str);
            return;
        }
        createApplication.a(hVar);
        createApplication.a(iVar);
        w.d("MicroMsg.PluginHelper", "<-- registerApplication successfully: %s", str);
    }

    public static com.tencent.mm.pluginsdk.d.a N(Context context, String str) {
        return x(context, str, null);
    }

    public static com.tencent.mm.pluginsdk.d.a x(Context context, String str, String str2) {
        c NA = NA(str);
        if (NA == null) {
            w.f("MicroMsg.PluginHelper", "create contact widget failed, plugin=%s, type=%s", str, str2);
            return null;
        }
        com.tencent.mm.pluginsdk.d.b contactWidgetFactory = NA.getContactWidgetFactory();
        if (contactWidgetFactory != null) {
            return contactWidgetFactory.N(context, str2);
        }
        w.f("MicroMsg.PluginHelper", "create contact widget factory failed, plugin=%s, type=%s", str, str2);
        return null;
    }

    public static boolean bGP() {
        return false;
    }

    public static synchronized boolean Jt(String str) {
        boolean z;
        synchronized (d.class) {
            z = sYu.get(str) != null;
        }
        return z;
    }

    private static synchronized c NA(String str) {
        c NB;
        synchronized (d.class) {
            try {
                NB = NB(str);
            } catch (ClassNotFoundException e) {
                w.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s, e:%s", str, e.toString());
                NB = null;
                return NB;
            } catch (InstantiationException e2) {
                w.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e2.toString());
                NB = null;
                return NB;
            } catch (IllegalAccessException e3) {
                w.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e3.toString());
                NB = null;
                return NB;
            }
        }
        return NB;
    }

    public static synchronized c a(String str, a aVar, b bVar) {
        c cVar;
        synchronized (d.class) {
            if (((String) sYt.get(str)) != null) {
                w.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) sYt.get(str));
            }
            cVar = (c) sYu.get(str);
            if (cVar != null) {
                aVar.onDone();
            } else {
                try {
                    cVar = NB(str);
                    if (cVar != null) {
                        aVar.onDone();
                    }
                } catch (Exception e) {
                    try {
                        cVar = NB(str);
                        if (cVar != null) {
                            aVar.onDone();
                        }
                    } catch (ClassNotFoundException e2) {
                        w.f("MicroMsg.PluginHelper", "plugin load failed ClassNotFoundException , plugin=%s ,e:%s", str, e2.toString());
                        w.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.b(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (InstantiationException e3) {
                        w.f("MicroMsg.PluginHelper", "plugin load failed InstantiationException , plugin=%s, e:%s", str, e3.toString());
                        w.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.b(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    } catch (IllegalAccessException e4) {
                        w.f("MicroMsg.PluginHelper", "plugin load failed IllegalAccessException , plugin=%s, e:%s", str, e4.toString());
                        w.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                        bVar.b(new IllegalArgumentException("Load Plugin Faild"));
                        cVar = null;
                        return cVar;
                    }
                }
            }
        }
        return cVar;
    }

    private static c NB(String str) {
        c cVar = (c) sYu.get(str);
        if (cVar != null) {
            return cVar;
        }
        cVar = (c) ab.getContext().getClassLoader().loadClass(ab.bIW() + ".plugin." + str + ".Plugin").newInstance();
        sYu.put(str, cVar);
        return cVar;
    }

    public static synchronized Class<?> es(String str, String str2) {
        Class<?> loadClass;
        synchronized (d.class) {
            if (((String) sYt.get(str)) != null) {
                w.d("MicroMsg.PluginHelper", "load plugin with mapping %s -> %s", str, (String) sYt.get(str));
            }
            if (NC(str)) {
                String str3 = ab.bIW() + ".plugin." + str;
                if (str2.startsWith(".")) {
                    str2 = str3 + str2;
                }
                try {
                    loadClass = ab.getContext().getClassLoader().loadClass(str2);
                } catch (Exception e) {
                    w.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                    loadClass = null;
                }
            } else {
                w.f("MicroMsg.PluginHelper", "plugin load failed, plugin=%s", str);
                loadClass = null;
            }
        }
        return loadClass;
    }

    public static synchronized boolean NC(String str) {
        boolean z;
        synchronized (d.class) {
            z = NA(str) != null;
        }
        return z;
    }
}
