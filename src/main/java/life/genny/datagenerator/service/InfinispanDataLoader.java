package life.genny.datagenerator.service;

import io.quarkus.arc.Priority;
import io.quarkus.runtime.Startup;
import io.quarkus.runtime.StartupEvent;
import life.genny.datagenerator.data.schemas.BaseEntity;
import life.genny.datagenerator.data.schemas.MessageEntity;
import life.genny.datagenerator.data.schemas.MessageKey;
import life.genny.datagenerator.utils.PersonGenerator;
import org.jboss.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import java.util.HashMap;

@ApplicationScoped
public class InfinispanDataLoader {

    private static final Logger LOGGER = Logger.getLogger(InfinispanDataLoader.class);

//    void onDataLoad(@Observes StartupEvent event) {
//        LOGGER.debug("onDataLoad");
//        HashMap<MessageKey, MessageEntity> data = generateFakeData();
//    }
//
//    private HashMap<MessageKey, MessageEntity> generateFakeData() {
//        BaseEntity be = PersonGenerator.generate();
//        LOGGER.info(be);
//        return null;
//    }

}
