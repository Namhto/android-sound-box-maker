package com.maxtho.soundboxmaker.exception;

/**
 * Created by Othman on 21/04/2018.
 */

public class SBMException extends RuntimeException {

    private ExceptionCode code;

    public SBMException(ExceptionCode code) {
        super(code.toString());
        this.code = code;
    }

    public ExceptionCode getCode() {
        return code;
    }
}
