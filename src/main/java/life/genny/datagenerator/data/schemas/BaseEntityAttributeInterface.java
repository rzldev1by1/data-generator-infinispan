package life.genny.datagenerator.data.schemas;

public sealed interface BaseEntityAttributeInterface permits BaseEntityAttribute {

    public Object getValue();

    public void setValue(Object value) throws IllegalArgumentException;

}
