package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.e.b.ba;
import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rv;
import com.tencent.mm.protocal.c.rw;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sd;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Iterator;
import java.util.Map;

public final class j extends ba {
    protected static com.tencent.mm.sdk.e.c.a gTP = ba.pw();
    private static a lEj = new a() {
        public final void vR(String str) {
            w.d("MicroMsg.FavItemInfo", str);
        }
    };
    private static a lEk = new a() {
        public final void vR(String str) {
            w.e("MicroMsg.FavItemInfo", str);
        }
    };

    private interface a {
        void vR(String str);
    }

    public final /* synthetic */ Object clone() {
        return ato();
    }

    public j() {
        this.field_flag = -1;
        this.field_fromUser = "";
        this.field_toUser = "";
        this.field_id = -1;
        this.field_realChatName = "";
        this.field_sourceType = -1;
        this.field_updateTime = -1;
        this.field_type = -1;
        this.field_updateSeq = -1;
        this.field_xml = "";
        this.field_itemStatus = 0;
        atf();
    }

    private void atf() {
        this.field_favProto = new rv();
        rw rwVar = new rw();
        rwVar.yj(1);
        this.field_favProto.a(rwVar);
        this.field_favProto.b(new sf());
        this.field_favProto.b(new rs());
        this.field_favProto.b(new ru());
        this.field_favProto.b(new rz());
        this.field_favProto.yh(-1);
        this.field_tagProto = new sd();
    }

    protected final com.tencent.mm.sdk.e.c.a sY() {
        return gTP;
    }

    public final boolean atg() {
        return (this.field_favProto.tyH & 1) != 0;
    }

    public final boolean ath() {
        return (this.field_favProto.tyH & 2) != 0;
    }

    public final boolean ati() {
        if (this.field_itemStatus == 1 || this.field_itemStatus == 4 || this.field_itemStatus == 9 || this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 15 || this.field_itemStatus == 17) {
            return true;
        }
        return false;
    }

    public final boolean atj() {
        if (this.field_itemStatus == 3 || this.field_itemStatus == 6 || this.field_itemStatus == 11 || this.field_itemStatus == 14 || this.field_itemStatus == 16 || this.field_itemStatus == 18) {
            return true;
        }
        return false;
    }

    public final boolean atk() {
        return this.field_itemStatus == 7;
    }

    public final boolean atl() {
        return this.field_itemStatus == 8;
    }

    public final boolean isDone() {
        return this.field_itemStatus == 10;
    }

    public final boolean atm() {
        if (this.field_itemStatus == 15 || this.field_itemStatus == 16) {
            return true;
        }
        return false;
    }

    public final boolean atn() {
        if (this.field_itemStatus == 12 || this.field_itemStatus == 13 || this.field_itemStatus == 14) {
            return true;
        }
        return false;
    }

    public final j vO(String str) {
        if (str == null || str.equals("")) {
            w.e("MicroMsg.FavItemInfo", "klem, FavItemInfo xml null");
        } else {
            Map q = bh.q(str, "favitem");
            if (q == null) {
                w.e("MicroMsg.FavItemInfo", "klem, FavItemInfo maps null");
            } else {
                try {
                    atf();
                    rv rvVar = this.field_favProto;
                    rvVar.OB((String) q.get(".favitem.title"));
                    rvVar.OC((String) q.get(".favitem.desc"));
                    rvVar.OA((String) q.get(".favitem.remark"));
                    rvVar.en(bg.getLong((String) q.get(".favitem.remark.$time"), 0));
                    String str2 = (String) q.get(".favitem.edittime");
                    rvVar.yi(bg.getInt((String) q.get(".favitem.version"), 0));
                    rvVar.eo(bg.getLong(str2, 0));
                    rvVar.yh(bg.getInt((String) q.get(".favitem.ctrlflag"), -1));
                    String str3 = ".favitem.source";
                    rw rwVar = rvVar.tzl;
                    rwVar.yj(bg.getInt((String) q.get(str3 + ".$sourcetype"), 0));
                    rwVar.OF((String) q.get(str3 + ".$sourceid"));
                    rwVar.OD((String) q.get(str3 + ".fromusr"));
                    rwVar.OE((String) q.get(str3 + ".tousr"));
                    rwVar.OG((String) q.get(str3 + ".realchatname"));
                    rwVar.ep(bg.getLong((String) q.get(str3 + ".createtime"), 0));
                    rwVar.OH((String) q.get(str3 + ".msgid"));
                    rwVar.OI((String) q.get(str3 + ".eventid"));
                    rwVar.OJ((String) q.get(str3 + ".appid"));
                    rwVar.OK((String) q.get(str3 + ".link"));
                    rwVar.OL((String) q.get(str3 + ".brandid"));
                    n.a(str, rvVar);
                    str3 = ".favitem.locitem";
                    rs rsVar = rvVar.tyw;
                    if (!bg.mA((String) q.get(str3 + ".label"))) {
                        rsVar.Ou((String) q.get(str3 + ".label"));
                    }
                    if (!bg.mA((String) q.get(str3 + ".poiname"))) {
                        rsVar.Ov((String) q.get(str3 + ".poiname"));
                    }
                    str2 = (String) q.get(str3 + ".lng");
                    if (!bg.mA(str2)) {
                        rsVar.l(bg.getDouble(str2, 0.0d));
                    }
                    str2 = (String) q.get(str3 + ".lat");
                    if (!bg.mA(str2)) {
                        rsVar.m(bg.getDouble(str2, 0.0d));
                    }
                    str2 = (String) q.get(str3 + ".scale");
                    if (!bg.mA(str2)) {
                        if (str2.indexOf(46) != -1) {
                            rsVar.yf(bg.getInt(str2.substring(0, str2.indexOf(46)), -1));
                        } else {
                            rsVar.yf(bg.getInt(str2, -1));
                        }
                    }
                    str3 = ".favitem.weburlitem";
                    sf sfVar = rvVar.tyy;
                    sfVar.OS((String) q.get(str3 + ".clean_url"));
                    sfVar.OR((String) q.get(str3 + ".pagedesc"));
                    sfVar.OT((String) q.get(str3 + ".pagethumb_url"));
                    sfVar.OQ((String) q.get(str3 + ".pagetitle"));
                    sfVar.yk(bg.getInt((String) q.get(str3 + ".opencache"), 0));
                    sfVar.yl(bg.getInt((String) q.get(str3 + ".contentattr"), 0));
                    sfVar.OU((String) q.get(str3 + ".canvasPageXml"));
                    str3 = ".favitem.productitem";
                    ru ruVar = rvVar.tyA;
                    ruVar.Ow((String) q.get(str3 + ".producttitle"));
                    ruVar.Ox((String) q.get(str3 + ".productdesc"));
                    ruVar.Oy((String) q.get(str3 + ".productthumb_url"));
                    ruVar.Oz((String) q.get(str3 + ".productinfo"));
                    ruVar.yg(bg.getInt((String) q.get(str3 + ".$type"), 0));
                    str3 = ".favitem.tvitem";
                    rz rzVar = rvVar.tyC;
                    rzVar.OM((String) q.get(str3 + ".tvtitle"));
                    rzVar.ON((String) q.get(str3 + ".tvdesc"));
                    rzVar.OO((String) q.get(str3 + ".tvthumb_url"));
                    rzVar.OP((String) q.get(str3 + ".tvinfo"));
                    if (this.field_favProto.tzl != null) {
                        rw rwVar2 = this.field_favProto.tzl;
                        this.field_sourceId = rwVar2.tzq;
                        this.field_sourceType = rwVar2.fFq;
                        this.field_fromUser = rwVar2.fOu;
                        this.field_toUser = rwVar2.toUser;
                    }
                    this.field_edittime = this.field_favProto.tyJ;
                    s.a(q, this.field_tagProto);
                } catch (Throwable e) {
                    w.printErrStackTrace("MicroMsg.FavItemInfo", e, "", new Object[0]);
                    w.e("MicroMsg.FavItemInfo", "klem , FavItemInfo exception:+%s", new Object[]{e.toString()});
                }
            }
        }
        return this;
    }

    public final void vP(String str) {
        a aVar = lEj;
        aVar.vR("----dump favitem from[" + str + "] beg----");
        aVar.vR("type: " + this.field_type);
        aVar.vR("favId: " + this.field_id);
        aVar.vR("localId: " + this.field_localId);
        aVar.vR("itemStatus: " + this.field_itemStatus);
        aVar.vR("localSeq: " + this.field_localSeq);
        aVar.vR("updateSeq: " + this.field_updateSeq);
        aVar.vR("ctrlFlag: " + this.field_flag);
        aVar.vR("sourceId: " + this.field_sourceId);
        aVar.vR("sourceType: " + this.field_sourceType);
        aVar.vR("sourceCreateTime: " + this.field_sourceCreateTime);
        aVar.vR("updateTime: " + this.field_updateTime);
        aVar.vR("editTime: " + this.field_edittime);
        aVar.vR("fromuser: " + this.field_fromUser);
        aVar.vR("toUser: " + this.field_toUser);
        aVar.vR("realChatName: " + this.field_realChatName);
        if (this.field_favProto != null) {
            aVar.vR("remarktime: " + this.field_favProto.tyF);
            aVar.vR("dataitemCount: " + this.field_favProto.tzn.size());
            if (this.field_favProto.tzl != null) {
                aVar.vR(" ----source item----");
                rw rwVar = this.field_favProto.tzl;
                aVar.vR("  sourceType: " + rwVar.fFq);
                aVar.vR("  fromUser: " + rwVar.fOu);
                aVar.vR("  toUser: " + rwVar.toUser);
                aVar.vR("  sourceId: " + rwVar.tzq);
                aVar.vR("  realChatName: " + rwVar.tyQ);
                aVar.vR("  createTime: " + rwVar.iam);
                aVar.vR("  msgId: " + rwVar.fSm);
                aVar.vR("  eventId: " + rwVar.fXj);
                aVar.vR("  appId: " + rwVar.appId);
                aVar.vR("  link: " + rwVar.hSX);
                aVar.vR("  mediaId: " + rwVar.tyW);
                aVar.vR("  brandId: " + rwVar.fCJ);
            }
            Iterator it = this.field_favProto.tzn.iterator();
            int i = 0;
            while (it.hasNext()) {
                rm rmVar = (rm) it.next();
                int i2 = i + 1;
                aVar.vR(" ----data item " + i + "----");
                aVar.vR("  dataId: " + rmVar.lKv);
                aVar.vR("  dataType: " + rmVar.aMw);
                aVar.vR("  dataSouceId: " + rmVar.txQ);
                aVar.vR("  svrDataStatus: " + rmVar.txY);
                aVar.vR("  cdnThumbUrl: " + rmVar.hhy);
                aVar.vR("  cdnThumbKey: " + rmVar.txe);
                aVar.vR("  cdnDataUrl: " + rmVar.txi);
                aVar.vR("  cdnDataKey: " + rmVar.txk);
                aVar.vR("  cdnEncryVer: " + rmVar.txm);
                aVar.vR("  fullmd5: " + rmVar.txz);
                aVar.vR("  head256md5: " + rmVar.txB);
                aVar.vR("  fullsize: " + rmVar.txD);
                aVar.vR("  thumbMd5: " + rmVar.txK);
                aVar.vR("  thumbHead256md5: " + rmVar.txM);
                aVar.vR("  thumbfullsize: " + rmVar.txO);
                aVar.vR("  duration: " + rmVar.duration);
                aVar.vR("  datafmt: " + rmVar.txx);
                aVar.vR("  streamWebUrl: " + rmVar.txp);
                aVar.vR("  streamDataUrl: " + rmVar.txr);
                aVar.vR("  streamLowBandUrl: " + rmVar.txt);
                aVar.vR("  ext: " + rmVar.fFs);
                if (rmVar.tyc != null) {
                    aVar.vR("  remarktime: " + rmVar.tyc.tyF);
                    aVar.vR("  ctrlflag: " + rmVar.tyc.tyH);
                    aVar.vR("  edittime: " + rmVar.tyc.tyJ);
                    if (rmVar.tyc.tyu != null) {
                        aVar.vR("   ----data source item----");
                        ro roVar = rmVar.tyc.tyu;
                        aVar.vR("    sourceType: " + roVar.fFq);
                        aVar.vR("    fromUser: " + roVar.fOu);
                        aVar.vR("    toUser: " + roVar.toUser);
                        aVar.vR("    realChatName: " + roVar.tyQ);
                        aVar.vR("    createTime: " + roVar.iam);
                        aVar.vR("    msgId: " + roVar.fSm);
                        aVar.vR("    eventId: " + roVar.fXj);
                        aVar.vR("    appId: " + roVar.appId);
                        aVar.vR("    link: " + roVar.hSX);
                        aVar.vR("    mediaId: " + roVar.tyW);
                        aVar.vR("    brandId: " + roVar.fCJ);
                    }
                    a("  ", aVar, rmVar.tyc.tyw);
                    a("  ", aVar, rmVar.tyc.tyy);
                    a("  ", aVar, rmVar.tyc.tyA);
                    a("  ", aVar, rmVar.tyc.tyC);
                }
                i = i2;
            }
            a("", aVar, this.field_favProto.tyw);
            a("", aVar, this.field_favProto.tyy);
            a("", aVar, this.field_favProto.tyA);
            a("", aVar, this.field_favProto.tyC);
        }
        aVar.vR("----dump favitem end----");
    }

    private static void a(String str, a aVar, rz rzVar) {
        if (rzVar != null) {
            aVar.vR(str + " ----tv item----");
            aVar.vR(str + "  title: " + rzVar.title);
            aVar.vR(str + "  desc: " + rzVar.desc);
            aVar.vR(str + "  thumbUrl: " + rzVar.thumbUrl);
        }
    }

    private static void a(String str, a aVar, ru ruVar) {
        if (ruVar != null) {
            aVar.vR(str + " ----product item----");
            aVar.vR(str + "  title: " + ruVar.title);
            aVar.vR(str + "  desc: " + ruVar.desc);
            aVar.vR(str + "  thumbUrl: " + ruVar.thumbUrl);
            aVar.vR(str + "  type: " + ruVar.type);
        }
    }

    private static void a(String str, a aVar, rs rsVar) {
        if (rsVar != null) {
            aVar.vR(str + " ----loc item----");
            aVar.vR(str + "  lng: " + rsVar.lng);
            aVar.vR(str + "  lat: " + rsVar.lat);
            aVar.vR(str + "  scale: " + rsVar.fOd);
            aVar.vR(str + "  label: " + rsVar.label);
            aVar.vR(str + "  poiname: " + rsVar.fRX);
        }
    }

    private static void a(String str, a aVar, sf sfVar) {
        if (sfVar != null) {
            aVar.vR(str + " ----url item----");
            aVar.vR(str + "  title: " + sfVar.title);
            aVar.vR(str + "  desc: " + sfVar.desc);
            aVar.vR(str + "  cleanUrl: " + sfVar.tzN);
            aVar.vR(str + "  thumbUrl: " + sfVar.thumbUrl);
            aVar.vR(str + "  opencache: " + sfVar.tzP);
        }
    }

    public final boolean vQ(String str) {
        if (bg.mA(str)) {
            return false;
        }
        Iterator it = this.field_tagProto.tzx.iterator();
        while (it.hasNext()) {
            if (str.equals((String) it.next())) {
                return false;
            }
        }
        this.field_tagProto.tzx.add(str);
        return true;
    }

    public static String b(j jVar) {
        String str;
        StringBuffer stringBuffer;
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("<favitem");
        stringBuffer2.append(" type='").append(jVar.field_type).append("'");
        stringBuffer2.append(">");
        rv rvVar = jVar.field_favProto;
        StringBuilder stringBuilder = new StringBuilder();
        if (!bg.mA(rvVar.title)) {
            stringBuilder.append("<title>").append(bg.PW(rvVar.title)).append("</title>");
        }
        if (!bg.mA(rvVar.desc)) {
            stringBuilder.append("<desc>").append(bg.PW(rvVar.desc)).append("</desc>");
        }
        if (rvVar.tyJ > 0) {
            stringBuilder.append("<edittime>").append(rvVar.tyJ).append("</edittime>");
        }
        if (!bg.mA(rvVar.iBi)) {
            stringBuilder.append("<remark ");
            if (rvVar.tyF > 0) {
                stringBuilder.append(" time ='").append(rvVar.tyF).append("'");
            }
            stringBuilder.append(">").append(bg.PW(rvVar.iBi)).append("</remark>");
        }
        if (rvVar.tyI) {
            stringBuilder.append("<ctrlflag>").append(rvVar.tyH).append("</ctrlflag>");
        }
        if (rvVar.tzp) {
            stringBuilder.append("<version>").append(rvVar.version).append("</version>");
        } else if (jVar.field_type == 18) {
            stringBuilder.append("<version>1</version>");
        }
        rw rwVar = rvVar.tzl;
        if (rwVar == null || rwVar.aUk() == 0) {
            w.w("MicroMsg.FavSourceItemParser", "klem toXml, source item empty");
            str = "";
        } else {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("<source");
            if (rwVar.tyL) {
                stringBuffer3.append(" sourcetype='").append(rwVar.fFq).append("'");
            }
            if (rwVar.tzr) {
                stringBuffer3.append(" sourceid='").append(rwVar.tzq).append("'");
            }
            stringBuffer3.append(">");
            if (rwVar.tyM) {
                stringBuffer3.append("<fromusr>").append(bg.PW(rwVar.fOu)).append("</fromusr>");
            }
            if (rwVar.tyN) {
                stringBuffer3.append("<tousr>").append(bg.PW(rwVar.toUser)).append("</tousr>");
            }
            if (rwVar.tyR) {
                stringBuffer3.append("<realchatname>").append(bg.PW(rwVar.tyQ)).append("</realchatname>");
            }
            if (rwVar.tyS) {
                stringBuffer3.append("<msgid>").append(rwVar.fSm).append("</msgid>");
            }
            if (rwVar.tyT) {
                stringBuffer3.append("<eventid>").append(rwVar.fXj).append("</eventid>");
            }
            if (rwVar.tyU) {
                stringBuffer3.append("<appid>").append(rwVar.appId).append("</appid>");
            }
            if (rwVar.tyV) {
                stringBuffer3.append("<link>").append(bg.PW(rwVar.hSX)).append("</link>");
            }
            if (rwVar.tyY) {
                stringBuffer3.append("<brandid>").append(bg.PW(rwVar.fCJ)).append("</brandid>");
            }
            stringBuffer3.append("</source>");
            str = stringBuffer3.toString();
        }
        stringBuilder.append(str);
        stringBuilder.append(f.ar(rvVar.tzn));
        rs rsVar = jVar.field_favProto.tyw;
        if (rsVar == null || rsVar.aUk() == 0) {
            w.d("MicroMsg.FavLocItemParser", "klem toXml, loc item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<locitem>");
            if (rsVar.tzg) {
                stringBuffer.append("<label>").append(bg.PW(rsVar.label)).append("</label>");
            }
            if (rsVar.tze) {
                stringBuffer.append("<lat>").append(rsVar.lat).append("</lat>");
            }
            if (rsVar.tzd) {
                stringBuffer.append("<lng>").append(rsVar.lng).append("</lng>");
            }
            if (rsVar.tzf) {
                stringBuffer.append("<scale>").append(rsVar.fOd).append("</scale>");
            }
            if (rsVar.tzh) {
                stringBuffer.append("<poiname>").append(rsVar.fRX).append("</poiname>");
            }
            stringBuffer.append("</locitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        sf sfVar = jVar.field_favProto.tyy;
        if (sfVar == null || sfVar.aUk() == 0) {
            w.d("MicroMsg.FavUrlItemParser", "klem toXml, url item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<weburlitem>");
            if (sfVar.tzO) {
                stringBuffer.append("<clean_url>").append(bg.PW(sfVar.tzN)).append("</clean_url>");
            }
            if (sfVar.txc) {
                stringBuffer.append("<pagedesc>").append(bg.PW(sfVar.desc)).append("</pagedesc>");
            }
            if (sfVar.tzi) {
                stringBuffer.append("<pagethumb_url>").append(bg.PW(sfVar.thumbUrl)).append("</pagethumb_url>");
            }
            if (sfVar.txb) {
                stringBuffer.append("<pagetitle>").append(bg.PW(sfVar.title)).append("</pagetitle>");
            }
            if (sfVar.tzQ) {
                stringBuffer.append("<opencache>").append(sfVar.tzP).append("</opencache>");
            }
            if (sfVar.tzR) {
                stringBuffer.append("<contentattr>").append(sfVar.hhv).append("</contentattr>");
            }
            if (sfVar.tyn) {
                stringBuffer.append("<canvasPageXml>").append(sfVar.canvasPageXml).append("</canvasPageXml>");
            }
            stringBuffer.append("</weburlitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        ru ruVar = jVar.field_favProto.tyA;
        if (ruVar == null || ruVar.aUk() == 0) {
            w.d("MicroMsg.FavProductItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<productitem");
            if (ruVar.tzk) {
                stringBuffer.append(" type='").append(ruVar.type).append("'");
            }
            stringBuffer.append(">");
            if (ruVar.txb) {
                stringBuffer.append("<producttitle>").append(bg.PW(ruVar.title)).append("</producttitle>");
            }
            if (ruVar.txc) {
                stringBuffer.append("<productdesc>").append(bg.PW(ruVar.desc)).append("</productdesc>");
            }
            if (ruVar.tzi) {
                stringBuffer.append("<productthumb_url>").append(bg.PW(ruVar.thumbUrl)).append("</productthumb_url>");
            }
            if (ruVar.tzj) {
                stringBuffer.append("<productinfo>").append(bg.PW(ruVar.info)).append("</productinfo>");
            }
            stringBuffer.append("</productitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        rz rzVar = jVar.field_favProto.tyC;
        if (rzVar == null || rzVar.aUk() == 0) {
            w.d("MicroMsg.FavTVItemParser", "klem toXml, product item empty");
            str = "";
        } else {
            stringBuffer = new StringBuffer();
            stringBuffer.append("<tvitem>");
            if (rzVar.txb) {
                stringBuffer.append("<tvtitle>").append(bg.PW(rzVar.title)).append("</tvtitle>");
            }
            if (rzVar.txc) {
                stringBuffer.append("<tvdesc>").append(bg.PW(rzVar.desc)).append("</tvdesc>");
            }
            if (rzVar.tzi) {
                stringBuffer.append("<tvthumb_url>").append(bg.PW(rzVar.thumbUrl)).append("</tvthumb_url>");
            }
            if (rzVar.tzj) {
                stringBuffer.append("<tvinfo>").append(bg.PW(rzVar.info)).append("</tvinfo>");
            }
            stringBuffer.append("</tvitem>");
            str = stringBuffer.toString();
        }
        stringBuilder.append(str);
        stringBuffer2.append(stringBuilder.toString());
        stringBuffer2.append(s.a(jVar.field_tagProto));
        stringBuffer2.append("</favitem>");
        return stringBuffer2.toString();
    }

    public final j ato() {
        j jVar = new j();
        jVar.field_favProto = this.field_favProto;
        jVar.field_sourceId = this.field_sourceId;
        jVar.field_edittime = this.field_edittime;
        jVar.field_ext = this.field_ext;
        jVar.field_flag = this.field_flag;
        jVar.field_fromUser = this.field_fromUser;
        jVar.field_id = this.field_id;
        jVar.field_itemStatus = this.field_itemStatus;
        jVar.field_localId = this.field_localId;
        jVar.field_localSeq = this.field_localSeq;
        jVar.field_realChatName = this.field_realChatName;
        jVar.field_tagProto = this.field_tagProto;
        jVar.field_sourceCreateTime = this.field_sourceCreateTime;
        jVar.field_updateSeq = this.field_updateSeq;
        jVar.field_toUser = this.field_toUser;
        jVar.field_updateTime = this.field_updateTime;
        jVar.field_type = this.field_type;
        jVar.field_xml = this.field_xml;
        jVar.field_datatotalsize = this.field_datatotalsize;
        return jVar;
    }
}
