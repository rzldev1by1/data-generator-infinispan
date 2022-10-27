package life.genny.datagenerator.data.schemas;

import life.genny.datagenerator.AttributeCode;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BaseEntity implements MessageEntity {

    private String dType = "BaseEntity";
    private Long id;
    private LocalDateTime created;
    private String name;
    private String realm = "Genny";
    private LocalDateTime updated;
    private String code;
    private Integer status;
    private List<BaseEntityAttribute> attributes;

    public BaseEntity() {
        attributes = new ArrayList<>();
    }

    public BaseEntity(String dType, Long id, Long createdLong, String name, String realm, Long updatedLong, String code, int status) {
        this.dType = dType;
        this.id = id;
        this.created = LocalDateTime.ofEpochSecond(createdLong / 1000, 0, ZoneOffset.UTC);
        this.name = name;
        this.realm = realm;
        this.updated = LocalDateTime.ofEpochSecond(updatedLong / 1000, 0, ZoneOffset.UTC);
        this.code = code;
        this.status = status;
        attributes = new ArrayList<>();
    }

    public BaseEntity(String dType, LocalDateTime created, String name, String realm, LocalDateTime updated, String code, Integer status) {
        this.dType = dType;
        this.created = created;
        this.name = name;
        this.realm = realm;
        this.updated = updated;
        this.code = code;
        this.status = status;
        attributes = new ArrayList<>();
    }

    public String getdType() {
        return dType;
    }

    public void setdType(String dType) {
        this.dType = dType;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealm() {
        return realm;
    }

    public void setRealm(String realm) {
        this.realm = realm;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setCode(AttributeCode.ENTITY_CODE code) {
        this.setCode(code, UUID.randomUUID().toString());
    }

    public void setCode(AttributeCode.ENTITY_CODE code, String uuid) {
        String prefix = "";
        prefix = switch (code) {
            case DEF_ADDRESS -> "ADD_";
            case DEF_AGENCY -> "AGE_";
            case DEF_AGENT -> "AGN_";
            case DEF_APPLICATION -> "APP_";
            case DEF_COMPANY -> "COM_";
            case DEF_CONTACT -> "CON_";
            case DEF_EDU_PRO_REP -> "EDR_";
            case DEF_EDU_PROVIDER -> "EDP_";
            case DEF_HOST_CPY -> "HCP_";
            case DEF_HOST_CPY_REP -> "HCR_";
            case DEF_INTERN -> "NTRN_";
            case DEF_INTERNSHIP -> "NTRS_";
            case DEF_ORGANISATION -> "ORG_";
            case DEF_PERSON -> "PER_";
            case DEF_SUPERVISOR -> "SPV_";
            case DEF_USER -> "USR_";
            default -> "UNKW_";
        };

        this.code = prefix + uuid.toUpperCase();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public void addAttribute(BaseEntityAttribute attribute) {
        attribute.setBaseEntityCode(this.getCode());
        attributes.add(attribute);
    }

    public List<BaseEntityAttribute> getAttributes() {
        return this.attributes;
    }

    @Override
    public MessageKey getMessageKey() {
        return new BaseEntityKey(getRealm(), getCode());
//        return new BaseEntityKey();
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "dType='" + dType + '\'' +
                ", id=" + id +
                ", created=" + created +
                ", name='" + name + '\'' +
                ", realm='" + realm + '\'' +
                ", updated=" + updated +
                ", code='" + code + '\'' +
                ", status=" + status +
                ", attributes=" + attributes.size() +
                '}';
    }
}
