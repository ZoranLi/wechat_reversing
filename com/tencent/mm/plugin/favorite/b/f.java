package com.tencent.mm.plugin.favorite.b;

import com.tencent.mm.protocal.c.rm;
import com.tencent.mm.protocal.c.rn;
import com.tencent.mm.protocal.c.ro;
import com.tencent.mm.protocal.c.rp;
import com.tencent.mm.protocal.c.rs;
import com.tencent.mm.protocal.c.ru;
import com.tencent.mm.protocal.c.rz;
import com.tencent.mm.protocal.c.sf;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.w;
import java.util.List;

public final class f {
    public static String ar(List<rm> list) {
        if (list == null || list.size() == 0) {
            w.v("MicroMsg.FavDataItemParser", "klem toXml data list empty");
            return "";
        }
        int size = list.size();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<datalist count='").append(size).append("'>");
        for (int i = 0; i < size; i++) {
            rm rmVar = (rm) list.get(i);
            stringBuffer.append("<dataitem ");
            if (rmVar.txw) {
                stringBuffer.append("datatype='").append(rmVar.aMw).append("'");
            }
            if (rmVar.txZ) {
                stringBuffer.append(" datastatus='").append(rmVar.txY).append("'");
            }
            if (rmVar.txF) {
                stringBuffer.append(" dataid='").append(rmVar.lKv).append("'");
            }
            if (rmVar.tyl) {
                stringBuffer.append(" htmlid='").append(bg.PW(rmVar.tyk)).append("'");
            }
            if (rmVar.tyr) {
                stringBuffer.append(" dataillegaltype='").append(rmVar.tyq).append("'");
            }
            if (rmVar.txR) {
                stringBuffer.append(" datasourceid='").append(rmVar.txQ).append("'");
            }
            stringBuffer.append(">");
            if (rmVar.txy) {
                stringBuffer.append("<datafmt>").append(rmVar.txx).append("</datafmt>");
            }
            if (rmVar.txb) {
                stringBuffer.append("<datatitle>").append(bg.PW(rmVar.title)).append("</datatitle>");
            }
            if (rmVar.txc) {
                stringBuffer.append("<datadesc>").append(bg.PW(rmVar.desc)).append("</datadesc>");
            }
            if (rmVar.txd) {
                stringBuffer.append("<cdn_thumburl>").append(bg.PW(rmVar.hhy)).append("</cdn_thumburl>");
            }
            if (rmVar.txg) {
                stringBuffer.append("<thumb_width>").append(rmVar.hhD).append("</thumb_width>");
            }
            if (rmVar.txh) {
                stringBuffer.append("<thumb_height>").append(rmVar.hhC).append("</thumb_height>");
            }
            if (rmVar.txj) {
                stringBuffer.append("<cdn_dataurl>").append(bg.PW(rmVar.txi)).append("</cdn_dataurl>");
            }
            if (rmVar.txf) {
                stringBuffer.append("<cdn_thumbkey>").append(bg.PW(rmVar.txe)).append("</cdn_thumbkey>");
            }
            if (rmVar.txl) {
                stringBuffer.append("<cdn_datakey>").append(bg.PW(rmVar.txk)).append("</cdn_datakey>");
            }
            if (rmVar.txn) {
                stringBuffer.append("<cdn_encryver>").append(rmVar.txm).append("</cdn_encryver>");
            }
            if (rmVar.txo) {
                stringBuffer.append("<duration>").append(rmVar.duration).append("</duration>");
            }
            if (rmVar.txq) {
                stringBuffer.append("<stream_weburl>").append(bg.PW(rmVar.txp)).append("</stream_weburl>");
            }
            if (rmVar.txs) {
                stringBuffer.append("<stream_dataurl>").append(bg.PW(rmVar.txr)).append("</stream_dataurl>");
            }
            if (rmVar.txu) {
                stringBuffer.append("<stream_lowbandurl>").append(bg.PW(rmVar.txt)).append("</stream_lowbandurl>");
            }
            if (rmVar.txv) {
                stringBuffer.append("<dataext>").append(bg.PW(rmVar.fFs)).append("</dataext>");
            }
            if (rmVar.txA) {
                stringBuffer.append("<fullmd5>").append(rmVar.txz).append("</fullmd5>");
            }
            if (rmVar.txC) {
                stringBuffer.append("<head256md5>").append(rmVar.txB).append("</head256md5>");
            }
            if (rmVar.txE) {
                stringBuffer.append("<fullsize>").append(rmVar.txD).append("</fullsize>");
            }
            if (rmVar.txL) {
                stringBuffer.append("<thumbfullmd5>").append(rmVar.txK).append("</thumbfullmd5>");
            }
            if (rmVar.txN) {
                stringBuffer.append("<thumbhead256md5>").append(rmVar.txM).append("</thumbhead256md5>");
            }
            if (rmVar.txP) {
                stringBuffer.append("<thumbfullsize>").append(rmVar.txO).append("</thumbfullsize>");
            }
            if (rmVar.txT) {
                stringBuffer.append("<stream_videoid>").append(bg.PW(rmVar.txS)).append("</stream_videoid>");
            }
            if (rmVar.tyb) {
                stringBuffer.append("<datasrctitle>").append(bg.PW(rmVar.tya)).append("</datasrctitle>");
            }
            if (rmVar.tyf) {
                stringBuffer.append("<datasrcname>").append(bg.PW(rmVar.tye)).append("</datasrcname>");
            }
            if (rmVar.tyh) {
                stringBuffer.append("<datasrctime>").append(bg.PW(rmVar.tyg)).append("</datasrctime>");
            }
            if (rmVar.tyn && (rmVar.tyc == null || rmVar.tyc.tyy == null || rmVar.tyc.tyy.aUk() == 0)) {
                stringBuffer.append("<canvasPageXml>").append(bg.PW(rmVar.canvasPageXml)).append("</canvasPageXml>");
            }
            if (rmVar.tym) {
                stringBuffer.append("<statextstr>").append(bg.PW(rmVar.fUY)).append("</statextstr>");
            }
            if (rmVar.tyt) {
                stringBuffer.append("<recordxml>").append(rmVar.tys).append("</recordxml>");
            }
            rp rpVar = rmVar.tyi;
            if (rpVar != null) {
                stringBuffer.append("<streamvideo>");
                stringBuffer.append("<streamvideourl>").append(bg.PW(rpVar.hjD)).append("</streamvideourl>");
                stringBuffer.append("<streamvideototaltime>").append(rpVar.tyZ).append("</streamvideototaltime>");
                stringBuffer.append("<streamvideotitle>").append(bg.PW(rpVar.hjF)).append("</streamvideotitle>");
                stringBuffer.append("<streamvideowording>").append(bg.PW(rpVar.hjG)).append("</streamvideowording>");
                stringBuffer.append("<streamvideoweburl>").append(bg.PW(rpVar.hjH)).append("</streamvideoweburl>");
                stringBuffer.append("<streamvideoaduxinfo>").append(bg.PW(rpVar.hjJ)).append("</streamvideoaduxinfo>");
                stringBuffer.append("<streamvideopublishid>").append(bg.PW(rpVar.hjK)).append("</streamvideopublishid>");
                stringBuffer.append("</streamvideo>");
            }
            rn rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyu == null || rnVar.tyu.aUk() == 0) {
                w.v("MicroMsg.FavDataItemParser", "klem toXml, data source item empty");
            } else {
                ro roVar = rnVar.tyu;
                stringBuffer.append("<dataitemsource");
                if (roVar.tyL) {
                    stringBuffer.append(" sourcetype='").append(roVar.fFq).append("'");
                }
                if (roVar.tyP) {
                    stringBuffer.append(" sourceid='").append(roVar.tyO).append("'");
                }
                stringBuffer.append(">");
                if (roVar.tyM) {
                    stringBuffer.append("<fromusr>").append(bg.PW(roVar.fOu)).append("</fromusr>");
                }
                if (roVar.tyN) {
                    stringBuffer.append("<tousr>").append(bg.PW(roVar.toUser)).append("</tousr>");
                }
                if (roVar.tyR) {
                    stringBuffer.append("<realchatname>").append(bg.PW(roVar.tyQ)).append("</realchatname>");
                }
                if (roVar.tyS) {
                    stringBuffer.append("<msgid>").append(roVar.fSm).append("</msgid>");
                }
                if (roVar.tyT) {
                    stringBuffer.append("<eventid>").append(roVar.fXj).append("</eventid>");
                }
                if (roVar.tyU) {
                    stringBuffer.append("<appid>").append(roVar.appId).append("</appid>");
                }
                if (roVar.tyV) {
                    stringBuffer.append("<link>").append(bg.PW(roVar.hSX)).append("</link>");
                }
                if (roVar.tyY) {
                    stringBuffer.append("<brandid>").append(bg.PW(roVar.fCJ)).append("</brandid>");
                }
                stringBuffer.append("</dataitemsource>");
            }
            rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyw == null || rnVar.tyw.aUk() == 0) {
                w.v("MicroMsg.FavDataItemParser", "klem toXml, loc item empty");
            } else {
                rs rsVar = rnVar.tyw;
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
            }
            rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyy == null || rnVar.tyy.aUk() == 0) {
                w.v("MicroMsg.FavDataItemParser", "klem toXml, url item empty");
            } else {
                sf sfVar = rnVar.tyy;
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
                    stringBuffer.append("<canvasPageXml>").append(bg.PW(sfVar.canvasPageXml)).append("</canvasPageXml>");
                }
                stringBuffer.append("</weburlitem>");
            }
            rnVar = rmVar.tyc;
            if (rnVar == null || rnVar.tyA == null || rnVar.tyA.aUk() == 0) {
                w.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                ru ruVar = rnVar.tyA;
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
            }
            rn rnVar2 = rmVar.tyc;
            if (rnVar2 == null || rnVar2.tyC == null || rnVar2.tyC.aUk() == 0) {
                w.v("MicroMsg.FavDataItemParser", "klem toXml, product item empty");
            } else {
                rz rzVar = rnVar2.tyC;
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
            }
            stringBuffer.append("</dataitem>");
        }
        stringBuffer.append("</datalist>");
        return stringBuffer.toString();
    }
}
