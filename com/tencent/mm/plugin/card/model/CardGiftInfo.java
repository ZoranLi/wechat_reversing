package com.tencent.mm.plugin.card.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.protocal.c.am;
import com.tencent.mm.protocal.c.an;
import com.tencent.mm.protocal.c.ao;
import com.tencent.mm.protocal.c.wb;
import java.util.Iterator;
import java.util.LinkedList;

public class CardGiftInfo implements Parcelable {
    public static final Creator<CardGiftInfo> CREATOR = new Creator<CardGiftInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new CardGiftInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new CardGiftInfo[i];
        }
    };
    public String fTJ;
    public String hib;
    public String kdX;
    public String kdY;
    public String kdZ;
    public String keA;
    public LinkedList<AcceptedCardItem> keB = new LinkedList();
    public LinkedList<AccepterItem> keC = new LinkedList();
    public String keD;
    public int keE;
    public String keF;
    public String keG;
    public String kea;
    public String keb;
    public String kec;
    public String ked;
    public String kee;
    public String kef;
    public String keg;
    public String keh;
    public String kei;
    public String kej;
    public boolean kek;
    public int kel;
    public int kem;
    public int ken;
    public String keo;
    public String kep;
    public int keq;
    public String ker;
    public String kes;
    public String ket;
    public String keu;
    public String kev;
    public String kew;
    public String kex;
    public String kez;
    public String toUserName;

    public static class AcceptedCardItem implements Parcelable {
        public static final Creator<AcceptedCardItem> CREATOR = new Creator<AcceptedCardItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AcceptedCardItem(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AcceptedCardItem[i];
            }
        };
        public String keH;
        public String keI;

        public AcceptedCardItem(Parcel parcel) {
            this.keH = parcel.readString();
            this.keI = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.keH);
            parcel.writeString(this.keI);
        }

        public int describeContents() {
            return 0;
        }
    }

    public static class AccepterItem implements Parcelable {
        public static final Creator<AccepterItem> CREATOR = new Creator<AccepterItem>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AccepterItem(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new AccepterItem[i];
            }
        };
        public String keH;
        public String keI;
        public String keJ;
        public String keK;

        public AccepterItem(Parcel parcel) {
            this.keH = parcel.readString();
            this.keI = parcel.readString();
            this.keJ = parcel.readString();
            this.keK = parcel.readString();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.keH);
            parcel.writeString(this.keI);
            parcel.writeString(this.keJ);
            parcel.writeString(this.keK);
        }

        public int describeContents() {
            return 0;
        }
    }

    protected CardGiftInfo(Parcel parcel) {
        this.toUserName = parcel.readString();
        this.fTJ = parcel.readString();
        this.kdX = parcel.readString();
        this.kdY = parcel.readString();
        this.kdZ = parcel.readString();
        this.kea = parcel.readString();
        this.keb = parcel.readString();
        this.kec = parcel.readString();
        this.ked = parcel.readString();
        this.kee = parcel.readString();
        this.kef = parcel.readString();
        this.keg = parcel.readString();
        this.keh = parcel.readString();
        this.kei = parcel.readString();
        this.kej = parcel.readString();
        this.hib = parcel.readString();
        this.kek = parcel.readByte() != (byte) 0;
        this.kel = parcel.readInt();
        this.kem = parcel.readInt();
        this.ken = parcel.readInt();
        this.keo = parcel.readString();
        this.kep = parcel.readString();
        this.keq = parcel.readInt();
        this.ker = parcel.readString();
        this.kes = parcel.readString();
        this.ket = parcel.readString();
        this.keu = parcel.readString();
        this.kev = parcel.readString();
        this.kew = parcel.readString();
        this.kex = parcel.readString();
        this.kez = parcel.readString();
        this.keA = parcel.readString();
        parcel.readTypedList(this.keB, AcceptedCardItem.CREATOR);
        parcel.readTypedList(this.keC, AccepterItem.CREATOR);
        this.keD = parcel.readString();
        this.keE = parcel.readInt();
        this.keF = parcel.readString();
        this.keG = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.toUserName);
        parcel.writeString(this.fTJ);
        parcel.writeString(this.kdX);
        parcel.writeString(this.kdY);
        parcel.writeString(this.kdZ);
        parcel.writeString(this.kea);
        parcel.writeString(this.keb);
        parcel.writeString(this.kec);
        parcel.writeString(this.ked);
        parcel.writeString(this.kee);
        parcel.writeString(this.kef);
        parcel.writeString(this.keg);
        parcel.writeString(this.keh);
        parcel.writeString(this.kei);
        parcel.writeString(this.kej);
        parcel.writeString(this.hib);
        parcel.writeByte(this.kek ? (byte) 1 : (byte) 0);
        parcel.writeInt(this.kel);
        parcel.writeInt(this.kem);
        parcel.writeInt(this.ken);
        parcel.writeString(this.keo);
        parcel.writeString(this.kep);
        parcel.writeInt(this.keq);
        parcel.writeString(this.ker);
        parcel.writeString(this.kes);
        parcel.writeString(this.ket);
        parcel.writeString(this.keu);
        parcel.writeString(this.kev);
        parcel.writeString(this.kew);
        parcel.writeString(this.kex);
        parcel.writeString(this.kez);
        parcel.writeString(this.keA);
        parcel.writeTypedList(this.keB);
        parcel.writeTypedList(this.keC);
        parcel.writeString(this.keD);
        parcel.writeInt(this.keE);
        parcel.writeString(this.keF);
        parcel.writeString(this.keG);
    }

    public String toString() {
        return "CardGiftInfo{toUserName='" + this.toUserName + '\'' + ", fromUserName='" + this.fTJ + '\'' + ", fromUserImgUrl='" + this.kdX + '\'' + ", fromUserContent='" + this.kdY + '\'' + ", fromUserContentPicUrl='" + this.kdZ + '\'' + ", fromUserContentVideoUrl='" + this.kea + '\'' + ", fromUserContentThumbPicUrl='" + this.keb + '\'' + ", picAESKey='" + this.kec + '\'' + ", videoAESKey='" + this.ked + '\'' + ", thumbVideoAESKey='" + this.kee + '\'' + ", cardBackgroundPicUrl='" + this.kef + '\'' + ", cardLogoLUrl='" + this.keg + '\'' + ", cardTitle='" + this.keh + '\'' + ", cardPrice='" + this.kei + '\'' + ", footerWording='" + this.kej + '\'' + ", color='" + this.hib + '\'' + ", needJump=" + this.kek + ", picDataLength=" + this.kel + ", videoDataLength=" + this.kem + ", thumbDataLength=" + this.ken + ", descTitle='" + this.keo + '\'' + ", descIconUrl='" + this.kep + '\'' + ", descLayoutMode=" + this.keq + ", giftingMediaTitle='" + this.ker + '\'' + ", descriptionTitleColor='" + this.kes + '\'' + ", cardTitleColor='" + this.ket + '\'' + ", cardPriceTitleColor='" + this.keu + '\'' + ", userCardId='" + this.kev + '\'' + ", operationTitle='" + this.kew + '\'' + ", operationUrl='" + this.kex + '\'' + ", cardTpId='" + this.kez + '\'' + ", cardCode='" + this.keA + '\'' + ", accepted_card_list_size='" + this.keB.size() + '\'' + ", accepter_list_size='" + this.keC.size() + '\'' + ", accepter_list_title='" + this.keD + '\'' + ", out_of_card='" + this.keE + '\'' + ", operation_wxa_username='" + this.keF + '\'' + ", operation_wxa_path='" + this.keG + '\'' + '}';
    }

    public static CardGiftInfo a(am amVar) {
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = amVar.tcX;
        cardGiftInfo.fTJ = amVar.tcY;
        cardGiftInfo.kdX = amVar.tcZ;
        cardGiftInfo.kdY = amVar.content;
        cardGiftInfo.kdZ = amVar.tda;
        cardGiftInfo.kea = amVar.tdb;
        cardGiftInfo.keb = amVar.tdc;
        cardGiftInfo.kec = amVar.tdd;
        cardGiftInfo.kee = amVar.tdf;
        cardGiftInfo.ked = amVar.tde;
        cardGiftInfo.kef = amVar.tdg;
        cardGiftInfo.keg = amVar.tdh;
        cardGiftInfo.keh = amVar.keH;
        cardGiftInfo.kei = amVar.keI;
        cardGiftInfo.kej = amVar.tdi;
        cardGiftInfo.hib = amVar.hib;
        cardGiftInfo.kek = amVar.tdj;
        cardGiftInfo.kel = amVar.tdk;
        cardGiftInfo.kem = amVar.tdl;
        cardGiftInfo.ken = amVar.tdm;
        cardGiftInfo.keo = amVar.tdn;
        cardGiftInfo.kep = amVar.tdo;
        cardGiftInfo.keq = amVar.tdp;
        cardGiftInfo.ker = amVar.tdq;
        cardGiftInfo.kes = amVar.tdr;
        cardGiftInfo.ket = amVar.tds;
        cardGiftInfo.keu = amVar.tdt;
        cardGiftInfo.kev = amVar.tdu;
        cardGiftInfo.kew = amVar.tdv;
        cardGiftInfo.kex = amVar.tdw;
        cardGiftInfo.kez = amVar.kdE;
        cardGiftInfo.keA = amVar.tdx;
        Iterator it = amVar.keB.iterator();
        while (it.hasNext()) {
            an anVar = (an) it.next();
            LinkedList linkedList = cardGiftInfo.keB;
            AcceptedCardItem acceptedCardItem = new AcceptedCardItem();
            acceptedCardItem.keI = anVar.keI;
            acceptedCardItem.keH = anVar.keH;
            linkedList.add(acceptedCardItem);
        }
        it = amVar.keC.iterator();
        while (it.hasNext()) {
            ao aoVar = (ao) it.next();
            linkedList = cardGiftInfo.keC;
            AccepterItem accepterItem = new AccepterItem();
            accepterItem.keI = aoVar.keI;
            accepterItem.keH = aoVar.keH;
            accepterItem.keK = aoVar.keK;
            accepterItem.keJ = aoVar.keJ;
            linkedList.add(accepterItem);
        }
        cardGiftInfo.keD = amVar.keD;
        cardGiftInfo.keE = amVar.keE;
        cardGiftInfo.keF = amVar.keF;
        cardGiftInfo.keG = amVar.keG;
        return cardGiftInfo;
    }

    public static CardGiftInfo a(wb wbVar) {
        CardGiftInfo cardGiftInfo = new CardGiftInfo();
        cardGiftInfo.toUserName = wbVar.tcX;
        cardGiftInfo.fTJ = wbVar.tcY;
        cardGiftInfo.kdX = wbVar.tcZ;
        cardGiftInfo.kdY = wbVar.content;
        cardGiftInfo.kdZ = wbVar.tda;
        cardGiftInfo.kea = wbVar.tdb;
        cardGiftInfo.keb = wbVar.tdc;
        cardGiftInfo.kec = wbVar.tdd;
        cardGiftInfo.kee = wbVar.tdf;
        cardGiftInfo.ked = wbVar.tde;
        cardGiftInfo.kef = wbVar.tdg;
        cardGiftInfo.keg = wbVar.tdh;
        cardGiftInfo.keh = wbVar.keH;
        cardGiftInfo.kei = wbVar.keI;
        cardGiftInfo.kej = wbVar.tdi;
        cardGiftInfo.hib = wbVar.hib;
        cardGiftInfo.kek = wbVar.tdj;
        cardGiftInfo.kel = wbVar.tdk;
        cardGiftInfo.kem = wbVar.tdl;
        cardGiftInfo.ken = wbVar.tdm;
        cardGiftInfo.keo = wbVar.tdn;
        cardGiftInfo.kep = wbVar.tdo;
        cardGiftInfo.keq = wbVar.tdp;
        cardGiftInfo.ker = wbVar.tdq;
        cardGiftInfo.kes = wbVar.tdr;
        cardGiftInfo.ket = wbVar.tds;
        cardGiftInfo.keu = wbVar.tdt;
        cardGiftInfo.kev = wbVar.tdu;
        cardGiftInfo.kew = wbVar.tdv;
        cardGiftInfo.kex = wbVar.tdw;
        cardGiftInfo.kez = wbVar.kdE;
        cardGiftInfo.keA = wbVar.tdx;
        return cardGiftInfo;
    }
}
