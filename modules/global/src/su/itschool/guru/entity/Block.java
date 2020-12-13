package su.itschool.guru.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "GURU_BLOCK")
@Entity(name = "guru_Block")
@NamePattern("%s|blockName")
public class Block extends StandardEntity {
    private static final long serialVersionUID = 2342267145866925916L;

    @NotNull
    @Column(name = "BLOCK_NAME", nullable = false)
    private String blockName;

    @Column(name = "BLOCK_GEO_POINT")
    private String blockGeoPoint;

    @Column(name = "BLOCK_ADDRESS")
    private String blockAddress;

    public String getBlockGeoPoint() {
        return blockGeoPoint;
    }

    public void setBlockGeoPoint(String blockGeoPoint) {
        this.blockGeoPoint = blockGeoPoint;
    }

    public String getBlockAddress() {
        return blockAddress;
    }

    public void setBlockAddress(String blockAddress) {
        this.blockAddress = blockAddress;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }
}