package com.tencent.mm.plugin.appbrand.jsapi;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.provider.ContactsContract.Contacts;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.samsung.android.sdk.look.smartclip.SlookSmartClipMetaTag;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.appstorage.AppBrandLocalMediaObject;
import com.tencent.mm.plugin.appbrand.appstorage.e;
import com.tencent.mm.plugin.appbrand.appstorage.e.a;
import com.tencent.mm.plugin.appbrand.appstorage.e.b;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.base.g.c;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import org.json.JSONObject;

public final class n extends a {
    public static final int CTRL_INDEX = 226;
    public static final String NAME = "addPhoneContact";
    private e iLi;

    public final void a(m mVar, JSONObject jSONObject, int i) {
        w.d("MicroMsg.JsApiAddPhoneContact", "addPhoneContact!");
        if (jSONObject == null) {
            mVar.x(i, d("fail:data is null", null));
            w.e("MicroMsg.JsApiAddPhoneContact", "data is null");
        } else if (bg.mA(jSONObject.optString("firstName"))) {
            mVar.x(i, d("fail:firstName is null", null));
            w.e("MicroMsg.JsApiAddPhoneContact", "firstName is null");
        } else {
            final Context a = a(mVar);
            if (a == null) {
                mVar.x(i, d("fail", null));
                w.e("MicroMsg.JsApiAddPhoneContact", "mmActivity is null, invoke fail!");
                return;
            }
            this.iLi = new e();
            this.iLi.iBa = jSONObject.optString("photoFilePath");
            this.iLi.aIO = jSONObject.optString("nickName");
            this.iLi.iAZ = new b(jSONObject.optString("firstName"), jSONObject.optString("middleName"), jSONObject.optString("lastName"));
            this.iLi.iBi = jSONObject.optString("remark");
            this.iLi.iBe = jSONObject.optString("mobilePhoneNumber");
            this.iLi.iBm = jSONObject.optString("weChatNumber");
            this.iLi.iBd = a(jSONObject, "address");
            this.iLi.iBj = jSONObject.optString("organization");
            this.iLi.title = jSONObject.optString("title");
            this.iLi.iBk = jSONObject.optString("workFaxNumber");
            this.iLi.iBh = jSONObject.optString("workPhoneNumber");
            this.iLi.iBg = jSONObject.optString("hostNumber");
            this.iLi.gku = jSONObject.optString("email");
            this.iLi.url = jSONObject.optString(SlookSmartClipMetaTag.TAG_TYPE_URL);
            this.iLi.iBc = a(jSONObject, "workAddress");
            this.iLi.iBl = jSONObject.optString("homeFaxNumber");
            this.iLi.iBf = jSONObject.optString("homePhoneNumber");
            this.iLi.iBb = a(jSONObject, "homeAddress");
            final String str = mVar.ivH;
            g.a(a, "", new String[]{a.getString(R.l.dFD), a.getString(R.l.dFC)}, "", new c(this) {
                final /* synthetic */ n iLk;

                public final void hq(int i) {
                    Intent intent;
                    switch (i) {
                        case 0:
                            intent = new Intent("android.intent.action.INSERT", Contacts.CONTENT_URI);
                            this.iLk.a(intent, a, str);
                            a.startActivity(intent);
                            return;
                        case 1:
                            intent = new Intent("android.intent.action.INSERT_OR_EDIT", Contacts.CONTENT_URI);
                            intent.setType("vnd.android.cursor.item/person");
                            this.iLk.a(intent, a, str);
                            a.startActivity(intent);
                            return;
                        default:
                            return;
                    }
                }
            });
            mVar.x(i, d("ok", null));
        }
    }

    private static a a(JSONObject jSONObject, String str) {
        return new a(jSONObject.optString(str + "Country"), jSONObject.optString(str + "State"), jSONObject.optString(str + "City"), jSONObject.optString(str + "Street"), jSONObject.optString(str + "PostalCode"));
    }

    public final void a(Intent intent, MMActivity mMActivity, String str) {
        intent.setFlags(SQLiteDatabase.CREATE_IF_NECESSARY);
        ArrayList arrayList = new ArrayList();
        b bVar = this.iLi.iAZ;
        StringBuilder stringBuilder = new StringBuilder();
        if (bg.PH(bVar.iBp) || bg.PH(bVar.iBq) || bg.PH(bVar.iBr)) {
            if (bVar.iBr.trim().length() > 0) {
                stringBuilder.append(bVar.iBr);
            }
            if (bVar.iBq.trim().length() > 0) {
                stringBuilder.append(bVar.iBq);
            }
            if (bVar.iBp.trim().length() > 0) {
                stringBuilder.append(bVar.iBp);
            }
        } else {
            if (bVar.iBp.trim().length() > 0) {
                stringBuilder.append(bVar.iBp);
            }
            if (bVar.iBq.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar.iBq);
            }
            if (bVar.iBr.trim().length() > 0) {
                stringBuilder.append(" ");
                stringBuilder.append(bVar.iBr);
            }
        }
        String stringBuilder2 = stringBuilder.toString();
        if (bg.mA(stringBuilder2)) {
            w.e("MicroMsg.JsApiAddPhoneContact", "no contact user name");
        } else {
            intent.putExtra("name", stringBuilder2);
        }
        if (!bg.mA(this.iLi.aIO)) {
            stringBuilder2 = this.iLi.aIO;
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/nickname");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bg.mA(this.iLi.iBi)) {
            stringBuilder2 = this.iLi.iBi;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/note");
            contentValues.put("data1", stringBuilder2);
            arrayList.add(contentValues);
        }
        if (!(bg.mA(this.iLi.iBj) && bg.mA(this.iLi.title))) {
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("mimetype", "vnd.android.cursor.item/organization");
            if (!bg.mA(this.iLi.iBj)) {
                contentValues2.put("data1", this.iLi.iBj);
            }
            if (!bg.mA(this.iLi.title)) {
                contentValues2.put("data4", this.iLi.title);
            }
            contentValues2.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues2);
        }
        if (!bg.mA(this.iLi.url)) {
            stringBuilder2 = this.iLi.url;
            contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/website");
            contentValues.put("data1", stringBuilder2);
            contentValues.put("data2", Integer.valueOf(1));
            arrayList.add(contentValues);
        }
        if (!bg.mA(this.iLi.gku)) {
            intent.putExtra("email", this.iLi.gku);
        }
        if (!bg.mA(this.iLi.iBe)) {
            b(arrayList, this.iLi.iBe, 2);
        }
        if (!bg.mA(this.iLi.iBf)) {
            b(arrayList, this.iLi.iBf, 1);
        }
        if (!bg.mA(this.iLi.iBh)) {
            b(arrayList, this.iLi.iBh, 3);
        }
        if (!bg.mA(this.iLi.iBg)) {
            b(arrayList, this.iLi.iBg, 10);
        }
        if (!bg.mA(this.iLi.iBl)) {
            b(arrayList, this.iLi.iBl, 5);
        }
        if (!bg.mA(this.iLi.iBk)) {
            b(arrayList, this.iLi.iBk, 4);
        }
        a(arrayList, this.iLi.iBd, 3);
        a(arrayList, this.iLi.iBc, 2);
        a(arrayList, this.iLi.iBb, 1);
        if (!bg.mA(this.iLi.iBm)) {
            stringBuilder2 = this.iLi.iBm;
            String string = mMActivity.getString(R.l.bpJ);
            ContentValues contentValues3 = new ContentValues();
            contentValues3.put("mimetype", "vnd.android.cursor.item/im");
            contentValues3.put("data1", stringBuilder2);
            contentValues3.put("data5", Integer.valueOf(-1));
            contentValues3.put("data6", string);
            arrayList.add(contentValues3);
        }
        AppBrandLocalMediaObject aH = com.tencent.mm.plugin.appbrand.appstorage.c.aH(str, this.iLi.iBa);
        if (!(aH == null || bg.mA(aH.hos))) {
            stringBuilder2 = aH.hos;
            if (!stringBuilder2.startsWith("file://")) {
                stringBuilder2 = "file://" + stringBuilder2;
            }
            Bitmap gN = com.tencent.mm.modelappbrand.a.b.AY().gN(stringBuilder2);
            if (gN != null) {
                OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                gN.compress(CompressFormat.JPEG, 100, byteArrayOutputStream);
                byte[] toByteArray = byteArrayOutputStream.toByteArray();
                ContentValues contentValues4 = new ContentValues();
                contentValues4.put("mimetype", "vnd.android.cursor.item/photo");
                contentValues4.put("data15", toByteArray);
                arrayList.add(contentValues4);
                gN.recycle();
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e) {
                }
            }
        }
        intent.putParcelableArrayListExtra(SlookAirButtonFrequentContactAdapter.DATA, arrayList);
    }

    private static void a(ArrayList<ContentValues> arrayList, a aVar, int i) {
        if (aVar != null && aVar.Ix().length() > 0) {
            ContentValues contentValues = new ContentValues();
            contentValues.put("mimetype", "vnd.android.cursor.item/postal-address_v2");
            contentValues.put("data1", aVar.Ix());
            contentValues.put("data9", aVar.iBo);
            contentValues.put("data2", Integer.valueOf(i));
            arrayList.add(contentValues);
        }
    }

    private static void b(ArrayList<ContentValues> arrayList, String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
        contentValues.put("data1", str);
        contentValues.put("data2", Integer.valueOf(i));
        arrayList.add(contentValues);
    }
}
