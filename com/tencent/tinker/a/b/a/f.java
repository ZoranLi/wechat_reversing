package com.tencent.tinker.a.b.a;

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
import com.tencent.mm.plugin.appbrand.jsapi.g.b;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.plugin.appbrand.jsapi.map.c;
import com.tencent.mm.plugin.appbrand.jsapi.map.d;
import com.tencent.mm.plugin.appbrand.jsapi.map.e;
import com.tencent.mm.plugin.appbrand.jsapi.map.i;
import com.tencent.mm.plugin.appbrand.jsapi.map.k;
import com.tencent.mm.plugin.appbrand.jsapi.n;
import com.tencent.mm.plugin.appbrand.jsapi.q;
import com.tencent.mm.plugin.appbrand.jsapi.share.g;
import com.tencent.mm.plugin.appbrand.jsapi.share.h;
import com.tencent.mm.plugin.appbrand.jsapi.w;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.GameJsApiOperateGameCenterMsg;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.aa;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.am;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.an;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.as;
import com.tencent.mm.plugin.game.gamewebview.jsapi.biz.v;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.qqmusic.mediaplayer.PlayerException;
import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.b.a;
import com.tencent.wcdb.FileUtils;

public final class f extends e {
    private final h xdq;
    private final c xdr;
    private final boolean xds = true;

    public f(h hVar, c cVar) {
        super(null);
        this.xdq = hVar;
        this.xdr = cVar;
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j) {
        if (this.xds) {
            i5 = this.xdr.Dy(i5);
        }
        switch (i2) {
            case -1:
            case 0:
            case 14:
                this.xdq.c((short) i2);
                return;
            case 36:
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.xdq.a(b.eG(i2, b.eH(0, 0)), (short) i3, b.w(0, 0, 0, 0));
                return;
            case 40:
                byte b;
                if (this.xds) {
                    b = i5 - this.xdq.xdl;
                    if (b == ((byte) b)) {
                        this.xdq.c(b.eG(i2, b & 255));
                        return;
                    } else if (b != ((short) b)) {
                        this.xdq.a((short) 42, (short) b, (short) (b >> 16));
                        return;
                    } else {
                        this.xdq.b((short) 41, (short) b);
                        return;
                    }
                }
                b = i5 - this.xdq.xdl;
                if (b != ((byte) b)) {
                    throw new j("Target out of range: " + a.DC(b) + ", perhaps you need to enable force jumbo mode.");
                }
                this.xdq.c(b.eG(i2, b & 255));
                return;
            case v.CTRL_BYTE /*41*/:
                short s;
                if (this.xds) {
                    short s2 = i5 - this.xdq.xdl;
                    if (s2 != ((short) s2)) {
                        this.xdq.a((short) 42, (short) s2, (short) (s2 >> 16));
                        return;
                    }
                    s = (short) i2;
                    this.xdq.b(s, (short) s2);
                    return;
                }
                s = (short) i2;
                this.xdq.b(s, b.eI(i5, this.xdq.xdl));
                return;
            case 42:
                int i6 = i5 - this.xdq.xdl;
                this.xdq.a((short) i2, (short) i6, (short) (i6 >> 16));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
        if (this.xds) {
            i5 = this.xdr.Dy(i5);
        }
        int i7;
        switch (i2) {
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
                this.xdq.c(b.eG(i2, i6));
                return;
            case 18:
                short s = (short) i2;
                h hVar = this.xdq;
                if (j < -8 || j > 7) {
                    throw new j("Literal out of range: " + a.fd(j));
                }
                hVar.c(b.eG(s, b.eH(i6, ((int) j) & 15)));
                return;
            case 19:
            case 22:
                this.xdq.b(b.eG(i2, i6), b.fc(j));
                return;
            case 20:
            case 23:
                if (j != ((long) ((int) j))) {
                    throw new j("Literal out of range: " + a.fd(j));
                }
                i7 = (int) j;
                this.xdq.a(b.eG(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case 21:
            case 25:
                this.xdq.b(b.eG(i2, i6), (short) ((int) (j >> (i2 == 21 ? 16 : 48))));
                return;
            case 24:
                h hVar2 = this.xdq;
                short s2 = (short) ((int) j);
                short s3 = (short) ((int) (j >> 16));
                short s4 = (short) ((int) (j >> 32));
                short s5 = (short) ((int) (j >> 48));
                hVar2.c(b.eG(i2, i6));
                hVar2.c(s2);
                hVar2.c(s3);
                hVar2.c(s4);
                hVar2.c(s5);
                return;
            case 26:
                if (this.xds) {
                    if (i3 > 65535) {
                        this.xdq.a(b.eG(27, i6), (short) i3, (short) (i3 >> 16));
                        return;
                    } else {
                        this.xdq.b(b.eG(i2, i6), (short) i3);
                        return;
                    }
                } else if (i3 > 65535) {
                    throw new j("string index out of bound: " + a.Dz(i3) + ", perhaps you need to enable force jumbo mode.");
                } else {
                    this.xdq.b(b.eG(i2, i6), (short) i3);
                    return;
                }
            case 27:
                this.xdq.a(b.eG(i2, i6), (short) i3, (short) (i3 >> 16));
                return;
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
                this.xdq.b(b.eG(i2, i6), (short) i3);
                return;
            case 36:
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.xdq.a(b.eG(i2, b.eH(0, 1)), (short) i3, b.w(i6, 0, 0, 0));
                return;
            case 38:
            case 43:
            case 44:
                switch (i2) {
                    case 43:
                    case 44:
                        this.xdq.eF(i5, this.xdq.xdl);
                        break;
                }
                i7 = i5 - this.xdq.xdl;
                this.xdq.a(b.eG(i2, i6), (short) i7, (short) (i7 >> 16));
                return;
            case FileUtils.S_IRWXG /*56*/:
            case b.CTRL_INDEX /*57*/:
            case m.CTRL_INDEX /*58*/:
            case bc.CTRL_INDEX /*59*/:
            case 60:
            case PlayerException.EXCEPTION_TYPE_INITLIB /*61*/:
                this.xdq.b(b.eG(i2, i6), b.eI(i5, this.xdq.xdl));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        if (this.xds) {
            i5 = this.xdr.Dy(i5);
        }
        switch (i2) {
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
            case d.CTRL_INDEX /*134*/:
            case com.tencent.mm.plugin.appbrand.jsapi.map.b.CTRL_INDEX /*135*/:
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
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.m.CTRL_BYTE /*188*/:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.k.CTRL_BYTE /*189*/:
            case 190:
            case com.tencent.mm.plugin.game.gamewebview.jsapi.biz.j.CTRL_BYTE /*191*/:
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
            case com.tencent.mm.plugin.appbrand.jsapi.share.f.CTRL_INDEX /*202*/:
            case aq.CTRL_INDEX /*203*/:
            case ao.CTRL_INDEX /*204*/:
            case cf.CTRL_INDEX /*205*/:
            case com.tencent.mm.plugin.appbrand.jsapi.v.CTRL_INDEX /*206*/:
            case 207:
                this.xdq.c(b.eG((short) i2, b.eH(i6, i7)));
                return;
            case 2:
            case 5:
            case 8:
                this.xdq.b(b.eG(i2, i6), b.Dv(i7));
                return;
            case 3:
            case 6:
            case 9:
                this.xdq.a((short) i2, b.Du(i6), b.Dv(i7));
                return;
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
                this.xdq.b(b.eG(i2, b.eH(i6, i7)), (short) i3);
                return;
            case 36:
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.xdq.a(b.eG(i2, b.eH(0, 2)), (short) i3, b.w(i6, i7, 0, 0));
                return;
            case 50:
            case 51:
            case 52:
            case PlayerException.EXCEPTION_TYPE_FILENOTFOUND /*53*/:
            case PlayerException.EXCEPTION_TYPE_FILECANNOTREAD /*54*/:
            case PlayerException.EXCEPTION_TYPE_UNKNOWFORMAT /*55*/:
                this.xdq.b(b.eG(i2, b.eH(i6, i7)), b.eI(i5, this.xdq.xdl));
                return;
            case bv.CTRL_INDEX /*208*/:
            case ag.CTRL_INDEX /*209*/:
            case h.CTRL_INDEX /*210*/:
            case g.CTRL_INDEX /*211*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.b.CTRL_INDEX /*212*/:
            case com.tencent.mm.plugin.appbrand.jsapi.bio.face.c.CTRL_INDEX /*213*/:
            case JsApiCheckIsSupportFaceDetect.CTRL_INDEX /*214*/:
            case cp.CTRL_INDEX /*215*/:
                this.xdq.b(b.eG(i2, b.eH(i6, i7)), b.fc(j));
                return;
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
                h hVar = this.xdq;
                short eG = b.eG(i2, i6);
                if (j != ((long) ((byte) ((int) j)))) {
                    throw new j("Literal out of range: " + a.fd(j));
                }
                hVar.b(eG, b.eG(i7, ((int) j) & 255));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
        switch (i2) {
            case 36:
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.xdq.a(b.eG(i2, b.eH(0, 3)), (short) i3, b.w(i6, i7, i8, 0));
                return;
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
            case android.support.v7.a.a.k.LI /*78*/:
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
                this.xdq.b(b.eG(i2, i6), b.eG(i7, i8));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
        switch (i2) {
            case 36:
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.xdq.a(b.eG(i2, b.eH(0, 4)), (short) i3, b.w(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
        switch (i2) {
            case 36:
            case MMGIFException.D_GIF_ERR_CLOSE_FAILED /*110*/:
            case 111:
            case MMGIFException.D_GIF_ERR_IMAGE_DEFECT /*112*/:
            case 113:
            case 114:
                this.xdq.a(b.eG(i2, b.eH(i10, 5)), (short) i3, b.w(i6, i7, i8, i9));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
        switch (i2) {
            case JsApiGetLocation.CTRL_INDEX /*37*/:
            case 116:
            case 117:
            case 118:
            case 119:
            case 120:
                this.xdq.a(b.eG(i2, i7), (short) i3, b.Du(i6));
                return;
            default:
                throw new IllegalStateException("unexpected opcode: " + a.DB(i2));
        }
    }

    public final void a(int i, int i2, int[] iArr, int[] iArr2) {
        int length;
        int i3 = 0;
        int cgH = this.xdq.cgH();
        this.xdq.c((short) i2);
        this.xdq.c(b.Ds(iArr2.length));
        for (int writeInt : iArr) {
            this.xdq.writeInt(writeInt);
        }
        if (this.xds) {
            length = iArr2.length;
            while (i3 < length) {
                this.xdq.writeInt(this.xdr.Dy(iArr2[i3]) - cgH);
                i3++;
            }
            return;
        }
        length = iArr2.length;
        while (i3 < length) {
            this.xdq.writeInt(iArr2[i3] - cgH);
            i3++;
        }
    }

    public final void b(int i, int i2, int i3, int[] iArr) {
        int i4 = 0;
        int cgH = this.xdq.cgH();
        this.xdq.c((short) i2);
        this.xdq.c(b.Ds(iArr.length));
        this.xdq.writeInt(i3);
        int length;
        if (this.xds) {
            length = iArr.length;
            while (i4 < length) {
                this.xdq.writeInt(this.xdr.Dy(iArr[i4]) - cgH);
                i4++;
            }
            return;
        }
        length = iArr.length;
        while (i4 < length) {
            this.xdq.writeInt(iArr[i4] - cgH);
            i4++;
        }
    }

    public final void a(int i, int i2, Object obj, int i3, int i4) {
        int i5 = 0;
        this.xdq.c((short) i2);
        this.xdq.c((short) i4);
        this.xdq.writeInt(i3);
        h hVar;
        int length;
        switch (i4) {
            case 1:
                h hVar2 = this.xdq;
                int i6 = 1;
                int i7 = 0;
                for (byte b : (byte[]) obj) {
                    if (i6 != 0) {
                        i7 = b & 255;
                        i6 = 0;
                    } else {
                        i6 = (b << 8) | i7;
                        hVar2.c((short) i6);
                        i7 = i6;
                        i6 = 1;
                    }
                }
                if (i6 == 0) {
                    hVar2.c((short) i7);
                    return;
                }
                return;
            case 2:
                hVar = this.xdq;
                short[] sArr = (short[]) obj;
                length = sArr.length;
                while (i5 < length) {
                    hVar.c(sArr[i5]);
                    i5++;
                }
                return;
            case 4:
                hVar = this.xdq;
                int[] iArr = (int[]) obj;
                length = iArr.length;
                while (i5 < length) {
                    hVar.writeInt(iArr[i5]);
                    i5++;
                }
                return;
            case 8:
                hVar = this.xdq;
                long[] jArr = (long[]) obj;
                length = jArr.length;
                while (i5 < length) {
                    long j = jArr[i5];
                    hVar.c((short) ((int) j));
                    hVar.c((short) ((int) (j >> 16)));
                    hVar.c((short) ((int) (j >> 32)));
                    hVar.c((short) ((int) (j >> 48)));
                    i5++;
                }
                return;
            default:
                throw new j("bogus element_width: " + a.DA(i4));
        }
    }
}
