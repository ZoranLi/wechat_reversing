package com.tencent.mm.console;

import android.app.Activity;
import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Debug;
import android.os.Debug.MemoryInfo;
import android.os.Looper;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Base64;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.R;
import com.tencent.mm.app.WorkerProfile;
import com.tencent.mm.console.a.a;
import com.tencent.mm.console.a.c;
import com.tencent.mm.console.a.d;
import com.tencent.mm.console.a.e;
import com.tencent.mm.console.a.f;
import com.tencent.mm.console.a.g;
import com.tencent.mm.console.a.h;
import com.tencent.mm.console.a.i;
import com.tencent.mm.console.a.j;
import com.tencent.mm.e.a.bb;
import com.tencent.mm.e.a.bh;
import com.tencent.mm.e.a.bj;
import com.tencent.mm.e.a.bk;
import com.tencent.mm.e.a.bz;
import com.tencent.mm.e.a.cd;
import com.tencent.mm.e.a.cf;
import com.tencent.mm.e.a.cg;
import com.tencent.mm.e.a.fi;
import com.tencent.mm.e.a.lj;
import com.tencent.mm.e.a.oo;
import com.tencent.mm.e.a.or;
import com.tencent.mm.e.a.pc;
import com.tencent.mm.e.a.ph;
import com.tencent.mm.e.a.ss;
import com.tencent.mm.e.a.st;
import com.tencent.mm.e.a.y;
import com.tencent.mm.e.b.ce;
import com.tencent.mm.kernel.k;
import com.tencent.mm.modelmulti.t;
import com.tencent.mm.modelstat.WatchDogPushReceiver;
import com.tencent.mm.platformtools.SpellMap;
import com.tencent.mm.platformtools.r;
import com.tencent.mm.platformtools.u;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.pluginsdk.l.z;
import com.tencent.mm.pluginsdk.model.app.an;
import com.tencent.mm.protocal.ac;
import com.tencent.mm.protocal.c.ana;
import com.tencent.mm.protocal.c.anb;
import com.tencent.mm.protocal.c.bu;
import com.tencent.mm.sdk.platformtools.MMBitmapFactory;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.af;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.am;
import com.tencent.mm.sdk.platformtools.av;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.p;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.ba;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.s;
import com.tencent.mm.storage.w;
import com.tencent.mm.u.ad;
import com.tencent.mm.u.ao;
import com.tencent.mm.u.ap;
import com.tencent.mm.u.aw;
import com.tencent.mm.u.ax;
import com.tencent.mm.u.ay;
import com.tencent.mm.u.bf;
import com.tencent.mm.u.m;
import com.tencent.mm.u.n;
import com.tencent.mm.ui.LauncherUI;
import com.tencent.mm.ui.MMAppMgr;
import com.tencent.mm.ui.chatting.En_5b8fbb1e;
import com.tencent.mm.ui.chatting.ag;
import com.tencent.smtt.sdk.WebView;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.wcdb.FileUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.lang.Thread.State;
import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import junit.framework.Assert;

public final class b {
    static {
        com.tencent.mm.console.a.b.init();
        g.init();
        h.init();
        e.init();
        c.init();
        d.init();
        a.init();
        j.init();
        f.init();
        i.init();
    }

    private static int dK(String str) {
        if (!str.startsWith("//") || str.length() <= 2) {
            return 0;
        }
        int indexOf = str.indexOf(" ");
        if (indexOf == -1) {
            indexOf = str.length();
        }
        try {
            indexOf = bg.getInt(str.substring(2, indexOf), 0);
            int i = com.tencent.mm.protocal.d.sYN % 256;
            if (i == 0 || indexOf < i || indexOf % i != 0) {
                return 0;
            }
            return indexOf / i;
        } catch (Exception e) {
            return 0;
        }
    }

    private static String dL(String str) {
        int indexOf = str.indexOf(" ");
        if (indexOf < 0) {
            return "";
        }
        return str.substring(indexOf).trim();
    }

    public static boolean v(final Context context, final String str) {
        if (!str.startsWith("//")) {
            return false;
        }
        if (com.tencent.mm.pluginsdk.b.b.aO(context, str)) {
            return true;
        }
        if (str.startsWith("//clearWXSNSDB")) {
            com.tencent.mm.sdk.b.a.urY.m(new oo());
            return true;
        } else if (str.startsWith("//verifytokenerror")) {
            r.ijQ = true;
            return true;
        } else if (str.equalsIgnoreCase("//ftsmsbiz")) {
            anb Iq = com.tencent.mm.as.f.Iq();
            r1 = new StringBuilder();
            Iterator it = Iq.jNe.iterator();
            while (it.hasNext()) {
                ana com_tencent_mm_protocal_c_ana = (ana) it.next();
                r1.append(String.format("%s | %.2f | %s", new Object[]{n.eK(com_tencent_mm_protocal_c_ana.tgG), Double.valueOf(com_tencent_mm_protocal_c_ana.tRF), o.Z("yyyy-MM-dd HH:mm", com_tencent_mm_protocal_c_ana.tRG / 1000)}));
                r1.append("\n");
            }
            r0 = new TextView(context);
            r0.setText(r1.toString());
            r0.setGravity(19);
            r0.setTextSize(1, 10.0f);
            r0.setLayoutParams(new LayoutParams(-1, -2));
            r0.setTextColor(-16711936);
            r0.setTypeface(Typeface.MONOSPACE);
            r1 = context.getResources().getDimensionPixelSize(R.f.aXt);
            r0.setPadding(r1, r1, r1, r1);
            com.tencent.mm.ui.base.g.a(context, null, r0, null);
            return true;
        } else if (str.startsWith("//wxafts")) {
            r0 = new st();
            r0.gaI.gaJ = str;
            com.tencent.mm.sdk.b.a.urY.m(r0);
            return true;
        } else {
            if (com.tencent.mm.sdk.a.b.bIu()) {
                if (str.startsWith("//launchapp clear")) {
                    com.tencent.mm.kernel.h.vI().vr().a(w.a.USERINFO_LAUNCH_APP_NOT_ASK_PKG_STRING, (Object) "");
                    return true;
                } else if (str.startsWith("//setsupportwxcode")) {
                    com.tencent.mm.kernel.h.vI().vr().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(true));
                    return true;
                } else if (str.startsWith("//setnotsupportwxcode")) {
                    com.tencent.mm.kernel.h.vI().vr().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//resetsupportwxcode")) {
                    com.tencent.mm.kernel.h.vI().vr().a(w.a.USERINFO_SET_SUPPORT_WX_CODE_BOOLEAN, null);
                    return true;
                }
            }
            Intent intent;
            if (str.startsWith("//testsightwidget")) {
                intent = new Intent();
                intent.putExtra("KSightPath", "/mnt/sdcard/tencent/tempvideo4.mp4");
                intent.putExtra("KSightThumbPath", "");
                intent.putExtra("sight_md5", com.tencent.mm.a.g.aV("/mnt/sdcard/tencent/tempvideo4.mp4"));
                intent.putExtra("KSnsPostManu", true);
                intent.putExtra("KTouchCameraTime", bg.Ny());
                intent.putExtra("Ksnsupload_type", 14);
                com.tencent.mm.bb.d.b(context, "sns", ".ui.En_c4f742e5", intent);
                return true;
            }
            if (str.startsWith("//ftstemplatetest")) {
                r0 = new bb();
                r0.fEA.fEB = 27;
                r0.fEA.fEB = 1;
                r0.fEA.filePath = "/sdcard/fts_template.zip";
                com.tencent.mm.sdk.b.a.urY.m(r0);
            }
            if (str.startsWith("//sightforward")) {
                intent = new Intent();
                intent.setClassName(context, "com.tencent.mm.ui.transmit.SightForwardUI");
                context.startActivity(intent);
                return true;
            } else if (str.startsWith("//uplog")) {
                r0 = "weixin";
                if (ap.zb()) {
                    r0 = m.xL();
                }
                r2 = str.split(" ");
                r1 = 0;
                if (r2 != null) {
                    if (r2.length > 1) {
                        r1 = bg.getInt(r2[1], 0);
                    }
                    if (r2.length > 2) {
                        r0 = r2[2];
                    }
                }
                ap.vd().d(new com.tencent.mm.u.bb(new com.tencent.mm.u.bb.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        ap.vd().a(1, "", 0, false);
                        com.tencent.mm.sdk.platformtools.w.bIP();
                        ap.vd().a(2, r0, r1, ap.zb());
                    }
                }));
                context.getString(R.l.dIO);
                final ProgressDialog a = com.tencent.mm.ui.base.g.a(context, context.getString(R.l.fnX), false, null);
                ap.a(new ad() {
                    public final void ey(int i) {
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "ipxx progress:%d", Integer.valueOf(i));
                        if (i < 0) {
                            ap.a(null);
                            a.dismiss();
                            com.tencent.mm.ui.base.g.h(context, R.l.eZf, R.l.dIO);
                        } else if (i >= 100) {
                            ap.a(null);
                            a.dismiss();
                            com.tencent.mm.ui.base.g.h(context, R.l.eZj, R.l.dIO);
                        } else {
                            a.setMessage(context.getString(R.l.eZg) + i + "%");
                        }
                    }
                });
                return true;
            } else if (str.startsWith("//upcrash")) {
                r0 = "weixin";
                if (ap.zb()) {
                    r0 = m.xL();
                }
                r2 = str.split(" ");
                r1 = 0;
                if (r2 != null) {
                    if (r2.length > 1) {
                        r1 = bg.getInt(r2[1], 0);
                    }
                    if (r2.length > 2) {
                        r0 = r2[2];
                    }
                }
                ap.vd().d(new com.tencent.mm.u.bb(new com.tencent.mm.u.bb.a() {
                    public final void a(com.tencent.mm.network.e eVar) {
                        ap.vd().a(3, r0, r1, ap.zb());
                    }
                }));
                return true;
            } else if (str.startsWith("//switchnotificationstatus")) {
                com.tencent.mm.i.f.aI(!com.tencent.mm.i.a.sk());
                return true;
            } else if (str.startsWith("//fixError0831")) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "fixError0831");
                com.tencent.mm.sdk.b.a.urY.m(new bh());
                return true;
            } else if (str.startsWith("//cleanpaycn")) {
                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "cleanpaycn");
                com.tencent.mm.sdk.b.a.urY.m(new bk());
                return true;
            } else if (str.startsWith("//busiluck ")) {
                r0 = "weixin://openNativeUrl/weixinHB/startreceivebizhbrequest?sendid=" + str.replace("//busiluck ", "");
                r1 = new Intent();
                r1.putExtra("key_way", 5);
                r1.putExtra("key_native_url", r0);
                com.tencent.mm.bb.d.b(context, "luckymoney", ".ui.LuckyMoneyBusiReceiveUI", r1);
                return true;
            } else if (str.startsWith("//testsoter")) {
                intent = new Intent();
                intent.setClassName(ab.getPackageName(), "com.tencent.mm.plugin.soter.ui.SoterTestUI");
                context.startActivity(intent);
                return true;
            } else if (str.startsWith("//facevideo")) {
                r0 = str.split(" ");
                if (r0.length == 3) {
                    ao.hlW.L("imgType", r0[1]);
                    ao.hlW.L("depth", r0[2]);
                }
                return true;
            } else if (str.startsWith("//alpha")) {
                r0 = str.split(" ");
                if (r0.length == 2) {
                    ao.hlW.L("alpha_duration", r0[1]);
                }
                return true;
            } else if (str.startsWith("//rectwidth")) {
                r0 = str.split(" ");
                if (r0.length == 2) {
                    ao.hlW.L("rect_width", r0[1]);
                }
                return true;
            } else if (str.startsWith("//newyearsw ")) {
                ap.yY();
                r0 = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(0))).intValue() ^ 1;
                ap.yY();
                com.tencent.mm.u.c.vr().a(w.a.USERINFO_LUCKY_MONEY_NEWYEAR_LOCAL_SWITCH_INT, Integer.valueOf(r0));
                return true;
            } else if (str.startsWith("//commitxlog")) {
                ap.vd().a(1, "", 0, false);
                com.tencent.mm.sdk.platformtools.w.bIP();
                return true;
            } else if (str.startsWith("//netstatus")) {
                r1 = am.ed(ab.getContext());
                com.tencent.mm.ui.base.g.a(context, r1, "netstatus", context.getString(R.l.fcd), context.getString(R.l.dXi), new OnClickListener() {
                    public final void onClick(DialogInterface dialogInterface, int i) {
                        ((ClipboardManager) context.getSystemService("clipboard")).setText(r1);
                    }
                }, null);
                return true;
            } else {
                long j;
                if (str.startsWith("//scaninterval ")) {
                    j = -1;
                    try {
                        j = bg.getLong(str.split(" ")[1], -1);
                    } catch (Exception e) {
                    }
                    if (j > 0) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_WECHAT_FILE_SCAN_INTERVAL_LONG, Long.valueOf(j));
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summerclean reset scaninterval[%d]", Long.valueOf(j));
                        return true;
                    }
                }
                if (str.startsWith("//scanwait ")) {
                    j = -1;
                    try {
                        j = bg.getLong(str.split(" ")[1], -1);
                    } catch (Exception e2) {
                    }
                    if (j > 0) {
                        ap.yY();
                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_WECHAT_FILE_SCAN_WAIT_TIME_LONG, Long.valueOf(j));
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summerclean reset scanwait[%d]", Long.valueOf(j));
                        return true;
                    }
                }
                if (str.equalsIgnoreCase("//delayquery")) {
                    r.ijT = !r.ijT;
                    return true;
                } else if (str.equalsIgnoreCase("//swipe")) {
                    r0 = ab.bIY();
                    r0.edit().putBoolean("settings_support_swipe", !r0.getBoolean("settings_support_swipe", true)).commit();
                    return true;
                } else if (str.equalsIgnoreCase("//multiwebview")) {
                    r0 = LauncherUI.bPI().getSharedPreferences(ab.bIX(), 0);
                    r1 = r0.getBoolean("settings_multi_webview", false);
                    if (r1) {
                        r0.edit().putBoolean("settings_multi_webview", !r1).commit();
                    }
                    return true;
                } else if (str.equalsIgnoreCase("//sightinfo")) {
                    ap.yY();
                    r0 = ((Boolean) com.tencent.mm.u.c.vr().get(344065, Boolean.valueOf(false))).booleanValue();
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(344065, Boolean.valueOf(!r0));
                    ap.yY();
                    com.tencent.mm.u.c.vr().jY(true);
                    return true;
                } else if (str.startsWith("//sighttest")) {
                    r0 = bg.PY(str.replace("//sighttest ", ""));
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(344066, Integer.valueOf(r0));
                    ap.yY();
                    com.tencent.mm.u.c.vr().jY(true);
                    return true;
                } else if (str.startsWith("//wxcamera")) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "set param %d", Integer.valueOf(bg.PY(str.replace("//wxcamera ", ""))));
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_LOCAL_SIGHT_SETTING_PRESET_INT_SYNC, Integer.valueOf(r0));
                    return true;
                } else if (str.startsWith("//printcrash")) {
                    r0 = str.replace("//printcrash ", "");
                    r1 = new TextView(context);
                    r1.setText(ev(bg.getInt(r0, 0)));
                    r1.setGravity(19);
                    r1.setTextSize(1, 8.0f);
                    r1.setLayoutParams(new LayoutParams(-1, -2));
                    r1.setTextColor(-16711936);
                    r1.setTypeface(Typeface.MONOSPACE);
                    r0 = context.getResources().getDimensionPixelSize(R.f.aXV);
                    r1.setPadding(r0, r0, r0, r0);
                    r1.setMovementMethod(ScrollingMovementMethod.getInstance());
                    com.tencent.mm.ui.base.g.a(context, null, r1, null);
                    return true;
                } else if (str.startsWith("//printleak")) {
                    r0 = new TextView(context);
                    r0.setText(com.tencent.mm.compatible.b.e.qW());
                    r0.setGravity(19);
                    r0.setTextSize(1, 8.0f);
                    r0.setLayoutParams(new LayoutParams(-1, -2));
                    r0.setTextColor(-16711936);
                    r0.setTypeface(Typeface.MONOSPACE);
                    r1 = context.getResources().getDimensionPixelSize(R.f.aXV);
                    r0.setPadding(r1, r1, r1, r1);
                    r0.setMovementMethod(ScrollingMovementMethod.getInstance());
                    com.tencent.mm.ui.base.g.a(context, null, r0, null);
                    return true;
                } else if (str.startsWith("//resetmapcnt")) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_TENCENT_MAP_COUNT_INT, Integer.valueOf(0));
                    return true;
                } else if (str.equals("//testrsa")) {
                    ac.G("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                    return true;
                } else if (str.equals("//testrsabad")) {
                    ac.G("010001", "F338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                    return true;
                } else if (str.equals("//walletofflinetest")) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_ADDRESS_HAS_SHOW_WALLETOFFLINE_DIALOG_BOOLEAN_SYNC, Boolean.valueOf(false));
                    return false;
                } else if (str.startsWith("//makemsgdata ")) {
                    r0 = bg.getInt(str.split(" ")[1], 0);
                    ap.yY();
                    com.tencent.mm.u.c.wT().w(En_5b8fbb1e.a.vIk, (long) r0);
                    return true;
                } else if (str.startsWith("//pullappservice")) {
                    com.tencent.mm.pluginsdk.model.app.ao.bDn().dA(ab.getContext());
                    return true;
                } else if (str.startsWith("//boundaryconfig")) {
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig SessionTextMsg:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSessionTextMsg"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig SNSObjectText:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSNSObjectText"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig SnsCommentMaxSize:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("SnsCommentMaxSize"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig FavText:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFavText"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionBufSize:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSendEmotionBufSize"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig EmotionWidth:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSendEmotionWidth"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig FavImageSize:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFavImageSize"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig FavVoiceLength:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFavVoiceLength"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig ShortVideoAutoDownloadBufSize:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitSessionShortVideoBufSize"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig VideoSize:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitVideoSize"), 0)));
                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "boundaryconfig FileSize:%d", Integer.valueOf(bg.getInt(com.tencent.mm.i.g.sV().getValue("InputLimitFileSize"), 0)));
                    return true;
                } else if (str.startsWith("//whatsnew")) {
                    MMAppMgr.aa((Activity) context);
                    return true;
                } else if (str.startsWith("//profile ")) {
                    ap.yY();
                    r0 = com.tencent.mm.u.c.wR().Rc(str.replace("//profile ", "").trim());
                    if (!(r0 == null || r0.tJ() == 0)) {
                        r1 = new Intent();
                        r1.putExtra("Contact_User", r0.getUsername());
                        com.tencent.mm.bb.d.b(context, "profile", ".ui.ContactInfoUI", r1);
                    }
                    return true;
                } else if (str.startsWith("//cs")) {
                    intent = new Intent();
                    intent.putExtra("voipCSBizId", "gh_b35727b00b78");
                    intent.putExtra("voipCSAppId", "wx6e7147e8d764e85d");
                    com.tencent.mm.bb.d.b(ab.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                    return true;
                } else if (str.startsWith("//acs")) {
                    intent = new Intent();
                    intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                    intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                    com.tencent.mm.bb.d.b(ab.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                    return true;
                } else if (str.startsWith("//wifiset")) {
                    intent = new Intent();
                    intent.putExtra("free_wifi_ssid", "Xiaomi_WENDY");
                    intent.putExtra("free_wifi_passowrd", "WX12345789");
                    com.tencent.mm.bb.d.b(ab.getContext(), "freewifi", ".ui.FreeWifiCopyPwdUI", intent);
                    return true;
                } else if (str.startsWith("//bcs")) {
                    intent = new Intent();
                    intent.putExtra("voipCSBizId", "gh_e8b085bb67e0");
                    intent.putExtra("voipCSAppId", "wx1224160e0adcefd6");
                    intent.putExtra("voipCSAllowBackCamera", "1");
                    intent.putExtra("voipCSShowOther", "1");
                    intent.putExtra("voipCSAvatarUrl", "https://ss2.baidu.com/6ONYsjip0QIZ8tyhnq/it/u=28737416,3249768666&fm=58");
                    intent.putExtra("voipCSContext", "test");
                    com.tencent.mm.bb.d.b(ab.getContext(), "voip_cs", ".ui.VoipCSMainUI", intent);
                    return true;
                } else if (str.startsWith("//getfpkey")) {
                    r1 = ba.bMW();
                    com.tencent.mm.ui.base.g.a(context, r1, "Fingerprint Key", context.getString(R.l.fcd), context.getString(R.l.dXi), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((ClipboardManager) context.getSystemService("clipboard")).setText(r1);
                            Toast.makeText(context, R.l.fce, 0).show();
                        }
                    }, null);
                    return true;
                } else if (str.startsWith("//commitwd")) {
                    WatchDogPushReceiver.Ki();
                    return true;
                } else if (str.startsWith("//setsnstestenv")) {
                    String[] split = str.split(" +");
                    if (split.length > 1) {
                        r3 = split[1];
                        if (p.isIPv4Address(r3) || p.isIPv6Address(r3)) {
                            if (split.length > 2) {
                                r2 = split[2];
                                if (p.isIPv4Address(r2) || p.isIPv6Address(r2)) {
                                    r1 = split.length > 3 ? split[3] : null;
                                    r.ijp = r3 != null;
                                    r.ijg = r3;
                                    r.ijK = r2;
                                    r.ijL = r1;
                                    ap.vd().d(new com.tencent.mm.modelcdntran.e());
                                    Toast.makeText(context, String.format("%s %s %s", new Object[]{r.ijg, r.ijK, r.ijL}), 1).show();
                                    return true;
                                }
                            }
                            r2 = null;
                            r1 = null;
                            if (r3 != null) {
                            }
                            r.ijp = r3 != null;
                            r.ijg = r3;
                            r.ijK = r2;
                            r.ijL = r1;
                            ap.vd().d(new com.tencent.mm.modelcdntran.e());
                            Toast.makeText(context, String.format("%s %s %s", new Object[]{r.ijg, r.ijK, r.ijL}), 1).show();
                            return true;
                        }
                    }
                    r3 = null;
                    r2 = null;
                    r1 = null;
                    if (r3 != null) {
                    }
                    r.ijp = r3 != null;
                    r.ijg = r3;
                    r.ijK = r2;
                    r.ijL = r1;
                    ap.vd().d(new com.tencent.mm.modelcdntran.e());
                    Toast.makeText(context, String.format("%s %s %s", new Object[]{r.ijg, r.ijK, r.ijL}), 1).show();
                    return true;
                } else if (str.startsWith("//snsvcodec")) {
                    r0 = str.split(" +");
                    if (r0.length > 1) {
                        r0 = r0[1];
                        if ("on".equalsIgnoreCase(r0)) {
                            ew(1);
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "snsvcodec val: 1");
                        } else if ("off".equalsIgnoreCase(r0)) {
                            ew(0);
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "snsvcodec val: 0");
                        }
                    } else {
                        ew(-1);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "snsvcodec val: -1");
                    }
                    return true;
                } else if (str.startsWith("//snswxpc")) {
                    r0 = str.split(" +");
                    if (r0.length > 1) {
                        r0 = r0[1];
                        if ("on".equalsIgnoreCase(r0)) {
                            ex(1);
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "snswxpc val: 1");
                        } else if ("off".equalsIgnoreCase(r0)) {
                            ex(0);
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "snswxpc val: 0");
                        }
                    } else {
                        ex(-1);
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "snswxpc val: -1");
                    }
                    return true;
                } else if (str.startsWith("//mmdumpsys")) {
                    ap.vL().D(new Runnable() {
                        public final void run() {
                            new aj(new aj.a(this) {
                                final /* synthetic */ AnonymousClass14 gTG;

                                {
                                    this.gTG = r1;
                                }

                                public final boolean oQ() {
                                    Exception e;
                                    Throwable th;
                                    if (com.tencent.mm.compatible.util.d.eo(23)) {
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "gcCount: %s", Debug.getRuntimeStats());
                                    } else {
                                        int globalGcInvocationCount = Debug.getGlobalGcInvocationCount();
                                        int threadGcInvocationCount = Debug.getThreadGcInvocationCount();
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "gcCount: %d %d", Integer.valueOf(globalGcInvocationCount), Integer.valueOf(threadGcInvocationCount));
                                    }
                                    long pss = Debug.getPss();
                                    Debug.getMemoryInfo(new MemoryInfo());
                                    if (com.tencent.mm.compatible.util.d.eo(23)) {
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%s", Long.valueOf(pss), r2.getMemoryStats());
                                    } else {
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "pss: %d, memoryInfo:%d", Long.valueOf(pss), Integer.valueOf(r2.nativePss));
                                    }
                                    LineNumberReader lineNumberReader;
                                    try {
                                        Process exec = Runtime.getRuntime().exec("top -m 5 -n 1");
                                        lineNumberReader = new LineNumberReader(new InputStreamReader(exec.getInputStream()));
                                        while (true) {
                                            try {
                                                String readLine = lineNumberReader.readLine();
                                                if (readLine == null) {
                                                    break;
                                                } else if (readLine.length() > 0) {
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", readLine);
                                                }
                                            } catch (Exception e2) {
                                                e = e2;
                                            }
                                        }
                                        exec.waitFor();
                                        exec.destroy();
                                        try {
                                            lineNumberReader.close();
                                        } catch (Exception e3) {
                                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e3.getMessage());
                                        }
                                    } catch (Exception e4) {
                                        e3 = e4;
                                        lineNumberReader = null;
                                        try {
                                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "getRunningAppProcessesByPs fail, ex = %s", e3.getMessage());
                                            if (lineNumberReader != null) {
                                                try {
                                                    lineNumberReader.close();
                                                } catch (Exception e32) {
                                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e32.getMessage());
                                                }
                                            }
                                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                            for (Thread name : Thread.getAllStackTraces().keySet()) {
                                                if (name.getState() == State.RUNNABLE) {
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", name.getName(), ah.b((StackTraceElement[]) r1.get((Thread) r2.next())));
                                                }
                                            }
                                            return true;
                                        } catch (Throwable th2) {
                                            th = th2;
                                            if (lineNumberReader != null) {
                                                try {
                                                    lineNumberReader.close();
                                                } catch (Exception e5) {
                                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "getRunningProcessesByPs finally got ex = %s", e5.getMessage());
                                                }
                                            }
                                            throw th;
                                        }
                                    } catch (Throwable th3) {
                                        th = th3;
                                        lineNumberReader = null;
                                        if (lineNumberReader != null) {
                                            lineNumberReader.close();
                                        }
                                        throw th;
                                    }
                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "thread count:%d", Integer.valueOf(Thread.activeCount()));
                                    for (Thread name2 : Thread.getAllStackTraces().keySet()) {
                                        if (name2.getState() == State.RUNNABLE) {
                                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "Running thread: %s\n %s", name2.getName(), ah.b((StackTraceElement[]) r1.get((Thread) r2.next())));
                                        }
                                    }
                                    return true;
                                }
                            }, true).v(10000, 10000);
                        }
                    });
                    return true;
                } else if (str.startsWith("//remittance reset")) {
                    ap.yY();
                    com.tencent.mm.u.c.vr().set(327729, "0");
                    return true;
                } else if (str.startsWith("//wv ")) {
                    r0 = str.replace("//wv ", "");
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0);
                    com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", r1);
                    return true;
                } else if (str.startsWith("//wvjsapi ")) {
                    r0 = str.replace("//wvjsapi ", "");
                    r1 = new Intent();
                    r1.putExtra("rawUrl", r0);
                    com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewTestUI", r1);
                    return true;
                } else if (str.startsWith("//setibeacontabuinopen")) {
                    if (!ap.zb()) {
                        return false;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(1));
                    return true;
                } else if (str.startsWith("//setibeacontabuinclose")) {
                    if (!ap.zb()) {
                        return false;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_IBEACON_SHAKE_TAB_IS_UIN_RESIDENT_INT, Integer.valueOf(0));
                    return true;
                } else if (str.startsWith("//setibeaconpushopen")) {
                    if (!ap.zb()) {
                        return false;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(true));
                    return true;
                } else if (str.startsWith("//setibeaconpushclose")) {
                    if (!ap.zb()) {
                        return false;
                    }
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_IBEACON_PUSH_IS_OPEN_BOOLEAN, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//ibeacon")) {
                    r0 = false;
                    r1 = false;
                    if (VERSION.SDK_INT >= 18) {
                        r0 = true;
                    }
                    BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
                    if (defaultAdapter != null && defaultAdapter.getState() == 12) {
                        r1 = true;
                    }
                    boolean hasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.bluetooth_le");
                    r2 = r0 && r1 && hasSystemFeature;
                    r1 = "isNowSupportedIbeacon:" + r2 + "\n\nisSystemSupported:" + r0 + "\nisBlueStateOn:" + r1 + "\nisSupportedBLE:" + hasSystemFeature + "\nSDK:" + VERSION.SDK_INT + "\nModel:" + Build.BRAND + "-" + com.tencent.mm.compatible.d.p.rF() + "\noperatingSystemInfo:" + com.tencent.mm.compatible.d.p.rJ();
                    com.tencent.mm.ui.base.g.a(context, r1, "TestResult", context.getString(R.l.dTn), context.getString(R.l.dXi), new OnClickListener() {
                        public final void onClick(DialogInterface dialogInterface, int i) {
                            ((ClipboardManager) context.getSystemService("clipboard")).setText(r1);
                        }
                    }, null);
                    return true;
                } else if (str.startsWith("//gettbs")) {
                    r0 = com.tencent.mm.compatible.d.p.gRf.gRR;
                    r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                    r2 = r1.getString("tbs_download", null);
                    r3 = r1.getString("tbs_webview_disable", null);
                    boolean z = r1.getBoolean("x5_jscore_enabled", false);
                    int tbsCoreVersion = WebView.getTbsCoreVersion(context);
                    r6 = WebView.getTbsSDKVersion(context);
                    String string = r1.getString("tbs_webview_min_sdk_version", null);
                    r1 = r1.getString("tbs_webview_max_sdk_version", null);
                    Toast.makeText(context, String.format("forceSys:%b\ntbs_download:%s\ntbs_disable:%s\ntbs_disable_min_sdk_version:%s\ntbs_disable_max_sdk_version:%s\ntbsCoreVersion:%d\ntbsSdkVersion:%d\nx5JsCoreEnabled:%b", new Object[]{Boolean.valueOf(r0), r2, r3, string, r1, Integer.valueOf(tbsCoreVersion), Integer.valueOf(r6), Boolean.valueOf(z)}), 1).show();
                    return true;
                } else if (str.startsWith("//deletetbs")) {
                    intent = new Intent();
                    intent.setComponent(new ComponentName(ab.getPackageName(), "com.tencent.mm.booter.MMReceivers$SandBoxProcessReceiver"));
                    context.sendBroadcast(intent);
                    r0 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    r0.putLong("last_check_ts", 0);
                    r0.apply();
                    ap.yY();
                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_OVER_SEA_DOWNLOAD_X5_HAS_NOTIFY_BOOLEAN_SYNC, Boolean.valueOf(false));
                    return true;
                } else if (str.startsWith("//tbsDisableOverScroll")) {
                    r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    try {
                        r0 = str.substring(str.indexOf(":") + 1);
                    } catch (IndexOutOfBoundsException e3) {
                        r0 = "";
                    }
                    r1.putBoolean("tbs_disable_over_scroll", Boolean.parseBoolean(r0));
                    r1.apply();
                    return true;
                } else if (str.startsWith("//enabletbs")) {
                    r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    r2 = str.replace("//enabletbs ", "");
                    r1.putString("tbs_webview_disable", "1".equals(r2) ? "0" : "1");
                    if ("0".equals(r2)) {
                        r1.putString("tbs_webview_min_sdk_version", "0");
                        r1.putString("tbs_webview_max_sdk_version", "0");
                    }
                    r1.apply();
                    return true;
                } else if (str.startsWith("//wvsha1")) {
                    r1 = context.getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit();
                    try {
                        r0 = str.substring(str.indexOf(":") + 1);
                    } catch (IndexOutOfBoundsException e4) {
                        r0 = "";
                    }
                    r1.putBoolean("wvsha1", Boolean.parseBoolean(r0));
                    r1.apply();
                    return true;
                } else {
                    if (str.startsWith("//channelId")) {
                        com.tencent.mm.ui.base.g.z(context, com.tencent.mm.sdk.platformtools.f.fuV, DownloadInfoColumns.CHANNELID);
                    }
                    if (str.startsWith("//traceroute")) {
                        com.tencent.mm.bb.d.w(context, "traceroute", ".ui.NetworkDiagnoseIntroUI");
                        return true;
                    }
                    if (str.startsWith("//qzone ")) {
                        new com.tencent.mm.pluginsdk.ui.applet.o(context).MU(str.replace("//qzone ", ""));
                    }
                    if (str.startsWith("//dumpcrash")) {
                        com.tencent.mm.sdk.platformtools.j.p(com.tencent.mm.compatible.util.e.hgq + "crash/", com.tencent.mm.compatible.util.e.hgv, false);
                        return true;
                    } else if (str.startsWith("//dumpanr")) {
                        com.tencent.mm.sdk.platformtools.j.p("/data/anr/", com.tencent.mm.compatible.util.e.hgv, false);
                        return true;
                    } else if (str.startsWith("//testanr")) {
                        try {
                            Thread.sleep(10000);
                        } catch (Throwable e5) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e5, "", new Object[0]);
                        }
                        return true;
                    } else if (str.startsWith("//opensnsadRightbar")) {
                        r.ijf = true;
                        return true;
                    } else if (str.startsWith("//setlocation ")) {
                        r0 = str.split(" ");
                        if (r0 == null || !com.tencent.mm.sdk.a.b.bIu()) {
                            return false;
                        }
                        r.iiv = true;
                        if (r0.length > 0) {
                            r.lat = bg.getDouble(r0[1], 0.0d);
                        }
                        if (r0.length > 1) {
                            r.lng = bg.getDouble(r0[2], 0.0d);
                        }
                        return true;
                    } else if (str.startsWith("//switchsdcard")) {
                        String str2;
                        ArrayList bJC = av.bJC();
                        int size = bJC.size();
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "switchsdcard sdcard size = " + size);
                        if (!(size <= 0 || bJC.get(0) == null || bg.mA(((av.a) bJC.get(0)).uvr))) {
                            for (r0 = 0; r0 < size; r0++) {
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "switchsdcard list i = " + r0 + " StatMountParse: " + bJC.get(r0));
                            }
                        }
                        for (int i = 0; i < size; i++) {
                            if (!((av.a) bJC.get(i)).uvr.equals(com.tencent.mm.compatible.util.e.hgs)) {
                                str2 = ((av.a) bJC.get(i)).uvr;
                                break;
                            }
                        }
                        str2 = null;
                        final Activity activity = (Activity) context;
                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "switchsdcard newSdcard: " + str2);
                        if (bg.mA(str2)) {
                            com.tencent.mm.ui.base.g.bj(context, context.getString(R.l.eXr));
                            return true;
                        }
                        com.tencent.mm.ui.base.g.a(context, context.getString(R.l.eXs), "", context.getString(R.l.dHT), context.getString(R.l.dGs), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                s sVar = new s(w.hgq + "SdcardInfo.cfg");
                                sVar.set(1, str2);
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "switchsdcard reset to sdcard root: " + sVar.get(1));
                                com.tencent.mm.sdk.platformtools.ad.Pu("welcome_page_show");
                                k.e(context, true);
                                com.tencent.mm.sdk.b.b yVar = new y();
                                yVar.fDf.fDg = false;
                                com.tencent.mm.sdk.b.a.urY.m(yVar);
                                WorkerProfile.oC().fxu.ox();
                                ap.getNotification().qi();
                                Intent intent = new Intent();
                                intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS");
                                ab.getContext().sendBroadcast(intent);
                                if (l.a.sBt != null) {
                                    l.a.sBt.ai(activity);
                                }
                                activity.finish();
                            }
                        }, null);
                        return true;
                    } else if (str.startsWith("//getip")) {
                        ap.vd().d(new com.tencent.mm.u.bb(new com.tencent.mm.u.bb.a() {
                            public final void a(com.tencent.mm.network.e eVar) {
                                if (eVar != null) {
                                    int i;
                                    String[] iPsString = eVar.getIPsString(true);
                                    for (i = 0; i < iPsString.length; i++) {
                                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "dkip long:%d  %s", Integer.valueOf(i), iPsString[i]);
                                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.mk(iPsString[i]).toString());
                                    }
                                    iPsString = eVar.getIPsString(false);
                                    for (i = 0; i < iPsString.length; i++) {
                                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "dkip short:%d %s", Integer.valueOf(i), iPsString[i]);
                                        com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "dkip long:%d %s", Integer.valueOf(i), com.tencent.mm.network.a.c.mk(iPsString[i]).toString());
                                    }
                                }
                            }
                        }));
                        return true;
                    } else if (str.startsWith("//localjsapi")) {
                        com.tencent.mm.sdk.platformtools.w.v("MicroMsg.CommandProcessor", "alvinluo path: %s", "file://" + com.tencent.mm.compatible.util.e.hgu + "test_jsapi.html");
                        r1 = new Intent();
                        r1.putExtra("rawUrl", r0);
                        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", r1);
                        return true;
                    } else if (str.startsWith("//getlocalkey")) {
                        r1 = ba.bMV();
                        com.tencent.mm.ui.base.g.a(context, r1, "Fingerprint Key", context.getString(R.l.fcd), context.getString(R.l.dXi), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ((ClipboardManager) context.getSystemService("clipboard")).setText(r1);
                                Toast.makeText(context, R.l.fce, 0).show();
                            }
                        }, null);
                        return true;
                    } else if (str.startsWith("//getdevid")) {
                        r1 = com.tencent.mm.compatible.d.p.rB();
                        com.tencent.mm.ui.base.g.a(context, r1, "devid", context.getString(R.l.dTn), context.getString(R.l.dXi), new OnClickListener() {
                            public final void onClick(DialogInterface dialogInterface, int i) {
                                ((ClipboardManager) context.getSystemService("clipboard")).setText(r1);
                            }
                        }, null);
                        return true;
                    } else if (str.startsWith("//testhtml")) {
                        intent = new Intent();
                        intent.putExtra("rawUrl", "file:///android_asset/jsapi/reader_test1.html");
                        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
                        return true;
                    } else if (str.startsWith("//testlocalhtml ")) {
                        r0 = str.replace("//testlocalhtml ", "");
                        r1 = new Intent();
                        r1.putExtra("rawUrl", "file://" + r0);
                        r1.putExtra("neverGetA8Key", true);
                        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", r1);
                        return true;
                    } else if (str.startsWith("//setkey")) {
                        if (ba.RX(str.replace("//setkey", ""))) {
                            Toast.makeText(context, R.l.fbw, 0).show();
                        }
                        return true;
                    } else if (str.startsWith("//checkspell")) {
                        r1 = str.replace("//checkspell ", "");
                        if (bg.mA(r1)) {
                            return true;
                        }
                        StringBuilder stringBuilder = new StringBuilder();
                        for (r0 = 0; r0 < r1.length(); r0++) {
                            stringBuilder.append("[" + r1.charAt(r0) + ":" + SpellMap.d(r1.charAt(r0)) + "]");
                        }
                        com.tencent.mm.ui.base.g.z(context, stringBuilder.toString(), "Check Spell");
                        return true;
                    } else if (str.startsWith("//gallery ")) {
                        r0 = str.replace("//gallery ", "");
                        if (bg.mA(r0)) {
                            return true;
                        }
                        context.getSharedPreferences(ab.bIX(), 0).edit().putString("gallery", r0).commit();
                        return true;
                    } else if (str.startsWith("//svgtag")) {
                        r0 = str.replace("//svgtag ", "");
                        if (r0.equals("on")) {
                            com.tencent.mm.bh.c.jL(true);
                        } else if (r0.equals("off")) {
                            com.tencent.mm.bh.c.jL(false);
                        }
                        return true;
                    } else if (str.startsWith("//svgcode")) {
                        try {
                            r0 = str.replace("//svgcode ", "");
                            if (!r0.equals("on")) {
                                r0.equals("off");
                            }
                            Class cls = Class.forName("com.tencent.mm.BuildConfig");
                            Field declaredField = cls.getDeclaredField("SVGCode");
                            declaredField.setAccessible(true);
                            r0 = declaredField.getBoolean(cls);
                            try {
                                Toast.makeText(ab.getContext(), "Using SVG Code : " + r0 + " " + com.tencent.mm.svg.b.b.bOa(), 1).show();
                            } catch (Exception e6) {
                            }
                        } catch (Throwable e52) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e52, "", new Object[0]);
                            r0 = false;
                        } catch (Throwable e522) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e522, "", new Object[0]);
                            r0 = false;
                        } catch (Throwable e5222) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e5222, "", new Object[0]);
                            r0 = false;
                        } catch (Throwable e52222) {
                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e52222, "", new Object[0]);
                            r0 = false;
                        }
                        return true;
                    } else if (str.startsWith("//testMbanner")) {
                        try {
                            r0 = str.replace("//testMbanner ", "").split(",");
                            if (r0.length >= 2) {
                                ax.zj().a(new aw(Integer.valueOf(r0[0]).intValue(), Integer.valueOf(r0[1]).intValue(), null));
                            }
                        } catch (Exception e7) {
                        }
                        return true;
                    } else {
                        if (str.startsWith("//testrsa")) {
                            ac.G("010001", "E338E5DAD46B331E3071FAFD4C0F84C7C7965DBBE64C6F8CC0F7CF04DC640C1F84A2014431A48D65F2B2F172BA9BE6F5A049BF52C78C14B0965E20F0D80D85A9180EBABB913D49821D28BFD9601DF52A4F3230AECAD96D23415F5E94D51A87CAA7630C5F3CB70345BAF572A4F61A134A2265AFD8FADDFE0222BD9ABF7DBEB7444D031454E8F21820BBC725E6857F765660E987FADEBCF6B3A15355C4CD3752A7B544D1D7E037AF4F9725BE37681A84C9E1DC431B3065294EAD53E913BAF16D46714B013EA077191E6CA08ABA6D70E9CA792D898D692E3168D6341369976657CD5E1504B9E2458F107225176734D11621AD36D7FFA26C573D6612455B09105C41", MMGIFException.D_GIF_ERR_NO_COLOR_MAP);
                        }
                        if (str.startsWith("//recomT")) {
                            try {
                                ap.yY().xy().a(str.replace("//recomT ", ""), true, null);
                            } catch (Exception e8) {
                            }
                            return true;
                        } else if (str.startsWith("//recomF")) {
                            try {
                                ap.yY().xy().a(str.replace("//recomF ", ""), false, null);
                            } catch (Exception e9) {
                            }
                            return true;
                        } else if (str.startsWith("//testgetreg")) {
                            try {
                                r0 = str.replace("//testgetreg ", "").split(",");
                                if (r0.length > 2) {
                                    new bf.a().fi(Integer.valueOf(r0[0]).intValue()).fk(Integer.valueOf(r0[1]).intValue()).fj(Integer.valueOf(r0[2]).intValue()).commit();
                                }
                            } catch (Exception e10) {
                            }
                            return true;
                        } else if (str.startsWith("//ffmpeg")) {
                            try {
                                r0 = str.indexOf("-r ");
                                r1 = str.indexOf("-b ");
                                r0 = str.substring(r0 + 3, r1);
                                r1 = str.substring(r1 + 3);
                                float f = bg.getFloat(r0.trim(), 0.0f);
                                r1 = bg.getInt(r1.trim(), 0);
                                com.tencent.mm.plugin.sight.base.b.ptA = r1;
                                com.tencent.mm.plugin.sight.base.b.ptB = f;
                                Toast.makeText(ab.getContext(), "set C2C video encode frame rate " + f + " bitrate " + r1, 0).show();
                            } catch (Exception e11) {
                                Toast.makeText(ab.getContext(), "set C2C video frame rate fail, please ensure your command.", 1).show();
                            }
                            return true;
                        } else if (str.startsWith("//onlinevideo")) {
                            try {
                                r0 = bg.getInt(str.replace("//onlinevideo ", ""), 0);
                                ap.yY();
                                com.tencent.mm.u.c.vr().a(w.a.USERINFO_ONLINE_VIDEO_INT, Integer.valueOf(r0));
                                Toast.makeText(ab.getContext(), r0 > 0 ? "online video" : "offline video", 0).show();
                            } catch (Throwable e522222) {
                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e522222, "", new Object[0]);
                                Toast.makeText(ab.getContext(), "set online video fail, please ensure your command.", 1).show();
                            }
                            return true;
                        } else if (str.startsWith("//hevcinfo")) {
                            r0 = com.tencent.mm.plugin.s.e.aKq();
                            r1 = En_5b8fbb1e.a.vIk;
                            au auVar = new au();
                            auVar.cH(r1);
                            auVar.dw(2);
                            auVar.setType(1);
                            auVar.z(System.currentTimeMillis());
                            auVar.setContent(r0);
                            ay.i(auVar);
                            return true;
                        } else if (str.startsWith("//presns")) {
                            com.tencent.mm.kernel.h.vL().e(new Runnable() {
                                public final void run() {
                                    com.tencent.mm.sdk.b.a.urY.m(new pc());
                                }
                            }, 3000);
                            Toast.makeText(ab.getContext(), "preload sns", 0).show();
                            return true;
                        } else if (str.startsWith("//calcwxdata")) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(w.a.USERINFO_BACKGROUND_CALC_TIME_LONG, Long.valueOf(0));
                            Toast.makeText(ab.getContext(), "calc wx data success", 0).show();
                            return true;
                        } else if (str.startsWith("//upfacemodel")) {
                            ap.vd().d(new com.tencent.mm.pluginsdk.k.a.b.m(42));
                            return true;
                        } else if (str.startsWith("//facett")) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().a(w.a.USERINFO_FACE_SHOW_TUTORIAL_BOOLEAN_SYNC, Boolean.valueOf(false));
                            return true;
                        } else if (str.startsWith("//switchpaytype")) {
                            r0 = str.split(" ");
                            if (r0 == null || r0.length < 2) {
                                return false;
                            }
                            try {
                                r0 = bg.getInt(r0[1], 0);
                                ap.yY();
                                com.tencent.mm.u.c.vr().set(339975, Integer.valueOf(r0));
                                return true;
                            } catch (Exception e12) {
                                com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "hy: switch wallet type error");
                                return false;
                            }
                        } else if (str.startsWith("//setNfcOpenUrl ")) {
                            r0 = str.replace("//setNfcOpenUrl ", "");
                            r1 = ab.bIZ().edit();
                            r1.putString("nfc_open_url", r0);
                            r1.commit();
                            return true;
                        } else if (str.startsWith("//snskvtest ")) {
                            r0 = str.replace("//snskvtest", "").trim();
                            if (r0.equals("0")) {
                                r.ijB = false;
                            } else if (r0.equals("1")) {
                                r.ijB = true;
                            }
                            return true;
                        } else if (str.startsWith("//emoji ")) {
                            ((com.tencent.mm.plugin.emoji.b.c) com.tencent.mm.kernel.h.j(com.tencent.mm.plugin.emoji.b.c.class)).getEmojiMgr().ul(str.replace("//emoji ", ""));
                            return true;
                        } else if (str.startsWith("//share ")) {
                            r0 = Integer.valueOf(str.replace("//share ", "")).intValue();
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(229635, Integer.valueOf(r0));
                            return true;
                        } else if (str.startsWith("//dumpappinfoblob ")) {
                            com.tencent.mm.pluginsdk.model.app.f Me = an.aRr().Me(str.replace("//dumpappinfoblob ", ""));
                            com.tencent.mm.ui.base.g.z(context, Me.px() + "\n" + Me.py() + "\n" + Me.pz(), "");
                            return true;
                        } else if (str.startsWith("//googleauth ")) {
                            r0 = str.replace("//googleauth ", "");
                            if (!TextUtils.isEmpty(r0)) {
                                if ("webview".equals(r0)) {
                                    context.getSharedPreferences(ab.bIX(), 0).edit().putBoolean("googleauth", true).commit();
                                } else if ("local".equals(r0)) {
                                    context.getSharedPreferences(ab.bIX(), 0).edit().putBoolean("googleauth", false).commit();
                                }
                            }
                            return true;
                        } else if (str.startsWith("//clrgamecache")) {
                            l.k bCo = l.a.bCo();
                            if (bCo != null) {
                                bCo.cl(context);
                            }
                            return true;
                        } else if (str.startsWith("//clearwepkg")) {
                            r0 = new ss();
                            r0.gaE.fEG = 6;
                            r1 = str.replace("//clearwepkg ", "").trim();
                            if (!(bg.mA(r1) || r1.equals("//clearwepkg"))) {
                                r0.gaE.gaF = r1;
                            }
                            com.tencent.mm.sdk.b.a.urY.m(r0);
                            return true;
                        } else if (str.startsWith("//googlemap")) {
                            r.ije = true;
                            return true;
                        } else if (str.startsWith("//sosomap")) {
                            r.ije = false;
                            return true;
                        } else if (str.startsWith("//opentrace")) {
                            com.tencent.mm.ui.applet.d dVar = new com.tencent.mm.ui.applet.d();
                            com.tencent.mm.ui.applet.d.eJ(ab.getContext());
                            return true;
                        } else if (str.startsWith("//updateConversation")) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "update all conversation start");
                            ap.yY();
                            for (String str3 : com.tencent.mm.u.c.wW().bLI()) {
                                ap.yY();
                                au cN = com.tencent.mm.u.c.wT().cN(str3, " and not ( type = 10000 and isSend != 2 ) ");
                                ap.yY();
                                com.tencent.mm.u.c.wW().X(cN);
                            }
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "update all conversation end");
                            return true;
                        } else if (str.startsWith("//setshakecarddata")) {
                            l.a.bCn().baO();
                            return true;
                        } else if (str.startsWith("//clearshakecarddata")) {
                            l.a.bCn().baP();
                            return true;
                        } else if (str.startsWith("//pageSize")) {
                            Context context2 = ab.getContext();
                            r1 = new StringBuilder("pageSize is ");
                            ap.yY();
                            Toast.makeText(context2, r1.append(com.tencent.mm.u.c.wO().getPageSize()).toString(), 1).show();
                            return true;
                        } else if (str.startsWith("//resetDBStatus")) {
                            ap.yY();
                            File file = new File(com.tencent.mm.u.c.vp());
                            try {
                                r1 = new StringBuilder();
                                ap.yY();
                                com.tencent.mm.ui.tools.e.e(new File(r1.append(com.tencent.mm.u.c.xu()).append(file.getName().replace(".db", ".db.backup")).toString()), file);
                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "backupPath db path is %s", r1);
                                com.tencent.mm.a.e.a(file, new File(file.getAbsolutePath() + "err" + System.currentTimeMillis()));
                                Toast.makeText(ab.getContext(), "db状态已重置,请重启微信", 1).show();
                            } catch (Exception e13) {
                                com.tencent.mm.sdk.platformtools.w.w("MicroMsg.CommandProcessor", "delete failed: " + e13.getMessage());
                            }
                            return true;
                        } else if (str.startsWith("//makesnsdata ")) {
                            z.bCt().dc((long) bg.getInt(str.replace("//makesnsdata ", ""), 0));
                            return true;
                        } else if (str.startsWith("//setsnsupload ")) {
                            r.ijo = bg.getInt(str.replace("//setsnsupload ", ""), 0);
                            return true;
                        } else if (str.startsWith("//logsnstable")) {
                            com.tencent.mm.sdk.b.a.urY.m(new cf());
                            return true;
                        } else if (str.startsWith("//fpsreset ")) {
                            r0 = new fi();
                            if (str.equalsIgnoreCase("//fpsreset on")) {
                                r0.fJU.fEG = 1;
                            } else {
                                r0.fJU.fEG = 0;
                            }
                            com.tencent.mm.sdk.b.a.urY.m(r0);
                            return true;
                        } else if (str.startsWith("//resetsnstip")) {
                            ap.yY();
                            com.tencent.mm.u.c.vr().set(327776, Integer.valueOf(0));
                            return true;
                        } else if (str.startsWith("//checkcount")) {
                            ap.yY();
                            r0 = com.tencent.mm.u.c.wT().Az(En_5b8fbb1e.a.vIk);
                            ap.yY();
                            Toast.makeText(context, "current count :" + r0 + " countAuto :" + com.tencent.mm.u.c.wT().Ax(En_5b8fbb1e.a.vIk), 1).show();
                            return true;
                        } else if (str.startsWith("//changeframe ")) {
                            ab.getContext().getSharedPreferences("preferences_animation", 0).edit().putFloat("frameInterval", Float.valueOf(str.replace("//changeframe ", "")).floatValue()).commit();
                            return true;
                        } else if (str.startsWith("//opendumpview")) {
                            com.tencent.mm.ui.applet.c cVar = new com.tencent.mm.ui.applet.c();
                            com.tencent.mm.ui.applet.c.eI(ab.getContext());
                            return true;
                        } else if (str.startsWith("//dumpmemory")) {
                            System.gc();
                            System.gc();
                            com.tencent.mm.bl.b.bOg();
                            return true;
                        } else if (str.startsWith("//dumpsnsfile")) {
                            com.tencent.mm.sdk.b.a.urY.m(new or());
                            return true;
                        } else if (str.startsWith("//coverage")) {
                            com.tencent.mm.plugin.report.b.f.DA(str.trim().substring(10));
                            return true;
                        } else if (str.startsWith("//dumpthreadpool")) {
                            com.tencent.mm.sdk.f.e.bKv();
                            return true;
                        } else if (str.startsWith("//testverifypsw ")) {
                            str3 = str.replace("//testverifypsw ", "").trim();
                            if (str3.equals("0")) {
                                r.ijD = false;
                            } else if (str3.equals("1")) {
                                r.ijD = true;
                            }
                            com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "summerdktext testverifypsw msg[%s], testVerifyPsw[%b]", str, Boolean.valueOf(r.ijD));
                            return true;
                        } else if (str.startsWith("//pickpoi")) {
                            intent = new Intent();
                            intent.putExtra("map_view_type", 8);
                            com.tencent.mm.bb.d.b(context, "location", ".ui.RedirectUI", intent);
                            return true;
                        } else if (str.startsWith("//configlist")) {
                            if (str.matches("^//configlist set ([\\S]*)=([\\S]*)$")) {
                                List aq = u.aq(str, "^//configlist set ([\\S]*)=([\\S]*)$");
                                if (aq != null && aq.size() == 2) {
                                    com.tencent.mm.i.g.sV().put((String) aq.get(0), (String) aq.get(1));
                                    com.tencent.mm.sdk.b.a.urY.m(new cg());
                                }
                            } else if (str.matches("^//configlist get ([\\S]*)$")) {
                                List aq2 = u.aq(str, "^//configlist get ([\\S]*)$");
                                if (aq2 != null && aq2.size() == 1) {
                                    str3 = (String) aq2.get(0);
                                    Toast.makeText(context, str3 + "=" + com.tencent.mm.i.g.sV().getValue(str3), 0).show();
                                }
                            } else {
                                ap.yY();
                                str3 = (String) com.tencent.mm.u.c.vr().get(278530, (Object) "");
                                ap.yY();
                                r1 = (String) com.tencent.mm.u.c.vr().get(278529, (Object) "");
                                r2 = com.tencent.mm.compatible.util.e.hgu + "dynacfg.xml";
                                bg.r(r2, (str3 + r1).getBytes());
                                Toast.makeText(context, "output dynacfg xml to " + r2, 0).show();
                            }
                            return true;
                        } else if (str.startsWith("//security")) {
                            try {
                                ap.yY().xz().a(str.replace("//security ", ""), true, null);
                            } catch (Exception e14) {
                            }
                            return true;
                        } else if (str.startsWith("//updatepackage")) {
                            try {
                                ap.vd().d(new com.tencent.mm.ap.k(bg.getInt(str.replace("//updatepackage ", "").trim(), 0)));
                            } catch (Exception e15) {
                            }
                            return true;
                        } else if (str.startsWith("//copypackage")) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copypackage msg:%s", str);
                            r0 = av.bJC();
                            r6 = r0.size();
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d", Integer.valueOf(r6));
                            if (r6 < 2) {
                                com.tencent.mm.ui.base.g.bj(context, context.getString(R.l.eaM));
                            } else {
                                com.tencent.mm.ui.base.g.a(context, context.getString(R.l.eaO), "", context.getString(R.l.dHT), context.getString(R.l.dGs), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass5 gTw;

                                            {
                                                this.gTw = r1;
                                            }

                                            public final void run() {
                                                try {
                                                    String str = com.tencent.mm.compatible.util.e.hgs;
                                                    ap.yY();
                                                    String xl = com.tencent.mm.u.c.xl();
                                                    ap.yY();
                                                    String wK = com.tencent.mm.u.c.wK();
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copypackage size:%d, root:%s, pkgFullPath:%s, sysPath:%s, pkgPath:%s", Integer.valueOf(r6), str, xl, wK, xl.substring(str.length()));
                                                    for (int i = 0; i < r6; i++) {
                                                        Object obj = ((av.a) r0.get(i)).uvr;
                                                        if (!(bg.mA(obj) || str.contains(obj))) {
                                                            File file = new File(obj + r5);
                                                            if (file.exists() && file.isDirectory()) {
                                                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copypackage done pkgFullPath:%s, old:%s, ret:%b", xl, file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.j.p(file.getAbsolutePath(), xl, false)));
                                                                if (com.tencent.mm.sdk.platformtools.j.p(file.getAbsolutePath(), xl, false)) {
                                                                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                                                        final /* synthetic */ AnonymousClass1 gTx;

                                                                        {
                                                                            this.gTx = r1;
                                                                        }

                                                                        public final void run() {
                                                                            com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.eaN));
                                                                        }
                                                                    });
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                                        final /* synthetic */ AnonymousClass1 gTx;

                                                        {
                                                            this.gTx = r1;
                                                        }

                                                        public final void run() {
                                                            com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.eaM));
                                                        }
                                                    });
                                                } catch (Exception e) {
                                                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.CommandProcessor", "summercmd copypackage e:%s", e.getMessage());
                                                }
                                            }
                                        }, "copypackage");
                                    }
                                }, null);
                            }
                            return true;
                        } else if (str.startsWith("//copy -n ")) {
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copy -n msg:%s ", str);
                            r0 = av.bJC();
                            r6 = r0.size();
                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copy -n size:%d", Integer.valueOf(r6));
                            if (r6 < 2) {
                                com.tencent.mm.ui.base.g.bj(context, context.getString(R.l.eaM));
                            } else {
                                com.tencent.mm.ui.base.g.a(context, context.getString(R.l.eaO), "", context.getString(R.l.dHT), context.getString(R.l.dGs), new OnClickListener() {
                                    public final void onClick(DialogInterface dialogInterface, int i) {
                                        com.tencent.mm.sdk.f.e.post(new Runnable(this) {
                                            final /* synthetic */ AnonymousClass6 gTz;

                                            {
                                                this.gTz = r1;
                                            }

                                            public final void run() {
                                                try {
                                                    String substring = str.substring(10);
                                                    String str = com.tencent.mm.compatible.util.e.hgs;
                                                    ap.yY();
                                                    String str2 = com.tencent.mm.u.c.xv() + substring;
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copy -n subDir:%s, root:%s, accPath:%s destPath:%s, subPath:%s", substring, str, r1, str2, str2.substring(str.length()));
                                                    for (int i = 0; i < r6; i++) {
                                                        Object obj = ((av.a) r0.get(i)).uvr;
                                                        if (!(bg.mA(obj) || str.contains(obj))) {
                                                            File file = new File(obj + r5);
                                                            if (file.exists() && file.isDirectory()) {
                                                                File file2 = new File(str2);
                                                                if (!file2.exists()) {
                                                                    file2.mkdir();
                                                                }
                                                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercmd copy -n done new:%s, old:%s, ret:%b", file2.getAbsolutePath(), file.getAbsolutePath(), Boolean.valueOf(com.tencent.mm.sdk.platformtools.j.p(file.getAbsolutePath(), file2.getAbsolutePath(), false)));
                                                                if (com.tencent.mm.sdk.platformtools.j.p(file.getAbsolutePath(), file2.getAbsolutePath(), false)) {
                                                                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                                                        final /* synthetic */ AnonymousClass1 gTA;

                                                                        {
                                                                            this.gTA = r1;
                                                                        }

                                                                        public final void run() {
                                                                            com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.eaN));
                                                                        }
                                                                    });
                                                                    return;
                                                                }
                                                            }
                                                        }
                                                    }
                                                    new ae(Looper.getMainLooper()).post(new Runnable(this) {
                                                        final /* synthetic */ AnonymousClass1 gTA;

                                                        {
                                                            this.gTA = r1;
                                                        }

                                                        public final void run() {
                                                            com.tencent.mm.ui.base.g.bl(context, context.getString(R.l.eaM));
                                                        }
                                                    });
                                                } catch (Exception e) {
                                                    com.tencent.mm.sdk.platformtools.w.w("MicroMsg.CommandProcessor", "summercmd copy -n e:%s", e.getMessage());
                                                }
                                            }
                                        }, "copy -n");
                                    }
                                }, null);
                            }
                            return true;
                        } else if (str.startsWith("//deletepackage")) {
                            try {
                                str3 = str.replace("//deletepackage ", "");
                                com.tencent.mm.sdk.b.b bzVar = new bz();
                                bzVar.fFy.fFz = bg.getInt(str3, 0);
                                com.tencent.mm.sdk.b.a.urY.m(bzVar);
                            } catch (Exception e16) {
                            }
                            return true;
                        } else if (str.startsWith("//audiowritetofile")) {
                            com.tencent.mm.compatible.d.p.gRd.gOr = true;
                            return true;
                        } else if (str.startsWith("//bankcard")) {
                            intent = new Intent();
                            intent.putExtra("BaseScanUI_select_scan_mode", 7);
                            intent.putExtra("bank_card_owner", "test");
                            if (!(com.tencent.mm.modelvideo.y.aI(context) || com.tencent.mm.al.a.aH(context))) {
                                com.tencent.mm.bb.d.b((Activity) context, "scanner", ".ui.BaseScanUI", intent);
                            }
                            return true;
                        } else {
                            if (str.startsWith("//banner")) {
                                Map q = com.tencent.mm.sdk.platformtools.bh.q("<sysmsg type=\"banner\"><mainframebanner type=\"11\"><showtype>1</showtype></mainframebanner></sysmsg>", "sysmsg");
                                str3 = (String) q.get(".sysmsg.mainframebanner.$type");
                                r1 = (String) q.get(".sysmsg.mainframebanner.showtype");
                                r2 = (String) q.get(".sysmsg.mainframebanner.data");
                                com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "type:%s showType:%s data:%s", str3, r1, r2);
                            }
                            if (str.startsWith("//gamemsg")) {
                                r0 = new lj();
                                r0.fSk.content = str;
                                com.tencent.mm.sdk.b.a.urY.m(r0);
                                return true;
                            } else if (str.startsWith("//shortcut#")) {
                                com.tencent.mm.plugin.ac.c.pts = str.substring(11);
                                return true;
                            } else if (str.startsWith("//gallerytype")) {
                                ag.vBB = !ag.vBB;
                                return true;
                            } else {
                                context.getString(R.l.fcU);
                                if (str.startsWith("//fullexit")) {
                                    com.tencent.mm.sdk.platformtools.ad.Pu("show_whatsnew");
                                    k.e(context, true);
                                    MMAppMgr.ai(context);
                                    ap.hold();
                                    com.tencent.mm.kernel.h.vJ().eh("");
                                    MMAppMgr.Sk();
                                    return true;
                                } else if (str.startsWith("//cleardldb")) {
                                    ap.yY();
                                    com.tencent.mm.u.c.wX().akS();
                                    return true;
                                } else if (str.startsWith("//setcardlayouttestdata")) {
                                    Object replace = str.replace("//setcardlayouttestdata ", "");
                                    ap.yY();
                                    com.tencent.mm.u.c.vr().a(w.a.USERINFO_CARDLAYOUT_TESTDATA_STRING, replace);
                                    return true;
                                } else if (str.startsWith("//delchatroomsysmsg")) {
                                    str3 = str.replace("//delchatroomsysmsg ", "");
                                    r1 = str3.indexOf(" ");
                                    r2 = str3.substring(0, r1);
                                    str3 = str3.substring(r1);
                                    if (bg.mA(r2)) {
                                        return false;
                                    }
                                    if (!str3.startsWith("<")) {
                                        return false;
                                    }
                                    au auVar2 = new au();
                                    auVar2.z(System.currentTimeMillis());
                                    auVar2.setType(CdnLogic.MediaType_FAVORITE_VIDEO);
                                    auVar2.setContent(str3);
                                    auVar2.dw(0);
                                    auVar2.cH(r2);
                                    ay.i(auVar2);
                                    return true;
                                } else {
                                    if (str.startsWith("//resetcrseq")) {
                                        r0 = str.split(" ");
                                        try {
                                            long j2 = bg.getLong(r0[1], -1);
                                            long j3 = bg.getLong(r0[2], -1);
                                            long j4 = bg.getLong(r0[3], -1);
                                            r0 = bg.getInt(r0[4], -1);
                                            if (j2 > 0) {
                                                r1 = j2 + "@chatroom";
                                                ap.yY();
                                                com.tencent.mm.storage.ae Rm = com.tencent.mm.u.c.wW().Rm(r1);
                                                if (Rm != null) {
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] before [%d, %d, %d] [%d, %d, %d]", Rm.getUsername(), Long.valueOf(Rm.pG()), Long.valueOf(Rm.pE()), Integer.valueOf(Rm.pF()), Long.valueOf(j3), Long.valueOf(j4), Integer.valueOf(r0));
                                                    if (j3 > -1) {
                                                        Rm.v(j3);
                                                    }
                                                    if (j4 > -1) {
                                                        Rm.u(j4);
                                                    }
                                                    if (r0 >= 0) {
                                                        Rm.dB(r0);
                                                    }
                                                    ap.yY();
                                                    r0 = com.tencent.mm.u.c.wW().a(Rm, Rm.getUsername(), false);
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summerbadcr resetcrseq [%s] done [%d, %d, %d] ret:%d", Rm.getUsername(), Long.valueOf(Rm.pG()), Long.valueOf(Rm.pE()), Integer.valueOf(Rm.pF()), Integer.valueOf(r0));
                                                    return true;
                                                }
                                            }
                                        } catch (Throwable e5222222) {
                                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e5222222, "summerbadcr resetcrseq", new Object[0]);
                                        }
                                    }
                                    if (str.startsWith("//printchatroominfo")) {
                                        str3 = En_5b8fbb1e.a.vIk;
                                        if (!com.tencent.mm.u.o.dH(str3)) {
                                            return false;
                                        }
                                        ap.yY();
                                        final q fV = com.tencent.mm.u.c.xa().fV(str3);
                                        if (fV == null) {
                                            com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], member is null", str3);
                                            return false;
                                        }
                                        ap.vL().D(new Runnable() {
                                            public final void run() {
                                                int bKS = fV.bKS();
                                                int i = fV.field_chatroomdataflag;
                                                int bKV = fV.bKV();
                                                q qVar = fV;
                                                if (qVar.b(qVar.uyW)) {
                                                    qVar.bKR();
                                                }
                                                int i2 = qVar.uyW.status;
                                                int bKW = fV.bKW();
                                                qVar = fV;
                                                if (qVar.b(qVar.uyW)) {
                                                    qVar.bKR();
                                                }
                                                String str = qVar.uyW.gMV;
                                                List DU = fV.DU();
                                                ap.yY();
                                                ce cN = com.tencent.mm.u.c.wT().cN(str3, " and flag != 0 and msgSeq != 0");
                                                boolean z = cN != null && cN.field_msgId > 0;
                                                ap.yY();
                                                com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercrinfo chatroomId[%s], version[%d], flag[%d], type[%d], status[%d], get[%b], msgCount[%d], maxCount[%d], upgrader[%s], membersize[%d]", str3, Integer.valueOf(bKS), Integer.valueOf(i), Integer.valueOf(bKV), Integer.valueOf(i2), Boolean.valueOf(z), Integer.valueOf(com.tencent.mm.u.c.wT().Ax(str3)), Integer.valueOf(bKW), str, Integer.valueOf(DU.size()));
                                                StringBuilder stringBuilder = new StringBuilder();
                                                stringBuilder.append("---chatroominfo---\nid:").append(str3).append("\nver:").append(bKS).append("\nflag:").append(i).append("\ntype:").append(bKV).append("\nstatus:").append(i2).append("\nget:").append(z).append("\nmsgCount:").append(r8).append("\nmaxCount:").append(bKW).append("\nupgrader:").append(str).append("\nmembersize:").append(DU.size());
                                                int i3 = -1;
                                                try {
                                                    i3 = bg.getInt(str.split(" ")[1], 0);
                                                } catch (Exception e) {
                                                }
                                                if (i3 == -1) {
                                                    i3 = DU.size();
                                                }
                                                if (i3 > DU.size()) {
                                                    i3 = DU.size();
                                                }
                                                if (i3 > 10) {
                                                    i = 10;
                                                } else {
                                                    i = i3;
                                                }
                                                if (i > 0) {
                                                    stringBuilder.append("\nmember:");
                                                }
                                                for (bKS = 0; bKS < i; bKS++) {
                                                    stringBuilder.append("\n").append((String) DU.get(bKS));
                                                }
                                                au auVar = new au();
                                                auVar.cH(str3);
                                                auVar.dw(2);
                                                auVar.setType(1);
                                                auVar.z(System.currentTimeMillis());
                                                auVar.setContent(stringBuilder.toString());
                                                ay.i(auVar);
                                            }
                                        });
                                        return true;
                                    } else if (str.equals("//testupdate")) {
                                        str3 = "";
                                        try {
                                            str3 = bg.convertStreamToString(context.getAssets().open("aplha_update_info.xml"));
                                        } catch (Throwable e17) {
                                            com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e17, "", new Object[0]);
                                        }
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(352273, str3);
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().set(352274, Long.valueOf(System.currentTimeMillis()));
                                        new com.tencent.mm.pluginsdk.model.app.a(str3).bCT();
                                        return true;
                                    } else if (str.equals("//checkUpdate0") || str.equals("//checkUpdate1")) {
                                        l.y.bCs().gG(str.equals("//checkUpdate1"));
                                        l.y.sBF = true;
                                        return true;
                                    } else if (str.equals("//debugsnstimelinestat")) {
                                        r.ijw = !r.ijw;
                                        Toast.makeText(ab.getContext(), "debugSnsTimelineStat: " + r.ijw, 0).show();
                                        return true;
                                    } else if (str.startsWith("//abtestmsg") && com.tencent.mm.sdk.a.b.bIu()) {
                                        com.tencent.mm.u.c.a.a gC = com.tencent.mm.u.c.a.gC(str.replace("//abtestmsg", ""));
                                        com.tencent.mm.u.c.c.Az().i(gC.hoO, 0);
                                        com.tencent.mm.u.c.c.AA().i(gC.hoP, 1);
                                        return true;
                                    } else if (str.startsWith("//triggergetabtest")) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_ABTEST_LAST_UPDATE_TIME_LONG, Long.valueOf(1));
                                        return true;
                                    } else if (str.startsWith("//vad")) {
                                        r0 = ab.bIY();
                                        if (r0 == null) {
                                            return false;
                                        }
                                        if (str.startsWith("//vad get")) {
                                            com.tencent.mm.ui.base.g.z(context, com.tencent.mm.aw.a.c.LY(), "VAD PARAMS").show();
                                            return true;
                                        }
                                        r0 = r0.edit();
                                        if (str.startsWith("//vad sd")) {
                                            r0.putInt("s_delay_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                        }
                                        if (str.startsWith("//vad st")) {
                                            r0.putInt("sil_time", Integer.valueOf(str.substring(9).trim()).intValue());
                                        }
                                        if (str.startsWith("//vad snr")) {
                                            r0.putFloat("s_n_ration", Float.valueOf(str.substring(10).trim()).floatValue());
                                        }
                                        if (str.startsWith("//vad sw")) {
                                            r0.putInt("s_window", Integer.valueOf(str.substring(9).trim()).intValue());
                                        }
                                        if (str.startsWith("//vad sl")) {
                                            r0.putInt("s_length", Integer.valueOf(str.substring(9).trim()).intValue());
                                        }
                                        r0.apply();
                                        return true;
                                    } else if (str.startsWith("//dumpabtestrecords")) {
                                        if (2 < com.tencent.mm.sdk.platformtools.w.getLogLevel()) {
                                            return false;
                                        }
                                        if (str.contains("info")) {
                                            r0 = com.tencent.mm.u.c.c.AA().bKJ();
                                        } else {
                                            r0 = com.tencent.mm.u.c.c.Az().bKJ();
                                        }
                                        r1 = new TextView(context);
                                        r1.setText(r0);
                                        r1.setGravity(8388627);
                                        r1.setTextSize(1, 10.0f);
                                        r1.setLayoutParams(new LayoutParams(-1, -2));
                                        r1.setTextColor(-16744704);
                                        r1.setTypeface(Typeface.MONOSPACE);
                                        r1.setMovementMethod(new ScrollingMovementMethod());
                                        r0 = context.getResources().getDimensionPixelSize(R.f.aXt);
                                        r1.setPadding(r0, r0, r0, r0);
                                        com.tencent.mm.ui.base.g.a(context, null, r1, null);
                                        return true;
                                    } else if (str.startsWith("//triggerWebViewCookiesCleanup")) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_WEBVIEW_CLEAR_HOST_COOKIES_INTERVAL_LONG, Long.valueOf(0));
                                        return true;
                                    } else if (str.startsWith("//cleanwebcache")) {
                                        com.tencent.mm.sdk.b.a.urY.m(new bj());
                                        return true;
                                    } else if (str.startsWith("//triggerWebViewCacheCleanup")) {
                                        intent = new Intent();
                                        intent.setComponent(new ComponentName(com.tencent.mm.ui.d.g.uOD, "com.tencent.mm.booter.MMReceivers$ToolsProcessReceiver"));
                                        intent.putExtra("tools_process_action_code_key", "com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE");
                                        context.sendBroadcast(intent);
                                        return true;
                                    } else if (str.startsWith("//dumpsnsabtest")) {
                                        com.tencent.mm.sdk.b.a.urY.m(new cd());
                                        return true;
                                    } else if (str.startsWith("//dumpsilkvoicefile")) {
                                        r.ijA = true;
                                        return true;
                                    } else if (str.startsWith("//fucktit")) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_SUBMENU_SHOW_TIT_BOOLEAN, Boolean.valueOf(true));
                                        return true;
                                    } else if (str.startsWith("//clog ")) {
                                        com.tencent.mm.plugin.report.service.g.oUh.dk(str.substring(7), "test cLog " + System.currentTimeMillis());
                                        return true;
                                    } else if (str.startsWith("//testformsg") && com.tencent.mm.sdk.a.b.bIu()) {
                                        str3 = str.substring(12).trim();
                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "MMCore.getSysCmdMsgExtension() " + ap.getSysCmdMsgExtension());
                                        bu buVar = new bu();
                                        buVar.tff = com.tencent.mm.platformtools.n.mw(str3);
                                        buVar.mtd = CdnLogic.MediaType_FAVORITE_VIDEO;
                                        ap.getSysCmdMsgExtension().b(new com.tencent.mm.y.d.a(buVar, false, false, false));
                                        return true;
                                    } else if (str.startsWith("//canwebviewcachedownload")) {
                                        r0 = bg.getInt(bg.mz(str.substring(25)).trim(), 1) > 0;
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_SET_CAN_WEBVIEW_CACHE_DOWNLOAD_BOOLEAN, Boolean.valueOf(r0));
                                        return true;
                                    } else if (str.startsWith("//canwebviewcacheprepushdownload")) {
                                        r0 = bg.getInt(bg.mz(str.substring(32)).trim(), 1) > 0;
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_SET_CAN_WEBVIEW_CACHE_PRE_PUSH_DOWNLOAD_BOOLEAN, Boolean.valueOf(r0));
                                        return true;
                                    } else if (str.startsWith("//resetsnslukcy")) {
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCTRLHASSHOW_BOOLEAN_SYNC, Boolean.valueOf(false));
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT_INT_SYNC, Integer.valueOf(0));
                                        ap.yY();
                                        com.tencent.mm.u.c.vr().a(w.a.USERINFO_NEWYEAR_2016_HONGBAO_SNS_CTRLLUCKYCOUNT2_INT_SYNC, Integer.valueOf(0));
                                        com.tencent.mm.sdk.b.a.urY.m(new ph());
                                        return true;
                                    } else if (str.startsWith("//mmimgdec ")) {
                                        str3 = str.substring(11);
                                        if ("on".equalsIgnoreCase(str3)) {
                                            MMBitmapFactory.setUseMMBitmapFactory(true);
                                            Toast.makeText(context, "内置图片(png)解析库开启", 0).show();
                                        } else if ("off".equalsIgnoreCase(str3)) {
                                            MMBitmapFactory.setUseMMBitmapFactory(false);
                                            Toast.makeText(context, "内置图片(png)解析库关闭", 0).show();
                                        }
                                        return true;
                                    } else if (str.startsWith("//enablempsp")) {
                                        al.a.jS(false);
                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                        return true;
                                    } else if (str.startsWith("//disablempsp")) {
                                        al.a.jS(true);
                                        Toast.makeText(context, "设置成功，请重启微信！", 0).show();
                                        return true;
                                    } else if (str.startsWith("//soterpay")) {
                                        com.tencent.mm.bb.d.w(context, "fingerprint", ".ui.SoterPayTestUI");
                                        return true;
                                    } else {
                                        context.getString(R.l.fbQ);
                                        if (str.startsWith("//getdltaskinfo")) {
                                            str3 = str.replace("//getdltaskinfo ", "");
                                            try {
                                                if (com.tencent.mm.plugin.downloader.model.d.ba(bg.getLong(str3, 0)) != null) {
                                                    com.tencent.mm.sdk.platformtools.w.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.d.ba(bg.getLong(str3, 0)).field_downloadId), com.tencent.mm.plugin.downloader.model.d.ba(bg.getLong(str3, 0)).field_downloadUrl, com.tencent.mm.plugin.downloader.model.d.ba(bg.getLong(str3, 0)).field_filePath, com.tencent.mm.plugin.downloader.model.d.ba(bg.getLong(str3, 0)).field_md5);
                                                } else {
                                                    com.tencent.mm.sdk.platformtools.w.i("getdltaskinfo", "infoID null");
                                                }
                                            } catch (Exception e18) {
                                                if (com.tencent.mm.plugin.downloader.model.d.tH(str3) != null) {
                                                    com.tencent.mm.sdk.platformtools.w.i("getdltaskinfo", "%d, %s, %s, %s", Long.valueOf(com.tencent.mm.plugin.downloader.model.d.tH(str3).field_downloadId), com.tencent.mm.plugin.downloader.model.d.tH(str3).field_downloadUrl, com.tencent.mm.plugin.downloader.model.d.tH(str3).field_filePath, com.tencent.mm.plugin.downloader.model.d.tH(str3).field_md5);
                                                } else {
                                                    com.tencent.mm.sdk.platformtools.w.i("getdltaskinfo", "infoURL null");
                                                }
                                            }
                                            return true;
                                        } else if (str.startsWith("//testscan ")) {
                                            r.ijF = !r.ijF;
                                            r.ijH = bg.getInt(str.replace("//testscan", "").trim(), 0);
                                            r.ijI = 0;
                                            return true;
                                        } else if (str.startsWith("//switchrecordmode")) {
                                            r1 = ab.bIY();
                                            r2 = r1.getBoolean("settings_voicerecorder_mode", false);
                                            r1.edit().putBoolean("settings_voicerecorder_mode", !r2).commit();
                                            if (r2) {
                                                Toast.makeText(ab.getContext(), "Turn off silk record", 1).show();
                                            } else {
                                                Toast.makeText(ab.getContext(), "Turn on silk record", 1).show();
                                            }
                                            return true;
                                        } else if (str.startsWith("//indoorsensorconfig ")) {
                                            com.tencent.mm.modelstat.e.JX().kQ(str.replace("//indoorsensorconfig ", ""));
                                            return true;
                                        } else if (str.startsWith("//testindoorsensor ")) {
                                            String[] split2 = str.replace("//testindoorsensor ", "").split(",");
                                            com.tencent.mm.modelstat.e.JX().a(12345, false, split2[0].equals("1"), bg.getFloat(split2[1], 0.0f), bg.getFloat(split2[2], 0.0f), 12);
                                            return true;
                                        } else if (str.startsWith("//facedebug")) {
                                            return true;
                                        } else {
                                            if (str.startsWith("//rstfacett")) {
                                                return true;
                                            }
                                            if (str.startsWith("//switchjsc")) {
                                                str3 = str.replace("//switchjsc ", "");
                                                r1 = ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4);
                                                if ("clear".equals(str3)) {
                                                    r1.edit().remove("switch_x5_jscore").apply();
                                                } else if ("true".equals(str3)) {
                                                    r1.edit().putBoolean("switch_x5_jscore", true).apply();
                                                } else if ("false".equals(str3)) {
                                                    r1.edit().putBoolean("switch_x5_jscore", false).apply();
                                                }
                                                return true;
                                            } else if (str.startsWith("//rfcdn")) {
                                                try {
                                                    com.tencent.mm.modelcdntran.g.Em().keep_OnRequestDoGetCdnDnsInfo(888);
                                                } catch (Throwable e52222222) {
                                                    com.tencent.mm.sdk.platformtools.w.e("MicroMsg.CommandProcessor", "rfcdn :%s", bg.g(e52222222));
                                                }
                                                return true;
                                            } else {
                                                if (str.startsWith("//testcrscroll ")) {
                                                    r0 = str.split(" ");
                                                    if (r0 != null && r0.length > 1) {
                                                        En_5b8fbb1e.vIh = bg.getInt(r0[1], 0);
                                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summerbadcr testscroll new BADCR_SCROLL_DELAY[%d]", Integer.valueOf(En_5b8fbb1e.vIh));
                                                        return true;
                                                    }
                                                }
                                                if (str.startsWith("//switchx5jscore")) {
                                                    r0 = ab.bIY();
                                                    r0.edit().putBoolean("switch_x5_jscore", !r0.getBoolean("switch_x5_jscore", true)).apply();
                                                    return true;
                                                } else if (str.startsWith("//switchmusicplayer")) {
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "msg:%s", str);
                                                    r2 = str.split(" ");
                                                    if (r2.length > 2) {
                                                        Object obj;
                                                        if (bg.getInt(r2[1], 0) == 0) {
                                                            obj = null;
                                                        } else {
                                                            r1 = 1;
                                                        }
                                                        int i2 = bg.getInt(r2[2], -1);
                                                        ap.yY();
                                                        r0 = ((Integer) com.tencent.mm.u.c.vr().get(w.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(0))).intValue();
                                                        if (i2 == -1) {
                                                            if (obj != null) {
                                                                r0 = 255;
                                                                obj = 1;
                                                            } else {
                                                                r0 = 0;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 == 0) {
                                                            if (obj != null) {
                                                                r0 |= 1;
                                                                r1 = 1;
                                                            } else {
                                                                r0 &= -2;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 == 1) {
                                                            if (obj != null) {
                                                                r0 |= 2;
                                                                r1 = 1;
                                                            } else {
                                                                r0 &= -3;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 == 4) {
                                                            if (obj != null) {
                                                                r0 |= 4;
                                                                r1 = 1;
                                                            } else {
                                                                r0 &= -5;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 == 6) {
                                                            if (obj != null) {
                                                                r0 |= 16;
                                                                r1 = 1;
                                                            } else {
                                                                r0 &= -17;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 == 7) {
                                                            if (obj != null) {
                                                                r0 |= 32;
                                                                r1 = 1;
                                                            } else {
                                                                r0 &= -33;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 == 8) {
                                                            if (obj != null) {
                                                                r0 |= 64;
                                                                r1 = 1;
                                                            } else {
                                                                r0 &= -65;
                                                                r1 = 1;
                                                            }
                                                        } else if (i2 != 9) {
                                                            obj = null;
                                                        } else if (obj != null) {
                                                            r0 |= FileUtils.S_IWUSR;
                                                            r1 = 1;
                                                        } else {
                                                            r0 &= -129;
                                                            r1 = 1;
                                                        }
                                                        if (obj != null) {
                                                            ap.yY();
                                                            com.tencent.mm.u.c.vr().a(w.a.USERINFO_MUSIC_PLAYER_SWITCH_FLAG_INT_SYNC, Integer.valueOf(r0));
                                                        }
                                                    }
                                                    return true;
                                                } else if (str.startsWith("//testdefaultrsa")) {
                                                    com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa");
                                                    ac.G("", "", 0);
                                                    new com.tencent.mm.modelsimple.u("", "", "", 0).Jg().a(com.tencent.mm.kernel.h.vH().vd().vh(), new com.tencent.mm.y.e() {
                                                        public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                                                            com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa NetSceneManualAuth onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                            if (i == 4 && i2 == -102) {
                                                                af.v(new Runnable(this) {
                                                                    final /* synthetic */ AnonymousClass8 gTD;

                                                                    {
                                                                        this.gTD = r1;
                                                                    }

                                                                    public final void run() {
                                                                        b.w(context, "RSA(req) fatal err, must recheck!!!");
                                                                    }
                                                                });
                                                            } else {
                                                                new com.tencent.mm.modelsimple.m().a(com.tencent.mm.kernel.h.vH().gXC.hsZ, new com.tencent.mm.y.e(this) {
                                                                    final /* synthetic */ AnonymousClass8 gTD;

                                                                    {
                                                                        this.gTD = r1;
                                                                    }

                                                                    public final void a(int i, int i2, String str, com.tencent.mm.y.k kVar) {
                                                                        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercert testdefaultrsa  NetSceneGetCert onSceneEnd [%d, %d, %s]", Integer.valueOf(i), Integer.valueOf(i2), str);
                                                                        if (i == 4 && i2 == -102) {
                                                                            af.v(new Runnable(this) {
                                                                                final /* synthetic */ AnonymousClass2 gTE;

                                                                                {
                                                                                    this.gTE = r1;
                                                                                }

                                                                                public final void run() {
                                                                                    b.w(context, "RSA(base) fatal err, must recheck!!!");
                                                                                }
                                                                            });
                                                                            return;
                                                                        }
                                                                        Toast.makeText(context, "DefaultRSA check pass", 0).show();
                                                                        b.w(context, "");
                                                                    }
                                                                });
                                                            }
                                                        }
                                                    });
                                                    return true;
                                                } else if (str.startsWith("//dumpdefaultrsa")) {
                                                    return w(context, "");
                                                } else {
                                                    if (str.startsWith("//hardwareinfo")) {
                                                        ((com.tencent.mm.plugin.hardwareopt.a.a.a) com.tencent.mm.kernel.h.h(com.tencent.mm.plugin.hardwareopt.a.a.a.class)).eN(true);
                                                        return true;
                                                    }
                                                    com.tencent.mm.sdk.platformtools.w.d("MicroMsg.CommandProcessor", "processed : in ret:[%d]", Integer.valueOf(dK(str)));
                                                    switch (dK(str)) {
                                                        case 0:
                                                            return false;
                                                        case 568:
                                                            Assert.assertTrue("test errlog", false);
                                                            return true;
                                                        case 569:
                                                            ap.yY().xw();
                                                            return true;
                                                        case 570:
                                                            if (ba.RX(dL(str))) {
                                                                Toast.makeText(context, R.l.fbw, 0).show();
                                                            }
                                                            return true;
                                                        case 571:
                                                            str3 = dL(str);
                                                            ap.yY();
                                                            com.tencent.mm.u.c.vr().set(8195, str3);
                                                            return true;
                                                        case 572:
                                                            com.tencent.mm.sdk.platformtools.f.fuX = Integer.valueOf(dL(str)).intValue();
                                                            return true;
                                                        case 574:
                                                            StringBuilder append = new StringBuilder().append(com.tencent.mm.compatible.d.p.rA());
                                                            ap.yY();
                                                            com.tencent.mm.ui.base.g.z(context, com.tencent.mm.a.g.n(append.append(com.tencent.mm.u.c.uH()).toString().getBytes()), "md5");
                                                            return true;
                                                        case 579:
                                                            com.tencent.mm.u.ag.a.yI().J(dL(str), "");
                                                            return true;
                                                        case 580:
                                                            ap.vd().d(new com.tencent.mm.u.bb(new com.tencent.mm.u.bb.a() {
                                                                public final void a(com.tencent.mm.network.e eVar) {
                                                                    if (eVar != null) {
                                                                        com.tencent.mm.network.c Cc = eVar.Cc();
                                                                        byte[] bArr = new byte[0];
                                                                        ap.yY();
                                                                        Cc.i(bArr, com.tencent.mm.u.c.uH());
                                                                    }
                                                                }
                                                            }));
                                                            return true;
                                                        case 581:
                                                            an.aRq().Mc(dL(str));
                                                            return true;
                                                        case 582:
                                                            str3 = dL(str);
                                                            ap.yY();
                                                            r0 = com.tencent.mm.u.c.wR().Rc(str3);
                                                            if (r0 == null || r0.tJ() == 0) {
                                                                return false;
                                                            }
                                                            r0.tc();
                                                            com.tencent.mm.u.o.t(r0);
                                                            return true;
                                                        case 583:
                                                            ap.yY();
                                                            com.tencent.mm.u.c.xx();
                                                            return true;
                                                        case 584:
                                                        case 585:
                                                            com.tencent.mm.u.ba.gp(dL(str));
                                                            return true;
                                                        case 586:
                                                            r0 = str.split(" ");
                                                            if (r0 != null && r0.length == 3) {
                                                                t.aP(bg.getInt(r0[1], 0), bg.getInt(r0[2], 0));
                                                            }
                                                            return true;
                                                        case 587:
                                                            com.tencent.mm.sdk.b.a.urY.m(new com.tencent.mm.e.a.ce());
                                                            return true;
                                                        case 588:
                                                            com.tencent.mm.a.e.aS("/sdcard/tencent/MicroMsg/back");
                                                            ap.yY();
                                                            com.tencent.mm.sdk.platformtools.j.p(com.tencent.mm.u.c.xu(), "/sdcard/tencent/MicroMsg/back", false);
                                                            return true;
                                                        case 590:
                                                            return true;
                                                        case 591:
                                                            try {
                                                                r0 = str.split(" ");
                                                                if (r0 != null && r0.length > 1) {
                                                                    ap.yY().xA().k(com.tencent.mm.sdk.platformtools.bh.q(r0[0], "sysmsg"));
                                                                }
                                                            } catch (Throwable e522222222) {
                                                                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e522222222, "hy: error occured in commandProcessor", new Object[0]);
                                                            }
                                                            return true;
                                                        default:
                                                            return false;
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    public static boolean w(Context context, String str) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!bg.mA(str)) {
            stringBuffer.append(str + "\n\n");
        }
        stringBuffer.append("Default RSA Info:\n");
        stringBuffer.append("ClientVersion: " + com.tencent.mm.sdk.platformtools.e.CLIENT_VERSION + "\n");
        stringBuffer.append("BASE_RSA_PUBLIC_VERSION = 157\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYN = DFCA42006DB7133D885F1A96C5619061A164C450C2003DCD4DD6268A01C2EAD9A75441E7DE44C5D9FC0E17B85C07FF044F62387EE3224080F3C04C6441EC683FE7BC7D97F1115B720B240BBF62CA28004160B30951AE80C75DF5D7C67D2C2241D291550E68890914CAC9F575599570D26F58883E4685A50FAF2C6C2C85C03CE90D6DCC52AEA0960DFBC5A86344ECCD6F3D6B8C898EDA99A43FE3D5D2BA716AA67E947FB97C67F78B7B2BF349079D796E1B0B2F49143F7587A6A186D608065FDB6D238FF1F1BC34DF908D81E09AC37B5A5E9DA7AF468FBBF9BDD423B3FB884FAF3AE00F3E1C7E29FDCB6E95F44ACC12B06F30C672DF245E2FC0D5CE7347AC092B len(512" + ")\n");
        stringBuffer.append("BASE_RSA_PUBLIC_KEYE = 010001\n\n");
        stringBuffer.append("REQ_RSA_PUBLIC_VERSION = 158\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYN = E161DA03D0B6AAD21F9A4FB27C32A3208AF25A707BB0E8ECE79506FBBAF97519D9794B7E1B44D2C6F2588495C4E040303B4C915F172DD558A49552762CB28AB309C08152A8C55A4DFC6EA80D1F4D860190A8EE251DF8DECB9B083674D56CD956FF652C3C724B9F02BE5C7CBC63FC0124AA260D889A73E91292B6A02121D25AAA7C1A87752575C181FFB25A6282725B0C38A2AD57676E0884FE20CF56256E14529BC7E82CD1F4A1155984512BD273D68F769AF46E1B0E3053816D39EB1F0588384F2F4B286E5CFAFB4D0435BDF7D3AA8D3E0C45716EAD190FDC66884B275BA08D8ED94B1F84E7729C25BD014E7FA3A23123E10D3A93B4154452DDB9EE5F8DAB67 len(512" + ")\n");
        stringBuffer.append("REQ_RSA_PUBLIC_KEYE = 010001\n");
        com.tencent.mm.sdk.platformtools.w.i("MicroMsg.CommandProcessor", "summercert dumpdefaultrsa " + stringBuffer.toString());
        if (!com.tencent.mm.sdk.a.b.bIu()) {
            return false;
        }
        View textView = new TextView(context);
        textView.setText(stringBuffer.toString());
        textView.setGravity(19);
        textView.setTextSize(1, 10.0f);
        textView.setLayoutParams(new LayoutParams(-1, -2));
        textView.setTextColor(-16711936);
        textView.setTypeface(Typeface.MONOSPACE);
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R.f.aXV);
        textView.setPadding(dimensionPixelSize, dimensionPixelSize, dimensionPixelSize, dimensionPixelSize);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        com.tencent.mm.ui.base.g.a(context, null, textView, null);
        if (!ac.bHw()) {
            return true;
        }
        Toast.makeText(context, "dump file:" + com.tencent.mm.compatible.util.e.hgu + "DefaultRSA.java", 1).show();
        return true;
    }

    private static StringBuilder ev(int i) {
        Throwable e;
        Date date = new Date(bg.Nz() - (((long) i) * 86400000));
        String str = com.tencent.mm.compatible.util.e.hgv + "crash_" + new SimpleDateFormat("yyyyMMdd", Locale.getDefault()).format(date) + ".txt";
        StringBuilder stringBuilder = new StringBuilder();
        if (!new File(str).exists()) {
            return new StringBuilder(" day -" + i + " no crash.");
        }
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(str)));
            try {
                if (bg.mA(bufferedReader.readLine())) {
                    bufferedReader.close();
                    StringBuilder stringBuilder2 = new StringBuilder("read day -" + i + "file failed");
                    try {
                        bufferedReader.close();
                        return stringBuilder2;
                    } catch (Exception e2) {
                        return stringBuilder2;
                    }
                }
                while (true) {
                    str = bufferedReader.readLine();
                    if (str != null) {
                        stringBuilder.append(new String(Base64.decode(str.split("error_")[1], 0)).split("#accinfo.uin=")[1]);
                        stringBuilder.append("\n_____________________________________\n");
                    } else {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    }
                }
                bufferedReader.close();
                return stringBuilder;
            } catch (Exception e4) {
                e = e4;
            }
        } catch (Exception e5) {
            e = e5;
            bufferedReader = null;
            try {
                com.tencent.mm.sdk.platformtools.w.printErrStackTrace("MicroMsg.CommandProcessor", e, "", new Object[0]);
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e6) {
                    }
                }
                return stringBuilder;
            } catch (Throwable th) {
                e = th;
                if (bufferedReader != null) {
                    try {
                        bufferedReader.close();
                    } catch (Exception e7) {
                    }
                }
                throw e;
            }
        } catch (Throwable th2) {
            e = th2;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            throw e;
        }
    }

    private static void ew(int i) {
        SharedPreferences ba = al.ba(ab.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                ba.edit().remove("st_sw_use_vcodec_img").commit();
                return;
            case 0:
                ba.edit().putBoolean("st_sw_use_vcodec_img", false).commit();
                return;
            case 1:
                ba.edit().putBoolean("st_sw_use_vcodec_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }

    private static void ex(int i) {
        SharedPreferences ba = al.ba(ab.getContext(), "sp_sns_dynswitch_stg");
        switch (i) {
            case -1:
                ba.edit().remove("st_sw_use_wxpc_img").commit();
                return;
            case 0:
                ba.edit().putBoolean("st_sw_use_wxpc_img", false).commit();
                return;
            case 1:
                ba.edit().putBoolean("st_sw_use_wxpc_img", true).commit();
                return;
            default:
                throw new IllegalArgumentException("Bad op parameter: " + i);
        }
    }
}
