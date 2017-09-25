package com.tencent.tinker.a.b.a;

import android.support.v7.a.a;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseImage;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseMedia;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiChooseWeChatContact;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetLocation;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiGetMusicPlayerState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiLaunchMiniProgram;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiMakeVoIPCall;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateBackgroundAudio;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiOperateMusicPlayer;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiScanCode;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiSetBackgroundAudioState;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStartRecordVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiStopPlayVoice;
import com.tencent.mm.plugin.appbrand.jsapi.JsApiUploadEncryptedFileToCDN;
import com.tencent.mm.plugin.appbrand.jsapi.ac;
import com.tencent.mm.plugin.appbrand.jsapi.ag;
import com.tencent.mm.plugin.appbrand.jsapi.ao;
import com.tencent.mm.plugin.appbrand.jsapi.aq;
import com.tencent.mm.plugin.appbrand.jsapi.auth.JsApiOperateWXData;
import com.tencent.mm.plugin.appbrand.jsapi.bc;
import com.tencent.mm.plugin.appbrand.jsapi.bg;
import com.tencent.mm.plugin.appbrand.jsapi.bh;
import com.tencent.mm.plugin.appbrand.jsapi.bio.face.JsApiCheckIsSupportFaceDetect;
import com.tencent.mm.plugin.appbrand.jsapi.bl;
import com.tencent.mm.plugin.appbrand.jsapi.bv;
import com.tencent.mm.plugin.appbrand.jsapi.bw;
import com.tencent.mm.plugin.appbrand.jsapi.cf;
import com.tencent.mm.plugin.appbrand.jsapi.ck;
import com.tencent.mm.plugin.appbrand.jsapi.cn;
import com.tencent.mm.plugin.appbrand.jsapi.cp;
import com.tencent.mm.plugin.appbrand.jsapi.map.b;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.f;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.v;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.wcdb.FileUtils;

public final class d {
    private final g xdo;

    public d(g gVar) {
        this.xdo = gVar;
    }

    public final void a(e eVar) {
        a aVar = this.xdo;
        aVar.xdk.hP = 0;
        aVar.xdl = 0;
        while (true) {
            aVar = this.xdo;
            if ((aVar.xdl < aVar.xdt.length ? 1 : null) != null) {
                int i = this.xdo.xdl;
                int read = this.xdo.read();
                int i2 = read & 255;
                if (i2 == 0 || i2 == 255) {
                    i2 = read;
                }
                int i3;
                int i4;
                int read2;
                int i5;
                int i6;
                int Dw;
                int readInt;
                int[] iArr;
                switch (i2) {
                    case -1:
                        eVar.a(i, read, 0, 1, 0, 0);
                        break;
                    case 0:
                    case 14:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.Dt(read));
                        break;
                    case 1:
                    case 4:
                    case 7:
                    case 33:
                    case 123:
                    case 124:
                    case 125:
                    case 126:
                    case 127:
                    case FileUtils.S_IWUSR /*128*/:
                    case 129:
                    case 130:
                    case 131:
                    case 132:
                    case e.CTRL_INDEX /*133*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.map.d.CTRL_INDEX /*134*/:
                    case b.CTRL_INDEX /*135*/:
                    case i.CTRL_INDEX /*136*/:
                    case 137:
                    case 138:
                    case w.CTRL_INDEX /*139*/:
                    case c.CTRL_INDEX /*140*/:
                    case k.CTRL_INDEX /*141*/:
                    case 142:
                    case 143:
                    case 176:
                    case 177:
                    case 178:
                    case 179:
                    case 180:
                    case 181:
                    case an.CTRL_BYTE /*182*/:
                    case 183:
                    case 184:
                    case 185:
                    case 186:
                    case as.CTRL_BYTE /*187*/:
                    case m.CTRL_BYTE /*188*/:
                    case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE /*189*/:
                    case 190:
                    case j.CTRL_BYTE /*191*/:
                    case bg.CTRL_INDEX /*192*/:
                    case JsApiChooseMedia.CTRL_INDEX /*193*/:
                    case JsApiUploadEncryptedFileToCDN.CTRL_INDEX /*194*/:
                    case JsApiChooseWeChatContact.CTRL_INDEX /*195*/:
                    case 196:
                    case 197:
                    case 198:
                    case 199:
                    case com.tencent.mm.plugin.appbrand.jsapi.map.m.CTRL_INDEX /*200*/:
                    case bh.CTRL_INDEX /*201*/:
                    case f.CTRL_INDEX /*202*/:
                    case aq.CTRL_INDEX /*203*/:
                    case ao.CTRL_INDEX /*204*/:
                    case cf.CTRL_INDEX /*205*/:
                    case v.CTRL_INDEX /*206*/:
                    case 207:
                        eVar.a(i, read & 255, 0, 1, 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 2:
                    case 5:
                    case 8:
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.Dt(read), this.xdo.read());
                        break;
                    case 3:
                    case 6:
                    case 9:
                        eVar.a(i, read & 255, 0, 1, 0, (long) b.Dt(read), this.xdo.read(), this.xdo.read());
                        break;
                    case 10:
                    case 11:
                    case 12:
                    case 13:
                    case 15:
                    case 16:
                    case 17:
                    case JsApiChooseImage.CTRL_INDEX /*29*/:
                    case 30:
                    case 39:
                        eVar.a(i, read & 255, 0, 1, 0, 0, b.Dt(read));
                        break;
                    case 18:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((((read >> 12) & 15) << 28) >> 28), (read >> 8) & 15);
                        break;
                    case 19:
                    case 22:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.xdo.read()), b.Dt(read));
                        break;
                    case 20:
                    case 23:
                        eVar.a(i, read & 255, 0, 1, 0, (long) this.xdo.readInt(), b.Dt(read));
                        break;
                    case 21:
                    case 25:
                        i3 = read & 255;
                        eVar.a(i, i3, 0, 1, 0, ((long) ((short) this.xdo.read())) << (i3 == 21 ? 16 : 48), b.Dt(read));
                        break;
                    case 24:
                        eVar.a(i, read & 255, 0, 1, 0, this.xdo.readLong(), b.Dt(read));
                        break;
                    case 26:
                    case 28:
                    case JsApiStartRecordVoice.CTRL_INDEX /*31*/:
                    case 34:
                    case PlayerException.EXCEPTION_IN_SETAUDIOEFFECT /*96*/:
                    case PlayerException.EXCEPTION_IN_RELEASE /*97*/:
                    case 98:
                    case 99:
                    case 100:
                    case 101:
                    case 102:
                    case 103:
                    case 104:
                    case MMGIFException.D_GIF_ERR_NO_IMAG_DSCR /*105*/:
                    case MMGIFException.D_GIF_ERR_NO_COLOR_MAP /*106*/:
                    case MMGIFException.D_GIF_ERR_WRONG_RECORD /*107*/:
                    case 108:
                    case MMGIFException.D_GIF_ERR_NOT_ENOUGH_MEM /*109*/:
                        i3 = read & 255;
                        eVar.a(i, i3, this.xdo.read(), b.Dw(i3), 0, 0, b.Dt(read));
                        break;
                    case 27:
                        i3 = read & 255;
                        eVar.a(i, i3, this.xdo.readInt(), b.Dw(i3), 0, 0, b.Dt(read));
                        break;
                    case 32:
                    case JsApiStopPlayVoice.CTRL_INDEX /*35*/:
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_JAVA_DATASOURCE /*82*/:
                    case cn.CTRL_INDEX /*83*/:
                    case 84:
                    case 85:
                    case 86:
                    case 87:
                    case 88:
                    case 89:
                    case PlayerException.EXCEPTION_IN_SETDATASOURCE /*90*/:
                    case PlayerException.EXCEPTION_IN_PREPARE /*91*/:
                    case 92:
                    case PlayerException.EXCEPTION_IN_PAUSE /*93*/:
                    case 94:
                    case PlayerException.EXCEPTION_IN_SEEK /*95*/:
                        i4 = read & 255;
                        eVar.a(i, i4, this.xdo.read(), b.Dw(i4), 0, 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case 36:
                    case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
                    case 111:
                    case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
                    case 113:
                    case 114:
                        int i7 = read & 255;
                        int i8 = (read >> 8) & 15;
                        i2 = (read >> 12) & 15;
                        read2 = this.xdo.read();
                        read = this.xdo.read();
                        i5 = read & 15;
                        i3 = (read >> 4) & 15;
                        i4 = (read >> 8) & 15;
                        i6 = (read >> 12) & 15;
                        Dw = b.Dw(i7);
                        switch (i2) {
                            case 0:
                                eVar.a(i, i7, read2, Dw, 0, 0);
                                break;
                            case 1:
                                eVar.a(i, i7, read2, Dw, 0, 0, i5);
                                break;
                            case 2:
                                eVar.a(i, i7, read2, Dw, 0, 0, i5, i3);
                                break;
                            case 3:
                                eVar.a(i, i7, read2, Dw, 0, 0, i5, i3, i4);
                                break;
                            case 4:
                                eVar.a(i, i7, read2, Dw, 0, 0, i5, i3, i4, i6);
                                break;
                            case 5:
                                eVar.a(i, i7, read2, Dw, 0, 0, i5, i3, i4, i6, i8);
                                break;
                            default:
                                throw new com.tencent.tinker.a.a.j("bogus registerCount: " + new String(new char[]{Character.forDigit(i2 & 15, 16)}));
                        }
                    case JsApiGetLocation.CTRL_INDEX /*37*/:
                    case 116:
                    case 117:
                    case 118:
                    case 119:
                    case 120:
                        i4 = read & 255;
                        eVar.b(i, i4, this.xdo.read(), b.Dw(i4), 0, 0, this.xdo.read(), b.Dt(read));
                        break;
                    case 38:
                    case 43:
                    case 44:
                        i3 = read & 255;
                        i5 = b.Dt(read);
                        readInt = i + this.xdo.readInt();
                        switch (i3) {
                            case 43:
                            case 44:
                                this.xdo.eF(readInt + 1, i);
                                break;
                        }
                        eVar.a(i, i3, 0, 1, readInt, 0, i5);
                        break;
                    case 40:
                        eVar.a(i, read & 255, 0, 1, i + ((byte) b.Dt(read)), 0);
                        break;
                    case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v.CTRL_BYTE /*41*/:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.xdo.read()), (long) b.Dt(read));
                        break;
                    case 42:
                        eVar.a(i, read & 255, 0, 1, i + this.xdo.readInt(), (long) b.Dt(read));
                        break;
                    case 45:
                    case JsApiGetMusicPlayerState.CTRL_INDEX /*46*/:
                    case JsApiOperateMusicPlayer.CTRL_INDEX /*47*/:
                    case 48:
                    case 49:
                    case bl.CTRL_INDEX /*68*/:
                    case 69:
                    case 70:
                    case 71:
                    case q.CTRL_INDEX /*72*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.share.b.CTRL_INDEX /*73*/:
                    case 74:
                    case 75:
                    case 76:
                    case am.CTRL_BYTE /*77*/:
                    case a.k.LI /*78*/:
                    case JsApiOperateWXData.CTRL_INDEX /*79*/:
                    case PlayerException.EXCEPTION_TYPE_CONNECT_FAIL /*80*/:
                    case PlayerException.EXCEPTION_TYPE_ERROR_CREATE_NATIVE_DATASOURCE /*81*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.map.f.CTRL_INDEX /*144*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.a.CTRL_INDEX /*145*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.share.e.CTRL_INDEX /*146*/:
                    case 147:
                    case JsApiScanCode.CTRL_INDEX /*148*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.g.c.CTRL_INDEX /*149*/:
                    case ck.CTRL_INDEX /*150*/:
                    case 151:
                    case com.tencent.mm.plugin.appbrand.jsapi.contact.b.CTRL_INDEX /*152*/:
                    case 153:
                    case JsApiMakeVoIPCall.CTRL_INDEX /*154*/:
                    case 155:
                    case 156:
                    case 157:
                    case 158:
                    case JsApiGetBackgroundAudioState.CTRL_INDEX /*159*/:
                    case JsApiSetBackgroundAudioState.CTRL_INDEX /*160*/:
                    case JsApiOperateBackgroundAudio.CTRL_INDEX /*161*/:
                    case 162:
                    case 163:
                    case 164:
                    case 165:
                    case JsApiLaunchMiniProgram.CTRL_INDEX /*166*/:
                    case 167:
                    case bw.CTRL_INDEX /*168*/:
                    case ac.CTRL_INDEX /*169*/:
                    case 170:
                    case 171:
                    case 172:
                    case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.ac.CTRL_BYTE /*173*/:
                    case GameJsApiOperateGameCenterMsg.CTRL_BYTE /*174*/:
                    case aa.CTRL_BYTE /*175*/:
                        i6 = read & 255;
                        i5 = b.Dt(read);
                        i2 = this.xdo.read();
                        eVar.a(i, i6, 0, 1, 0, 0, i5, i2 & 255, b.Dt(i2));
                        break;
                    case 50:
                    case 51:
                    case 52:
                    case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
                    case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
                    case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.xdo.read()), 0, (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case FileUtils.S_IRWXG /*56*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.g.b.CTRL_INDEX /*57*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.m.CTRL_INDEX /*58*/:
                    case bc.CTRL_INDEX /*59*/:
                    case 60:
                    case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                        eVar.a(i, read & 255, 0, 1, i + ((short) this.xdo.read()), 0, b.Dt(read));
                        break;
                    case bv.CTRL_INDEX /*208*/:
                    case ag.CTRL_INDEX /*209*/:
                    case h.CTRL_INDEX /*210*/:
                    case g.CTRL_INDEX /*211*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
                    case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
                    case cp.CTRL_INDEX /*215*/:
                        eVar.a(i, read & 255, 0, 1, 0, (long) ((short) this.xdo.read()), (read >> 8) & 15, (read >> 12) & 15);
                        break;
                    case com.tencent.mm.plugin.appbrand.jsapi.e.c.CTRL_INDEX /*216*/:
                    case com.tencent.mm.plugin.appbrand.jsapi.e.b.CTRL_INDEX /*217*/:
                    case 218:
                    case 219:
                    case 220:
                    case 221:
                    case 222:
                    case 223:
                    case 224:
                    case 225:
                    case n.CTRL_INDEX /*226*/:
                        i4 = read & 255;
                        i5 = b.Dt(read);
                        i2 = this.xdo.read();
                        eVar.a(i, i4, 0, 1, 0, (long) ((byte) b.Dt(i2)), i5, i2 & 255);
                        break;
                    case 256:
                        read2 = this.xdo.cgH();
                        Dw = this.xdo.read();
                        readInt = this.xdo.readInt();
                        iArr = new int[Dw];
                        for (i2 = 0; i2 < Dw; i2++) {
                            iArr[i2] = this.xdo.readInt() + read2;
                        }
                        eVar.b(i, read, readInt, iArr);
                        break;
                    case 512:
                        read2 = this.xdo.cgH();
                        Dw = this.xdo.read();
                        int[] iArr2 = new int[Dw];
                        iArr = new int[Dw];
                        for (i2 = 0; i2 < Dw; i2++) {
                            iArr2[i2] = this.xdo.readInt();
                        }
                        for (i2 = 0; i2 < Dw; i2++) {
                            iArr[i2] = this.xdo.readInt() + read2;
                        }
                        eVar.a(i, read, iArr2, iArr);
                        break;
                    case 768:
                        i2 = this.xdo.read();
                        int readInt2 = this.xdo.readInt();
                        Object obj;
                        switch (i2) {
                            case 1:
                                obj = new byte[readInt2];
                                i2 = 0;
                                Object obj2 = 1;
                                readInt = 0;
                                while (readInt < readInt2) {
                                    if (obj2 != null) {
                                        i2 = this.xdo.read();
                                    }
                                    obj[readInt] = (byte) (i2 & 255);
                                    readInt++;
                                    obj2 = obj2 == null ? 1 : null;
                                    i2 >>= 8;
                                }
                                eVar.a(i, read, obj, obj.length, 1);
                                break;
                            case 2:
                                obj = new short[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = (short) this.xdo.read();
                                }
                                eVar.a(i, read, obj, obj.length, 2);
                                break;
                            case 4:
                                obj = new int[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.xdo.readInt();
                                }
                                eVar.a(i, read, obj, obj.length, 4);
                                break;
                            case 8:
                                obj = new long[readInt2];
                                for (i2 = 0; i2 < readInt2; i2++) {
                                    obj[i2] = this.xdo.readLong();
                                }
                                eVar.a(i, read, obj, obj.length, 8);
                                break;
                            default:
                                throw new com.tencent.tinker.a.a.j("bogus element_width: " + com.tencent.tinker.a.b.b.a.DA(i2));
                        }
                    default:
                        throw new IllegalStateException("Unknown opcode: " + com.tencent.tinker.a.b.b.a.Dz(i2));
                }
            }
            return;
        }
    }
}
