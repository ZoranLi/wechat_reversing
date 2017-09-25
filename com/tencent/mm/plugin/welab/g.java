package com.tencent.mm.plugin.welab;

import android.text.TextUtils;
import com.tencent.mm.sdk.platformtools.w;
import java.io.ByteArrayInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.xml.sax.InputSource;

public final class g {
    private static DocumentBuilder hoN = null;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.tencent.mm.plugin.welab.c.a.a KW(java.lang.String r17) {
        /*
        r2 = "MicroMsg.Welabparser";
        r3 = "ABTest msg content: %s";
        r4 = 1;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r4[r5] = r17;
        com.tencent.mm.sdk.platformtools.w.v(r2, r3, r4);
        r2 = ">\n+\\s*<";
        r3 = "><";
        r0 = r17;
        r2 = r0.replaceAll(r2, r3);
        r5 = new com.tencent.mm.plugin.welab.c.a.a;
        r5.<init>();
        r3 = gE(r2);
        if (r3 != 0) goto L_0x0037;
    L_0x0026:
        r3 = "MicroMsg.Welabparser";
        r4 = "Msg parsing failed, msg: %s";
        r6 = 1;
        r6 = new java.lang.Object[r6];
        r7 = 0;
        r6[r7] = r2;
        com.tencent.mm.sdk.platformtools.w.e(r3, r4, r6);
        r2 = r5;
    L_0x0036:
        return r2;
    L_0x0037:
        r2 = r3.getAttributes();
        if (r2 != 0) goto L_0x003f;
    L_0x003d:
        r2 = 0;
        goto L_0x0036;
    L_0x003f:
        r4 = "type";
        r4 = r2.getNamedItem(r4);
        r2 = 1;
        if (r4 == 0) goto L_0x0210;
    L_0x0049:
        r6 = "newabtestlabs";
        r4 = r4.getNodeValue();
        r4 = r6.equals(r4);
        if (r4 == 0) goto L_0x0210;
    L_0x0056:
        r4 = "prioritylevel";
        r4 = r3.getElementsByTagName(r4);
        r6 = r4.getLength();
        if (r6 <= 0) goto L_0x0071;
    L_0x0063:
        r2 = 0;
        r2 = r4.item(r2);
        r2 = r2.getTextContent();
        r4 = 1;
        r2 = com.tencent.mm.sdk.platformtools.bg.getInt(r2, r4);
    L_0x0071:
        r4 = "status";
        r4 = r3.getElementsByTagName(r4);
        r6 = r4.getLength();
        if (r6 <= 0) goto L_0x008e;
    L_0x007e:
        r6 = 0;
        r4 = r4.item(r6);
        r4 = r4.getTextContent();
        r6 = 1;
        r4 = com.tencent.mm.sdk.platformtools.bg.getInt(r4, r6);
        r5.field_status = r4;
    L_0x008e:
        r5.field_prioritylevel = r2;
        r12 = r3.getChildNodes();
        r2 = 0;
        r4 = r2;
    L_0x0096:
        r2 = r12.getLength();
        if (r4 >= r2) goto L_0x0421;
    L_0x009c:
        r2 = r12.item(r4);
        if (r2 == 0) goto L_0x023e;
    L_0x00a2:
        r3 = r2.getNodeType();
        r6 = 1;
        if (r3 != r6) goto L_0x023e;
    L_0x00a9:
        r3 = r2.getNodeName();
        r6 = "expinfo";
        r3 = r3.equals(r6);
        if (r3 == 0) goto L_0x023e;
    L_0x00b6:
        r2 = (org.w3c.dom.Element) r2;	 Catch:{ Exception -> 0x0233 }
        r3 = r2.getAttributes();	 Catch:{ Exception -> 0x0233 }
        if (r3 == 0) goto L_0x023e;
    L_0x00be:
        r6 = "id";
        r3 = r3.getNamedItem(r6);	 Catch:{ Exception -> 0x0233 }
        if (r3 == 0) goto L_0x023e;
    L_0x00c7:
        r3 = r3.getNodeValue();	 Catch:{ Exception -> 0x0233 }
        r5.field_expId = r3;	 Catch:{ Exception -> 0x0233 }
        r3 = "sequence";
        r3 = r2.getElementsByTagName(r3);	 Catch:{ Exception -> 0x0233 }
        r6 = r3.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r6 == 0) goto L_0x023e;
    L_0x00da:
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0233 }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x0233 }
        r6 = 0;
        r14 = com.tencent.mm.sdk.platformtools.bg.getLong(r3, r6);	 Catch:{ Exception -> 0x0233 }
        r3 = "starttime";
        r3 = r2.getElementsByTagName(r3);	 Catch:{ Exception -> 0x0233 }
        r6 = r3.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r6 <= 0) goto L_0x021c;
    L_0x00f6:
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0233 }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x0233 }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.getLong(r3, r6);	 Catch:{ Exception -> 0x0233 }
        r8 = 0;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 != 0) goto L_0x0427;
    L_0x010b:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0233 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        r10 = r6;
    L_0x0113:
        r3 = "monitor";
        r3 = r2.getElementsByTagName(r3);	 Catch:{ Exception -> 0x0226 }
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0226 }
        r3 = r3.getChildNodes();	 Catch:{ Exception -> 0x0226 }
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0226 }
        r3 = r3.getChildNodes();	 Catch:{ Exception -> 0x0226 }
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0226 }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x0226 }
        r6 = -1;
        r3 = com.tencent.mm.sdk.platformtools.bg.getInt(r3, r6);	 Catch:{ Exception -> 0x0226 }
        r5.field_idkey = r3;	 Catch:{ Exception -> 0x0226 }
        r3 = "monitor";
        r3 = r2.getElementsByTagName(r3);	 Catch:{ Exception -> 0x0226 }
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0226 }
        r3 = r3.getChildNodes();	 Catch:{ Exception -> 0x0226 }
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0226 }
        r3 = r3.getChildNodes();	 Catch:{ Exception -> 0x0226 }
        r6 = 1;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0226 }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x0226 }
        r6 = -1;
        r3 = com.tencent.mm.sdk.platformtools.bg.getInt(r3, r6);	 Catch:{ Exception -> 0x0226 }
        r5.field_idkeyValue = r3;	 Catch:{ Exception -> 0x0226 }
    L_0x0165:
        r3 = "endtime";
        r3 = r2.getElementsByTagName(r3);	 Catch:{ Exception -> 0x0233 }
        r6 = r3.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r6 <= 0) goto L_0x0187;
    L_0x0172:
        r6 = 0;
        r3 = r3.item(r6);	 Catch:{ Exception -> 0x0233 }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x0233 }
        r6 = 0;
        r6 = com.tencent.mm.sdk.platformtools.bg.getLong(r3, r6);	 Catch:{ Exception -> 0x0233 }
        r8 = 0;
        r3 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1));
        if (r3 != 0) goto L_0x0424;
    L_0x0187:
        r6 = 9223372036854775807; // 0x7fffffffffffffff float:NaN double:NaN;
        r8 = r6;
    L_0x018d:
        r7 = new java.util.HashMap;	 Catch:{ Exception -> 0x0233 }
        r7.<init>();	 Catch:{ Exception -> 0x0233 }
        r3 = "args";
        r2 = r2.getElementsByTagName(r3);	 Catch:{ Exception -> 0x0233 }
        r3 = r2.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r3 <= 0) goto L_0x0243;
    L_0x019f:
        r3 = 0;
        r2 = r2.item(r3);	 Catch:{ Exception -> 0x0233 }
        r13 = r2.getChildNodes();	 Catch:{ Exception -> 0x0233 }
        r2 = 0;
        r6 = r2;
    L_0x01aa:
        r2 = r13.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r6 >= r2) goto L_0x0243;
    L_0x01b0:
        r3 = r13.item(r6);	 Catch:{ Exception -> 0x0233 }
        r2 = r3.getNodeType();	 Catch:{ Exception -> 0x0233 }
        r16 = 1;
        r0 = r16;
        if (r2 != r0) goto L_0x020c;
    L_0x01be:
        r2 = r3.getNodeName();	 Catch:{ Exception -> 0x0233 }
        r16 = "arg";
        r0 = r16;
        r2 = r2.equals(r0);	 Catch:{ Exception -> 0x0233 }
        if (r2 == 0) goto L_0x020c;
    L_0x01cd:
        r0 = r3;
        r0 = (org.w3c.dom.Element) r0;	 Catch:{ Exception -> 0x0233 }
        r2 = r0;
        r16 = "key";
        r0 = r16;
        r2 = r2.getElementsByTagName(r0);	 Catch:{ Exception -> 0x0233 }
        r3 = (org.w3c.dom.Element) r3;	 Catch:{ Exception -> 0x0233 }
        r16 = "value";
        r0 = r16;
        r3 = r3.getElementsByTagName(r0);	 Catch:{ Exception -> 0x0233 }
        r16 = r2.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r16 == 0) goto L_0x020c;
    L_0x01eb:
        r16 = r3.getLength();	 Catch:{ Exception -> 0x0233 }
        if (r16 == 0) goto L_0x020c;
    L_0x01f1:
        r16 = 0;
        r0 = r16;
        r2 = r2.item(r0);	 Catch:{ Exception -> 0x0233 }
        r2 = r2.getTextContent();	 Catch:{ Exception -> 0x0233 }
        r16 = 0;
        r0 = r16;
        r3 = r3.item(r0);	 Catch:{ Exception -> 0x0233 }
        r3 = r3.getTextContent();	 Catch:{ Exception -> 0x0233 }
        r7.put(r2, r3);	 Catch:{ Exception -> 0x0233 }
    L_0x020c:
        r2 = r6 + 1;
        r6 = r2;
        goto L_0x01aa;
    L_0x0210:
        r2 = "MicroMsg.Welabparser";
        r3 = "recv illegal type msg";
        com.tencent.mm.sdk.platformtools.w.i(r2, r3);
        r2 = r5;
        goto L_0x0036;
    L_0x021c:
        r6 = java.lang.System.currentTimeMillis();	 Catch:{ Exception -> 0x0233 }
        r8 = 1000; // 0x3e8 float:1.401E-42 double:4.94E-321;
        r6 = r6 / r8;
        r10 = r6;
        goto L_0x0113;
    L_0x0226:
        r3 = move-exception;
        r6 = "MicroMsg.Welabparser";
        r3 = com.tencent.mm.sdk.platformtools.bg.g(r3);	 Catch:{ Exception -> 0x0233 }
        com.tencent.mm.sdk.platformtools.w.e(r6, r3);	 Catch:{ Exception -> 0x0233 }
        goto L_0x0165;
    L_0x0233:
        r2 = move-exception;
        r3 = "MicroMsg.Welabparser";
        r2 = r2.getMessage();
        com.tencent.mm.sdk.platformtools.w.e(r3, r2);
    L_0x023e:
        r2 = r4 + 1;
        r4 = r2;
        goto L_0x0096;
    L_0x0243:
        r5.field_sequence = r14;	 Catch:{ Exception -> 0x0233 }
        r5.field_starttime = r10;	 Catch:{ Exception -> 0x0233 }
        r5.field_endtime = r8;	 Catch:{ Exception -> 0x0233 }
        r2 = "AllVer";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_AllVer = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "BizType";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_BizType = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Desc_cn";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Desc_cn = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Desc_en";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Desc_en = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Desc_hk";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Desc_hk = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Desc_tw";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Desc_tw = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "DetailURL";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_DetailURL = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Introduce_cn";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Introduce_cn = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Introduce_en";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Introduce_en = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Introduce_hk";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Introduce_hk = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Introduce_tw";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Introduce_tw = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Pos";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_Pos = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Type";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_Type = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Switch";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_Switch = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "WeAppPath";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_WeAppPath = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "WeAppUser";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_WeAppUser = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "LabsAppId";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_LabsAppId = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "TitleKey_android";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_TitleKey_android = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Title_cn";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Title_cn = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Title_en";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Title_en = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Title_hk";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Title_hk = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Title_tw";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Title_tw = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ThumbUrl_cn";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ThumbUrl_cn = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ThumbUrl_en";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ThumbUrl_en = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ThumbUrl_hk";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ThumbUrl_hk = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ThumbUrl_tw";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ThumbUrl_tw = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ImgUrl_android_cn";
        r2 = a(r7, r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_cn = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ImgUrl_android_tw";
        r2 = a(r7, r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_tw = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ImgUrl_android_en";
        r2 = a(r7, r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_en = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "ImgUrl_android_hk";
        r2 = a(r7, r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_hk = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = r5.field_ImgUrl_android_cn;	 Catch:{ Exception -> 0x0233 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0233 }
        if (r2 == 0) goto L_0x03b2;
    L_0x03a7:
        r2 = "ImgUrl_cn";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_cn = r2;	 Catch:{ Exception -> 0x0233 }
    L_0x03b2:
        r2 = r5.field_ImgUrl_android_en;	 Catch:{ Exception -> 0x0233 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0233 }
        if (r2 == 0) goto L_0x03c5;
    L_0x03ba:
        r2 = "ImgUrl_en";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_en = r2;	 Catch:{ Exception -> 0x0233 }
    L_0x03c5:
        r2 = r5.field_ImgUrl_android_hk;	 Catch:{ Exception -> 0x0233 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0233 }
        if (r2 == 0) goto L_0x03d8;
    L_0x03cd:
        r2 = "ImgUrl_hk";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_hk = r2;	 Catch:{ Exception -> 0x0233 }
    L_0x03d8:
        r2 = r5.field_ImgUrl_android_tw;	 Catch:{ Exception -> 0x0233 }
        r2 = android.text.TextUtils.isEmpty(r2);	 Catch:{ Exception -> 0x0233 }
        if (r2 == 0) goto L_0x03eb;
    L_0x03e0:
        r2 = "ImgUrl_tw";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_ImgUrl_android_tw = r2;	 Catch:{ Exception -> 0x0233 }
    L_0x03eb:
        r2 = "RedPoint";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_RedPoint = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "WeAppDebugMode";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r2 = com.tencent.mm.sdk.platformtools.bg.PY(r2);	 Catch:{ Exception -> 0x0233 }
        r5.field_WeAppDebugMode = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "TitleKey_android";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_TitleKey_android = r2;	 Catch:{ Exception -> 0x0233 }
        r2 = "Icon";
        r2 = r7.get(r2);	 Catch:{ Exception -> 0x0233 }
        r2 = (java.lang.String) r2;	 Catch:{ Exception -> 0x0233 }
        r5.field_Icon = r2;	 Catch:{ Exception -> 0x0233 }
        goto L_0x023e;
    L_0x0421:
        r2 = r5;
        goto L_0x0036;
    L_0x0424:
        r8 = r6;
        goto L_0x018d;
    L_0x0427:
        r10 = r6;
        goto L_0x0113;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.welab.g.KW(java.lang.String):com.tencent.mm.plugin.welab.c.a.a");
    }

    private static String a(HashMap<String, String> hashMap, String str) {
        StringBuilder stringBuilder = new StringBuilder();
        if (!hashMap.containsKey(str)) {
            return stringBuilder.toString();
        }
        stringBuilder.append((String) hashMap.get(str)).append(";");
        int i = 1;
        while (true) {
            String str2 = str + "_" + i;
            if (!hashMap.containsKey(str2)) {
                return stringBuilder.toString();
            }
            stringBuilder.append((String) hashMap.get(str2)).append(";");
            i++;
        }
    }

    public static List<String> KX(String str) {
        if (TextUtils.isEmpty(str)) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(str.split(";"));
    }

    private static Element gE(String str) {
        try {
            DocumentBuilder documentBuilder;
            InputSource inputSource = new InputSource(new ByteArrayInputStream(str.getBytes()));
            if (hoN != null) {
                documentBuilder = hoN;
            } else {
                documentBuilder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
                hoN = documentBuilder;
            }
            Document parse = documentBuilder.parse(inputSource);
            parse.normalize();
            return parse.getDocumentElement();
        } catch (Exception e) {
            w.e("MicroMsg.Welabparser", e.toString());
            return null;
        }
    }
}
