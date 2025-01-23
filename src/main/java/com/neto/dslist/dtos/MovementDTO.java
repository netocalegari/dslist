package com.neto.dslist.dtos;

public class MovementDTO {
    private Integer sourceIndex;
    private Integer targetIndex;

    public MovementDTO() {
    }

    public Integer getSourceIndex() {
        return sourceIndex;
    }

    public void setSourceIndex(Integer sourceIndex) {
        this.sourceIndex = sourceIndex;
    }

    public Integer getTargetIndex() {
        return targetIndex;
    }

    public void setTargetIndex(Integer targetIndex) {
        this.targetIndex = targetIndex;
    }
}
