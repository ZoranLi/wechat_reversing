package com.tencent.mm.plugin.card.model;

import android.database.Cursor;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.e.i;
import com.tencent.mm.sdk.platformtools.w;
import java.util.ArrayList;
import java.util.List;

public final class l extends i<k> {
    public static final String[] gUx = new String[]{i.a(k.gTP, "CardQrCodeDataInfo")};
    public e gUz;

    public l(e eVar) {
        super(eVar, k.gTP, "CardQrCodeDataInfo", k.gaK);
        this.gUz = eVar;
    }

    public final List<k> st(String str) {
        List<k> arrayList = new ArrayList();
        Cursor rawQuery = this.gUz.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0", new String[]{str});
        while (rawQuery != null) {
            try {
                if (!rawQuery.moveToNext()) {
                    break;
                }
                k kVar = new k();
                kVar.b(rawQuery);
                arrayList.add(kVar);
            } catch (Exception e) {
                w.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeByCardId error!", new Object[]{e.getMessage()});
                return arrayList;
            } finally {
                if (rawQuery != null) {
                    rawQuery.close();
                }
            }
        }
        if (rawQuery != null) {
            rawQuery.close();
        }
        return arrayList;
    }

    public final k su(String str) {
        k kVar;
        Exception exception;
        Cursor rawQuery = this.gUz.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=0  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    k kVar2 = new k();
                    try {
                        kVar2.b(rawQuery);
                        w.i("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  success! card_id = %s, code_id = %s ", new Object[]{str, kVar2.field_code_id});
                        kVar = kVar2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e) {
                        Exception exception2 = e;
                        kVar = kVar2;
                        exception = exception2;
                        try {
                            w.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[]{exception.getMessage()});
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return kVar;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    }
                    return kVar;
                }
            } catch (Exception e2) {
                exception = e2;
                kVar = null;
                w.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId error!", new Object[]{exception.getMessage()});
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return kVar;
            }
        }
        w.e("MicroMsg.CardQrCodeDataInfoStorage", "getOneCardQrcodeByCardId  is empty! card_id = %s", new Object[]{str});
        kVar = null;
        if (rawQuery != null) {
            rawQuery.close();
        }
        return kVar;
    }

    public final k sv(String str) {
        k kVar;
        Exception exception;
        Cursor rawQuery = this.gUz.rawQuery("select * from CardQrCodeDataInfo where card_id =? AND status=1  limit 1", new String[]{str});
        if (rawQuery != null) {
            try {
                if (rawQuery.getCount() > 0) {
                    rawQuery.moveToPosition(0);
                    k kVar2 = new k();
                    try {
                        kVar2.b(rawQuery);
                        w.i("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  success! card_id = %s, code_id = %s ", new Object[]{str, kVar2.field_code_id});
                        kVar = kVar2;
                        if (rawQuery != null) {
                            rawQuery.close();
                        }
                    } catch (Exception e) {
                        Exception exception2 = e;
                        kVar = kVar2;
                        exception = exception2;
                        try {
                            w.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[]{exception.getMessage()});
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                            return kVar;
                        } catch (Throwable th) {
                            if (rawQuery != null) {
                                rawQuery.close();
                            }
                        }
                    }
                    return kVar;
                }
            } catch (Exception e2) {
                exception = e2;
                kVar = null;
                w.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId error!", new Object[]{exception.getMessage()});
                if (rawQuery != null) {
                    rawQuery.close();
                }
                return kVar;
            }
        }
        w.e("MicroMsg.CardQrCodeDataInfoStorage", "getCardQrcodeShowingByCardId  is empty! card_id = %s", new Object[]{str});
        kVar = null;
        if (rawQuery != null) {
            rawQuery.close();
        }
        return kVar;
    }

    public final boolean bv(String str, String str2) {
        c kVar = new k();
        kVar.field_card_id = str;
        kVar.field_code_id = str2;
        boolean a = a(kVar, new String[]{"card_id", "code_id"});
        if (a) {
            w.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  success! card_id = %s, code_id = %s", new Object[]{kVar.field_card_id, kVar.field_code_id});
        } else {
            w.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData  failure! card_id = %s, code_id = %s", new Object[]{kVar.field_card_id, kVar.field_code_id});
        }
        return a;
    }

    public final boolean gR(String str) {
        c kVar = new k();
        kVar.field_card_id = str;
        boolean a = a(kVar, new String[]{"card_id"});
        if (a) {
            w.i("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  success! card_id = %s", new Object[]{str});
        } else {
            w.e("MicroMsg.CardQrCodeDataInfoStorage", "delete qrCodeData by cardId  failure! card_id = %s", new Object[]{str});
        }
        return a;
    }
}
