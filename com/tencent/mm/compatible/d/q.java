package com.tencent.mm.compatible.d;

import com.tencent.mm.compatible.h.a;
import com.tencent.mm.sdk.platformtools.SensorController;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bg;
import com.tencent.mm.sdk.platformtools.bh;
import com.tencent.mm.sdk.platformtools.w;
import java.util.Map;

final class q {
    q() {
    }

    public static boolean a(String str, n nVar, b bVar, a aVar, j jVar, u uVar, y yVar, r rVar, t tVar, w wVar, s sVar) {
        try {
            w.d("MicroMsg.DeviceInfoParser", "xml: " + str);
            Map q = bh.q(str, "deviceinfoconfig");
            if (q == null) {
                w.i("MicroMsg.DeviceInfoParser", "hy: null device config");
                return false;
            }
            if (q.get(".deviceinfoconfig.voip.cpu.armv7") != null) {
                nVar.gQP = bg.getInt((String) q.get(".deviceinfoconfig.voip.cpu.armv7"), 0);
                nVar.gQO = true;
            }
            if (q.get(".deviceinfoconfig.voip.cpu.armv6") != null) {
                nVar.gQQ = bg.getInt((String) q.get(".deviceinfoconfig.voip.cpu.armv6"), 0);
                nVar.gQO = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.num") != null) {
                bVar.gOW = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.num"), 0);
                bVar.gOX = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.surface") != null) {
                bVar.gOY = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.surface"), 0);
                bVar.gOZ = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.format") != null) {
                bVar.gPa = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.format"), 0);
                bVar.gPb = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.enable") != null) {
                bVar.gPe.gPD = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.enable"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.fps") != null) {
                bVar.gPe.gPE = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.fps"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.orien") != null) {
                bVar.gPe.gPF = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.orien"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.rotate") != null) {
                bVar.gPe.gPG = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.rotate"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.isleft") != null) {
                bVar.gPe.gPH = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.isleft"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.width") != null) {
                bVar.gPe.width = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.width"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.back.height") != null) {
                bVar.gPe.height = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.back.height"), 0);
                bVar.gPf = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.enable") != null) {
                bVar.gPc.gPD = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.enable"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.fps") != null) {
                bVar.gPc.gPE = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.fps"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.orien") != null) {
                bVar.gPc.gPF = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.orien"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.rotate") != null) {
                bVar.gPc.gPG = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.rotate"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.isleft") != null) {
                bVar.gPc.gPH = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.isleft"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.width") != null) {
                bVar.gPc.width = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.width"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.front.height") != null) {
                bVar.gPc.height = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.front.height"), 0);
                bVar.gPd = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.frotate") != null) {
                bVar.gPh = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.frotate"), 0);
                bVar.gPg = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.forientation") != null) {
                bVar.gPi = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.forientation"), 0);
                bVar.gPg = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.brotate") != null) {
                bVar.gPj = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.brotate"), 0);
                bVar.gPg = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.borientation") != null) {
                bVar.gPk = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.borientation"), 0);
                bVar.gPg = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                bVar.gPl = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                bVar.gPm = true;
                bVar.gPg = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                bVar.gPo = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                bVar.gPn = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold") != null) {
                bVar.gPp = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.scannerFocusThreshold"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.scannerImageQuality") != null) {
                bVar.gPq = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.scannerImageQuality"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval") != null) {
                bVar.gPB = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.autoFocusTimeInterval"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.focusType") != null) {
                bVar.gPC = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.focusType"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.num") != null) {
                bVar.gPl = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.num"), 0);
                bVar.gPm = true;
                bVar.gPg = true;
            }
            if (q.get(".deviceinfoconfig.voip.camera.videorecord.api20") != null) {
                bVar.gPo = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.videorecord.api20"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.setframerate") != null) {
                bVar.gPn = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.setframerate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useFixFPSMode") != null) {
                bVar.gPr = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.useFixFPSMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useRangeFPSMode") != null) {
                bVar.gPs = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.useRangeFPSMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat") != null) {
                bVar.gPt = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.setYUV420SPFormat"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useMeteringMode") != null) {
                bVar.gPu = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.useMeteringMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode") != null) {
                bVar.gPv = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.useContinueVideoFocusMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported") != null) {
                bVar.gPw = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.mUsestabilizationsupported"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.sightCameraID") != null) {
                bVar.gPx = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.sightCameraID"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.needEnhance") != null) {
                bVar.gPy = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.needEnhance"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.support480enc") != null) {
                bVar.gPz = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.support480enc"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.camera.supportHWenc") != null) {
                bVar.gPA = bg.getInt((String) q.get(".deviceinfoconfig.voip.camera.supportHWenc"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.streamtype") != null) {
                aVar.gNO = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.streamtype"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.smode") != null) {
                aVar.gNP = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.smode"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.omode") != null) {
                aVar.gNQ = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.omode"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.ospeaker") != null) {
                aVar.gNR = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.ospeaker"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.operating") != null) {
                aVar.gNS = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.operating"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.moperating") != null) {
                aVar.gNT = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.moperating"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.mstreamtype") != null) {
                aVar.gNU = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.mstreamtype"), 0);
                aVar.gNN = true;
            }
            if (q.get(".deviceinfoconfig.voip.audio.recordmode") != null) {
                aVar.gNV = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.recordmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                aVar.gNW = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.aecmode") != null) {
                aVar.gNX = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.aecmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.nsmode") != null) {
                aVar.gNY = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.nsmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.volummode") != null) {
                aVar.gNZ = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.volummode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.sourcemode") != null) {
                aVar.gOl = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.sourcemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.micmode") != null) {
                aVar.gOk = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.micmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.speakerMode") != null) {
                aVar.gOm = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.speakerMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.phoneMode") != null) {
                aVar.gOn = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.phoneMode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType") != null) {
                aVar.gOo = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.deviceinfo.voipstreamType"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.speakerstreamtype") != null) {
                aVar.gOp = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.speakerstreamtype"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.phonestreamtype") != null) {
                aVar.gOq = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.phonestreamtype"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringphonestream") != null) {
                aVar.gOs = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringphonestream"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringphonemode") != null) {
                aVar.gOt = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringphonemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringspeakerstream") != null) {
                aVar.gOu = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringspeakerstream"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ringspeakermode") != null) {
                aVar.gOv = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.ringspeakermode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.aecmodenew") != null) {
                aVar.gOw = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.aecmodenew"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.nsmodenew") != null) {
                aVar.gOx = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.nsmodenew"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcmodenew") != null) {
                aVar.gOy = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcmodenew"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcmode") != null) {
                aVar.gOz = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agctargetdb") != null) {
                aVar.gOA = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agctargetdb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcgaindb") != null) {
                aVar.gOB = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcgaindb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcflag") != null) {
                aVar.gOC = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcflag"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agclimiter") != null) {
                aVar.gOD = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agclimiter"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.inputvolumescale") != null) {
                aVar.gOa = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.inputvolumescale"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumescale") != null) {
                aVar.gOb = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumescale"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker") != null) {
                aVar.gOc = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.inputvolumescaleforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker") != null) {
                aVar.gOd = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumescaleforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.ehanceheadsetec") != null) {
                aVar.gOg = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.ehanceheadsetec"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset") != null) {
                aVar.gOh = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.setecmodelevelforheadset"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker") != null) {
                aVar.gOi = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.setecmodelevelforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec") != null) {
                aVar.gOj = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.enablespeakerenhanceec"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.enablerectimer") != null) {
                aVar.gOE = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.enablerectimer"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.enablePlayTimer") != null) {
                aVar.gOF = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.enablePlayTimer"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof0") != null) {
                aVar.gOH[0] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof0"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof1") != null) {
                aVar.gOH[1] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof1"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof2") != null) {
                aVar.gOH[2] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof2"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof3") != null) {
                aVar.gOH[3] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof3"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof4") != null) {
                aVar.gOH[4] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof4"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof5") != null) {
                aVar.gOH[5] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof5"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof6") != null) {
                aVar.gOH[6] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof6"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof7") != null) {
                aVar.gOH[7] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof7"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof8") != null) {
                aVar.gOH[8] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof8"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof9") != null) {
                aVar.gOH[9] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof9"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof10") != null) {
                aVar.gOH[10] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof10"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof11") != null) {
                aVar.gOH[11] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof11"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof12") != null) {
                aVar.gOH[12] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof12"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof13") != null) {
                aVar.gOH[13] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof13"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctcof.cof14") != null) {
                aVar.gOH[14] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctcof.cof14"), 0);
                aVar.gOG = 1;
            }
            if (q.get(".deviceinfoconfig.voip.audio.correctoff") != null && bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.correctoff"), 0) == 1) {
                aVar.gOG = 0;
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone") != null) {
                aVar.gOe = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumegainforphone"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker") != null) {
                aVar.gOf = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.outputvolumegainforspeaker"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0") != null) {
                aVar.gOI[0] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof0"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1") != null) {
                aVar.gOI[1] = (short) bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.noisegatestrength.cof1"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxflag") != null) {
                aVar.gOS = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxflag"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxtargetdb") != null) {
                aVar.gOT = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxtargetdb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxgaindb") != null) {
                aVar.gOU = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxgaindb"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.agcrxlimiter") != null) {
                aVar.gOV = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.agcrxlimiter"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.spkecenable") != null) {
                aVar.gOK = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.spkecenable"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.audio.playenddelay") != null) {
                aVar.gNW = bg.getInt((String) q.get(".deviceinfoconfig.voip.audio.playenddelay"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.speakermode") != null) {
                aVar.gOM = bg.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.speakermode"), 0);
                aVar.gOL = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.phonemode") != null) {
                aVar.gON = bg.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.phonemode"), 0);
                aVar.gOL = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.sourcemode") != null) {
                aVar.gOO = bg.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.sourcemode"), 0);
                aVar.gOL = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.streamtype") != null) {
                aVar.gOP = bg.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.streamtype"), 0);
                aVar.gOL = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype") != null) {
                aVar.gOQ = bg.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.speakerstreamtype"), 0);
                aVar.gOL = true;
            }
            if (q.get(".deviceinfoconfig.voip.ipcall.phonestreamtype") != null) {
                aVar.gOR = bg.getInt((String) q.get(".deviceinfoconfig.voip.ipcall.phonestreamtype"), 0);
                aVar.gOL = true;
            }
            if (q.get(".deviceinfoconfig.voip.common.js") != null) {
                jVar.gPS = true;
                jVar.gPT = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.js") != null) {
                jVar.gPK = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.js"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.stopbluetoothbr") != null) {
                jVar.gPL = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.stopbluetoothbr"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.stopbluetoothbu") != null) {
                jVar.gPM = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.stopbluetoothbu"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.setbluetoothscoon") != null) {
                jVar.gPO = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.setbluetoothscoon"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.startbluetoothsco") != null) {
                jVar.gPN = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.startbluetoothsco"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.voicesearchfastmode") != null) {
                jVar.gPP = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.voicesearchfastmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.pcmreadmode") != null) {
                jVar.gPR = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.pcmreadmode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.pcmbufferrate") != null) {
                jVar.gPQ = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.pcmbufferrate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.app") != null) {
                jVar.gPU = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.app"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp") != null) {
                jVar.gQn = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipapp"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns") != null) {
                jVar.gQo = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappns"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec") != null) {
                jVar.gQp = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappaec"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc") != null) {
                jVar.gQq = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.deviceinfo.voipappagc"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.vmfd") != null) {
                jVar.gPV = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.vmfd"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.htcvoicemode") != null) {
                jVar.gPW = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.htcvoicemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.samsungvoicemode") != null) {
                jVar.gPX = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.samsungvoicemode"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.speexbufferrate") != null) {
                jVar.gPY = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.speexbufferrate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.linespe") != null) {
                jVar.gPZ = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.linespe"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.fixspan") != null) {
                jVar.gQk = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.fixspan"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extvideo") != null) {
                jVar.gQa = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.extvideo"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extvideosam") != null) {
                jVar.gQb = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.extvideosam"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.sysvideodegree") != null) {
                jVar.gQc = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.sysvideodegree"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.mmnotify") != null) {
                jVar.gQf = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.mmnotify"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extsharevcard") != null) {
                jVar.gQe = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.extsharevcard"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                jVar.gQg = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                jVar.gQh = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.sysvideofdegree") != null) {
                jVar.gQd = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.sysvideofdegree"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.audioformat") != null) {
                jVar.gQg = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.audioformat"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.qrcam") != null) {
                jVar.gQh = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.qrcam"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.base") != null) {
                jVar.gQr = (String) q.get(".deviceinfoconfig.voip.common.base");
            }
            if (q.get(".deviceinfoconfig.voip.common.packageinfo") != null) {
                jVar.gQs = (String) q.get(".deviceinfoconfig.voip.common.packageinfo");
            }
            if (q.get(".deviceinfoconfig.voip.common.classloader") != null) {
                jVar.gQt = (String) q.get(".deviceinfoconfig.voip.common.classloader");
            }
            if (q.get(".deviceinfoconfig.voip.common.resources") != null) {
                jVar.gQu = (String) q.get(".deviceinfoconfig.voip.common.resources");
            }
            if (q.get(".deviceinfoconfig.voip.common.sysvideofp") != null) {
                jVar.gQi = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.sysvideofp"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.common.extstoragedir") != null) {
                jVar.gQv = (String) q.get(".deviceinfoconfig.voip.common.extstoragedir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extpubdir") != null) {
                jVar.gQw = (String) q.get(".deviceinfoconfig.voip.common.extpubdir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extdatadir") != null) {
                jVar.gQx = (String) q.get(".deviceinfoconfig.voip.common.extdatadir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extrootdir") != null) {
                jVar.gQy = (String) q.get(".deviceinfoconfig.voip.common.extrootdir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extstoragestate") != null) {
                jVar.gQz = (String) q.get(".deviceinfoconfig.voip.common.extstoragestate");
            }
            if (q.get(".deviceinfoconfig.voip.common.extcachedir") != null) {
                jVar.gQA = (String) q.get(".deviceinfoconfig.voip.common.extcachedir");
            }
            if (q.get(".deviceinfoconfig.voip.common.extvideoplayer") != null) {
                jVar.gQj = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.extvideoplayer"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.common.loadDrawable") != null) {
                jVar.gQB = (String) q.get(".deviceinfoconfig.voip.common.loadDrawable");
            }
            if (q.get(".deviceinfoconfig.voip.common.loadXmlResourceParser") != null) {
                jVar.gQC = (String) q.get(".deviceinfoconfig.voip.common.loadXmlResourceParser");
            }
            if (q.get(".deviceinfoconfig.voip.common.sensorNearFar") != null && 1 == bg.getInt((String) q.get(".deviceinfoconfig.voip.common.sensorNearFar"), 0)) {
                SensorController.uvH = true;
            }
            if (q.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio") != null) {
                SensorController.uvI = bg.getDouble((String) q.get(".deviceinfoconfig.voip.common.sensorNearFarDivideRatio"), 0.0d);
            }
            if (q.get(".deviceinfoconfig.voip.common.sightFullType") != null) {
                jVar.gQD = (String) q.get(".deviceinfoconfig.voip.common.sightFullType");
            }
            if (q.get(".deviceinfoconfig.voip.common.slyTextureView") != null) {
                jVar.gQE = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.slyTextureView"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.common.checkSightDraftMd5") != null) {
                jVar.gQF = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.checkSightDraftMd5"), 1);
            }
            if (q.get(".deviceinfoconfig.voip.common.swipeBackConfig") != null) {
                jVar.gQG = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.swipeBackConfig"), 1);
                a.aE(jVar.gQG == 1);
            }
            if (q.get(".deviceinfoconfig.voip.common.canDecodeWebp") != null) {
                jVar.gQH = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.canDecodeWebp"), 1);
            }
            if (q.get(".deviceinfoconfig.voip.common.isScanZoom") != null) {
                jVar.gQl = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.isScanZoom"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio") != null) {
                jVar.gQm = bg.getDouble((String) q.get(".deviceinfoconfig.voip.common.scanMaxZoomDivideRatio"), -1.0d);
            }
            if (q.get(".deviceinfoconfig.voip.common.notificationSetMode") != null) {
                jVar.gQI = bg.getInt((String) q.get(".deviceinfoconfig.voip.common.notificationSetMode"), -1);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo") != null) {
                uVar.gRC = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useThisInfo"), 0) == 1;
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.width") != null) {
                uVar.gRD = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.width"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.height") != null) {
                uVar.gRE = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.height"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.frameRate") != null) {
                uVar.gRF = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.frameRate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate") != null) {
                uVar.gRG = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.encodingBitRate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useSystem") != null) {
                uVar.gRH = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useSystem"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek") != null) {
                uVar.gRI = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.yuv420SPSeek"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC") != null) {
                uVar.gRJ = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useMediaCodecEncodeAAC"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate") != null) {
                uVar.gRK = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.AACSampleRate"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera") != null) {
                uVar.gRL = bg.getInt((String) q.get(".deviceinfoconfig.voip.mediaRecorder.useTextureViewForCamera"), 0);
            }
            if (q.get(".deviceinfoconfig.voip.webview.notifythread") != null) {
                yVar.gRQ = bg.getInt((String) q.get(".deviceinfoconfig.voip.webview.notifythread"), 0) == 1;
            }
            if (q.get(".deviceinfoconfig.voip.webview.forceUseSysWebView") != null) {
                yVar.gRR = bg.getInt((String) q.get(".deviceinfoconfig.voip.webview.forceUseSysWebView"), 0) == 1;
                w.i("MicroMsg.DeviceInfoParser", "save forceusesystemwebview = %b", Boolean.valueOf(yVar.gRR));
                ab.getContext().getSharedPreferences("com.tencent.mm_webview_x5_preferences", 4).edit().putBoolean("tbs_force_user_sys_webview", yVar.gRR).commit();
            }
            jVar.dump();
            int i = bg.getInt((String) q.get(".deviceinfoconfig.fingerprint.forceFingerprintStatus"), 0);
            int i2 = bg.getInt((String) q.get(".deviceinfoconfig.fingerprint.supportExportEntrance"), 0);
            w.i("MicroMsg.DeviceInfoParser", "hy: got fingerprint force status: %d", Integer.valueOf(i));
            if (rVar != null) {
                rVar.el(i);
                rVar.ek(i2);
            }
            w.i("MicroMsg.DeviceInfoParser", "hy: get soter status: %d", Integer.valueOf(bg.getInt((String) q.get(".deviceinfoconfig.soter.isSupport"), 0)));
            if (wVar != null) {
                wVar.aC(i2 == 1);
            }
            w.i("MicroMsg.DeviceInfoParser", "lm: got PublicNum: %s", (String) q.get(".deviceinfoconfig.freeWifi.operations.bizUserName"));
            if (tVar != null) {
                tVar.dv(r2);
            }
            w.i("MicroMsg.DeviceInfoParser", "lm: got manufacturerNameMaps: %s", bh.q(str, "manufacturerName"));
            if (tVar != null) {
                tVar.i(r2);
            }
            w.i("MicroMsg.DeviceInfoParser", "lm: got swipback: %d", Integer.valueOf(bg.getInt((String) q.get(".deviceinfoconfig.style.swipback"), 0)));
            if (tVar != null) {
                tVar.em(i2);
            }
            i = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.recordertype"), -1);
            int i3 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.needRotateEachFrame"), -1);
            int i4 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.enableHighResolutionRecord"), -1);
            int i5 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.landscapeRecordModeEnable"), -1);
            int i6 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.transcodeDecoderType"), -1);
            int i7 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.mediaPlayerType"), -1);
            int i8 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.strategyMask"), -1);
            i2 = bg.getInt((String) q.get(".deviceinfoconfig.mmsight.recorderOption"), -1);
            if (sVar != null) {
                sVar.gRq = i;
                sVar.gRr = i3;
                sVar.gRs = i4;
                sVar.gRt = i5;
                sVar.gRu = i6;
                sVar.gRv = i7;
                sVar.gRw = i8;
                sVar.gRx = i2;
                w.i("MicroMsg.DeviceInfoParser", "get mmSightRecorderInfo: %s", sVar.toString());
            }
            return true;
        } catch (Throwable e) {
            w.printErrStackTrace("MicroMsg.DeviceInfoParser", e, "", new Object[0]);
            return false;
        }
    }
}
