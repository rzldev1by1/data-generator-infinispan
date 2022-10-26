package life.genny.datagenerator.data.marshaller;

import life.genny.datagenerator.data.schemas.BaseEntityAttributeKey;
import org.infinispan.protostream.MessageMarshaller;

import java.io.IOException;

public class BaseEntityAttributeKeyMarshaller implements MessageMarshaller<BaseEntityAttributeKey> {
    @Override
    public BaseEntityAttributeKey readFrom(ProtoStreamReader reader) throws IOException {
        String attributeCode = reader.readString("attributeCode");
        String baseEntityCode = reader.readString("baseEntityCode");
        String productCode = reader.readString("realm");
        Long attributeId = reader.readLong("ATTRIBUTE_ID");
        Long baseEntityId = reader.readLong("BASEENTITY_ID");
        return new BaseEntityAttributeKey(productCode, baseEntityCode, attributeCode, attributeId, baseEntityId);
    }

    @Override
    public void writeTo(ProtoStreamWriter writer, BaseEntityAttributeKey beak) throws IOException {
        writer.writeString("attributeCode", beak.getAttributeCode());
        writer.writeString("baseEntityCode", beak.getBaseEntityCode());
        writer.writeString("realm", beak.getRealm());
        writer.writeLong("ATTRIBUTE_ID", beak.getATTRIBUTE_ID());
        writer.writeLong("BASEENTITY_ID", beak.getBASEENTITY_ID());
    }

    @Override
    public Class<? extends BaseEntityAttributeKey> getJavaClass() {
        return BaseEntityAttributeKey.class;
    }

    @Override
    public String getTypeName() {
        return "genny." + getJavaClass().getSimpleName();
    }
}
