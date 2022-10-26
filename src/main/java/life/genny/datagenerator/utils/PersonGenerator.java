package life.genny.datagenerator.utils;
import life.genny.datagenerator.AttributeCode;
import life.genny.datagenerator.data.schemas.BaseEntity;
import life.genny.datagenerator.data.schemas.BaseEntityAttribute;
import org.jboss.logging.Logger;

import java.time.LocalDateTime;

public final class PersonGenerator {

    private static final Logger LOGGER = Logger.getLogger(PersonGenerator.class.getSimpleName());

    private static final GeneratorUtils generator = new GeneratorUtils();

    private static BaseEntity createPersonEntity() {
        BaseEntity entity = new BaseEntity();
        entity.setStatus(1);
        entity.setName(generator.generateFirstName() + " " + generator.generateLastName());
        entity.setCode(AttributeCode.ENTITY_CODE.DEF_PERSON.toString());
        entity.setCreated(LocalDateTime.now());
        entity.setUpdated(LocalDateTime.now());
        return entity;
    }

    private static BaseEntityAttribute createAttribute(AttributeCode.DEF_PERSON attributeCode, Object value) {
        BaseEntityAttribute attribute = new BaseEntityAttribute();
        attribute.setAttributeCode(attributeCode.toString());
        attribute.setInferred(GeneratorUtils.DEFAULT_INFERRED);
        attribute.setPrivacyFlag(GeneratorUtils.DEFAULT_PRIVACY_FLAG);
        attribute.setReadOnly(GeneratorUtils.DEFAULT_READ_ONLY);
        attribute.setRealm(GeneratorUtils.DEFAULT_REALM);
        attribute.setCreated(LocalDateTime.now());
        attribute.setUpdated(LocalDateTime.now());
        try {
            attribute.setValue(value);
        } catch (Exception e) {
            LOGGER.error(e);
        }
        return attribute;
    }

    public static BaseEntity generate() {
        BaseEntity entity = PersonGenerator.createPersonEntity();

            try {
                String[] name = entity.getName().split(" ");
                String firstName = name[0];
                String lastName = name[1];

                String gender = generator.generateGender();

                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_FIRSTNAME,
                        firstName
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_LASTNAME,
                        lastName
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_INITIALS,
                        firstName.substring(0, 1).toUpperCase() + lastName.substring(0, 1).toUpperCase()
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_DOB,
                        generator.generateDOB()
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_EMAIL,
                        generator.generateEmail(firstName, lastName).toString()
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_LINKEDIN_URL,
                        generator.generateLinkedInURL(firstName, lastName)
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_PHONE_NUMBER,
                        generator.generatePhoneNumber()
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_LNK_SEND_EMAIL,
                        true
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_LNK_GENDER_SELECT,
                        "[\"SEL_" + gender + "\"]"
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_GENDER,
                        gender
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.ATT_PRI_PROCESS_ID,
                        generator.generateUUID()
                ));
                entity.addAttribute(createAttribute(
                        AttributeCode.DEF_PERSON.PRI_PREFIX,
                        "PER_"
                ));

            } catch (Exception e) {
                LOGGER.error(e);
            }

        return entity;
    }
}
