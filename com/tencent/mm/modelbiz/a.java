package com.tencent.mm.modelbiz;

import android.graphics.Bitmap;
import com.tencent.mm.e.b.af;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.c.go;
import com.tencent.mm.protocal.c.gp;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import com.tencent.mm.storage.x;
import com.tencent.mm.x.d;
import com.tencent.mm.x.n;
import com.tencent.mm.y.k;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class a {
    static boolean b(BizInfo bizInfo) {
        if (bizInfo == null) {
            w.i("MicroMsg.BizAttrRenovator", "BizInfo is null.");
            return false;
        } else if (!Cy()) {
            return false;
        } else {
            int i = ((com.tencent.mm.plugin.zero.b.a) h.h(com.tencent.mm.plugin.zero.b.a.class)).sV().getInt("MMBizAttrSyncFreq", -1);
            if (i == -1) {
                w.i("MicroMsg.BizAttrRenovator", "MMBizAttrSyncFreq is null.");
                i = 3600;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = bizInfo.field_incrementUpdateTime;
            String str = bizInfo.field_attrSyncVersion;
            w.i("MicroMsg.BizAttrRenovator", "currentMS(%d), lastUpdateTime(%d), freq(%d), version(%s).", Long.valueOf(currentTimeMillis), Long.valueOf(j), Integer.valueOf(i), str);
            return currentTimeMillis - j >= ((long) (i * 1000));
        }
    }

    public static boolean Cy() {
        int i;
        Object obj = h.vI().vr().get(com.tencent.mm.storage.w.a.USERINFO_BIZ_ATTR_SYNC_OPEN_FLAG_INT, null);
        if (obj == null || !(obj instanceof Integer)) {
            w.i("MicroMsg.BizAttrRenovator", "openFlag is null.");
            i = 1;
        } else {
            i = ((Integer) obj).intValue();
        }
        w.i("MicroMsg.BizAttrRenovator", "openFlag is %d.", Integer.valueOf(i));
        if (i == 1) {
            return true;
        }
        return false;
    }

    public final boolean hB(final String str) {
        if (bg.mA(str)) {
            w.i("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes failed, username is null or nil.");
            return false;
        }
        w.d("MicroMsg.BizAttrRenovator", "try2UpdateBizAttributes");
        BizInfo hO = w.DH().hO(str);
        if (b(hO)) {
            final WeakReference weakReference = new WeakReference(null);
            h.vH().gXC.a(new o(str, hO.field_attrSyncVersion, new com.tencent.mm.modelbiz.o.a<o>(this) {
                final /* synthetic */ a huf;

                public final /* synthetic */ void b(int i, int i2, String str, k kVar) {
                    o oVar = (o) kVar;
                    w.i("MicroMsg.BizAttrRenovator", "onSceneEnd errType = " + i + ", errCode = " + i2 + ",errMsg = " + str);
                    if (weakReference != null) {
                        weakReference.get();
                    }
                    if (oVar == null) {
                        w.e("MicroMsg.BizAttrRenovator", "scene == null");
                    } else if (i == 0 && i2 == 0) {
                        go goVar = (oVar.gUA == null || oVar.gUA.hsk.hsr == null) ? null : (go) oVar.gUA.hsk.hsr;
                        if (goVar == null) {
                            w.e("MicroMsg.BizAttrRenovator", "resp is null.");
                            return;
                        }
                        String str2 = "MicroMsg.BizAttrRenovator";
                        String str3 = "[BizAttr] biz(%s) Attribute LastAttrVersion = %s, UpdateInfoList.size = %s";
                        Object[] objArr = new Object[3];
                        objArr[0] = str;
                        objArr[1] = goVar.tkC == null ? null : new String(goVar.tkC.sYA);
                        objArr[2] = Integer.valueOf(goVar.tkD == null ? 0 : goVar.tkD.size());
                        w.i(str2, str3, objArr);
                        if (goVar.tkD == null) {
                            w.e("MicroMsg.BizAttrRenovator", "[BizAttr] resp.UpdateInfoList null");
                            return;
                        }
                        boolean z;
                        String str4 = str;
                        List list = goVar.tkD;
                        if (bg.mA(str4)) {
                            w.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, username is null.");
                            z = false;
                        } else {
                            BizInfo hO = w.DH().hO(str4);
                            if (a.b(hO)) {
                                af Rc = ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().Rc(str4);
                                if (Rc == null || ((int) Rc.gTQ) == 0 || !Rc.bLe()) {
                                    w.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact do not exist.(username : %s)", str4);
                                    z = false;
                                } else {
                                    if (bg.mA(Rc.field_username)) {
                                        Rc.setUsername(str4);
                                    }
                                    z = a.a(Rc, hO, list);
                                }
                            } else {
                                w.i("MicroMsg.BizAttrRenovator", "Do not need to update bizAttrs now.(username : %s)", str4);
                                z = false;
                            }
                        }
                        if (!z) {
                            w.i("MicroMsg.BizAttrRenovator", "notifyDataSetChanged, after updateBizAttributes.");
                        }
                        if (goVar.tkC != null) {
                            z = (bg.mA(str) || bg.mA(bg.bo(goVar.tkC.sYA))) ? false : w.DH().eE("BizInfo", String.format("update %s set %s='%s', %s=%d where %s='%s'", new Object[]{"BizInfo", "attrSyncVersion", bg.bo(goVar.tkC.sYA), "incrementUpdateTime", Long.valueOf(System.currentTimeMillis()), "username", str}));
                            w.i("MicroMsg.BizAttrRenovator", "Update attrSyncVersion of bizInfo succ = %b.", Boolean.valueOf(z));
                        }
                    } else {
                        w.e("MicroMsg.BizAttrRenovator", "scene.getType() = %s", Integer.valueOf(oVar.getType()));
                    }
                }
            }), 0);
            return true;
        }
        w.i("MicroMsg.BizAttrRenovator", "do not need to update biz attrs now.");
        return false;
    }

    public static boolean a(x xVar, BizInfo bizInfo, List<gp> list) {
        if (xVar == null || list == null || list.size() == 0) {
            w.e("MicroMsg.BizAttrRenovator", "updateBizAttributes failed.");
            return false;
        }
        String str = xVar.field_username;
        if (xVar.bLe()) {
            if (bizInfo == null) {
                bizInfo = w.DH().hO(str);
            }
            if (bizInfo == null) {
                w.i("MicroMsg.BizAttrRenovator", "BizInfo is null.(username : %s)", str);
                return false;
            }
            JSONObject jSONObject;
            com.tencent.mm.x.h hs = n.Bm().hs(str);
            try {
                if (bg.mA(bizInfo.field_extInfo)) {
                    jSONObject = new JSONObject();
                } else {
                    jSONObject = new JSONObject(bizInfo.field_extInfo);
                }
            } catch (Exception e) {
                w.e("MicroMsg.BizAttrRenovator", "create Json object from extInfo error. %s.", e);
                jSONObject = new JSONObject();
            }
            long j = -1;
            long j2 = (long) xVar.field_type;
            int i = 0;
            Object obj = null;
            for (gp gpVar : list) {
                if (gpVar == null) {
                    w.w("MicroMsg.BizAttrRenovator", "keyValue is null.");
                } else {
                    Object obj2;
                    int i2;
                    String str2 = gpVar.tkE;
                    w.i("MicroMsg.BizAttrRenovator", "[BizAttr] UpdateInfoList key = %s, value = %s", str2, gpVar.oTN);
                    String str3 = gpVar.oTN;
                    if (!"UserName".equals(str2)) {
                        if ("NickName".equals(str2)) {
                            xVar.bR(str3);
                        } else if ("Alias".equals(str2)) {
                            xVar.bO(str3);
                        } else if ("PYInitial".equals(str2)) {
                            xVar.bS(str3);
                        } else if ("QuanPin".equals(str2)) {
                            xVar.bT(str3);
                        } else if ("VerifyFlag".equals(str2)) {
                            xVar.de(bg.getInt(str3, xVar.field_verifyFlag));
                        } else if ("VerifyInfo".equals(str2)) {
                            xVar.cj(str3);
                        } else if ("Signature".equals(str2)) {
                            xVar.ce(str3);
                        } else {
                            obj2 = null;
                            if (obj2 == null && !b(jSONObject, str2, gpVar.oTN)) {
                                str3 = gpVar.oTN;
                                if ("BrandInfo".equals(str2)) {
                                    bizInfo.field_brandInfo = str3;
                                } else if ("BrandIconURL".equals(str2)) {
                                    bizInfo.field_brandIconURL = str3;
                                } else if ("BrandFlag".equals(str2)) {
                                    obj2 = null;
                                    if (obj2 == null) {
                                        str3 = gpVar.oTN;
                                        if ("BigHeadImgUrl".equals(str2)) {
                                            if (!"SmallHeadImgUrl".equals(str2)) {
                                                obj2 = null;
                                                if (obj2 == null) {
                                                    i++;
                                                    obj = 1;
                                                } else if ("BitMask".equals(str2)) {
                                                    if ("BitVal".equals(str2)) {
                                                        i2 = i;
                                                    } else {
                                                        j2 = bg.getLong(gpVar.oTN, j2);
                                                        i2 = i + 1;
                                                    }
                                                    i = i2;
                                                } else {
                                                    j = bg.getLong(gpVar.oTN, j);
                                                    i++;
                                                }
                                            } else if (hs != null) {
                                                hs.hrA = str3;
                                            }
                                        } else if (hs != null) {
                                            hs.hrB = str3;
                                        }
                                        obj2 = 1;
                                        if (obj2 == null) {
                                            i++;
                                            obj = 1;
                                        } else if ("BitMask".equals(str2)) {
                                            if ("BitVal".equals(str2)) {
                                                i2 = i;
                                            } else {
                                                j2 = bg.getLong(gpVar.oTN, j2);
                                                i2 = i + 1;
                                            }
                                            i = i2;
                                        } else {
                                            j = bg.getLong(gpVar.oTN, j);
                                            i++;
                                        }
                                    }
                                } else {
                                    bizInfo.field_brandFlag = bg.getInt(str3, bizInfo.field_brandFlag);
                                }
                                obj2 = 1;
                                if (obj2 == null) {
                                    str3 = gpVar.oTN;
                                    if ("BigHeadImgUrl".equals(str2)) {
                                        if (!"SmallHeadImgUrl".equals(str2)) {
                                            obj2 = null;
                                            if (obj2 == null) {
                                                i++;
                                                obj = 1;
                                            } else if ("BitMask".equals(str2)) {
                                                j = bg.getLong(gpVar.oTN, j);
                                                i++;
                                            } else {
                                                if ("BitVal".equals(str2)) {
                                                    j2 = bg.getLong(gpVar.oTN, j2);
                                                    i2 = i + 1;
                                                } else {
                                                    i2 = i;
                                                }
                                                i = i2;
                                            }
                                        } else if (hs != null) {
                                            hs.hrA = str3;
                                        }
                                    } else if (hs != null) {
                                        hs.hrB = str3;
                                    }
                                    obj2 = 1;
                                    if (obj2 == null) {
                                        i++;
                                        obj = 1;
                                    } else if ("BitMask".equals(str2)) {
                                        if ("BitVal".equals(str2)) {
                                            i2 = i;
                                        } else {
                                            j2 = bg.getLong(gpVar.oTN, j2);
                                            i2 = i + 1;
                                        }
                                        i = i2;
                                    } else {
                                        j = bg.getLong(gpVar.oTN, j);
                                        i++;
                                    }
                                }
                            }
                            i++;
                        }
                    }
                    obj2 = 1;
                    str3 = gpVar.oTN;
                    if ("BrandInfo".equals(str2)) {
                        bizInfo.field_brandInfo = str3;
                    } else if ("BrandIconURL".equals(str2)) {
                        bizInfo.field_brandIconURL = str3;
                    } else if ("BrandFlag".equals(str2)) {
                        obj2 = null;
                        if (obj2 == null) {
                            str3 = gpVar.oTN;
                            if ("BigHeadImgUrl".equals(str2)) {
                                if (hs != null) {
                                    hs.hrB = str3;
                                }
                            } else if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bg.getLong(gpVar.oTN, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = bg.getLong(gpVar.oTN, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (hs != null) {
                                hs.hrA = str3;
                            }
                            obj2 = 1;
                            if (obj2 == null) {
                                i++;
                                obj = 1;
                            } else if ("BitMask".equals(str2)) {
                                if ("BitVal".equals(str2)) {
                                    i2 = i;
                                } else {
                                    j2 = bg.getLong(gpVar.oTN, j2);
                                    i2 = i + 1;
                                }
                                i = i2;
                            } else {
                                j = bg.getLong(gpVar.oTN, j);
                                i++;
                            }
                        }
                        i++;
                    } else {
                        bizInfo.field_brandFlag = bg.getInt(str3, bizInfo.field_brandFlag);
                    }
                    obj2 = 1;
                    if (obj2 == null) {
                        str3 = gpVar.oTN;
                        if ("BigHeadImgUrl".equals(str2)) {
                            if (!"SmallHeadImgUrl".equals(str2)) {
                                obj2 = null;
                                if (obj2 == null) {
                                    i++;
                                    obj = 1;
                                } else if ("BitMask".equals(str2)) {
                                    j = bg.getLong(gpVar.oTN, j);
                                    i++;
                                } else {
                                    if ("BitVal".equals(str2)) {
                                        j2 = bg.getLong(gpVar.oTN, j2);
                                        i2 = i + 1;
                                    } else {
                                        i2 = i;
                                    }
                                    i = i2;
                                }
                            } else if (hs != null) {
                                hs.hrA = str3;
                            }
                        } else if (hs != null) {
                            hs.hrB = str3;
                        }
                        obj2 = 1;
                        if (obj2 == null) {
                            i++;
                            obj = 1;
                        } else if ("BitMask".equals(str2)) {
                            if ("BitVal".equals(str2)) {
                                i2 = i;
                            } else {
                                j2 = bg.getLong(gpVar.oTN, j2);
                                i2 = i + 1;
                            }
                            i = i2;
                        } else {
                            j = bg.getLong(gpVar.oTN, j);
                            i++;
                        }
                    }
                    i++;
                }
            }
            if (i == 0) {
                w.i("MicroMsg.BizAttrRenovator", "None attribute has been updated.");
                return false;
            }
            bizInfo.field_extInfo = jSONObject.toString();
            if (!(hs == null || r4 == null)) {
                n.Bm().a(hs);
                n.Bl();
                d.s(str, false);
                n.Bl();
                d.s(str, true);
                n.Bz().hf(str);
                com.tencent.mm.modelbiz.l.a DP = w.DP();
                if (!bg.mA(str)) {
                    w.d("MicroMsg.BrandLogic", "remove cache by brandKey : %s", str);
                    WeakReference weakReference = (WeakReference) DP.hwc.remove(str);
                    if (weakReference != null) {
                        Bitmap bitmap = (Bitmap) weakReference.get();
                        if (bitmap != null) {
                            bitmap.isRecycled();
                        }
                    }
                }
            }
            xVar.setType(xVar.field_type | ((int) (j & j2)));
            ((com.tencent.mm.plugin.messenger.foundation.a.h) h.h(com.tencent.mm.plugin.messenger.foundation.a.h.class)).wR().a(str, xVar);
            w.DH().e(bizInfo);
            w.i("MicroMsg.BizAttrRenovator", "Update bizInfo attributes successfully.");
            return true;
        }
        w.w("MicroMsg.BizAttrRenovator", "updateBizAttributes failed, contact is not a biz contact.(username : %s)", str);
        return false;
    }

    private static boolean b(JSONObject jSONObject, String str, String str2) {
        try {
            if ("IsShowHeadImgInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if ("IsHideInputToolbarInMsg".equals(str)) {
                jSONObject.put(str, str2);
            } else if (!"IsAgreeProtocol".equals(str)) {
                if ("InteractiveMode".equals(str)) {
                    jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                } else if ("CanReceiveSpeexVoice".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConnectorMsgType".equals(str)) {
                    jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                } else if ("ReportLocationType".equals(str)) {
                    jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                } else if ("AudioPlayType".equals(str)) {
                    jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                } else if ("IsShowMember".equals(str)) {
                    jSONObject.put(str, str2);
                } else if ("ConferenceContactExpireTime".equals(str)) {
                    jSONObject.put(str, str2);
                } else if (!"VerifyMsg2Remark".equals(str)) {
                    if ("VerifyContactPromptTitle".equals(str)) {
                        jSONObject.put(str, str2);
                    } else if (!"IsSubscribeStat".equals(str)) {
                        if ("ScanQRCodeType".equals(str)) {
                            jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                        } else if ("ServiceType".equals(str)) {
                            jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                        } else if (!"NeedShowUserAddrObtaining".equals(str)) {
                            if ("SupportEmoticonLinkPrefix".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("FunctionFlag".equals(str)) {
                                jSONObject.put(str, bg.getInt(str2, jSONObject.optInt(str)));
                            } else if ("NotifyManage".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("ServicePhone".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if ("IsTrademarkProtection".equals(str)) {
                                jSONObject.put(str, str2);
                            } else if (!"CanReceiveLongVideo".equals(str)) {
                                if ("TrademarkUrl".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("TrademarkName".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("MMBizMenu".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if ("VerifySource".equals(str)) {
                                    jSONObject.put(str, str2);
                                } else if (!"MMBizTabbar".equals(str)) {
                                    if ("PayShowInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("HardwareBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if ("EnterpriseBizInfo".equals(str)) {
                                        jSONObject.put(str, str2);
                                    } else if (!"MainPage".equals(str)) {
                                        if ("RegisterSource".equals(str)) {
                                            jSONObject.put(str, str2);
                                        } else if (!"IBeaconBizInfo".equals(str)) {
                                            if ("WxaAppInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WxaAppVersionInfo".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if ("WXAppType".equals(str)) {
                                                jSONObject.put(str, str2);
                                            } else if (!"BindWxaInfo".equals(str)) {
                                                return false;
                                            } else {
                                                jSONObject.put(str, str2);
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (JSONException e) {
            w.e("MicroMsg.BizAttrRenovator", "updateExtInfoAttrs failed, key(%s) value(%s), exception : %s.", str, str2, e);
        }
        return true;
    }
}
