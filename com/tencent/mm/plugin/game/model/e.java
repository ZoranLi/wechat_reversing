package com.tencent.mm.plugin.game.model;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.widget.Toast;
import com.tencent.mm.R;
import com.tencent.mm.bk.a;
import com.tencent.mm.opensdk.modelmsg.WXAppExtendObject;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import com.tencent.mm.plugin.game.ui.GameRegionPreference;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.pluginsdk.model.app.f;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.pluginsdk.model.app.g.c;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.sdk.platformtools.w;
import java.io.InputStream;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public final class e {
    public static LinkedList<f> aAB() {
        w.d("MicroMsg.GameCenterLogic", "getShowInGameCenterGames");
        LinkedList<f> linkedList = new LinkedList();
        linkedList.addAll(SubCoreGameCenter.aBH().mox);
        Collection linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            int i;
            f fVar = (f) it.next();
            if (fVar != null) {
                w.i("MicroMsg.GameCenterLogic", "appinfo:[%s], appinfo flag:[%d]", new Object[]{fVar.field_appId, Integer.valueOf(fVar.field_appInfoFlag)});
                if ((fVar.field_appInfoFlag & 4) > 0) {
                    i = 1;
                    if (i == 0) {
                        w.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                        linkedList2.add(fVar);
                    }
                }
            }
            i = 0;
            if (i == 0) {
                w.i("MicroMsg.GameCenterLogic", "app should not show in gamecenter:[%s]", new Object[]{fVar.field_appName});
                linkedList2.add(fVar);
            }
        }
        if (linkedList2.size() > 0) {
            linkedList.removeAll(linkedList2);
        }
        return linkedList;
    }

    public static LinkedList<String> aAC() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(SubCoreGameCenter.aBH().mow);
        return linkedList;
    }

    public static void V(Context context, final String str) {
        a(context, str, null, "WX_GameCenter", new c() {
            public final void ex(boolean z) {
                if (z) {
                    SubCoreGameCenter.aBE();
                    w.b(str, 0, 0, null, null);
                }
            }
        });
    }

    public static void a(final Context context, String str, String str2, String str3, final c cVar) {
        if (bg.mA(str)) {
            w.e("MicroMsg.GameCenterLogic", "null or nil appid");
            if (cVar != null) {
                cVar.ex(false);
            }
        }
        final f aJ = g.aJ(str, true);
        if (aJ == null || bg.mA(aJ.field_appId)) {
            w.e("MicroMsg.GameCenterLogic", "appinfo is null or appid is null");
            if (cVar != null) {
                cVar.ex(false);
            }
        } else if (p.b(context, aJ)) {
            final WXMediaMessage wXMediaMessage = new WXMediaMessage(new WXAppExtendObject());
            wXMediaMessage.sdkVer = 620757000;
            wXMediaMessage.messageAction = str2;
            wXMediaMessage.messageExt = str3;
            w.d("MicroMsg.GameCenterLogic", "launch game app from wx: appid: [%s], appname:[%s], openid:[%s]", new Object[]{aJ.field_appId, aJ.field_appName, aJ.field_openId});
            if (bg.mA(aJ.field_openId)) {
                w.i("MicroMsg.GameCenterLogic", "open id is null or nil, try to get from server:[%s]", new Object[]{aJ.field_appName});
                an.aRs().Jl(aJ.field_appId);
            }
            a.post(new Runnable() {
                public final void run() {
                    g.a(context, aJ.field_packageName, wXMediaMessage, aJ.field_appId, aJ.field_openId, 1, cVar, null);
                }
            });
        } else {
            w.e("MicroMsg.GameCenterLogic", "The app %s signature is incorrect.", new Object[]{aJ.field_appName});
            Toast.makeText(context, context.getString(R.l.eoN, new Object[]{g.a(context, aJ, null)}), 1).show();
            if (cVar != null) {
                cVar.ex(false);
            }
        }
    }

    public static String aAD() {
        String bJW = bg.bJW();
        if (bg.mA(bJW)) {
            bJW = "CN";
        }
        return bJW.toUpperCase();
    }

    public static GameRegionPreference.a cg(Context context) {
        Object ci = ci(context);
        if (bg.mA(ci)) {
            ci = aAD();
        }
        return (GameRegionPreference.a) a.mGh.aCg().get(ci);
    }

    public static String a(GameRegionPreference.a aVar) {
        StringBuffer stringBuffer = new StringBuffer();
        if (aVar != null) {
            String mz = bg.mz(v.bIN());
            if ("zh_CN".equalsIgnoreCase(mz)) {
                stringBuffer.append(aVar.mEg);
            } else if ("zh_TW".equalsIgnoreCase(mz) || "zh_HK".equalsIgnoreCase(mz)) {
                stringBuffer.append(aVar.mEh);
            } else {
                stringBuffer.append(aVar.mEi);
            }
        }
        return stringBuffer.toString();
    }

    public static String xO(String str) {
        String str2;
        InputStream inputStream = null;
        String str3 = "";
        try {
            inputStream = ab.getContext().getAssets().open("game_region_default.txt");
            byte[] bArr = new byte[inputStream.available()];
            inputStream.read(bArr);
            str2 = new String(bArr);
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e) {
                    w.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bg.g(e)});
                }
            }
        } catch (Throwable e2) {
            w.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bg.g(e2)});
            if (inputStream != null) {
                try {
                    inputStream.close();
                    str2 = str3;
                } catch (Throwable e22) {
                    w.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bg.g(e22)});
                    str2 = str3;
                }
            } else {
                str2 = str3;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (Throwable e3) {
                    w.e("MicroMsg.GameCenterLogic", "exception:%s", new Object[]{bg.g(e3)});
                }
            }
        }
        String[] split = str2.trim().split("\\|");
        if (split.length < 3) {
            w.e("MicroMsg.GameCenterLogic", "this region default title has problem %s", new Object[]{str2});
            return "";
        } else if ("zh_CN".equalsIgnoreCase(str)) {
            return split[0];
        } else {
            if ("zh_TW".equalsIgnoreCase(str) || "zh_HK".equalsIgnoreCase(str)) {
                return split[1];
            }
            return split[2];
        }
    }

    public static void W(Context context, String str) {
        int i = 0;
        String valueOf = String.valueOf(System.currentTimeMillis() / 1000);
        SharedPreferences sharedPreferences = context.getSharedPreferences("game_center_pref", 0);
        String string = sharedPreferences.getString("download_app_id_time_map", "");
        if (bg.mA(string)) {
            sharedPreferences.edit().putString("download_app_id_time_map", str + "-" + valueOf).commit();
        } else if (string.contains(str)) {
            String str2 = new String();
            String[] split = string.split(",");
            while (i < split.length) {
                string = split[i];
                if (string.contains(str)) {
                    string = str + "-" + valueOf;
                }
                if (i == split.length - 1) {
                    str2 = str2 + string;
                } else {
                    str2 = str2 + string + ",";
                }
                i++;
            }
            sharedPreferences.edit().putString("download_app_id_time_map", str2).apply();
        } else {
            sharedPreferences.edit().putString("download_app_id_time_map", string + "," + str + "-" + valueOf).apply();
        }
    }

    public static Set<String> ch(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getStringSet("show_download_gift_tips", new HashSet());
    }

    public static ShapeDrawable bJ(int i, int i2) {
        ShapeDrawable shapeDrawable = new ShapeDrawable(new RoundRectShape(new float[]{(float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2, (float) i2}, null, null));
        shapeDrawable.getPaint().setColor(i);
        return shapeDrawable;
    }

    public static int aAE() {
        com.tencent.mm.plugin.game.c.v aAG = g.aAF().aAG();
        return aAG != null ? aAG.mtm : 0;
    }

    public static String ci(Context context) {
        return context.getSharedPreferences("game_center_pref", 0).getString("game_region_code", "");
    }

    public static void X(Context context, String str) {
        context.getSharedPreferences("game_center_pref", 0).edit().putString("game_region_code", str).commit();
    }
}
