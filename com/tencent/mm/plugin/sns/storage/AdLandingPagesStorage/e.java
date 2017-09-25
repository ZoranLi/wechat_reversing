package com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.WindowManager;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.sns.model.ae;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.b;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.u;
import com.tencent.mm.plugin.sns.ui.SnsAdNativeLandingPagesUI;
import com.tencent.mm.protocal.c.alh;
import com.tencent.mm.protocal.c.bfc;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.u.c.c;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.smtt.sdk.WebView;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

public final class e {
    public static int qmB = 750;
    public static int qmC = 10;
    private static Set<a> qmD = null;

    private static class a {
        public int qmE;
        public int qmF;
        public int qmG;

        public final boolean equals(Object obj) {
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            if (aVar.qmE == this.qmE && aVar.qmF == this.qmF && aVar.qmG == this.qmG) {
                return true;
            }
            return false;
        }

        public final int hashCode() {
            return (this.qmE + this.qmF) + this.qmG;
        }

        public final String toString() {
            return "[nodeType=" + this.qmE + ",compType=" + this.qmF + ",subCompType=" + this.qmG + "]";
        }
    }

    private static boolean tz(int i) {
        if (i == 101 || i == 103) {
            return false;
        }
        return true;
    }

    private static boolean tA(int i) {
        if (i == 103) {
            return true;
        }
        return false;
    }

    public static float a(double d, int i, int i2, int i3) {
        if (i == 0) {
            return (float) d;
        }
        if (i2 == 0) {
            return (float) d;
        }
        float width = (((float) ((WindowManager) ab.getContext().getSystemService("window")).getDefaultDisplay().getWidth()) * (((float) d) * ((float) i3))) / ((float) i2);
        int i4 = (int) width;
        if (((double) (width - ((float) i4))) > 0.001d) {
            i4++;
        }
        return (float) i4;
    }

    private static p a(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        p pVar;
        int PY = bg.PY((String) map.get(str + ".type"));
        int PY2 = bg.PY((String) map.get(str + ".subType"));
        p rVar;
        switch (PY) {
            case 1:
                rVar = new r();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.qgb = bg.ap((String) map.get(str + ".content"), "");
                rVar.textAlignment = bg.PY((String) map.get(str + ".textAlignment"));
                rVar.qgc = bg.ap((String) map.get(str + ".fontColor"), "");
                rVar.hbf = a(bg.Qa((String) map.get(str + ".fontSize")), i, i2, i3);
                rVar.qgd = (bg.PY((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & r.qfY) > 0;
                rVar.qge = (bg.PY((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & r.qfZ) > 0;
                rVar.qgf = (bg.PY((String) map.get(new StringBuilder().append(str).append(".showType").toString())) & r.qga) > 0;
                rVar.maxLines = bg.PY((String) map.get(str + ".maxLines"));
                pVar = rVar;
                break;
            case 21:
                if (PY2 == 2) {
                    rVar = new b();
                    rVar.fTO = (String) map.get(str + ".appid");
                    rVar.qfd = (String) map.get(str + ".appPageUrl");
                    rVar.channelId = (String) map.get(str + ".channelId");
                    rVar.uq = (String) map.get(str + ".pkg");
                    rVar.qfb = bg.PY((String) map.get(str + ".platform"));
                    rVar.qfc = (String) map.get(str + ".warningAndroid");
                } else if (PY2 == 4) {
                    rVar = new f();
                    rVar.kez = bg.ap((String) map.get(str + ".cardTpId"), "");
                    rVar.kfp = bg.ap((String) map.get(str + ".cardExt"), "");
                } else if (PY2 == 7) {
                    rVar = new h();
                    rVar.qfk = bg.PZ((String) map.get(str + ".jumpCanvasId"));
                } else {
                    rVar = new i();
                }
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.title = bg.ap((String) map.get(str + ".btnTitle"), "");
                rVar.qfl = bg.PY((String) map.get(str + ".btnType"));
                rVar.qfm = bg.ap((String) map.get(str + ".btnJumpUrl"), "");
                rVar.qfn = bg.ap((String) map.get(str + ".btnJumpApp"), "");
                rVar.qfo = bg.ap((String) map.get(str + ".fontColor"), "");
                rVar.qfp = a(bg.Qa((String) map.get(str + ".fontSize")), i, i2, i3);
                rVar.textAlignment = bg.PY((String) map.get(str + ".btnAlignment"));
                rVar.qfq = a(bg.Qa((String) map.get(str + ".borderSize")), i, i2, i3);
                rVar.height = a(bg.Qa((String) map.get(str + ".btnHeight")), i, i2, i3);
                rVar.qfr = bg.ap((String) map.get(str + ".btnBgColorTheme"), "");
                rVar.qfs = bg.ap((String) map.get(str + ".btnBorderColorTheme"), "");
                rVar.qft = bg.ap((String) map.get(str + ".btnBgImgUrl"), "");
                pVar = rVar;
                break;
            case v.CTRL_BYTE /*41*/:
                rVar = new m();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.qfy = bg.ap((String) map.get(str + ".pureImageUrl"), "");
                rVar.width = a(bg.Qa((String) map.get(str + ".imageWidth")), i, i2, i3);
                rVar.height = a(bg.Qa((String) map.get(str + ".imageHeight")), i, i2, i3);
                rVar.qfv = false;
                pVar = rVar;
                break;
            case 44:
                rVar = new l();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.qfy = bg.ap((String) map.get(str + ".panoramaImageUrl"), "");
                rVar.width = a(bg.Qa((String) map.get(str + ".imageWidth")), i, i2, i3);
                rVar.height = a(bg.Qa((String) map.get(str + ".imageHeight")), i, i2, i3);
                pVar = rVar;
                break;
            case 45:
                rVar = new m();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.qfy = bg.ap((String) map.get(str + ".fullScreenImageUrl"), "");
                rVar.qfv = true;
                pVar = rVar;
                break;
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                rVar = new n();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.qfz = bg.ap((String) map.get(str + ".sightVideoUrl"), "");
                rVar.qfA = bg.ap((String) map.get(str + ".sightThumbUrl"), "");
                rVar.qfB = bg.ap((String) map.get(str + ".streamVideoUrl"), "");
                rVar.qfC = bg.ap((String) map.get(str + ".jumpText"), "");
                try {
                    rVar.qfD = Color.parseColor((String) map.get(str + ".jumpTextColor"));
                } catch (Exception e) {
                    rVar.qfD = Color.rgb(255, 255, 255);
                }
                try {
                    rVar.qfE = Color.parseColor((String) map.get(str + ".separatorColor"));
                } catch (Exception e2) {
                    rVar.qfE = Color.rgb(255, 255, 255);
                }
                rVar.width = a(bg.Qa((String) map.get(str + ".sightDisplayWidth")), i, i2, i3);
                rVar.height = a(bg.Qa((String) map.get(str + ".sightDisplayHeight")), i, i2, i3);
                rVar.qfF = bg.PY((String) map.get(str + ".sightDisplayType"));
                pVar = rVar;
                break;
            case 62:
                rVar = new t();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.qfB = bg.ap((String) map.get(str + ".streamVideoUrl"), "");
                rVar.qgg = bg.ap((String) map.get(str + ".streamVideoThumb"), "");
                rVar.width = a(bg.Qa((String) map.get(str + ".streamDisplayWidth")), i, i2, i3);
                rVar.height = a(bg.Qa((String) map.get(str + ".streamDisplayHeight")), i, i2, i3);
                rVar.qgh = bg.PY((String) map.get(str + ".streamDisplayType"));
                pVar = rVar;
                break;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                rVar = new s();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.mER = bg.ap((String) map.get(str + ".webviewUrl"), "");
                pVar = rVar;
                break;
            case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                rVar = new u();
                rVar.url = bg.ap((String) map.get(str + ".webviewUrl"), "");
                pVar = rVar;
                break;
            case 102:
                pVar = c(map, str, i, i2, i3, i4);
                break;
            case 104:
                List b = b(map, str, i, i2, i3, i4);
                pVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.e();
                pVar.qfi = b;
                break;
            case 121:
            case 122:
                int argb;
                double a = (double) a(bg.Qa((String) map.get(str + ".topLineSize")), i, i2, i3);
                double a2 = (double) a(bg.Qa((String) map.get(str + ".bottomLineSize")), i, i2, i3);
                if (tB(i4)) {
                    argb = Color.argb(51, 0, 0, 0);
                } else {
                    argb = Color.argb(51, 255, 255, 255);
                }
                if (PY != 121) {
                    if (PY != 122) {
                        pVar = null;
                        break;
                    }
                    String str2 = str + ".phoneNumList.phoneNum";
                    List arrayList = new ArrayList();
                    int i5 = 0;
                    while (true) {
                        CharSequence charSequence;
                        if (i5 == 0) {
                            charSequence = (String) map.get(str2);
                        } else {
                            String str3 = (String) map.get(str2 + i5);
                        }
                        if (!TextUtils.isEmpty(charSequence)) {
                            arrayList.add(charSequence);
                            i5++;
                        } else if (!arrayList.isEmpty()) {
                            pVar = new d(a, a2, argb, arrayList);
                            break;
                        } else {
                            return null;
                        }
                    }
                }
                double Qa = bg.Qa((String) map.get(str + ".location.$x"));
                double Qa2 = bg.Qa((String) map.get(str + ".location.$y"));
                int PY3 = bg.PY((String) map.get(str + ".location.$scale"));
                String str4 = (String) map.get(str + ".location.$label");
                String str5 = (String) map.get(str + ".location.$poiname");
                if (!TextUtils.isEmpty(str4) || !TextUtils.isEmpty(str5)) {
                    p gVar = new g(a, a2, new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g.a(Qa, Qa2, PY3, str4, str5), argb);
                    break;
                }
                return null;
                break;
            case 131:
                rVar = new q();
                rVar.qfJ = PY;
                rVar.fEC = PY2;
                rVar.label = bg.ap((String) map.get(str + ".label"), "");
                rVar.value = (float) bg.Qa((String) map.get(str + ".value"));
                rVar.qfX = bg.ap((String) map.get(str + ".foregroundImage"), "");
                rVar.qfp = a(bg.Qa((String) map.get(str + ".fontSize")), i, i2, i3);
                rVar.iDX = bg.ap((String) map.get(str + ".backgroundColor"), "");
                pVar = rVar;
                break;
            case 132:
                pVar = a(map, str, i, i2, i3);
                break;
            default:
                return null;
        }
        if (pVar == null) {
            return pVar;
        }
        pVar.qfQ = tB(i4);
        pVar.type = PY;
        pVar.fEC = PY2;
        a(pVar, (Map) map, str, i, i2, i3);
        return pVar;
    }

    private static com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v a(Map<String, String> map, String str, int i, int i2, int i3) {
        com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v vVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v();
        try {
            String str2 = str + ".radarChart";
            vVar.qgi = (String) map.get(str2 + ".borderImg");
            vVar.qgp = (String) map.get(str2 + ".maskImg");
            vVar.qgk = (String) map.get(str2 + ".coverColor");
            vVar.qgl = Color.parseColor((String) map.get(str2 + ".labelFont.$color"));
            vVar.qgm = (int) a(bg.Qa((String) map.get(str2 + ".labelFont.$size")), i, i2, i3);
            vVar.qgn = Color.parseColor((String) map.get(str2 + ".scoreFont.$color"));
            vVar.qgo = (int) a(bg.Qa((String) map.get(str2 + ".scoreFont.$size")), i, i2, i3);
            vVar.qgj = a(bg.Qa((String) map.get(str2 + ".borderImgWidth")), i, i2, i3);
            String str3 = str2 + ".itemList.item";
            int i4 = 0;
            while (true) {
                if (i4 != 0) {
                    str2 = str3 + i4;
                } else {
                    str2 = str3;
                }
                com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v.a aVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.v.a();
                aVar.label = (String) map.get(str2 + ".label");
                aVar.qgq = (String) map.get(str2 + ".score");
                aVar.value = (float) bg.Qa((String) map.get(str2 + ".value"));
                if (TextUtils.isEmpty(aVar.label) && TextUtils.isEmpty(aVar.qgq)) {
                    break;
                }
                vVar.pcf.add(aVar);
                i4++;
            }
        } catch (Throwable e) {
            w.e("AdLandingPagesParseHelper", bg.g(e));
        }
        return vVar;
    }

    private static List<p> b(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        List<p> arrayList = new ArrayList();
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            p a = a((Map) map, i, i3, i2, i4, str3);
            if (a == null) {
                return arrayList;
            }
            if (a.qfT) {
                arrayList.add(a);
            } else {
                w.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
            }
            i5++;
        }
    }

    private static j c(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        j jVar = new j();
        try {
            int parseColor = Color.parseColor((String) map.get(str + ".bgColorTheme"));
            jVar.backgroundColor = (((int) (bg.getDouble((String) map.get(str + ".bgColorAlpha"), 0.0d) * 255.0d)) << 24) | (parseColor & 16777215);
        } catch (Throwable e) {
            w.e("AdLandingPagesParseHelper", "%s", new Object[]{bg.g(e)});
            jVar.backgroundColor = Color.argb(51, 0, 0, 0);
        }
        String str2 = (str + ".componentGroupList") + ".componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            parseColor = bg.PY((String) map.get(str3 + ".type"));
            p pVar = null;
            if (tz(parseColor)) {
                pVar = a((Map) map, str3, i, i2, i3, i4);
            }
            if (pVar == null) {
                return jVar;
            }
            if (pVar.qfT) {
                jVar.qfu.add(pVar);
            }
            i5++;
        }
    }

    private static k d(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        p kVar = new k();
        a(kVar, (Map) map, str, i, i2, i3);
        kVar.qfw = bg.PY((String) map.get(str + ".pageCtrType"));
        kVar.qfx = bg.PY((String) map.get(new StringBuilder().append(str).append(".isFullScreen").toString())) == 1;
        String str2 = str + ".componentGroupList.componentGroup";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            j jVar = new j();
            String str4 = str3 + ".componentItem";
            int i6 = 0;
            while (true) {
                String str5;
                if (i6 == 0) {
                    str5 = str4;
                } else {
                    str5 = str4 + i6;
                }
                int PY = bg.PY((String) map.get(str5 + ".type"));
                p pVar = null;
                if (tz(PY)) {
                    pVar = a((Map) map, str5, i, i2, i3, i4);
                }
                if (pVar == null) {
                    break;
                }
                if (pVar.qfT) {
                    jVar.qfu.add(pVar);
                }
                i6++;
            }
            if (jVar.qfu.size() == 0) {
                return kVar;
            }
            kVar.qfu.add(jVar);
            i5++;
        }
    }

    private static void a(p pVar, Map<String, String> map, String str, int i, int i2, int i3) {
        boolean z = true;
        pVar.qfJ = bg.PY((String) map.get(str + ".type"));
        pVar.type = pVar.qfJ;
        pVar.qfI = bg.ap((String) map.get(str + ".id"), "");
        pVar.qfK = a(bg.Qa((String) map.get(str + ".paddingTop")), i, i2, i3);
        pVar.qfL = a(bg.Qa((String) map.get(str + ".paddingBottom")), i, i2, i3);
        pVar.qfM = a(bg.Qa((String) map.get(str + ".paddingLeft")), i, i2, i3);
        pVar.qfN = a(bg.Qa((String) map.get(str + ".paddingRight")), i, i2, i3);
        pVar.fEC = bg.PY((String) map.get(str + ".subType"));
        String str2 = str + ".if";
        if (map.containsKey(str2)) {
            pVar.qfT = "1".equals(map.get(str2));
        } else {
            pVar.qfT = true;
        }
        str2 = str + ".noReport";
        if (map.containsKey(str2)) {
            if (!"1".equals(map.get(str2))) {
                z = false;
            }
            pVar.qfU = z;
        } else {
            pVar.qfU = false;
        }
        Object ap = bg.ap((String) map.get(str + ".layoutWidth"), "");
        Object ap2 = bg.ap((String) map.get(str + ".layoutHeight"), "");
        if (TextUtils.isEmpty(ap)) {
            pVar.qfO = 2.14748365E9f;
        } else {
            double Qa = bg.Qa(ap);
            if (Qa < 0.0d) {
                pVar.qfO = (float) Qa;
            } else {
                pVar.qfO = a(Qa, i, i2, i3);
            }
        }
        if (TextUtils.isEmpty(ap2)) {
            pVar.qfP = 2.14748365E9f;
        } else {
            double Qa2 = bg.Qa(ap2);
            if (Qa2 < 0.0d) {
                pVar.qfP = (float) Qa2;
            } else {
                pVar.qfP = a(Qa2, i, i2, i3);
            }
        }
        str2 = (String) map.get(str + ".verticalAlignment");
        String str3 = (String) map.get(str + ".horizontalAlignment");
        if (TextUtils.isEmpty(str2)) {
            pVar.qfR = -1;
        } else {
            pVar.qfR = bg.PY(str2);
        }
        if (TextUtils.isEmpty(str3)) {
            pVar.qfS = -1;
        } else {
            pVar.qfS = bg.PY(str3);
        }
    }

    private static p e(Map<String, String> map, String str, int i, int i2, int i3, int i4) {
        p oVar = new o();
        oVar.qfH = bg.PY((String) map.get(str + ".subType"));
        a(oVar, (Map) map, str, i, i2, i3);
        String str2 = str + ".layoutItems.componentItem";
        int i5 = 0;
        while (true) {
            String str3;
            if (i5 == 0) {
                str3 = str2;
            } else {
                str3 = str2 + i5;
            }
            int PY = bg.PY((String) map.get(str3 + ".type"));
            p pVar = null;
            if (tz(PY)) {
                pVar = a((Map) map, str3, i, i2, i3, i4);
            } else if (tA(PY)) {
                pVar = e(map, str3, i, i2, i3, i4);
            }
            if (pVar == null) {
                return oVar;
            }
            if (pVar.qfT) {
                oVar.qfG.add(pVar);
            }
            i5++;
        }
    }

    public static LinkedList<c> k(String str, String str2, String str3, String str4) {
        LinkedList<c> linkedList = new LinkedList();
        if (TextUtils.isEmpty(str)) {
            return linkedList;
        }
        String str5 = "";
        if (!TextUtils.isEmpty(str)) {
            str = str.replaceAll("\\{\\{.*?\\}\\}", str5);
        }
        Map q = bh.q(str, str2);
        if (q == null) {
            w.w("AdLandingPagesParseHelper", " parse landingpages xml is error ," + str);
            return linkedList;
        }
        int i;
        String str6;
        int PY = bg.PY((String) q.get("." + str2 + ".adCanvasInfo.sizeType"));
        int PY2 = bg.PY((String) q.get("." + str2 + ".adCanvasInfo.basicRootFontSize"));
        int PY3 = bg.PY((String) q.get("." + str2 + ".adCanvasInfo.basicWidth"));
        if (PY2 == 0 && PY == 1) {
            i = qmC;
        } else {
            i = PY2;
        }
        if (PY3 == 0 && PY == 1) {
            PY3 = qmB;
        }
        String str7 = ".adCanvasInfo.PageList.Page";
        if (bg.mA(str2) || str7.equals("adCanvasInfo")) {
            str6 = str7;
        } else {
            str6 = "." + str2 + str7;
        }
        int i2 = 0;
        while (true) {
            String str8;
            if (i2 == 0) {
                str8 = str6;
            } else {
                str8 = str6 + i2;
            }
            c cVar = new c();
            cVar.qmq = bg.ap((String) q.get(str8 + ".backgroundCover"), "");
            cVar.iDX = bg.ap((String) q.get(str8 + ".backgroundColor"), "");
            cVar.qmr = bg.PY((String) q.get(new StringBuilder().append(str8).append(".backgroundCover.$isAddBlur").toString())) > 0;
            cVar.id = i2;
            str7 = str8 + ".if";
            if (q.containsKey(str7)) {
                cVar.qfT = "1".equals(q.get(str7));
            } else {
                cVar.qfT = true;
            }
            if (cVar.qfT) {
                String str9 = str8 + ".componentItemList.componentItem";
                int i3 = 0;
                while (true) {
                    p a;
                    if (i3 == 0) {
                        str8 = str9;
                    } else {
                        str8 = str9 + i3;
                    }
                    try {
                        a = a(q, PY, i, PY3, !TextUtils.isEmpty(cVar.iDX) ? Color.parseColor(cVar.iDX) : 0, str8);
                    } catch (Throwable e) {
                        w.e("AdLandingPagesParseHelper", bg.g(e));
                        a = a(q, PY, i, PY3, 0, str8);
                    }
                    if (a == null) {
                        break;
                    }
                    if (a.qfT) {
                        if (a.type == 21) {
                            ((i) a).qdW = str4;
                            ((i) a).qdX = str3;
                        }
                        a(a, q, str8, PY, PY3, i);
                        cVar.qms.add(a);
                    } else {
                        w.i("AdLandingPagesParseHelper", "comp " + a.toString() + " ifCondition is false");
                    }
                    i3++;
                }
                if (cVar.qms.size() == 0) {
                    break;
                }
                linkedList.add(cVar);
            }
            i2++;
        }
        if (linkedList.size() > 0) {
            ((c) linkedList.get(0)).qmt = true;
        }
        return linkedList;
    }

    private static p a(Map<String, String> map, int i, int i2, int i3, int i4, String str) {
        int PY = bg.PY((String) map.get(str + ".type"));
        if (tz(PY)) {
            try {
                return a((Map) map, str, i, i3, i2, i4);
            } catch (Exception e) {
                return a((Map) map, str, i, i3, i2, 0);
            }
        }
        Object obj;
        if (PY == 101) {
            obj = 1;
        } else {
            obj = null;
        }
        if (obj != null) {
            return d(map, str, i, i3, i2, i4);
        }
        if (tA(PY)) {
            return e(map, str, i, i3, i2, i4);
        }
        w.e("AdLandingPagesParseHelper", "the type" + PY + " is not client known type");
        return null;
    }

    public static LinkedList<c> c(String str, String str2, String str3, String str4, String str5) {
        String str6 = new String(str);
        try {
            JSONObject jSONObject = new JSONObject(str3);
            w.i("AdLandingPagesParseHelper", "the jsonObject is " + jSONObject.toString());
            Iterator keys = jSONObject.keys();
            while (keys.hasNext()) {
                String str7;
                Object next = keys.next();
                if (next != null && (next instanceof String)) {
                    str7 = (String) next;
                    String string = jSONObject.getString(str7);
                    if (!bg.mA(string)) {
                        str7 = str6.replace("{{" + str7 + "}}", "<![CDATA[" + string + "]]>");
                        str6 = str7;
                    }
                }
                str7 = str6;
                str6 = str7;
            }
        } catch (Exception e) {
            w.e("AdLandingPagesParseHelper", "the json is parsed error : " + str);
        }
        return k(str6, str2, str4, str5);
    }

    private static boolean tB(int i) {
        int i2 = i | WebView.NIGHT_MODE_COLOR;
        return i2 - WebView.NIGHT_MODE_COLOR > -1 - i2;
    }

    private static boolean Ga(String str) {
        return bg.PY(bg.ap((String) bh.q(str, "adCanvasInfo").get(".adCanvasInfo.bizId"), "")) == 1;
    }

    private static boolean b(String str, Context context, boolean z, int i) {
        String str2 = (String) bh.q(str, "adCanvasInfo").get(".adCanvasInfo.shareWebUrl");
        if (TextUtils.isEmpty(str2)) {
            return false;
        }
        if (z) {
            try {
                str2 = k(str2, "exp=" + c.AA().getExpIdByKey("Sns_Canvas_GameShare_JumpWay") + "_" + i);
            } catch (URISyntaxException e) {
            }
            w.i("AdLandingPagesParseHelper", "canvas jump url " + str2);
        }
        Intent intent = new Intent();
        intent.putExtra("rawUrl", str2);
        intent.putExtra("showShare", true);
        com.tencent.mm.bb.d.b(context, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }

    private static String k(String str, String... strArr) {
        URI uri = new URI(str);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i <= 0; i++) {
            stringBuilder.append(strArr[0]).append("&");
        }
        if (stringBuilder.length() <= 1) {
            return str;
        }
        String stringBuilder2;
        StringBuilder deleteCharAt = stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        String query = uri.getQuery();
        if (query == null) {
            stringBuilder2 = deleteCharAt.toString();
        } else {
            stringBuilder2 = query + "&" + deleteCharAt.toString();
        }
        return new URI(uri.getScheme(), uri.getAuthority(), uri.getPath(), stringBuilder2, uri.getFragment()).toString();
    }

    private static boolean bgW() {
        com.tencent.mm.storage.c dX = c.Az().dX("100150");
        if (!dX.isValid()) {
            return false;
        }
        int i = bg.getInt((String) dX.bKK().get("openCanvas"), 0);
        w.i("AdLandingPagesParseHelper", "canOpenGameCanvas abtest=" + i);
        if (i == 1) {
            return true;
        }
        return false;
    }

    public static boolean A(Intent intent, Context context) {
        int i = 0;
        String stringExtra = intent.getStringExtra("sns_landing_pages_xml");
        if (!TextUtils.isEmpty(stringExtra)) {
            if (TextUtils.isEmpty(stringExtra) || !Gb(stringExtra)) {
                w.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{stringExtra});
            } else {
                String str = "";
                boolean Ga = Ga(stringExtra);
                if (Ga) {
                    str = c.AA().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    if (TextUtils.isEmpty(str)) {
                        i = bgW();
                    } else {
                        int cF = c.AA().cF("Sns_Canvas_GameShare_JumpWay", 0);
                        w.i("AdLandingPagesParseHelper", "abtestvalue = " + cF);
                        if (cF != 0) {
                            i = 1;
                        }
                    }
                } else {
                    i = 1;
                }
                if (i == 0) {
                    return b(stringExtra, context, Ga, intent.getIntExtra("sns_landig_pages_from_source", -1));
                }
                Intent intent2 = new Intent(intent);
                intent2.setClass(context, SnsAdNativeLandingPagesUI.class);
                intent2.putExtra("sns_landing_pages_expid", str);
                context.startActivity(intent2);
                return true;
            }
        }
        return false;
    }

    public static boolean a(bfc com_tencent_mm_protocal_c_bfc, Activity activity) {
        String str = com_tencent_mm_protocal_c_bfc.qsQ;
        long longValue = new BigInteger(com_tencent_mm_protocal_c_bfc.mQY).longValue();
        List list = com_tencent_mm_protocal_c_bfc.ufB.tsO;
        if (!TextUtils.isEmpty(str)) {
            if (TextUtils.isEmpty(str) || !Gb(str)) {
                w.i("AdLandingPagesParseHelper", "invalid canvas xml %s", new Object[]{str});
            } else {
                String expIdByKey;
                boolean z;
                String str2 = "";
                boolean Ga = Ga(str);
                if (Ga) {
                    expIdByKey = c.AA().getExpIdByKey("Sns_Canvas_GameShare_JumpWay");
                    z = c.AA().cF("Sns_Canvas_GameShare_JumpWay", 0) != 0;
                    if (!z && bgW()) {
                        z = true;
                    }
                } else {
                    expIdByKey = str2;
                    z = true;
                }
                if (z) {
                    com.tencent.mm.plugin.sns.storage.m dG = ae.beL().dG(longValue);
                    Intent intent = new Intent();
                    if (dG != null) {
                        intent.putExtra("sns_landing_pages_share_sns_id", dG.bhe());
                        intent.putExtra("sns_landing_pages_ux_info", dG.bhI());
                        intent.putExtra("sns_landing_pages_aid", dG.bhD());
                        intent.putExtra("sns_landing_pages_traceid", dG.bhE());
                    }
                    if (list != null && list.size() > 0) {
                        intent.putExtra("sns_landing_pages_share_thumb_url", ((alh) list.get(0)).tPi);
                    }
                    intent.putExtra("sns_landing_pages_expid", expIdByKey);
                    intent.putExtra("sns_landig_pages_from_source", 11);
                    intent.setClass(activity, SnsAdNativeLandingPagesUI.class);
                    intent.putExtra("sns_landing_pages_xml", str);
                    intent.putExtra("sns_landing_pages_xml_prefix", "adxml");
                    intent.putExtra("sns_landing_pages_need_enter_and_exit_animation", false);
                    activity.startActivity(intent);
                    return true;
                }
                b(str, activity, Ga, 11);
            }
        }
        return false;
    }

    public static boolean Gb(String str) {
        InputStream inputStream = null;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String name;
        if (qmD == null && qmD == null) {
            qmD = new HashSet();
            try {
                inputStream = ab.getContext().getAssets().open("sns/canvas_valid_type.xml");
                XmlPullParser newPullParser = XmlPullParserFactory.newInstance().newPullParser();
                newPullParser.setInput(inputStream, "UTF-8");
                int i = -1;
                int eventType = newPullParser.getEventType();
                int i2 = -1;
                while (eventType != 1) {
                    int i3;
                    if (eventType == 2) {
                        boolean z;
                        name = newPullParser.getName();
                        if ("canvastype".equals(name)) {
                            eventType = 0;
                            z = false;
                        } else if ("pagetype".equals(name)) {
                            eventType = 1;
                            z = true;
                        } else if ("componenttype".equals(name)) {
                            eventType = 2;
                            z = true;
                        } else if ("subtype".equals(name)) {
                            z = true;
                            eventType = i2;
                        } else {
                            eventType = i2;
                            z = true;
                        }
                        if (!z) {
                            i2 = bg.getInt(newPullParser.getAttributeValue(null, "android"), 0) == 1 ? bg.getInt(newPullParser.getAttributeValue(null, "val"), -1) : -1;
                            switch (z) {
                                case false:
                                case true:
                                case true:
                                    i = eventType;
                                    continue;
                                case true:
                                    if (!(eventType == -1 || i == -1 || i2 == -1)) {
                                        a aVar = new a();
                                        aVar.qmE = eventType;
                                        aVar.qmF = i;
                                        aVar.qmG = i2;
                                        qmD.add(aVar);
                                        w.i("AdLandingPagesParseHelper", "valid canvas type " + aVar);
                                        break;
                                    }
                            }
                        }
                        i2 = i;
                        i = eventType;
                    } else {
                        i3 = i;
                        i = i2;
                        i2 = i3;
                    }
                    eventType = newPullParser.next();
                    i3 = i2;
                    i2 = i;
                    i = i3;
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {
                    }
                }
            } catch (Throwable e2) {
                w.e("AdLandingPagesParseHelper", bg.g(e2));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e3) {
                    }
                }
            } catch (Throwable e22) {
                w.e("AdLandingPagesParseHelper", bg.g(e22));
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e4) {
                    }
                }
            } catch (Throwable th) {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e5) {
                    }
                }
            }
        }
        if (qmD == null || qmD.isEmpty()) {
            return false;
        }
        Map q = bh.q(str, "adCanvasInfo");
        if (q == null || q.isEmpty()) {
            w.w("AdLandingPagesParseHelper", "invalid landingpages xml," + str);
            return false;
        }
        a aVar2 = new a();
        aVar2.qmE = 0;
        aVar2.qmF = bg.PY((String) q.get(".adCanvasInfo.type"));
        aVar2.qmG = bg.PY((String) q.get(".adCanvasInfo.subtype"));
        if (qmD.contains(aVar2)) {
            name = ".adCanvasInfo.PageList.Page";
            int i4 = 0;
            while (true) {
                String str2;
                aVar2.qmE = 1;
                if (i4 == 0) {
                    str2 = name;
                } else {
                    str2 = name + i4;
                }
                if (!q.containsKey(str2 + ".componentItemList.componentItem.type")) {
                    return true;
                }
                aVar2.qmF = bg.PY((String) q.get(str2 + ".type"));
                aVar2.qmG = bg.PY((String) q.get(str2 + ".subType"));
                if (qmD.contains(aVar2)) {
                    String str3 = str2 + ".componentItemList.componentItem";
                    aVar2.qmE = 2;
                    int i5 = 0;
                    while (true) {
                        if (i5 == 0) {
                            str2 = str3;
                        } else {
                            str2 = str3 + i5;
                        }
                        if (q.containsKey(str2 + ".type")) {
                            aVar2.qmF = bg.PY((String) q.get(str2 + ".type"));
                            aVar2.qmG = bg.PY((String) q.get(str2 + ".subType"));
                            if (qmD.contains(aVar2)) {
                                i5++;
                            } else {
                                w.i("AdLandingPagesParseHelper", "invalid component type " + aVar2);
                                return false;
                            }
                        }
                        i4++;
                    }
                } else {
                    w.i("AdLandingPagesParseHelper", "invalid page type " + aVar2);
                    return false;
                }
            }
        }
        w.i("AdLandingPagesParseHelper", "invalid canvas type " + aVar2);
        return false;
    }

    public static String w(com.tencent.mm.plugin.sns.storage.m mVar) {
        if (mVar == null) {
            w.e("AdLandingPagesParseHelper", "the snsinfo is null");
            return null;
        } else if (mVar.tE(32)) {
            com.tencent.mm.plugin.sns.storage.e bhJ = mVar.bhJ();
            if (bhJ == null) {
                w.e("AdLandingPagesParseHelper", "the adSnsInfo is null");
                return null;
            }
            com.tencent.mm.plugin.sns.storage.b bha = mVar.bha();
            if (bha == null) {
                w.e("AdLandingPagesParseHelper", "the adxml is null");
                return null;
            }
            com.tencent.mm.plugin.sns.storage.a bhc = mVar.bhc();
            if (bhc == null) {
                w.e("AdLandingPagesParseHelper", "the adInfo is null");
                return null;
            } else if (!bha.qdV) {
                w.e("AdLandingPagesParseHelper", "the snsinfo is not a landingpage");
                return null;
            } else if (bhc.qdY == null || bhc.qdY.size() == 0) {
                w.e("AdLandingPagesParseHelper", "the mappedCanvasCardExt is empty");
                return null;
            } else {
                String str = bhJ.field_adxml;
                LinkedList k = k(str, "adxml", "adId", "");
                String str2 = str;
                for (String str3 : bhc.qdY.keySet()) {
                    if (!bg.mA(str3)) {
                        String str4 = (String) bhc.qdY.get(str3);
                        if (!bg.mA(str4)) {
                            String str5;
                            Iterator it = k.iterator();
                            String str6 = null;
                            while (it.hasNext()) {
                                Iterator it2 = ((c) it.next()).qms.iterator();
                                while (it2.hasNext()) {
                                    p pVar = (p) it2.next();
                                    if ((pVar instanceof f) && !bg.mA(((f) pVar).kez) && ((f) pVar).kez.equals(str3)) {
                                        str5 = ((f) pVar).kfp;
                                        break;
                                    }
                                }
                                str5 = str6;
                                if (str5 != null) {
                                    break;
                                }
                                str6 = str5;
                            }
                            str5 = str6;
                            if (bg.mA(r2)) {
                                str3 = str2;
                                str2 = str3;
                            } else {
                                w.i("AdLandingPagesParseHelper", "old card ext is " + r2 + " and new card ext is " + str4);
                                str3 = str2.replace(r2, str4);
                                try {
                                    str2 = str3.replace(bg.PW(r2), bg.PW(str4));
                                } catch (Exception e) {
                                    w.e("AdLandingPagesParseHelper", "the xml is error");
                                }
                            }
                        }
                    }
                }
                return str2;
            }
        } else {
            w.e("AdLandingPagesParseHelper", "the snsinfo is not a ad");
            return null;
        }
    }
}
