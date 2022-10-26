package life.genny.datagenerator.data.schemas;

import java.io.Serializable;

public interface MessageKey extends Serializable {
    public String getKeyString();

    public MessageKey fromKey(String key);

    public String getDelimiter();

    public default String[] getComponents() {
        return getKeyString().split(getDelimiter());
    }

    public String getEntityCode();
}
