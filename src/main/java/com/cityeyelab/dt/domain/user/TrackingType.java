package com.cityeyelab.dt.domain.user;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TrackingType {

    USER001("USER_LOGIN", "로그인"),

    FAC001("FACILITY_ADD", "신규입력"),
    FAC002("FACILITY_UPDATE", "정보수정"),
    FAC003("FACILITY_MOVE", "위치이동"),
    FAC004("FACILITY_DELETE", "삭제"),

    TRACK001("TRACK_ADD", "신규입력"),
    TRACK002("TRACK_UPDATE", "정보수정"),
    TRACK003("TRACK_MOVE", "위치이동"),
    TRACK004("TRACK_DELTE", "삭제"),

    NMS000("NMS", "ERROR"),
    NMS001("NMS", "FIX");

    private final String key;
    private final String content;
}
