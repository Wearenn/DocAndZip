package fr.univ.lorraine.ufr.mim.m2.gi.docandzip.dtos;

public class TypeDto {

    private Long typeId;
    private String type;

    public TypeDto() {}

    public TypeDto(Long typeId, String type) {
        this.typeId = typeId;
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
