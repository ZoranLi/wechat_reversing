package com.tencent.mm.plugin.appbrand.jsapi;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.CommonDataKinds.Phone;
import android.provider.ContactsContract.Contacts;
import android.support.v4.app.a.a;
import android.telephony.PhoneNumberUtils;
import android.widget.Toast;
import com.samsung.android.sdk.look.airbutton.SlookAirButtonFrequentContactAdapter;
import com.tencent.mm.R;
import com.tencent.mm.plugin.appbrand.b;
import com.tencent.mm.plugin.appbrand.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class q extends a {
    public static final int CTRL_INDEX = 72;
    public static final String NAME = "chooseContact";

    public final void a(final m mVar, final JSONObject jSONObject, final int i) {
        int i2 = 0;
        final MMActivity a = a(mVar);
        if (a == null) {
            w.e("MicroMsg.JsApiChooseContact", "getPageContext failed, appid is %s", new Object[]{mVar.ivH});
            mVar.x(i, d("fail", null));
            return;
        }
        b.a(mVar.ivH, new a(this) {
            final /* synthetic */ q iLo;

            public final void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
                if (i == 48) {
                    if (iArr[0] == 0) {
                        this.iLo.a(mVar, jSONObject, i);
                    } else {
                        mVar.x(i, this.iLo.d("permission_denied", null));
                    }
                }
            }
        });
        Activity a2 = a(mVar);
        if (a2 == null) {
            mVar.x(i, d("fail", null));
        } else {
            i2 = com.tencent.mm.pluginsdk.i.a.a(a2, "android.permission.READ_CONTACTS", 48, "", "");
            if (i2 != 0) {
                b.mX(mVar.ivH);
            }
        }
        if (i2 == 0) {
            w.i("MicroMsg.JsApiChooseContact", "check permission");
            return;
        }
        a.uSV = new MMActivity.a(this) {
            final /* synthetic */ q iLo;

            public final void a(int i, int i2, Intent intent) {
                if (100 != i) {
                    w.e("MicroMsg.JsApiChooseContact", "requestcode not equal, requestCode = %d", new Object[]{Integer.valueOf(i)});
                    mVar.x(i, this.iLo.d("fail", null));
                } else if (i2 == 0 || i2 == 1) {
                    mVar.x(i, this.iLo.d("cancel", null));
                } else if (i2 == -1) {
                    Uri data = intent.getData();
                    if (data == null) {
                        w.e("MicroMsg.JsApiChooseContact", "onActivityResult, uri == null");
                        mVar.x(i, this.iLo.d("fail", null));
                    } else if (com.tencent.mm.pluginsdk.i.a.aT(a, "android.permission.READ_CONTACTS")) {
                        try {
                            Object obj;
                            String str;
                            Map hashMap;
                            Cursor query = a.getContentResolver().query(data, null, null, null, null);
                            if (query != null && query.getCount() > 0) {
                                query.moveToFirst();
                                int columnIndex = query.getColumnIndex("has_phone_number");
                                if (columnIndex <= 0 || query.getInt(columnIndex) > 0) {
                                    String string = query.getString(query.getColumnIndex("_id"));
                                    Cursor query2 = a.getContentResolver().query(Phone.CONTENT_URI, null, "contact_id = " + string, null, null);
                                    w.i("MicroMsg.JsApiChooseContact", "onActivityResult, queried cursor = %s", new Object[]{query});
                                    if (query2 == null) {
                                        mVar.x(i, this.iLo.d("fail", null));
                                        return;
                                    }
                                    if (query2.moveToFirst()) {
                                        obj = null;
                                        str = null;
                                        while (!query2.isAfterLast()) {
                                            columnIndex = query2.getColumnIndex("data1");
                                            int columnIndex2 = query2.getColumnIndex(SlookAirButtonFrequentContactAdapter.DISPLAY_NAME);
                                            String string2 = query2.getString(columnIndex);
                                            string = query2.getString(columnIndex2);
                                            w.d("MicroMsg.JsApiChooseContact", "onActivityResult, username : " + string);
                                            if (string2 != null) {
                                                w.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (string2 == null) {
                                                    string2 = null;
                                                } else {
                                                    string2 = string2.replaceAll("\\D", "");
                                                    if (string2.startsWith("86")) {
                                                        string2 = string2.substring(2);
                                                    }
                                                }
                                                w.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneNumber : " + string2);
                                                if (!(PhoneNumberUtils.isGlobalPhoneNumber(string2) && string2.length() == 11)) {
                                                    string2 = str;
                                                }
                                                w.d("MicroMsg.JsApiChooseContact", "onActivityResult, phoneResult : " + string2);
                                            } else {
                                                string2 = str;
                                            }
                                            query2.moveToNext();
                                            str = string2;
                                            string2 = string;
                                        }
                                    } else {
                                        obj = null;
                                        str = null;
                                    }
                                    if (!query2.isClosed()) {
                                        query2.close();
                                    }
                                    if (!(query == null || query.isClosed())) {
                                        query.close();
                                    }
                                    if (bg.mA(str)) {
                                        hashMap = new HashMap(1);
                                        hashMap.put("phoneNumber", str);
                                        str = "displayName";
                                        if (obj == null) {
                                            obj = "";
                                        }
                                        hashMap.put(str, obj);
                                        mVar.x(i, this.iLo.d("ok", hashMap));
                                    }
                                    mVar.x(i, this.iLo.d("fail", null));
                                    Toast.makeText(a, R.l.eAp, 0).show();
                                    return;
                                }
                            }
                            obj = null;
                            str = null;
                            query.close();
                            if (bg.mA(str)) {
                                mVar.x(i, this.iLo.d("fail", null));
                                Toast.makeText(a, R.l.eAp, 0).show();
                                return;
                            }
                            hashMap = new HashMap(1);
                            hashMap.put("phoneNumber", str);
                            str = "displayName";
                            if (obj == null) {
                                obj = "";
                            }
                            hashMap.put(str, obj);
                            mVar.x(i, this.iLo.d("ok", hashMap));
                        } catch (SecurityException e) {
                            w.e("MicroMsg.JsApiChooseContact", "onActivityResult, permission denied: %s", new Object[]{e.toString()});
                            g.b(a, ab.getResources().getString(R.l.eAr), "", true);
                            mVar.x(i, this.iLo.d("fail:system permission denied", null));
                        }
                    } else {
                        w.e("MicroMsg.JsApiChooseContact", "onActivityResult, no contact permission");
                        mVar.x(i, this.iLo.d("fail:system permission denied", null));
                    }
                }
            }
        };
        a.startActivityForResult(new Intent("android.intent.action.PICK", Contacts.CONTENT_URI), 100);
    }
}
